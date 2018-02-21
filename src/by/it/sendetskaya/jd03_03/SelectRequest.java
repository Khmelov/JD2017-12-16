package by.it.sendetskaya.jd03_03;

import by.it.sendetskaya.jd03_03.bean.Buyer;
import by.it.sendetskaya.jd03_03.bean.Role;
import by.it.sendetskaya.jd03_03.connect.ConnectionCreator;

import java.sql.*;
import java.util.List;

public class SelectRequest {


    public static void selectUser ()  throws SQLException {

        try(Connection connection=ConnectionCreator.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql=String.format("SELECT buyers.ID, buyers.Nickname, roles.Role " +
                    "FROM buyers INNER JOIN roles ON buyers.FK_roles=roles.ID;"
            );

            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next())
            {
                ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
                int countColumn=resultSetMetaData.getColumnCount();
                for (int i = 1; i < countColumn+1; i++) {
                    System.out.print(resultSetMetaData.getColumnLabel(i)+"="+
                            resultSet.getString(i)+" ");
                }
                System.out.println();
            }

            //количество записей
            String sqlCount=String.format("SELECT COUNT(buyers.Nickname) AS " +
                    "'Количество пользователей', (SELECT COUNT(DISTINCT roles.Role)" +
                    " FROM roles) AS 'Количество ролей' FROM buyers;");
            resultSet=statement.executeQuery(sqlCount);

            System.out.print("Всего: ");
            if (resultSet.next())
            {
                ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
                int countColumn=resultSetMetaData.getColumnCount();
                for (int i = 1; i < countColumn+1; i++) {
                    System.out.print(resultSetMetaData.getColumnLabel(i)+"="+
                            resultSet.getInt(i)+" ");
                }
                System.out.println();
            }


        }
    }
}

//
//    private static DAO dao;
//    private static List<Buyer>buyers;
//    private static List<Role>roles;
//
//    public static void selectUser ()  throws SQLException {
//
//        dao=DAO.getDAO();
//        buyers=dao.buyerDAO.getAll();
//        roles=dao.roleDAO.getAll();
//
//        for (Role role: roles) {
//            for (Buyer buyer : buyers) {
//                selectUserAndRole(buyer,role);
//            }
//        }
//    }
//
//
//    //пользователи+их роли
//    public static void selectUserAndRole (Buyer buyer,Role role)  throws SQLException {
//
//        try (Connection connection = ConnectionCreator.getConnection();
//             Statement statement = connection.createStatement()
//        ) {
//            String sql = String.format("SELECT %d,'%s','%s' " +
//                    "FROM buyers INNER JOIN roles ON %d=%d;",
//            buyer.getId(),buyer.getNickname(),role.getRole(),buyer.getFk_roles(),role.getId());
//
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while (resultSet.next()) {
//                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//                int countColumn = resultSetMetaData.getColumnCount();
//                for (int i = 1; i < countColumn + 1; i++) {
//                    System.out.print(resultSetMetaData.getColumnLabel(i) + "=" +
//                            resultSet.getString(i) + " ");
//                }
//                System.out.println();
//            }
//
//            //количество записей
//            String sqlCount=String.format("SELECT COUNT('%s') AS " +
//                    "'Количество пользователей', (SELECT COUNT(DISTINCT '%s')" +
//                    " FROM roles) AS 'Количество ролей' FROM buyers;",
//                    buyer.getNickname(),role.getRole());
//            resultSet=statement.executeQuery(sqlCount);
//
//            System.out.print("Всего: ");
//            if (resultSet.next())
//            {
//                ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
//                int countColumn=resultSetMetaData.getColumnCount();
//                for (int i = 1; i < countColumn+1; i++) {
//                    System.out.print(resultSetMetaData.getColumnLabel(i)+"="+
//                            resultSet.getInt(i)+" ");
//                }
//                System.out.println();
//            }
//        }
//    }
//
//}
