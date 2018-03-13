package by.it.sevashko.project.java.controller;

import by.it.sevashko.project.java.dao.helpers.ResetDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class FrontController extends HttpServlet {

    @Override
    public void init(){
        try {
            ResetDB.main(null);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ActionFactory factory = new ActionFactory();
        Action command = factory.defineCommand(req);
        Action nextStep = null;
        ServletContext servletContext = getServletContext();
        try {
            nextStep = command.execute(req);
        } catch (Exception e) {
            req.setAttribute(Msg.ERROR,"FC:"+e.getMessage());
            String errorJsp = Actions.ERROR.getCommand().getJsp();
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher(errorJsp);
            dispatcher.forward(req, resp);
        }
        if (nextStep == null || nextStep == command){
            String viewJsp = command.getJsp();
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher(viewJsp);
            dispatcher.forward(req, resp);
        }
        else {
            resp.sendRedirect("do?command=" + nextStep);
        }
    }
}
