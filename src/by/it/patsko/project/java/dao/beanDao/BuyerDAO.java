package by.it.patsko.project.java.dao.beanDao;

import by.it.patsko.project.java.dao.ConnectionCreator;
import by.it.patsko.project.java.dao.beens.Buyer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuyerDAO extends DAO implements I_DAO<Buyer> {

    @Override
    public boolean create(Buyer buyer) throws SQLException {
        buyer.setId(0);
        int id = executeUpdate(
                String.format("INSERT INTO `buyers`(`login`, `password`, `email`, `Roles_id`) " +
                                "VALUES ('%s','%s','%s','%d')",
                        buyer.getLogin(), buyer.getPassword(), buyer.getEmail(), buyer.getRoles_id()));
        if (id > 0) buyer.setId(id);
        return id > 0;
    }

    @Override
    public Buyer read(int id) throws SQLException {
        List<Buyer> buyerList = getAll(" where id=" + id);
        return !buyerList.isEmpty() ? buyerList.get(0) : null;
    }

    @Override
    public boolean update(Buyer buyer) throws SQLException {
        return 1 == executeUpdate(
                String.format("UPDATE `buyers` SET `login`='%s',`password`='%s',`email`='%s',`Roles_id`='%d' WHERE id=%d",
                        buyer.getLogin(), buyer.getPassword(), buyer.getEmail(), buyer.getRoles_id(), buyer.getId()));
    }

    @Override
    public boolean delete(Buyer buyer) throws SQLException {
        return 1 == executeUpdate(
                String.format("DELETE FROM `buyers` WHERE id=%d", buyer.getId()));
    }

    @Override
    public List<Buyer> getAll(String where) throws SQLException {
        List<Buyer> buyerList = new ArrayList<>();
        Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement();
        ResultSet buyers = statement.executeQuery("SELECT * FROM `buyers`" + where);
        while (buyers.next()) {
            buyerList.add(
                    new Buyer(
                            buyers.getInt("id"),
                            buyers.getString("login"),
                            buyers.getString("password"),
                            buyers.getString("email"),
                            buyers.getInt("Roles_id")
                    )
            );
        }
        return buyerList;
    }
}
