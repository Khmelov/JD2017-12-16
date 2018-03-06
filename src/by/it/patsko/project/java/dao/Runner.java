package by.it.patsko.project.java.dao;


import by.it.patsko.project.java.dao.beanDao.BuyerDAO;
import by.it.patsko.project.java.dao.beanDao.DAO;
import by.it.patsko.project.java.dao.beens.Book;
import by.it.patsko.project.java.dao.beens.Buyer;
import by.it.patsko.project.java.dao.beens.ListOfPurchases;
import by.it.patsko.project.java.dao.beens.Role;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {
        /*DAO beanDAO = DAO.getDAO();
        Role role=beanDAO.roleDAO.read(2);
        System.out.println(role+"\n");
        Buyer buyer=beanDAO.buyerDAO.read(1);
        System.out.println(buyer+"\n");
        buyer.setLogin("buyer"+buyer.getId());
        beanDAO.buyerDAO.create(buyer);
        System.out.println(buyer+"\n");
        buyer.setLogin("buyer"+(buyer.getId()+1));
        beanDAO.buyerDAO.update(buyer);
        System.out.println(buyer+"\n");
        beanDAO.buyerDAO.delete(buyer);
        List<Buyer> users=beanDAO.buyerDAO.getAll("");
        for (Buyer b : users) {
            System.out.println(b);
        }
        System.out.println();
        List<Book> ads=beanDAO.bookDAO.getAll("");
        for (Book b : ads) {
            System.out.println(b);
        }
        System.out.println();
        Book book=beanDAO.bookDAO.read(1);
        System.out.println(book);
        System.out.println();

        System.out.println("чтение:");
        ListOfPurchases list=beanDAO.listOfPurchasesDAO.read(1);
        System.out.println(list);
        list.setBooks_id(2);
        System.out.println("обнавление: "+beanDAO.listOfPurchasesDAO.update(list)+"\n"+list);
        System.out.println("удаление: "+beanDAO.listOfPurchasesDAO.delete(list));
        System.out.println("создание: "+beanDAO.listOfPurchasesDAO.create(new ListOfPurchases(10,1,1)));*/
        System.out.println(new BuyerDAO().read("TestLogin","TestPassword"));
    }
}
