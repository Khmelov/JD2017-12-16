package by.it.viktorbrui.jd03_03.beanDAO;

import by.it.viktorbrui.jd03_03.connect.ConnectionCreator;

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
            if (recCount == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
            return -1;
        }
    }

    public int executeUpdate(String sql) throws SQLException {
        if (sql.toUpperCase().startsWith("INSERT"))
            return create(sql);

        try (Connection cn = ConnectionCreator.getConnection();
             Statement statement = cn.createStatement()
        ) {
            return statement.executeUpdate(sql);
        }
    }

}
