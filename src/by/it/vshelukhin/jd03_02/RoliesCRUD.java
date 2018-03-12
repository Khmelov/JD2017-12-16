package by.it.vshelukhin.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoliesCRUD implements CRUD<Rolies> {
    @Override
    public boolean create(Rolies rolie) throws SQLException {
        rolie.setId(0);
        int a = -1;
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            String request = String.format("INSERT INTO `rolies`(`role`) " +
                    "VALUES ('%s')",rolie.getRole());
            a = statement.executeUpdate(request, Statement.RETURN_GENERATED_KEYS);
            if (a == 1) {
                ResultSet res = statement.getGeneratedKeys();
                if (res.next()) rolie.setId(res.getInt(1));
            }
        }
        return a == 1;
    }

    @Override
    public Rolies read(int id) throws SQLException {
        Rolies rolie = null;
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            String request = String.format("SELECT * FROM `rolies` WHERE id=%d", id);
            ResultSet res = statement.executeQuery(request);
            if (res.next()) {
                rolie = new Rolies(res.getInt("id"), res.getString("role"));
            }
        }
        return rolie;
    }

    @Override
    public boolean update(Rolies rolie) throws SQLException {
        int a = -1;
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            String request = String.format("UPDATE `rolies` SET `role`='%s' WHERE id=%d",
                    rolie.getRole(), rolie.getId());
            a = statement.executeUpdate(request);
        }
        return a == 1;
    }

    @Override
    public boolean delete(Rolies rolie) throws SQLException {
        int a = -1;
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            String request = String.format("DELETE FROM `rolies` WHERE id=%d", rolie.getId());
            a = statement.executeUpdate(request);
        }
        return a == 1;
    }
}
