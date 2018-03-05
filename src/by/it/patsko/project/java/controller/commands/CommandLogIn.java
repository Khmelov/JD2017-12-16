package by.it.patsko.project.java.controller.commands;

import by.it.patsko.project.java.controller.*;
import by.it.patsko.project.java.dao.beanDao.BuyerDAO;
import by.it.patsko.project.java.dao.beens.Buyer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;

public class CommandLogIn extends ActionCommand {

    @Override
    public ActionCommand execute(HttpServletRequest req) throws ParseException, SQLException {
        HttpSession session = req.getSession();
        if (session.getAttribute(Msg.BUYER) != null) {
            CommandError.errorMassage = "Вы уже вошли на сайт";
            CommandError.errorDetails = "<h5>details:</h5>" + Arrays.toString(new Exception().getStackTrace());
            return Actions.ERROR.command;
        }
        if (!FormUtil.isPost(req)) return Actions.LOGIN.command;

        String testLogin = FormUtil.getString(req.getParameter("Login"), Pattern.LOGIN);
        String testPassword = FormUtil.getString(req.getParameter("Password"), Pattern.PASSWORD);
        try {
            Buyer buyer = new BuyerDAO().read(new BuyerDAO().read(testLogin, testPassword));
            session.setAttribute(Msg.BUYER, buyer);
            session.setMaxInactiveInterval(30);
            req.setAttribute(Msg.MESSAGE, "Залогинился пользователь" + buyer.getLogin());

            /*Cookie cookie1 = new Cookie("loginCookie", buyer.getLogin());
            Cookie cookie2 = new Cookie("passwordCookie", buyer.getPassword());
            cookie1.setMaxAge(60);
            cookie2.setMaxAge(60);*/

        } catch (NullPointerException e) {
            CommandError.errorMassage = "Такого пользователя не существует";
            CommandError.errorDetails = "<h5>details:</h5>" + Arrays.toString(e.getStackTrace());
            return Actions.ERROR.command;
        }
        return Actions.PROFILE.command;
    }
}
