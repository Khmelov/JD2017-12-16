package by.it.sendetskaya.project.java.DAO.beanDAO;

import java.sql.SQLException;
import java.util.List;

public interface IDAO  <T>{

    boolean create(T bean)throws SQLException;
    boolean update(T bean)throws SQLException;
    boolean delete(T bean)throws SQLException;
    T read(int id)throws SQLException;

    //список прочтенного
    //T readAll ()throws SQLException;
    List<T> getAll() throws SQLException;  //все прочитать
    List<T> getAll(String where) throws SQLException;  //по какому либо условию
}
