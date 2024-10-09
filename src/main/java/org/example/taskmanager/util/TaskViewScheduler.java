package org.example.taskmanager.util;

import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.TaskHistory;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.service.TaskHistoryService;
import org.example.taskmanager.service.TaskService;
import org.example.taskmanager.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskViewScheduler {
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    private final TaskHistoryService taskHistoryService;
    private final TaskService taskService;
    private final UserService userService;

    public TaskViewScheduler(){
        this.taskService = new TaskService();
        this.taskHistoryService = new TaskHistoryService();
        this.userService = new UserService();
    }

    public void start() {
        scheduler.scheduleAtFixedRate(this::update, 0,20, TimeUnit.SECONDS);
    }
    public void update(){
        List<TaskHistory> taskList = taskHistoryService.getAllTaskHistoryForChangeStatus();
        taskList.forEach(task -> {
            Optional<User> userOptional = Optional.of(task.getTask().getAssigneeTo());
            userOptional.ifPresent(user -> {
                user.setToken(user.getToken()*2);
                task.getTask().setChanged(true);
                task.setApprove(true);
                userService.update(user);
                taskService.update(task.getTask());
            });
        });
    }
}
