package org.example.taskmanager.util;

import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.TaskHistory;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.service.TaskHistoryService;
import org.example.taskmanager.service.TaskService;
import org.example.taskmanager.service.UserService;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


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
        scheduler.scheduleAtFixedRate(this::markUnapprovedTasks, 0, 60, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(this::processTokens, 0, 121, TimeUnit.SECONDS);
    }

    public void markUnapprovedTasks(){
        List<User> listUsers = userService.getAll();
        listUsers.forEach(user -> {
            taskHistoryService.findAll(user).stream()
                    .filter(taskHistory -> !taskHistory.isRequestStatusAccept())
                    .forEach(taskHistory -> {
                        Task task = taskHistory.getTask();
                        task.setChanged(true);
                        taskService.update(task);
                    });
        });
    }
    public void processTokens(){
        List<User> listUsers = userService.getAll();
        listUsers.forEach(user -> {
            AtomicInteger countTask = new AtomicInteger();
            taskHistoryService.getAllTaskHistoryForChangeStatus(user).stream()
                    .filter(taskHistory -> !taskHistory.isRequestStatusAccept() && taskHistory.getTask().isChanged())
                    .forEach(taskHistory -> {
                        taskHistory.setRequestStatusAccept(true);
                        taskHistoryService.update(taskHistory);
                        countTask.getAndIncrement();
                    });
            if(countTask.intValue() > 0) {
                user.setToken(4);
            } else user.setToken(2);
            userService.update(user);
        });
    }


    public void update() {
//        List<User> userList = userService.getAll();
//        userList.forEach(user -> {
//            List<TaskHistory> unapproveTaskHistoryList = taskHistoryService.findAll(user).stream()
//                    .filter(taskHistory -> !taskHistory.isApprove()).collect(Collectors.toList());
//            if(!unapproveTaskHistoryList.isEmpty()){
//
//            }
//
//        });


//        List<TaskHistory> taskList = taskHistoryService.getAllTaskHistoryForChangeStatus();
//        LocalDateTime now = LocalDateTime.now();
//        taskList.forEach(taskHistory -> {
//            User user = taskHistory.getTask().getAssigneeTo();
//            int numberTaskLastDay = (int) taskList.stream()
//                    .filter(taskHistory1 -> taskHistory1.getModificationDate().isAfter(now.minusSeconds(60))).count();
//            if (numberTaskLastDay > 1) {
//                user.setToken(numberTaskLastDay);
//            } else {
//                user.setToken(2);
//            }
//            userService.update(user);
//        });
//        taskList.stream().filter(taskHistory ->
//            !taskHistory.getTask().isChanged() && taskHistory.getTask().getEndDate().isBefore(LocalDate.now())
//        ).forEach(taskHistory -> {
//            User user = taskHistory.getTask().getAssigneeTo();
//
//            if(Duration.between(taskHistory.getModificationDate(), now).toSeconds() >= 30) {
//                if (user.getToken() == 0) {
//                    user.setToken(2);
//                } else {
//                    user.setToken(user.getToken() * 2);
//                }
//            }
//            taskHistory.getTask().setChanged(true);
//            taskHistory.setApprove(true);
//            userService.update(user);
//            taskService.update(taskHistory.getTask());
//            taskHistoryService.update(taskHistory);
//        });
    }

}
