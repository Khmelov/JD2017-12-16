package by.it.akhmelev.project8.java.dao.beanDAO;

import by.it.akhmelev.project8.java.dao.beanDAO.InterfaceDAO;
import by.it.akhmelev.project8.java.entity.Ad;

import java.sql.SQLException;
import java.util.List;

/**
 * @author i.sukach
 */
public class AdDAO implements InterfaceDAO<Ad> {
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
