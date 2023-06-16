package com.tasksrest.api.kanban.application;

import java.util.Optional;

import com.tasksrest.api.kanban.application.service.KanbanResponse;
import com.tasksrest.api.kanban.domain.Kanban;
import com.tasksrest.api.kanban.domain.KanbanRepository;
import com.tasksrest.api.kanban.domain.exception.NotFoundKanbanException;

public class GetKanban {
    private KanbanRepository repository;

    public GetKanban(KanbanRepository repository) {
        this.repository = repository;
    }

    public KanbanResponse invoke(Integer id) {
        Optional<Kanban> kanban = this.repository.findById(id);
        
        if (!kanban.isPresent()) {
            throw new NotFoundKanbanException("Not found");
        }
        
        return new KanbanResponse(kanban.get());
    }
}
