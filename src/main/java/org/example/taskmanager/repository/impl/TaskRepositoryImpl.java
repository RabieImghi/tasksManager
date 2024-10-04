package org.example.taskmanager.repository.impl;

import org.example.taskmanager.entity.Task;

import java.util.Optional;

public interface TaskRepositoryImpl {
    public Optional<Task> save(Task task);
}
