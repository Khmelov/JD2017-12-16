package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.dao.DAO;
import by.it.akhmelev.project8.java.entity.User;

import javax.servlet.http.HttpServletRequest;

class CommandSignup extends Command {
    @Override
    public Command execute(HttpServletRequest req) throws Exception {
        if (!Util.isPost(req))
            return null;
        String login = Util.getString(req, "Login", ".+");
        String email = Util.getString(req, "Email", ".+");
        String password = Util.getString(req, "Password", ".+");
        //по умолчанию администратор, но это нужно изменить
        User user = new User(0, login, email, password, 1);
        DAO dao = DAO.getDAO();
        dao.user.create(user);
        if (user.getId() > 0)
            return Actions.LOGIN.command;
        else {
            req.setAttribute(Msg.MESSAGE, "Ошибка добавления пользователя");
            return null;
        }
    }
}
