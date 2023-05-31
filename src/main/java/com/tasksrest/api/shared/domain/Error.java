package com.tasksrest.api.shared.domain;

public class Error {
    private String cause;
    private Boolean error;

    public Error(String cause){
        this.cause = cause;
        this.error = true;
    }

    public String getCause() {
        return this.cause;
    }

    public Boolean getError() {
        return this.error;
    }
}
