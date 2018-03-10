package by.it.patsko.project.java.controller.commands;

import by.it.patsko.project.java.controller.Actions;
import by.it.patsko.project.java.controller.FormUtil;
import by.it.patsko.project.java.controller.Msg;
import by.it.patsko.project.java.dao.beanDao.BookDAO;
import by.it.patsko.project.java.dao.beanDao.CategoryDAO;
import by.it.patsko.project.java.dao.beanDao.DAO;
import by.it.patsko.project.java.dao.beens.Book;
import by.it.patsko.project.java.dao.beens.Category;
import by.it.patsko.project.java.dao.beens.ListOfPurchases;
import by.it.patsko.project.java.dao.beens.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CommandCategory extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (req.getParameter("toBasket") != null) {
            User user = (User) req.getSession().getAttribute(Msg.USER);
            if (user != null) {
                int bookId = FormUtil.getInt(req.getParameter("bookToBasketId"));
                ListOfPurchases list = new ListOfPurchases(0, user.getId(), bookId);
                DAO.getDAO().listOfPurchasesDAO.create(list);
            } else {
                CommandError.errorMassage = "Вы не залогинелись";
                CommandError.errorDetails = "";
                return Actions.ERROR.command;
            }
        }
        Category category = new CategoryDAO().read(FormUtil.getInt(req.getParameter("categoryId")));
        List<Book> books = new BookDAO().getAll("WHERE category_id=" + category.getId());
        req.setAttribute("booksSize", books.size());
        String strStart = req.getParameter("start");
        int start = 0;
        if (strStart != null) {
            start = Integer.parseInt(strStart);

        }
        books = new BookDAO().getAll(
                String.format(" where category_id='%d' LIMIT %d, 10", category.getId(), start));

        req.setAttribute("category", category);
        req.setAttribute(Msg.BOOKS_IN_CATEGORY, books);
        return null;
    }
}
