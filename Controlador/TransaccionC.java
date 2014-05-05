/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Colchon;
import Modelo.Deposito;
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
    TransaccionV transaccionV;
    Conexion conexion=new Conexion();
    private ArrayList<Transaccion> transacciones;
    private ArrayList<Colchon> listaProductos;
    private ArrayList<Deposito> listaDepositos;
    private Validacion validacion;
    
    public TransaccionC(TransaccionV transaccionV){
        this.transaccionV=transaccionV;
        validacion = new Validacion();
    }
    
    public void guardar() {
        if(transaccionV.validar()){
            guardarTransaccion();
        }
        
    }
    
    /*private boolean validar() {
        boolean res;
        if(!validacion.esVacioJTextField(transaccion.jTextFieldCodigo)){
            if(!validacion.esVacioJTextField(jTextFieldPrecioUnitario)){
                if(!validacion.esVacioJTextField(jTextFieldCostoUnitario)){
                    if(isEntrada()){                        
                        codigo=jTextFieldCodigo.getText();
                        tipo=isEntrada();
                        fecha=jDateChooser.getDate();
                        detalle=jTextFieldDetalle.getText();
                        precioUnitario=Double.parseDouble(jTextFieldPrecioUnitario.getText());
                        costoUnitario=Double.parseDouble(jTextFieldCostoUnitario.getText());
                        cantidad=Double.parseDouble(jTextFieldCantidad.getText());
                        precioCosto=Double.parseDouble(jTextFieldPrecioCosto.getText());
                        precioMayor=Double.parseDouble(jTextFieldPrecioMayor.getText());
                        producto=transaccion.getListaProductos().get(jComboBoxProducto.getSelectedIndex());
                        deposito=transaccion.getListaDepositos().get(jComboBoxDepositos.getSelectedIndex());
                        res= true;
                    }else{
                        validarSalida();
                        res= true;
                    }
                }else{
                    res=false;
                    validacion.mostrarMensaje("debe introducir el costo unitario");
                }
            }else{
                res=false;
                validacion.mostrarMensaje("debe introducir el precio unitario");
            }
        }else{
            res=false;
            validacion.mostrarMensaje("debe introducir el codigo de la transaccion");
        }
        return res;
    }*/
    
    public void guardarTransaccion() {
        transaccion = new Transaccion(transaccionV.getProducto(), transaccionV.getDeposito(), transaccionV.getCodigo(), transaccionV.isTipo(),
                transaccionV.getFecha(), transaccionV.getDetalle(), transaccionV.getCantidad(), transaccionV.getCostoUnitario(),
                transaccionV.getPrecioUnitario(), transaccionV.getPrecioCosto(), transaccionV.getPrecioMayor());
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

    public void llenarListaDepositos(JComboBox jComboBoxDepositos) {
        jComboBoxDepositos.removeAllItems();
        setListaDepositos(new ArrayList<Deposito>());
        conexion.getListaDepositos(getListaDepositos());
        for(int i=0;i<getListaDepositos().size();i++){
            jComboBoxDepositos.addItem(getListaDepositos().get(i).getNombre());
        }
    }

    /**
     * @return the listaDepositos
     */
    public ArrayList<Deposito> getListaDepositos() {
        return listaDepositos;
    }

    /**
     * @param listaDepositos the listaDepositos to set
     */
    public void setListaDepositos(ArrayList<Deposito> listaDepositos) {
        this.listaDepositos = listaDepositos;
    }
    
}
