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
import org.example.taskmanager.util.TaskStatus;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
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
        if(request.getParameter("action")!=null) {
            String action = request.getParameter("action");
            String idTask = request.getParameter("id");
            Long id = Long.parseLong(idTask);
            switch (action){
                case "deleteTask":{
                    Optional<Task> task= taskService.findById(id);
                    task.ifPresent(task1 -> {

                    });
                }break;
                case "updateTask":{
                    Optional<Task> task= taskService.findById(id);
                    if(task.isPresent()) {
                        request.setAttribute("task", task.get());
                        request.setAttribute("userList",userService.getAll());
                        RequestDispatcher tasks = request.getRequestDispatcher("admin/__ My-Task__ EditTickets.jsp");
                        tasks.forward(request, response);
                    }
                }break;
            }
        }else {
            request.setAttribute("user", user);
            List<Task> taskList = taskService.findAll();
            request.setAttribute("taskList", taskList);
            RequestDispatcher tasks = request.getRequestDispatcher("admin/__ My-Task__ Tickets.jsp");
            tasks.forward(request, response);
        }

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
                request.setAttribute("tagsList", ;

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
                Long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(),endDate);
                request.setAttribute("userList", this.userService.getAll());
                RequestDispatcher tasks = request.getRequestDispatcher("admin/__ My-Task__ AddTickets.jsp");
                if(creationDate.isAfter(endDate)){
                    request.setAttribute("errorDate", "Invalid Start Date ! start date should be before end date");
                    tasks.forward(request, response);
                }else if(creationDate.isBefore(LocalDate.now()) ){
                    request.setAttribute("errorDate", "Invalid Start Date ! start date should be after or equal today");
                    tasks.forward(request, response);
                }else if(daysBetween<=3){
                    request.setAttribute("errorDate", "Date must be 3 days before End Date");
                    tasks.forward(request, response);
                } else{
                    if(userCreat.isPresent() && userAssignee.isPresent()){
                        Task task = new Task(title,description,creationDate,endDate, TaskStatus.EN_PROGRESS,false,userCreat.get(),userAssignee.get());
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
