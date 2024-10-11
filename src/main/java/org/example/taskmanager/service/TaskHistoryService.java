package org.example.taskmanager.service;

import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.TaskHistory;
import org.example.taskmanager.entity.User;
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

    public List<TaskHistory> getTaskHistoryByTaskId(User user, String typeModification) {
        return taskHistoryRepository.getTaskHistoryByTaskId(user, typeModification);
    }
    public Optional<TaskHistory> save(TaskHistory taskHistory) {
        return taskHistoryRepository.save(taskHistory);
    }
    public List<TaskHistory> findAll(User user) {
        return taskHistoryRepository.findAll(user);
    }
    public Optional<TaskHistory> findById(Long id){
        return taskHistoryRepository.findById(id);
    }
    public Optional<TaskHistory> update(TaskHistory taskHistory){
        return taskHistoryRepository.update(taskHistory);
    }
    public List<TaskHistory> getAllTaskHistoryForChangeStatus(User user){
        return taskHistoryRepository.getAllTaskHistoryForChangeStatus(user);
    }
    public List<TaskHistory> getAllTaskHistory(){
        return taskHistoryRepository.getAllTaskHistory();
    }
}
