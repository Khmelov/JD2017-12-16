package by.it.vshelukhin.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductCRUD implements CRUD<Product>{

    @Override
    public boolean create(Product product) throws SQLException {
        int a = -1;
        product.setId(0);
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            String request = String.format("INSERT INTO `product`(`name`, `fk_students`) " +
                    "VALUES ('%s',%d)",product.getName(), product.getFk_students());
            a = statement.executeUpdate(request, Statement.RETURN_GENERATED_KEYS);
            if (a == 1) {
                ResultSet res = statement.getGeneratedKeys();
                if (res.next()) product.setId(res.getInt(1));
            }
        }
        return a == 1;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        int a = -1;
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            String request = String.format("UPDATE `product` SET `name`='%s',`fk_students`=%d WHERE id=%d",
                    product.getName(), product.getFk_students(), product.getId());
            a = statement.executeUpdate(request);
        }
        return a == 1;
    }

    @Override
    public boolean delete(Product product) throws SQLException {
        int a = -1;
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            String request = String.format("DELETE FROM `product` WHERE id=%d", product.getId());
            a = statement.executeUpdate(request);
        }
        return a == 1;
    }

    @Override
    public Product read(int id) throws SQLException {
        Product product = null;
        try(Connection connection = MyConnect.getConnection();
            Statement statement = connection.createStatement()) {
            String request = String.format("SELECT * FROM `product` WHERE id=%d", id);
            ResultSet res = statement.executeQuery(request);
            if (res.next()) {
                product = new Product(res.getInt("id"), res.getString("name"), res.getInt("fk_students"));
            }
        }
        return product;
    }
}
