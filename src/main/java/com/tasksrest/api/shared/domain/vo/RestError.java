package com.tasksrest.api.shared.domain.vo;

public class RestError {
    private String cause;
    private Boolean error = true;

    public RestError(String cause){
        this.cause = cause;
    }

    public String getCause() {
        return this.cause;
    }

    public Boolean getError() {
        return this.error;
    }
}
