package by.it.akhmelev.project7.java.controller;

import by.it.akhmelev.project7.java.controller.Action;
import by.it.akhmelev.project7.java.controller.Actions;
import by.it.akhmelev.project7.java.dao.DAO;
import by.it.akhmelev.project7.java.entity.Ad;
import by.it.akhmelev.project7.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

class CommandProfile extends Action {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        Object o = session.getAttribute("user");
        User user;
        if (o != null) {
            user = (User) o;
        } else
            return Actions.LOGIN.command;
        //обновление данных пользователя
        if (FormUtil.isPost(req)) {
            String login = FormUtil.getString(req, "Login", ".+");
            String password = FormUtil.getString(req, "Password", ".+");
            user.setLogin(login);
            //user.setEmail(email);
            user.setPassword(password);
            DAO.getDAO().userDAO.update(user);
        }


        List<Ad> ads = DAO.getDAO().adDAO.getAll(
                "where fk_users='" + user.getId() + "'"
        );
        req.setAttribute("ads", ads);
        return null;
    }
}
