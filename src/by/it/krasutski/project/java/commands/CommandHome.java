package by.it.krasutski.project.java.commands;

import by.it.krasutski.project.java.entity.Ad;
import by.it.krasutski.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandHome extends Action {

    @Override
    Action execute(HttpServletRequest req) throws Exception {
        List<Ad> ads = DAO.getDAO().adDAO.getAll("");
        req.setAttribute("ads",ads);
        return null;
    }
}
