package by.it.kozlov.jd03_02.crud;

import by.it.kozlov.jd03_02.ConnectionCreator;
import by.it.kozlov.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD implements ICRUD<Role> {

    @Override
    public boolean create(Role bean) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Role bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Role bean) throws SQLException {
        return false;
    }

    @Override
    public Role read(int id) throws SQLException {
        Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement();
        String sql = String.format("SELECT * FROM `kozlov`.`roles` WHERE id=%d",
                id);
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            return new Role(
                    resultSet.getInt("id"),
                    resultSet.getString("role")
            );
        }
        return null;
    }

    public Role read(String role) throws SQLException {
        Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement();
        String sql = String.format("SELECT * FROM `kozlov`.`roles` WHERE role='%s'",
                role);
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            return new Role(
                    resultSet.getInt("id"),
                    resultSet.getString("role")
            );
        }
        return null;
    }

}
