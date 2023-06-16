package com.tasksrest.api.kanban.domain;

import com.tasksrest.api.shared.domain.TaskHolder;

public class Column extends TaskHolder {
    private Integer wip;

    private Kanban kanban;

    public Column() {}

    public Column(String name, Integer order, Integer wip) {
        super(name, order);
        
        this.wip = wip;
    }

    public Column(String name, Integer order, Integer wip, Kanban kanban) {
        super(name, order);
        
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
