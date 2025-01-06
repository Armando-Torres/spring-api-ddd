package com.tasksrest.api.kanban.infrastructure.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksrest.api.kanban.application.AddColumn;
import com.tasksrest.api.kanban.application.DeleteColumn;
import com.tasksrest.api.kanban.application.GetColumn;
import com.tasksrest.api.kanban.application.GetColumns;
import com.tasksrest.api.kanban.application.UpdateColumn;
import com.tasksrest.api.kanban.application.service.ColumnRequest;
import com.tasksrest.api.kanban.application.service.ColumnResponse;
import com.tasksrest.api.kanban.domain.ColumnRepository;
import com.tasksrest.api.kanban.domain.KanbanRepository;

@RestController
@RequestMapping(value = "/v1/kanban/{kanbanId}/column", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ColumnSpringController {
    private final KanbanRepository kanbanRepository;
    private final ColumnRepository columnRepository;
    
    public ColumnSpringController(KanbanRepository kanbanRepository, ColumnRepository columnRepository) {
        this.kanbanRepository = kanbanRepository;
        this.columnRepository = columnRepository;
    }

    @PostMapping
    public ResponseEntity<List<ColumnResponse>> createKanbanColumn(@PathVariable("kanbanId") Integer kanbanId, @RequestBody List<ColumnRequest> requestBody){
        AddColumn useCase = new AddColumn(this.columnRepository, this.kanbanRepository);
        
        List<ColumnResponse> kanbanColumn = useCase.invoke(kanbanId, requestBody);

        return ResponseEntity.status(HttpStatus.CREATED).body(kanbanColumn);
    }

    @GetMapping
    public ResponseEntity<List<ColumnResponse>> getAllKanbanColumns(@PathVariable("kanbanId") Integer kanbanId) {
        GetColumns useCase = new GetColumns(this.columnRepository, this.kanbanRepository);
        
        List<ColumnResponse> kanbanColumn = useCase.invoke(kanbanId);

        return ResponseEntity.status(HttpStatus.OK).body(kanbanColumn);
    }
    
    @GetMapping("/{columnId}")
    public ResponseEntity<ColumnResponse> getKanbanColumn(@PathVariable("columnId") Integer columnId) {
        GetColumn useCase = new GetColumn(this.columnRepository);
        
        ColumnResponse kanbanColumn = useCase.invoke(columnId);

        return ResponseEntity.status(HttpStatus.OK).body(kanbanColumn);
    }

    @PatchMapping("/{columnId}")
    public ResponseEntity<ColumnResponse> editKanbanColumn(@PathVariable("columnId") Integer columnId, @RequestBody ColumnRequest column) {
        UpdateColumn useCase = new UpdateColumn(this.columnRepository);

        ColumnResponse updateColumn = useCase.invoke(columnId, column);
        
        return ResponseEntity.ok(updateColumn);
    }

    @DeleteMapping("/{columnId}")
    public ResponseEntity<Void> deleteKanbanColumn(@PathVariable("columnId") Integer columnId) {
        DeleteColumn useCase = new DeleteColumn(this.columnRepository);    

        useCase.invoke(columnId);

        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}

