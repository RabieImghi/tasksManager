package org.example.taskmanager.servlet;

import jakarta.persistence.Persistence;
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
import org.example.taskmanager.service.TageService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "Tag", value = "Tag")
public class TageServlet extends HttpServlet {
    private TageService tageService;

    public void init() throws ServletException {
        this.tageService =new TageService(new TageRepository());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        tagePage(request,response);
    }
    public void tagePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        RequestDispatcher tagPage = request.getRequestDispatcher("admin/__ My-Task__ Tags.jsp");
        List<Tage> tageList = tageService.findAll();
        request.setAttribute("user",user);
        request.setAttribute("tageList", tageList);
        tagPage.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "Add Tag" : save(request,response);
            case "Delete"  : delete(request,response);
            case "Update"  : update(request,response);
        }
    }
    public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        String name = request.getParameter("name");
        tageService.findByName(name).ifPresent(tage -> {
            request.setAttribute("error","Tage Already Exist");
            try {
                request.getRequestDispatcher("admin/__ My-Task__ Tags.jsp").forward(request,response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        });
        Tage tage = new Tage(name);
        tageService.save(tage).ifPresent(tage1 -> {
            try {
                tagePage(request,response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        Long id =  Long.parseLong(request.getParameter("tagId"));
        tageService.findById(id).flatMap(tage -> tageService.delete(tage)).ifPresent(tage1 -> {
            try {
                tagePage(request, response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        Long id =  Long.parseLong(request.getParameter("tagId"));
        String name = request.getParameter("name");
        tageService.findById(id).ifPresent(tage -> {
            tage.setName(name);
            tageService.update(tage).ifPresent(tage1 ->  {
                try {
                    tagePage(request,response);
                } catch (ServletException | IOException e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }
}
