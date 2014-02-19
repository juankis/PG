/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import static Controlador.Conexion.getSessionFactory;
import Modelo.Esponja;
import Vista.EsponjaV;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
/**
 *
 * @author juanki
 */
public class EsponjaC {
    private Esponja esponja;
    private ArrayList<Esponja> listaEsponjas;
    private Conexion conexion=new Conexion();
    public EsponjaC(){
        
    }

    public EsponjaC(EsponjaV esponjaV) {
        esponja=new Esponja(esponjaV.getMaterial(), esponjaV.getColor(),esponjaV.getCodigo(), null);
        
    }
    public void guardar(){
        Conexion util= new Conexion();
        util.guardar(esponja);
     }

    public void llenarJTableEsponjas(JTable jTableEsponjas) {
        setListaEsponjas( new ArrayList<Esponja>());
        conexion.getListaEsponjas(getListaEsponjas());
        
        for(int i=0;i<listaEsponjas.size();i++){
            Esponja e=listaEsponjas.get(i);
            addColchonATabla(e,(DefaultTableModel)jTableEsponjas.getModel(),i);
        }
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

    private void addColchonATabla(Esponja e, DefaultTableModel model,int i) {
        String[] arr={e.getMaterial(),e.getColor(),e.getCodigo()};
        model.addRow(arr);
        
    }

    public void establecerEsponjaIndex(int filaSeleccionada) {
        esponja=listaEsponjas.get(filaSeleccionada);
    }

    public void getEsponja(EsponjaV esponjaV) {
        esponjaV.setColor(esponja.getColor());
        esponjaV.setMaterial(esponja.getMaterial());
        esponjaV.setCodigo(esponja.getCodigo());
    }

    public void modificar() {
        conexion.modificar(esponja);
    }

    public void setEsponja(EsponjaV esponjaV) {
        esponja.setColor(esponjaV.getColor());
        esponja.setMaterial(esponjaV.getMaterial());
        esponja.setCodigo(esponjaV.getCodigo());
    }

    public boolean eliminarEsponja() {
        boolean exito=false;
        if(!existeDependencia()){
           conexion.eliminar(esponja);
           exito=true;
        }
        return exito;
    }
    
    public boolean existeDependencia(){
        conexion.abrir();
        esponja=(Esponja)conexion.getObject(esponja);
        boolean res=esponja.getColchons().isEmpty();
        conexion.cerrar();
        return  !res;
    }

    public void llenarAtributosEsponja(JComboBox materialCombo, JComboBox colorCombo) {
        for(Esponja e:listaEsponjas){
            if(true)
            materialCombo.addItem(e.getMaterial());
            colorCombo.addItem(e.getColor());
            //materialCombo.setInheritsPopupMenu
        }
            
    }
    
}
