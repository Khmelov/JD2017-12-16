package by.it.akhmelev.project6.java.controller;

import by.it.akhmelev.project6.java.dao.DAO;
import by.it.akhmelev.project6.java.entity.Ad;
import by.it.akhmelev.project6.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandProfile extends Action {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        Object o = session.getAttribute("user");
        User user;
        if (o!=null){
            user=(User)o;
        }
        else
            return Actions.LOGIN.command;
        List<Ad> ads = DAO.getDAO().adDAO.getAll(
                "where fk_users='"+user.getId()+"'"
        );
        req.setAttribute("ads",ads);
        return null;
    }
}
