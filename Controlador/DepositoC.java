/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Deposito;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fcpa
 */
public class DepositoC {
   private Deposito deposito;
   private ArrayList<Deposito> listaDepositos;
   private Conexion conexion=new Conexion();

    public DepositoC(Vista.DepositoV depositoVista) {
        deposito = new Deposito(depositoVista.getNombre(), depositoVista.getDireccion(), depositoVista.getDetalle(), null);
    }

    public DepositoC() {
        
    }

    public void guardar() {
        conexion.guardar(deposito);
    }

    public void llenarJTableDepositos(JTable jTableDepositos) {
        setListaDepositos(new ArrayList<Deposito>());
        conexion.getListaDepositos(getListaDepositos());
        for(int i=0;i<listaDepositos.size();i++){
            Deposito d=getListaDepositos().get(i);
            addDepositoATabla(d,(DefaultTableModel)jTableDepositos.getModel(),i);
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

    private void addDepositoATabla(Deposito d, DefaultTableModel defaultTableModel, int i) {
        String[] arr={d.getNombre().toString(),d.getDireccion().toString(),d.getDetalle()};
        defaultTableModel.addRow(arr);
    }

    public void establecerDepositoIndex(int filaSeleccionada) {
        deposito=listaDepositos.get(filaSeleccionada);
    }

    public boolean eliminarDeposito() {
        boolean exito=false;
        if(!existeDependencia()){
           conexion.eliminar(deposito);
           exito=true;
        }
        return exito;
    }
    public boolean existeDependencia(){
        conexion.abrir();
        deposito=(Deposito)conexion.getObject(deposito);
        boolean res=deposito.getEntradas().isEmpty();
        conexion.cerrar();
        return  !res;
    }
    
}
