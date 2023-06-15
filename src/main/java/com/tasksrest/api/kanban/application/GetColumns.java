package com.tasksrest.api.kanban.application;

import java.util.List;
import java.util.stream.Collectors;

import com.tasksrest.api.kanban.application.service.ColumnResponse;
import com.tasksrest.api.kanban.domain.Column;
import com.tasksrest.api.kanban.domain.ColumnRepository;
import com.tasksrest.api.kanban.domain.Kanban;
import com.tasksrest.api.kanban.domain.KanbanRepository;
import com.tasksrest.api.kanban.domain.exception.NotFoundKanbanException;

public class GetColumns {
    private final KanbanRepository kanbanRepository;
    private final ColumnRepository kanbanColumnRepository;

    public GetColumns(ColumnRepository kanbanColumnRepository, KanbanRepository kanbanRepository) {
        this.kanbanColumnRepository = kanbanColumnRepository;
        this.kanbanRepository = kanbanRepository;
    }

    public List<ColumnResponse> invoke(Integer kanbanId){ 
        Kanban kanban = this.kanbanRepository.findById(kanbanId);
        
        if (kanban == null) {
            throw new NotFoundKanbanException("Not found");
        }

        List<Column> columns = this.kanbanColumnRepository.findAll();
        
        return columns.stream()
            .map(element -> { return new ColumnResponse(element); })
            .collect(Collectors.toList());
    }
}
