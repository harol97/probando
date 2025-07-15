package com.harol.users.infraestructure.in.impl;

import org.springframework.web.bind.annotation.RestController;

import com.harol.users.domain.model.User;
import com.harol.users.domain.ports.in.DeleteUserUseCase;
import com.harol.users.domain.ports.in.GetAllUsersUseCase;
import com.harol.users.domain.ports.in.GetUserUseCase;
import com.harol.users.domain.ports.in.SaveUserUseCase;
import com.harol.users.infraestructure.in.UserController;
import com.harol.users.infraestructure.in.dtos.UserDTO;
import com.harol.users.infraestructure.in.dtos.UserInDTO;
import com.harol.users.infraestructure.in.dtos.UserPatchDTO;
import com.harol.users.infraestructure.in.mapper.UserDtoMapper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController {

    private GetUserUseCase getUserUseCase;
    private SaveUserUseCase saveUserUseCase;
    private DeleteUserUseCase deleteUserUseCase;
    private UserDtoMapper userMapper;
    private GetAllUsersUseCase getAllUsersUseCase;

    @Override
    public Mono<UserDTO> getById(Long id) {
        return getUserUseCase
                .getById(id)
                .map(userMapper::userToUserDto);
    }

    @Override
    public Mono<Void> create(@Valid UserInDTO userInDTO) {
        User user = userMapper.userInDtoToUser(userInDTO);
        return saveUserUseCase
                .save(user);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return getUserUseCase
                .getById(id) // obtenemos el user
                .flatMap(user -> deleteUserUseCase
                        .delete(user));
    }

    @Override
    public Mono<Void> update(Long id, @Valid UserPatchDTO userPatchDTO) {
        return getUserUseCase
                .getById(id) // obtener el usuario
                .flatMap(user -> {
                    userMapper.updateUserFromUserPatchDto(userPatchDTO, user); // actualizar el objeto que teniamos con
                                                                               // la nueva data
                    return saveUserUseCase.save(user); // actualizar en la base de datos
                });
    }

    @Override
    public Flux<UserDTO> getAll() {
        return getAllUsersUseCase
                .getAllUsers()
                .map(userMapper::userToUserDto);
    }
}