package org.example.taskmanager.util;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class SchedulerContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        TaskViewScheduler taskViewScheduler = new TaskViewScheduler();
        TaskStatusScheduler taskStatusScheduler = new TaskStatusScheduler();
        taskViewScheduler.start();
        taskStatusScheduler.start();
    }
}

