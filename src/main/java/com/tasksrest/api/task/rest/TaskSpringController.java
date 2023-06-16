package com.tasksrest.api.task.rest;

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

import com.tasksrest.api.shared.application.CreateTask;
import com.tasksrest.api.shared.application.GetTask;
import com.tasksrest.api.shared.application.GetTasks;
import com.tasksrest.api.shared.application.UpdateTask;
import com.tasksrest.api.shared.application.service.CreateTaskRequest;
import com.tasksrest.api.shared.application.service.TaskRequest;
import com.tasksrest.api.shared.application.service.TaskResponse;
import com.tasksrest.api.shared.domain.Task;
import com.tasksrest.api.shared.domain.TaskHolderRepository;
import com.tasksrest.api.shared.domain.TaskRepository;
import com.tasksrest.api.shared.domain.vo.Pagination;
import com.tasksrest.api.shared.domain.vo.TaskStatus;
import com.tasksrest.api.shared.domain.vo.TasksFilters;

@RestController
@RequestMapping(value = "/v1/task", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskSpringController {    
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskHolderRepository taskHolderRepository;

    @PostMapping
    public ResponseEntity<TaskResponse> createSingleTask(@RequestBody CreateTaskRequest requestBody){
        CreateTask useCase = new CreateTask(this.taskRepository, this.taskHolderRepository);
        
        TaskResponse task = useCase.invoke(requestBody);

        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<TaskResponse> editTasks(@PathVariable("id") Integer id, @RequestBody TaskRequest task) {
        UpdateTask useCase = new UpdateTask(this.taskRepository);

        TaskResponse updateTask = useCase.invoke(id, task);
        
        return ResponseEntity.ok(updateTask);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable("id") Integer id) {
        GetTask useCase = new GetTask(this.taskRepository);

        TaskResponse task = useCase.invoke(id);

        return ResponseEntity.ok(task);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getTasks(@RequestParam Map<String,String> filters) {
        GetTasks useCase = new GetTasks(this.taskRepository);

        Pagination pagination = new Pagination(Integer.parseInt(filters.get("offset")), Integer.parseInt(filters.get("limit")));
        TaskStatus status = (filters.get("status") != null) ? new TaskStatus(filters.get("status")) : null;
        TasksFilters taskFilters = new TasksFilters(filters.get("name"), filters.get("desc"), Integer.parseInt(filters.get("holder")), status, pagination);

        List<TaskResponse> tasks = useCase.invoke(taskFilters);
        
        return ResponseEntity.ok(tasks);
    }
}
