package by.it.akhmelev.project6.java.controller;

import by.it.akhmelev.project6.java.dao.DAO;
import by.it.akhmelev.project6.java.entity.Ad;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandIndex extends Action {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        List<Ad> ads = DAO.getDAO().adDAO.getAll("");
        req.setAttribute("ads",ads);
        return null;
    }
}
