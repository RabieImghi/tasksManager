package org.example.taskmanager.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.service.UserService;
import org.example.taskmanager.util.Manage;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Register", value = "Register")
public class RegisterServlet extends HttpServlet {

    private UserService userService;

    public void init() throws ServletException {
        this.userService = new UserService();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(username, email, password, Manage.USER);


        try {
            if (userService.register(user)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
