package by.it.sevashko.jd03_03.dao;

import by.it.sevashko.jd03_03.connect.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract class AbstractDAO {

    int executeUpdate(String sql) throws SQLException {
        if (sql.startsWith("INSERT")) return insert(sql);
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ){
            return statement.executeUpdate(sql);
        }
    }

    private int insert(String sql) throws SQLException{
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ){
            int rowsAffected = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (rowsAffected == 1) {
                ResultSet result = statement.getGeneratedKeys();
                result.next();
                return result.getInt(1);
            }
            return -1;
        }
    }
}
