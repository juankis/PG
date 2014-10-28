/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Colchon;
import Modelo.Entrada;
import Modelo.Salida;
import Vista.SalidaV;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fcpa
 */

public class SalidaC {

    
    private SalidaV salidaV;
    private Salida salida;
    private Conexion conexion;
    private ColchonC colchonC;
    Colchon colchon;
    public SalidaC(SalidaV aThis) {
        this.salidaV=aThis;
        conexion=new Conexion();
        colchonC=new ColchonC();
    }
    public boolean guardar() {
        int id=conexion.getNextValue("SELECT MAX(idsalida) FROM Salida");
            colchon = colchonC.getColchon(salidaV.getProductos().getModel().getSelectedItem().toString());
            
        if(validar()){
            descontarEntradas();
            salida=new Salida(id,colchon,salidaV.getFecha(), salidaV.getCantidad,salidaV.getDetalle(), null);
            conexion.guardar(salida);
            return true;
        }else{
            JOptionPane.showMessageDialog(null,"no exxiste suficiente stock");
            return false;
        }
        
    }
    private void descontarEntradas(){
    
    BigDecimal requerido = salidaV.getCantidad();
    EntradaC entradasC=new EntradaC();
    ArrayList<Entrada> entradas = entradasC.getEntradas();
    RelacionEntradaSalidaC relacion;
        
        for(Entrada e: entradas){
            int resCompare = e.getStockentrada().compareTo(requerido);
            if(resCompare >=0) {
                relacion= new RelacionEntradaSalidaC(salida, e, requerido.intValue());
                relacion.guardar();
                e.setStockentrada(e.getStockentrada() - requerido);
            } else {
                
            }
        }
    }
    
    private boolean validar() {
        int res = colchon.getStockactual().compareTo(salidaV.getCantidad());
        return res>=0;
    }

    public void actualizar() {
        llenarListaProductos();
    }

    private void llenarListaProductos() {
        colchonC.llenarListaProductos(salidaV.getProductos());
    }

}
