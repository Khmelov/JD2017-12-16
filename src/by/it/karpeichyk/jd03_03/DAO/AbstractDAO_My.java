package by.it.karpeichyk.jd03_03.DAO;

import by.it.karpeichyk.jd03_03.ConnectWithDB.My_Connection_DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by user on 21.02.2018.
 */
public class AbstractDAO_My {
    private int create(String sql) throws SQLException {
        try (Connection cnc = My_Connection_DB.getConnection();
             Statement statement = cnc.createStatement()) {
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
        try (Connection cnc = My_Connection_DB.getConnection();
             Statement statement = cnc.createStatement()) {
            return statement.executeUpdate(sql);
        }
    }
}
