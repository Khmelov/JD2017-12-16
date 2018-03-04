package by.it.patsko.project.java.commands;

import by.it.patsko.project.java.*;
import by.it.patsko.project.java.dao.beanDao.BuyerDAO;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;

public class CommandProfile implements ActionCommand {

    @Override
    public String execute(HttpServletRequest req) throws SQLException, ParseException {
        req.setAttribute(Msg.PROFILE_LOGIN, LogInBuyer.currentBuyer.getLogin());
        req.setAttribute(Msg.PROFILE_PASSWORD, LogInBuyer.currentBuyer.getPassword());
        if (FormUtil.isPost(req)) {
            String login = FormUtil.getString(req.getParameter("newLogin"), Pattern.LOGIN);
            if (login != null) {
                    LogInBuyer.currentBuyer.setLogin(login);
                    new BuyerDAO().update(LogInBuyer.currentBuyer);
                    req.setAttribute(Msg.PROFILE_LOGIN, LogInBuyer.currentBuyer.getLogin());

//                    req.setAttribute(Msg.MESSAGE, "Новый логин " + login);
//                req.setAttribute(Msg.ERROR_DETAILS, "<h5>details:</h5>" + Arrays.toString(new Exception().getStackTrace()));
                    return Actions.PROFILE.jsp;
                } else req.setAttribute(Msg.MESSAGE, "login==null");


            String password = FormUtil.getString(req.getParameter("newPassword"), Pattern.PASSWORD);
            if (password != null) {
                LogInBuyer.currentBuyer.setPassword(password);
                new BuyerDAO().update(LogInBuyer.currentBuyer);
                req.setAttribute(Msg.PROFILE_PASSWORD, LogInBuyer.currentBuyer.getPassword());

//                req.setAttribute(Msg.MESSAGE, "Новый пароль " + password);

//                req.setAttribute(Msg.ERROR_DETAILS, "<h5>details:</h5>" + Arrays.toString(new Exception().getStackTrace()));
                return Actions.PROFILE.jsp;
            } else req.setAttribute(Msg.MESSAGE, "password==null");
        }

        return Actions.PROFILE.jsp;
    }
}
