package by.it.karpeichyk.jd03_02;

import java.sql.SQLException;

/**
 * Created by user on 19.02.2018.
 */
public interface BeanCRUD<T> {
    boolean create(T bean) throws SQLException;
    boolean update(T bean) throws SQLException;



    boolean delete(T bean) throws SQLException;
    T read(int id) throws SQLException;

}
