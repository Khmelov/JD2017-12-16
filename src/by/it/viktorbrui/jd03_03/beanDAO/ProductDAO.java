package by.it.viktorbrui.jd03_03.beanDAO;

import by.it.viktorbrui.jd03_03.bean.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductDAO implements InterfaceDAO<Product>{
    @Override
    public boolean create(Product bean) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Product bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Product bean) throws SQLException {
        return false;
    }

    @Override
    public Product read(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Product> getAll(String where) throws SQLException {
        return null;
    }
}
