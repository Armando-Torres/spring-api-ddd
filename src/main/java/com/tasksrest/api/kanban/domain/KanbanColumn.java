package com.tasksrest.api.kanban.domain;

import com.tasksrest.api.shared.domain.TaskContainer;

public class KanbanColumn extends TaskContainer{
    private Integer wip;

    private Kanban kanban;

    public KanbanColumn() {}

    public KanbanColumn(Integer wip, Kanban kanban) {
        this.wip = wip;
        this.kanban = kanban;
    }

    public void setWip(Integer wip) {
        this.wip = wip;
    }

    public Integer getWip() {
        return this.wip;
    }

    public void setKanban(Kanban kanban) {
        this.kanban = kanban;
    }

    public Kanban getKanban() {
        return this.kanban;
    }
}
