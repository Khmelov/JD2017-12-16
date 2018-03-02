package by.it.krasutski.project.java.commands;

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
        try {
            process(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ActionFactory actionFactory=new ActionFactory();
        ActionCommand command=actionFactory.defineCommand(req);
        String viewJsp= null;
        try {
            viewJsp = command.execute(req);
        } catch (Exception e) {
            req.setAttribute(Msg.ERROR,"FC:"+e.getMessage());
            viewJsp=Actions.ERROR.jsp;
        }
        ServletContext servletContext=getServletContext();
        RequestDispatcher dispatcher=servletContext.getRequestDispatcher(viewJsp);
        dispatcher.forward(req,resp);
    }
}
