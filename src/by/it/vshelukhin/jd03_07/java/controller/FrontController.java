package by.it.vshelukhin.jd03_07.java.controller;

import by.it.vshelukhin.jd03_07.java.controller.Action;
import by.it.vshelukhin.jd03_07.java.controller.ActionFactory;
import by.it.vshelukhin.jd03_07.java.controller.Actions;
import by.it.vshelukhin.jd03_07.java.controller.Msg;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    protected void process (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ActionFactory factory = new ActionFactory();
        Action command = factory.getActionCommand(req);
        Action nextStep = null;
        ServletContext servletContext = getServletContext();
        try {
            nextStep = command.execute(req);
        } catch (Exception e) {
            req.setAttribute(Msg.ERROR, "FC:" + e.getMessage());
            String errorJsp = Actions.ERROR.actionCommand.getJsp();
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher(errorJsp);
        }

        if (nextStep == null || nextStep==command) //конец, показать jsp
        {
            String viewJsp = command.getJsp();
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher(viewJsp);
            dispatcher.forward(req, resp);
        }
        else //redirect
        {
            resp.sendRedirect("do?command="+nextStep);
        }
    }
}
