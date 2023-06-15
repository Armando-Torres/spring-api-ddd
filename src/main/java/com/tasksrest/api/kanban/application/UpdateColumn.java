package com.tasksrest.api.kanban.application;

import com.tasksrest.api.kanban.application.service.ColumnRequest;
import com.tasksrest.api.kanban.application.service.ColumnResponse;
import com.tasksrest.api.kanban.domain.Column;
import com.tasksrest.api.kanban.domain.ColumnRepository;
import com.tasksrest.api.kanban.domain.Kanban;
import com.tasksrest.api.kanban.domain.KanbanRepository;
import com.tasksrest.api.kanban.domain.exception.NotFoundKanbanException;

public class UpdateColumn {
    private final KanbanRepository kanbanRepository;
    private final ColumnRepository kanbanColumnRepository;

    public UpdateColumn(ColumnRepository kanbanColumnRepository, KanbanRepository kanbanRepository) {
        this.kanbanColumnRepository = kanbanColumnRepository;
        this.kanbanRepository = kanbanRepository;
    }

    public ColumnResponse invoke(Integer kanbanId, Integer columnId, ColumnRequest newColumnData){ 
        Kanban kanban = this.kanbanRepository.findById(kanbanId);
        
        if (kanban == null) {
            throw new NotFoundKanbanException("Not found");
        }

        Column column = this.kanbanColumnRepository.findById(columnId);
        Column persistColumn = null;

        if (newColumnData.getName() != null) {
            column.setName(newColumnData.getName());
        }
        
        if (newColumnData.getWip() != null) {
            column.setWip(newColumnData.getWip());
        }

        if (newColumnData.getOrder() != null) {
            column.setOrder(newColumnData.getOrder());
        }

        persistColumn = this.kanbanColumnRepository.save(column);
        
        return new ColumnResponse(persistColumn);
    }
}
