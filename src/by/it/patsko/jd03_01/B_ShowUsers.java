package by.it.patsko.jd03_01;

import java.sql.*;

public class B_ShowUsers {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection =
                     DriverManager.getConnection(Connect.URL_DB, Connect.USER_DB, Connect.PASSWORD_DB)) {
            Statement statement=connection.createStatement();
            ResultSet buyers=statement.executeQuery("SELECT * FROM `buyers`");
            while ((buyers.next()))
                System.out.println(buyers.getString("login")+"\t-\t"+(buyers.getInt("Roles_id")==1?"admin":"buyer"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
