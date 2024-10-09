package org.example.taskmanager.util;

import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.TaskHistory;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.service.TaskHistoryService;
import org.example.taskmanager.service.TaskService;
import org.example.taskmanager.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TokenScheduler {
    private final ScheduledExecutorService sc = Executors.newScheduledThreadPool(1);

    public void startScheduler(){
        UserService userService = new UserService();
        TaskService taskService = new TaskService();
        TaskHistoryService taskHistoryService = new TaskHistoryService();
        List<TaskHistory> taskList = taskHistoryService.getAllTaskHistoryForChangeStatus();

        Runnable addTokenTask = ()->{

        };
        sc.scheduleAtFixedRate(addTokenTask,0,30, TimeUnit.SECONDS);
    }
    public void stopScheduler(){
        sc.shutdown();
    }
}
