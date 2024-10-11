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
import org.example.taskmanager.entity.User;
import org.example.taskmanager.service.TageService;
import org.example.taskmanager.service.TaskService;
import org.example.taskmanager.service.UserService;
import org.example.taskmanager.util.TaskStatus;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(name = "Task", value = "Task")
public class TaskServlet extends HttpServlet {
    UserService userService;
    TaskService taskService;
    TageService tageService;

    @Override
    public void init() throws ServletException {
        this.userService = new UserService();
        this.taskService = new TaskService();
        this.tageService = new TageService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
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
                        taskService.delete(task1).ifPresent(task2 -> {
                            try {
                                request.setAttribute("taskList", taskService.findAll());
                                request.getRequestDispatcher("admin/__ My-Task__ Tickets.jsp").forward(request,response);
                            } catch (ServletException | IOException e) {
                                throw new RuntimeException(e);
                            }
                        });



                    });
                }break;
                case "updateTask":{
                    Optional<Task> task= taskService.findById(id);
                    if(task.isPresent()) {
                        request.setAttribute("task", task.get());
                        request.setAttribute("userList",userService.getAll());
                        request.setAttribute("tagesList",tageService.findAll());
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String action = request.getParameter("actionType");
        switch (action){
            case "Add Task" : addTaskView(request,response,user);
            case "addTask" : addTask(request,response);
            case "updateTask" : updateTask(request,response);
        }
    }

    public void addTaskView(HttpServletRequest request, HttpServletResponse response,User user) throws ServletException, IOException{
        request.setAttribute("userList", this.userService.getAll());
        request.setAttribute("user", user);
        request.setAttribute("tagesList", tageService.findAll());
        RequestDispatcher tasks = request.getRequestDispatcher("admin/__ My-Task__ AddTickets.jsp");
        tasks.forward(request, response);
    }

    public void addTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Optional<Task> task = getTaskInfo(request,response,false);
        task.ifPresent(task1 -> {
            Optional<Task> taskSaved = taskService.save(task1);
            redirectToTasks(request, response, taskSaved);
        });
    }

    private void redirectToTasks(HttpServletRequest request, HttpServletResponse response, Optional<Task> taskUpdated)
    {
        taskUpdated.ifPresent(task2 -> {
            try {
                request.setAttribute("taskList", taskService.findAll());
                request.getRequestDispatcher("admin/__ My-Task__ Tickets.jsp").forward(request,response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void updateTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Optional<Task> task = getTaskInfo(request,response,true);
        task.ifPresent(task1 -> {
            Optional<Task> taskUpdated = taskService.update(task1);
            redirectToTasks(request, response, taskUpdated);
        });
    }

    public Optional<Task> getTaskInfo(HttpServletRequest request, HttpServletResponse response ,boolean isUpdate) throws ServletException, IOException
    {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        LocalDate creationDate = LocalDate.parse(request.getParameter("creationDate"));
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
        String user_id = request.getParameter("user_id");
        String assignee = request.getParameter("assigneeTo_id");
        String[] selectedTages = request.getParameterValues("tages[]");
        if(selectedTages.length<=1){
            request.setAttribute("errorDate", "Please select at least tow Tage");
            request.getRequestDispatcher("admin/__ My-Task__ AddTickets.jsp").forward(request, response);
        }
        List<Long> tagesId = Arrays.stream(selectedTages)
                .map(Long::parseLong)
                .collect(Collectors.toList());
        Long userCreatId = Long.parseLong(user_id);
        Long userAssigneeId = Long.parseLong(assignee);
        Optional<User> userCreat = userService.getById(userCreatId);
        Optional<User> userAssignee = userService.getById(userAssigneeId);
        List<Tage> listTage =new ArrayList<>();
        tagesId.forEach(tageId->{
            Optional<Tage> tage = tageService.findById(tageId);
            tage.ifPresent(listTage::add);
        });
        checkDateValidate(request,response,isUpdate,creationDate,endDate);
        if(!userCreat.isPresent() || !userAssignee.isPresent()){
            request.getRequestDispatcher("admin/__ My-Task__ AddTickets.jsp").forward(request, response);
        }
        if (isUpdate){
            String isCompleted = request.getParameter("isCompleted");

            Long idTask= Long.parseLong(request.getParameter("idTask"));
            Optional<Task> task = taskService.findById(idTask);
            if(task.isPresent()){
                if(TaskStatus.valueOf(isCompleted).equals(TaskStatus.COMPLETED)){
                    if(endDate.isAfter(LocalDate.now())){
                        request.setAttribute("task",task.get());
                        request.getRequestDispatcher("admin/__ My-Task__ EditTickets.jsp").forward(request, response);
                    }
                }else {
                    Task task1 =task.get();
                    task1.setTitle(title);
                    task1.setDescription(description);
                    task1.setCreationDate(creationDate);
                    task1.setEndDate(endDate);
                    task1.setUser(userCreat.get());
                    task1.setAssigneeTo(userAssignee.get());
                    task1.setTages(listTage);
                    task1.setIsCompleted(TaskStatus.valueOf(isCompleted));
                    return task;
                }

            } return Optional.empty();

        }else {
            Task task = new Task(title,description,creationDate,endDate, TaskStatus.EN_PROGRESS,false,userCreat.get(),userAssignee.get(),listTage,false);
            return Optional.of(task);
        }

    }
    public void checkDateValidate(HttpServletRequest request, HttpServletResponse response ,boolean isUpdate,LocalDate creationDate,LocalDate endDate) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(),creationDate);
        if(creationDate.isAfter(endDate)){
            request.setAttribute("errorDate", "Invalid Start Date ! start date should be before end date");
            addTaskView(request,response,user);
        }else if(daysBetween<=3){
            request.setAttribute("errorDate", "Invalid Start Date ! start date should be after after 3 day from today");
            addTaskView(request,response,user);
        }
    }

}
