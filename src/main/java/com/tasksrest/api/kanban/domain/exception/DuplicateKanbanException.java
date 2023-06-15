package com.tasksrest.api.kanban.domain.exception;

public class DuplicateKanbanException extends RuntimeException{
    
    public DuplicateKanbanException(String message) {
        super(message);
    }
}
