package by.it.krasutski.project.java.commands;

import by.it.krasutski.project.java.dao.DAO;
import by.it.krasutski.project.java.entity.Ad;
import by.it.krasutski.project.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandProfile extends Action {

    @Override
    Action execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        Object o = session.getAttribute("user");
        User user;
        if (o != null) {
            user = (User) o;
        } else
            return Actions.LOGIN.command;
        if (FormUtil.isPost(req)) {
            String login = FormUtil.getString(req, "Login", Patterns.LOGIN);
            String password = FormUtil.getString(req, "Password", Patterns.PASSWORD);
            String phoneNumber = FormUtil.getString(req, "PhoneNumber", Patterns.PHONENUMBER);
            user.setLogin(login);
            user.setPassword(password);
            user.setPhoneNumber(phoneNumber);
            DAO.getDAO().userDAO.update(user);
        }
        return null;
    }
}
