package Modelo;
// Generated 28-oct-2014 11:47:39 by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Entrada generated by hbm2java
 */
public class Entrada  implements java.io.Serializable {


     private int identrada;
     private Colchon colchon;
     private Deposito deposito;
     private String codigoentrada;
     private BigDecimal costounitario;
     private BigDecimal preciounitario;
     private BigDecimal totalcosto;
     private BigDecimal totalmayor;
     private BigDecimal stockentrada;
     private BigDecimal cantidadentrada;
     private Date fechaentrada;
     private String detalleentrada;
     private Set relacionentradasalidas = new HashSet(0);

    public Entrada() {
    }

	
    public Entrada(int identrada) {
        this.identrada = identrada;
    }
    public Entrada(int identrada, Colchon colchon, Deposito deposito, String codigoentrada, BigDecimal costounitario, BigDecimal preciounitario, BigDecimal totalcosto, BigDecimal totalmayor, BigDecimal stockentrada, BigDecimal cantidadentrada, Date fechaentrada, String detalleentrada, Set relacionentradasalidas) {
       this.identrada = identrada;
       this.colchon = colchon;
       this.deposito = deposito;
       this.codigoentrada = codigoentrada;
       this.costounitario = costounitario;
       this.preciounitario = preciounitario;
       this.totalcosto = totalcosto;
       this.totalmayor = totalmayor;
       this.stockentrada = stockentrada;
       this.cantidadentrada = cantidadentrada;
       this.fechaentrada = fechaentrada;
       this.detalleentrada = detalleentrada;
       this.relacionentradasalidas = relacionentradasalidas;
    }
   
    public int getIdentrada() {
        return this.identrada;
    }
    
    public void setIdentrada(int identrada) {
        this.identrada = identrada;
    }
    public Colchon getColchon() {
        return this.colchon;
    }
    
    public void setColchon(Colchon colchon) {
        this.colchon = colchon;
    }
    public Deposito getDeposito() {
        return this.deposito;
    }
    
    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }
    public String getCodigoentrada() {
        return this.codigoentrada;
    }
    
    public void setCodigoentrada(String codigoentrada) {
        this.codigoentrada = codigoentrada;
    }
    public BigDecimal getCostounitario() {
        return this.costounitario;
    }
    
    public void setCostounitario(BigDecimal costounitario) {
        this.costounitario = costounitario;
    }
    public BigDecimal getPreciounitario() {
        return this.preciounitario;
    }
    
    public void setPreciounitario(BigDecimal preciounitario) {
        this.preciounitario = preciounitario;
    }
    public BigDecimal getTotalcosto() {
        return this.totalcosto;
    }
    
    public void setTotalcosto(BigDecimal totalcosto) {
        this.totalcosto = totalcosto;
    }
    public BigDecimal getTotalmayor() {
        return this.totalmayor;
    }
    
    public void setTotalmayor(BigDecimal totalmayor) {
        this.totalmayor = totalmayor;
    }
    public BigDecimal getStockentrada() {
        return this.stockentrada;
    }
    
    public void setStockentrada(BigDecimal stockentrada) {
        this.stockentrada = stockentrada;
    }
    public BigDecimal getCantidadentrada() {
        return this.cantidadentrada;
    }
    
    public void setCantidadentrada(BigDecimal cantidadentrada) {
        this.cantidadentrada = cantidadentrada;
    }
    public Date getFechaentrada() {
        return this.fechaentrada;
    }
    
    public void setFechaentrada(Date fechaentrada) {
        this.fechaentrada = fechaentrada;
    }
    public String getDetalleentrada() {
        return this.detalleentrada;
    }
    
    public void setDetalleentrada(String detalleentrada) {
        this.detalleentrada = detalleentrada;
    }
    public Set getRelacionentradasalidas() {
        return this.relacionentradasalidas;
    }
    
    public void setRelacionentradasalidas(Set relacionentradasalidas) {
        this.relacionentradasalidas = relacionentradasalidas;
    }




}


