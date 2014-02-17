SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `smail` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `smail` ;

-- -----------------------------------------------------
-- Table `t_server`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `t_server` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `domain`  VARCHAR(64) NOT NULL ,
  `host` VARCHAR(64) NOT NULL ,
  `port` INT(5) NOT NULL ,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_domain` (`domain`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `t_mail_account`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `t_mail_account` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `server_id` INT NOT NULL ,
  `username` VARCHAR(64) NOT NULL ,
  `password` VARCHAR(64) NOT NULL ,
  `mailbox` VARCHAR(64) NOT NULL ,
  `is_useful` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `t_mailbox`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `t_mailbox` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `server_id` INT NOT NULL ,
  `username` VARCHAR(18) NOT NULL ,
  `vrfy_date` DATE  NOT NULL,
  UNIQUE KEY `uk_serverid_username` (`server_id`,`username`) ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

USE `smail` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
