package by.it.akhmelev.project6.java.controller;

import by.it.akhmelev.project6.java.dao.DAO;
import by.it.akhmelev.project6.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandLogin extends Action {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (!FormUtil.isPost(req))
            return null;
        String login =
                FormUtil.getString(req,"Login", ".+");
        String password =
                FormUtil.getString(req,"Password", ".+");
        DAO dao = DAO.getDAO();
        List<User> list = dao.userDAO.getAll(" where Login='" + login + "' and Password='" + password + "'");
        if (list.size() > 0) {
            req.setAttribute(Msg.MESSAGE, "пользователь " + login + " найден");
            HttpSession session = req.getSession();
            session.setAttribute("user",list.get(0));
            return null;
        } else {
            req.setAttribute(Msg.ERROR, "пользователь " + login + " НЕ найден");
            return Actions.LOGIN.command;
        }
    }
}
