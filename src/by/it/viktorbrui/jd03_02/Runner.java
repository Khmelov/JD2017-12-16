package by.it.viktorbrui.jd03_02;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        UserCRUD userCRUD=new UserCRUD();
        User user=userCRUD.read(2);
        System.out.println("read"+user);

        user.setNickname("WTF?");
        userCRUD.create(user);
        System.out.println("create"+user);

        user.setNickname("qwerty");
        userCRUD.update(user);
        System.out.println("create"+user);

        userCRUD.delete(user);
        System.out.println("delete"+user);

   //     RoleCRUD RoleCRUD=new RoleCRUD();
   //     Role Role=RoleCRUD.read(2);
   //     System.out.println(Role);
    }
}
