package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.controller.Action;
import by.it.akhmelev.project8.java.controller.Actions;
import by.it.akhmelev.project8.java.controller.FormUtil;
import by.it.akhmelev.project8.java.dao.DAO;
import by.it.akhmelev.project8.java.entity.Ad;
import by.it.akhmelev.project8.java.entity.User;

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

        String where = String.format(" where fk_users='%d'", user.getId());
        List<Ad> ads = DAO.getDAO().adDAO.getAll(where);
        req.setAttribute("adsSize", ads.size());
        String strStart = req.getParameter("start");
        int startAd = 0;
        if (strStart != null)
            startAd = Integer.parseInt(strStart);
        where = String.format(" where fk_users='%d' LIMIT %d, 5", user.getId(), startAd);

        ads = DAO.getDAO().adDAO.getAll(where);
        req.setAttribute("ads", ads);
        return null;
    }
}
