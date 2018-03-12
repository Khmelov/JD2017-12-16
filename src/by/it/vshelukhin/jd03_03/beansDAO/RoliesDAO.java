package by.it.vshelukhin.jd03_03.beansDAO;

import by.it.vshelukhin.jd03_03.beans.Rolies;
import by.it.vshelukhin.jd03_03.connection.MyConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoliesDAO implements InterfaceDAO<Rolies> {
    @Override
    public boolean create(Rolies bean) throws SQLException {
        throw new SQLException("Так добавить роль нельзя!");
    }

    @Override
    public Rolies read(int id) throws SQLException {
        String filtr = String.format("WHERE id=%d", id);
        return readAll(filtr).get(0);
    }

    @Override
    public boolean update(Rolies bean) throws SQLException {
        throw new SQLException("Так изменить роль нельзя!");
    }

    @Override
    public boolean delete(Rolies bean) throws SQLException {
        throw new SQLException("Так удалить роль нельзя!");
    }

    @Override
    public List<Rolies> readAll(String filtr) throws SQLException {
        List<Rolies> rolList = null;
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            rolList = new ArrayList<>();
            String request = String.format("SELECT * FROM `rolies` %s", filtr);
            ResultSet res = statement.executeQuery(request);
            while (res.next()) {
                rolList.add(new Rolies(res.getInt("id"), res.getString("role")));
            }
        }
        return rolList;
    }
}
