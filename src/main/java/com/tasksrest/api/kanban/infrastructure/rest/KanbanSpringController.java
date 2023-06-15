package com.tasksrest.api.kanban.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksrest.api.kanban.application.CreateKanban;
import com.tasksrest.api.kanban.application.GetKanban;
import com.tasksrest.api.kanban.application.service.CreateKanbanRequest;
import com.tasksrest.api.kanban.application.service.KanbanResponse;
import com.tasksrest.api.kanban.domain.ColumnRepository;
import com.tasksrest.api.kanban.domain.KanbanRepository;

@RestController
@RequestMapping(value = "/v1/kanban", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class KanbanSpringController {
    @Autowired
    private KanbanRepository kanbanRepository;

    @Autowired
    private ColumnRepository columnRepository;

    @PostMapping
    public ResponseEntity<KanbanResponse> createKanban(@RequestBody CreateKanbanRequest requestBody){
        CreateKanban useCase = new CreateKanban(this.kanbanRepository, this.columnRepository);
        
        KanbanResponse kanban = useCase.invoke(requestBody);

        return ResponseEntity.status(HttpStatus.CREATED).body(kanban);
    }

    /*@PatchMapping(path = "/{id}")
    public ResponseEntity<Task> editTasks(@PathVariable("id") Integer id, @RequestBody Task task) {
        UpdateTask useCase = new UpdateTask(repository);

        Task updateTask = useCase.invoke(id, task);
        
        return ResponseEntity.ok(updateTask);
    }*/

    @GetMapping(path = "/{id}")
    public ResponseEntity<KanbanResponse> getTask(@PathVariable("id") Integer id) {
        GetKanban useCase = new GetKanban(this.kanbanRepository);

        KanbanResponse kanban = useCase.invoke(id);

        return ResponseEntity.ok(kanban);
    }

    /*@GetMapping
    public ResponseEntity<List<GetKanbanResponse>> getTasks(@RequestParam Map<String,String> filters) {
        GetTasks useCase = new GetTasks(this.repository);

        Pagination pagination = new Pagination(Integer.parseInt(filters.get("offset")), Integer.parseInt(filters.get("limit")));
        TaskStatus status = (filters.get("status") != null) ? new TaskStatus(filters.get("status")) : null;
        TasksFilters taskFilters = new TasksFilters(filters.get("name"), filters.get("desc"), status, pagination);

        List<GetKanbanResponse> tasks = useCase.invoke(taskFilters);
        
        return ResponseEntity.ok(tasks);
    }*/
}
    