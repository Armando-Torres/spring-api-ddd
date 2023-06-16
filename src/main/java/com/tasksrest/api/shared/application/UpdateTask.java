package com.tasksrest.api.shared.application;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.tasksrest.api.shared.application.service.TaskRequest;
import com.tasksrest.api.shared.application.service.TaskResponse;
import com.tasksrest.api.shared.domain.Task;
import com.tasksrest.api.shared.domain.TaskRepository;
import com.tasksrest.api.shared.domain.exception.UpdateEmptyException;

public class UpdateTask {
    private final TaskRepository repository;

    public UpdateTask(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskResponse invoke(Integer id, TaskRequest newTaskData){
        this.checkIfAtLeastOneFieldAreForUpdate(id, newTaskData);

        Task task = this.repository.findById(id);
        Task persistTask = null;

        if (newTaskData.getName() != null) {
            task.setName(newTaskData.getName());
        }
        
        if (newTaskData.getDesc() != null) {
            task.setDescription(newTaskData.getDesc());
        }

        if (newTaskData.getOrder() != null) {
            task.setOrder(newTaskData.getOrder());
        }

        if (newTaskData.getStatus() != null) {
            task.setStatus(newTaskData.getStatus());
        }

        persistTask = this.repository.save(task);

        return new TaskResponse(persistTask);
    }

    private void checkIfAtLeastOneFieldAreForUpdate(Integer id, TaskRequest newTaskData) {

        Class<?> taskClass = newTaskData.getClass();

        Set<Field> properties = new HashSet<Field>(Arrays.asList(taskClass.getDeclaredFields()));

        for (Field field : properties) {
            field.setAccessible(true);            

            try {
                if (field.get(newTaskData) == null) {
                    continue;
                } else {
                    return;
                }
            } catch (NullPointerException e) {
                continue;

            } catch (IllegalAccessException e) {
                throw new UpdateEmptyException(String.format("Updating task with id: %d with access issues", id));
            }
        }

        throw new UpdateEmptyException(String.format("Trying to update task with id: %d with no body", id));
    }
}
