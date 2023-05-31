package com.tasksrest.api.shared.infrastructure.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tasksrest.api.shared.application.ErrorResponse;
import com.tasksrest.api.shared.domain.Error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

    private final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
    
    @ExceptionHandler
    protected ResponseEntity<Object> handleConflict(Exception e, WebRequest request) {
        Error errorResponse = (new ErrorResponse()).invoke(e.getMessage());

        this.logger.warn(String.format("%s", errorResponse.getCause()));
        
        return handleExceptionInternal(e, errorResponse, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
    }
}
