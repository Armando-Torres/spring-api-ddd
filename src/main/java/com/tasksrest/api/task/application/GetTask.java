package com.tasksrest.api.task.application;

import com.tasksrest.api.task.domain.Task;
import com.tasksrest.api.task.domain.TaskRepository;
import com.tasksrest.api.task.domain.exception.NotFoundTaskException;

public class GetTask {
    private final TaskRepository repository;
    private final String NOT_FOUND = "Task not found";

    public GetTask(TaskRepository repository) {
        this.repository = repository;
    }

    public Task invoke(Integer id) { 
        Task task = this.repository.findById(id);
        
        if (task == null) {
            throw new NotFoundTaskException(NOT_FOUND);
        }
        
        return task;
    }
}
