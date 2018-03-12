package by.it.sendetskaya.project.java.DAO.beanDAO;

import by.it.sendetskaya.project.java.entity.Good;
import by.it.sendetskaya.project.java.DAO.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GoodDAO extends AbstractDAO implements IDAO<Good> {
    @Override
    public boolean create(Good good) {

        good.setId(0);

            String sql=String.format("INSERT INTO sendetskaya.goods (`Name`, " +
                            "`Price`, `Size`, `Colour`, `Structure`, `Description`) " +
                            "VALUES ('%s','%5.2f','%s','%s','%s','%s');",good.getName(),
                    good.getPrice(),good.getSize(),good.getColour(),good.getStructure(),
                    good.getDescription());
        int id=executeUpdate(sql);
        if (id>0){
            good.setId(id);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean update(Good good) {

        String sql=String.format("UPDATE sendetskaya.goods SET `Name`='%s',`Price`='%5.2f'," +
                        "`Size`='%s',`Colour`='%s',`Structure`='%s',`Description`='%s'" +
                        "WHERE `ID`='%d' ;",good.getName(),good.getPrice(),
                good.getSize(),good.getColour(),good.getStructure(),good.getDescription(),
                good.getId());
        return executeUpdate(sql)>0;
    }

    @Override
    public boolean delete(Good good) {
        String sql=String.format("DELETE FROM sendetskaya.goods WHERE " +
                "`ID`='%d' ;", good.getId());
        return executeUpdate(sql)>0;
    }

    @Override
    public Good read(int id) throws SQLException {

        List<Good> list=getAll("WHERE ID="+id+" LIMIT 0,1");
        if(list.size()>0)
        {
            return list.get(0);
        }

        else
            return null;
    }

    @Override
    public List <Good> getAll() throws SQLException {

        List <Good> list=new ArrayList<>();
        try(Connection connection= ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("SELECT *  FROM goods ;");

            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next())
            {
                Good good =new Good(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getDouble("Price"),
                        resultSet.getString("Size"),
                        resultSet.getString("Colour"),
                        resultSet.getString("Structure"),
                        resultSet.getString("Description")
                );
                list.add(good);
            }
        }

        return list;
    }

    @Override
    public List<Good> getAll(String where) throws SQLException {

        List <Good> list=new ArrayList<>();
        try(Connection connection= ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("SELECT * FROM goods "+where+ ";");

            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next())
            {
                Good good =new Good(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getDouble("Price"),
                        resultSet.getString("Size"),
                        resultSet.getString("Colour"),
                        resultSet.getString("Structure"),
                        resultSet.getString("Description")
                );
                list.add(good);
            }
        }

        return list;
    }

}
