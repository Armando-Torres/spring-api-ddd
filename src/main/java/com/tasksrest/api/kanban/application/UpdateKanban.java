package com.tasksrest.api.kanban.application;

import java.util.Optional;

import com.tasksrest.api.kanban.application.service.KanbanRequest;
import com.tasksrest.api.kanban.application.service.KanbanResponse;
import com.tasksrest.api.kanban.domain.Kanban;
import com.tasksrest.api.kanban.domain.KanbanRepository;
import com.tasksrest.api.kanban.domain.exception.NotFoundKanbanException;

public class UpdateKanban {
    private final KanbanRepository kanbanRepository;

    private static final String notFound = "Kanban not found";

    public UpdateKanban(KanbanRepository kanbanRepository) {
        this.kanbanRepository = kanbanRepository;
    }

    public KanbanResponse invoke(Integer kanbanId, KanbanRequest newKanbanData){ 
        Optional<Kanban> kanban = this.kanbanRepository.findById(kanbanId);

        if (!kanban.isPresent()) {
            throw new NotFoundKanbanException(notFound);
        }

        Kanban persistKanban = null;

        if (newKanbanData.getName() != null) {
            kanban.get().setName(newKanbanData.getName());
        }

        persistKanban = this.kanbanRepository.save(kanban.get());
        
        return new KanbanResponse(persistKanban);
    }
}
