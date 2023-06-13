package com.tasksrest.api.shared.domain.vo;

import com.tasksrest.api.shared.domain.exception.InvalidStatusException;

public class TaskStatus {
    public enum STATUS {
        OPEN,
        ASSIGNED,
        INPROCESS,
        REVIEW,
        DONE
    }

    private String status;

    public TaskStatus(String status) {
        this.validateStatus(status);

        this.status = STATUS.valueOf(status).toString();
    }

    public String getValue() {
        return this.status;
    }    

    private void validateStatus(String status) {
        try {
            STATUS.valueOf(status);

        } catch (IllegalArgumentException e) {
            throw new InvalidStatusException(String.format("Status %s are invalid", status));
        }
    }
}
