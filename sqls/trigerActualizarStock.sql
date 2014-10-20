


CREATE OR REPLACE FUNCTION actualizarStock()
  RETURNS trigger AS
$BODY$
DECLARE
    stockActualVar decimal;
BEGIN
	stockActualVar:=(select c.stockActual from colchon  c where idcolchon=NEW.idcolchon);
	update colchon set stockActual = stockActual+NEW.cantidadEntrada where idcolchon=NEW.idcolchon;
    RETURN null;
END;
$BODY$
  LANGUAGE plpgsql;


  
 
CREATE TRIGGER actualizarStock
AFTER INSERT 
ON entrada
FOR EACH ROW
EXECUTE PROCEDURE actualizarStock();