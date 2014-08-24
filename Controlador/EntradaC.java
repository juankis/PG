/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Colchon;
import Modelo.Deposito;

import Modelo.Entrada;
import Vista.EntradaV;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanki
 */
public class EntradaC {

    Entrada entrada;
    EntradaV entradaV;
    Conexion conexion=new Conexion();
    private ArrayList<Entrada> entradas;
    private ArrayList<Colchon> listaProductos;
    private ArrayList<Deposito> listaDepositos;
    private Validacion validacion;
    
    public EntradaC(EntradaV transaccionV){
        this.entradaV=transaccionV;
        validacion = new Validacion();
    }
    
    public boolean guardar() {
        if(entradaV.validar()){
            guardarEntrada();
        }
        return true;
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
    
    public void guardarEntrada() {
        int id=conexion.getNextValue("SELECT MAX(identrada) FROM Entrada");
        this.entrada = new Entrada(id,
                entradaV.getProducto(),
                entradaV.getDeposito(),
                entradaV.getCodigo(),
                entradaV.isTipo(),
                entradaV.getCostoUnitario(),
                entradaV.getPrecioUnitario(), entradaV.getPrecioCosto(), 
                entradaV.getPrecioMayor(),
                entradaV.getPrecioMayor(), 
                entradaV.getCantidad(), 
                entradaV.getFecha(), entradaV.getDetalle(), null);
        conexion.guardar(entrada);
    }

    public void llenarListaProductos(JComboBox productos) {
        productos.removeAllItems();
        setListaProductos(new ArrayList<Colchon>());
        conexion.getListaColchones(getListaProductos());
        for(int i=0;i<getListaProductos().size();i++){
            productos.addItem(getListaProductos().get(i).getNombrecolchon());
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

    public void llenarTablaEntradas(JTable jTable1) {
        setEntradas(new ArrayList<Entrada>());
        conexion.getListaTransacciones(getEntradas());
        conexion.abrir();
        
        for(int i=0;i<entradas.size();i++){
            addColchonATabla(entradas.get(i),(DefaultTableModel)jTable1.getModel(),i);
        }
         conexion.cerrar();
    }

    /**
     * @return the entradaes
     */
    public ArrayList<Entrada> getEntradas() {
        return entradas;
    }

    /**
     * @param entradas the entradaes to set
     */
    public void setEntradas(ArrayList<Entrada> entradas) {
        this.entradas = entradas;
    }

    private void addColchonATabla(Entrada t, DefaultTableModel defaultTableModel, int i) {
        t=(Entrada)conexion.getObject(t);
        String[] arr={t.getCodigoentrada(),t.getFechaentrada().toString(),t.getColchon().getNombrecolchon(),t.getTipoentrada().toString(),t.getPreciounitario().toString(),t.getCantidadentrada().toString()};
        defaultTableModel.addRow(arr);
    }

    public void establecerTransaccionIndex(int filaSeleccionada) {
        entrada=entradas.get(filaSeleccionada);
    }

    public void getEntradas(EntradaV entradaV) {
        entradaV.setCodigo(entrada.getCodigoentrada());
        entradaV.setFecha(entrada.getFechaentrada());
        conexion.abrir();
        entradaV.setProducto((Colchon)conexion.getObject(entrada.getColchon()));
        conexion.cerrar();
        entradaV.setTipo(entrada.getTipoentrada());
        entradaV.setPrecioUnitario(entrada.getPreciounitario());
        entradaV.setCantidad(entrada.getCantidadentrada());
        entradaV.setPrecioCosto(entrada.getTotalcosto());
        entradaV.setPrecioMayor(entrada.getTotalmayor());
        entradaV.setDetalle(entrada.getDetalleentrada());
    }

    public boolean eliminarEntrada() {
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
            jComboBoxDepositos.addItem(getListaDepositos().get(i).getNombredeposito());
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
