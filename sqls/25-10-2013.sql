SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Colchon`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Colchon` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `color` VARCHAR(45) NULL ,
  `tela` VARCHAR(45) NULL ,
  `cantidad` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Medidas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Medidas` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `ancho` DECIMAL(10,0) NULL ,
  `largo` DECIMAL(10,0) NULL ,
  `grosor` DECIMAL(10,0) NULL ,
  `plazas` DECIMAL(10,0) NULL ,
  `Colchon_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Medidas_Colchon_idx` (`Colchon_id` ASC) ,
  CONSTRAINT `fk_Medidas_Colchon`
    FOREIGN KEY (`Colchon_id` )
    REFERENCES `mydb`.`Colchon` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Esponja`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Esponja` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `material` VARCHAR(45) NULL ,
  `color` VARCHAR(45) NULL ,
  `Colchon_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Esponja_Colchon1_idx` (`Colchon_id` ASC) ,
  CONSTRAINT `fk_Esponja_Colchon1`
    FOREIGN KEY (`Colchon_id` )
    REFERENCES `mydb`.`Colchon` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Resortes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Resortes` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `tipo` VARCHAR(45) NULL ,
  `Colchon_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Resortes_Colchon1_idx` (`Colchon_id` ASC) ,
  CONSTRAINT `fk_Resortes_Colchon1`
    FOREIGN KEY (`Colchon_id` )
    REFERENCES `mydb`.`Colchon` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Colchones`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Colchones` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `material` VARCHAR(45) NULL ,
  `medidas` VARCHAR(45) NULL ,
  `tipo` VARCHAR(45) NULL ,
  `Colchon_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Colchones_Colchon1_idx` (`Colchon_id` ASC) ,
  CONSTRAINT `fk_Colchones_Colchon1`
    FOREIGN KEY (`Colchon_id` )
    REFERENCES `mydb`.`Colchon` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Precio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Precio` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `precioCosto` DECIMAL(10,0) NULL ,
  `precioMayor` DECIMAL(10,0) NULL ,
  `Colchon_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Precio_Colchon1_idx` (`Colchon_id` ASC) ,
  CONSTRAINT `fk_Precio_Colchon1`
    FOREIGN KEY (`Colchon_id` )
    REFERENCES `mydb`.`Colchon` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Acolchado`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Acolchado` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `tipo` VARCHAR(45) NULL ,
  `Colchon_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Acolchado_Colchon1_idx` (`Colchon_id` ASC) ,
  CONSTRAINT `fk_Acolchado_Colchon1`
    FOREIGN KEY (`Colchon_id` )
    REFERENCES `mydb`.`Colchon` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DobleAcolchado`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`DobleAcolchado` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `tipo` VARCHAR(45) NULL ,
  `altura` VARCHAR(45) NULL ,
  `movible` TINYINT(1) NULL ,
  `Colchon_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_DobleAcolchado_Colchon1_idx` (`Colchon_id` ASC) ,
  CONSTRAINT `fk_DobleAcolchado_Colchon1`
    FOREIGN KEY (`Colchon_id` )
    REFERENCES `mydb`.`Colchon` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `mydb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
