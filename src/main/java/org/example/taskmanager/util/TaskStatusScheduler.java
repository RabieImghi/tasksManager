package org.example.taskmanager.util;

import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.TaskHistory;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.repository.TaskRepository;
import org.example.taskmanager.service.TaskHistoryService;
import org.example.taskmanager.service.TaskService;
import org.example.taskmanager.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TaskStatusScheduler {
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    private final TaskService taskService;

    public TaskStatusScheduler(){
        this.taskService = new TaskService(new TaskRepository());
    }

    public void start() {
        scheduler.scheduleAtFixedRate(this::update, 30,50, TimeUnit.MINUTES);
    }
    public void update(){
        List<Task> taskList = taskService.findAll();
        LocalDate dateNow = LocalDate.now();
        List<Task> filteredTask = taskList
                .stream()
                .filter(task -> task.getEndDate().isBefore(dateNow) && task.getIsCompleted().equals(TaskStatus.EN_PROGRESS))
                .collect(Collectors.toList());
        filteredTask.forEach(task ->  {
            task.setIsCompleted(TaskStatus.CANCELLED);
            taskService.update(task);
        });
    }
}
