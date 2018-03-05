package by.it.patsko.project.java.controller.commands;

import by.it.patsko.project.java.controller.Actions;
import by.it.patsko.project.java.controller.Msg;
import by.it.patsko.project.java.dao.beanDao.BookDAO;
import by.it.patsko.project.java.dao.beanDao.CategoryDAO;
import by.it.patsko.project.java.dao.beens.Book;
import by.it.patsko.project.java.dao.beens.Category;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Enumeration;
import java.util.List;

public class CommandCategoryCS extends ActionCommand  {
    @Override
    public ActionCommand execute(HttpServletRequest req) throws SQLException {
        Category category = new CategoryDAO().read(1);
        List<Book> books = new BookDAO().getAll("WHERE category_id="+category.getId());

        req.setAttribute(Msg.CS_TABLE, findCategoryTable(category,books));


        return Actions.CATEGORYCS.command;
    }
    private String findCategoryTable(Category category,List<Book> books) {
        StringBuilder sb = new StringBuilder();

            sb.append("<p><b>")
                    .append(category.getCategoryName())
                    .append("</p></b>");
            for (int i = 0; i < books.size(); i++) {
                sb.append(books.get(i).getAuthor())
                        .append(books.get(i).getName())
                        .append(books.get(i).getPrice())
                        .append("<a href=\"do?command=toBasket\" method=\"post\" class=\"btn btn-primary btn-lg active\" role=\"button\" aria-pressed=\"true\">в корзину</a>\n")
                .append("<br>");
            }
        return sb.toString();
    }
}
