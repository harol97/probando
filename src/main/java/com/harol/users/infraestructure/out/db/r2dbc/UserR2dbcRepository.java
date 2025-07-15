package com.harol.users.infraestructure.out.db.r2dbc;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserR2dbcRepository extends ReactiveCrudRepository<UserEntity, Long> {
}