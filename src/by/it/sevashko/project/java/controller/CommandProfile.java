package by.it.sevashko.project.java.controller;

import by.it.sevashko.project.java.dao.DAO;
import by.it.sevashko.project.java.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandProfile extends Action {

    @Override
    public Action execute(HttpServletRequest req) throws SQLException, ParseException {
        User user = FormUtil.getUser(req);
        if (user == null){
            return Actions.LOGIN.getCommand();
        }
        if (FormUtil.isPost(req)) {
            String login = FormUtil.checkValue(req.getParameter("login"), Patterns.Login);
            String password = FormUtil.checkValue(req.getParameter("password"), Patterns.PASSWORD);
            String name = FormUtil.checkValue(req.getParameter("name"), Patterns.NAME);
            String lastName = FormUtil.checkValue(req.getParameter("lastName"), Patterns.NAME);
            String email = FormUtil.checkValue(req.getParameter("email"), Patterns.EMAIL);
            user.setLogin(login);
            user.setPassword(password);
            user.setName(name);
            user.setLastName(lastName);
            user.setEmail(email);
            if (req.getParameter("Update") != null){
                DAO.getDAO().userDAO.update(user);
                req.setAttribute(Msg.MESSAGE, "Измененения сохранены");
            }
            else if (req.getParameter("Delete")!=null){
                DAO.getDAO().userDAO.delete(user);
                req.getSession().setAttribute(Msg.MESSAGE, "Пользователь удален");
                req.getSession().invalidate();
                return Actions.SIGNUP.command;
            }
        }
        return null;
    }
}
