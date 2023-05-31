package com.tasksrest.api.task.domain.exception;

public class DuplicateTaskException extends RuntimeException{
    
    public DuplicateTaskException(String message) {
        super(message);
    }
}
