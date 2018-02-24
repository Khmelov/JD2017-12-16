-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema kozlov
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `kozlov` ;

-- -----------------------------------------------------
-- Schema kozlov
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kozlov` DEFAULT CHARACTER SET utf8 ;
USE `kozlov` ;

-- -----------------------------------------------------
-- Table `kozlov`.`brand`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kozlov`.`brand` ;

CREATE TABLE IF NOT EXISTS `kozlov`.`brand` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kozlov`.`city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kozlov`.`city` ;

CREATE TABLE IF NOT EXISTS `kozlov`.`city` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kozlov`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kozlov`.`roles` ;

CREATE TABLE IF NOT EXISTS `kozlov`.`roles` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kozlov`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kozlov`.`users` ;

CREATE TABLE IF NOT EXISTS `kozlov`.`users` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(50) NOT NULL,
  `Email` VARCHAR(50) NOT NULL,
  `Password` VARCHAR(50) NOT NULL,
  `city_ID` INT(11) NOT NULL,
  `Address` VARCHAR(100) NOT NULL,
  `PhoneNumber` VARCHAR(50) NOT NULL,
  `roles_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles_idx` (`roles_ID` ASC),
  INDEX `fk_users_city1_idx` (`city_ID` ASC),
  CONSTRAINT `fk_users_city1`
    FOREIGN KEY (`city_ID`)
    REFERENCES `kozlov`.`city` (`ID`),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_ID`)
    REFERENCES `kozlov`.`roles` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kozlov`.`cars`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kozlov`.`cars` ;

CREATE TABLE IF NOT EXISTS `kozlov`.`cars` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `brand_ID` INT(11) NOT NULL,
  `Model` VARCHAR(50) NOT NULL,
  `Class` VARCHAR(50) NOT NULL,
  `Price` DOUBLE NOT NULL,
  `Year` INT(11) NOT NULL,
  `users_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_cars_users1_idx` (`users_ID` ASC),
  INDEX `fk_cars_brand1_idx` (`brand_ID` ASC),
  CONSTRAINT `fk_cars_brand1`
    FOREIGN KEY (`brand_ID`)
    REFERENCES `kozlov`.`brand` (`ID`),
  CONSTRAINT `fk_cars_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `kozlov`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `kozlov`.`brand`
-- -----------------------------------------------------
START TRANSACTION;
USE `kozlov`;
INSERT INTO `kozlov`.`brand` (`ID`, `brand`) VALUES (1, 'BMW');
INSERT INTO `kozlov`.`brand` (`ID`, `brand`) VALUES (2, 'Mercedes-Benz');

COMMIT;


-- -----------------------------------------------------
-- Data for table `kozlov`.`city`
-- -----------------------------------------------------
START TRANSACTION;
USE `kozlov`;
INSERT INTO `kozlov`.`city` (`ID`, `city`) VALUES (1, 'Брестская область');
INSERT INTO `kozlov`.`city` (`ID`, `city`) VALUES (2, 'Витебская область');
INSERT INTO `kozlov`.`city` (`ID`, `city`) VALUES (3, 'Гомельская область');
INSERT INTO `kozlov`.`city` (`ID`, `city`) VALUES (4, 'Гродненская область');
INSERT INTO `kozlov`.`city` (`ID`, `city`) VALUES (5, 'Минская область');
INSERT INTO `kozlov`.`city` (`ID`, `city`) VALUES (6, 'Могилевская область');
INSERT INTO `kozlov`.`city` (`ID`, `city`) VALUES (7, 'г. Минск');

COMMIT;


-- -----------------------------------------------------
-- Data for table `kozlov`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `kozlov`;
INSERT INTO `kozlov`.`roles` (`ID`, `Role`) VALUES (1, 'admin');
INSERT INTO `kozlov`.`roles` (`ID`, `Role`) VALUES (2, 'user');

COMMIT;


-- -----------------------------------------------------
-- Data for table `kozlov`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `kozlov`;
INSERT INTO `kozlov`.`users` (`ID`, `Login`, `Email`, `Password`, `city_ID`, `Address`, `PhoneNumber`, `roles_ID`) VALUES (1, 'bayernkraft.by', 'bmw.service@bayernkraft.by', 'bayernkraft', 7, 'ул. Панченко, 9', '+375447730077', 2);
INSERT INTO `kozlov`.`users` (`ID`, `Login`, `Email`, `Password`, `city_ID`, `Address`, `PhoneNumber`, `roles_ID`) VALUES (2, 'mercedes-benz.by', 'info@mercedes-benz.by', 'mercedes', 7, 'ул. Тимирязева, 70', '+375296039999', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `kozlov`.`cars`
-- -----------------------------------------------------
START TRANSACTION;
USE `kozlov`;
INSERT INTO `kozlov`.`cars` (`ID`, `brand_ID`, `Model`, `Class`, `Price`, `Year`, `users_ID`) VALUES (1, 1, '7 series', 'Седан', 164400, 2018, 1);
INSERT INTO `kozlov`.`cars` (`ID`, `brand_ID`, `Model`, `Class`, `Price`, `Year`, `users_ID`) VALUES (2, 1, 'X6', 'Кроссовер', 132000, 2018, 1);
INSERT INTO `kozlov`.`cars` (`ID`, `brand_ID`, `Model`, `Class`, `Price`, `Year`, `users_ID`) VALUES (3, 2, 'E 200 4MATIC', 'Седан', 137706, 2018, 2);
INSERT INTO `kozlov`.`cars` (`ID`, `brand_ID`, `Model`, `Class`, `Price`, `Year`, `users_ID`) VALUES (4, 2, 'GLS', 'Внедорожник', 164700, 2018, 2);

COMMIT;

