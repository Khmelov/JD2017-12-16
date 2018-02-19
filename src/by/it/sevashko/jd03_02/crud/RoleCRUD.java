package by.it.sevashko.jd03_02.crud;

import by.it.sevashko.jd03_02.Helpers.Connector;
import by.it.sevashko.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD implements CRUD<Role> {

    @Override
    public boolean create(Role bean) throws SQLException {
        return false;
    }

    @Override
    public Role read(int id) throws SQLException {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = String.format("SELECT * FROM `roles` WHERE id=%d;", id);
            ResultSet result = statement.executeQuery(query);
            if (result.next()){
                return new Role(
                        result.getInt("id"),
                        result.getString("role"));
            }
        }
        return null;
    }

    @Override
    public boolean update(Role bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Role bean) {
        return false;
    }
}
