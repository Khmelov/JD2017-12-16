package by.it.krasutski.project.java.commands;

import by.it.krasutski.project.java.dao.beans.User;
import by.it.krasutski.project.java.dao.beansDAO.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) throws Exception {
        if (FormUtil.isPost(req))
            return Actions.LOGIN.jsp;
        String login =
                FormUtil.getString(req.getParameter("Login"), Patterns.LOGIN);
        String password =
                FormUtil.getString(req.getParameter("Password"), Patterns.PASSWORD);
        DAO dao = DAO.getDAO();
        List<User> list = dao.userDAO.getAll(" where Login='" + login + "' and Password='" + password + "'");
        if (list.size() > 0)
            req.setAttribute(Msg.MESSAGE, "user " + login + " exists.");
        else
            req.setAttribute(Msg.ERROR, "user " + login + " not exists.");

        return Actions.LOGIN.jsp;
    }
}
