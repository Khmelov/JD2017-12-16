package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.controller.Action;
import by.it.akhmelev.project8.java.controller.Actions;
import by.it.akhmelev.project8.java.controller.FormUtil;
import by.it.akhmelev.project8.java.controller.Msg;
import by.it.akhmelev.project8.java.dao.DAO;
import by.it.akhmelev.project8.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

class CommandLogin extends Action {
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
            return Actions.PROFILE.command;
        } else {
            req.setAttribute(Msg.ERROR, "пользователь " + login + " НЕ найден");
            return Actions.LOGIN.command;
        }
    }
}
