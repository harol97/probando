package com.harol.users.application;

import com.harol.users.domain.model.User;
import com.harol.users.domain.ports.in.DeleteUserUseCase;
import com.harol.users.domain.ports.out.UserRepository;

import reactor.core.publisher.Mono;

public record DeleteUserUseCaseImpl(UserRepository userRepository) implements DeleteUserUseCase {

    @Override
    public Mono<Void> delete(User user) {
        return userRepository.delete(user);
    }
}
