/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.EsponjaC;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author juanki
 */
public class EsponjaV extends javax.swing.JFrame {

    Controlador.EsponjaC esponja;
    private String material="";
    private String color="";
    private String codigo="";
    
    private NuevoProductoV nuevoProucto;
    public EsponjaV() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        actualizar();
        iniciarAutoComplete();
        limpiarCampos();
    }

    EsponjaV(NuevoProductoV aThis) {
        nuevoProucto=aThis;
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        actualizar();
        iniciarAutoComplete();
        limpiarCampos();
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
        colorCombo = new javax.swing.JComboBox();
        materialCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEsponjas = new javax.swing.JTable();
        jButtonVer = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        codigoCombo = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        colorCombo.setEditable(true);
        jPanel1.add(colorCombo);
        colorCombo.setBounds(85, 135, 91, 27);

        materialCombo.setEditable(true);
        materialCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                materialComboMouseReleased(evt);
            }
        });
        jPanel1.add(materialCombo);
        materialCombo.setBounds(85, 104, 91, 27);

        jLabel2.setText("color");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 138, 50, 14);

        jLabel1.setText("material");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 107, 50, 14);

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(botonCancelar);
        botonCancelar.setBounds(119, 183, 90, 23);

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(botonGuardar);
        botonGuardar.setBounds(10, 183, 90, 23);

        jLabel3.setText("Esponja");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 11, 60, 14);

        jTableEsponjas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Material", "Color", "Codigo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEsponjas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEsponjasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEsponjas);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(214, 11, 250, 227);

        jButtonVer.setText("ver");
        jButtonVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVer);
        jButtonVer.setBounds(243, 249, 74, 23);

        jButtonEliminar.setText("eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEliminar);
        jButtonEliminar.setBounds(330, 250, 90, 23);

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonModificar);
        jButtonModificar.setBounds(10, 209, 90, 23);

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonActualizar);
        jButtonActualizar.setBounds(10, 33, 100, 23);

        jLabel4.setText("Codigo");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 77, 50, 14);
        jPanel1.add(codigoCombo);
        codigoCombo.setBounds(85, 74, 91, 27);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        fondo.setText("jLabel5");
        jPanel1.add(fondo);
        fondo.setBounds(0, 0, 1718, 1050);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        if(validar()){
            esponja= new Controlador.EsponjaC(this);
            esponja.guardar();
            actualizar();
        }
        
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void jButtonVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerActionPerformed
        verEsponja();
    }//GEN-LAST:event_jButtonVerActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        modificarEsponja();
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        eliminarEsponja();
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void materialComboMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialComboMouseReleased
        autoCompletar();
        
    }//GEN-LAST:event_materialComboMouseReleased

    private void jTableEsponjasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEsponjasMouseClicked
        if(evt.getClickCount()==2){
            nuevoProucto.setEsponjaSeleccionada(jTableEsponjas.getModel().getValueAt(filaSeleccionada(), 2));    
            dispose();
        }
    }//GEN-LAST:event_jTableEsponjasMouseClicked
    
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
            java.util.logging.Logger.getLogger(EsponjaV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EsponjaV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EsponjaV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EsponjaV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EsponjaV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextField codigoCombo;
    private javax.swing.JComboBox colorCombo;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEsponjas;
    private javax.swing.JComboBox materialCombo;
    // End of variables declaration//GEN-END:variables

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
        materialCombo.getModel().setSelectedItem(material);
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        colorCombo.getModel().setSelectedItem(color);
        
    }
    private boolean validar(){
        material=""+materialCombo.getSelectedItem();
        color=""+colorCombo.getSelectedItem();
        codigo=codigoCombo.getText();//getSelectedItem().toString();
        return true;
    }
    public void llenarTableEsponjas(){
        esponja=new EsponjaC();
        esponja.llenarJTableEsponjas(jTableEsponjas);
    }

    private void verEsponja() {
        if(filaSeleccionada()>=0){
            esponja.establecerEsponjaIndex(filaSeleccionada());
            esponja.getEsponja(this);
        }
    }
    public int filaSeleccionada(){
        int fila_select = jTableEsponjas.getSelectedRow();
        if(fila_select<0)
            JOptionPane.showMessageDialog(this,"Seleccione una Esponja");
        return fila_select;
    }

    private void modificarEsponja() {
        if(validar()){
        esponja.setEsponja(this);
        esponja.modificar();
        }
        actualizar();
    }

    private void eliminarEsponja() {
        if(filaSeleccionada()>=0){
            esponja.establecerEsponjaIndex(filaSeleccionada());
            if(!esponja.eliminarEsponja())
                JOptionPane.showMessageDialog(rootPane, "No se pudo eliminar, la espoja esta relacionada a uno o mas colchones, elimine estos primero");
        }
        
        actualizar();
    }
    private void actualizar(){
        limpiarTabla();
        llenarTableEsponjas();
        llenarAtributosEsponja();
    }
    private void limpiarTabla(){
        DefaultTableModel dm=(DefaultTableModel)jTableEsponjas.getModel();
        for(int tam=dm.getRowCount()-1;tam>=0;tam--){
            dm.removeRow(tam);
        }
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
        codigoCombo.setText(codigo);
    }
    
     private void llenarAtributosEsponja() {
        esponja.llenarAtributosEsponja(this.materialCombo,this.colorCombo);
        AutoCompleteDecorator.decorate(materialCombo);
        AutoCompleteDecorator.decorate(colorCombo);
    }

    private void autoCompletar() {
        codigoCombo.setText(""+materialCombo.getSelectedItem()+"/"+colorCombo.getSelectedItem());
    }
    private void iniciarAutoComplete(){
        colorCombo.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
           @Override
            public void keyReleased(KeyEvent evt) {
               autoCompletar();
            }
            });
        materialCombo.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
           @Override
            public void keyReleased(KeyEvent evt) {
               autoCompletar();
            }
            });
    }

    private void limpiarCampos() {
        codigoCombo.setText("");
        materialCombo.setSelectedItem("");
        colorCombo.setSelectedItem("");
    }
}