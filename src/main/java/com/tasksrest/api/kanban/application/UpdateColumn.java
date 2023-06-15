package com.tasksrest.api.kanban.application;

import com.tasksrest.api.kanban.application.service.ColumnRequest;
import com.tasksrest.api.kanban.application.service.ColumnResponse;
import com.tasksrest.api.kanban.domain.Column;
import com.tasksrest.api.kanban.domain.ColumnRepository;
import com.tasksrest.api.kanban.domain.exception.NotFoundColumnException;

public class UpdateColumn {
    private final ColumnRepository kanbanColumnRepository;

    private final String NOT_FOUND = "Column not found";

    public UpdateColumn(ColumnRepository kanbanColumnRepository) {
        this.kanbanColumnRepository = kanbanColumnRepository;
    }

    public ColumnResponse invoke(Integer columnId, ColumnRequest newColumnData){ 
        Column column = this.kanbanColumnRepository.findById(columnId);

        if (column == null) {
            throw new NotFoundColumnException(NOT_FOUND);
        }

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
