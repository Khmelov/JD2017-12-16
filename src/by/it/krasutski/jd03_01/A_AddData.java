package by.it.krasutski.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData {
    public static void main(String[] args) {
        addData();
    }

    public static void addData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/krasutski" +
                        "?useUnicode=true&characterEncoding=UTF-8",
                "root",
                ""
        )) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `krasutski`.`ads` (`Title`, `SmallDesc`, `Description`,`Price`, `users_ID`,`category_ID`)" +
                    " VALUES ('iPhone 8 Plus Space Grey', '64gb', '10/10 good phone',699,3,1);");
            System.out.println("Ad added.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
