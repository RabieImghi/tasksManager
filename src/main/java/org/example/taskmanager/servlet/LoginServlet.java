package org.example.taskmanager.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.TaskHistory;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.service.TaskHistoryService;
import org.example.taskmanager.service.TaskService;
import org.example.taskmanager.service.UserService;
import org.example.taskmanager.util.Manage;
import org.example.taskmanager.util.TaskStatus;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(name = "Login", value = "Login")
public class LoginServlet extends HttpServlet {
    UserService userService;
    TaskService taskService;
    TaskHistoryService taskHistoryService;
    public void init() throws ServletException {
        this.userService = new UserService();
        this.taskService = new TaskService();
        this.taskHistoryService = new TaskHistoryService();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        try {
            Optional<User> user = userService.login(username,password);
            if(user.isPresent()) {
                request.setAttribute("user", user.get());
                session.setAttribute("user", user.get());
                if(user.get().getManage().equals(Manage.USER)){
                    request.setAttribute("taskList", taskService.findAll() );
                    RequestDispatcher dispatcher = request.getRequestDispatcher("admin/__ My-Task__ Tickets.jsp");
                    dispatcher.forward(request, response);
                }else dashboard(request,response);
            }else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void dashboard(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        TaskService taskService = new TaskService();
        TaskHistoryService taskHistoryService = new TaskHistoryService();
        List<Task> taskList = taskService.findAll().stream().sorted((a,b)->a.getId().compareTo(b.getId())).collect(Collectors.toList());

        List<TaskHistory> taskHistoryList = taskHistoryService.getAllTaskHistory();
        long completedTask = taskList.stream().filter(task -> task.getIsCompleted().equals(TaskStatus.COMPLETED)).count();
        long canceledTask = taskList.stream().filter(task -> task.getIsCompleted().equals(TaskStatus.CANCELLED)).count();
        request.setAttribute("totalTask",taskList.size());
        request.setAttribute("completedTask",completedTask);
        request.setAttribute("canceledTask",canceledTask);
        request.setAttribute("totalToken",taskHistoryList.size());
        request.setAttribute("listTask", taskList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/__ My-Task__ Dashboard.jsp");
        dispatcher.forward(request, response);
    }
}
