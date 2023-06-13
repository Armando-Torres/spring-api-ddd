package com.tasksrest.api.shared.domain.exception;

public class NotFoundTaskException extends RuntimeException{
    
    public NotFoundTaskException(String message) {
        super(message);
    }
}
