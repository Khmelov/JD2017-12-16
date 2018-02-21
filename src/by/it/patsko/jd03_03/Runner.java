package by.it.patsko.jd03_03;

import by.it.patsko.jd03_03.beens.Book;
import by.it.patsko.jd03_03.beens.Buyer;
import by.it.patsko.jd03_03.beens.ListOfPurchases;
import by.it.patsko.jd03_03.beens.Role;
import by.it.patsko.jd03_03.dao.DAO;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getDAO();
        Role role=dao.roleDAO.read(2);
        System.out.println(role+"\n");
        Buyer buyer=dao.buyerDAO.read(1);
        System.out.println(buyer+"\n");
        buyer.setLogin("buyer"+buyer.getId());
        dao.buyerDAO.create(buyer);
        System.out.println(buyer+"\n");
        buyer.setLogin("buyer"+(buyer.getId()+1));
        dao.buyerDAO.update(buyer);
        System.out.println(buyer+"\n");
        dao.buyerDAO.delete(buyer);
        List<Buyer> users=dao.buyerDAO.getAll("");
        for (Buyer b : users) {
            System.out.println(b);
        }
        System.out.println();
        List<Book> ads=dao.bookDAO.getAll("");
        for (Book b : ads) {
            System.out.println(b);
        }
        System.out.println();
        Book book=dao.bookDAO.read(1);
        System.out.println(book);
        System.out.println();

        System.out.println("чтение:\n");
        ListOfPurchases list=dao.listOfPurchasesDAO.read(1);
        System.out.println(list);
        list.setBooks_id(2);
        System.out.println("обнавление: "+dao.listOfPurchasesDAO.update(list)+"\n"+list);
        System.out.println("удаление: "+dao.listOfPurchasesDAO.delete(list));
        System.out.println("создание: "+dao.listOfPurchasesDAO.create(new ListOfPurchases(10,1,1)));
    }
}
