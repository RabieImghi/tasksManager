package org.example.taskmanager.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.taskmanager.entity.Tage;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.repository.TageRepository;
import org.example.taskmanager.repository.TaskHistoryRepository;
import org.example.taskmanager.repository.UserRepository;
import org.example.taskmanager.service.TageService;
import org.example.taskmanager.service.TaskHistoryService;
import org.example.taskmanager.service.UserService;
import org.example.taskmanager.util.Manage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(name = "User", value = "User")
public class UserServlet extends HttpServlet {
    UserService userService;
    TaskHistoryService taskHistoryService;
    TageService tageService;
    public void init() throws ServletException {
        userService = new UserService(new UserRepository());
        taskHistoryService = new TaskHistoryService(new TaskHistoryRepository());
        tageService = new TageService(new TageRepository());
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dashboard = request.getRequestDispatcher("admin/__ My-Task__ Dashboard.jsp");
        RequestDispatcher users = request.getRequestDispatcher("admin/__ My-Task__ Ourclients.jsp");
        RequestDispatcher editDispatcher = request.getRequestDispatcher("admin/__ My-Task__ EditClient.jsp");
        HttpSession session = request.getSession();
        String idParam = request.getParameter("id");
        String action = request.getParameter("action");
        String typeParam = request.getParameter("type");
        session.setAttribute("typeParam", typeParam);
        if(action.equals("update")){
            if (idParam != null) {
                Long id = Long.parseLong(idParam);
                Optional<User> user =userService.getById(id);
                if(user.isPresent()){
                    request.setAttribute("user", user.get());
                    request.setAttribute("userLogin", session.getAttribute("user"));
                    if(typeParam.equals("manager")) request.setAttribute("isManager", "true");
                    editDispatcher.forward(request, response);
                }
            }
            else {
                users.forward(request, response);
            }
        }else if(action.equals("delete")){
            if (idParam != null){
                Long id = Long.parseLong(idParam);
                Optional<User> user =userService.getById(id);
                if(user.isPresent()){
                    if(userService.deleteById(user.get()).isPresent()){
                        String type = request.getParameter("type");
                        if(type.equals("manager")){
                            request.setAttribute("userList",userService.getAll());
                            users.forward(request, response);
                        } else response.sendRedirect("Login");

                    }
                }
            }
        }else if(action.equals("dashboard")){
            List<String> listTage = tageService.findAll().stream()
                    .map(Tage::getName).collect(Collectors.toList());
            LoginServlet.dashboard(request,response,(User) session.getAttribute("user"), LocalDate.now().minusMonths(1),listTage);
        }else if(action.equals("users")){
            List<User> usersList= userService.getAll();
            request.setAttribute("userList", usersList);
            users.forward(request, response);
        } else if(action.equals("logout")){
            session.invalidate();
            response.sendRedirect("Login");
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
        response.setContentType("text/html");
        if(request.getParameter("action") != null && request.getParameter("action").equals("addUser")){
            RequestDispatcher tasks = request.getRequestDispatcher("admin/__ My-Task__ AddClient.jsp");
            tasks.forward(request, response);
        }else {
            String username = request.getParameter("username");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String typeUser = request.getParameter("typeUser");
            String id = request.getParameter("id");
            Long userId = Long.parseLong(id);
            String typeParam = session.getAttribute("typeParam").toString();
            Optional<User> userOptional =userService.getById(userId);
            if (userOptional.isPresent()){
                User user = userOptional.get();
                user.setFirstname(firstname);
                user.setLastname(lastname);
                user.setEmail(email);
                user.setUsername(username);
                user.setManage(Manage.valueOf(typeUser));
                userService.update(user);
                request.setAttribute("user", user);
                if(typeParam.equals("user")) dispatcher.forward(request,response);
                else {
                    request.setAttribute("userList", userService.getAll());
                    request.getRequestDispatcher("admin/__ My-Task__ Ourclients.jsp").forward(request,response);
                };
            }else {
                dispatcher.forward(request,response);
            }
        }





    }

}