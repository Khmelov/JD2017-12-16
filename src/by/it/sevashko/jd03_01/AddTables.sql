-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sevashko
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sevashko
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sevashko` DEFAULT CHARACTER SET utf8 ;
USE `sevashko` ;

-- -----------------------------------------------------
-- Table `sevashko`.`publications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sevashko`.`publications` (
  `index` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Индекс издания (ID)',
  `name` VARCHAR(150) NOT NULL COMMENT 'Наименование издания',
  `periodicity` INT(11) NOT NULL COMMENT 'Количество экземпляров в полугодии',
  `min_period` INT(11) NOT NULL COMMENT 'Минимальный подписной период (в месяцах)',
  `price` FLOAT NOT NULL COMMENT 'Цена за минимальный подписной период',
  PRIMARY KEY (`index`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Каталог изданий';


-- -----------------------------------------------------
-- Table `sevashko`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sevashko`.`roles` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'ID роли',
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `role_UNIQUE` (`role` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Роли пользователей';


-- -----------------------------------------------------
-- Table `sevashko`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sevashko`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL COMMENT 'Логин',
  `name` VARCHAR(45) NOT NULL COMMENT 'Имя пользователя',
  `lastName` VARCHAR(45) NOT NULL COMMENT 'Фамилия пользователя',
  `email` VARCHAR(45) NOT NULL COMMENT 'Email',
  `password` VARCHAR(20) NOT NULL COMMENT 'Пароль',
  `FK_role` INT(11) NOT NULL COMMENT 'Роль пользователя',
  PRIMARY KEY (`id`),
  INDEX `FK_roles_idx` (`FK_role` ASC),
  CONSTRAINT `FK_roles`
    FOREIGN KEY (`FK_role`)
    REFERENCES `sevashko`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Пользователи';


-- -----------------------------------------------------
-- Table `sevashko`.`subscriptions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sevashko`.`subscriptions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'ID подписки',
  `user_id` INT(11) NOT NULL COMMENT 'Пользователь',
  `publication_id` INT(11) NOT NULL COMMENT 'Издание',
  `period` INT(11) NOT NULL COMMENT 'Подписной период',
  `start_subscription` DATE NOT NULL COMMENT 'Начало подписного периода',
  `end_subscription` DATE NOT NULL COMMENT 'Конец подписного периода',
  `price` FLOAT NOT NULL COMMENT 'Цена подписки',
  PRIMARY KEY (`id`),
  INDEX `FK_usres_idx` (`user_id` ASC),
  INDEX `FK_publications_idx` (`publication_id` ASC),
  CONSTRAINT `FK_publications`
    FOREIGN KEY (`publication_id`)
    REFERENCES `sevashko`.`publications` (`index`),
  CONSTRAINT `FK_usres`
    FOREIGN KEY (`user_id`)
    REFERENCES `sevashko`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Пул подписок';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
