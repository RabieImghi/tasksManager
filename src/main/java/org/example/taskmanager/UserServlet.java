package org.example.taskmanager;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello User!";
        try {
            // Initialize the EntityManagerFactory
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("myJPAUnit");
            message = "Connected to the database successfully!";
        } catch (Exception e) {
            // Handle the exception
            message = "Error connecting to the database: " + e.getMessage();
        }
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
    }

        public void destroy() {
    }
}