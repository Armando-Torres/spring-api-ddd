package com.tasksrest.api.shared.domain.exception;

public class InvalidStatusException extends RuntimeException{
    
    public InvalidStatusException(String message) {
        super(message);
    }
}
