package by.it.sendetskaya.jd03_02;

import java.sql.*;

public class Basket_CRUD implements IBean_CRUD <Basket> {

    @Override
    public boolean create(Basket basket) throws SQLException {

        basket.setId(0);
        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("INSERT INTO sendetskaya.baskets (`Quantity`," +
                            " `Sum`, `FK_buyers`, `FK_goods`) " +
                    "VALUES ('%d','%5.2f','%d','%d');",basket.getQuantity(),
                    basket.getSum(),basket.getFk_buyers(),basket.getFk_goods());
            int recCount=statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
            if (recCount==1){
                ResultSet keys=statement.getGeneratedKeys();
                if ((keys.next())){
                    int id=keys.getInt(1);
                    basket.setId(id);
                }
            }
            return recCount==1;
        }

    }

    @Override
    public boolean update(Basket basket) throws SQLException  {
        Basket resBasket=null;
        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("UPDATE sendetskaya.baskets SET `Quantity`='%d'," +
                            "`Sum`='%5.2f',`FK_buyers`='%d',`FK_goods`='%d'" +
                            "WHERE `ID`='%d' ;",basket.getQuantity(),
                    basket.getSum(),basket.getFk_buyers(),basket.getFk_goods(),
                    basket.getId());
            int recCount=statement.executeUpdate(sql);
            if(recCount==1)
                resBasket=basket;

            return recCount==1;
        }
    }

    @Override
    public boolean delete(Basket basket)  throws SQLException {
        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("DELETE FROM sendetskaya.baskets WHERE " +
                            "`ID`='%d' ;", basket.getId());
            int recCount=statement.executeUpdate(sql);

            return recCount==1;
        }
    }

    @Override
    public Basket read(int id)  throws SQLException {

        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("SELECT *  FROM sendetskaya.baskets WHERE" +
                    " ID=%d",id);

                   final ResultSet resultSet=statement.executeQuery(sql);

                    if (resultSet.next())
                    {
                        return new Basket (
                                resultSet.getInt("ID"),
                                resultSet.getInt("Quantity"),
                                resultSet.getDouble("Sum"),
                                resultSet.getInt("FK_buyers"),
                                resultSet.getInt("FK_goods")
                                );
                    }
        }

        return null;
    }

    @Override
    public Basket readAll() throws SQLException {
        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("SELECT *  FROM sendetskaya.baskets;");

            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next())
            {
                ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
                int countColumn=resultSetMetaData.getColumnCount();
                for (int i = 1; i < countColumn+1; i++) {
                        System.out.print(resultSetMetaData.getColumnLabel(i)+"="+
                                resultSet.getString(i)+" ");
//                    return new Basket (
//                            resultSet.getInt("ID"),
//                            resultSet.getInt("Quantity"),
//                            resultSet.getDouble("Sum"),
//                            resultSet.getInt("FK_buyers"),
//                            resultSet.getInt("FK_goods")
//                    );
                }
                System.out.println();
            }
        }

        return null;
    }
}
