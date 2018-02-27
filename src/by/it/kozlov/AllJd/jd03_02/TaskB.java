package by.it.kozlov.jd03_02;

import by.it.kozlov.jd03_02.beans.Role;
import by.it.kozlov.jd03_02.beans.User;
import by.it.kozlov.jd03_02.crud.RoleCRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskB {
    public static void main(String[] args) throws SQLException {
        int counterUsers = 0;
        int counterRoles = 0;
        Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `kozlov`.`users`");
        while (resultSet.next()) {
            User user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("login"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getInt("cityID"),
                    resultSet.getString("address"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getInt("rolesID")
            );
            counterUsers++;
            System.out.print(user + " ");

            RoleCRUD roleCRUD = new RoleCRUD();
            Role role = roleCRUD.read(user.getRolesID());
            System.out.println(role);
        }
        resultSet = statement.executeQuery("SELECT * FROM `kozlov`.`roles`");
        while (resultSet.next()) {
            counterRoles++;
        }
        System.out.println("Всего пользователей " + counterUsers + ", всего ролей " + counterRoles);


    }
}
