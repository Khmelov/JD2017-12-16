package by.it.krasutski.project.java.commands;

import by.it.krasutski.project.java.entity.Ad;
import by.it.krasutski.project.java.entity.Category;
import by.it.krasutski.project.java.entity.User;
import by.it.krasutski.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandMyAds extends Action {

    @Override
    Action execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        Object o = session.getAttribute("user");
        User user;
        if (o != null) {
            user = (User) o;
        } else
            return Actions.LOGIN.command;
        if (FormUtil.isPost(req)) {
            int id = FormUtil.getInt(req, "ID");
            String title = FormUtil.getString(req, "Title", ".+");
            String smalldesc = FormUtil.getString(req, "SmallDesc", ".+");
            String description = FormUtil.getString(req, "Description", ".+");
            int price = FormUtil.getInt(req, "Price");
            int category = FormUtil.getInt(req, "category_ID");
            Ad ad = new Ad(id, title, smalldesc, description, price, user.getID(), category);
            if (req.getParameter("Update") != null) {
                DAO.getDAO().adDAO.update(ad);
            } else if (req.getParameter("Delete") != null) {
                DAO.getDAO().adDAO.delete(ad);
            }
        }
        List<Ad> ads = DAO.getDAO().adDAO.getAll("where users_ID='" + user.getID() + "'");
        req.setAttribute("adsSize", ads.size());
        String strStart = req.getParameter("ads");
        int startAd = 0;
        if (strStart != null)
            startAd = Integer.parseInt(strStart);
        String where = String.format(" where users_ID='%d' LIMIT %d, 3", user.getID(), startAd);
        ads = DAO.getDAO().adDAO.getAll(where);
        req.setAttribute("ads", ads);
        List<Category> categories = DAO.getDAO().categoryDAO.getAll("");
        req.setAttribute("categories", categories);
        return null;
    }
}
