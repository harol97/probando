package com.harol.users.application;

import com.harol.users.domain.model.User;
import com.harol.users.domain.ports.in.GetUserUseCase;
import com.harol.users.domain.ports.out.UserRepository;

import reactor.core.publisher.Mono;

public record GetUserUseCaseImpl(
        UserRepository userRepository
        ) implements GetUserUseCase {
    @Override
    public Mono<User> getById(Long id) {
        return userRepository
                .getById(id);
    }
}