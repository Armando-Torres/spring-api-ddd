package com.tasksrest.api.kanban.application;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.tasksrest.api.kanban.application.service.ColumnResponse;
import com.tasksrest.api.kanban.application.service.CreateKanbanRequest;
import com.tasksrest.api.kanban.application.service.KanbanResponse;
import com.tasksrest.api.kanban.domain.ColumnRepository;
import com.tasksrest.api.kanban.domain.Kanban;
import com.tasksrest.api.kanban.domain.KanbanRepository;
import com.tasksrest.api.shared.domain.exception.DuplicateTaskException;

public class CreateKanban {
    private final KanbanRepository kanbanRepository;

    private final ColumnRepository columnRepository;

    public CreateKanban(KanbanRepository kanbanRepository, ColumnRepository columnRepository) {
        this.kanbanRepository = kanbanRepository;
        this.columnRepository = columnRepository;
    }

    public KanbanResponse invoke(CreateKanbanRequest request){
        Kanban persistKanban = null;
        KanbanResponse response;

        try {
            persistKanban = this.kanbanRepository.save(new Kanban(request.getName()));
            response = new KanbanResponse(persistKanban);

            // If columns are set, call AddColumn use case instead of give responsability to persistence mapping
            if (request.getColumns().size() > 0) {
                AddColumn addColumnUseCase = new AddColumn(this.columnRepository, this.kanbanRepository);
            
                List<ColumnResponse> kanbanColumns = addColumnUseCase.invoke(persistKanban.getId(), request.getColumns());

                response.setColumns(kanbanColumns);
            }

        } catch (DataIntegrityViolationException e) {
            throw new DuplicateTaskException(String.format("%s already exists", request.getName()));
        } 

        return response;
    }
}
