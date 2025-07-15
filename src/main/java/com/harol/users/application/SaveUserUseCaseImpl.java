package com.harol.users.application;

import com.harol.users.domain.model.User;
import com.harol.users.domain.ports.in.SaveUserUseCase;
import com.harol.users.domain.ports.out.UserRepository;

import reactor.core.publisher.Mono;

public record SaveUserUseCaseImpl(UserRepository userRepository) implements SaveUserUseCase {

    @Override
    public Mono<Void> save(User user) {
        return userRepository.save(user);
    }

}
