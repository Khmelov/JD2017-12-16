package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.dao.DAO;
import by.it.akhmelev.project8.java.entity.Ad;
import by.it.akhmelev.project8.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CommandProfile extends Action {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findInSession(req, User.class);
        if (user == null)
            return Actions.LOGIN.command;
        //обновление данных пользователя
        if (Util.isPost(req)) {
            String login = Util.getString(req, "Login", ".+");
            String password = Util.getString(req, "Password", ".+");
            user.setLogin(login);
            //user.setEmail(email);
            user.setPassword(password);
            DAO.getDAO().user.update(user);
        }

        String where = String.format(" where fk_users='%d'", user.getId());
        List<Ad> ads = DAO.getDAO().ad.getAll(where);
        req.setAttribute("adsSize", ads.size());
        String strStart = req.getParameter("start");
        int startAd = 0;
        if (strStart != null)
            startAd = Integer.parseInt(strStart);
        where = String.format(" where fk_users='%d' LIMIT %d, 5", user.getId(), startAd);

        ads = DAO.getDAO().ad.getAll(where);
        req.setAttribute("ads", ads);
        return null;
    }
}
