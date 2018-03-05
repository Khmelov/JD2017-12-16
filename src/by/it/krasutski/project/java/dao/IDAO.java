package by.it.krasutski.project.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<Bean> {

    boolean create(Bean bean) throws SQLException;

    boolean update(Bean bean) throws SQLException;

    boolean delete(Bean bean) throws SQLException;

    Bean read(int ID) throws SQLException;

    List<Bean> getAll(String where) throws SQLException;
}
