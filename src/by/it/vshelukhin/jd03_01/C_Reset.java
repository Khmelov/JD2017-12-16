package by.it.vshelukhin.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {
    public void run() throws SQLException {

        String URL_DB = "jdbc:mysql://127.0.0.1:2016" +
                "?useUnicode=true&characterEncoding=UTF-8";
        String USER_DB = "root";
        String PASSWORD_DB = "";
        Connection myConnect = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
        Statement st = myConnect.createStatement();

        st.executeUpdate("DROP TABLE IF EXISTS `magaz`.`product` ;");
        st.executeUpdate("DROP TABLE IF EXISTS `magaz`.`rolies` ;");
        st.executeUpdate("DROP TABLE IF EXISTS `magaz`.`student` ;");
    }
}
