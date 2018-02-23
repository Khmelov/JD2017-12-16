package by.it.akhmelev.jd03_03.classwork;

import by.it.akhmelev.jd03_03.classwork.bean.Ad;
import by.it.akhmelev.jd03_03.classwork.bean.Role;
import by.it.akhmelev.jd03_03.classwork.bean.User;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getDAO();
       Role role=dao.roleDAO.read(2);
        System.out.println(role);
        System.out.println("===================================");
       User user=dao.userDAO.read(1);
        System.out.println(user);
        System.out.println("===================================");
        user.setLogin("Vasya");
        dao.userDAO.create(user);
        System.out.println(user);
        System.out.println("===================================");
        user.setLogin("Fedya");
        dao.userDAO.update(user);
        System.out.println(user);
        System.out.println("===================================");
        dao.userDAO.delete(user);
        List<User> users=dao.userDAO.getAll("");
        for (User u : users) {
            System.out.println(u);
        }
        System.out.println("===================================");
        List<Ad> ads=dao.adDAO.getAll("");
        for (Ad a : ads) {
            System.out.println(a);
        }

    }
}
