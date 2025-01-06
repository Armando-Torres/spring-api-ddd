package com.tasksrest.api.kanban.application;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.tasksrest.api.kanban.application.service.ColumnResponse;
import com.tasksrest.api.kanban.application.service.CreateKanbanRequest;
import com.tasksrest.api.kanban.application.service.KanbanResponse;
import com.tasksrest.api.kanban.application.service.KanbanWithColumnsResponse;
import com.tasksrest.api.kanban.domain.ColumnRepository;
import com.tasksrest.api.kanban.domain.Kanban;
import com.tasksrest.api.kanban.domain.KanbanRepository;
import com.tasksrest.api.kanban.domain.exception.DuplicateKanbanException;

public class CreateKanban {
    private final KanbanRepository kanbanRepository;

    private final ColumnRepository columnRepository;

    public CreateKanban(KanbanRepository kanbanRepository, ColumnRepository columnRepository) {
        this.kanbanRepository = kanbanRepository;
        this.columnRepository = columnRepository;
    }

    public KanbanResponse invoke(CreateKanbanRequest request){
        Kanban persistKanban = null;
        KanbanResponse response = null;
        KanbanWithColumnsResponse responseWithColumns = null;

        try {
            persistKanban = this.kanbanRepository.save(new Kanban(request.getName()));
            response = new KanbanResponse(persistKanban);

            // If columns are set, call AddColumn use case instead of give responsability to persistence mapping
            if (!request.getColumns().isEmpty()) {
                responseWithColumns =  new KanbanWithColumnsResponse(persistKanban);

                AddColumn addColumnUseCase = new AddColumn(this.columnRepository, this.kanbanRepository);
            
                List<ColumnResponse> kanbanColumns = addColumnUseCase.invoke(persistKanban, request.getColumns());

                responseWithColumns.setColumns(kanbanColumns);
            }

        } catch (DataIntegrityViolationException e) {
            throw new DuplicateKanbanException(String.format("%s already exists", request.getName()));
        } 

        return (responseWithColumns != null) ? responseWithColumns : response;
    }
}
