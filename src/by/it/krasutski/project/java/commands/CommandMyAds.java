package by.it.krasutski.project.java.commands;

import by.it.krasutski.project.java.entity.Ad;
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
        List<Ad> ads = DAO.getDAO().adDAO.getAll(
                "where users_ID='" + user.getID() + "'"
        );
        req.setAttribute("ads", ads);
        return null;
    }
}
