package com.harol.users.domain.ports.in;

import com.harol.users.domain.model.User;

import reactor.core.publisher.Flux;

public interface GetAllUsersUseCase {

    Flux<User> getAllUsers();

}
