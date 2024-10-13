package org.example.taskmanager.repository.impl;

import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TaskRepositoryImpl {
    Optional<Task> save(Task task);
    List<Task> findAll();
    Optional<Task> findById(Long id);
    Optional<Task> update(Task task);
    Optional<Task> delete(Task task);
    List<Task> statManager(User manager, LocalDate startDate, LocalDate endDate, List<String> tags);
}
