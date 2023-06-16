package com.tasksrest.api.shared.domain.vo;

public class TasksFilters {
    private String name;
    private String desc;
    private Integer holderId;
    private TaskStatus status;
    private Pagination pagination;

    public TasksFilters(String name, String desc, Integer holderId, TaskStatus status, Pagination pagination) {
        this.name = name;
        this.desc = desc;
        this.holderId = holderId;
        this.status = status;
        this.pagination = pagination;
    }
    
    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public Integer getHolderId() {
        return this.holderId;
    }

    public TaskStatus getStatus() {
        return this.status;
    }

    public Pagination getPagination() {
        return this.pagination;
    }
}
