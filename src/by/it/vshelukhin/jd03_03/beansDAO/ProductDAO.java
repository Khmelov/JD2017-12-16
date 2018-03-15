package by.it.vshelukhin.jd03_03.beansDAO;

import by.it.vshelukhin.jd03_03.beans.Product;
import by.it.vshelukhin.jd03_03.connection.MyConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements InterfaceDAO<Product> {
    @Override
    public boolean create(Product bean) throws SQLException {
        int a = -1;
        bean.setId(0);
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            String request = String.format("INSERT INTO `product`(`name`, `fk_students`) " +
                    "VALUES ('%s',%d)",bean.getName(), bean.getFk_students());
            a = statement.executeUpdate(request, Statement.RETURN_GENERATED_KEYS);
            if (a == 1) {
                ResultSet res = statement.getGeneratedKeys();
                if (res.next()) bean.setId(res.getInt(1));
            }
        }
        return a == 1;
    }

    @Override
    public Product read(int id) throws SQLException {
        String filtr = String.format("WHERE id=%d", id);
        return readAll(filtr).get(0);
    }

    @Override
    public boolean update(Product bean) throws SQLException {
        int a = -1;
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            String request = String.format("UPDATE `product` SET `name`='%s',`fk_students`=%d WHERE id=%d",
                    bean.getName(), bean.getFk_students(), bean.getId());
            a = statement.executeUpdate(request);
        }
        return a == 1;
    }

    @Override
    public boolean delete(Product bean) throws SQLException {
        int a = -1;
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            String request = String.format("DELETE FROM `product` WHERE id=%d", bean.getId());
            a = statement.executeUpdate(request);
        }
        return a == 1;
    }

    @Override
    public List<Product> readAll(String filtr) throws SQLException {
        List<Product> prodList = null;
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            prodList = new ArrayList<>();
            String request = String.format("SELECT * FROM `product` %s", filtr);
            ResultSet res = statement.executeQuery(request);
            while (res.next()) {
                prodList.add(new Product(
                        res.getInt("id"),
                        res.getString("name"),
                        res.getInt("fk_students")
                        )
                );
            }
        }
        return prodList;
    }
}
