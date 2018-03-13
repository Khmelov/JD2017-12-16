package by.it.vshelukhin.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentCRUD implements CRUD<Student> {

    @Override
    public boolean create(Student student) throws SQLException {
        student.setId(0);
        int a = -1;
        try (Connection connection = MyConnect.getConnection();
             Statement statement = connection.createStatement();) {
            String request = String.format("INSERT INTO `student`(`univer`, `kurs`, `facultet`, `price`, `id_role`) " +
                            "VALUES ('%s',%d,'%s',%s,%d)",
                    student.getUniver(), student.getKurs(), student.getFacultet(),
                    Double.toString(student.getPrice()), student.getRole());

            a = statement.executeUpdate(request, Statement.RETURN_GENERATED_KEYS);
            if (a == 1) {
                ResultSet res = statement.getGeneratedKeys();
                if (res.next()) student.setId(res.getInt(1));
            }
        }
        return a == 1;
    }

    @Override
    public Student read(int id) throws SQLException {
        Student stud = null;
        try (Connection connection = MyConnect.getConnection();
             Statement statement = connection.createStatement();) {
            String request = String.format("SELECT * FROM `student` WHERE id=%d", id);
            ResultSet res = statement.executeQuery(request);
            if (res.next()) {
                stud = new Student();
                stud.setId(res.getInt("id"));
                stud.setUniver(res.getString("univer"));
                stud.setKurs(res.getInt("kurs"));
                stud.setFacultet(res.getString("facultet"));
                stud.setPrice(res.getDouble("price"));
                stud.setRole(res.getInt("id_role"));
            }
        }
        return stud;
    }

    @Override
    public boolean update(Student student) throws SQLException {
        int a = -1;
        try (Connection connection = MyConnect.getConnection();
             Statement statement = connection.createStatement()) {
            String request = String.format("UPDATE `student` " +
                            "SET `univer`='%s',`kurs`=%d,`facultet`='%s'," +
                            "`price`='%s',`id_role`=%d WHERE id=%d",
                    student.getUniver(), student.getKurs(), student.getFacultet(),
                    student.getPrice(), student.getRole(), student.getId());
            a = statement.executeUpdate(request);
        }
        return a == 1;
    }

    @Override
    public boolean delete(Student student) throws SQLException {
        int a = -1;
        try (Connection connection = MyConnect.getConnection();
             Statement statement = connection.createStatement()) {
            String request = String.format("DELETE FROM `student` WHERE id=%d", student.getId());
            a = statement.executeUpdate(request);
        }
        return a == 1;
    }
}
