/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.ColchonC;
import Controlador.Conexion;
import Controlador.Validacion;
import Modelo.Esponja;
import Modelo.Medidas;
import java.util.ArrayList;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author fcpa
 */
public class ProductoFormulario extends javax.swing.JFrame {

    /**
     * Creates new form ProductoFormulario
     */
    private ColchonC colchon;
    EsponjaV vistaEsponja;
    MedidasV vistaMedidas;
    private String nombre;
    private String color;
    private String tela;
    private String tipo;
    private Esponja esponja;
    private Medidas medidas;
    private ArrayList<Esponja> listaEsponjas;
    private ArrayList<Medidas> listaMedidas;
    private Conexion conexion;
    private Validacion validacion;
    private ProductosV productos;
    public ProductoFormulario() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        validacion=new Validacion();
        
        iniciarValoresIniciales();
    }

    public ProductoFormulario(ColchonC colcchonC, ProductosV productos) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        validacion=new Validacion();
        this.colchon=colcchonC;
        this.productos=productos;
        iniciarValoresIniciales();
    }
    
    private void iniciarValoresIniciales() {
        actualizar();
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNombre = new javax.swing.JTextField();
        jComboBoxColor = new javax.swing.JComboBox();
        jComboBoxTela = new javax.swing.JComboBox();
        jComboBoxEsponja = new javax.swing.JComboBox();
        jComboBoxTipo = new javax.swing.JComboBox();
        jComboBoxMedidas = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonVistaEsponja = new javax.swing.JButton();
        jButtonVistaMedidas = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jBottonCancelar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextFieldNombre.setBackground(new java.awt.Color(255, 204, 204));
        jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNombreKeyReleased(evt);
            }
        });

        jComboBoxColor.setEditable(true);

        jComboBoxTela.setEditable(true);

        jComboBoxEsponja.setEditable(true);

        jComboBoxTipo.setEditable(true);

        jComboBoxMedidas.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxMedidas.setEditable(true);

        jLabel6.setText("Medidas");

        jLabel5.setText("Tipo");

        jLabel4.setText("Esponja");

        jLabel3.setText("Tela");

        jLabel2.setText("Color");

        jLabel1.setText("Nombre");

        jButtonVistaEsponja.setText("+");
        jButtonVistaEsponja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVistaEsponjaActionPerformed(evt);
            }
        });

        jButtonVistaMedidas.setText("+");
        jButtonVistaMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVistaMedidasActionPerformed(evt);
            }
        });

        jButtonGuardar.setMnemonic('g');
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jBottonCancelar.setMnemonic('c');
        jBottonCancelar.setText("Cancelar");
        jBottonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBottonCancelarActionPerformed(evt);
            }
        });

        jButtonModificar.setMnemonic('m');
        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxTela, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxColor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxEsponja, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jButtonVistaEsponja))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jButtonVistaMedidas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jBottonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jComboBoxTela, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxColor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jComboBoxEsponja, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButtonVistaEsponja)))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jComboBoxMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButtonVistaMedidas)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGuardar)
                    .addComponent(jBottonCancelar))
                .addGap(1, 1, 1)
                .addComponent(jButtonModificar)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVistaEsponjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVistaEsponjaActionPerformed
        vistaEsponja= new EsponjaV(this);
        vistaEsponja.setVisible(true);
    }//GEN-LAST:event_jButtonVistaEsponjaActionPerformed

    private void jButtonVistaMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVistaMedidasActionPerformed
        vistaMedidas = new MedidasV(this);
        vistaMedidas.setVisible(true);
    }//GEN-LAST:event_jButtonVistaMedidasActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jBottonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBottonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jBottonCancelarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        modificarProducto();
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jTextFieldNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyReleased
        validacion.esVacioJTextField(jTextFieldNombre);
    }//GEN-LAST:event_jTextFieldNombreKeyReleased

    public ColchonC getProducto() {
        return colchon;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(ColchonC producto) {
        this.colchon = producto;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
        jTextFieldNombre.setText(nombre);
    }
    
    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
        jComboBoxColor.setSelectedItem(color);
    }

    /**
     * @return the tela
     */
    public String getTela() {
        return tela;
    }

    /**
     * @param tela the tela to set
     */
    public void setTela(String tela) {
        this.tela = tela;
        jComboBoxTela.setSelectedItem(tela);
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
        jComboBoxTipo.setSelectedItem(tipo);
    }

    /**
     * @return the esponja
     */
    public Esponja getEsponja() {
        return esponja;
    }

    /**
     * @param esponja the esponja to set
     */
    public void setEsponja(Esponja esponja) {
        this.esponja = esponja;
        try{
            jComboBoxEsponja.setSelectedItem(esponja.getCodigo());
        }catch(NullPointerException e){
            jComboBoxEsponja.setSelectedItem("");
        }
        
    }

    /**
     * @return the medidas
     */
    public Medidas getMedidas() {
        return medidas;
    }

    /**
     * @param medidas the medidas to set
     */
    public void setMedidas(Medidas medidas) {
        this.medidas = medidas;
        try{
            jComboBoxMedidas.setSelectedItem(medidas.getCodigo());
        }catch(NullPointerException e){
            jComboBoxMedidas.setSelectedItem("");
        }
        
    }

    /**
     * @return the listaEsponjas
     */
    public ArrayList<Esponja> getListaEsponjas() {
        return listaEsponjas;
    }

    /**
     * @param listaEsponjas the listaEsponjas to set
     */
    public void setListaEsponjas(ArrayList<Esponja> listaEsponjas) {
        this.listaEsponjas = listaEsponjas;
    }

    /**
     * @return the listaMedidas
     */
    public ArrayList<Medidas> getListaMedidas() {
        return listaMedidas;
    }

    /**
     * @param listaMedidas the listaMedidas to set
     */
    public void setListaMedidas(ArrayList<Medidas> listaMedidas) {
        this.listaMedidas = listaMedidas;
    }
    
    void setMedidasSeleccionada(Object medidas) {
        llenarListaMedias();
        jComboBoxMedidas.setSelectedItem(medidas);
    }

    void setEsponjaSeleccionada(Object valueAt) {
        llenarListaEsponjas();
        jComboBoxEsponja.setSelectedItem(valueAt);
    }
    
    private void llenarListaMedias(){
        colchon.llenarListaMedidas(this.jComboBoxMedidas);
        AutoCompleteDecorator.decorate(jComboBoxMedidas);
    }
    
    private void llenarListaEsponjas(){
        colchon.llenarListaEsponjas(this.jComboBoxEsponja);
        AutoCompleteDecorator.decorate(jComboBoxEsponja);
    }
    private void modificarProducto() {
        if(validar()){
            colchon.setProducto(this);    
            colchon.modificar();
            validacion.mostrarMensaje("los cambios se han realizado con exito");
            productos.actualizar();
            dispose(); 
        }
        //actualizar();
    }
    
    private void actualizar() {
        //limpiarTabla();
        limpiarCampos();
        llenarListaMedias();
        llenarListaEsponjas();
        //llenarjTableProductos();
        llenarAtributosColchon();
        seleccionarCamposVacios();
    }
    
    private void llenarAtributosColchon() {
        colchon.llenarAtributosColchon(this.jComboBoxColor,this.jComboBoxTela,this.jComboBoxTipo);
        AutoCompleteDecorator.decorate(jComboBoxColor);
        AutoCompleteDecorator.decorate(jComboBoxTela);
        AutoCompleteDecorator.decorate(jComboBoxTipo);
    }
    
    private void seleccionarCamposVacios() {
        jComboBoxColor.setSelectedItem("");
        jComboBoxEsponja.setSelectedItem("");
        jComboBoxMedidas.setSelectedItem("");
        jComboBoxTela.setSelectedItem("");
        jComboBoxTipo.setSelectedItem("");
    }
    
    private void limpiarCampos() {
        jComboBoxColor.removeAllItems();
        jComboBoxEsponja.removeAllItems();
        jComboBoxMedidas.removeAllItems();
        jComboBoxTela.removeAllItems();
        jComboBoxTipo.removeAllItems();
    }
    
    private boolean validar() {
        if(jComboBoxEsponja.getSelectedIndex()>=0)
            esponja=colchon.getListaEsponjas().get(jComboBoxEsponja.getSelectedIndex());
        else
            esponja=null;
        
        if(jComboBoxMedidas.getSelectedIndex()>=0)
            medidas=colchon.getListaMedidas().get(jComboBoxMedidas.getSelectedIndex());
        else
            medidas=null;
        
        tela = jComboBoxTela.getSelectedItem().toString();
        color = jComboBoxColor.getSelectedItem().toString();
        tipo = jComboBoxTipo.getSelectedItem().toString();
        nombre = jTextFieldNombre.getText();
        return true;
    }
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
            java.util.logging.Logger.getLogger(ProductoFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductoFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductoFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductoFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductoFormulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBottonCancelar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonVistaEsponja;
    private javax.swing.JButton jButtonVistaMedidas;
    private javax.swing.JComboBox jComboBoxColor;
    private javax.swing.JComboBox jComboBoxEsponja;
    private javax.swing.JComboBox jComboBoxMedidas;
    private javax.swing.JComboBox jComboBoxTela;
    private javax.swing.JComboBox jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables

    public void editar() {
        jButtonModificar.setLocation(jButtonGuardar.getLocation().x,jButtonGuardar.getLocation().y);
        jButtonGuardar.setVisible(false);
    }

    private void guardar() {
        if(validar()){
            colchon= new Controlador.ColchonC(this);
            colchon.guardar();
            //seleccionarCamposVacios();
            validacion.mostrarMensaje("La Operacion se a Guardado Con exito");
            productos.actualizar();
            dispose();
            
        }
    }

    
}