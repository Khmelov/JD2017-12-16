package by.it.sevashko.project.java.controller;

import by.it.sevashko.project.java.dao.DAO;
import by.it.sevashko.project.java.entities.Publication;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CommandIndex extends Action {

    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        List<Publication> publications = DAO.getDAO().publicationDAO.getALL("");
        req.setAttribute("publications", publications);
        return null;
    }
}
