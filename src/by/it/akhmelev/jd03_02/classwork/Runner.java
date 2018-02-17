package by.it.akhmelev.jd03_02.classwork;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        UserCRUD userCRUD=new UserCRUD();
        User user=userCRUD.read(2);
        System.out.println("read"+user);

        user.setLogin("Kuku");
        userCRUD.create(user);
        System.out.println("create"+user);

        user.setLogin("Kuku2");
        userCRUD.update(user);
        System.out.println("create"+user);

        userCRUD.delete(user);
        System.out.println("delete"+user);

        RoleCRUD roleCRUD=new RoleCRUD();
        Role role=roleCRUD.read(1);
        System.out.println(role);
    }
}
