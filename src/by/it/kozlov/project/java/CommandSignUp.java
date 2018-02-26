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
                Integer.parseInt(request.getParameter("00")),
                FormUtil.getString(request.getParameter("Login"), ".+"),
                FormUtil.getString(request.getParameter("Login"), ".+"),
                2
        );
        DAO dao = DAO.getDAO();
        dao.user.create(user);
        if (user.getId() > 0) {
            return Actions.INDEX.jsp;
        } else {
            request.setAttribute(Message.MESSAGE, "Ошибка добавления пользователя");
            return Actions.SIGNUP.jsp;
        }
    }
}
