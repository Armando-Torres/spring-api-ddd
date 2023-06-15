package com.tasksrest.api.kanban.application;

import org.springframework.dao.DataIntegrityViolationException;

import com.tasksrest.api.kanban.application.service.CreateKanbanRequest;
import com.tasksrest.api.kanban.application.service.KanbanResponse;
import com.tasksrest.api.kanban.domain.Kanban;
import com.tasksrest.api.kanban.domain.KanbanRepository;
import com.tasksrest.api.shared.domain.exception.DuplicateTaskException;

public class CreateKanban {
    private final KanbanRepository kanbanRepository;

    public CreateKanban(KanbanRepository kanbanRepository) {
        this.kanbanRepository = kanbanRepository;
    }

    public KanbanResponse invoke(CreateKanbanRequest request){
        Kanban persistKanban = null;

        try {
            persistKanban = this.kanbanRepository.save(new Kanban(request.getName()));

        } catch (DataIntegrityViolationException e) {
            throw new DuplicateTaskException(String.format("%s already exists", request.getName()));
        } 

        return new KanbanResponse(persistKanban);
    }
}
