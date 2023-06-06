package com.tasksrest.api.task.infrastructure.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasksrest.api.shared.domain.vo.Pagination;
import com.tasksrest.api.task.application.CreateTask;
import com.tasksrest.api.task.application.GetTask;
import com.tasksrest.api.task.application.GetTasks;
import com.tasksrest.api.task.application.UpdateTask;
import com.tasksrest.api.task.application.requests.CreateTaskRequest;
import com.tasksrest.api.task.domain.Task;
import com.tasksrest.api.task.domain.TaskRepository;
import com.tasksrest.api.task.domain.vo.Status;
import com.tasksrest.api.task.domain.vo.TasksFilters;

@RestController
@RequestMapping(value = "/v1/task", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskSpringController {    
    @Autowired
    private TaskRepository repository;

    @PostMapping
    public ResponseEntity<Task> createSingleTask(@RequestBody CreateTaskRequest requestBody){
        CreateTask useCase = new CreateTask(this.repository);
        
        Task task = useCase.invoke(requestBody);

        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Task> editTasks(@PathVariable("id") Integer id, @RequestBody Task task) {
        UpdateTask useCase = new UpdateTask(repository);

        Task updateTask = useCase.invoke(id, task);
        
        return ResponseEntity.ok(updateTask);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Task> getTask(@PathVariable("id") Integer id) {
        GetTask useCase = new GetTask(this.repository);

        Task task = useCase.invoke(id);

        return ResponseEntity.ok(task);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(@RequestParam Map<String,String> filters) {
        GetTasks useCase = new GetTasks(this.repository);

        Pagination pagination = new Pagination(Integer.parseInt(filters.get("offset")), Integer.parseInt(filters.get("limit")));
        Status status = (filters.get("status") != null) ? new Status(filters.get("status")) : null;
        TasksFilters taskFilters = new TasksFilters(filters.get("name"), filters.get("desc"), status, pagination);

        List<Task> tasks = useCase.invoke(taskFilters);
        
        return ResponseEntity.ok(tasks);
    }
}
