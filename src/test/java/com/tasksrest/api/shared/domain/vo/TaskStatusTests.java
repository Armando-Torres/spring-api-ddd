package com.tasksrest.api.shared.domain.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.tasksrest.api.shared.domain.exception.InvalidStatusException;

public class TaskStatusTests {

    @Test
    void createStatusThrowExceptionWhenAreInvalid() {
        assertThrows(InvalidStatusException.class, () -> {
            new TaskStatus("FINISHED");
        });
    }
    
    @Test
    void createStatusThrowExceptionInLowerCase() {
        assertThrows(InvalidStatusException.class, () -> {
            new TaskStatus("open");
        });
    }

    @Test
    void createStatusThrowExceptionInPascalCase() {
        assertThrows(InvalidStatusException.class, () -> {
            new TaskStatus("Open");
        });
    }

    @Test
    void createStatusIsOkInUpperCase() {
        TaskStatus status = new TaskStatus("REVIEW");

        assertEquals("REVIEW", status.getValue());
    }
}
