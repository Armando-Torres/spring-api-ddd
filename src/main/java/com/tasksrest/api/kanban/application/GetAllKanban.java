package com.tasksrest.api.kanban.application;

import java.util.List;
import java.util.stream.Collectors;

import com.tasksrest.api.kanban.application.service.KanbanResponse;
import com.tasksrest.api.kanban.domain.Kanban;
import com.tasksrest.api.kanban.domain.KanbanRepository;

public class GetAllKanban {
    private KanbanRepository repository;

    public GetAllKanban(KanbanRepository repository) {
        this.repository = repository;
    }

    public List<KanbanResponse> invoke() {
        List<Kanban> kanbans = this.repository.findAll();
        
        return kanbans.stream()
            .map(kanban -> new KanbanResponse(kanban))
            .collect(Collectors.toList());
    }
}
