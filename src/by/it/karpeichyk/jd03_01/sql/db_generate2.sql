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
DROP TABLE IF EXISTS `karpeychik`.`roles` ;

CREATE TABLE IF NOT EXISTS `karpeychik`.`roles` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `ROLE` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `karpeychik`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karpeychik`.`users` ;

CREATE TABLE IF NOT EXISTS `karpeychik`.`users` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(50) NOT NULL,
  `Pasword` VARCHAR(50) NOT NULL,
  `Email` VARCHAR(50) NOT NULL,
  `FK_roles` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles_idx` (`FK_roles` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`FK_roles`)
    REFERENCES `karpeychik`.`roles` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `karpeychik`.`ads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karpeychik`.`ads` ;

CREATE TABLE IF NOT EXISTS `karpeychik`.`ads` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Description` VARCHAR(50) NOT NULL,
  `Carrying` INT(11) NOT NULL,
  `Volume` INT(11) NOT NULL,
  `Tariff` VARCHAR(50) NOT NULL,
  `FK_Users` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ads_users1_idx` (`FK_Users` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`FK_Users`)
    REFERENCES `karpeychik`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `karpeychik`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `karpeychik`;
INSERT INTO `karpeychik`.`ads` (`ID`, `Description`, `Carrying`, `Volume`, `Tariff`, `FK_Users`) VALUES (DEFAULT, ' Грузоперевозки по Рб и РФ', 20, 120, '1.5$ за километр', 2);
INSERT INTO `karpeychik`.`ads` (`ID`, `Description`, `Carrying`, `Volume`, `Tariff`, `FK_Users`) VALUES (DEFAULT, 'Грузоперевозки по Рб', 5, 50, '0.75 $ за километр', 2);
INSERT INTO `karpeychik`.`ads` (`ID`, `Description`, `Carrying`, `Volume`, `Tariff`, `FK_Users`) VALUES (DEFAULT, 'Грузоперевозки по Европе', 20, 120, '1.65 $ за километр', 2);
INSERT INTO `karpeychik`.`ads` (`ID`, `Description`, `Carrying`, `Volume`, `Tariff`, `FK_Users`) VALUES (DEFAULT, 'Грузоперевозки по Рб и РФ', 10, 80, '0.95 $ за километр', 2);

COMMIT;

