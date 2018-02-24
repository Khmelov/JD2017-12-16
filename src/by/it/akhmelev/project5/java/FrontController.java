package by.it.akhmelev.project5.java;

import by.it.akhmelev.project5.java.ActionCommand;
import by.it.akhmelev.project5.java.ActionFactory;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    private void  process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ActionFactory actionFactory=new ActionFactory();
        ActionCommand command=actionFactory.defineCommand(req);
        String viewJsp=command.execute(req);

        ServletContext servletContext=getServletContext();
        RequestDispatcher dispatcher=servletContext.getRequestDispatcher(viewJsp);
        dispatcher.forward(req,resp);
    }
}
