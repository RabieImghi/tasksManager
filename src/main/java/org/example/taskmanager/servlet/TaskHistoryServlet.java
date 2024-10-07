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
        saveTaskHistory(request,response);
    }
    public void checkTaskIfExist(HttpServletRequest request,HttpServletResponse response,List<TaskHistory> taskHistoryList, Task task){
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
    public void saveTaskHistory(HttpServletRequest request,HttpServletResponse response){
        String type = request.getParameter("type");
        String taskId = request.getParameter("id");
        Long id = Long.parseLong(taskId);
        LocalDate dateDemand = LocalDate.now();
        Optional<Task> task = taskService.findById(id);
        task.ifPresent(task1 -> {
            List<TaskHistory> getTaskHistory = taskHistoryService.getTaskHistoryByTaskId(task1,type);
            checkTaskIfExist(request,response,getTaskHistory,task1);
            TaskHistory taskHistory = new TaskHistory(type,dateDemand,task1);
            try {
                saveTaskHistoryChange(request,response,getTaskHistory,task1,taskHistory);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


    public void saveTaskHistoryChange(HttpServletRequest request,HttpServletResponse response,List<TaskHistory> taskHistoryList, Task task, TaskHistory taskHistory) throws ServletException, IOException {
        String error = "";
        if(taskHistory.getTypeModification().equals("change")){
            boolean isSaved = save(request,response,taskHistoryList,taskHistory,task.getAssigneeTo().getToken());
            if (!isSaved) error = "You can't change task more than tow for a day";
        }else{
            boolean isSaved = save(request,response,taskHistoryList,taskHistory,1);
            if (!isSaved) error = "You can't delete task more than one for a month";
            else taskService.delete(taskHistory.getTask());
        }
        request.setAttribute("taskList", taskService.findAll());
        request.setAttribute("error",error);
        RequestDispatcher taskDispatch = request.getRequestDispatcher("admin/__ My-Task__ Tickets.jsp");
        taskDispatch.forward(request,response);

    }
    public boolean save(HttpServletRequest request,HttpServletResponse response,List<TaskHistory> taskHistoryList,TaskHistory taskHistory,int size){
        if(taskHistoryList.size()<size) {
            taskHistoryService.save(taskHistory).ifPresent(taskHistory1 -> {
                request.setAttribute("taskList",taskService.findAll());
                RequestDispatcher taskDispatch = request.getRequestDispatcher("admin/__ My-Task__ Tickets.jsp");
                try {
                    taskDispatch.forward(request,response);
                } catch (ServletException | IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return false;
    }

}
