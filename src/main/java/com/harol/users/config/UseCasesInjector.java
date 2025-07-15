package com.harol.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.harol.users.application.DeleteUserUseCaseImpl;
import com.harol.users.application.GetAllUsersUseCaseImpl;
import com.harol.users.application.GetUserUseCaseImpl;
import com.harol.users.application.SaveUserUseCaseImpl;
import com.harol.users.domain.ports.in.DeleteUserUseCase;
import com.harol.users.domain.ports.in.GetAllUsersUseCase;
import com.harol.users.domain.ports.in.GetUserUseCase;
import com.harol.users.domain.ports.in.SaveUserUseCase;
import com.harol.users.domain.ports.out.UserRepository;

/*
 * This clases have all beans of application
 * inject manually
 */
@Configuration
public class UseCasesInjector {
    @Bean
    GetUserUseCase injectGetUserUseCase(UserRepository userRepository) {
        return new GetUserUseCaseImpl(userRepository);
    }

    @Bean
    SaveUserUseCase injectSaveUserUseCase(UserRepository userRepository) {
        return new SaveUserUseCaseImpl(userRepository);
    }

    @Bean
    DeleteUserUseCase injectDeleteUserUseCase(UserRepository userRepository) {
        return new DeleteUserUseCaseImpl(userRepository);
    }

    @Bean
    GetAllUsersUseCase injectGetAllUsersUseCase(UserRepository userRepository){
        return new GetAllUsersUseCaseImpl(userRepository);
    }
}