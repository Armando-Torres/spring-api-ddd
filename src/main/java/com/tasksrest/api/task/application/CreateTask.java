package com.tasksrest.api.task.application;

import org.springframework.dao.DataIntegrityViolationException;

import com.tasksrest.api.task.domain.Task;
import com.tasksrest.api.task.domain.TaskRepository;
import com.tasksrest.api.task.domain.exception.DuplicateTaskException;

public class CreateTask {
    private final TaskRepository repository;

    public CreateTask(TaskRepository repository) {
        this.repository = repository;
    }

    public Task invoke(String name, String description, String status){
        Task task = new Task(name, description, status.toUpperCase());
        Task persistTask = null;

        try {
            persistTask = this.repository.save(task);

        } catch (DataIntegrityViolationException e) {
            throw new DuplicateTaskException(String.format("%s already exists", task.getName()));
        } 

        return persistTask;
    }
}
