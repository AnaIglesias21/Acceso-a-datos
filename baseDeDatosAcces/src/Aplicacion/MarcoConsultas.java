/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import static Aplicacion.AplicacionTarea3.miIcono;
import datos.Empleados;
import datos.Ordenes;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import org.openide.util.Exceptions;

/**
 *
 * @author AnaIglesias
 */
public class MarcoConsultas extends javax.swing.JDialog {

    private Empleados empleado;
    private Ordenes orden;
    private SQLClass query;
    private String[] datos = new String[3];
        
    /**
     * Creates new form MarcoConsultas
     */
    public MarcoConsultas(java.awt.Frame parent, boolean modal, String tabla) {
        super(parent, modal);
        initComponents();
        setIconImage(miIcono);
        setLocationRelativeTo(null);//colocamos en el centro la ventana
        jLabel_titulo.setText(tabla);
        
        //conectamos a la bse de datos
        query = new SQLClass();
        query.conectar();
        //inicializamos la tabla
        inicializarTabla(tabla);
        //creamos la conexión 
        query.cerrarConexion();
    }
    
    //método para inicializar la tabla
    public void inicializarTabla(String tabla){
        //definimos nuetro modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();
        //ejecutamos la consulta
        query.setRS("Select * from "+tabla);
        
        if (tabla.equals("EMPLEADOS")){
            //creamos un objeto de tipo empleado
            empleado = new Empleados();
            /*con el objeto empleado obtemos los nombres de los campos a 
              visualizar y los establecemos como cabecera de nuestra tabla
            */
            modelo.setColumnIdentifiers(empleado.getCampos());
            
            
            try {
                //mientras haya registros obtenemos los datos 
                while(query.getRS().next()){
                    
                    datos[0] = query.getRS().getString(1);
                    datos[1] = query.getRS().getString(2);
                    datos[2] = query.getRS().getString(3);
                    //añadimos una fila a nuestra tabla
                    modelo.addRow(datos);
                    
                }
            } catch (SQLException ex) {
                Exceptions.printStackTrace(ex);
            }
        }else{
            orden = new Ordenes();
            
            modelo.setColumnIdentifiers(orden.getCampos());
            
            try {
                while(query.getRS().next()){
                    datos[0] = query.getRS().getString(1);
                    datos[1] = query.getRS().getString(2);
                    datos[2] = query.getRS().getString(3);
                    modelo.addRow(datos);
                }
            } catch (SQLException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        
        jTable_datos.setModel(modelo);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_datos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(MarcoConsultas.class, "MarcoConsultas.title")); // NOI18N
        setResizable(false);

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_titulo.setText(org.openide.util.NbBundle.getMessage(MarcoConsultas.class, "MarcoConsultas.jLabel_titulo.text")); // NOI18N

        jTable_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable_datos);
        if (jTable_datos.getColumnModel().getColumnCount() > 0) {
            jTable_datos.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(MarcoConsultas.class, "MarcoConsultas.jTable_datos.columnModel.title0")); // NOI18N
            jTable_datos.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(MarcoConsultas.class, "MarcoConsultas.jTable_datos.columnModel.title1")); // NOI18N
            jTable_datos.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(MarcoConsultas.class, "MarcoConsultas.jTable_datos.columnModel.title2")); // NOI18N
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_titulo))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_datos;
    // End of variables declaration//GEN-END:variables
}