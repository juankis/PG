/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Salida;
import Vista.SalidaV;

/**
 *
 * @author fcpa
 */

public class SalidaC {

    
    private SalidaV salidaV;
    private Salida salida;
    private Conexion conexion;
    private ColchonC colchon;
    public SalidaC(SalidaV aThis) {
        this.salidaV=aThis;
        conexion=new Conexion();
        colchon=new ColchonC();
    }
    public void guardar() {
        if(validar()){
            //System.out.println(colchon.getColchon(salidaV.getProductos().getModel().getSelectedItem().toString())+""+salidaV.getCantidad()+""+ salidaV.getFecha()+""+ salidaV.getDetalle());
            salida=new Salida();
            salida=new Salida(salida.getIdsalida(),
                    colchon.getColchon(salidaV.getProductos().getModel().getSelectedItem().toString()),
                    salidaV.getFecha(), salidaV.getCantidad(),salidaV.getDetalle(), null);
            conexion.guardar(salida);
        }
    }

    private boolean validar() {
        return true;
    }

    public void actualizar() {
        llenarListaProductos();
    }

    private void llenarListaProductos() {
        colchon.llenarListaProductos(salidaV.getProductos());
    }

}
