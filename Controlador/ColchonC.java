/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Esponja;
import Modelo.Medidas;
import Modelo.Colchon;
import Vista.ProductoFormulario;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


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

    public ColchonC(ProductoFormulario colchonV) {
        colchon=new Colchon();
        colchon=new Colchon(colchon.getIdcolchon(),colchonV.getEsponja(), colchonV.getMedidas(),  colchonV.getColor(), colchonV.getTela(), colchonV.getTipo(),colchonV.getNombre(),null,null);
        //colchon=new Colchon(idcolchon, null, null, null, null, null, null, null, null)
    }
    
    public Colchon getColchon(String nombre){
        Object res=conexion.getObjectSql("select c from Colchon c where c.nombre = '"+nombre+"'");
        return (Colchon)res;
    }
    public void guardar() {
        conexion.guardar(colchon);
    }

    public void llenarListaMedidas(JComboBox medidas) {
        medidas.removeAllItems();
        setListaMedidas(new ArrayList<Medidas>());
        conexion.getListaMedidas(getListaMedidas());
        for(int i=0;i<getListaMedidas().size();i++){
            medidas.addItem(getListaMedidas().get(i).getCodigomedidas());
        }
    }

    public void llenarListaEsponjas(JComboBox esponjas) {
        esponjas.removeAllItems();
        setListaEsponjas(new ArrayList<Esponja>());
        conexion.getListaEsponjas(getListaEsponjas());
        for(int i=0;i<getListaEsponjas().size();i++){
            esponjas.addItem(getListaEsponjas().get(i).getCodigoesponja());
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
       String  codigoEsponja;
       String  codigoMedidas;
       try{
           codigoEsponja=c.getEsponja().getCodigoesponja();
       }catch (NullPointerException e){
           codigoEsponja=null;
       }
       try{
           codigoMedidas=c.getMedidas().getCodigomedidas();
       }catch (NullPointerException e){
           codigoMedidas=null;
       }
       String[] arr={c.getNombrecolchon(),c.getColorcolchon(),c.getTela(),codigoEsponja,codigoMedidas,c.getTipocolchon()};
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

    public void llenarAtributosColchon(JComboBox JComboBoxColor,JComboBox JComboBoxTela,JComboBox JComboBoxTipo) {
        for(Colchon c:listaColchones){
            JComboBoxColor.addItem(c.getColorcolchon());
            JComboBoxTela.addItem(c.getTela());
            JComboBoxTipo.addItem(c.getTipocolchon());
        }
//        validacion.eliminarRepetidosCombo(JComboBoxColor);
       // jTextFieldColor.addItem("");
       //jTextFieldTela.addItem("");
    }

    public void establecerProductoIndex(int filaSeleccionada) {
        colchon=listaColchones.get(filaSeleccionada);
    }

    public void getProducto(ProductoFormulario productoFormulario) {
        productoFormulario.setNombre(colchon.getNombrecolchon());
        productoFormulario.setColor(colchon.getColorcolchon());
        productoFormulario.setTela(colchon.getTela());
        productoFormulario.setTipo(colchon.getTipocolchon());
        conexion.abrir();
        try{
            productoFormulario.setEsponja((Esponja)conexion.getObject(colchon.getEsponja()));
        }catch(IllegalArgumentException e){
            productoFormulario.setEsponja(colchon.getEsponja());
        }
        try{
            productoFormulario.setMedidas((Medidas)conexion.getObject(colchon.getMedidas()));
        }catch(IllegalArgumentException e){
            productoFormulario.setMedidas(colchon.getMedidas());
        }   
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
        boolean res=colchon.getEntradas().isEmpty();
        conexion.cerrar();
        return  !res;
    }

    public void setProducto(ProductoFormulario productoV) {
        colchon.setNombrecolchon(productoV.getNombre());
        colchon.setColorcolchon(productoV.getColor());
        colchon.setTela(productoV.getTela());
        colchon.setTipocolchon(productoV.getTipo());
        colchon.setMedidas(productoV.getMedidas());
        colchon.setEsponja(productoV.getEsponja());
    }

    public void modificar() {
        conexion.modificar(colchon);
    }
    
    public void llenarListaProductos(JComboBox productos) {
        productos.removeAllItems();
        setListaColchones(new ArrayList<Colchon>());
        conexion.getListaColchones(getListaColchones());
        for(int i=0;i<getListaColchones().size();i++){
            productos.addItem(getListaColchones().get(i).getNombrecolchon());
        }
    }
}
