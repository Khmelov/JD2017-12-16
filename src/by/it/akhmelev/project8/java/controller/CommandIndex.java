package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.controller.Action;
import by.it.akhmelev.project8.java.dao.DAO;
import by.it.akhmelev.project8.java.entity.Ad;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CommandIndex extends Action {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        List<Ad> ads = DAO.getDAO().adDAO.getAll("");
        req.setAttribute("ads",ads);
        return null;
    }
}
