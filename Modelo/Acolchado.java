package Modelo;
// Generated May 5, 2014 12:01:48 PM by Hibernate Tools 3.6.0



/**
 * Acolchado generated by hbm2java
 */
public class Acolchado  implements java.io.Serializable {


     private Integer id;
     private String tipo;

    public Acolchado() {
    }

    public Acolchado(String tipo) {
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


