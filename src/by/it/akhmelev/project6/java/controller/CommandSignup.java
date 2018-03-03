package by.it.akhmelev.project6.java.controller;

import by.it.akhmelev.project6.java.dao.DAO;
import by.it.akhmelev.project6.java.entity.User;

import javax.servlet.http.HttpServletRequest;

public class CommandSignup extends Action {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (!FormUtil.isPost(req))
            return null;
        String login = FormUtil.getString(req, "Login", ".+");
        String email = FormUtil.getString(req, "Email", ".+");
        String password = FormUtil.getString(req, "Password", ".+");
        User user = new User(0, login, email, password, 1);
        DAO dao = DAO.getDAO();
        dao.userDAO.create(user);
        if (user.getId() > 0)
            return Actions.LOGIN.command;
        else {
            req.setAttribute(Msg.MESSAGE, "Ошибка добавления пользователя");
            return null;
        }
    }
}
