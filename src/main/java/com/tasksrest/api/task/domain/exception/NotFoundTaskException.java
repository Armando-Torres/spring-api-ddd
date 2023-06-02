package com.tasksrest.api.task.domain.exception;

public class NotFoundTaskException extends RuntimeException{
    
    public NotFoundTaskException(String message) {
        super(message);
    }
}
