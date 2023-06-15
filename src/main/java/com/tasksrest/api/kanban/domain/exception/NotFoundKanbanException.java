package com.tasksrest.api.kanban.domain.exception;

public class NotFoundKanbanException extends RuntimeException{
    
    public NotFoundKanbanException(String message) {
        super(message);
    }
}
