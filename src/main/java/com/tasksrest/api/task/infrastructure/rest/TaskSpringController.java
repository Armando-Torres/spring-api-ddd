package com.tasksrest.api.task.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.tasksrest.api.task.application.CreateTask;
import com.tasksrest.api.task.domain.Task;
import com.tasksrest.api.task.domain.TaskRepository;

@RestController
@RequestMapping(value = "/v1/task")
public class TaskSpringController {    
    @Autowired
    private TaskRepository repository;

    @PostMapping
    public Task createSingleTask(@RequestParam("name") String name, @RequestParam("desc") String description, @RequestParam("status") String status){
        CreateTask useCase = new CreateTask(this.repository);
        
        Task task = useCase.invoke(name, description, status);

        return task;
    }
}
