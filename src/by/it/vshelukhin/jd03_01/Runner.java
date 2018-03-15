package by.it.vshelukhin.jd03_01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Runner {
    public static void main(String[] args) throws SQLException {
        A_AddStudent addStud = new A_AddStudent("БНТУ", 1, "ЭФ",100.0,1);
        addStud.run();
        addStud = (new A_AddStudent("БГУИР", 2, "ИТ",35.0,1));
        addStud.run();
        addStud = (new A_AddStudent("Админ", 0, "Админ",0.0,2));
        addStud.run();

        Connection connection = MyConnect.getConnection();
        Statement st = connection.createStatement();
        ResultSet rez = st.executeQuery("SELECT * FROM student");
        while (rez.next()){
            if (rez.getInt("id_role") == 2) continue;
            for (int i = 0; i < (new Random().nextInt(5))+1 ; i++) {
                int j = rez.getInt("id");
                System.out.println(j);
                A_AddData addData = new A_AddData(String.format("Контрольная по химии номер %d",i+1), j);
                addData.run();
            }
        }

        B_AddRoles addRole = new B_AddRoles(1,"Посетитель");
        addRole.run();
        addRole = new B_AddRoles(2, "Администратор");
        addRole.run();

        B_ShowUsers showUsers = new B_ShowUsers();
        showUsers.run();

        //new C_Reset().run();
        //new C_Init().run();



    }
}
