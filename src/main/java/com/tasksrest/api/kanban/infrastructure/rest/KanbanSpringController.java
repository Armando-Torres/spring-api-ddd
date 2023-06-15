package com.tasksrest.api.kanban.infrastructure.rest;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.tasksrest.api.kanban.application.CreateKanban;
import com.tasksrest.api.kanban.application.GetAllKanban;
import com.tasksrest.api.kanban.application.GetKanban;
import com.tasksrest.api.kanban.application.UpdateKanban;
import com.tasksrest.api.kanban.application.service.CreateKanbanRequest;
import com.tasksrest.api.kanban.application.service.KanbanRequest;
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

    @PatchMapping(path = "/{id}")
    public ResponseEntity<KanbanResponse> editTasks(@PathVariable("id") Integer id, @RequestBody KanbanRequest kanban) {
        UpdateKanban useCase = new UpdateKanban(kanbanRepository);

        KanbanResponse updateKanban = useCase.invoke(id, kanban);
        
        return ResponseEntity.ok(updateKanban);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<KanbanResponse> getKanban(@PathVariable("id") Integer id) {
        GetKanban useCase = new GetKanban(this.kanbanRepository);

        KanbanResponse kanban = useCase.invoke(id);

        return ResponseEntity.ok(kanban);
    }

    @GetMapping
    public ResponseEntity<List<KanbanResponse>> getAllKanban() {
        GetAllKanban useCase = new GetAllKanban(this.kanbanRepository);

        List<KanbanResponse> kanban = useCase.invoke();

        return ResponseEntity.ok(kanban);
    }
}
    