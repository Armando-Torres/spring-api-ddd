package com.tasksrest.api.shared.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tasksrest.api.shared.domain.vo.RestError;
import com.tasksrest.api.task.domain.exception.DuplicateTaskException;
import com.tasksrest.api.task.domain.exception.InvalidStatusException;
import com.tasksrest.api.task.domain.exception.NotFoundTaskException;
import com.tasksrest.api.task.domain.exception.UpdateEmptyException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

    private final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler({DuplicateTaskException.class})
    protected ResponseEntity<Object> handleDuplicateTaskException(DuplicateTaskException e) {
        this.logException(HttpStatus.CONFLICT.value(), e.getMessage());
        
        return this.resposeException(HttpStatus.CONFLICT, e.getMessage());
    }

    @ExceptionHandler({NotFoundTaskException.class})
    protected ResponseEntity<Object> handleNotFoundTaskException(NotFoundTaskException e) {
        this.logException(HttpStatus.NOT_FOUND.value(), e.getMessage());
        
        return this.resposeException(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler({InvalidStatusException.class})
    protected ResponseEntity<Object> handleInvalidStatusException(InvalidStatusException e) {
        this.logException(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage());

        return this.resposeException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
    }

    @ExceptionHandler({UpdateEmptyException.class})
    protected ResponseEntity<Object> handleUpdateEmptyException(UpdateEmptyException e) {
        this.logException(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage());

        return this.resposeException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
    }
    

    private void logException(Integer code, String cause) {
        this.logger.warn(String.format("%d %s", code, cause));
    }

    private ResponseEntity<Object> resposeException(HttpStatus status, String cause) {
        return ResponseEntity.status(status).body(new RestError(cause));
    }
}
