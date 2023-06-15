package com.tasksrest.api.kanban.application;

import com.tasksrest.api.kanban.application.service.KanbanResponse;
import com.tasksrest.api.kanban.domain.Kanban;
import com.tasksrest.api.kanban.domain.KanbanRepository;
import com.tasksrest.api.shared.domain.exception.NotFoundTaskException;

public class GetKanban {
    private KanbanRepository repository;

    public GetKanban(KanbanRepository repository) {
        this.repository = repository;
    }

    public KanbanResponse invoke(Integer id) {
        Kanban kanban = this.repository.findById(id);
        
        if (kanban == null) {
            throw new NotFoundTaskException("Not found");
        }
        
        return new KanbanResponse(kanban);
    }
}
