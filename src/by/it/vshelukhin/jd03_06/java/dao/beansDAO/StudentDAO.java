package by.it.vshelukhin.jd03_06.java.dao.beansDAO;

import by.it.vshelukhin.jd03_06.java.entity.Student;
import by.it.vshelukhin.jd03_06.java.dao.connection.MyConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements InterfaceDAO<Student> {

    @Override
    public boolean create(Student bean) throws SQLException {
        bean.setId(0);
        int a = -1;
        try (Connection connection = MyConnect.getConnection();
             Statement statement = connection.createStatement();) {
            String request = String.format("INSERT INTO `students`(`login`, `password`, `univer`, `kurs`, `facultet`, `price`, `roles_id`) " +
                            "VALUES ('%s','%s','%s', %d,'%s',%s, %d)", bean.getLogin(), bean.getPassword(),
                    bean.getUniver(), bean.getKurs(), bean.getFacultet(),
                    Double.toString(bean.getPrice()), bean.getRole());

            a = statement.executeUpdate(request, Statement.RETURN_GENERATED_KEYS);
            if (a == 1) {
                ResultSet res = statement.getGeneratedKeys();
                if (res.next()) bean.setId(res.getInt(1));
            }
        }
        return a == 1;
    }

    @Override
    public Student read(int id) throws SQLException {
        String filtr = String.format("WHERE id=%d",id);
        return readAll(filtr).get(0);
    }

    @Override
    public boolean update(Student bean) throws SQLException {
        int a = -1;
        try (Connection connection = MyConnect.getConnection();
             Statement statement = connection.createStatement()) {
            String request = String.format("UPDATE `students` " +
                            "SET `login`='%s', `password`='%s', `univer`='%s',`kurs`=%d," +
                            "`facultet`='%s', `price`='%s',`roles_id`=%d WHERE id=%d",
                    bean.getLogin(), bean.getPassword(),
                    bean.getUniver(), bean.getKurs(), bean.getFacultet(),
                    bean.getPrice(), bean.getRole(), bean.getId());
            a = statement.executeUpdate(request);
        }
        return a == 1;
    }

    @Override
    public boolean delete(Student bean) throws SQLException {
        int a = -1;
        try (Connection connection = MyConnect.getConnection();
             Statement statement = connection.createStatement()) {
            String request = String.format("DELETE FROM `students` WHERE id=%d", bean.getId());
            a = statement.executeUpdate(request);
        }
        return a == 1;
    }

    @Override
    public List<Student> readAll(String filtr) throws SQLException {
        List<Student> studList = null;
        try (Connection connection = MyConnect.getConnection();
             Statement statement = connection.createStatement();) {
            studList = new ArrayList<>();
            String request = String.format("SELECT * FROM `students` %s", filtr);
            ResultSet res = statement.executeQuery(request);
            while (res.next()) {
                Student stud = new Student();

                stud.setId(res.getInt("id"));
                stud.setLogin(res.getString("login"));
                stud.setPassword(res.getString("password"));
                stud.setUniver(res.getString("univer"));
                stud.setKurs(res.getInt("kurs"));
                stud.setFacultet(res.getString("facultet"));
                stud.setPrice(res.getDouble("price"));
                stud.setRole(res.getInt("roles_id"));
                studList.add(stud);
            }
        }
        return studList;
    }
}
