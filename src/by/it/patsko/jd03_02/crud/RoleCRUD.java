package by.it.patsko.jd03_02.crud;

import by.it.patsko.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD implements I_CRUD<Role> {

    @Override
    public boolean create(Role role) throws SQLException {
        role.setId(0);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("INSERT INTO `roles`(`role`) VALUES ('%s')", role.getRole()),
                    Statement.RETURN_GENERATED_KEYS);
            if (1 == recCount) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) role.setId(keys.getInt(1));
            }
            return recCount == 1;
        }
    }

    @Override
    public Role read(int id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet roles = statement.executeQuery(
                    String.format("SELECT * FROM `roles` WHERE id=%d", id));
            if (roles.next()) {
                return new Role(
                        roles.getInt("id"),
                        roles.getString("role"));
            }
        }
        return null;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("UPDATE `roles` SET `role`='%s' WHERE id=%d", role.getRole(), role.getId()));
            return recCount == 1;
        }
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int recCount = statement.executeUpdate(
                    String.format("DELETE FROM `roles` WHERE id=%d", role.getId()));
            return recCount == 1;
        }
    }
}
