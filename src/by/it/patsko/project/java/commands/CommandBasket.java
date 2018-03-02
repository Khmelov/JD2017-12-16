package by.it.patsko.project.java.commands;

import by.it.patsko.project.java.ActionCommand;
import by.it.patsko.project.java.Actions;
import by.it.patsko.project.java.LogInBuyer;
import by.it.patsko.project.java.Msg;
import by.it.patsko.project.java.dao.beanDao.BookDAO;
import by.it.patsko.project.java.dao.beanDao.DAO;
import by.it.patsko.project.java.dao.beanDao.ListOfPurchasesDAO;
import by.it.patsko.project.java.dao.beens.Book;
import by.it.patsko.project.java.dao.beens.Buyer;
import by.it.patsko.project.java.dao.beens.ListOfPurchases;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CommandBasket implements ActionCommand  {
    @Override
    public String execute(HttpServletRequest req) throws SQLException {
        List<ListOfPurchases> purchasesList =
                new ListOfPurchasesDAO().getAll("WHERE Buyers_id=" + LogInBuyer.currentBuyer.getId());



        req.setAttribute(Msg.PURCHASES_TABLE, findPurchases(purchasesList));
        return Actions.BASKET.jsp;
    }
    private String findPurchases(List<ListOfPurchases> purchasesList) throws SQLException {

        StringBuilder sb = new StringBuilder();

        sb.append("<p><b>")
                .append(LogInBuyer.currentBuyer.getLogin())
                .append(", у вас в корзине:</p></b>")
                .append("<table class=\"table\">\n" +
                        "          <thead>\n" +
                        "            <tr>\n" +
                        "              <th scope=\"col\">Автор</th>\n" +
                        "              <th scope=\"col\">Название</th>\n" +
                        "              <th scope=\"col\">Цена</th>\n" +
                        "            </tr>\n" +
                        "          </thead>\n" +
                        "          <tbody>");
        for (int i = 0; i < purchasesList.size(); i++) {
            Book currentBook=new BookDAO().read(purchasesList.get(i).getBooks_id());
            sb.append("<tr>\n" +
                    "              <td>")
                    .append(currentBook.getAuthor())
                    .append("</td>\n" +
                            "              <td>")
                    .append(currentBook.getName())
                    .append("</td>\n" +
                            "              <td>")
                    .append(currentBook.getPrice());
        }
        sb.append("</tbody>\n" +
                "        </table>");
        return sb.toString();
    }
}
