package com.harol.users.infraestructure.in;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.harol.users.infraestructure.in.dtos.UserDTO;
import com.harol.users.infraestructure.in.dtos.UserInDTO;
import com.harol.users.infraestructure.in.dtos.UserPatchDTO;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/users")
@Validated
public interface UserController {


    @GetMapping("/{id}")
    Mono<UserDTO> getById(@PathVariable Long id);

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Mono<Void> create(@Valid @RequestBody UserInDTO userInDTO);

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    Mono<Void> delete(@PathVariable Long id);

    @PatchMapping("/{id}")
    Mono<Void> update(@PathVariable Long id, @Valid @RequestBody UserPatchDTO userPatchDTO);

    @GetMapping("")
    Flux<UserDTO> getAll();

}