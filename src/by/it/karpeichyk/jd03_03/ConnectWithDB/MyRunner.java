package by.it.karpeichyk.jd03_03.ConnectWithDB;

import by.it.karpeichyk.jd03_03.BEAN.Ad;
import by.it.karpeichyk.jd03_03.BEAN.Role;
import by.it.karpeichyk.jd03_03.BEAN.User;
import by.it.karpeichyk.jd03_03.DAO.MyDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 23.02.2018.
 */
public class MyRunner {
    public static void main(String[] args) throws SQLException {
        MyDAO dao = MyDAO.getMyDAO();
        Role role = dao.myRoleDAO.read(1);
        System.out.println(role);
        System.out.println("================================");
        User user = dao.myUserDAO.read(3);
        System.out.println(user);
        System.out.println("=================================");
        user.setLogin("Petya");
        dao.myUserDAO.create(user);
        System.out.println(user);
        System.out.println("=================================");
        user.setLogin("Fedos");
        dao.myUserDAO.update(user);
        System.out.println(user);
        System.out.println("===================================");
        dao.myUserDAO.delete(user);
        List<Ad> ads = dao.myAdDAO.getAll("");
        for(Ad a : ads){
            System.out.println(a);

        }
    }
}
