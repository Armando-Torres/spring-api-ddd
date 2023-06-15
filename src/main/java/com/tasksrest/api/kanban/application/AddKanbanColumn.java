package com.tasksrest.api.kanban.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.tasksrest.api.kanban.application.request.CreateKanbanColumnRequest;
import com.tasksrest.api.kanban.domain.Kanban;
import com.tasksrest.api.kanban.domain.Column;
import com.tasksrest.api.kanban.domain.ColumnRepository;
import com.tasksrest.api.kanban.domain.KanbanRepository;
import com.tasksrest.api.shared.domain.exception.DuplicateTaskException;

public class AddKanbanColumn {
    private final KanbanRepository kanbanRepository;
    private final ColumnRepository kanbanColumnRepository;

    public AddKanbanColumn(ColumnRepository kanbanColumnRepository, KanbanRepository kanbanRepository) {
        this.kanbanColumnRepository = kanbanColumnRepository;
        this.kanbanRepository = kanbanRepository;
    }

    public List<Column> invoke(Integer kanbanId, List<CreateKanbanColumnRequest> request){
        List<Column> persistKanban = new ArrayList<Column>();
        Kanban kanban = this.kanbanRepository.findById(kanbanId);

        try {
            for (CreateKanbanColumnRequest column : request) {
                Column kanbanColumn = new Column(column.getName(), column.getOrder(), column.getWip(), kanban);
                
                persistKanban.add(
                    this.kanbanColumnRepository.save(kanbanColumn)
                );
            }            

        } catch (DataIntegrityViolationException e) {
            throw new DuplicateTaskException(String.format("d already exists", kanbanId));
        } 

        return persistKanban;
    }
}
