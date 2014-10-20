package Modelo;
// Generated Sep 14, 2014 5:19:05 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Medidas generated by hbm2java
 */
public class Medidas  implements java.io.Serializable {


     private int idmedidas;
     private String ancho;
     private String largo;
     private String grosor;
     private String plazas;
     private String codigomedidas;
     private Set colchons = new HashSet(0);

    public Medidas() {
    }

	
    public Medidas(int idmedidas) {
        this.idmedidas = idmedidas;
    }
    public Medidas(int idmedidas, String ancho, String largo, String grosor, String plazas, String codigomedidas, Set colchons) {
       this.idmedidas = idmedidas;
       this.ancho = ancho;
       this.largo = largo;
       this.grosor = grosor;
       this.plazas = plazas;
       this.codigomedidas = codigomedidas;
       this.colchons = colchons;
    }
   
    public int getIdmedidas() {
        return this.idmedidas;
    }
    
    public void setIdmedidas(int idmedidas) {
        this.idmedidas = idmedidas;
    }
    public String getAncho() {
        return this.ancho;
    }
    
    public void setAncho(String ancho) {
        this.ancho = ancho;
    }
    public String getLargo() {
        return this.largo;
    }
    
    public void setLargo(String largo) {
        this.largo = largo;
    }
    public String getGrosor() {
        return this.grosor;
    }
    
    public void setGrosor(String grosor) {
        this.grosor = grosor;
    }
    public String getPlazas() {
        return this.plazas;
    }
    
    public void setPlazas(String plazas) {
        this.plazas = plazas;
    }
    public String getCodigomedidas() {
        return this.codigomedidas;
    }
    
    public void setCodigomedidas(String codigomedidas) {
        this.codigomedidas = codigomedidas;
    }
    public Set getColchons() {
        return this.colchons;
    }
    
    public void setColchons(Set colchons) {
        this.colchons = colchons;
    }




}


