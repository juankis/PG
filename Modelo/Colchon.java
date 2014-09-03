package Modelo;
// Generated Aug 31, 2014 8:32:31 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Colchon generated by hbm2java
 */
public class Colchon  implements java.io.Serializable {


     private int idcolchon;
     private Esponja esponja;
     private Medidas medidas;
     private String colorcolchon;
     private String tela;
     private String nombrecolchon;
     private String tipocolchon;
     private BigDecimal stockactual;
     private Set entradas = new HashSet(0);
     private Set salidas = new HashSet(0);

    public Colchon() {
    }

	
    public Colchon(int idcolchon) {
        this.idcolchon = idcolchon;
    }
    public Colchon(int idcolchon, Esponja esponja, Medidas medidas, String colorcolchon, String tela, String nombrecolchon, String tipocolchon, BigDecimal stockactual, Set entradas, Set salidas) {
       this.idcolchon = idcolchon;
       this.esponja = esponja;
       this.medidas = medidas;
       this.colorcolchon = colorcolchon;
       this.tela = tela;
       this.nombrecolchon = nombrecolchon;
       this.tipocolchon = tipocolchon;
       this.stockactual = stockactual;
       this.entradas = entradas;
       this.salidas = salidas;
    }
   
    public int getIdcolchon() {
        return this.idcolchon;
    }
    
    public void setIdcolchon(int idcolchon) {
        this.idcolchon = idcolchon;
    }
    public Esponja getEsponja() {
        return this.esponja;
    }
    
    public void setEsponja(Esponja esponja) {
        this.esponja = esponja;
    }
    public Medidas getMedidas() {
        return this.medidas;
    }
    
    public void setMedidas(Medidas medidas) {
        this.medidas = medidas;
    }
    public String getColorcolchon() {
        return this.colorcolchon;
    }
    
    public void setColorcolchon(String colorcolchon) {
        this.colorcolchon = colorcolchon;
    }
    public String getTela() {
        return this.tela;
    }
    
    public void setTela(String tela) {
        this.tela = tela;
    }
    public String getNombrecolchon() {
        return this.nombrecolchon;
    }
    
    public void setNombrecolchon(String nombrecolchon) {
        this.nombrecolchon = nombrecolchon;
    }
    public String getTipocolchon() {
        return this.tipocolchon;
    }
    
    public void setTipocolchon(String tipocolchon) {
        this.tipocolchon = tipocolchon;
    }
    public BigDecimal getStockactual() {
        return this.stockactual;
    }
    
    public void setStockactual(BigDecimal stockactual) {
        this.stockactual = stockactual;
    }
    public Set getEntradas() {
        return this.entradas;
    }
    
    public void setEntradas(Set entradas) {
        this.entradas = entradas;
    }
    public Set getSalidas() {
        return this.salidas;
    }
    
    public void setSalidas(Set salidas) {
        this.salidas = salidas;
    }




}


