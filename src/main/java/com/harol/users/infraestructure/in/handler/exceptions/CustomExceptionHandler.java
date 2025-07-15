package com.harol.users.infraestructure.in.handler.exceptions;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.harol.users.exceptions.NotFoundException;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public Map<String, String> notFoundHandle(NotFoundException exception) {
        // si fuera void dejariamos un log de la excepcion
        return Map.of("error", exception.getMessage());
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> handleConstraintValidationErrors() {
        return Map.of("error", "custom validation error");
    }
}