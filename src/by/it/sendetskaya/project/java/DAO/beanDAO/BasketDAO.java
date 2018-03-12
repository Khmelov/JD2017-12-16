package by.it.sendetskaya.project.java.DAO.beanDAO;

import by.it.sendetskaya.project.java.entity.Basket;
import by.it.sendetskaya.project.java.DAO.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BasketDAO extends AbstractDAO implements IDAO<Basket> {

    @Override
    public boolean create(Basket basket) {

        basket.setId(0);

            String sql=String.format("INSERT INTO sendetskaya.baskets (`Quantity`," +
                            " `Sum`, `FK_buyers`, `FK_goods`) " +
                            "VALUES ('%d','%5.2f','%d','%d');",basket.getQuantity(),
                    basket.getSum(),basket.getFk_buyers(),basket.getFk_goods());
        int id=executeUpdate(sql);
        if (id>0){
            basket.setId(id);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean update(Basket basket) {

        String sql=String.format("UPDATE sendetskaya.baskets SET `Quantity`='%d'," +
                        "`Sum`='%5.2f',`FK_buyers`='%d',`FK_goods`='%d'" +
                        "WHERE `ID`='%d' ;",basket.getQuantity(),
                basket.getSum(),basket.getFk_buyers(),basket.getFk_goods(),
                basket.getId());
        return executeUpdate(sql)>0;
    }

    @Override
    public boolean delete(Basket basket) {

        String sql=String.format("DELETE FROM sendetskaya.baskets WHERE " +
                "`ID`='%d' ;", basket.getId());
        return executeUpdate(sql)>0;
    }

    @Override
    public Basket read(int id) throws SQLException {

        List<Basket> list=getAll("WHERE ID="+id+" LIMIT 0,1");
        if(list.size()>0)
        {
            return list.get(0);
        }

        else
            return null;
    }

    @Override
    public List<Basket> getAll() throws SQLException {

        List<Basket> list=new ArrayList<>();
        try(Connection connection= ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("SELECT *  FROM sendetskaya.baskets ;");

            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next())
            {
                Basket basket=new Basket(
                        resultSet.getInt("ID"),
                        resultSet.getInt("Quantity"),
                        resultSet.getDouble("Sum"),
                        resultSet.getInt("FK_buyers"),
                        resultSet.getInt("FK_goods")
                );
                list.add(basket);
            }
        }
        return list;
    }

    @Override
    public List<Basket> getAll(String where) throws SQLException {

        List<Basket> list=new ArrayList<>();
        try(Connection connection= ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("SELECT *  FROM sendetskaya.baskets "+where+ ";");

            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next())
            {
                Basket basket=new Basket(
                        resultSet.getInt("ID"),
                        resultSet.getInt("Quantity"),
                        resultSet.getDouble("Sum"),
                        resultSet.getInt("FK_buyers"),
                        resultSet.getInt("FK_goods")
                );
                list.add(basket);
            }
        }
        return list;
    }

}
