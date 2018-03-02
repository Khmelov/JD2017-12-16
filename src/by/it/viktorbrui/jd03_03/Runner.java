package by.it.viktorbrui.jd03_03;

import by.it.viktorbrui.jd03_03.bean.Product;
import by.it.viktorbrui.jd03_03.bean.Role;
import by.it.viktorbrui.jd03_03.bean.User;

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
        user.setNickname("Владимир");
        dao.userDAO.create(user);
        System.out.println(user);
        System.out.println("===================================");
        user.setNickname("Зося");
        dao.userDAO.update(user);
        System.out.println(user);
        System.out.println("===================================");
        dao.userDAO.delete(user);
        List<User> users=dao.userDAO.getAll("");
        for (User u : users) {
            System.out.println(u);
        }
        System.out.println("===================================");
        List<Product> Products=dao.prductDAO.getAll("");
        for (Product a : Products) {
            System.out.println(a);
        }
    }
}
