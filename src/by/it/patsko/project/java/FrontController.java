package by.it.patsko.project.java;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;

public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);

    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute(Msg.BUYER,LogInBuyer.currentBuyer!=null?LogInBuyer.currentBuyer.getLogin():"");
        req.setAttribute(Msg.PROFILE_LOGIN,LogInBuyer.currentBuyer!=null?LogInBuyer.currentBuyer.getLogin():"");

        ActionFactory factory = new ActionFactory();
        ActionCommand command = factory.defineCommand(req);
        String viewJSP = null;
        try {
            viewJSP = command.execute(req);

        } catch (SQLException | ParseException | NullPointerException e) {
            req.setAttribute(Msg.ERROR,"FC:"+e.getMessage());
            req.setAttribute(Msg.ERROR_DETAILS,"<h5>details:</h5>"+ Arrays.toString(e.getStackTrace()));
            viewJSP=Actions.ERROR.jsp;
        }
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(viewJSP);
        requestDispatcher.forward(req, resp);

    }
}
