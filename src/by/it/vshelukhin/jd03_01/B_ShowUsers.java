package by.it.vshelukhin.jd03_01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B_ShowUsers implements  Runnable {
    @Override
    public void run() {
        try {
            Connection connectMagaz = MyConnect.getConnection();
            Statement st = connectMagaz.createStatement();
            String s = String.format("SELECT * FROM student");
            ResultSet resultSet = st.executeQuery(s);
            while (resultSet.next()){
                int i = resultSet.getInt("id");
                System.out.printf("Пользователь %d" , i);
                String gRole = String.format("SELECT * FROM rolies WHERE id=%d",resultSet.getInt("id_role"));
                Statement stRole = connectMagaz.createStatement();
                ResultSet currentRole = stRole.executeQuery(gRole);
                if (currentRole.next()) System.out.printf(" является %s\n", currentRole.getString("role"));
                else System.out.printf(" неизвестен\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        try {
//            Connection connectMagaz = MyConnect.getConnection();
//            Statement st = connectMagaz.createStatement();
//            String s = String.format("SELECT * FROM student");
//            ResultSet resultSet = st.executeQuery(s);
//            while (resultSet.next()){
//                int i = resultSet.getInt("id");
//                System.out.printf("Пользователь %d" , i);
//                String gRole = String.format("SELECT * FROM rolies WHERE id=%d",i);
//                Statement stRole = connectMagaz.createStatement();
//                ResultSet currentRole = stRole.executeQuery(gRole);
//                if (currentRole.next()) System.out.printf("является %s\n", currentRole.getString("role"));
//                else System.out.printf(" неизвестен\n");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
