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
import java.util.Optional;

@WebServlet(name = "Login", value = "Login")
public class LoginServlet extends HttpServlet {
    UserService userService;
    public void init() throws ServletException {
        this.userService = new UserService();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Optional<User> user = userService.login(username,password);
            if(user.isPresent()) {
                request.setAttribute("user", user.get());
                RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
                dispatcher.forward(request, response);
            }else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
