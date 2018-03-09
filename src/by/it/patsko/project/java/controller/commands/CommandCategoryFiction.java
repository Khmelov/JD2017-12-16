package by.it.patsko.project.java.controller.commands;

import by.it.patsko.project.java.controller.Actions;
import by.it.patsko.project.java.controller.Msg;
import by.it.patsko.project.java.dao.beanDao.BookDAO;
import by.it.patsko.project.java.dao.beanDao.CategoryDAO;
import by.it.patsko.project.java.dao.beens.Book;
import by.it.patsko.project.java.dao.beens.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CommandCategoryFiction extends ActionCommand  {
    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        Category category = new CategoryDAO().read(2);
        List<Book> books = new BookDAO().getAll("WHERE category_id="+category.getId());



        req.setAttribute(Msg.FICTION_TABLE, findCategoryTable(category,books));
        return Actions.CATEGORYFICTION.command;
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
