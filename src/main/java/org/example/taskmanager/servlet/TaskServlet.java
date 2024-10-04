package org.example.taskmanager.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.service.TaskService;
import org.example.taskmanager.service.UserService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@WebServlet(name = "Task", value = "Task")
public class TaskServlet extends HttpServlet {
    UserService userService;
    TaskService taskService;

    @Override
    public void init() throws ServletException {
        this.userService = new UserService();
        this.taskService = new TaskService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("user", user);
        RequestDispatcher tasks = request.getRequestDispatcher("admin/__ My-Task__ Tickets.jsp");
        tasks.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String action = request.getParameter("actionType");
        switch (action){
            case "Add Task" : {
                request.setAttribute("userList", this.userService.getAll());
                request.setAttribute("user", user);

                RequestDispatcher tasks = request.getRequestDispatcher("admin/__ My-Task__ AddTickets.jsp");
                tasks.forward(request, response);
            }
            break;
            case "addTask" : {
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                LocalDate creationDate = LocalDate.parse(request.getParameter("creationDate"));
                LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
                String user_id = request.getParameter("user_id");
                String assignee = request.getParameter("assigneeTo_id");
                Long userCreatId = Long.parseLong(user_id);
                Long userAssigneeId = Long.parseLong(assignee);
                Optional<User> userCreat = userService.getById(userCreatId);
                Optional<User> userAssignee = userService.getById(userAssigneeId);
                Long daysBetween = ChronoUnit.DAYS.between(endDate,LocalDate.now());
                request.setAttribute("userList", this.userService.getAll());
                RequestDispatcher tasks = request.getRequestDispatcher("admin/__ My-Task__ AddTickets.jsp");
                if(creationDate.isAfter(endDate) || creationDate.isAfter(LocalDate.now()) ){
                    request.setAttribute("errorDate", "Invalid Start Date");
                    tasks.forward(request, response);
                }else if(daysBetween<=3){
                    request.setAttribute("errorDate", "Date must be 3 days before End Date");
                    tasks.forward(request, response);
                } else{
                    if(userCreat.isPresent() && userAssignee.isPresent()){
                        Task task = new Task(title,description,creationDate,endDate,false,false,userCreat.get(),userAssignee.get());
                        Optional<Task> task1= taskService.save(task);
                        task1.ifPresent(task2 -> {
                            try {
                                request.getRequestDispatcher("admin/__ My-Task__ AddTickets.jsp").forward(request,response);
                            } catch (ServletException e) {
                                throw new RuntimeException(e);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });

                    }
                }




            }
        }
    }
}
