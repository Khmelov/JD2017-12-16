package by.it.krasutski.jd03_02.crud;

import by.it.krasutski.jd03_02.database.ConnectionCreator;
import by.it.krasutski.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD implements BeanCRUD<Role> {

    @Override
    public boolean create(Role bean) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Role bean) throws SQLException {
        return false;
    }

    @Override
    public Role read(int ID) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = String.format("SELECT * FROM `roles` WHERE ID=%d;", ID);
            ResultSet result = statement.executeQuery(query);
            if (result.next()){
                return new Role(
                        result.getInt("ID"),
                        result.getString("Role"));
            }
        }
        return null;
    }

    @Override
    public boolean delete(Role bean) throws SQLException {
        return false;
    }
}
