package by.it.viktorbrui.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class RoleCRUD implements BeanCRUD<Role> {


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
        try (Connection cn = ConnectionCreator.getConnection();
             Statement statement = cn.createStatement()
        ) {
            String sql = String.format("SELECT *  FROM `roles` WHERE ID=%d", id);
            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Role(
                        resultSet.getInt("ID"),
                        resultSet.getString("Role")
                );
            }
        }
        return null;
    }


}