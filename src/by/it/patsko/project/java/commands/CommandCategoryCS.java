package by.it.patsko.project.java.commands;

import by.it.patsko.project.java.ActionCommand;
import by.it.patsko.project.java.Actions;
import by.it.patsko.project.java.Msg;
import by.it.patsko.project.java.dao.beanDao.BookDAO;
import by.it.patsko.project.java.dao.beanDao.CategoryDAO;
import by.it.patsko.project.java.dao.beens.Book;
import by.it.patsko.project.java.dao.beens.Category;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.List;

public class CommandCategoryCS implements ActionCommand  {
    @Override
    public String execute(HttpServletRequest req) throws SQLException {
        Category category = new CategoryDAO().read(1);
        List<Book> books = new BookDAO().getAll("WHERE category_id="+category.getId());



        req.setAttribute(Msg.CS_TABLE, findCategoryTable(category,books));
        return Actions.CATEGORYCS.jsp;
    }
    private String findCategoryTable(Category category,List<Book> books) {
        StringBuilder sb = new StringBuilder();

            sb.append("<p><b>")
                    .append(category.getCategoryName())
                    .append("</p></b>")
                    .append("<table class=\"table\">\n" +
                            "          <thead>\n" +
                            "            <tr>\n" +
                            "              <th scope=\"col\">Автор</th>\n" +
                            "              <th scope=\"col\">Название</th>\n" +
                            "              <th scope=\"col\">Цена</th>\n" +
                            "              <th scope=\"col\"></th>\n" +
                            "            </tr>\n" +
                            "          </thead>\n" +
                            "          <tbody>");
            for (int i = 0; i < books.size(); i++) {
                sb.append("<tr>\n" +
                        "              <td>")
                        .append(books.get(i).getAuthor())
                        .append("</td>\n" +
                                "              <td>")
                        .append(books.get(i).getName())
                        .append("</td>\n" +
                                "              <td>")
                        .append(books.get(i).getPrice())
                        .append("</td>\n" +
                                "              <td>\n" +
                                "                  <a href=\"do?command=toBasket\" method=\"post\" class=\"btn btn-primary btn-lg active\" role=\"button\" aria-pressed=\"true\">в корзину</a>\n" +
                                "              </td>\n" +
                                "            </tr>");
            }
            sb.append("</tbody>\n" +
                    "        </table>");
        return sb.toString();
    }
}
