package com.tasksrest.api.shared.application;

import com.tasksrest.api.shared.application.service.TaskResponse;
import com.tasksrest.api.shared.domain.Task;
import com.tasksrest.api.shared.domain.TaskRepository;
import com.tasksrest.api.shared.domain.exception.NotFoundTaskException;

public class GetTask {
    private final TaskRepository repository;
    private final String NOT_FOUND = "Task not found";

    public GetTask(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskResponse invoke(Integer id) { 
        Task task = this.repository.findById(id);
        
        if (task == null) {
            throw new NotFoundTaskException(NOT_FOUND);
        }
        
        return new TaskResponse(task);
    }
}
