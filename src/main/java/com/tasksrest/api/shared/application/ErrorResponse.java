package com.tasksrest.api.shared.application;

import com.tasksrest.api.shared.domain.Error;

public class ErrorResponse {

    public Error invoke(String cause) {
        return new Error(cause);
    }
}
