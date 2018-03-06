package by.it.akhmelev.project7.java.controller;

import by.it.akhmelev.project7.java.controller.Action;
import by.it.akhmelev.project7.java.controller.Actions;
import by.it.akhmelev.project7.java.controller.FormUtil;
import by.it.akhmelev.project7.java.controller.Msg;
import by.it.akhmelev.project7.java.dao.DAO;
import by.it.akhmelev.project7.java.entity.User;

import javax.servlet.http.HttpServletRequest;

class CommandSignup extends Action {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (!FormUtil.isPost(req))
            return null;
        String login = FormUtil.getString(req, "Login", ".+");
        String email = FormUtil.getString(req, "Email", ".+");
        String password = FormUtil.getString(req, "Password", ".+");
        //по умолчанию администратор, но это нужно изменить
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
