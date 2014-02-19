/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Colchon;
import Modelo.Esponja;
import Modelo.Transaccion;
import Vista.TransaccionV;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanki
 */
public class TransaccionC {

    Transaccion transaccion;
    Conexion conexion=new Conexion();
    private ArrayList<Transaccion> transacciones;
    private ArrayList<Colchon> listaProductos;
    
    public void guardar(TransaccionV transaccionV) {
        //transaccion = new Transaccion(transaccionV.getProducto(), transaccionV.getCodigo(), transaccionV.isTipo(), transaccionV.getFecha(), transaccionV.getDetalle(), transaccionV.getPrecioUnitario(), transaccionV.getCantidad(), transaccionV.getPrecioCosto(), transaccionV.getPrecioMayor());
        transaccion = new Transaccion(transaccionV.getProducto(), null, transaccionV.getCodigo(), transaccionV.isTipo(), transaccionV.getFecha(), transaccionV.getDetalle(), transaccionV.getCantidad(), transaccionV.getCostoUnitario(), transaccionV.getPrecioUnitario(), transaccionV.getPrecioCosto(), transaccionV.getPrecioMayor());
    }
    public void guardar() {
        conexion.guardar(transaccion);
    }

    public void llenarListaProductos(JComboBox productos) {
        productos.removeAllItems();
        setListaProductos(new ArrayList<Colchon>());
        conexion.getListaColchones(getListaProductos());
        for(int i=0;i<getListaProductos().size();i++){
            productos.addItem(getListaProductos().get(i).getNombre());
        }
    }

    /**
     * @return the listaProductos
     */
    public ArrayList<Colchon> getListaProductos() {
        return listaProductos;
    }

    /**
     * @param listaProductos the listaProductos to set
     */
    public void setListaProductos(ArrayList<Colchon> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void llenarTablaTransacciones(JTable jTable1) {
        setTransacciones(new ArrayList<Transaccion>());
        conexion.getListaTransacciones(getTransacciones());
        conexion.abrir();
        
        for(int i=0;i<transacciones.size();i++){
            addColchonATabla(transacciones.get(i),(DefaultTableModel)jTable1.getModel(),i);
        }
         conexion.cerrar();
    }

    /**
     * @return the transacciones
     */
    public ArrayList<Transaccion> getTransacciones() {
        return transacciones;
    }

    /**
     * @param transacciones the transacciones to set
     */
    public void setTransacciones(ArrayList<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    private void addColchonATabla(Transaccion t, DefaultTableModel defaultTableModel, int i) {
        t=(Transaccion)conexion.getObject(t);
        String[] arr={t.getCodigo(),t.getFecha().toString(),t.getColchon().getNombre(),t.getTipo().toString(),t.getPrecioUnitario().toString(),t.getCantidad().toString()};
        defaultTableModel.addRow(arr);
    }

    public void establecerTransaccionIndex(int filaSeleccionada) {
        transaccion=transacciones.get(filaSeleccionada);
    }

    public void getTransacciones(TransaccionV transaccionV) {
        transaccionV.setCodigo(transaccion.getCodigo());
        transaccionV.setFecha(transaccion.getFecha());
        conexion.abrir();
        transaccionV.setProducto((Colchon)conexion.getObject(transaccion.getColchon()));
        conexion.cerrar();
        transaccionV.setTipo(transaccion.getTipo());
        transaccionV.setPrecioUnitario(transaccion.getPrecioUnitario());
        transaccionV.setCantidad(transaccion.getCantidad());
        transaccionV.setPrecioCosto(transaccion.getTotalCosto());
        transaccionV.setPrecioMayor(transaccion.getTotalMayor());
        transaccionV.setDetalle(transaccion.getDetalle());
    }

    public boolean eliminarTransaccion() {
        boolean exito=false;
        if(!existeDependencia()){
           conexion.eliminar(transaccion);
           exito=true;
        }
        return exito;
    }

    private boolean existeDependencia() {
        /*conexion.abrir();
        transaccion=(Transaccion)conexion.getObject(transaccion);
        boolean res=;
        conexion.cerrar();
        return  !res;*/
        //aun no depende de nadie
        return false;
    }
    
}
