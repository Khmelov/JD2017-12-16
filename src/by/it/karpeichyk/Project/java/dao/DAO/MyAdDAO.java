package by.it.karpeichyk.Project.java.dao.DAO;



import by.it.karpeichyk.Project.java.dao.BEAN.Ad;
import by.it.karpeichyk.Project.java.dao.ConnectWithDB.My_Connection_DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by user on 23.02.2018.
 */
public class MyAdDAO extends AbstractDAO_My implements DAO<Ad> {

    @Override
    public boolean create(Ad ad) throws SQLException {
        String sql = String.format(Locale.ENGLISH,"INSERT INTO ads (Description,Carrying,Volume,Tariff,FK_Users)" +
        " VALUES ('%s','%d','%d','%s','%d');",
                ad.getDescription(),
                ad.getCarrying(),
                ad.getVolume(),
                ad.getTariff(),
                ad.getFK_Users());
        ad.setId(executeUpdate(sql));
        return (ad.getId()>0);
    }

    @Override
    public boolean update(Ad ad) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE 'ads' SET"+
        "'Description' = %s"+
        "'Carrying' = %d"+
        "'Volume' = %d"+
        "'Tariff' = %s"+
        "'FK_Users' = %s"+
        "WHERE 'ads'.'ID'= %d",
                ad.getDescription(),
                ad.getCarrying(),
                ad.getVolume(),
                ad.getTariff(),
                ad.getFK_Users(),
                ad.getId());
        return false;
    }

    @Override
    public boolean delete(Ad ad) throws SQLException {
        String sql = String.format("DELETE FROM 'ads' . 'ID' = %d;",ad.getId());
        return (0<executeUpdate(sql));
    }

    @Override
    public Ad read(int id) throws SQLException {
        List<Ad> roles = getAll("WHERE ID=" + "LIMIT 0.1");
        if (roles.size()>0){
            return  roles.get(0);
        }else
        return null;
    }

    @Override
    public List<Ad> getAll(String WHERE)  {
List<Ad> ads = new ArrayList<>();
String sql = "SELECT  * FROM ads " + WHERE + ";";
   try(Connection connection = My_Connection_DB.getConnection();
       Statement statement = connection.createStatement();){
       ResultSet rs = statement.executeQuery(sql);
       while (rs.next()){
           Ad ad = new  Ad ();
           ad.setId(rs.getInt("ID"));
           ad.setDescription(rs.getString("Description"));
           ad.setCarrying(rs.getInt("Carrying"));
           ad.setVolume(rs.getInt("Volume"));
           ad.setTariff(rs.getString("Tariff"));
           ad.setFK_Users(rs.getInt("FK_Users"));
           ads.add(ad);
       }
   }catch (SQLException e){
            e.printStackTrace();
   }return ads;

    }}

