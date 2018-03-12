package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.dao.DAO;
import by.it.akhmelev.project8.java.entity.Ad;
import by.it.akhmelev.project8.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CommandProfile extends Command {
    @Override
    Command execute(HttpServletRequest req) throws Exception {
        User user = Util.findInSession(req, "user");
        if (user == null)
            return Actions.LOGIN.command;
        //обновление данных пользователя
        if (Util.isPost(req)) {
            String login = Util.frmString(req, "Login", ".+");
            String password = Util.frmString(req, "Password", ".+");
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
