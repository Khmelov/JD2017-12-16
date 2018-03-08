package by.it.patsko.project.java.controller.commands;

import by.it.patsko.project.java.controller.Actions;
import by.it.patsko.project.java.controller.FormUtil;
import by.it.patsko.project.java.controller.Msg;
import by.it.patsko.project.java.dao.beanDao.BookDAO;
import by.it.patsko.project.java.dao.beanDao.CategoryDAO;
import by.it.patsko.project.java.dao.beanDao.DAO;
import by.it.patsko.project.java.dao.beens.Book;
import by.it.patsko.project.java.dao.beens.Buyer;
import by.it.patsko.project.java.dao.beens.Category;
import by.it.patsko.project.java.dao.beens.ListOfPurchases;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.Enumeration;
import java.util.List;

public class CommandCategoryCS extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (req.getParameter("toBasket") != null) {
            Buyer buyer = (Buyer) req.getSession().getAttribute(Msg.BUYER);
            if (buyer != null) {
                int bookId = FormUtil.getInt(req.getParameter("id"));
                ListOfPurchases list = new ListOfPurchases(0, buyer.getId(), bookId);
                DAO.getDAO().listOfPurchasesDAO.create(list);
            } else {
                CommandError.errorMassage = "Вы не залогинелись";
                CommandError.errorDetails = "";
                return Actions.ERROR.command;
            }
        }
        Category category = new CategoryDAO().read(1);
        List<Book> books = new BookDAO().getAll("WHERE category_id=" + category.getId());

        req.setAttribute(Msg.CATEGORIES, category);
        req.setAttribute(Msg.BOOKS_IN_CATEGORY, books);
        return null;
    }
}
