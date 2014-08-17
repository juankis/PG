package Modelo;
// Generated Aug 3, 2014 10:33:50 AM by Hibernate Tools 3.6.0


import java.math.BigDecimal;

/**
 * Relacionentradasalida generated by hbm2java
 */
public class Relacionentradasalida  implements java.io.Serializable {


     private int idrelacionentradasalida;
     private Entrada entrada;
     private Salida salida;
     private BigDecimal cantidadrelentrsal;

    public Relacionentradasalida() {
    }

	
    public Relacionentradasalida(int idrelacionentradasalida) {
        this.idrelacionentradasalida = idrelacionentradasalida;
    }
    public Relacionentradasalida(int idrelacionentradasalida, Entrada entrada, Salida salida, BigDecimal cantidadrelentrsal) {
       this.idrelacionentradasalida = idrelacionentradasalida;
       this.entrada = entrada;
       this.salida = salida;
       this.cantidadrelentrsal = cantidadrelentrsal;
    }
   
    public int getIdrelacionentradasalida() {
        return this.idrelacionentradasalida;
    }
    
    public void setIdrelacionentradasalida(int idrelacionentradasalida) {
        this.idrelacionentradasalida = idrelacionentradasalida;
    }
    public Entrada getEntrada() {
        return this.entrada;
    }
    
    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }
    public Salida getSalida() {
        return this.salida;
    }
    
    public void setSalida(Salida salida) {
        this.salida = salida;
    }
    public BigDecimal getCantidadrelentrsal() {
        return this.cantidadrelentrsal;
    }
    
    public void setCantidadrelentrsal(BigDecimal cantidadrelentrsal) {
        this.cantidadrelentrsal = cantidadrelentrsal;
    }




}


