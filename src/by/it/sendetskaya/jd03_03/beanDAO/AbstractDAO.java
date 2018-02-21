package by.it.sendetskaya.jd03_03.beanDAO;

import by.it.sendetskaya.jd03_03.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AbstractDAO {


    private int create (String sql) {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            int recCount = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (recCount == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if ((keys.next())) {
                    return keys.getInt(1);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return - 1;
    }

    public int executeUpdate(String sql) {

        if (sql.trim().toUpperCase().startsWith("INSERT"))
        {
            create(sql);
        }

        int result=-1;

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            result = statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
