/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import static Aplicacion.AplicacionTarea3.miIcono;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AnaIglesias
 */
public class ListadoEmpleados extends javax.swing.JDialog {

    String buscar, codigo;
    SQLClass query;
    private PreparedStatement enviaConsulta;
    private final String consultaArticulo = "Select nombre_Empleado from Empleados where codigo_Empleado IN "
            + "(Select cod_emple from Ordenes where codigo_producto = ?)";
    /**
     * Creates new form ListadoEmpleados
     */
    public ListadoEmpleados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(miIcono);
        
        //Establecemos el español para los mensajes de error
        Locale.setDefault(new Locale("es","ES"));
        setLocationRelativeTo(null);
        
        query = new SQLClass();
        query.conectar();
        query.setRS("Select Distinct codigo_Producto, nombre_Producto From Ordenes");
       
        try {
            //recorremos el Resultset rellenando con los datos el ComboBox
            while(query.getRS().next()){
                jComboBox_articulo.addItem(query.getRS().getString(1)+" => "+query.getRS().getString(2)); 
            }
            
            //cerramos la conexión para liberar recursos
            query.cerrarConexion();   
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox_articulo = new javax.swing.JComboBox<>();
        jButton_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_listaEmpleados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(ListadoEmpleados.class, "ListadoEmpleados.title")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText(org.openide.util.NbBundle.getMessage(ListadoEmpleados.class, "ListadoEmpleados.jLabel1.text")); // NOI18N

        jComboBox_articulo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_articulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_articuloActionPerformed(evt);
            }
        });

        jButton_buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_buscar.setText(org.openide.util.NbBundle.getMessage(ListadoEmpleados.class, "ListadoEmpleados.jButton_buscar.text")); // NOI18N
        jButton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarActionPerformed(evt);
            }
        });

        jTable_listaEmpleados.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable_listaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Empleados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_listaEmpleados);
        if (jTable_listaEmpleados.getColumnModel().getColumnCount() > 0) {
            jTable_listaEmpleados.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(ListadoEmpleados.class, "ListadoEmpleados.jTable_listaEmpleados.columnModel.title0")); // NOI18N
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_buscar)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_articuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_articuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_articuloActionPerformed

    private void jButton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarActionPerformed
        query.conectar();
        codigo = "";
        ResultSet rs = null;
        //obtengo el empleado seleccionado
        buscar = jComboBox_articulo.getSelectedItem().toString().substring(0, 9);
        
        //comprobamos los caracteres obtenidos del ComboBox para asegurar el código correcto
        for(int i=0;i<buscar.length();i++){
            if (Character.isLetter(buscar.charAt(i)) || Character.isDigit(buscar.charAt(i))){
                codigo += buscar.charAt(i);
            }
        }
        
        try {
            enviaConsulta = query.getCN().prepareStatement(consultaArticulo);
            enviaConsulta.setString(1, codigo);
            rs = enviaConsulta.executeQuery();
            DefaultTableModel modelo = new DefaultTableModel();
            String[] nombre = {"Nombre"};
            modelo.setColumnIdentifiers(nombre);
            String[] empleados = new String[1];
            
            while(rs.next()){
                empleados[0] = rs.getString(1);
                modelo.addRow(empleados);
            }
            
            jTable_listaEmpleados.setModel(modelo);
            
        } catch (SQLException ex) {
                System.out.println("Error de ejecución\n"+ex);
        }
        
    }//GEN-LAST:event_jButton_buscarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JComboBox<String> jComboBox_articulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_listaEmpleados;
    // End of variables declaration//GEN-END:variables
}
