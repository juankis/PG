
CREATE OR REPLACE FUNCTION descontarstock()
  RETURNS trigger AS
$BODY$
DECLARE
    requerido decimal:=NEW.cantidadSalida;
    entradaV Record;
BEGIN
	FOR entradaV in select e.* from entrada e where e.idcolchon = NEW.idcolchon and e.stockEntrada > 0 LOOP
	        IF entradaV.stockEntrada > requerido THEN
			insert into relacionentradaSalida (cantidadrelentrsal) values (requerido);
			update entrada set stockEntrada = stockEntrada - requerido;
			Exit;
		ELSE
			insert into relacionentradaSalida (cantidadrelentrsal) values (entradaV.cantidadentrada);
			update entrada set stockEntrada = 0;
		END IF;
		update colchon set stockActual = stockActual - requerido;
	END LOOP;
    RETURN null;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION descontarstock()
  OWNER TO postgres;


CREATE TRIGGER descontarStock
BEFORE INSERT 
ON salida
FOR EACH ROW
EXECUTE PROCEDURE  descontarStock();