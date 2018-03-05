package by.it.kozlov.project.java.controller;

import by.it.kozlov.project.java.entity.User;
import by.it.kozlov.project.java.dao.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandSignUp extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse resp) throws SQLException {
        if (!FormUtil.isPost(request)) {
            return null;
        }
        try {
            User user = new User(0,
                    FormUtil.getString(request.getParameter("Login"), "[A-Za-z0-9_@.]+"),
                    FormUtil.getString(request.getParameter("Email"), "([A-Za-z0-9_]*)[@a-z0-9_\\.]+"),
                    FormUtil.getString(request.getParameter("Password"), "[A-Za-z0-9_А-Яа-яЁё]+"),
                    Integer.parseInt(request.getParameter("City")),
                    FormUtil.getString(request.getParameter("Address"), "[A-Za-z0-9_А-Яа-яЁё -]+"),
                    FormUtil.getString(request.getParameter("PhoneNumber"), "[0-9+]*"),
                    2
            );

            DAO dao = DAO.getDAO();
            if (dao.user.create(user)) {
                request.setAttribute(Message.MESSAGE, "Пользователь зарегестрирован");
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                return Actions.LOGIN.command;
            } else {
                request.setAttribute(Message.MESSAGE, "Ошибка добавления пользователя");
                return Actions.SIGNUP.command;
            }
        } catch (ParseException e) {
            request.setAttribute(Message.MESSAGE, "Введены недопустимые символы");
            return Actions.SIGNUP.command;
        }
    }
}
