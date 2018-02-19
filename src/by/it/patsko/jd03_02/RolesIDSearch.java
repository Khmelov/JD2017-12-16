package by.it.patsko.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RolesIDSearch {

    public static void main(String[] args) {
        Connection connection = ConnectionCreator.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet roles = statement.executeQuery("SELECT * FROM `roles`");

            System.out.println("Введите имя роли для поиска: ");
            Scanner scanner = new Scanner(System.in);
            String roleName = scanner.nextLine();
            while (roles.next())
                if (roleName.equals(roles.getString("role")))
                    System.out.println(roles.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
