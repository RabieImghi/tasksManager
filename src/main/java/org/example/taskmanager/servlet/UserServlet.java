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
                    if(userService.deleteById(user.get()).isPresent()){
                        response.sendRedirect("Login");
                    }
                }
            }
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String id = request.getParameter("id");
        Long userId = Long.parseLong(id);
        Optional<User> userOptional =userService.getById(userId);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setEmail(email);
            user.setUsername(username);
            userService.update(user);
            request.setAttribute("user", user);
            dispatcher.forward(request,response);
        }else {
            dispatcher.forward(request,response);
        }



    }

}