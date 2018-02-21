package by.it.sendetskaya.jd03_02;

import java.sql.*;

public class Good_CRUD implements IBean_CRUD <Good> {

    @Override
    public boolean create(Good good) throws SQLException {

        good.setId(0);
        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("INSERT INTO sendetskaya.goods (`Name`, " +
                            "`Price`, `Size`, `Colour`, `Structure`, `Description`) " +
                    "VALUES ('%s','%5.2f','%s','%s','%s','%s');",good.getName(),
                    good.getPrice(),good.getSize(),good.getColour(),good.getStructure(),
                    good.getDescription());
            int recCount=statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
            if (recCount==1){
                ResultSet keys=statement.getGeneratedKeys();
                if ((keys.next())){
                    int id=keys.getInt(1);
                    good.setId(id);
                }
            }
            return recCount==1;
        }

    }

    @Override
    public boolean update(Good good) throws SQLException  {
        Good resGood=null;
        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("UPDATE sendetskaya.goods SET `Name`='%s',`Price`='%5.2f'," +
                            "`Size`='%s',`Colour`='%s',`Structure`='%s',`Description`='%s'" +
                            "WHERE `ID`='%d' ;",good.getName(),good.getPrice(),
                    good.getSize(),good.getColour(),good.getStructure(),good.getDescription(),
                    good.getId());
            int recCount=statement.executeUpdate(sql);
            if(recCount==1)
                resGood=good;

            return recCount==1;
        }
    }

    @Override
    public boolean delete(Good good)  throws SQLException {
        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("DELETE FROM sendetskaya.goods WHERE " +
                            "`ID`='%d' ;", good.getId());
            int recCount=statement.executeUpdate(sql);

            return recCount==1;
        }
    }

    @Override
    public Good read(int id)  throws SQLException {

        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("SELECT *  FROM sendetskaya.goods WHERE" +
                    " ID=%d",id);

                   final ResultSet resultSet=statement.executeQuery(sql);

                    if (resultSet.next())
                    {
                        return new Good (
                                resultSet.getInt("ID"),
                                resultSet.getString("Name"),
                                resultSet.getDouble("Price"),
                                resultSet.getString("Size"),
                                resultSet.getString("Colour"),
                                resultSet.getString("Structure"),
                                resultSet.getString("Description")
                        );
                    }
        }

        return null;
    }

    @Override
    public Good readAll() throws SQLException {
        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("SELECT *  FROM sendetskaya.goods;");

            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next())
            {
                ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
                int countColumn=resultSetMetaData.getColumnCount();
                for (int i = 1; i < countColumn+1; i++) {
                        System.out.print(resultSetMetaData.getColumnLabel(i)+"="+
                                resultSet.getString(i)+" ");
//                    return new Buyer (
//                            resultSet.getInt("ID"),
//                            resultSet.getString("Name"),
//                            resultSet.getDouble("Price"),
//                            resultSet.getString("Size"),
//                            resultSet.getString("Colour"),
//                            resultSet.getString("Structure"),
//                            resultSet.getString("Description")
//                    );
                }
                System.out.println();
            }
        }

        return null;
    }
}
