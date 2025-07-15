package com.harol.users.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }


    public NotFoundException() {
        super("Resource is not exist");
    }

}
