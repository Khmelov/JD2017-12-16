package by.it.sendetskaya.project.java.controller;

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
            process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
            process(req,resp);
    }

    private void process (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ActionFactory actionFactory=new ActionFactory();
        Action command = actionFactory.defineCommand(req);
        Action nextStep=null;
        ServletContext servletContext=getServletContext();

        try {
            nextStep = command.execute(req,resp);
        } catch (Exception e) {
            req.setAttribute(Msg.ERROR,"Ошибка:"+e.getMessage());
            String errorJsp=Actions.ERROR.command.getJsp();
            RequestDispatcher dispatcher=servletContext.getRequestDispatcher(errorJsp);
        }
        if(nextStep==null||nextStep==command)
        {
            String viewJsp=command.getJsp();
            RequestDispatcher dispatcher=servletContext.getRequestDispatcher(viewJsp);
            dispatcher.forward(req,resp);
        }
        else //redirect
        {
            resp.sendRedirect("do?command="+nextStep);
        }

    }
}
