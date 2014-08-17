/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Esponja;
import Modelo.Medidas;
import Vista.MedidasV;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanki
 */
public class MedidasC {
    
    Modelo.Medidas medidas;//=new Medidas();
    Conexion conexion=new Conexion();
    private ArrayList<Medidas> listaMedidas;
    public MedidasC(){
        
    }

    public MedidasC(MedidasV medidasV) {
        medidas=new Medidas();
        medidas = new Medidas(medidas.getIdmedidas(),medidasV.getAncho(), medidasV.getLargo(), medidasV.getGrosor(), medidasV.getPlazas(),medidasV.getCodigo(), null);
    }

    public void guardar() {
        Conexion util=new Conexion();
        util.guardar(medidas);
    }

    public void llenarJTableEsponjas(JTable jTableMedidas) {
        setListaMedidas( new ArrayList<Medidas>());
        conexion.getListaMedidas(getListaMedidas());
        
        for(int i=0;i<listaMedidas.size();i++){
            Medidas m=listaMedidas.get(i);
            addColchonATabla(m,(DefaultTableModel)jTableMedidas.getModel(),i);
        }
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
    
    private void addColchonATabla(Medidas m, DefaultTableModel model,int i) {
        String[] arr={m.getPlazas().toString(),m.getLargo().toString(),m.getAncho().toString(),m.getGrosor().toString(),m.getCodigomedidas()};
        model.addRow(arr);
        
    }

    public void establecerMedidasIndex(int filaSeleccionada) {
        medidas=listaMedidas.get(filaSeleccionada);
    }

    public void getMedidas(MedidasV medidasV) {
        medidasV.setPlazas(medidas.getPlazas());
        medidasV.setLargo(medidas.getLargo());
        medidasV.setAncho(medidas.getAncho());
        medidasV.setGrosor(medidas.getGrosor());
        medidasV.setCodigo(medidas.getCodigomedidas());
    }

    public void setMedidas(MedidasV medidasV) {
        medidas.setPlazas(medidasV.getPlazas());
        medidas.setLargo(medidasV.getLargo());
        medidas.setAncho(medidasV.getAncho());
        medidas.setGrosor(medidasV.getGrosor());
        medidas.setCodigomedidas(medidasV.getCodigo());
    }

    public void modificar() {
        conexion.modificar(medidas);
    }

    public boolean eliminarMedidas() {
        boolean exito=false;
        if(!existeDependencia()){
           conexion.eliminar(medidas);
           exito=true;
        }
        return exito;
    }

    public boolean existeDependencia(){
        conexion.abrir();
        medidas=(Medidas)conexion.getObject(medidas);
        boolean res=medidas.getColchons().isEmpty();
        conexion.cerrar();
        return  !res;
    }

   
   
}
