/*CREATE TRIGGER last_name_changes
  BEFORE INSERT
  ON salida
  FOR EACH ROW
  EXECUTE PROCEDURE log_last_name_changes();*/
	insert into public.entrada (idcolchon, iddeposito, codigoentrada, tipoentrada, costounitario, preciounitario, totalcosto, totalmayor, cantidadentrada, fechaentrada, detalleentrada, identrada) values (1, 0, '11', '1', '10', '100', '100', '1000', '10', '2014-08-31 -04:00:00', '', 2)

