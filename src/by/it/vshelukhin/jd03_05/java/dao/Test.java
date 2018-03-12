package by.it.vshelukhin.jd03_05.java.dao;

import by.it.vshelukhin.jd03_05.java.dao.beans.Student;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getDAO();
        Student read = dao.studentDAO.read(1);
        read.setLogin("Привет");
        dao.studentDAO.create(read);
    }
}
