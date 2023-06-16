package com.tasksrest.api.shared.application;

import org.springframework.dao.DataIntegrityViolationException;

import com.tasksrest.api.shared.application.service.CreateTaskRequest;
import com.tasksrest.api.shared.application.service.TaskResponse;
import com.tasksrest.api.shared.domain.Task;
import com.tasksrest.api.shared.domain.TaskHolder;
import com.tasksrest.api.shared.domain.TaskHolderRepository;
import com.tasksrest.api.shared.domain.TaskRepository;
import com.tasksrest.api.shared.domain.exception.DuplicateTaskException;

public class CreateTask {
    private final TaskRepository taskRepository;

    private final TaskHolderRepository taskHolderRepository;

    public CreateTask(TaskRepository taskRepository, TaskHolderRepository taskHolderRepository) {
        this.taskRepository = taskRepository;
        this.taskHolderRepository = taskHolderRepository;
    }

    public TaskResponse invoke(CreateTaskRequest request){
        TaskHolder taskHolder = this.taskHolderRepository.findById(request.getTaskHolderId());

        Task task = new Task(request.getName(), request.getDesc(), request.getStatus(), request.getOrder());
        task.setTaskHolder(taskHolder);

        Task persistTask = null;

        try {
            persistTask = this.taskRepository.save(task);

        } catch (DataIntegrityViolationException e) {
            throw new DuplicateTaskException(String.format("%s already exists", task.getName()));
        } 

        return new TaskResponse(persistTask);
    }
}
