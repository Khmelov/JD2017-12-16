package by.it.vshelukhin.jd03_05.java.dao;

import by.it.vshelukhin.jd03_05.java.dao.connection.MyConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyReset {
     public void run() throws SQLException {
         try (Connection connection = MyConnect.getConnection();
              Statement st = connection.createStatement();) {

             st.executeUpdate("DROP SCHEMA IF EXISTS `magaz` ;");
             st.executeUpdate("CREATE SCHEMA IF NOT EXISTS `magaz` DEFAULT CHARACTER SET utf8 ;");
             st.executeUpdate("DROP TABLE IF EXISTS `magaz`.`roles` ;");
             st.executeUpdate("CREATE TABLE IF NOT EXISTS `magaz`.`roles` (\n" +
                     "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                     "  `role` VARCHAR(200) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,\n" +
                     "  PRIMARY KEY (`id`))\n" +
                     "ENGINE = InnoDB\n" +
                     "AUTO_INCREMENT = 1\n" +
                     "DEFAULT CHARACTER SET = utf8\n" +
                     "COLLATE = utf8_unicode_ci;");
             st.executeUpdate("DROP TABLE IF EXISTS `magaz`.`students` ;\n");
             st.executeUpdate("CREATE TABLE IF NOT EXISTS `magaz`.`students` (\n" +
                     "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                     "  `login` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,\n" +
                     "  `password` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,\n" +
                     "  `univer` VARCHAR(200) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,\n" +
                     "  `kurs` INT(11) NOT NULL,\n" +
                     "  `facultet` VARCHAR(200) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,\n" +
                     "  `price` DOUBLE NOT NULL,\n" +
                     "  `roles_id` INT(11) NOT NULL,\n" +
                     "  PRIMARY KEY (`id`),\n" +
                     "  INDEX `fk_students_roles1_idx` (`roles_id` ASC),\n" +
                     "  CONSTRAINT `fk_students_roles1`\n" +
                     "    FOREIGN KEY (`roles_id`)\n" +
                     "    REFERENCES `magaz`.`roles` (`id`)\n" +
                     "    ON DELETE RESTRICT\n" +
                     "    ON UPDATE RESTRICT)\n" +
                     "ENGINE = InnoDB\n" +
                     "AUTO_INCREMENT = 1\n" +
                     "DEFAULT CHARACTER SET = utf8\n" +
                     "COLLATE = utf8_unicode_ci;");
             st.executeUpdate("DROP TABLE IF EXISTS `magaz`.`works` ;");
             st.executeUpdate("CREATE TABLE IF NOT EXISTS `magaz`.`works` (\n" +
                     "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                     "  `name` VARCHAR(500) NOT NULL,\n" +
                     "  `price` FLOAT NOT NULL,\n" +
                     "  PRIMARY KEY (`id`))\n" +
                     "ENGINE = InnoDB\n" +
                     "AUTO_INCREMENT = 1\n" +
                     "DEFAULT CHARACTER SET = utf8;");

             st.executeUpdate("DROP TABLE IF EXISTS `magaz`.`zakaz` ;");
             st.executeUpdate("CREATE TABLE IF NOT EXISTS `magaz`.`zakaz` (\n" +
                     "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                     "  `students_id` INT(11) NOT NULL,\n" +
                     "  `works_id` INT(11) NOT NULL,\n" +
                     "  PRIMARY KEY (`id`),\n" +
                     "  INDEX `fk_zakaz_students1_idx` (`students_id` ASC),\n" +
                     "  INDEX `fk_zakaz_works1_idx` (`works_id` ASC),\n" +
                     "  CONSTRAINT `fk_zakaz_students1`\n" +
                     "    FOREIGN KEY (`students_id`)\n" +
                     "    REFERENCES `magaz`.`students` (`id`)\n" +
                     "    ON DELETE CASCADE\n" +
                     "    ON UPDATE CASCADE,\n" +
                     "  CONSTRAINT `fk_zakaz_works1`\n" +
                     "    FOREIGN KEY (`works_id`)\n" +
                     "    REFERENCES `magaz`.`works` (`id`)\n" +
                     "    ON DELETE RESTRICT\n" +
                     "    ON UPDATE CASCADE)\n" +
                     "ENGINE = InnoDB\n" +
                     "AUTO_INCREMENT = 1\n" +
                     "DEFAULT CHARACTER SET = utf8\n" +
                     "COLLATE = utf8_unicode_ci;");

             st.executeUpdate("ALTER TABLE `magaz`.`zakaz` DROP FOREIGN KEY `fk_zakaz_works1`;");
             st.executeUpdate("ALTER TABLE `magaz`.`zakaz` ADD  CONSTRAINT `fk_zakaz_works1` FOREIGN KEY (`works_id`) REFERENCES `magaz`.`works`(`id`) ON DELETE CASCADE ON UPDATE CASCADE;");

             st.executeUpdate("INSERT INTO `magaz`.`roles`(`role`) VALUES ('Администратор')");
             st.executeUpdate("INSERT INTO `magaz`.`roles`(`role`) VALUES ('Клиент')");
             st.executeUpdate("INSERT INTO `magaz`.`roles`(`role`) VALUES ('Гость')");

             st.executeUpdate("INSERT INTO `magaz`.`students`(`login`, `password`, `univer`, `kurs`, `facultet`, `price`, `roles_id`) VALUES ('log1','pas1','БНТУ',1,'ЭФ',80.5,2)");
             st.executeUpdate("INSERT INTO `magaz`.`students`(`login`, `password`, `univer`, `kurs`, `facultet`, `price`, `roles_id`) VALUES ('log2','pas2','БГУИР',2,'ИТ',100.0,2)");
             st.executeUpdate("INSERT INTO `magaz`.`students`(`login`, `password`, `univer`, `kurs`, `facultet`, `price`, `roles_id`) VALUES ('log3','pas3','Админ',0,'админ',0.0,1)");

             st.executeUpdate("INSERT INTO `magaz`.`works`(`name`, `price`) VALUES ('Контрольная по химии',45)");
             st.executeUpdate("INSERT INTO `magaz`.`works`(`name`, `price`) VALUES ('Контрольная по физике',40)");
             st.executeUpdate("INSERT INTO `magaz`.`works`(`name`, `price`) VALUES ('Контрольная по математике',30)");
             st.executeUpdate("INSERT INTO `magaz`.`works`(`name`, `price`) VALUES ('Контрольная по начерталке',20)");

             st.executeUpdate("INSERT INTO `magaz`.`zakaz`(`students_id`, `works_id`) VALUES (1,1)");
             st.executeUpdate("INSERT INTO `magaz`.`zakaz`(`students_id`, `works_id`) VALUES (1,3)");
             st.executeUpdate("INSERT INTO `magaz`.`zakaz`(`students_id`, `works_id`) VALUES (1,4)");
             st.executeUpdate("INSERT INTO `magaz`.`zakaz`(`students_id`, `works_id`) VALUES (2,1)");
             st.executeUpdate("INSERT INTO `magaz`.`zakaz`(`students_id`, `works_id`) VALUES (2,2)");
             st.executeUpdate("INSERT INTO `magaz`.`zakaz`(`students_id`, `works_id`) VALUES (2,3)");
         }
     }
}
