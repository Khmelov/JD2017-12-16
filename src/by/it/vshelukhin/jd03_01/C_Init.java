package by.it.vshelukhin.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

        public void run() throws SQLException{

        String URL_DB = "jdbc:mysql://127.0.0.1:2016"+
                "?useUnicode=true&characterEncoding=UTF-8";
        String USER_DB = "root";
        String PASSWORD_DB = "";
        Connection myConnect = DriverManager.getConnection(URL_DB,USER_DB, PASSWORD_DB);
        Statement st = myConnect.createStatement();

        st.executeUpdate("DROP SCHEMA IF EXISTS `magaz` ;");
        st.executeUpdate("CREATE SCHEMA IF NOT EXISTS `magaz` DEFAULT CHARACTER SET utf8 ;");
        st.executeUpdate("DROP TABLE IF EXISTS `magaz`.`product` ;");
        st.executeUpdate("CREATE TABLE IF NOT EXISTS `magaz`.`product` (\n" +
                "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(1000) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,\n" +
                "  `fk_students` INT(11) NOT NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB\n" +
                "AUTO_INCREMENT = 1\n" +
                "DEFAULT CHARACTER SET = utf8\n" +
                "COLLATE = utf8_unicode_ci;");
        st.executeUpdate("DROP TABLE IF EXISTS `magaz`.`rolies` ;");
        st.executeUpdate("CREATE TABLE IF NOT EXISTS `magaz`.`rolies` (\n" +
                "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `role` VARCHAR(200) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB\n" +
                "AUTO_INCREMENT = 1\n" +
                "DEFAULT CHARACTER SET = utf8\n" +
                "COLLATE = utf8_unicode_ci;");
        st.executeUpdate("DROP TABLE IF EXISTS `magaz`.`student` ;");
        st.executeUpdate("\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS `magaz`.`student` (\n" +
                "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `univer` VARCHAR(200) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,\n" +
                "  `kurs` INT(11) NOT NULL,\n" +
                "  `facultet` VARCHAR(200) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,\n" +
                "  `price` DOUBLE NOT NULL,\n" +
                "  `id_role` INT(11) NOT NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB\n" +
                "AUTO_INCREMENT = 1\n" +
                "DEFAULT CHARACTER SET = utf8\n" +
                "COLLATE = utf8_unicode_ci;\n");
        st.executeUpdate("INSERT INTO `magaz`.`rolies`(`role`) VALUES ('Посетитель')");
        st.executeUpdate("INSERT INTO `magaz`.`rolies`(`role`) VALUES ('Администратор')");
        st.executeUpdate("INSERT INTO `magaz`.`student`(`univer`, `kurs`, `facultet`, `price`, `id_role`) VALUES ('БНТУ',1,'ЭФ',55.0,1)");
        st.executeUpdate("INSERT INTO `magaz`.`student`(`univer`, `kurs`, `facultet`, `price`, `id_role`) VALUES ('БГУИР',2,'ИТ',100.0,1)");
        st.executeUpdate("INSERT INTO `magaz`.`student`(`univer`, `kurs`, `facultet`, `price`, `id_role`) VALUES ('Админ',0,'админ',0.0,2)");
        st.executeUpdate("INSERT INTO `magaz`.`product`(`name`, `fk_students`) VALUES ('Коптрольная по химии 1',1)");
        st.executeUpdate("INSERT INTO `magaz`.`product`(`name`, `fk_students`) VALUES ('Коптрольная по химии 2',1)");
        st.executeUpdate("INSERT INTO `magaz`.`product`(`name`, `fk_students`) VALUES ('Коптрольная по химии 1',2)");
        st.executeUpdate("INSERT INTO `magaz`.`product`(`name`, `fk_students`) VALUES ('Коптрольная по математике',2)");
    }
}
