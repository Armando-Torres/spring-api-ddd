package com.tasksrest.api.kanban.domain.exception;

public class DuplicateColumnException extends RuntimeException{
    
    public DuplicateColumnException(String message) {
        super(message);
    }
}
