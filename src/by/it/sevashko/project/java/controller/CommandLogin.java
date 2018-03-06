package by.it.sevashko.project.java.controller;

import by.it.sevashko.project.java.dao.DAO;
import by.it.sevashko.project.java.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CommandLogin extends Action {

    @Override
    public Action execute(HttpServletRequest req) throws ParseException, SQLException {
        if (!FormUtil.isPost(req)) return null;

        req.setAttribute(Msg.MESSAGE, "Проверка полей");
        String login = FormUtil.checkValue(req.getParameter("login"), Patterns.Login);
        String password = FormUtil.checkValue(req.getParameter("password"), Patterns.PASSWORD);

        req.setAttribute(Msg.MESSAGE, "Получаем DAO");
        DAO dao = DAO.getDAO();

        req.setAttribute(Msg.MESSAGE, "Поиск пользователя в базе");
        List<User> users = dao.userDAO.getALL(String.format(" WHERE login='%s' AND password='%s'", login, password));
        if(users.size() > 0){
            req.setAttribute(Msg.MESSAGE, "Вход выполнен");
            User user = users.get(0);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
        } else {
            req.setAttribute(Msg.MESSAGE, "Пользователь не найден");
        }
        return null;
    }
}
