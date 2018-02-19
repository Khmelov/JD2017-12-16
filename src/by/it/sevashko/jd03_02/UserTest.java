package by.it.sevashko.jd03_02;

import by.it.sevashko.jd03_02.beans.User;
import by.it.sevashko.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

public class UserTest {

    static void test() throws SQLException {
        User user = new User(0, "VladSV", "12345", "Владислав",
                "Севашко", "vladsvby@yandex.by",1);
        UserCRUD userCRUD = new UserCRUD();
        userCRUD.create(user);
    }
}
