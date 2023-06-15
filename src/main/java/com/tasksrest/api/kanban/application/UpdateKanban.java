package com.tasksrest.api.kanban.application;

import com.tasksrest.api.kanban.application.service.KanbanRequest;
import com.tasksrest.api.kanban.application.service.KanbanResponse;
import com.tasksrest.api.kanban.domain.Kanban;
import com.tasksrest.api.kanban.domain.KanbanRepository;
import com.tasksrest.api.kanban.domain.exception.NotFoundKanbanException;

public class UpdateKanban {
    private final KanbanRepository kanbanRepository;

    private final String NOT_FOUND = "Kanban not found";

    public UpdateKanban(KanbanRepository kanbanRepository) {
        this.kanbanRepository = kanbanRepository;
    }

    public KanbanResponse invoke(Integer kanbanId, KanbanRequest newKanbanData){ 
        Kanban kanban = this.kanbanRepository.findById(kanbanId);

        if (kanban == null) {
            throw new NotFoundKanbanException(NOT_FOUND);
        }

        Kanban persistKanban = null;

        if (newKanbanData.getName() != null) {
            kanban.setName(newKanbanData.getName());
        }

        persistKanban = this.kanbanRepository.save(kanban);
        
        return new KanbanResponse(persistKanban);
    }
}
