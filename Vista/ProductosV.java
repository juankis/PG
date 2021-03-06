/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.ColchonC;
import Controlador.Conexion;
import Modelo.Esponja;
import Modelo.Medidas;
import com.sun.corba.se.spi.logging.CORBALogDomains;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author juanki
 */
public class ProductosV extends javax.swing.JFrame {
    EsponjaV vistaEsponja;
    MedidasV vistaMedidas;
    private ColchonC colchon;
    private EntradaV transaccion;
    public ProductosV() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        colchon =new ColchonC();
        actualizar();
    }

    ProductosV(EntradaV aThis) {
        transaccion=aThis;
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        colchon =new ColchonC();
        actualizar();
        valoresPorDefecto();
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
        jLabel7 = new javax.swing.JLabel();
        buttonActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jButtonVer = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        crearProducto = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(283, 260));
        jPanel1.setLayout(null);

        jLabel7.setText("Producto Colchon");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 22, 110, 16);

        buttonActualizar.setMnemonic('a');
        buttonActualizar.setText("Actualizar");
        buttonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(buttonActualizar);
        buttonActualizar.setBounds(20, 54, 110, 28);

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Color", "Tela", "Esponja", "Medidas", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProductos);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(170, 30, 456, 265);

        jButtonVer.setMnemonic('v');
        jButtonVer.setText("Ver");
        jButtonVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVer);
        jButtonVer.setBounds(20, 130, 110, 28);

        jButtonEliminar.setMnemonic('e');
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEliminar);
        jButtonEliminar.setBounds(20, 170, 110, 28);

        crearProducto.setMnemonic('p');
        crearProducto.setText("crear Producto");
        crearProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearProductoActionPerformed(evt);
            }
        });
        jPanel1.add(crearProducto);
        crearProducto.setBounds(20, 90, 110, 28);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        fondo.setText("de3");
        jPanel1.add(fondo);
        fondo.setBounds(0, 0, 1705, 1050);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_buttonActualizarActionPerformed

    private void jTableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductosMouseClicked
        if(evt.getClickCount()==2){
            try{
               transaccion.setProductoSeleccionado(jTableProductos.getModel().getValueAt(filaSeleccionada(),0));
               dispose();
            }catch (NullPointerException e){

            }   
        }
    }//GEN-LAST:event_jTableProductosMouseClicked

    private void jButtonVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerActionPerformed
        editarProducto();
    }//GEN-LAST:event_jButtonVerActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        eliminarProducto();
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void crearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearProductoActionPerformed
        ProductoFormulario form=new ProductoFormulario(colchon,this,false);
        form.setVisible(true);
    }//GEN-LAST:event_crearProductoActionPerformed

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
            java.util.logging.Logger.getLogger(ProductosV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductosV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductosV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductosV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductosV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualizar;
    private javax.swing.JButton crearProducto;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonVer;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductos;
    // End of variables declaration//GEN-END:variables

    
    
    
    /**
     * @return the producto
     */
    

    private void inicializarVariables() {
//        llenarListaMedias();
  //      llenarListaEsponjas();
        llenarjTableProductos();
    //    llenarAtributosColchon();
    }

    public void actualizar() {
        limpiarTabla();
        //limpiarCampos();
        //llenarListaMedias();
        //llenarListaEsponjas();
        llenarjTableProductos();
        //llenarAtributosColchon();
        //seleccionarCamposVacios();
    }

    private void limpiarTabla(){
        DefaultTableModel dm=(DefaultTableModel)jTableProductos.getModel();
        for(int tam=dm.getRowCount()-1;tam>=0;tam--){
            dm.removeRow(tam);
        }
    }
    
    private void llenarjTableProductos() {
        colchon.llenarJTableProductos(jTableProductos);
    }
    
    public ColchonC getProducto() {
        return colchon;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(ColchonC producto) {
        this.colchon = producto;
    }
    
    public int filaSeleccionada(){
        int fila_select = jTableProductos.getSelectedRow();
        if(fila_select<0)
            JOptionPane.showMessageDialog(this,"Seleccione una Esponja");
        return fila_select;
    }

    

    private void editarProducto() {
        if(filaSeleccionada()>=0){
            colchon.establecerProductoIndex(filaSeleccionada());
            ProductoFormulario form=new ProductoFormulario(colchon,this,true);
            colchon.getProducto(form);
            form.setVisible(rootPaneCheckingEnabled);
        }
    }

    private void eliminarProducto() {
        
        if(filaSeleccionada()>=0){
            colchon.establecerProductoIndex(filaSeleccionada());
            if(!colchon.eliminarProducto())
                JOptionPane.showMessageDialog(rootPane, "No se pudo eliminar, la producto esta relacionado");
        }
        
        actualizar();
    }

    

    private void valoresPorDefecto() {
       //jTextFieldNombre.setText("Auto");
    }

    
    
       
}
