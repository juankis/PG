

 CREATE FUNCTION suficienteStock (integer) RETURNS boolean AS '
        DECLARE
            idColchonBuscado ALIAS FOR $1;
            cantStock integer;
        BEGIN
        cantStock := (select sum(cantidadentrada)
			from entrada e
			where e.idcolchon = idColchonBuscado
			group by e.idcolchon);

		if cantStock > 0 then
		return true;
		else
		return false;
		end if;
        END;
    ' LANGUAGE 'plpgsql';