-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema viktorbrui
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `viktorbrui` ;

-- -----------------------------------------------------
-- Schema viktorbrui
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `viktorbrui` DEFAULT CHARACTER SET latin1 ;
USE `viktorbrui` ;

-- -----------------------------------------------------
-- Table `viktorbrui`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viktorbrui`.`roles` ;

CREATE TABLE IF NOT EXISTS `viktorbrui`.`roles` (
  `ID` INT(50) NOT NULL AUTO_INCREMENT,
  `Roles` VARCHAR(50) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `viktorbrui`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viktorbrui`.`user` ;

CREATE TABLE IF NOT EXISTS `viktorbrui`.`user` (
  `ID` INT(50) NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(50) NULL DEFAULT NULL,
  `email` VARCHAR(50) NULL,
  `password` VARCHAR(50) NULL DEFAULT NULL,
  `address` VARCHAR(55) NULL DEFAULT NULL,
  `phone` INT(50) NULL DEFAULT NULL,
  `FK_Roles` INT(50) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_user_roles1_idx` (`FK_Roles` ASC),
  FULLTEXT INDEX `password` (`password` ASC),
  CONSTRAINT `fk_user_roles1`
    FOREIGN KEY (`FK_Roles`)
    REFERENCES `viktorbrui`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `viktorbrui`.`products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viktorbrui`.`products` ;

CREATE TABLE IF NOT EXISTS `viktorbrui`.`products` (
  `ID` INT(50) NOT NULL AUTO_INCREMENT,
  `ProductName` VARCHAR(50) NULL,
  `Sku` VARCHAR(50) NULL,
  `Count` INT(55) NULL,
  `Price` INT(50) NULL,
  `PriceCurrencу` VARCHAR(50) NULL,
  `FK_Users` INT(50) NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_products_user1_idx` (`FK_Users` ASC),
  CONSTRAINT `fk_products_user1`
    FOREIGN KEY (`FK_Users`)
    REFERENCES `viktorbrui`.`user` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `viktorbrui`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `viktorbrui`;
INSERT INTO `viktorbrui`.`roles` (`ID`, `Roles`) VALUES (NULL, 'Administraor');
INSERT INTO `viktorbrui`.`roles` (`ID`, `Roles`) VALUES (NULL, 'User');
INSERT INTO `viktorbrui`.`roles` (`ID`, `Roles`) VALUES (NULL, 'Guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `viktorbrui`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `viktorbrui`;
INSERT INTO `viktorbrui`.`user` (`ID`, `nickname`, `email`, `password`, `address`, `phone`, `FK_Roles`) VALUES (NULL, 'Administrator', 'Admin@mail.ru', 'Admin1234', 'AdministrationCenter', 3333333, 1);
INSERT INTO `viktorbrui`.`user` (`ID`, `nickname`, `email`, `password`, `address`, `phone`, `FK_Roles`) VALUES (NULL, 'User', 'User@mail.ru', 'User1234', 'UserCenter', 2222222, 2);
INSERT INTO `viktorbrui`.`user` (`ID`, `nickname`, `email`, `password`, `address`, `phone`, `FK_Roles`) VALUES (NULL, 'Guest', 'Guest@mail.ru', 'Guest1234', 'GuestCenter', 11111111, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `viktorbrui`.`products`
-- -----------------------------------------------------
START TRANSACTION;
USE `viktorbrui`;
INSERT INTO `viktorbrui`.`products` (`ID`, `ProductName`, `Sku`, `Count`, `Price`, `PriceCurrencу`, `FK_Users`) VALUES (NULL, 'Poland', 'A4754P3', 1, 120, 'euro', 2);
INSERT INTO `viktorbrui`.`products` (`ID`, `ProductName`, `Sku`, `Count`, `Price`, `PriceCurrencу`, `FK_Users`) VALUES (NULL, 'Russia', 'A4234D7', 2, 600, 'euro', 2);

COMMIT;

