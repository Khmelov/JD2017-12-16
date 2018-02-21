package by.it.krasutski.jd03_03;

import by.it.krasutski.jd03_03.beans.Ad;
import by.it.krasutski.jd03_03.beans.Role;
import by.it.krasutski.jd03_03.beans.User;
import by.it.krasutski.jd03_03.beansDAO.DAO;
import by.it.krasutski.jd03_03.database.DataBaseInit;
import by.it.krasutski.jd03_03.database.DataBaseReset;

import java.sql.SQLException;
import java.util.List;

public class Runner {

    private static Ad ad = new Ad(0, "Samsung", "Good",
            "Good TV lol", 569, 2, 3);

    public static void main(String[] args) throws SQLException {
        DataBaseReset.resetDB();
        System.out.println("===================================");
        DataBaseInit.initDB();
        System.out.println("===================================");
        DAO dao = DAO.getDAO();
        Role role = dao.roleDAO.read(2);
        System.out.println(role);
        System.out.println("===================================");
        User user = dao.userDAO.read(2);
        System.out.println(user);
        System.out.println("===================================");
        user.setLogin("Nooblol");
        dao.userDAO.create(user);
        System.out.println(user);
        System.out.println("===================================");
        user.setLogin("george123");
        dao.userDAO.update(user);
        System.out.println(user);
        System.out.println("===================================");
        dao.adDAO.create(ad);
        dao.userDAO.delete(user);
        List<User> users = dao.userDAO.getAll("");
        for (User u : users) {
            System.out.println(u);
        }
        System.out.println("===================================");
        List<Ad> ads = dao.adDAO.getAll("");
        for (Ad a : ads) {
            System.out.println(a);
        }

    }
}
