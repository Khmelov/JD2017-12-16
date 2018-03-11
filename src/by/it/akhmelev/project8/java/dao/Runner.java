package by.it.akhmelev.project8.java.dao;


import by.it.akhmelev.project8.java.entity.Ad;
import by.it.akhmelev.project8.java.entity.Role;
import by.it.akhmelev.project8.java.entity.User;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getDAO();
       Role role=dao.role.read(2);
        System.out.println(role);
        System.out.println("===================================");
       User user=dao.user.read(1);
        System.out.println(user);
        System.out.println("===================================");
        user.setLogin("Vasya");
        dao.user.create(user);
        System.out.println(user);
        System.out.println("===================================");
        user.setLogin("Fedya");
        dao.user.update(user);
        System.out.println(user);
        System.out.println("===================================");
        dao.user.delete(user);
        List<User> users=dao.user.getAll("");
        for (User u : users) {
            System.out.println(u);
        }
        System.out.println("===================================");
        List<Ad> ads=dao.ad.getAll("");
        for (Ad a : ads) {
            System.out.println(a);
        }

    }
}
