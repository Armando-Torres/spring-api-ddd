package com.tasksrest.api.shared.application;

import org.springframework.dao.DataIntegrityViolationException;

import com.tasksrest.api.shared.application.service.CreateTaskRequest;
import com.tasksrest.api.shared.domain.Task;
import com.tasksrest.api.shared.domain.TaskRepository;
import com.tasksrest.api.shared.domain.exception.DuplicateTaskException;

public class CreateTask {
    private final TaskRepository repository;

    public CreateTask(TaskRepository repository) {
        this.repository = repository;
    }

    public Task invoke(CreateTaskRequest request){
        Task task = new Task(request.getName(), request.getDesc(), request.getStatus());
        Task persistTask = null;

        try {
            persistTask = this.repository.save(task);

        } catch (DataIntegrityViolationException e) {
            throw new DuplicateTaskException(String.format("%s already exists", task.getName()));
        } 

        return persistTask;
    }
}
