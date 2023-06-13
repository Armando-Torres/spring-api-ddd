package com.tasksrest.api.shared.domain.exception;

public class UpdateEmptyException extends RuntimeException{
    
    public UpdateEmptyException(String message) {
        super(message);
    }
}
