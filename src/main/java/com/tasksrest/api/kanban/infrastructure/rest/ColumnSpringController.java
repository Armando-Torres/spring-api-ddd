package com.tasksrest.api.kanban.infrastructure.rest;

import java.util.List;

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

import com.tasksrest.api.kanban.application.AddColumn;
import com.tasksrest.api.kanban.application.GetColumns;
import com.tasksrest.api.kanban.application.service.AddColumnRequest;
import com.tasksrest.api.kanban.application.service.ColumnResponse;
import com.tasksrest.api.kanban.domain.ColumnRepository;
import com.tasksrest.api.kanban.domain.KanbanRepository;

@RestController
@RequestMapping(value = "/v1/kanban/{id}/column", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ColumnSpringController {
    @Autowired
    private KanbanRepository kanbanRepository;

    @Autowired
    private ColumnRepository columnRepository;

    @PostMapping()
    public ResponseEntity<List<ColumnResponse>> createKanbanColumn(@PathVariable("id") Integer kanbanId, @RequestBody List<AddColumnRequest> requestBody){
        AddColumn useCase = new AddColumn(this.columnRepository, this.kanbanRepository);
        
        List<ColumnResponse> kanbanColumn = useCase.invoke(kanbanId, requestBody);

        return ResponseEntity.status(HttpStatus.CREATED).body(kanbanColumn);
    }

    @GetMapping()
    public ResponseEntity<List<ColumnResponse>> getKanbanColumns(@PathVariable("id") Integer kanbanId) {
        GetColumns useCase = new GetColumns(this.columnRepository, this.kanbanRepository);
        
        List<ColumnResponse> kanbanColumn = useCase.invoke(kanbanId);

        return ResponseEntity.status(HttpStatus.OK).body(kanbanColumn);
    }
}

