package by.it.patsko.project.java.dao.beanDao;

import java.sql.SQLException;
import java.util.List;

public interface I_DAO<T> {
    boolean create(T bean) throws SQLException;
    T read(int id) throws SQLException;
    boolean update(T bean) throws SQLException;
    boolean delete(T bean) throws SQLException;

    List<T> getAll(String where) throws SQLException;
}
