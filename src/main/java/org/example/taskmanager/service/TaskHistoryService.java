package org.example.taskmanager.service;

import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.TaskHistory;
import org.example.taskmanager.repository.TaskHistoryRepository;
import org.example.taskmanager.service.impl.TaskHistoryServiceImpl;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;

public class TaskHistoryService implements TaskHistoryServiceImpl {
    TaskHistoryRepository taskHistoryRepository;
    public TaskHistoryService() {
        this.taskHistoryRepository = new TaskHistoryRepository();
    }

    public List<TaskHistory> getTaskHistoryByTaskId(Task task) {
        return taskHistoryRepository.getTaskHistoryByTaskId(task);
    }
    public Optional<TaskHistory> save(TaskHistory taskHistory) {
        return taskHistoryRepository.save(taskHistory);
    }
}
