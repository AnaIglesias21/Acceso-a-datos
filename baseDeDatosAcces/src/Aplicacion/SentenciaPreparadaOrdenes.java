/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import static Aplicacion.AplicacionTarea3.miIcono;
import java.sql.*;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.event.*;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

/**
 *
 * @author AnaIglesias
 */
public class SentenciaPreparadaOrdenes extends javax.swing.JDialog {

    private String buscar , codigo="";
    private SQLClass query = new SQLClass();
    private PreparedStatement enviaConsulta;
    /**
     * Creates new form MarcoActualizarOrdenes
     */
    public SentenciaPreparadaOrdenes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(miIcono);
        Locale.setDefault(new Locale("es","ES"));
        jButton_aceptar.setEnabled(false);
        setLocationRelativeTo(null);
        
        //creamoa la conexión para almacenar en el comboBox todos los empleados 
        query.conectar();
        query.setRS("Select * from Ordenes");
       
        try {
            //recorremos el Resultset rellenando con los datos el ComboBox
            while(query.getRS().next()){
                jComboBox_articulos.addItem(query.getRS().getString(1)+" => "+query.getRS().getString(2)); 
            }
            
            //cerramos la conexión para liberar recursos
            query.cerrarConexion();   
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
            
        ValidationGroup group = validationPanel.getValidationGroup();
        group.add(jTextField_codigo, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextField_nombre, StringValidators.REQUIRE_NON_EMPTY_STRING);
        
        validationPanel.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                if (validationPanel.getProblem()== null){
                    jButton_aceptar.setEnabled(true);
                }else{
                    jButton_aceptar.setEnabled(false);
                }
            }
            
        });
       
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox_articulos = new javax.swing.JComboBox<>();
        jPanel_insertaOrdenes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_codigo = new javax.swing.JTextField();
        jTextField_nombre = new javax.swing.JTextField();
        validationPanel = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jTextField_empleado = new javax.swing.JTextField();
        jButton_aceptar = new javax.swing.JButton();
        jButton_limpiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton_buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(SentenciaPreparadaOrdenes.class, "SentenciaPreparadaOrdenes.title")); // NOI18N

        jComboBox_articulos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_articulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_articulosActionPerformed(evt);
            }
        });

        jPanel_insertaOrdenes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(SentenciaPreparadaOrdenes.class, "SentenciaPreparadaOrdenes.jPanel_insertaOrdenes.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText(org.openide.util.NbBundle.getMessage(SentenciaPreparadaOrdenes.class, "SentenciaPreparadaOrdenes.jLabel1.text")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText(org.openide.util.NbBundle.getMessage(SentenciaPreparadaOrdenes.class, "SentenciaPreparadaOrdenes.jLabel2.text")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText(org.openide.util.NbBundle.getMessage(SentenciaPreparadaOrdenes.class, "SentenciaPreparadaOrdenes.jLabel3.text")); // NOI18N

        jTextField_codigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_codigo.setName("Código"); // NOI18N

        jTextField_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_nombre.setName("Nombre"); // NOI18N

        jTextField_empleado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_empleado.setText(org.openide.util.NbBundle.getMessage(SentenciaPreparadaOrdenes.class, "SentenciaPreparadaOrdenes.jTextField_empleado.text")); // NOI18N

        javax.swing.GroupLayout jPanel_insertaOrdenesLayout = new javax.swing.GroupLayout(jPanel_insertaOrdenes);
        jPanel_insertaOrdenes.setLayout(jPanel_insertaOrdenesLayout);
        jPanel_insertaOrdenesLayout.setHorizontalGroup(
            jPanel_insertaOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_insertaOrdenesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_insertaOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_insertaOrdenesLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_empleado)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel_insertaOrdenesLayout.createSequentialGroup()
                        .addGroup(jPanel_insertaOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGroup(jPanel_insertaOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_insertaOrdenesLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(validationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_insertaOrdenesLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel_insertaOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(31, Short.MAX_VALUE))))
        );
        jPanel_insertaOrdenesLayout.setVerticalGroup(
            jPanel_insertaOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_insertaOrdenesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(validationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_insertaOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel_insertaOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel_insertaOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jButton_aceptar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_aceptar.setText(org.openide.util.NbBundle.getMessage(SentenciaPreparadaOrdenes.class, "SentenciaPreparadaOrdenes.jButton_aceptar.text")); // NOI18N
        jButton_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aceptarActionPerformed(evt);
            }
        });

        jButton_limpiar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_limpiar.setText(org.openide.util.NbBundle.getMessage(SentenciaPreparadaOrdenes.class, "SentenciaPreparadaOrdenes.jButton_limpiar.text")); // NOI18N
        jButton_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_limpiarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText(org.openide.util.NbBundle.getMessage(SentenciaPreparadaOrdenes.class, "SentenciaPreparadaOrdenes.jLabel5.text")); // NOI18N

        jButton_buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_buscar.setText(org.openide.util.NbBundle.getMessage(SentenciaPreparadaOrdenes.class, "SentenciaPreparadaOrdenes.jButton_buscar.text")); // NOI18N
        jButton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_articulos, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_buscar)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel_insertaOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_articulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jButton_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_insertaOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_articulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_articulosActionPerformed

    }//GEN-LAST:event_jComboBox_articulosActionPerformed

    private void jButton_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aceptarActionPerformed
        
       try {

            query.conectar();
            String stn_actualiza = "UPDATE ORDENES SET "
                    + "Nombre_Producto = ?"
                    + " WHERE Codigo_Producto = ?";
            enviaConsulta = query.getCN().prepareStatement(stn_actualiza);
            enviaConsulta.setString(1, jTextField_nombre.getText());
            enviaConsulta.setString(2, jTextField_codigo.getText());
            enviaConsulta.executeUpdate();
            enviaConsulta.close();
            JOptionPane.showMessageDialog(null, "Registro modificado correctamente", null, JOptionPane.INFORMATION_MESSAGE);
            query.cerrarConexion();
            dispose();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    

    }//GEN-LAST:event_jButton_aceptarActionPerformed

    private void jButton_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_limpiarActionPerformed
        jTextField_codigo.setText("");
        jTextField_nombre.setText("");
        jTextField_empleado.setText("");
        jComboBox_articulos.setSelectedIndex(0);
    }//GEN-LAST:event_jButton_limpiarActionPerformed

    private void jButton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarActionPerformed
                                                     
        try {
            query.conectar();
            codigo="";
            //obtengo el empleado seleccionado
            buscar = jComboBox_articulos.getSelectedItem().toString().substring(0, 9);
            //comprobamos los caracteres obtenidos del ComboBox para asegurar el código correcto
            for(int i=0;i<buscar.length();i++){
                if (Character.isLetter(buscar.charAt(i)) || Character.isDigit(buscar.charAt(i))){
                    codigo += buscar.charAt(i);
                }
            }
            
            String consultaOrdenes = "Select * from Ordenes WHERE codigo_Producto = ?";
            enviaConsulta = query.getCN().prepareStatement(consultaOrdenes);
            enviaConsulta.setString(1, codigo);
            ResultSet rs = enviaConsulta.executeQuery();
            if (rs.next()){
            
                //visualizamos los datos de la tabla ordenes seleccionado
                jTextField_codigo.setText(rs.getString(1));
                jTextField_codigo.setEditable(false);
                jTextField_nombre.setText(rs.getString(2));
                jTextField_empleado.setText(rs.getString(3));
                jTextField_empleado.setEditable(false);
                jButton_aceptar.setEnabled(true);
            }
            
            query.cerrarConexion();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton_buscarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_aceptar;
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_limpiar;
    private javax.swing.JComboBox<String> jComboBox_articulos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel_insertaOrdenes;
    private javax.swing.JTextField jTextField_codigo;
    private javax.swing.JTextField jTextField_empleado;
    private javax.swing.JTextField jTextField_nombre;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanel;
    // End of variables declaration//GEN-END:variables
}
