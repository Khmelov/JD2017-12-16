package by.it.kozlov.project.java;

import by.it.kozlov.project.java.dao.beans.User;
import by.it.kozlov.project.java.dao.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws ParseException, SQLException {
        if (!FormUtil.isPost(request)) {
            return Actions.LOGIN.jsp;
        }
        String login = FormUtil.getString(request.getParameter("Login"), ".+");
        DAO dao = DAO.getDAO();
        List<User> users = dao.user.getAll(String.format("WHERE login='%s'", login));
        if (users.size() == 1) {
            User user = users.get(0);
            String password = FormUtil.getString(request.getParameter("Password"), ".+");
            if (user.getPassword().equals(password)) {
                request.setAttribute(Message.MESSAGE, "Пользователь найден");
                return Actions.LOGIN.jsp;
            } else {
                request.setAttribute(Message.MESSAGE, "Неверный пароль");
                return Actions.LOGIN.jsp;
            }
        } else if (users.size() == 0) {
            request.setAttribute(Message.MESSAGE, "Пользователя с таким именем не существует");
            return Actions.LOGIN.jsp;
        } else {                      //Убрать когда поле логин будет уникальным
            request.setAttribute(Message.MESSAGE, "Найдено больше одного пользователя");
            return Actions.LOGIN.jsp;
        }
    }
}
