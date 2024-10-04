package org.example.taskmanager.service.impl;

import org.example.taskmanager.entity.Task;

import java.util.Optional;

public interface TaskServiceImpl {
    public Optional<Task> save(Task task);
}
