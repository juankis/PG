/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Colchon;
import Modelo.Deposito;
import Modelo.Esponja;
import Modelo.Entrada;
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

    Entrada entrada;
    TransaccionV transaccionV;
    Conexion conexion=new Conexion();
    private ArrayList<Entrada> entradas;
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
        if(!validacion.esVacioJTextField(entrada.jTextFieldCodigo)){
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
                        producto=entrada.getListaProductos().get(jComboBoxProducto.getSelectedIndex());
                        deposito=entrada.getListaDepositos().get(jComboBoxDepositos.getSelectedIndex());
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
            validacion.mostrarMensaje("debe introducir el codigo de la entrada");
        }
        return res;
    }*/
    
    public void guardarTransaccion() {
        this.entrada = new Entrada(transaccionV.getProducto(), transaccionV.getDeposito(), transaccionV.getCodigo(),
                transaccionV.isTipo(), transaccionV.getFecha(), transaccionV.getDetalle(), transaccionV.getCantidad(), 
                transaccionV.getCostoUnitario(), transaccionV.getPrecioUnitario(), transaccionV.getPrecioCosto(), 
                transaccionV.getPrecioMayor(), transaccionV.getCantidad(), null);
        conexion.guardar(entrada);
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
        setTransacciones(new ArrayList<Entrada>());
        conexion.getListaTransacciones(getTransacciones());
        conexion.abrir();
        
        for(int i=0;i<entradas.size();i++){
            addColchonATabla(entradas.get(i),(DefaultTableModel)jTable1.getModel(),i);
        }
         conexion.cerrar();
    }

    /**
     * @return the entradaes
     */
    public ArrayList<Entrada> getTransacciones() {
        return entradas;
    }

    /**
     * @param transacciones the entradaes to set
     */
    public void setTransacciones(ArrayList<Entrada> transacciones) {
        this.entradas = transacciones;
    }

    private void addColchonATabla(Entrada t, DefaultTableModel defaultTableModel, int i) {
        t=(Entrada)conexion.getObject(t);
        String[] arr={t.getCodigo(),t.getFecha().toString(),t.getColchon().getNombre(),t.getTipo().toString(),t.getPrecioUnitario().toString(),t.getCantidad().toString()};
        defaultTableModel.addRow(arr);
    }

    public void establecerTransaccionIndex(int filaSeleccionada) {
        entrada=entradas.get(filaSeleccionada);
    }

    public void getTransacciones(TransaccionV transaccionV) {
        transaccionV.setCodigo(entrada.getCodigo());
        transaccionV.setFecha(entrada.getFecha());
        conexion.abrir();
        transaccionV.setProducto((Colchon)conexion.getObject(entrada.getColchon()));
        conexion.cerrar();
        transaccionV.setTipo(entrada.getTipo());
        transaccionV.setPrecioUnitario(entrada.getPrecioUnitario());
        transaccionV.setCantidad(entrada.getCantidad());
        transaccionV.setPrecioCosto(entrada.getTotalCosto());
        transaccionV.setPrecioMayor(entrada.getTotalMayor());
        transaccionV.setDetalle(entrada.getDetalle());
    }

    public boolean eliminarTransaccion() {
        boolean exito=false;
        if(!existeDependencia()){
           conexion.eliminar(entrada);
           exito=true;
        }
        return exito;
    }

    private boolean existeDependencia() {
        /*conexion.abrir();
        entrada=(Transaccion)conexion.getObject(entrada);
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
