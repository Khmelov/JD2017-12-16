package by.it.akhmelev.project8.java.dao.beanDAO;


import by.it.akhmelev.project8.java.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class AbstractDAO {

    private int create(String sql) throws SQLException {
        try (Connection cn = ConnectionCreator.getConnection();
             Statement statement = cn.createStatement()
        ) {
            int recCount = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            int id = -1;
            if (recCount == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    id = keys.getInt(1);
                    keys.close();
                }
            }
            return id;
        }
    }

    public int executeUpdate(String sql) throws SQLException {
        if (sql.toUpperCase().trim().startsWith("INSERT"))
            return create(sql);
        try (Connection cn = ConnectionCreator.getConnection();
             Statement statement = cn.createStatement()
        ) {
            return statement.executeUpdate(sql);
        }
    }

}
