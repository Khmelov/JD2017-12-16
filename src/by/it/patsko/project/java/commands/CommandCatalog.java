package by.it.patsko.project.java.commands;

import by.it.patsko.project.java.*;
import by.it.patsko.project.java.dao.beanDao.CatalogDAO;
import by.it.patsko.project.java.dao.beanDao.CategoryDAO;
import by.it.patsko.project.java.dao.beens.Catalog;
import by.it.patsko.project.java.dao.beens.Category;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.text.ParseException;
import java.util.List;

public class CommandCatalog implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) throws ParseException, SQLException {
        List<Catalog> catalogs = new CatalogDAO().getAll("");
        List<Category> categories = new CategoryDAO().getAll("");

        req.setAttribute(Msg.CATALOG_TABLE, findCatalogTable(catalogs, categories));
        return Actions.CATALOG.jsp;
    }


    private String findCatalogTable(List<Catalog> catalogs, List<Category> categories) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < catalogs.size(); i++) {
            sb.append("<p><b>")
                    .append(catalogs.get(i).getCatalogName())
                    .append("</p></b>")
                    .append("<table class=\"table\">\n" +
                            "          <thead>\n" +
                            "            <tr>\n" +
                            "              <th scope=\"col\">№</th>\n" +
                            "              <th scope=\"col\">Категория</th>\n" +
                            "            </tr>\n" +
                            "          </thead>")
                    .append("<tbody>\n");
            for (int j = 0; j < categories.size(); j++) {
                sb.append("<tr>\n" +
                        "              <td>")
                        .append(j + 1)
                        .append("</td>\n" +
                                "              <td><a  href=\"do?command=")
                        .append("category")
                        .append(categories.get(j).getCategoryName().toLowerCase())
                        .append("\">")
                        .append(categories.get(j).getCategoryName())
                        .append("</a></td>\n" +
                                "            </tr>");
            }
            sb.append("</tbody>\n" +
                    "        </table>");
        }
        return sb.toString();
    }
}
