package controller;

import controller.command.*;
import model.service.EventService;
import model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Servlet extends HttpServlet {

    private HashMap<String, Command> commands = new HashMap<String, Command>();

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("loggedUsers", new HashSet<String>());

        commands.put("registration", new Registration(new UserService()));
        commands.put("login", new Login(new UserService()));

        commands.put("moderator", new Moderator());
        commands.put("speaker", new Speaker());
        commands.put("visitor", new Visitor());
        commands.put("logout", new Logout());
        commands.put("home", new Home());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        String path = req.getRequestURI();
        path = path.replaceAll(".*/app/", "");
        Command command = commands.getOrDefault(path, (r) -> "/login.jsp");

        //System.out.println(path);

        String page = command.execute(req);
        if (page.contains("redirect")) {
            resp.sendRedirect(page.replace("redirect:", ""));
            System.out.println(page.replace("redirect:", ""));
        } else {
            req.getRequestDispatcher(page).forward(req, resp);
        }
    }

}
