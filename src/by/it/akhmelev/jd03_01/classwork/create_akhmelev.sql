-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema akhmelev
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `akhmelev` ;

-- -----------------------------------------------------
-- Schema akhmelev
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `akhmelev` DEFAULT CHARACTER SET utf8 ;
USE `akhmelev` ;

-- -----------------------------------------------------
-- Table `akhmelev`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `akhmelev`.`roles` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `akhmelev`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `akhmelev`.`users` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(50) NOT NULL,
  `Email` VARCHAR(50) NOT NULL,
  `Password` VARCHAR(50) NOT NULL,
  `FK_roles` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles1_idx` (`FK_roles` ASC),
  CONSTRAINT `fk_users_roles1`
    FOREIGN KEY (`FK_roles`)
    REFERENCES `akhmelev`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `akhmelev`.`ads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `akhmelev`.`ads` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Description` VARCHAR(2000) NOT NULL,
  `Address` VARCHAR(300) NOT NULL,
  `Flool` INT(11) NOT NULL,
  `Floors` INT(11) NOT NULL,
  `RoomCount` INT(11) NOT NULL,
  `Price` DOUBLE NOT NULL,
  `Area` DOUBLE NOT NULL,
  `FK_users` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ads_users1_idx` (`FK_users` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`FK_users`)
    REFERENCES `akhmelev`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Data for table `akhmelev`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `akhmelev`;
INSERT INTO `akhmelev`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'Administrator');
INSERT INTO `akhmelev`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'User');
INSERT INTO `akhmelev`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'Guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `akhmelev`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `akhmelev`;
INSERT INTO `akhmelev`.`users` (`ID`, `Login`, `Email`, `Password`, `FK_roles`) VALUES (DEFAULT, 'admin', 'admin@it.by', 'admin', 1);
INSERT INTO `akhmelev`.`users` (`ID`, `Login`, `Email`, `Password`, `FK_roles`) VALUES (DEFAULT, 'user', 'user@it.by', 'user', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `akhmelev`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `akhmelev`;
INSERT INTO `akhmelev`.`ads` (`ID`, `Description`, `Address`, `Flool`, `Floors`, `RoomCount`, `Price`, `Area`, `FK_users`) VALUES (DEFAULT, 'Good price', 'Lenina 1', 1, 1, 1, 111111, 111, 2);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
