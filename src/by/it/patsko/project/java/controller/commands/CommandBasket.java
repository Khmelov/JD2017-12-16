package by.it.patsko.project.java.controller.commands;

import by.it.patsko.project.java.controller.Actions;
import by.it.patsko.project.java.controller.Msg;
import by.it.patsko.project.java.dao.beanDao.BookDAO;
import by.it.patsko.project.java.dao.beanDao.DAO;
import by.it.patsko.project.java.dao.beanDao.ListOfPurchasesDAO;
import by.it.patsko.project.java.dao.beens.Book;
import by.it.patsko.project.java.dao.beens.Buyer;
import by.it.patsko.project.java.dao.beens.ListOfPurchases;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandBasket extends ActionCommand {
    @Override
    public ActionCommand execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        Buyer buyer;
        if ((buyer=(Buyer) req.getSession().getAttribute(Msg.BUYER)) != null) {
            List<ListOfPurchases> purchasesList =
                    new ListOfPurchasesDAO().getAll("WHERE Buyers_id=" + buyer.getId());

            List<Book> booksInBasket = new ArrayList<>(purchasesList.size());
            for (int i = 0; i < purchasesList.size(); i++) {
                booksInBasket.add(DAO.getDAO().bookDAO.read(purchasesList.get(0).getBooks_id()));
            }
            req.setAttribute(Msg.PURCHASES, booksInBasket);

            return Actions.BASKET.command;
        } else {
            CommandError.errorMassage = "Вы не залогинились";
            CommandError.errorDetails = "<h5>details:</h5>" + Arrays.toString(new Exception().getStackTrace());
            return Actions.ERROR.command;
        }
    }
}
