package by.it.patsko.project.java.controller.commands;

import by.it.patsko.project.java.controller.*;
import by.it.patsko.project.java.dao.beanDao.BuyerDAO;
import by.it.patsko.project.java.dao.beens.Buyer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;

public class CommandProfile extends ActionCommand {

    @Override
    public ActionCommand execute(HttpServletRequest req) throws ParseException, SQLException {
        HttpSession session = req.getSession();
        Buyer buyer = (Buyer) session.getAttribute(Msg.BUYER);
        req.setAttribute(Msg.PROFILE_LOGIN, buyer.getLogin());
        req.setAttribute(Msg.PROFILE_PASSWORD, buyer.getPassword());

        if (FormUtil.isPost(req)) {
            String login = FormUtil.getString(req.getParameter("newLogin"), Pattern.LOGIN);
            if (login != null) {
                buyer.setLogin(login);
                new BuyerDAO().update(buyer);
                req.setAttribute(Msg.PROFILE_LOGIN, buyer.getLogin());
                session.setAttribute(Msg.BUYER, buyer);
                return Actions.PROFILE.command;
            } else req.setAttribute(Msg.MESSAGE, "login==null");

            String password = FormUtil.getString(req.getParameter("newPassword"), Pattern.PASSWORD);
            if (password != null) {
                buyer.setPassword(password);
                new BuyerDAO().update(buyer);
                req.setAttribute(Msg.PROFILE_PASSWORD, buyer.getPassword());
                session.setAttribute(Msg.BUYER, buyer);
                return Actions.PROFILE.command;
            } else req.setAttribute(Msg.MESSAGE, "password==null");
        }


        return Actions.PROFILE.command;
    }
}
