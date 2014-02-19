package Modelo;
// Generated 08-feb-2014 17:42:54 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Esponja generated by hbm2java
 */
public class Esponja  implements java.io.Serializable {


     private Integer id;
     private String material;
     private String color;
     private String codigo;
     private Set colchons = new HashSet(0);

    public Esponja() {
    }

    public Esponja(String material, String color, String codigo, Set colchons) {
       this.material = material;
       this.color = color;
       this.codigo = codigo;
       this.colchons = colchons;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMaterial() {
        return this.material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public Set getColchons() {
        return this.colchons;
    }
    
    public void setColchons(Set colchons) {
        this.colchons = colchons;
    }




}

