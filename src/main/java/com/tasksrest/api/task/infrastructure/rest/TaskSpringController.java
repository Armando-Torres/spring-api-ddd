package com.tasksrest.api.task.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tasksrest.api.task.application.CreateTask;
import com.tasksrest.api.task.application.CreateTaskRequest;
import com.tasksrest.api.task.application.GetTask;
import com.tasksrest.api.task.domain.Task;
import com.tasksrest.api.task.domain.TaskRepository;

@RestController
@RequestMapping(value = "/v1/task", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskSpringController {    
    @Autowired
    private TaskRepository repository;

    @PostMapping
    //public Task createSingleTask(@RequestBody String name, @RequestBody String description, @RequestBody String status){
    public Task createSingleTask(@RequestBody CreateTaskRequest requestBody){
        CreateTask useCase = new CreateTask(this.repository);
        
        Task task = useCase.invoke(requestBody);

        return task;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getTask(@PathVariable("id") Integer id) {
        GetTask useCase = new GetTask(this.repository);
        Task task = useCase.invoke(id);

        return ResponseEntity.ok(task);
        
    }
}
