/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.SalidaC;
import java.util.Date;
import javax.swing.JComboBox;
import java.math.BigDecimal;
/**
 *
 * @author fcpa
 */
public class SalidaV extends javax.swing.JFrame {

    /**
     * Creates new form SalidaV
     */
    private SalidaC salida;
    public String detalle;
    private Menu menu;
    public SalidaV() {
        initComponents();
        salida = new SalidaC(this);
        actualizar();
        valoresPorDefecto();
    }

    SalidaV(Menu aThis) {
        initComponents();
        salida = new SalidaC(this);
        actualizar();
        valoresPorDefecto();
        menu = aThis;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxProductos = new javax.swing.JComboBox();
        jTextFieldCantidad = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDetalle = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setText("Producto");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(31, 45, 49, 16);

        jLabel2.setText("Cantidad");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(31, 72, 50, 16);

        jPanel1.add(jComboBoxProductos);
        jComboBoxProductos.setBounds(98, 40, 112, 26);
        jPanel1.add(jTextFieldCantidad);
        jTextFieldCantidad.setBounds(99, 72, 111, 28);

        jButtonAceptar.setMnemonic('a');
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAceptar);
        jButtonAceptar.setBounds(88, 213, 69, 28);

        jButtonCancelar.setMnemonic('c');
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelar);
        jButtonCancelar.setBounds(175, 213, 78, 28);

        jLabel3.setText("Detalle");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(31, 118, 39, 16);

        jTextAreaDetalle.setColumns(20);
        jTextAreaDetalle.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDetalle);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(88, 118, 176, 60);

        jLabel4.setText("Salida");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(143, 6, 35, 16);
        jPanel1.add(jDateChooser);
        jDateChooser.setBounds(228, 40, 127, 24);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        guardar();
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SalidaV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalidaV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalidaV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalidaV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalidaV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JComboBox jComboBoxProductos;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDetalle;
    private javax.swing.JTextField jTextFieldCantidad;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the cantidad
     */
    public BigDecimal getCantidad() {
        return new BigDecimal(jTextFieldCantidad.getText());
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        jTextFieldCantidad.setText(""+cantidad);
    }

    /**
     * @return the detalle
     */
    public String getDetalle() {
        return jTextAreaDetalle.getText();
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(String detalle) {
        jTextAreaDetalle.setText(detalle);
    }
    
    /**
     * @return the productos
     */
    public JComboBox getProductos() {
        return jComboBoxProductos;
    }

    /**
     * @param productos the detalle to set
     */
    public void setProductos(JComboBox productos) {
        jComboBoxProductos=productos;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return jDateChooser.getDate();
    }

    /**
     * @param productos the fecha to set
     */
    public void setFecha(Date fecha) {
        jDateChooser.setDate(fecha);
    }
    
    
    
    
    private void guardar() {
        if(salida.guardar())
            dispose();
    }

    private void actualizar() {
        salida.actualizar();
    }

    private void valoresPorDefecto() {
        jDateChooser.setDate(new Date());
    }

   
}
