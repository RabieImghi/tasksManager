package org.example.taskmanager.service;

import org.example.taskmanager.entity.Task;
import org.example.taskmanager.repository.TaskRepository;
import org.example.taskmanager.repository.UserRepository;
import org.example.taskmanager.repository.impl.TaskRepositoryImpl;
import org.example.taskmanager.service.impl.TaskServiceImpl;

import java.util.Optional;

public class TaskService implements TaskServiceImpl {
    private final TaskRepositoryImpl taskRepository;

    public TaskService() {
        this.taskRepository = new TaskRepository();
    }

    public Optional<Task> save(Task task) {
        return taskRepository.save(task);
    }
}
