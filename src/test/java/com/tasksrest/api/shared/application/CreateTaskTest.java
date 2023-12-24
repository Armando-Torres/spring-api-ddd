package com.tasksrest.api.shared.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import com.tasksrest.api.shared.application.service.CreateTaskRequest;
import com.tasksrest.api.shared.application.service.TaskResponse;
import com.tasksrest.api.shared.domain.Task;
import com.tasksrest.api.shared.domain.TaskHolder;
import com.tasksrest.api.shared.domain.TaskHolderRepository;
import com.tasksrest.api.shared.domain.TaskRepository;
import com.tasksrest.api.shared.domain.exception.NotFoundHolderException;

public class CreateTaskTest {
    private TaskRepository taskRepository;
    private TaskHolderRepository taskHolderRepository;

    private CreateTaskRequest request;

    @BeforeEach
    void setUp() {
        taskRepository = Mockito.mock(TaskRepository.class);
        taskHolderRepository = Mockito.mock(TaskHolderRepository.class);
        request = Mockito.mock(CreateTaskRequest.class);
    }

    @Test
    void requestWihoutHolderShouldThrowException() {
        Mockito.when(request.getTaskHolderId()).thenReturn(null);

        CreateTask useCase = new CreateTask(taskRepository, taskHolderRepository);

        assertThrows(NotFoundHolderException.class, () -> {
            useCase.invoke(this.request);
        });
    }

    @Test
    void holderNotFoundOnRepositoryShouldThrowException() {
        Mockito.when(request.getTaskHolderId()).thenReturn(2);
        Mockito.doReturn(null).when(taskRepository).findById(2);

        CreateTask useCase = new CreateTask(taskRepository, taskHolderRepository);

        assertThrows(NotFoundHolderException.class, () -> {
            useCase.invoke(this.request);

            verify(taskRepository, never()).save(mock(Task.class));
        });
    }

    @Test
    void taskWithAllArgumentsShouldCreateTask() {
        TaskHolder taskHolder = mock(TaskHolder.class);
        when(taskHolder.getId()).thenReturn(Integer.valueOf(1));

        when(request.getName()).thenReturn("Task test");
        when(request.getDesc()).thenReturn("Task description with more text");
        when(request.getOrder()).thenReturn(Integer.valueOf(1));
        when(request.getStatus()).thenReturn("open");
        when(request.getTaskHolderId()).thenReturn(Integer.valueOf(1));

        Task task = new Task(request.getName(), request.getDesc(), request.getStatus(), request.getOrder());
        when(task.getTaskHolder()).thenReturn(taskHolder);
        when(task.getId()).thenReturn(Integer.valueOf(1));

        when(taskHolderRepository.findById(anyInt())).thenReturn(Optional.of(taskHolder));
        when(taskRepository.save(any(Task.class))).thenReturn(task);


        CreateTask useCase = new CreateTask(taskRepository, taskHolderRepository);
        TaskResponse response = useCase.invoke(this.request);

        verify(taskRepository, atLeastOnce()).save(any(Task.class));

        assertEquals("Task test", response.getName());
        assertEquals("Task description with more text", response.getDescription());
        assertEquals(1, response.getOrder());
        assertEquals("OPEN", response.getStatus());
        assertEquals(1, response.getHolderId());
    }
}
