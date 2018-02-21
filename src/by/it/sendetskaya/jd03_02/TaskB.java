package by.it.sendetskaya.jd03_02;

import java.sql.*;

public class TaskB {


    public static void selectUser ()  throws SQLException {

//        Buyer_CRUD buyer_crud =new Buyer_CRUD();
//        Buyer buyer= buyer_crud.readAll();
//
//        Role_CRUD role_crud=new Role_CRUD();
//        Role role=role_crud.readAll();

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
