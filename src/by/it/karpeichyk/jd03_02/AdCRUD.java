package by.it.karpeichyk.jd03_02;

import java.sql.*;
import java.util.Locale;

/**
 * Created by user on 20.02.2018.
 */
public class AdCRUD {


    public Ad create(Ad ad) throws SQLException {
        ad.setId(0);
        String createAdSQL = String.format(Locale.ENGLISH,
                " INSERT INTO ads ( " +
                        "Description," +
                        "Carrying," +
                        "Volume," +
                        "Tariff," +
                        "FK_Users" +
                        ")VALUES('%s', '%d','%d','%s','%d');",
                ad.getDescription(),
                ad.getCarrying(),
                ad.getVolume(),
                ad.getTariff(),
                ad.getFK_users());
        try (
                Connection connection = My_Connection_DB.getConnection();
                Statement statement = connection.createStatement()) {
            //System.out.println(createAdSQL);

            if (1 == statement.executeUpdate(createAdSQL, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    ad.setId(id);
                }
            }

        }
        return ad;

    }

    public Ad read(int id) throws SQLException {
        Ad adResult = null;
        String readAdSQL = "SELECT * FROM ads where ID=" + id;

        try (
                Connection connection = My_Connection_DB.getConnection();
                Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery(readAdSQL);
            if (resultSet.next()) {
                adResult = new Ad(
                        resultSet.getInt("ID"),
                        resultSet.getString("Description"),
                        resultSet.getInt("Carrying"),
                        resultSet.getInt("Volume"),
                        resultSet.getString("Tarrif"),
                        resultSet.getInt("FK_users"));

            }
        }
        return adResult;
    }

    public Ad update(Ad ad) throws SQLException {
        Ad adResult = null;
        String updateAdSQL = String.format(Locale.ENGLISH,
                "UPDATE ads" +
                        "SET Description = '%s' ," +
                        "Carrying = %d," +
                        "Volume = %d," +
                        "Tariff = '%s'" +
                        "FK_users = %d" +
                        "WHERE ads.ID = %d",
                ad.getDescription(),
                ad.getCarrying(),
                ad.getVolume(),
                ad.getTariff(),
                ad.getFK_users(),
                ad.getId());
        try (
                Connection connection = My_Connection_DB.getConnection();
                Statement statement = connection.createStatement()) {
            System.out.println(updateAdSQL);
            if (statement.executeUpdate(updateAdSQL) == 1)
                adResult = ad;
        }
        return adResult;
    }

    public boolean delete(Ad ad) throws SQLException {
        String deleteAdSQL = String.format("DELETE FROM ads WHERE ads.ID = %d", ad.getId());
        try (
                Connection connection = My_Connection_DB.getConnection();
                Statement statement = connection.createStatement()) {
            return (statement.executeUpdate(deleteAdSQL) == 1);
        }

    }
}
