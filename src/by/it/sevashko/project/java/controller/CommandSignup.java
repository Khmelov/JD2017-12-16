package by.it.sevashko.project.java.controller;

import by.it.sevashko.project.java.dao.DAO;
import by.it.sevashko.project.java.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandSignup extends Action {

    @Override
    public Action execute(HttpServletRequest req) throws ParseException, SQLException {
        if (!FormUtil.isPost(req)) return null;

        String login = FormUtil.checkValue(req.getParameter("login"), Patterns.Login);
        String password = FormUtil.checkValue(req.getParameter("password"), Patterns.PASSWORD);
        String name = FormUtil.checkValue(req.getParameter("name"), Patterns.NAME);
        String lastName = FormUtil.checkValue(req.getParameter("lastName"), Patterns.NAME);
        String email = FormUtil.checkValue(req.getParameter("email"), Patterns.EMAIL);

        req.setAttribute(Msg.MESSAGE, "Создание объекта пользователя");
        User user = new User(0, login, password, name, lastName, email, 1);

        req.setAttribute(Msg.MESSAGE, "Получаем DAO");
        DAO dao = DAO.getDAO();

        req.setAttribute(Msg.MESSAGE, "Запись пользователя в базу данных");
        dao.userDAO.create(user);

        if (user.getId()>0) {
            req.setAttribute(Msg.MESSAGE, "Пользователь создан");
            return Actions.LOGIN.getCommand();
        }
        else
        {
            req.setAttribute(Msg.MESSAGE,"Ошибка добавления пользователя");
            return null;
        }
    }
}
