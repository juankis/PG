/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author fcpa
 */
public class Validacion {
    public boolean validacionesSoloNumeros(java.awt.event.KeyEvent evt){
        char car = evt.getKeyChar();
        boolean res=true;
        if((car<'0' || car>'9')) 
            evt.consume();
        else
            res=false;
        return res;
    }
    
    public void validacionCantidadCaracteres(String texto, int cantidadLimite,java.awt.event.KeyEvent evt ){
        if(texto.length()>cantidadLimite)
            evt.consume();
    }

    public boolean esVacioJTextField(JTextField jTextField) {
        boolean res=false;
        if(jTextField.getText().equals("")){
            res=true;
            jTextField.setBackground(Color.pink);
        }else
            jTextField.setBackground(Color.white);
        
        return res;
    }
}
