package by.it.patsko.project.java.controller.commands;

import by.it.patsko.project.java.controller.Actions;
import by.it.patsko.project.java.controller.Msg;
import by.it.patsko.project.java.dao.beanDao.BookDAO;
import by.it.patsko.project.java.dao.beanDao.ListOfPurchasesDAO;
import by.it.patsko.project.java.dao.beens.Book;
import by.it.patsko.project.java.dao.beens.Buyer;
import by.it.patsko.project.java.dao.beens.ListOfPurchases;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class CommandBasket extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req) throws SQLException {
        Buyer buyer;
        if ((buyer=(Buyer) req.getSession().getAttribute(Msg.BUYER)) != null) {
            List<ListOfPurchases> purchasesList =
                    new ListOfPurchasesDAO().getAll("WHERE Buyers_id=" + buyer.getId());

            req.setAttribute(Msg.PURCHASES_TABLE, findPurchases(purchasesList,buyer));
            return Actions.BASKET.command;
        } else {
            CommandError.errorMassage = "Вы не залогинились";
            CommandError.errorDetails = "<h5>details:</h5>" + Arrays.toString(new Exception().getStackTrace());
            return Actions.ERROR.command;
        }
    }

    private String findPurchases(List<ListOfPurchases> purchasesList, Buyer buyer) throws SQLException {

        StringBuilder sb = new StringBuilder();

        sb.append("<p><b>")
                .append(buyer.getLogin())
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
            Book currentBook = new BookDAO().read(purchasesList.get(i).getBooks_id());
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
