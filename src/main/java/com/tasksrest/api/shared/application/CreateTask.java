package com.tasksrest.api.shared.application;

import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;

import com.tasksrest.api.shared.application.service.CreateTaskRequest;
import com.tasksrest.api.shared.application.service.TaskResponse;
import com.tasksrest.api.shared.domain.Task;
import com.tasksrest.api.shared.domain.TaskHolder;
import com.tasksrest.api.shared.domain.TaskHolderRepository;
import com.tasksrest.api.shared.domain.TaskRepository;
import com.tasksrest.api.shared.domain.exception.DuplicateTaskException;
import com.tasksrest.api.shared.domain.exception.NotFoundHolderException;

public class CreateTask {
    private final TaskRepository taskRepository;

    private final TaskHolderRepository taskHolderRepository;

    public CreateTask(TaskRepository taskRepository, TaskHolderRepository taskHolderRepository) {
        this.taskRepository = taskRepository;
        this.taskHolderRepository = taskHolderRepository;
    }

    public TaskResponse invoke(CreateTaskRequest request){
        Optional<TaskHolder> taskHolder = this.taskHolderRepository.findById(request.getTaskHolderId());

        if (!taskHolder.isPresent()) {
            throw new NotFoundHolderException(String.format("Holder with id:%d not found", request.getTaskHolderId()));
        }

        Task task = new Task(request.getName(), request.getDesc(), request.getStatus(), request.getOrder());
        task.setTaskHolder(taskHolder.get());

        Task persistTask = null;

        try {
            persistTask = this.taskRepository.save(task);

        } catch (DataIntegrityViolationException e) {
            throw new DuplicateTaskException(String.format("%s already exists", task.getName()));
        } 

        return new TaskResponse(persistTask);
    }
}
