
CREATE OR REPLACE FUNCTION descontarStock()
  RETURNS trigger AS
$BODY$
DECLARE
    requerido decimal:=NEW.cantidadSalida;
    entredaV Record;
BEGIN
	FOR entredaV in select e.* from entrada e where e.identrada and e.stockactual>0 LOOP
		IF entradaV.cantidadentrada > requerido THEN
			insert into relacionentradaSalida (cantidadrelentrsal) values (requerido);
			update entrada set stockEntrada = cantidadStock - requerido;
			EXIT;
		ELSE
			insert into relacionentradaSalida (cantidadrelentrsal) values (entradaV.cantidadentrada);
			update entrada set stockEntrada = 0;
		END IF;
		update colchon set cantidadStock = cantidadStock - requerido;
	END LOOP;
    RETURN null;
END;
$BODY$
  LANGUAGE plpgsql;


CREATE TRIGGER descontarStock
BEFORE INSERT 
ON salida
FOR EACH ROW
EXECUTE PROCEDURE  descontarStock();