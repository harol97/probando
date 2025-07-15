package com.harol.users.domain.ports.in;

import com.harol.users.domain.model.User;

import reactor.core.publisher.Mono;

public interface DeleteUserUseCase {
    Mono<Void> delete(User user);
}
