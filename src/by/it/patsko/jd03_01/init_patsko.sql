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
-- Table `patsko`.`Roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patsko`.`Roles` ;

CREATE TABLE IF NOT EXISTS `patsko`.`Roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `patsko`.`Buyers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patsko`.`Buyers` ;

CREATE TABLE IF NOT EXISTS `patsko`.`Buyers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `Roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Buyers_Roles1_idx` (`Roles_id` ASC),
  CONSTRAINT `fk_Buyers_Roles1`
    FOREIGN KEY (`Roles_id`)
    REFERENCES `patsko`.`Roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `patsko`.`Catalog`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patsko`.`Catalog` ;

CREATE TABLE IF NOT EXISTS `patsko`.`Catalog` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(10) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `patsko`.`Category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patsko`.`Category` ;

CREATE TABLE IF NOT EXISTS `patsko`.`Category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `CategoryName` VARCHAR(100) NULL,
  `Catalog_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Category_Catalog2_idx` (`Catalog_id` ASC),
  CONSTRAINT `fk_Category_Catalog2`
    FOREIGN KEY (`Catalog_id`)
    REFERENCES `patsko`.`Catalog` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `patsko`.`Books`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patsko`.`Books` ;

CREATE TABLE IF NOT EXISTS `patsko`.`Books` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL,
  `author` VARCHAR(200) NULL,
  `price` DOUBLE NULL,
  `Category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Books_Category1_idx` (`Category_id` ASC),
  CONSTRAINT `fk_Books_Category1`
    FOREIGN KEY (`Category_id`)
    REFERENCES `patsko`.`Category` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `patsko`.`List of purchases`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patsko`.`List of purchases` ;

CREATE TABLE IF NOT EXISTS `patsko`.`List of purchases` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Buyers_id` INT NOT NULL,
  `Books_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_List of purchases_Buyers2_idx` (`Buyers_id` ASC),
  INDEX `fk_List of purchases_Books1_idx` (`Books_id` ASC),
  CONSTRAINT `fk_List of purchases_Buyers2`
    FOREIGN KEY (`Buyers_id`)
    REFERENCES `patsko`.`Buyers` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_List of purchases_Books1`
    FOREIGN KEY (`Books_id`)
    REFERENCES `patsko`.`Books` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `patsko`.`Roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `patsko`;
INSERT INTO `patsko`.`Roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `patsko`.`Roles` (`id`, `role`) VALUES (DEFAULT, 'buyer');

COMMIT;


-- -----------------------------------------------------
-- Data for table `patsko`.`Buyers`
-- -----------------------------------------------------
START TRANSACTION;
USE `patsko`;
INSERT INTO `patsko`.`Buyers` (`id`, `login`, `password`, `email`, `Roles_id`) VALUES (DEFAULT, 'admin', 'password', 'admin@admin.by', 1);
INSERT INTO `patsko`.`Buyers` (`id`, `login`, `password`, `email`, `Roles_id`) VALUES (DEFAULT, 'buyer1', 'qwerty', 'buyer1@buyer.by', 2);
INSERT INTO `patsko`.`Buyers` (`id`, `login`, `password`, `email`, `Roles_id`) VALUES (DEFAULT, 'buyer2', '12345', 'buyer2@buyer.by', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `patsko`.`Catalog`
-- -----------------------------------------------------
START TRANSACTION;
USE `patsko`;
INSERT INTO `patsko`.`Catalog` (`id`, `name`) VALUES (DEFAULT, 'Каталог книг');

COMMIT;


-- -----------------------------------------------------
-- Data for table `patsko`.`Category`
-- -----------------------------------------------------
START TRANSACTION;
USE `patsko`;
INSERT INTO `patsko`.`Category` (`id`, `CategoryName`, `Catalog_id`) VALUES (DEFAULT, 'Цифровые технологии', 1);
INSERT INTO `patsko`.`Category` (`id`, `CategoryName`, `Catalog_id`) VALUES (DEFAULT, 'Художественная литература', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `patsko`.`Books`
-- -----------------------------------------------------
START TRANSACTION;
USE `patsko`;
INSERT INTO `patsko`.`Books` (`id`, `name`, `author`, `price`, `Category_id`) VALUES (DEFAULT, 'Java. Эффективное программирование', 'Джошуа Блох', 200, 1);
INSERT INTO `patsko`.`Books` (`id`, `name`, `author`, `price`, `Category_id`) VALUES (DEFAULT, 'Java 8. Полное руководство', 'Герберт Шилдт', 500, 1);
INSERT INTO `patsko`.`Books` (`id`, `name`, `author`, `price`, `Category_id`) VALUES (DEFAULT, 'Оно', 'Стивен Кинг', 100, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `patsko`.`List of purchases`
-- -----------------------------------------------------
START TRANSACTION;
USE `patsko`;
INSERT INTO `patsko`.`List of purchases` (`id`, `Buyers_id`, `Books_id`) VALUES (DEFAULT, 1, 1);
INSERT INTO `patsko`.`List of purchases` (`id`, `Buyers_id`, `Books_id`) VALUES (DEFAULT, 1, 3);
INSERT INTO `patsko`.`List of purchases` (`id`, `Buyers_id`, `Books_id`) VALUES (DEFAULT, 2, 2);

COMMIT;

