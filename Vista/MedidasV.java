/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.EsponjaC;
import Controlador.MedidasC;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanki
 */
public class MedidasV extends javax.swing.JFrame {

    private String plazas;
    private String ancho;
    private String largo;
    private String grosor;
    private String codigo;
    private MedidasC medidas;
    private NuevoProductoV nuevoProducto;
    public MedidasV() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        medidas=new MedidasC();
        llenarTableMedidas();
    }

    MedidasV(NuevoProductoV aThis) {
        nuevoProducto=aThis;
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        medidas=new MedidasC();
        llenarTableMedidas();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPlazas = new javax.swing.JTextField();
        jTextFieldLargo = new javax.swing.JTextField();
        jTextFieldAncho = new javax.swing.JTextField();
        jTextFieldGrosor = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMedidas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonVer = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setText("Plazas");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 103, 50, 14);

        jLabel2.setText("Largo");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 130, 50, 14);

        jLabel3.setText("Ancho");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(19, 156, 50, 14);

        jLabel4.setText("Grosor");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 180, 50, 14);

        jTextFieldPlazas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlazasActionPerformed(evt);
            }
        });
        jTextFieldPlazas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPlazasKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldPlazas);
        jTextFieldPlazas.setBounds(91, 101, 81, 27);

        jTextFieldLargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLargoActionPerformed(evt);
            }
        });
        jTextFieldLargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldLargoKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldLargo);
        jTextFieldLargo.setBounds(91, 127, 81, 27);

        jTextFieldAncho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAnchoActionPerformed(evt);
            }
        });
        jTextFieldAncho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldAnchoKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldAncho);
        jTextFieldAncho.setBounds(91, 153, 81, 27);

        jTextFieldGrosor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGrosorActionPerformed(evt);
            }
        });
        jTextFieldGrosor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldGrosorKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldGrosor);
        jTextFieldGrosor.setBounds(91, 179, 81, 27);

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(botonGuardar);
        botonGuardar.setBounds(10, 217, 90, 23);

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(botonCancelar);
        botonCancelar.setBounds(110, 220, 90, 23);

        jTableMedidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Plazas", "Largo", "Ancho", "Grosor", "Codigo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMedidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMedidasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMedidas);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(210, 40, 354, 229);

        jLabel5.setText("Medidas");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(26, 22, 60, 14);

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(26, 42, 100, 23);

        jButtonVer.setText("Ver");
        jButtonVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVer);
        jButtonVer.setBounds(270, 280, 49, 23);

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEliminar);
        jButtonEliminar.setBounds(350, 280, 90, 23);

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonModificar);
        jButtonModificar.setBounds(10, 246, 90, 23);

        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldCodigo);
        jTextFieldCodigo.setBounds(91, 76, 81, 27);

        jLabel6.setText("Codigo");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 80, 50, 14);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel1.add(fondo);
        fondo.setBounds(0, 0, 1680, 1050);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPlazasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPlazasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPlazasActionPerformed

    private void jTextFieldLargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLargoActionPerformed

    private void jTextFieldAnchoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAnchoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAnchoActionPerformed

    private void jTextFieldGrosorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGrosorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGrosorActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        if(validar())
        {
            medidas= new MedidasC(this);
            medidas.guardar();
            actualizar();
            limpiarCampos();
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void jButtonVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerActionPerformed
        verMedidas();
    }//GEN-LAST:event_jButtonVerActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        eliminarMedidas();
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       actualizar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        modificarMedidas();
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void jTextFieldPlazasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPlazasKeyReleased
        autoCompletarCodigoPlazas();
        if(jTextFieldPlazas.getText().isEmpty()){
            jTextFieldLargo.setEnabled(true);
            jTextFieldAncho.setEnabled(true);
            
        }else{
            jTextFieldLargo.setEnabled(false);
            jTextFieldAncho.setEnabled(false);
            
        }
    }//GEN-LAST:event_jTextFieldPlazasKeyReleased

    private void jTextFieldLargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLargoKeyReleased
        autoCompletarCodigoPlazas();
        if(jTextFieldAncho.getText().isEmpty()&&jTextFieldLargo.getText().isEmpty()){
            jTextFieldPlazas.setEnabled(true);
            
        }else{
            jTextFieldPlazas.setEnabled(false);
           
        }
    }//GEN-LAST:event_jTextFieldLargoKeyReleased

    private void jTextFieldAnchoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAnchoKeyReleased
        autoCompletarCodigoPlazas();
        if(jTextFieldAncho.getText().isEmpty()&&jTextFieldLargo.getText().isEmpty()){
            jTextFieldPlazas.setEnabled(true);
           
        }else{
            jTextFieldPlazas.setEnabled(false);
            
        }
    }//GEN-LAST:event_jTextFieldAnchoKeyReleased

    private void jTextFieldGrosorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGrosorKeyReleased
        autoCompletarCodigoPlazas();
    }//GEN-LAST:event_jTextFieldGrosorKeyReleased

    private void jTableMedidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMedidasMouseClicked
        if(evt.getClickCount()==2){
            nuevoProducto.setMedidasSeleccionada(jTableMedidas.getModel().getValueAt(filaSeleccionada(), 4));
            dispose();
        }
    }//GEN-LAST:event_jTableMedidasMouseClicked

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
            java.util.logging.Logger.getLogger(MedidasV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedidasV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedidasV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedidasV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedidasV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMedidas;
    private javax.swing.JTextField jTextFieldAncho;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldGrosor;
    private javax.swing.JTextField jTextFieldLargo;
    private javax.swing.JTextField jTextFieldPlazas;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the plazas
     */
    public String getPlazas() {
        return plazas;
    }

    /**
     * @param plazas the plazas to set
     */
    public void setPlazas(String plazas) {
        this.plazas = plazas;
        jTextFieldPlazas.setText(""+plazas);
    }

    /**
     * @return the ancho
     */
    public String getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(String ancho) {
        this.ancho = ancho;
        jTextFieldAncho.setText(ancho);
    }

    /**
     * @return the largo
     */
    public String getLargo() {
        return largo;
    }

    /**
     * @param largo the largo to set
     */
    public void setLargo(String largo) {
        this.largo = largo;
        jTextFieldLargo.setText(largo);
    }

    /**
     * @return the grosor
     */
    public String getGrosor() {
        return grosor;
    }

    /**
     * @param grosor the grosor to set
     */
    public void setGrosor(String grosor) {
        this.grosor = grosor;
        jTextFieldGrosor.setText(grosor);
    }

    private boolean validar() {
        plazas=jTextFieldPlazas.getText();
        ancho=jTextFieldAncho.getText();
        largo=jTextFieldLargo.getText();
        grosor=jTextFieldGrosor.getText();
        codigo=jTextFieldCodigo.getText();
        return true;
    }

    /**
     * @return the medidas
     */
    public MedidasC getMedidas() {
        return medidas;
    }

    /**
     * @param medidas the medidas to set
     */
    public void setMedidas(MedidasC medidas) {
        this.medidas = medidas;
    }
    
    private void actualizar(){
        limpiarTabla();
        llenarTableMedidas();
    }
    public void llenarTableMedidas(){
        //medidas=new MedidasC();
        medidas.llenarJTableEsponjas(jTableMedidas);
    }
    private void limpiarTabla(){
        DefaultTableModel dm=(DefaultTableModel)jTableMedidas.getModel();
        for(int tam=dm.getRowCount()-1;tam>=0;tam--){
            dm.removeRow(tam);
        }
    }

    private void verMedidas() {
        if(filaSeleccionada()>=0){
            medidas.establecerMedidasIndex(filaSeleccionada());
            medidas.getMedidas(this);
        }
    }
    
    public int filaSeleccionada(){
        int fila_select = jTableMedidas.getSelectedRow();
        if(fila_select<0)
            JOptionPane.showMessageDialog(this,"Seleccione una Esponja");
        return fila_select;
    }

    private void modificarMedidas() {
        if(validar()){
        medidas.setMedidas(this);
        medidas.modificar();
        }
        actualizar();
    }

    private void eliminarMedidas() {
        if(filaSeleccionada()>=0){
            medidas.establecerMedidasIndex(filaSeleccionada());
            if(!medidas.eliminarMedidas())
                JOptionPane.showMessageDialog(rootPane, "No se pudo eliminar, la espoja esta relacionada a uno o mas colchones, elimine estos primero");
        }
        actualizar();
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
        jTextFieldCodigo.setText(codigo);
    }

    private void autoCompletarCodigoPlazas() {
        if(jTextFieldPlazas.isEnabled())
            jTextFieldCodigo.setText(jTextFieldPlazas.getText()+"x"+jTextFieldGrosor.getText());
        else
            jTextFieldCodigo.setText(jTextFieldLargo.getText()+"x"+jTextFieldAncho.getText()+"x"+jTextFieldGrosor.getText());
    }

    private void limpiarCampos() {
        jTextFieldCodigo.setText("");
        jTextFieldAncho.setText("");
        jTextFieldGrosor.setText("");
        jTextFieldLargo.setText("");
        jTextFieldPlazas.setText("");
    }
    
}
