package by.it.krasutski.project.java.commands;

import by.it.krasutski.project.java.entity.User;
import by.it.krasutski.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandLogin extends Action {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (!FormUtil.isPost(req))
            return null;
        String login =
                FormUtil.getString(req, "Login", Patterns.LOGIN);
        String password =
                FormUtil.getString(req, "Password", Patterns.PASSWORD);
        DAO dao = DAO.getDAO();
        List<User> list = dao.userDAO.getAll(" where Login='" + login + "' and Password='" + password + "'");
        if (list.size() > 0) {
            req.setAttribute(Msg.MESSAGE, "user " + login + " exists.");
            HttpSession session = req.getSession();
            session.setAttribute("user", list.get(0));
            return null;
        } else
            req.setAttribute(Msg.ERROR, "user " + login + " not exists.");

        return Actions.LOGIN.command;
    }
}
