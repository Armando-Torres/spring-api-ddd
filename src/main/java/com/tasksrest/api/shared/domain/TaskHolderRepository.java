package com.tasksrest.api.shared.domain;

import java.util.List;

public interface TaskHolderRepository {
    List<TaskHolder> findAll();

    TaskHolder findById(Integer id);

    TaskHolder save(TaskHolder taskHolder);

    void delete(TaskHolder taskHolder);
}
