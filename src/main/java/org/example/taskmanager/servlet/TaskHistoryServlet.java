package org.example.taskmanager.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.TaskHistory;
import org.example.taskmanager.service.TaskHistoryService;
import org.example.taskmanager.service.TaskService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "TaskHistoryServlet", urlPatterns = "taskHistory")
public class TaskHistoryServlet extends HttpServlet {

    TaskHistoryService taskHistoryService;
    TaskService taskService;

    public void init() {
        this.taskService = new TaskService();
        this.taskHistoryService = new TaskHistoryService();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String type = request.getParameter("type");
        String taskId = request.getParameter("taskId");
        Long id = Long.parseLong(taskId);
        LocalDate dateDemand = LocalDate.now();
        Optional<Task> task = taskService.findById(id);
        task.ifPresent(task1 -> {
            List<TaskHistory> getTaskHistory = taskHistoryService.getTaskHistoryByTaskId(task1);

            if(getTaskHistory.size() <2) {
                TaskHistory taskHistory = new TaskHistory(type, dateDemand, task1);
                taskHistoryService.save(taskHistory).ifPresent(taskHistory1 -> {
                    request.setAttribute("taskList",taskService.findAll());
                    RequestDispatcher taskDispatch = request.getRequestDispatcher("admin/__ My-Task__ Tickets.jsp");
                    try {
                        taskDispatch.forward(request,response);
                    } catch (ServletException | IOException e) {
                        throw new RuntimeException(e);
                    }
                });

            }else {
                request.setAttribute("error", "You can't change the status of this task more than once a day");
                request.setAttribute("taskList",taskService.findAll());
                RequestDispatcher taskDispatch = request.getRequestDispatcher("admin/__ My-Task__ Tickets.jsp");
            }

        });

    }



}
