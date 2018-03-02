package by.it.viktorbrui.jd03_02;

import java.sql.SQLException;

interface BeanCRUD<T> {
    boolean create(T bean) throws SQLException;
    boolean update(T bean) throws SQLException;
    boolean delete(T bean) throws SQLException;
    T read(int id) throws SQLException;
}
