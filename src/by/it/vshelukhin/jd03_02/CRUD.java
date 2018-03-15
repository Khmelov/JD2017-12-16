package by.it.vshelukhin.jd03_02;

import java.sql.SQLException;

public interface CRUD<T> {
    boolean create(T bean) throws SQLException;
    boolean update(T bean) throws SQLException;
    boolean delete(T bean) throws SQLException;
    T read(int id) throws SQLException;
}
