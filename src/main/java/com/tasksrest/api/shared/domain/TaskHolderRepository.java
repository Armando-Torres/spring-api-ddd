package com.tasksrest.api.shared.domain;

import java.util.List;
import java.util.Optional;

public interface TaskHolderRepository {
    List<TaskHolder> findAll();

    Optional<TaskHolder> findById(Integer id);

    TaskHolder save(TaskHolder taskHolder);

    void delete(TaskHolder taskHolder);
}
