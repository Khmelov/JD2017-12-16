package by.it.patsko.project.java.controller.commands.crudCommands;

import by.it.patsko.project.java.controller.Actions;
import by.it.patsko.project.java.controller.FormUtil;
import by.it.patsko.project.java.controller.Msg;
import by.it.patsko.project.java.controller.Pattern;
import by.it.patsko.project.java.controller.commands.ActionCommand;
import by.it.patsko.project.java.controller.commands.CommandError;
import by.it.patsko.project.java.dao.beanDao.DAO;
import by.it.patsko.project.java.dao.beens.Book;
import by.it.patsko.project.java.dao.beens.Category;
import by.it.patsko.project.java.dao.beens.Role;
import by.it.patsko.project.java.dao.beens.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CommandCrudBooks extends ActionCommand {
    int chosenCategoryId;

    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        System.out.println(req.getParameter("choose_category_id"));
        System.out.println(req.getParameter("id"));
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("author"));
        System.out.println(req.getParameter("price"));
        System.out.println(req.getParameter("Category_id"));
        System.out.println(req.getParameter("Update"));
        System.out.println(req.getParameter("Delete"));
        System.out.println(req.getParameter("Create"));
        System.out.println("-----------------------------");

        if (FormUtil.isPost(req)) {
            if (req.getParameter("choose_category_id") != null)
                chosenCategoryId = FormUtil.getInt(req.getParameter("choose_category_id"));
            if (isCUD(req)) {
                int id = FormUtil.getInt(req.getParameter("id"));
                String name = FormUtil.getString(req.getParameter("name"));
                String author = FormUtil.getString(req.getParameter("author"));
                int price = FormUtil.getInt(req.getParameter("price"));
                int Category_id = FormUtil.getInt(req.getParameter("Category_id"));
                Book book = new Book(id, name, author, price, Category_id);
                if (req.getParameter("Update") != null) {
                    DAO.getDAO().bookDAO.update(book);
                } else if (req.getParameter("Delete") != null) {
                    DAO.getDAO().bookDAO.delete(book);
                } else if (req.getParameter("Create") != null) {
                    DAO.getDAO().bookDAO.create(book);
                }
            }
        }
        if (chosenCategoryId != 0) {
            List<Book> books = DAO.getDAO().bookDAO.getAll("WHERE Category_id=" + chosenCategoryId);
            req.setAttribute(Msg.BOOKS, books);
            req.setAttribute("choose_category_id", chosenCategoryId);
        }
        List<Category> categories = DAO.getDAO().categoryDAO.getAll("");
        req.setAttribute(Msg.CATEGORIES, categories);
        return Actions.CRUDBOOKS.command;
    }


    boolean isCUD(HttpServletRequest req) {
        return req.getParameter("Update") != null
                || req.getParameter("Delete") != null ||
                req.getParameter("Create") != null;
    }
}
