package org.example.taskmanager.service;

import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.repository.TaskRepository;
import org.example.taskmanager.repository.UserRepository;
import org.example.taskmanager.repository.impl.TaskRepositoryImpl;
import org.example.taskmanager.service.impl.TaskServiceImpl;
import org.example.taskmanager.util.TaskStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class TaskService implements TaskServiceImpl {
    private final TaskRepositoryImpl taskRepository;

    public TaskService(TaskRepositoryImpl taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Optional<Task> save(Task task) {
        return taskRepository.save(task);
    }
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }
    public Optional<Task> update(Task task) {
        return taskRepository.update(task);
    }
    public Optional<Task> delete(Task task) {
        return taskRepository.delete(task);
    }
    public double statManager(User manager, LocalDate startDate, LocalDate endDate, List<String> tags) {
        List<Task> tasks = taskRepository.statManager(manager, startDate, endDate, tags);
        long completedTasks = tasks.stream().filter(task -> task.getIsCompleted().equals(TaskStatus.COMPLETED)).count();
        return (completedTasks / (double) tasks.size()) * 100;
    }
}
