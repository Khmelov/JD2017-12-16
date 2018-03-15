package by.it.vshelukhin.jd03_07.java.dao.beansDAO;


import by.it.vshelukhin.jd03_07.java.dao.beansDAO.InterfaceDAO;
import by.it.vshelukhin.jd03_07.java.entity.Work;
import by.it.vshelukhin.jd03_07.java.dao.connection.MyConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkDAO implements InterfaceDAO<Work> {
    @Override
    public boolean create(Work bean) throws SQLException {
        int a = -1;
        bean.setId(0);
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            String request = String.format("INSERT INTO `works`(`name`, `price`) " +
                    "VALUES ('%s',%s)", bean.getName(), Double.toString(bean.getPrice()));
            a = statement.executeUpdate(request, Statement.RETURN_GENERATED_KEYS);
            if (a == 1) {
                ResultSet res = statement.getGeneratedKeys();
                if (res.next()) bean.setId(res.getInt(1));
            }
        }
        return a == 1;
    }

    @Override
    public Work read(int id) throws SQLException {
        String filtr = String.format("WHERE id=%d", id);
        return readAll(filtr).get(0);
    }

    @Override
    public boolean update(Work bean) throws SQLException {
        int a = -1;
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            String request = String.format("UPDATE `works` SET `name`='%s',`price`=%s WHERE id=%d",
                    bean.getName(), Double.toString(bean.getPrice()), bean.getId());
            a = statement.executeUpdate(request);
        }
        return a == 1;
    }

    @Override
    public boolean delete(Work bean) throws SQLException {
        int a = -1;
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            String request = String.format("DELETE FROM `works` WHERE id=%d", bean.getId());
            a = statement.executeUpdate(request);
        }
        return a == 1;
    }

    @Override
    public List<Work> readAll(String filtr) throws SQLException {
        List<Work> workList = null;
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            workList = new ArrayList<>();
            String request = String.format("SELECT * FROM `works` %s", filtr);
            ResultSet res = statement.executeQuery(request);
            while (res.next()) {
                workList.add(new Work(
                                res.getInt("id"),
                                res.getString("name"),
                                (double)res.getFloat("price")
                                 )
                );
            }
        }
        return workList;
    }
}
