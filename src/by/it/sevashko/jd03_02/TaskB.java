package by.it.sevashko.jd03_02;

import by.it.sevashko.jd03_02.Helpers.Connector;

import java.sql.*;

public class TaskB {

    public static void main(String[] args) {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = "SELECT users.id, login, name, lastName, email, role FROM users INNER JOIN roles ON users.fk_role=roles.id;";
            ResultSet result = statement.executeQuery(query);
            int count = 0;  //счетчик рользователей
            while (result.next()){
                count++;
                ResultSetMetaData meta = result.getMetaData();
                int columnCount = meta.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%8s: %-20s\t",meta.getColumnLabel(i), result.getString(i));
                }
                System.out.println();
            }
            System.out.println("Общее количество пользователей: " + count);
            //количество ролей
            result = statement.executeQuery("SELECT COUNT(id) FROM roles;");
            if (result.next()) {
                System.out.printf("Количество возможных ролей: %s\n", result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
