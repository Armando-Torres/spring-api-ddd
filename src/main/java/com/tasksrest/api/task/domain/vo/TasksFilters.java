package com.tasksrest.api.task.domain.vo;

import com.tasksrest.api.shared.domain.vo.Pagination;

public class TasksFilters {
    private String name;
    private String desc;
    private Status status;
    private Pagination pagination;

    public TasksFilters(String name, String desc, Status status, Pagination pagination) {
        this.name = name;
        this.desc = desc;
        this.status = status;
        this.pagination = pagination;
    }
    
    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public Status getStatus() {
        return this.status;
    }

    public Pagination getPagination() {
        return this.pagination;
    }
}
