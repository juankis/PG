SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `Colchon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Colchon` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `color` VARCHAR(45) NULL,
  `tela` VARCHAR(45) NULL,
  `cantidad` VARCHAR(45) NULL,
  `tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Medidas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Medidas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ancho` DOUBLE NULL,
  `largo` DOUBLE NULL,
  `grosor` DOUBLE NULL,
  `plazas` DOUBLE NULL,
  `Colchon_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Medidas_Colchon_idx` (`Colchon_id` ASC),
  CONSTRAINT `fk_Medidas_Colchon`
    FOREIGN KEY (`Colchon_id`)
    REFERENCES `Colchon` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Esponja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Esponja` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `material` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `Colchon_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Esponja_Colchon1_idx` (`Colchon_id` ASC),
  CONSTRAINT `fk_Esponja_Colchon1`
    FOREIGN KEY (`Colchon_id`)
    REFERENCES `Colchon` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Resortes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Resortes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NULL,
  `Colchon_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Resortes_Colchon1_idx` (`Colchon_id` ASC),
  CONSTRAINT `fk_Resortes_Colchon1`
    FOREIGN KEY (`Colchon_id`)
    REFERENCES `Colchon` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Precio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Precio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `precioCosto` DOUBLE NULL,
  `precioMayor` DOUBLE NULL,
  `Colchon_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Precio_Colchon1_idx` (`Colchon_id` ASC),
  CONSTRAINT `fk_Precio_Colchon1`
    FOREIGN KEY (`Colchon_id`)
    REFERENCES `Colchon` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Acolchado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Acolchado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NULL,
  `Colchon_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Acolchado_Colchon1_idx` (`Colchon_id` ASC),
  CONSTRAINT `fk_Acolchado_Colchon1`
    FOREIGN KEY (`Colchon_id`)
    REFERENCES `Colchon` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DobleAcolchado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DobleAcolchado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NULL,
  `altura` VARCHAR(45) NULL,
  `movible` TINYINT(1) NULL,
  `Colchon_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_DobleAcolchado_Colchon1_idx` (`Colchon_id` ASC),
  CONSTRAINT `fk_DobleAcolchado_Colchon1`
    FOREIGN KEY (`Colchon_id`)
    REFERENCES `Colchon` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
