package by.it.sendetskaya.jd03_02;

import java.sql.*;

public class Buyer_CRUD implements IBean_CRUD <Buyer> {

    @Override
    public boolean create(Buyer buyer) throws SQLException {

        buyer.setId(0);
        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("INSERT INTO sendetskaya.buyers (Email, Nickname, Password, FK_roles) " +
                    "VALUES ('%s','%s','%s',%d);",buyer.getEmail(),
                    buyer.getNickname(),buyer.getPassword(),buyer.getFk_roles());
            int recCount=statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
            if (recCount==1){
                ResultSet keys=statement.getGeneratedKeys();
                if ((keys.next())){
                    int id=keys.getInt(1);
                    buyer.setId(id);
                }
            }
            return recCount==1;
        }

    }

    @Override
    public boolean update(Buyer buyer) throws SQLException  {
        Buyer resBuyer=null;
        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("UPDATE sendetskaya.buyers SET `Email`='%s'," +
                            "`Nickname`='%s',`Password`='%s',`FK_roles`='%d' " +
                            "WHERE `ID`='%d' ;",buyer.getEmail(), buyer.getNickname(),
                    buyer.getPassword(),buyer.getFk_roles(), buyer.getId());
            int recCount=statement.executeUpdate(sql);
            if(recCount==1)
                resBuyer=buyer;

            return recCount==1;
        }
    }

    @Override
    public boolean delete(Buyer buyer)  throws SQLException {
        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("DELETE FROM sendetskaya.buyers WHERE " +
                            "`ID`='%d' ;", buyer.getId());
            int recCount=statement.executeUpdate(sql);

            return recCount==1;
        }
    }

    @Override
    public Buyer read(int id)  throws SQLException {

        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("SELECT *  FROM sendetskaya.buyers WHERE" +
                    " ID=%d",id);

                   final ResultSet resultSet=statement.executeQuery(sql);

                    if (resultSet.next())
                    {
                        return new Buyer (
                                resultSet.getInt("ID"),
                                resultSet.getString("Email"),
                                resultSet.getString("Nickname"),
                                resultSet.getString("Password"),
                                resultSet.getInt("FK_roles")
                        );
                    }
        }

        return null;
    }

    @Override
    public Buyer readAll() throws SQLException {
        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("SELECT *  FROM sendetskaya.buyers;");

            ResultSet resultSet=statement.executeQuery(sql);

                while (resultSet.next())
                {
                    ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
                    int countColumn=resultSetMetaData.getColumnCount();
                    for (int i = 1; i < countColumn+1; i++) {
                        System.out.print(resultSetMetaData.getColumnLabel(i)+"="+
                                resultSet.getString(i)+" ");
//                        return new Buyer (
//                                resultSet.getInt("ID"),
//                                resultSet.getString("Email"),
//                                resultSet.getString("Nickname"),
//                                resultSet.getString("Password"),
//                                resultSet.getInt("FK_roles")
//                        );
                    }
                    System.out.println();
                }
        }

        return null;
    }
}
