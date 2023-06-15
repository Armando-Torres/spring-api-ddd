package com.tasksrest.api.kanban.domain.exception;

public class NotFoundColumnException extends RuntimeException{
    
    public NotFoundColumnException(String message) {
        super(message);
    }
}
