package by.it.kozlov.project.java.controller;

import by.it.kozlov.project.java.entity.User;
import by.it.kozlov.project.java.dao.dao.DAO;
import by.it.kozlov.project.java.filters.CookiesUser;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CommandLogin extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse resp) throws ParseException, SQLException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeyException {
        if (!FormUtil.isPost(request)) {
            return Actions.LOGIN.command;
        } else if (request.getParameter("Login").equals("")) {
            request.setAttribute(Message.MESSAGE, "Введите имя пользователя и пароль");
            return Actions.LOGIN.command;
        }
        String login = FormUtil.getString(request.getParameter("Login"), "[A-Za-z0-9_@.-]+");
        DAO dao = DAO.getDAO();
        List<User> users = dao.user.getAll(String.format("WHERE login='%s'", login));
        if (users.size() == 1) {
            User user = users.get(0);
            String password = FormUtil.getString(request.getParameter("Password"), "[A-Za-z0-9_А-Яа-яЁё]+");
            if (user.getPassword().equals(password)) {
                if (request.getParameter("Button").equals("Delete")) {
                    if (dao.user.delete(user)) {
                        request.setAttribute(Message.MESSAGE, "Пользователь удалён");
                        return Actions.LOGIN.command;
                    }
                    request.setAttribute(Message.MESSAGE, "Ошибка удаления пользователя");
                    return Actions.LOGIN.command;
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    session.setMaxInactiveInterval(30);
                    request.setAttribute(Message.MESSAGE, "Вы вошли");
                    CookiesUser.setCookie(resp, user);
                    return null;
                }
            } else {
                request.setAttribute(Message.MESSAGE, "Неверный пароль");
                return Actions.LOGIN.command;
            }
        } else if (users.size() == 0) {
            request.setAttribute(Message.MESSAGE, "Пользователя с таким именем не существует");
            return Actions.LOGIN.command;
        } else {                      //Убрать когда поле логин будет уникальным
            request.setAttribute(Message.MESSAGE, "Найдено больше одного пользователя");
            return Actions.LOGIN.command;
        }
    }
}
