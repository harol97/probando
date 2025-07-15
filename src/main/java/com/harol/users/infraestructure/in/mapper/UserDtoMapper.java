package com.harol.users.infraestructure.in.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.harol.users.domain.model.User;
import com.harol.users.infraestructure.in.dtos.UserDTO;
import com.harol.users.infraestructure.in.dtos.UserInDTO;
import com.harol.users.infraestructure.in.dtos.UserPatchDTO;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    UserDTO userToUserDto(User user);

    @Mapping(target = "id", ignore = true)
    User userInDtoToUser(UserInDTO userInDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateUserFromUserPatchDto(UserPatchDTO userPatchDTO, @MappingTarget User user);
}
