/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Esponja;
import Modelo.Medidas;
import Modelo.Colchon;
import Vista.NuevoProductoV;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author juanki
 */
public class ColchonC {
    
    private Colchon colchon;
    private ArrayList<Medidas> listaMedidas;
    private ArrayList<Esponja> listaEsponjas;
    private ArrayList<Colchon> listaColchones;
    private Conexion conexion=new Conexion();
    public ColchonC(){
    
    }

    public ColchonC(NuevoProductoV colchonV) {
        
        colchon=new Colchon(colchonV.getEsponja(), colchonV.getMedidas(), colchonV.getNombre(), colchonV.getColor(), colchonV.getTela(), colchonV.getTipo(),null );
    }
    
    public void guardar() {
        conexion.guardar(colchon);
    }

    public void llenarListaMedidas(JComboBox medidas) {
        medidas.removeAllItems();
        setListaMedidas(new ArrayList<Medidas>());
        conexion.getListaMedidas(getListaMedidas());
        for(int i=0;i<getListaMedidas().size();i++){
            medidas.addItem(getListaMedidas().get(i).getCodigo());
        }
       // medidas.addItem("");
    }

    public void llenarListaEsponjas(JComboBox esponjas) {
        esponjas.removeAllItems();
        setListaEsponjas(new ArrayList<Esponja>());
        conexion.getListaEsponjas(getListaEsponjas());
        for(int i=0;i<getListaEsponjas().size();i++){
            esponjas.addItem(getListaEsponjas().get(i).getCodigo());
        }
       // esponjas.addItem("");
    }
    

    /**
     * @return the listaMedidas
     */
    public ArrayList<Medidas> getListaMedidas() {
        return listaMedidas;
    }

    /**
     * @param listaMedidas the listaMedidas to set
     */
    public void setListaMedidas(ArrayList<Medidas> listaMedidas) {
        this.listaMedidas = listaMedidas;
    }

    /**
     * @return the listaEsponjas
     */
    public ArrayList<Esponja> getListaEsponjas() {
        return listaEsponjas;
    }

    /**
     * @param listaEsponjas the listaEsponjas to set
     */
    public void setListaEsponjas(ArrayList<Esponja> listaEsponjas) {
        this.listaEsponjas = listaEsponjas;
    }

    public void llenarJTableProductos(JTable jTableProductos) {
        setListaColchones(new ArrayList<Colchon>());
        conexion.getListaColchones(listaColchones);
        conexion.abrir();
        
        for(int i=0;i<listaColchones.size();i++){
            addColchonATabla(listaColchones.get(i),(DefaultTableModel)jTableProductos.getModel(),i);
        }
         conexion.cerrar();
    }

    private void addColchonATabla(Colchon c, DefaultTableModel TableModelProductos,int pos) {
       c=(Colchon)conexion.getObject(c);
       String[] arr={c.getNombre(),c.getColor(),c.getTela(),c.getEsponja().getCodigo(),c.getMedidas().getCodigo(),c.getTipo()};
       TableModelProductos.addRow(arr);
    }

    /**
     * @return the listaColchones
     */
    public ArrayList<Colchon> getListaColchones() {
        return listaColchones;
    }

    /**
     * @param listaColchones the listaColchones to set
     */
    public void setListaColchones(ArrayList<Colchon> listaColchones) {
        this.listaColchones = listaColchones;
    }

    public void llenarAtributosColchon(JComboBox jTextFieldColor,JComboBox jTextFieldTela,JComboBox Tipo) {
        for(Colchon c:listaColchones){
            jTextFieldColor.addItem(c.getColor());
            jTextFieldTela.addItem(c.getTela());
            Tipo.addItem(c.getTipo());
        }
       // jTextFieldColor.addItem("");
        //jTextFieldTela.addItem("");
    }

    public void establecerProductoIndex(int filaSeleccionada) {
        colchon=listaColchones.get(filaSeleccionada);
    }

    public void getProducto(NuevoProductoV productoV) {
        productoV.setNombre(colchon.getNombre());
        productoV.setColor(colchon.getColor());
        productoV.setTela(colchon.getTela());
        productoV.setTipo(colchon.getTipo());
        conexion.abrir();
        productoV.setMedidas((Medidas)conexion.getObject(colchon.getMedidas()));
        productoV.setEsponja((Esponja)conexion.getObject(colchon.getEsponja()));
        conexion.cerrar();
    }

    public boolean eliminarProducto() {
        boolean exito=false;
        if(!existeDependencia()){
           conexion.eliminar(colchon);
           exito=true;
        }
        return exito;
    }

    private boolean existeDependencia() {
        conexion.abrir();
        colchon=(Colchon)conexion.getObject(colchon);
        boolean res=colchon.getTransaccions().isEmpty();
        conexion.cerrar();
        return  !res;
    }

    public void setProducto(NuevoProductoV productoV) {
        colchon.setNombre(productoV.getNombre());
        colchon.setColor(productoV.getColor());
        colchon.setTela(productoV.getTela());
        colchon.setTipo(productoV.getTipo());
        colchon.setMedidas(productoV.getMedidas());
        colchon.setEsponja(productoV.getEsponja());
    }

    public void modificar() {
        conexion.modificar(colchon);
    }
}
