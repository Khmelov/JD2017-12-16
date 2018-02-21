package by.it.patsko.jd03_02;


import java.sql.*;

public class ShowBuyers {
    public static void main(String[] args) {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM `buyers` INNER JOIN `roles` ON buyers.Roles_id=roles.id");
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();
                for (int i = 1; i < columnCount + 1; i++) {
                    System.out.println(
                            resultSetMetaData.getColumnLabel(i) + "=" + resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
            resultSet = statement.executeQuery(
                    "SELECT COUNT(*) FROM `buyers` INNER JOIN `roles` ON buyers.Roles_id=roles.id");
            if (resultSet.next())
                System.out.println("Количество пользователей: " + resultSet.getInt(1));

            resultSet = statement.executeQuery(
                    "SELECT COUNT(id) FROM roles;");
            if (resultSet.next()) {
                System.out.printf("Количество возможных ролей: %s\n", resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
