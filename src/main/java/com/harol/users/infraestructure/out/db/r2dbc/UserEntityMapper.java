package com.harol.users.infraestructure.out.db.r2dbc;

import org.mapstruct.Mapper;

import com.harol.users.domain.model.User;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    User userEntityToUser(UserEntity userEntity);
    UserEntity userToUserEntity(User user);
}
