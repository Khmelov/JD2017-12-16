package by.it.karpeichyk.Project.java;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class FrontController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        process(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);

    }

    private  void process (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ActionFactory actionFactory = new ActionFactory();
        ActionCommand command = actionFactory.defineCommand(req);
        String viewJsp = null;
        try {
            viewJsp = command.execute(req);
        }catch (Exception e){
            req.setAttribute(Msg.ERROR,"FC:"+e.getMessage());
            viewJsp=Action.ERROR.jsp;
        }

        ServletContext servletContext=getServletContext();
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(viewJsp);
        dispatcher.forward(req,resp);
    }


    }
