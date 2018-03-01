package by.it.sevashko.jd03_03.dao;

import by.it.sevashko.jd03_03.beans.User;

import java.sql.SQLException;

public class Runner_UniversalDAO {

    public static void main(String[] args) throws SQLException {
        UniversalDAO<User> dao = new UniversalDAO<>(new User(), "users");
        User user = new User(0, "VladSVBY", "12345", "Владислав",
                "Севашко", "vladsvby@yandex.by",1);

        dao.create(user);
        User rUser = dao.read(user.getId());
        System.out.println(rUser);
        System.out.println();
        rUser.setName("Vladislav");
        dao.update(rUser);
        System.out.println(dao.read(user.getId()));
        System.out.println();
        for (User user1 : dao.getALL("")){
            System.out.println(user1);
        }
        System.out.println();
        System.out.println(dao.delete(user));
    }
}
