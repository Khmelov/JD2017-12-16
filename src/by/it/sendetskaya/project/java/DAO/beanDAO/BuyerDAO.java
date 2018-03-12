package by.it.sendetskaya.project.java.DAO.beanDAO;

import by.it.sendetskaya.project.java.entity.Buyer;
import by.it.sendetskaya.project.java.DAO.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuyerDAO extends AbstractDAO implements IDAO<Buyer> {

    @Override
    public boolean create(Buyer buyer) {

        buyer.setId(0);

            String sql=String.format("INSERT INTO sendetskaya.buyers (Email, Nickname, Password, FK_roles) " +
                            "VALUES ('%s','%s','%s',%d);",buyer.getEmail(),
                    buyer.getNickname(),buyer.getPassword(),buyer.getFk_roles());
            int id=executeUpdate(sql);
            if (id>0){
                    buyer.setId(id);
                    return true;
                }
            else
                return false;
    }

    @Override
    public boolean update(Buyer buyer) {

            String sql=String.format("UPDATE sendetskaya.buyers SET `Email`='%s'," +
                            "`Nickname`='%s',`Password`='%s',`FK_roles`='%d' " +
                            "WHERE `ID`='%d' ;",buyer.getEmail(), buyer.getNickname(),
                    buyer.getPassword(),buyer.getFk_roles(), buyer.getId());

            return executeUpdate(sql)>0;
    }

    @Override
    public boolean delete(Buyer buyer) {

            String sql=String.format("DELETE FROM sendetskaya.buyers WHERE " +
                    "`ID`='%d' ;", buyer.getId());

            return executeUpdate(sql)>0;

    }

    @Override
    public Buyer read(int id)  throws SQLException {

        List<Buyer> list=getAll("WHERE ID="+id+" LIMIT 0,1");
        if(list.size()>0)
        {
            return list.get(0);
        }

        else
            return null;
    }

    @Override
    public List<Buyer> getAll() throws SQLException {

        List<Buyer> list=new ArrayList<>();
        try(Connection connection= ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("SELECT *  FROM sendetskaya.buyers ;");

            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next())
            {
                Buyer buyer=new Buyer(
                        resultSet.getInt("ID"),
                        resultSet.getString("Email"),
                        resultSet.getString("Nickname"),
                        resultSet.getString("Password"),
                        resultSet.getInt("FK_roles")
                );
                list.add(buyer);
            }
        }

        return list;
    }

    @Override
    public List<Buyer> getAll(String where) throws SQLException {

        List<Buyer> list=new ArrayList<>();
        try(Connection connection= ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("SELECT *  FROM sendetskaya.buyers "+where+ ";");

            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next())
            {
                Buyer buyer=new Buyer(
                        resultSet.getInt("ID"),
                        resultSet.getString("Email"),
                        resultSet.getString("Nickname"),
                        resultSet.getString("Password"),
                        resultSet.getInt("FK_roles")
                );
                list.add(buyer);
            }
        }

        return list;
    }

}
