package com.tasksrest.api.kanban.infrastructure.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksrest.api.kanban.application.AddKanbanColumn;
import com.tasksrest.api.kanban.application.request.CreateKanbanColumnRequest;
import com.tasksrest.api.kanban.domain.Column;
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
    public ResponseEntity<List<Column>> createKanbanColumn(@PathVariable("id") Integer kanbanId, @RequestBody List<CreateKanbanColumnRequest> requestBody){
        AddKanbanColumn useCase = new AddKanbanColumn(this.columnRepository, this.kanbanRepository);
        
        List<Column> kanbanColumn = useCase.invoke(kanbanId, requestBody);

        return ResponseEntity.status(HttpStatus.CREATED).body(kanbanColumn);
    }
}

