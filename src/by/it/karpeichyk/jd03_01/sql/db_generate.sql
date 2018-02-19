-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema karpeychik
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `karpeychik` ;

-- -----------------------------------------------------
-- Schema karpeychik
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `karpeychik` DEFAULT CHARACTER SET utf8 ;
USE `karpeychik` ;

-- -----------------------------------------------------
-- Table `karpeychik`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `karpeychik`.`roles` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `ROLE` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `karpeychik`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `karpeychik`.`users` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(50) NOT NULL,
  `Pasword` VARCHAR(50) NOT NULL,
  `FK_roles` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles_idx` (`FK_roles` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`FK_roles`)
    REFERENCES `karpeychik`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `karpeychik`.`ads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `karpeychik`.`ads` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Description` VARCHAR(50) NOT NULL,
  `Floor` INT(11) NOT NULL,
  `Floors` INT(11) NOT NULL,
  `Price` DOUBLE NOT NULL,
  `Area` DOUBLE NOT NULL,
  `FK_Users` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ads_users1_idx` (`FK_Users` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`FK_Users`)
    REFERENCES `karpeychik`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Data for table `karpeychik`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `karpeychik`;
INSERT INTO `karpeychik`.`roles` (`ID`, `ROLE`) VALUES (DEFAULT, 'Admin');
INSERT INTO `karpeychik`.`roles` (`ID`, `ROLE`) VALUES (DEFAULT, 'User');

COMMIT;


-- -----------------------------------------------------
-- Data for table `karpeychik`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `karpeychik`;
INSERT INTO `karpeychik`.`users` (`ID`, `Login`, `Pasword`, `FK_roles`) VALUES (DEFAULT, 'admin', 'admin', 1);
INSERT INTO `karpeychik`.`users` (`ID`, `Login`, `Pasword`, `FK_roles`) VALUES (DEFAULT, 'user', 'user', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `karpeychik`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `karpeychik`;
INSERT INTO `karpeychik`.`ads` (`ID`, `Description`, `Floor`, `Floors`, `Price`, `Area`, `FK_Users`) VALUES (DEFAULT, 'ddddd', 1, 5, 5555, 55, 2);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
