package Modelo;
// Generated Feb 21, 2014 9:02:18 AM by Hibernate Tools 3.6.0



/**
 * Resortes generated by hbm2java
 */
public class Resortes  implements java.io.Serializable {


     private Integer id;
     private String tipo;

    public Resortes() {
    }

    public Resortes(String tipo) {
       this.tipo = tipo;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }




}


