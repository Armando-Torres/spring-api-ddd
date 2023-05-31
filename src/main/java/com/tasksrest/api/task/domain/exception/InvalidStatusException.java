package com.tasksrest.api.task.domain.exception;

public class InvalidStatusException extends RuntimeException{
    
    public InvalidStatusException(String message) {
        super(message);
    }
}
