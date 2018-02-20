package by.it.akhmelev.jd03_03.classwork.beanDAO;

import by.it.akhmelev.jd03_03.classwork.bean.Ad;

import java.sql.SQLException;
import java.util.List;

/**
 * @author i.sukach
 */
public class AdDAO implements InterfaceDAO<Ad>{
    @Override
    public boolean create(Ad bean) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Ad bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Ad bean) throws SQLException {
        return false;
    }

    @Override
    public Ad read(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Ad> getAll(String where) throws SQLException {
        return null;
    }
}
