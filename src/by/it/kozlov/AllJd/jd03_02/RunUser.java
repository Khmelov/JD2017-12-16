package by.it.kozlov.jd03_02;

import by.it.kozlov.jd03_02.beans.User;
import by.it.kozlov.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

public class RunUser {
    public static void main(String[] args) throws SQLException {
        UserCRUD userCRUD = new UserCRUD();
        User user = userCRUD.read(1);
        System.out.println(user);

        user.setPassword("qwerty");
        userCRUD.create(user);
        System.out.println(user);

        user.setPassword("asddfghjk");
        userCRUD.update(user);
        user = userCRUD.read(1);
        System.out.println(user);

        user = userCRUD.read(3);
        if (userCRUD.delete(user)) {
            System.out.println("Удалено номер 3");
        } else {
            System.out.println("error");
        }
    }
}
