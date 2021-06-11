package Aplicacion;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author AnaIglesias
 */
public class LaminaPrincipal extends JPanel{
    
     public LaminaPrincipal(){
        
        this.setLayout(new BorderLayout());
        
        //Creamos una lámina para la zona norte que ontendrá el JCombobox con las tablas
        laminaTablas = new JPanel();
        //creamos eun borde para personalizar la lámina
        bordeTablas = new TitledBorder(new BevelBorder(BevelBorder.RAISED,Color.LIGHT_GRAY,Color.DARK_GRAY),
                "Tablas de la Base de Datos",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font(Font.MONOSPACED,Font.BOLD,16),
                Color.DARK_GRAY);
        
        //palicamos el borde a la lámina
        laminaTablas.setBorder(bordeTablas);
        
        //damos un color de fondo
        //laminaTablas.setBackground(new Color(160,157,157));
        laminaTablas.setBackground(Color.CYAN.darker());
        
        //creamos los radio Button para seleccionar la tabla con la que trabajar
        rbEmpleados = new JRadioButton("Empleados    ",true);
        rbEmpleados.setForeground(Color.WHITE);
        //rbEmpleados.setBackground(new Color(160,157,157));
        rbEmpleados.setFont(new Font(Font.SERIF,Font.BOLD,15));
        rbEmpleados.setBackground(Color.CYAN.darker());
        
        rbEmpleados.addMouseListener(new MouseAdapter() {
           
            //Sobreescribo los métodos necesarios para mostrar la apariencia de los botones del menú
           @Override
            public void mouseEntered(MouseEvent e) {
            
                rbEmpleados.setForeground(Color.WHITE);
                rbProductos.setForeground(Color.DARK_GRAY);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                
            }
           
           @Override
            public void mouseClicked(MouseEvent e){
                
                rbEmpleados.setForeground(Color.WHITE);
                rbProductos.setForeground(Color.DARK_GRAY);
            }
            
            
        });
        
        rbProductos = new JRadioButton("Ordenes de Productos",false);
        rbProductos.setForeground(Color.DARK_GRAY);
        rbProductos.setFont(new Font(Font.SERIF,Font.BOLD,15));
        rbProductos.setBackground(Color.CYAN.darker());
      
        rbProductos.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseEntered(MouseEvent e) {
            
                rbProductos.setForeground(Color.WHITE);
                rbEmpleados.setForeground(Color.DARK_GRAY);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                
            }
            
           @Override
            public void mouseClicked(MouseEvent e){
                
                rbProductos.setForeground(Color.WHITE);
                rbEmpleados.setForeground(Color.DARK_GRAY);
                
            }
        });
        
        //añadimos los radio button a la lámina
        laminaTablas.add(rbEmpleados);
        laminaTablas.add(rbProductos);
        
        //añadimos los radio Button al grupo
        grupo = new ButtonGroup();
        grupo.add(rbEmpleados);
        grupo.add(rbProductos);
    
        this.add(laminaTablas, BorderLayout.NORTH);
        
        //creamos una lámina para presentar los botones del menú
        laminaBotones = new JPanel();
        
        //damos disposición a la lámina
        GridLayout gl = new GridLayout(3,2);
        gl.setHgap(5);
        gl.setVgap(5);
        laminaBotones.setLayout(gl);
        
        bordeBotones = new BevelBorder(BevelBorder.LOWERED,Color.DARK_GRAY,Color.DARK_GRAY);
        
        laminaBotones.setBorder(bordeBotones);
        laminaBotones.setBackground(Color.LIGHT_GRAY.darker());
        
        //Instanciamos la clase AccionRealizar
        AccionRealizar accion = new AccionRealizar();
        //Creamos, añadimos y ponemos los botones a la escucha mediante el metodo ponerBoton
        //creamos los botones
        laminaBotones.add(ponerBoton("Crear",accion));
        laminaBotones.add(ponerBoton("Insertar",accion));
        laminaBotones.add(ponerBoton("Consultar",accion));
        laminaBotones.add(ponerBoton("Actualizar",accion));
        laminaBotones.add(ponerBoton("<html><center><p>Sentencias</p><p>preparadas</p></html>",accion));
        laminaBotones.add(ponerBoton("<html><center><p>Listado</p><p>Empleado/Artículos</p></html>",accion));
        
        this.add(laminaBotones, BorderLayout.CENTER);
        
    }
    
    private BotonPersonalizado ponerBoton(String Titulo,ActionListener oyente){
         
         BotonPersonalizado boton = new BotonPersonalizado(Titulo);
         boton.addActionListener(oyente);
                        
         /*Uso la clase adaptadora para sobreescribir solo los métodos que me interesan
          utilizando una clase interna anónima*/
        
        boton.addMouseListener(new MouseAdapter() {
            
            //Sobreescribo los métodos necesarios para mostrar la apariencia de los botones del menú
           @Override
            public void mouseEntered(MouseEvent e) {
            
                boton.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,16));
                boton.setBorder(new LineBorder(Color.WHITE));
                boton.setForeground(Color.WHITE);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                boton.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,16));
                boton.setBorder(new LineBorder(Color.CYAN.darker()));
		boton.setForeground(Color.BLACK);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                
            }
        });
        
        return boton;
        
    }
    
    private class AccionRealizar implements ActionListener{
        //objeto para realizar las operaciones sobre las tablas de la BD
        SQLClass query = new SQLClass();
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String opcion = e.getActionCommand();
            
            switch (opcion) {
                
                case "Crear":
                    
                    if (rbEmpleados.isSelected()){
                         
                         query.crearTabla("Empleados");
                         
                      }else{
                         
                         query.crearTabla("Ordenes"); 
                         
                      }   
                    
                      break;
                      
                case "Insertar":
                    
                    query.conectar();
                    if (rbEmpleados.isSelected()){
                        if (query.existeTabla(query.getCN(), "Empleados")){
                            query.cerrarConexion();
                            //creamos una clase que se encarga de la recogida de datos
                            marcoEmpleados= new MarcoInsertarEmpleado(null, true);
                            marcoEmpleados.setVisible(true);
                            
                        }else{
                            
                            JOptionPane.showMessageDialog(null, "La tabla Empleados no está creada", null,JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        if (query.existeTabla(query.getCN(), "Ordenes")){
                            query.setRS("Select * from Empleados");
                            int filas=-1;
                            try {
                                filas = query.getRS().getRow();
                               
                            } catch (SQLException ex) {
                                
                            }
                            if (filas>-1){
                                query.cerrarConexion();
                                marcoOrdenes = new MarcoInsertarOrdenes(null,true);
                                marcoOrdenes.setVisible(true);
                            }else{
                               JOptionPane.showMessageDialog(null, "La tabla Empleados está vacía.\nNo se pueden introducir datos en la tabla Ordenes.", null,JOptionPane.INFORMATION_MESSAGE); 
                            }    
                        }else{
                            
                            JOptionPane.showMessageDialog(null, "La tabla Ordenes no está creada", null,JOptionPane.INFORMATION_MESSAGE);
                        }    
                    }  
                    query.cerrarConexion();
                    break;
                      
                case "Consultar":
                       
                        query.conectar();
                        
                        if (rbEmpleados.isSelected()){
                           if (query.existeTabla(query.getCN(), "Empleados")){
                                query.cerrarConexion();
                                marcoConsultas = new MarcoConsultas(null, true, "EMPLEADOS");
                        
                                marcoConsultas.setVisible(true);
                           }else{
                                
                                JOptionPane.showMessageDialog(null, "La tabla Empleados no está creada", null,JOptionPane.INFORMATION_MESSAGE);
                           } 
                        }else{
                           if (query.existeTabla(query.getCN(), "Ordenes")){
                                query.cerrarConexion();
                                marcoConsultas = new MarcoConsultas(null, true, "ORDENES");
                        
                                marcoConsultas.setVisible(true);
                           }else{
                               
                               JOptionPane.showMessageDialog(null, "La tabla Ordenes no está creada", null,JOptionPane.INFORMATION_MESSAGE);
                           }    
                        }
                        query.cerrarConexion();
                      break;
                      
                case "Actualizar":
                    query.conectar();
                    if (rbEmpleados.isSelected()){
                        if (query.existeTabla(query.getCN(), "Empleados")){
                            query.cerrarConexion();
                            marcoActualizaEmpleado = new MarcoActualizarEmpleado(null,true);
                            marcoActualizaEmpleado.setVisible(true);
                        }else{
                            
                            JOptionPane.showMessageDialog(null, "La tabla Empleados no está creada", null,JOptionPane.INFORMATION_MESSAGE);
                        }    
                    
                    }else{
                              
                        JOptionPane.showMessageDialog(null, "La tabla Ordenes no se actualiza", null,JOptionPane.INFORMATION_MESSAGE);
                       
                    }    
                    query.cerrarConexion();   
                    break;
                        
                case "<html><center><p>Sentencias</p><p>preparadas</p></html>":
                    
                    query.conectar();
                    if (rbEmpleados.isSelected()){
                        if (query.existeTabla(query.getCN(), "Empleados")){  
                            query.cerrarConexion();
                            SentenciaPreparadaEmpleado spEmpleado = new SentenciaPreparadaEmpleado(null,true);
                            spEmpleado.setVisible(true);
                        }else{
                                
                            JOptionPane.showMessageDialog(null, "La tabla Empleados no está creada", null,JOptionPane.INFORMATION_MESSAGE);
                        }    
                    
                    }else{
                        if (query.existeTabla(query.getCN(), "Ordenes")){
                            query.cerrarConexion();
                            spOrden = new SentenciaPreparadaOrdenes(null,true);
                            spOrden.setVisible(true);
                        }else{
                            
                            JOptionPane.showMessageDialog(null, "La tabla Ordenes no está creada", null,JOptionPane.INFORMATION_MESSAGE);
                        }  
                        
                    }    
                    query.cerrarConexion();
                    break;
                    
                case "<html><center><p>Listado</p><p>Empleado/Artículos</p></html>":
                    
                    query.conectar();
                    if (rbEmpleados.isSelected()){
                        if (query.existeTabla(query.getCN(), "Empleados") && query.existeTabla(query.getCN(),"Ordenes")){  
                            //query.cerrarConexion();    
                            listado = new ListadoEmpleados(null,true); 
                            listado.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(null, "La tabla Empleados o la tabla Ordenes no están creadas", null,JOptionPane.INFORMATION_MESSAGE);
                        }    
                    }else{
                        
                        JOptionPane.showMessageDialog(null, "No hay listado de la tabla Ordenes", "Listado", JOptionPane.INFORMATION_MESSAGE);
                    } 
                    
                    query.cerrarConexion();
                    break;
                    
            }        
           
        }
    
    }
    
    private Border bordePrincipal, bordeTablas, bordeBotones;
    JComboBox CBempleados;
    private JPanel laminaTablas, laminaBotones, laminaDatos;
    private JRadioButton rbEmpleados, rbProductos;
    private ButtonGroup grupo;
    private MarcoInsertarEmpleado marcoEmpleados;
    private MarcoInsertarOrdenes marcoOrdenes;
    private MarcoConsultas marcoConsultas;
    private MarcoActualizarEmpleado marcoActualizaEmpleado;
    private ListadoEmpleados listado;
    private SentenciaPreparadaEmpleado spEmpleado;
    private SentenciaPreparadaOrdenes spOrden;
   
}
