package by.it.krasutski.project.java.commands;

import by.it.krasutski.project.java.entity.User;
import by.it.krasutski.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class CommandSignUp extends Action {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (!FormUtil.isPost(req))
            return null;
        try {
            String login =
                    FormUtil.getString(req, "Login", Patterns.LOGIN);
            String email =
                    FormUtil.getString(req, "Email", Patterns.EMAIL);
            String password =
                    FormUtil.getString(req, "Password", Patterns.PASSWORD);
            String nickname =
                    FormUtil.getString(req, "Nickname", Patterns.NICKNAME);
            String phonenumber =
                    FormUtil.getString(req, "PhoneNumber", Patterns.PHONENUMBER);

            User user = new User(0, login, email, password, nickname, phonenumber, 2);
            DAO dao = DAO.getDAO();
            if (dao.userDAO.create(user)) {
                req.setAttribute(Msg.MESSAGE, "User" + login + "created.");
                return Actions.LOGIN.command;
            } else {
                req.setAttribute(Msg.MESSAGE, "Can't create user.");
                return Actions.SIGNUP.command;
            }
        } catch (ParseException e) {
            req.setAttribute(Msg.MESSAGE, "Check your inputs.");
            return Actions.SIGNUP.command;
        }
    }
}
