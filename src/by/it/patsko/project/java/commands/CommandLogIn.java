package by.it.patsko.project.java.commands;

import by.it.patsko.project.java.*;
import by.it.patsko.project.java.dao.beanDao.BuyerDAO;
import by.it.patsko.project.java.dao.beens.Buyer;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;

public class CommandLogIn implements ActionCommand {

    @Override
    public String execute(HttpServletRequest req) throws SQLException {
        if (LogInBuyer.currentBuyer != null) {
            req.setAttribute(Msg.ERROR, "Вы уже вошли на сайт");
            req.setAttribute(Msg.ERROR_DETAILS, "<h5>details:</h5>" + Arrays.toString(new Exception().getStackTrace()));
            return Actions.ERROR.jsp;
        }
        if (!FormUtil.isPost(req)) return Actions.LOGIN.jsp;
        try {
            String testLogin = FormUtil.getString(req.getParameter("Login"), Pattern.LOGIN);
            String testPassword = FormUtil.getString(req.getParameter("Password"), Pattern.PASSWORD);
            Buyer buyer = new BuyerDAO().read(new BuyerDAO().read(testLogin, testPassword));
            LogInBuyer.getInstance(buyer);

            req.setAttribute(Msg.PROFILE_LOGIN, LogInBuyer.currentBuyer.getLogin());
            req.setAttribute(Msg.PROFILE_PASSWORD, LogInBuyer.currentBuyer.getPassword());

//            req.setAttribute(Msg.BUYER, LogInBuyer.currentBuyer.getLogin());

            req.setAttribute(Msg.MESSAGE, "Залогинился пользователь" + LogInBuyer.currentBuyer);
        } catch (NullPointerException e) {
            req.setAttribute(Msg.ERROR, "Такого пользователя не существует");
            req.setAttribute(Msg.ERROR_DETAILS, "<h5>details:</h5>" + Arrays.toString(e.getStackTrace()));
            return Actions.ERROR.jsp;
        }
        return Actions.PROFILE.jsp;
//        return null;
    }
}
