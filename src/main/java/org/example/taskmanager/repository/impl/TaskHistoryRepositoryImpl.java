package org.example.taskmanager.repository.impl;

import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.TaskHistory;
import org.example.taskmanager.entity.User;

import java.util.List;
import java.util.Optional;

public interface TaskHistoryRepositoryImpl {
    List<TaskHistory> getTaskHistoryByTaskId(User user, String typeModification);
    Optional<TaskHistory> save(TaskHistory taskHistory);
    List<TaskHistory> findAll(User user);
    Optional<TaskHistory> findById(Long id);
    Optional<TaskHistory> update(TaskHistory taskHistory);
    List<TaskHistory> getAllTaskHistoryForChangeStatus(User user);
}
