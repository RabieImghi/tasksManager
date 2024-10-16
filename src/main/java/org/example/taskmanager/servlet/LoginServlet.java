package org.example.taskmanager.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.taskmanager.entity.Tage;
import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.TaskHistory;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.repository.TageRepository;
import org.example.taskmanager.repository.TaskHistoryRepository;
import org.example.taskmanager.repository.TaskRepository;
import org.example.taskmanager.repository.UserRepository;
import org.example.taskmanager.service.TageService;
import org.example.taskmanager.service.TaskHistoryService;
import org.example.taskmanager.service.TaskService;
import org.example.taskmanager.service.UserService;
import org.example.taskmanager.util.Manage;
import org.example.taskmanager.util.TaskStatus;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(name = "Login", value = "Login")
public class LoginServlet extends HttpServlet {
    UserService userService;
    TaskService taskService;
    TaskHistoryService taskHistoryService;
    TageService tageService;
    public void init() throws ServletException {
        this.userService = new UserService(new UserRepository());
        this.taskService = new TaskService(new TaskRepository());
        this.taskHistoryService = new TaskHistoryService(new TaskHistoryRepository());
        this.tageService = new TageService(new TageRepository());
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
                }else {
                    List<String> listTage = tageService.findAll().stream()
                            .map(Tage::getName).collect(Collectors.toList());
                    dashboard(request,response,user.get(),LocalDate.now().minusMonths(1),listTage);
                }
            }else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void dashboard(HttpServletRequest request,HttpServletResponse response,User user,LocalDate sDate,List<String> listTage)throws ServletException, IOException {
        TaskService taskService = new TaskService(new TaskRepository());
        TaskHistoryService taskHistoryService = new TaskHistoryService(new TaskHistoryRepository());
        TageService tageService = new TageService(new TageRepository());
        LocalDate endDate = LocalDate.now();
        List<Task> taskList = taskService.findAll().stream().sorted((a,b)->a.getId().compareTo(b.getId()))
                .filter(task -> task.getUser().getId().equals(user.getId()))
                .filter(task ->  !task.getCreationDate().isBefore(sDate) && !task.getCreationDate().isAfter(endDate))
                .filter(task -> task.getTages().stream().anyMatch(tag -> listTage.contains(tag.getName())))
                .collect(Collectors.toList());
        List<TaskHistory> taskHistoryList = taskHistoryService.getAllTaskHistory();
        long completedTask = taskList.stream().filter(task -> task.getIsCompleted().equals(TaskStatus.COMPLETED)).count();
        long canceledTask = taskList.stream().filter(task -> task.getIsCompleted().equals(TaskStatus.CANCELLED)).count();

        double prs = taskService.statManager(user,sDate,endDate,listTage);
        request.setAttribute("completionPercentage", prs);
        request.setAttribute("totalTask",taskList.size());
        request.setAttribute("completedTask",completedTask);
        request.setAttribute("canceledTask",canceledTask);
        request.setAttribute("totalToken",taskHistoryList.size());
        request.setAttribute("listTask", taskList);
        request.setAttribute("tagesList", tageService.findAll());
        request.setAttribute("endDate",endDate);
        request.setAttribute("sDate",sDate);
        request.setAttribute("listTage",listTage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/__ My-Task__ Dashboard.jsp");
        dispatcher.forward(request, response);
    }
}
