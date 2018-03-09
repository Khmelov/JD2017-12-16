package by.it.krasutski.project.java.commands;

import by.it.krasutski.project.java.entity.Ad;
import by.it.krasutski.project.java.entity.Category;
import by.it.krasutski.project.java.entity.User;
import by.it.krasutski.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

public class CommandCreateAd extends Action {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        Object o = session.getAttribute("user");
        User user;
        if (o != null) {
            user = (User) o;
        } else
            return Actions.LOGIN.command;
        if (!FormUtil.isPost(req)) {
            return null;
        }
        try {
            Ad ad = new Ad(0,
                    FormUtil.getString(req, "Title", ".+"),
                    FormUtil.getString(req, "SmallDesc", ".+"),
                    FormUtil.getString(req, "Description", ".+"),
                    FormUtil.getInt(req, "Price"),
                    user.getID(),
                    FormUtil.getInt(req,"category_ID")
            );
            DAO dao = DAO.getDAO();
            dao.adDAO.create(ad);
            if (ad.getID() > 0) {
                req.setAttribute(Msg.MESSAGE, "Ad created.");
                return Actions.MYADS.command;
            } else {
                req.setAttribute(Msg.ERROR, "Can't create ad.");
                return Actions.CREATEAD.command;
            }
        } catch (ParseException e) {
            req.setAttribute(Msg.MESSAGE, "Check your inputs.");
            return Actions.CREATEAD.command;
        }
    }
}
