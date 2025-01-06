package com.tasksrest.api.kanban.application;

import java.util.Optional;

import com.tasksrest.api.kanban.application.service.ColumnRequest;
import com.tasksrest.api.kanban.application.service.ColumnResponse;
import com.tasksrest.api.kanban.domain.Column;
import com.tasksrest.api.kanban.domain.ColumnRepository;
import com.tasksrest.api.kanban.domain.exception.NotFoundColumnException;

public class UpdateColumn {
    private final ColumnRepository kanbanColumnRepository;

    private static final String notFound = "Column not found";

    public UpdateColumn(ColumnRepository kanbanColumnRepository) {
        this.kanbanColumnRepository = kanbanColumnRepository;
    }

    public ColumnResponse invoke(Integer columnId, ColumnRequest newColumnData){ 
        Optional<Column> column = this.kanbanColumnRepository.findById(columnId);

        if (!column.isPresent()) {
            throw new NotFoundColumnException(notFound);
        }

        Column persistColumn = null;

        if (newColumnData.getName() != null) {
            column.get().setName(newColumnData.getName());
        }
        
        if (newColumnData.getWip() != null) {
            column.get().setWip(newColumnData.getWip());
        }

        if (newColumnData.getOrder() != null) {
            column.get().setOrder(newColumnData.getOrder());
        }

        persistColumn = this.kanbanColumnRepository.save(column.get());
        
        return new ColumnResponse(persistColumn);
    }
}
