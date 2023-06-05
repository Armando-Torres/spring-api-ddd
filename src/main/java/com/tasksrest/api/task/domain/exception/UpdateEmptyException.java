package com.tasksrest.api.task.domain.exception;

public class UpdateEmptyException extends RuntimeException{
    
    public UpdateEmptyException(String message) {
        super(message);
    }
}
