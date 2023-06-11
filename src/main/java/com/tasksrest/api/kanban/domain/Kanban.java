package com.tasksrest.api.kanban.domain;

import java.util.Collection;

public class Kanban {
    private Integer id;

    private String name;

    private Collection<KanbanColumn> columns;

    public Kanban() {

    }

    public Kanban(String name) {
        this.name = name;
    }

    public Kanban(String name, Collection<KanbanColumn> columns) {
        this.name = name;
        this.columns = columns;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<KanbanColumn> getColumns() {
        return this.columns;
    }

    public void setColumns(Collection<KanbanColumn> columns) {
        this.columns = columns;
    }
}
