package by.it.vshelukhin.jd03_07.java.dao.beansDAO;

import by.it.vshelukhin.jd03_07.java.dao.beansDAO.InterfaceDAO;
import by.it.vshelukhin.jd03_07.java.entity.Zakaz;
import by.it.vshelukhin.jd03_07.java.dao.connection.MyConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ZakazDAO implements InterfaceDAO<Zakaz> {
    @Override
    public boolean create(Zakaz bean) throws SQLException {
        int a = -1;
        bean.setId(0);
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            String request = String.format("INSERT INTO `zakaz`(`students_id`, `works_id`) " +
                    "VALUES ('%d',%d)", bean.getStudents_id(), bean.getWorks_id());
            a = statement.executeUpdate(request, Statement.RETURN_GENERATED_KEYS);
            if (a == 1) {
                ResultSet res = statement.getGeneratedKeys();
                if (res.next()) bean.setId(res.getInt(1));
            }
        }
        return a == 1;
    }

    @Override
    public Zakaz read(int id) throws SQLException {
        String filtr = String.format("WHERE id=%d", id);
        return readAll(filtr).get(0);
    }

    @Override
    public boolean update(Zakaz bean) throws SQLException {
        int a = -1;
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            String request = String.format("UPDATE `zakaz` SET `students_id`=%d,`works_id`=%d WHERE id=%d",
                    bean.getStudents_id(), bean.getWorks_id(), bean.getId());
            a = statement.executeUpdate(request);
        }
        return a == 1;
    }

    @Override
    public boolean delete(Zakaz bean) throws SQLException {
        int a = -1;
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            String request = String.format("DELETE FROM `zakaz` WHERE id=%d", bean.getId());
            a = statement.executeUpdate(request);
        }
        return a == 1;
    }

    @Override
    public List<Zakaz> readAll(String filtr) throws SQLException {
        List<Zakaz> zakazList = null;
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            zakazList = new ArrayList<>();
            String request = String.format("SELECT * FROM `zakaz` %s", filtr);
            ResultSet res = statement.executeQuery(request);
            while (res.next()) {
                zakazList.add(new Zakaz(
                                res.getInt("id"),
                                res.getInt("students_id"),
                                res.getInt("works_id")
                                )
                );
            }
        }
        return zakazList;
    }
}
