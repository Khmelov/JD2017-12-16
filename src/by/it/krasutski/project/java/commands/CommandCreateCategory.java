package by.it.krasutski.project.java.commands;

import by.it.krasutski.project.java.dao.DAO;
import by.it.krasutski.project.java.entity.Ad;
import by.it.krasutski.project.java.entity.Category;
import by.it.krasutski.project.java.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

public class CommandCreateCategory extends Action {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (!FormUtil.isPost(req)) {
            return null;
        }
        Category category = new Category(0, FormUtil.getString(req,"Name",".+"));
        DAO.getDAO().categoryDAO.create(category);
        req.setAttribute(Msg.MESSAGE, "Category created");
        return null;
    }
}
