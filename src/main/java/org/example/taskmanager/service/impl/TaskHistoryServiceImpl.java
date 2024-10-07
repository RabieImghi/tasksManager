package org.example.taskmanager.service.impl;

import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.TaskHistory;

import java.util.List;
import java.util.Optional;

public interface TaskHistoryServiceImpl {
    List<TaskHistory> getTaskHistoryByTaskId(Task task);
    Optional<TaskHistory> save(TaskHistory taskHistory);
}
