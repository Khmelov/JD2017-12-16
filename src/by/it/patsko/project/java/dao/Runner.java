package by.it.patsko.project.java.dao;


import by.it.patsko.project.java.dao.beanDao.DAO;
import by.it.patsko.project.java.dao.beanDao.UserDAO;
import by.it.patsko.project.java.dao.beens.Book;
import by.it.patsko.project.java.dao.beens.ListOfPurchases;
import by.it.patsko.project.java.dao.beens.Role;
import by.it.patsko.project.java.dao.beens.User;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {
        /*DAO dao = DAO.getDAO();
        Role role=dao.roleDAO.read(2);
        System.out.println(role+"\n");
        User user=dao.userDAO.read(1);
        System.out.println(user+"\n");
        user.setLogin("user"+user.getId());
        dao.userDAO.create(user);
        System.out.println(user+"\n");
        user.setLogin("user"+(user.getId()+1));
        dao.userDAO.update(user);
        System.out.println(user+"\n");
        dao.userDAO.delete(user);
        List<User> users=dao.userDAO.getAll("");
        for (User b : users) {
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

        System.out.println("чтение:");
        ListOfPurchases list=dao.listOfPurchasesDAO.read(1);
        System.out.println(list);
        list.setBooks_id(2);
        System.out.println("обнавление: "+dao.listOfPurchasesDAO.update(list)+"\n"+list);
        System.out.println("удаление: "+dao.listOfPurchasesDAO.delete(list));
        System.out.println("создание: "+dao.listOfPurchasesDAO.create(new ListOfPurchases(10,1,1)));*/
        System.out.println(new UserDAO().read("TestLogin","TestPassword"));
    }
}
