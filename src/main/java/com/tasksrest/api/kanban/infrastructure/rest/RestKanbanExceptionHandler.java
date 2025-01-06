package com.tasksrest.api.kanban.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tasksrest.api.kanban.domain.exception.DuplicateColumnException;
import com.tasksrest.api.kanban.domain.exception.DuplicateKanbanException;
import com.tasksrest.api.kanban.domain.exception.NotFoundColumnException;
import com.tasksrest.api.kanban.domain.exception.NotFoundKanbanException;
import com.tasksrest.api.shared.domain.vo.RestError;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class RestKanbanExceptionHandler extends ResponseEntityExceptionHandler{

    private final Logger loggerInstance = LoggerFactory.getLogger(RestKanbanExceptionHandler.class);

    @ExceptionHandler({DuplicateColumnException.class})
    protected ResponseEntity<Object> handleDuplicateColumnException(DuplicateColumnException e) {
        this.logException(HttpStatus.CONFLICT.value(), e.getMessage());
        
        return this.resposeException(HttpStatus.CONFLICT, e.getMessage());
    }

    @ExceptionHandler({DuplicateKanbanException.class})
    protected ResponseEntity<Object> handleDuplicateKanbanException(DuplicateKanbanException e) {
        this.logException(HttpStatus.CONFLICT.value(), e.getMessage());
        
        return this.resposeException(HttpStatus.CONFLICT, e.getMessage());
    }

    @ExceptionHandler({NotFoundColumnException.class})
    protected ResponseEntity<Object> handleNotFoundColumnException(NotFoundColumnException e) {
        this.logException(HttpStatus.NOT_FOUND.value(), e.getMessage());
        
        return this.resposeException(HttpStatus.NOT_FOUND, e.getMessage());
    }   
    
    @ExceptionHandler({NotFoundKanbanException.class})
    protected ResponseEntity<Object> handleNotFoundKanbanException(NotFoundKanbanException e) {
        this.logException(HttpStatus.NOT_FOUND.value(), e.getMessage());
        
        return this.resposeException(HttpStatus.NOT_FOUND, e.getMessage());
    }

    private void logException(Integer code, String cause) {
        this.loggerInstance.warn("{} {}", code, cause);
    }

    private ResponseEntity<Object> resposeException(HttpStatus status, String cause) {
        return ResponseEntity.status(status).body(new RestError(cause));
    }
}
