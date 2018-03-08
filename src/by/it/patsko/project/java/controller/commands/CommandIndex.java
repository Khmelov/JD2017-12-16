package by.it.patsko.project.java.controller.commands;

import by.it.patsko.project.java.controller.Actions;
import by.it.patsko.project.java.controller.Msg;
import by.it.patsko.project.java.dao.beanDao.CatalogDAO;
import by.it.patsko.project.java.dao.beanDao.CategoryDAO;
import by.it.patsko.project.java.dao.beens.Catalog;
import by.it.patsko.project.java.dao.beens.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CommandIndex extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {
        List<Catalog> catalogs = new CatalogDAO().getAll("");
        List<Category> categories = new CategoryDAO().getAll("");

        req.setAttribute(Msg.CATALOGS, catalogs);
        req.setAttribute(Msg.CATEGORIES, categories);
        return Actions.INDEX.command;
    }
}
