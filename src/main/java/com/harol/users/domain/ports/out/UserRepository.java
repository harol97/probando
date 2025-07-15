package com.harol.users.domain.ports.out;

import com.harol.users.domain.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> getById(Long id);

    Mono<Void> save(User user);

    Mono<Void> delete(User user);

    Flux<User> getAllUsers();
}
