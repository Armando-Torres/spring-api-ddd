package com.tasksrest.api.kanban.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.tasksrest.api.kanban.domain.Kanban;
import com.tasksrest.api.kanban.application.service.AddColumnRequest;
import com.tasksrest.api.kanban.application.service.ColumnResponse;
import com.tasksrest.api.kanban.domain.Column;
import com.tasksrest.api.kanban.domain.ColumnRepository;
import com.tasksrest.api.kanban.domain.KanbanRepository;
import com.tasksrest.api.shared.domain.exception.DuplicateTaskException;

public class AddColumn {
    private final KanbanRepository kanbanRepository;
    private final ColumnRepository kanbanColumnRepository;

    public AddColumn(ColumnRepository kanbanColumnRepository, KanbanRepository kanbanRepository) {
        this.kanbanColumnRepository = kanbanColumnRepository;
        this.kanbanRepository = kanbanRepository;
    }

    public List<ColumnResponse> invoke(Integer kanbanId, List<AddColumnRequest> request){
        List<ColumnResponse> persistKanban = new ArrayList<ColumnResponse>();
        Kanban kanban = this.kanbanRepository.findById(kanbanId);

        try {
            for (AddColumnRequest column : request) {
                Column kanbanColumn = new Column(column.getName(), column.getOrder(), column.getWip(), kanban);
                
                persistKanban.add(
                    new ColumnResponse(
                        this.kanbanColumnRepository.save(kanbanColumn)
                    )
                );
            }            

        } catch (DataIntegrityViolationException e) {
            throw new DuplicateTaskException(String.format("d already exists", kanbanId));
        } 

        return persistKanban;
    }
}