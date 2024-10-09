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
import org.example.taskmanager.util.TokenScheduler;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "TaskHistoryServlet", urlPatterns = "taskHistory")
public class TaskHistoryServlet extends HttpServlet {

    TaskHistoryService taskHistoryService;
    TaskService taskService;
    UserService userService;

    public void init() {
        this.taskService = new TaskService();
        this.taskHistoryService = new TaskHistoryService();
        this.userService = new UserService();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "saveTaskHistory":
                    saveTaskHistory(request,response);
                    break;
                case "approve" : {
                    approveTask(request,response);
                    break;
                }
            }
        }
    }
    public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String actionPost = request.getParameter("action");
        if (actionPost != null) {
            switch (actionPost) {
                case "saveApprove":{
                    saveApprove(request,response);
                }
            }
        }
    }

    public void checkTaskIfExist(HttpServletRequest request,HttpServletResponse response,List<TaskHistory> taskHistoryList, Task task)
    {
        taskHistoryList.stream().forEach(taskHistory -> {
            if(task.getId() == taskHistory.getTask().getId()) {
                request.setAttribute("error", "You can't change the same task more than one time");
                request.setAttribute("taskList",taskService.findAll());
                RequestDispatcher taskDispatch = request.getRequestDispatcher("admin/__ My-Task__ Tickets.jsp");
                try {
                    taskDispatch.forward(request,response);
                } catch (ServletException | IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public void saveTaskHistory(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        String type = request.getParameter("type");
        String taskId = request.getParameter("id");
        Long id = Long.parseLong(taskId);
        LocalDate dateDemand = LocalDate.now();
        Optional<Task> task = taskService.findById(id);
        task.ifPresent(task1 -> {
            if(task1.isChanged()){
                String error = "You can't change task changed before ..";
                request.setAttribute("taskList", taskService.findAll());
                request.setAttribute("error",error);
                RequestDispatcher taskDispatch = request.getRequestDispatcher("admin/__ My-Task__ Tickets.jsp");
                try {
                    taskDispatch.forward(request,response);
                } catch (ServletException | IOException e) {
                    throw new RuntimeException(e);
                }
            }else {
                Optional<User> oldUser = userService.getById(task1.getAssigneeTo().getId());
                if(!oldUser.isPresent()) try {
                    throw new Exception("error");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                List<TaskHistory> getTaskHistory = taskHistoryService.getTaskHistoryByTaskId(oldUser.get(),type);
                checkTaskIfExist(request,response,getTaskHistory,task1);
                TaskHistory taskHistory = new TaskHistory(type,dateDemand,task1,oldUser.get(),false);
                try {
                    saveTaskHistoryChange(request,response,getTaskHistory,task1,taskHistory);
                } catch (ServletException | IOException e) {
                    throw new RuntimeException(e);
                }
            }

        });
    }
    public void saveTaskHistoryChange(HttpServletRequest request,HttpServletResponse response,List<TaskHistory> taskHistoryList, Task task, TaskHistory taskHistory) throws ServletException, IOException
    {
        String error = "";
        if(taskHistory.getTypeModification().equals("change")){
            boolean isSaved = save(request,response,taskHistoryList,taskHistory,task.getAssigneeTo().getToken(),task);
            if (!isSaved) error = "You can't change task more than tow for a day";
        }else{
            boolean isSaved = save(request,response,taskHistoryList,taskHistory,1,task);
            if (!isSaved) error = "You can't delete task more than one for a month";
        }
        request.setAttribute("taskList", taskService.findAll());
        request.setAttribute("error",error);
        RequestDispatcher taskDispatch = request.getRequestDispatcher("admin/__ My-Task__ Tickets.jsp");
        taskDispatch.forward(request,response);

    }
    public boolean save(HttpServletRequest request,HttpServletResponse response,List<TaskHistory> taskHistoryList,TaskHistory taskHistory,int size, Task task)
    {
        if(taskHistoryList.size()<size) {
            taskHistoryService.save(taskHistory).ifPresent(taskHistory1 -> {
                RequestDispatcher taskDispatch = request.getRequestDispatcher("admin/__ My-Task__ Tickets.jsp");
                try {
                   if(taskHistory.getTypeModification().equals("delete")){
                       task.setDeleted(true);
                       taskService.update(task);
                   }
                   request.setAttribute("taskList",taskService.findAll());
                   taskDispatch.forward(request,response);
                } catch (ServletException | IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return false;
    }

    public void approveTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<TaskHistory> ListTaskHistory = taskHistoryService.findAll(user);
        request.setAttribute("taskHistoryList",ListTaskHistory);
        request.setAttribute("userList", userService.getAll());
        request.setAttribute("taskList", taskService.findAll());
        RequestDispatcher taskDispatch = request.getRequestDispatcher("admin/__ My-Task__ ApproveChangeTickets.jsp");
        taskDispatch.forward(request,response);
    }

    public void saveApprove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Long taskId = Long.parseLong(request.getParameter("taskId"));
        Long newUser = Long.parseLong(request.getParameter("newUser"));
        boolean isNeedNewTask = Boolean.parseBoolean(request.getParameter("isNeedNewTask"));
        Long taskHistoryId = Long.parseLong(request.getParameter("taskHistoryId"));

        if(!isNeedNewTask){
            Optional<Task> task = taskService.findById(taskId);
            task.ifPresent(task1 -> {
                Optional<User> user = userService.getById(newUser);
                user.ifPresent(user1 -> {
                    task1.setAssigneeTo(user1);
                    task1.setChanged(true);
                    taskService.update(task1).ifPresent(task2 -> {
                        Optional<TaskHistory> taskHistory = taskHistoryService.findById(taskHistoryId);
                        taskHistory.ifPresent(taskHistory1 -> {
                            taskHistory1.setApprove(true);
                            taskHistoryService.update(taskHistory1);
                            try {
                                approveTask(request,response);
                            } catch (ServletException | IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    });
                });
            });
        }

    }

}
