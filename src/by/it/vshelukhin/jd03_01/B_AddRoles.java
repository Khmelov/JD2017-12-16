package by.it.vshelukhin.jd03_01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B_AddRoles implements Runnable{
    int id = 1;
    String role = "";


    public B_AddRoles() {
        super();
    }

    public B_AddRoles(int id, String role) {
        this();
        this.id = id;
        this.role = role;
    }

    @Override
    public void run() {

        try {

            Connection connectMagaz = MyConnect.getConnection();
            Statement st = connectMagaz.createStatement();
            ResultSet inRolesTable = st.executeQuery(String.format("SELECT * FROM rolies WHERE `id` = %d",id));
            if (inRolesTable.next()) {
                Statement stDel = connectMagaz.createStatement();
                stDel.executeUpdate(String.format("DELETE FROM `rolies` WHERE `rolies`.`id` = %d;",inRolesTable.getInt("id")));
            }

            String s = String.format("INSERT INTO `rolies`(`id`, `role`) VALUES (%d,'%s')",id, role);
            System.out.println("Запись добавлена в таблицу role");
            st.executeUpdate(s);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        int id = 2;
//        String role = "adkmyin";
//        try {
//
//            Connection connectMagaz = MyConnect.getConnection();
//            Statement st = connectMagaz.createStatement();
//            ResultSet inRolesTable = st.executeQuery(String.format("SELECT * FROM rolies WHERE `id` = %d",id));
//            if (inRolesTable.next()) {
//                Statement stDel = connectMagaz.createStatement();
//                stDel.executeUpdate(String.format("DELETE FROM `rolies` WHERE `rolies`.`id` = %d;",inRolesTable.getInt("id")));
//            }
//
//            String s = String.format("INSERT INTO `rolies`(`id`, `role`) VALUES (%d,'%s')",id, role);
//            System.out.println("Запись добавлена в таблицу role");
//            st.executeUpdate(s);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
