package org.example.taskmanager.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.service.UserService;

import java.io.IOException;
import java.nio.file.OpenOption;
import java.util.Optional;

@WebServlet(name = "User", value = "User")
public class UserServlet extends HttpServlet {
    UserService userService;
    public void init() throws ServletException {
        userService = new UserService();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
        RequestDispatcher editDispatcher = request.getRequestDispatcher("editUser.jsp");
        String idParam = request.getParameter("id");
        String action = request.getParameter("action");
        if(action.equals("update")){
            if (idParam != null) {
                Long id = Long.parseLong(idParam);
                Optional<User> user =userService.getById(id);
                if(user.isPresent()){
                    request.setAttribute("user", user.get());
                    editDispatcher.forward(request, response);
                }
            }
            else {
                dispatcher.forward(request, response);
            }
        }else if(action.equals("delete")){
            if (idParam != null){
                Long id = Long.parseLong(idParam);
                Optional<User> user =userService.getById(id);
                if(user.isPresent()){

                }
            }
        }

    }
}