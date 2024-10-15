package org.example.taskmanager.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.repository.UserRepository;
import org.example.taskmanager.service.UserService;
import org.example.taskmanager.util.Manage;

import java.io.IOException;

@WebServlet(name = "Register", value = "Register")
public class RegisterServlet extends HttpServlet {

    private UserService userService;

    public void init() throws ServletException {
        this.userService = new UserService(new UserRepository());
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(false);
        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String typeUser = request.getParameter("typeUser");
        String submitType = request.getParameter("submit");
        User user = new User(username,firstname,lastname, password,email, Manage.valueOf(typeUser));

        RequestDispatcher loginDispatcher = request.getRequestDispatcher("index.jsp");
        RequestDispatcher registerDispatcher = request.getRequestDispatcher("register.jsp");
        try {
            if (userService.register(user).isPresent()) {
                request.setAttribute("message","Register With success");
                if (submitType.equals("user")) loginDispatcher.forward(request, response);
                else {
                    request.setAttribute("userList", userService.getAll());
                    request.getRequestDispatcher("admin/__ My-Task__ Ourclients.jsp").forward(request,response);
                }
            } else {
                registerDispatcher.forward(request, response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
