package com.tasksrest.api.kanban.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;

import com.tasksrest.api.kanban.domain.Kanban;
import com.tasksrest.api.kanban.application.service.ColumnRequest;
import com.tasksrest.api.kanban.application.service.ColumnResponse;
import com.tasksrest.api.kanban.domain.Column;
import com.tasksrest.api.kanban.domain.ColumnRepository;
import com.tasksrest.api.kanban.domain.KanbanRepository;
import com.tasksrest.api.kanban.domain.exception.DuplicateColumnException;
import com.tasksrest.api.kanban.domain.exception.NotFoundKanbanException;

public class AddColumn {
    private final KanbanRepository kanbanRepository;
    private final ColumnRepository kanbanColumnRepository;

    public AddColumn(ColumnRepository kanbanColumnRepository, KanbanRepository kanbanRepository) {
        this.kanbanColumnRepository = kanbanColumnRepository;
        this.kanbanRepository = kanbanRepository;
    }

    public List<ColumnResponse> invoke(Kanban kanban, List<ColumnRequest> request){ 
        return this.invokeInternal(kanban, request);
    }

    public List<ColumnResponse> invoke(Integer kanbanId, List<ColumnRequest> request){
        Optional<Kanban> kanban = this.kanbanRepository.findById(kanbanId);

        if (!kanban.isPresent()) {
            throw new NotFoundKanbanException(String.format("Kanban with id:%d not found", kanbanId));
        }

        return this.invokeInternal(kanban.get(), request);
    }

    private List<ColumnResponse> invokeInternal(Kanban kanban, List<ColumnRequest> request) {
        List<ColumnResponse> persistKanban = new ArrayList<ColumnResponse>();

        try {
            for (ColumnRequest column : request) {
                Column kanbanColumn = new Column(column.getName(), column.getOrder(), column.getWip(), kanban);
                
                persistKanban.add(
                    new ColumnResponse(
                        this.kanbanColumnRepository.save(kanbanColumn)
                    )
                );
            }            

        } catch (DataIntegrityViolationException e) {
            throw new DuplicateColumnException("Some columns already exists");
        } 

        return persistKanban;
    }
}
