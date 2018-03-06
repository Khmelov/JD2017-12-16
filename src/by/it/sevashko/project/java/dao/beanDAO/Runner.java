package by.it.sevashko.project.java.dao.beanDAO;

import by.it.sevashko.project.java.dao.DAO;
import by.it.sevashko.project.java.entities.User;

import java.sql.SQLException;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getDAO();
        List<User> list = dao.userDAO.getALL(String.format("WHERE login='%s' AND password='%s'", "VladSV", "qwerty"));
    }
}
