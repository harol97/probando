package com.harol.users.infraestructure.out.db.r2dbc;

import org.springframework.stereotype.Repository;

import com.harol.users.domain.model.User;
import com.harol.users.domain.ports.out.UserRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class UserReactiveRepository implements UserRepository {

    private UserR2dbcRepository userR2dbcRepository;
    private UserEntityMapper userEntityMapper;

    @Override
    public Mono<Void> delete(User user) {
        return userR2dbcRepository
                .delete(userEntityMapper.userToUserEntity(user));
    }

    @Override
    public Flux<User> getAllUsers() {
        return userR2dbcRepository
        .findAll()
        .map(userEntityMapper::userEntityToUser);
    }

    @Override
    public Mono<User> getById(Long id) {
        return userR2dbcRepository
                .findById(id)
                .map(userEntityMapper::userEntityToUser);
    }

    /* TODO review it , It's failed on update */
    @Override
    public Mono<Void> save(User user) {
        return userR2dbcRepository
                .save(userEntityMapper.userToUserEntity(user))
                .then();
    }

}
