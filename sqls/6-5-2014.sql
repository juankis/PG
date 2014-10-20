SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `Medidas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Medidas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ancho` VARCHAR(30) NULL,
  `largo` VARCHAR(30) NULL,
  `grosor` VARCHAR(30) NULL,
  `plazas` VARCHAR(30) NULL,
  `codigo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Esponja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Esponja` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `material` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `codigo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Colchon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Colchon` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `tela` VARCHAR(45) NULL,
  `tipo` VARCHAR(45) NULL,
  `Medidas_id` INT NULL,
  `Esponja_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Colchon_Medidas1_idx` (`Medidas_id` ASC),
  INDEX `fk_Colchon_Esponja1_idx` (`Esponja_id` ASC),
  CONSTRAINT `fk_Colchon_Medidas1`
    FOREIGN KEY (`Medidas_id`)
    REFERENCES `Medidas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Colchon_Esponja1`
    FOREIGN KEY (`Esponja_id`)
    REFERENCES `Esponja` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Resortes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Resortes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Acolchado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Acolchado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DobleAcolchado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DobleAcolchado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NULL,
  `altura` VARCHAR(45) NULL,
  `movible` TINYINT(1) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Deposito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Deposito` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `detalle` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Entrada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Entrada` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Codigo` VARCHAR(45) NULL,
  `tipo` TINYINT(1) NULL,
  `fecha` DATETIME NULL,
  `detalle` VARCHAR(300) NULL,
  `cantidad` DOUBLE NULL,
  `costoUnitario` DOUBLE NULL,
  `precioUnitario` DOUBLE NULL,
  `totalCosto` DOUBLE NULL,
  `totalMayor` DOUBLE NULL,
  `stock` DOUBLE NULL,
  `Colchon_id` INT NOT NULL,
  `Deposito_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_kardex_Colchon1_idx` (`Colchon_id` ASC),
  INDEX `fk_Transaccion_Deposito1_idx` (`Deposito_id` ASC),
  CONSTRAINT `fk_kardex_Colchon1`
    FOREIGN KEY (`Colchon_id`)
    REFERENCES `Colchon` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transaccion_Deposito1`
    FOREIGN KEY (`Deposito_id`)
    REFERENCES `Deposito` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Salida` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cantidad` DOUBLE NULL,
  `fecha` DATE NULL,
  `detalle` VARCHAR(300) NULL,
  `Colchon_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Salida_Colchon1_idx` (`Colchon_id` ASC),
  CONSTRAINT `fk_Salida_Colchon1`
    FOREIGN KEY (`Colchon_id`)
    REFERENCES `Colchon` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RelacionEntradaSalida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RelacionEntradaSalida` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cantidad` DOUBLE NULL,
  `Entrada_id` INT NOT NULL,
  `salida_idSalida` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_RelacionEntradaSalida_Entrada1_idx` (`Entrada_id` ASC),
  INDEX `fk_RelacionEntradaSalida_salida1_idx` (`salida_idSalida` ASC),
  CONSTRAINT `fk_RelacionEntradaSalida_Entrada1`
    FOREIGN KEY (`Entrada_id`)
    REFERENCES `Entrada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RelacionEntradaSalida_salida1`
    FOREIGN KEY (`salida_idSalida`)
    REFERENCES `Salida` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
