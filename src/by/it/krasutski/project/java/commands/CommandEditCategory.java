package by.it.krasutski.project.java.commands;

import by.it.krasutski.project.java.dao.DAO;
import by.it.krasutski.project.java.entity.Ad;
import by.it.krasutski.project.java.entity.Category;
import by.it.krasutski.project.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandEditCategory extends Action {

    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if (FormUtil.isPost(req)) {
            Category category = new Category(FormUtil.getInt(req, "ID"),
                    FormUtil.getString(req, "Name", ".+"));
            if (req.getParameter("Update") != null) {
                DAO.getDAO().categoryDAO.update(category);
            } else if (req.getParameter("Delete") != null) {
                DAO.getDAO().categoryDAO.delete(category);
            }
        }
        List<Category> categories = DAO.getDAO().categoryDAO.getAll("");
        req.setAttribute("categories", categories);
        return null;
    }
}
