package by.it.karpeichyk.jd03_03.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 21.02.2018.
 */
public interface DAO <T>{

    boolean create(T BEAN) throws SQLException;
    boolean update(T BEAN) throws SQLException;
    boolean delete(T BEAN) throws SQLException;
    T read(int id) throws SQLException;
    List<T> getAll(String where) throws SQLException;
}
