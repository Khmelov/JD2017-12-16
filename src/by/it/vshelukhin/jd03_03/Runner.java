package by.it.vshelukhin.jd03_03;

import by.it.vshelukhin.jd03_03.beans.Student;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getDAO();
        System.out.println(dao.studentDAO.read(3));
        System.out.println(dao.productDAO.read(1));
        System.out.println(dao.roliesDAO.read(1));
        Student st = dao.studentDAO.read(3);
        dao.studentDAO.create(st);
    }

}
