package by.it.karpeichyk.jd03_02;

/**
 * Created by user on 19.02.2018.
 */
import java.sql.SQLException;
public class Runner {
    public static void main(String[] args) throws SQLException {
        RoleCRUD roleCRUD= new RoleCRUD();
        Role role = roleCRUD.read(8);
        System.out.println(role);

       UserCRUD userCRUD=new UserCRUD();
        User user=userCRUD.read(1);
        System.out.println("read"+user);

        user.setLogin("Lala");
        userCRUD.create(user);
        System.out.println("create"+user);

        user.setLogin("laland");
        Role role1= roleCRUD.read(1);
        System.out.println(role1);

        UserCRUD userCRUD1=new UserCRUD();
        User user1=userCRUD1.read(2);
        System.out.println("read"+user1);


        userCRUD.delete(user);
        System.out.println("delete"+user);

    }
}
