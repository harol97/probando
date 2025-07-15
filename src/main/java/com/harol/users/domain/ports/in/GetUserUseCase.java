package com.harol.users.domain.ports.in;

import com.harol.users.domain.model.User;

import reactor.core.publisher.Mono;

public interface GetUserUseCase {
    Mono<User> getById(Long id);
}