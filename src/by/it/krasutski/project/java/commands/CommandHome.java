package by.it.krasutski.project.java.commands;

import by.it.krasutski.project.java.entity.Ad;
import by.it.krasutski.project.java.dao.DAO;
import by.it.krasutski.project.java.entity.Category;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandHome extends Action {

    @Override
    Action execute(HttpServletRequest req) throws Exception {
        List<Ad> ads = DAO.getDAO().adDAO.getAll("");
        List<Category> categories = DAO.getDAO().categoryDAO.getAll("");
        req.setAttribute("ads",ads);
        req.setAttribute("categories",categories);
        return null;
    }
}
