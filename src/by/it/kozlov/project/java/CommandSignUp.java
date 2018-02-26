package by.it.kozlov.project.java;

import by.it.kozlov.project.java.dao.beans.User;
import by.it.kozlov.project.java.dao.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandSignUp implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws ParseException, SQLException {
        if (!FormUtil.isPost(request)) {
            return Actions.SIGNUP.jsp;
        }
        User user = new User(0,
                FormUtil.getString(request.getParameter("Login"), ".+"),
                FormUtil.getString(request.getParameter("Email"), ".+"),
                FormUtil.getString(request.getParameter("Password"), ".+"),
                Integer.parseInt(request.getParameter("City")),
                FormUtil.getString(request.getParameter("Address"), ".+"),
                FormUtil.getString(request.getParameter("PhoneNumber"), ".+"),
                2
        );
        DAO dao = DAO.getDAO();
        if (dao.user.create(user)) {
            return Actions.LOGIN.jsp;
        } else {
            request.setAttribute(Message.MESSAGE, "Ошибка добавления пользователя");
            return Actions.SIGNUP.jsp;
        }
    }
}
