package by.it.viktorbrui.jd03_03.beanDAO;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<T> {

    boolean create(T bean) throws SQLException;
    boolean update(T bean) throws SQLException;
    boolean delete(T bean) throws SQLException;
    T read(int id) throws SQLException;
    List<T> getAll(String where) throws SQLException;


}
