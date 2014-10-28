/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Entrada;
import Modelo.Relacionentradasalida;
import Modelo.Salida;
import java.math.BigDecimal;

/**
 *
 * @author juanki
 */
public class RelacionEntradaSalidaC {
    
     private Conexion conexion=new Conexion();
     Relacionentradasalida relacion;
     
    public RelacionEntradaSalidaC(Salida idSalida, Entrada idEntrada, int cantidadrelentrsal){
        int id=conexion.getNextValue("SELECT MAX(idrelacionentradasalida) FROM Relacionentradasalida");
        relacion = new Relacionentradasalida(id, idEntrada, idSalida, new BigDecimal(cantidadrelentrsal));
    }
    
    public void guardar() {
        conexion.guardar(relacion);
    }
}
