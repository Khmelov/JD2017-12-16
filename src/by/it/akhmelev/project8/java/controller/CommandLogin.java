package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.dao.DAO;
import by.it.akhmelev.project8.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

class CommandLogin extends Action {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (!Util.isPost(req))
            return null;
        String login =
                Util.getString(req,"Login", ".+");
        String password =
                Util.getString(req,"Password", ".+");
        DAO dao = DAO.getDAO();
        List<User> list = dao.user.getAll(" where Login='" + login + "' and Password='" + password + "'");
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
