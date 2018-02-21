package by.it.karpeichyk.jd03_01;

import java.sql.*;

/**
 * Created by user on 18.02.2018.
 */
public class Select {
    public static void main(String[] args) {
         try (Connection connection =
                       DriverManager.getConnection
                               (Driver.URL_DB, Driver.USER_DB, Driver.PASSWORD_DB);
               Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery("select Login,ROLE from users,roles where roles=roles.ID;");
            while (resultSet.next()) {
                String out = resultSet.getString("Login") + ", " + resultSet.getString("ROLE");

                System.out.println(out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
