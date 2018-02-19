-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema patsko
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `patsko` ;

-- -----------------------------------------------------
-- Schema patsko
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `patsko` DEFAULT CHARACTER SET utf8 ;
USE `patsko` ;

-- -----------------------------------------------------
-- Table `patsko`.`catalog`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patsko`.`catalog` ;

CREATE TABLE IF NOT EXISTS `patsko`.`catalog` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `patsko`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patsko`.`category` ;

CREATE TABLE IF NOT EXISTS `patsko`.`category` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `CategoryName` VARCHAR(100) NULL DEFAULT NULL,
  `Catalog_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Category_Catalog2_idx` (`Catalog_id` ASC),
  CONSTRAINT `fk_Category_Catalog2`
    FOREIGN KEY (`Catalog_id`)
    REFERENCES `patsko`.`catalog` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `patsko`.`books`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patsko`.`books` ;

CREATE TABLE IF NOT EXISTS `patsko`.`books` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL DEFAULT NULL,
  `author` VARCHAR(200) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `Category_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Books_Category1_idx` (`Category_id` ASC),
  CONSTRAINT `fk_Books_Category1`
    FOREIGN KEY (`Category_id`)
    REFERENCES `patsko`.`category` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `patsko`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patsko`.`roles` ;

CREATE TABLE IF NOT EXISTS `patsko`.`roles` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `patsko`.`buyers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patsko`.`buyers` ;

CREATE TABLE IF NOT EXISTS `patsko`.`buyers` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `Roles_id` INT(11) NOT NULL DEFAULT '2',
  PRIMARY KEY (`id`),
  INDEX `fk_Buyers_Roles1_idx` (`Roles_id` ASC),
  CONSTRAINT `fk_Buyers_Roles1`
    FOREIGN KEY (`Roles_id`)
    REFERENCES `patsko`.`roles` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `patsko`.`list of purchases`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patsko`.`list of purchases` ;

CREATE TABLE IF NOT EXISTS `patsko`.`list of purchases` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `Buyers_id` INT(11) NOT NULL,
  `Books_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_List of purchases_Buyers2_idx` (`Buyers_id` ASC),
  INDEX `fk_List of purchases_Books1_idx` (`Books_id` ASC),
  CONSTRAINT `fk_List of purchases_Books1`
    FOREIGN KEY (`Books_id`)
    REFERENCES `patsko`.`books` (`id`),
  CONSTRAINT `fk_List of purchases_Buyers2`
    FOREIGN KEY (`Buyers_id`)
    REFERENCES `patsko`.`buyers` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
