package com.harol.users.application;

import com.harol.users.domain.model.User;
import com.harol.users.domain.ports.in.GetAllUsersUseCase;
import com.harol.users.domain.ports.out.UserRepository;

import reactor.core.publisher.Flux;

public record GetAllUsersUseCaseImpl(UserRepository userRepository) implements GetAllUsersUseCase{

    @Override
    public Flux<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

}
