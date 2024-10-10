package org.example.taskmanager.util;

import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.TaskHistory;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.service.TaskHistoryService;
import org.example.taskmanager.service.TaskService;
import org.example.taskmanager.service.UserService;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public void update() {
        List<TaskHistory> taskList = taskHistoryService.getAllTaskHistoryForChangeStatus();
        taskList.forEach(taskHistory -> {
            LocalDateTime now = LocalDateTime.now();

            long secondsSinceModification = Duration.between(taskHistory.getModificationDate(), now).toSeconds();

            if (secondsSinceModification > 20) {
                Optional<User> userOptional = Optional.of(taskHistory.getTask().getAssigneeTo());
                userOptional.ifPresent(user -> {
                    if (Duration.between(taskHistory.getModificationDate(), now).toSeconds() >= 30) {
                        if (user.getToken() == 0) {
                            user.setToken(2);
                        } else {
                            user.setToken(user.getToken() * 2);
                        }
                        taskHistory.getTask().setChanged(true);
                    }
                    taskHistory.setApprove(true);
                    userService.update(user);
                    taskService.update(taskHistory.getTask());
                    taskHistoryService.update(taskHistory);
                });
            }
        });
    }

}
