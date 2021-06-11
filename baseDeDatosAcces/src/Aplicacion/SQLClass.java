
package Aplicacion;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author AnaIglesias
 */
public class SQLClass {
    
    private String url;
    private static Connection cn;
    private static Statement st;
    private static ResultSet rs;
    
    public SQLClass(){
        url="jdbc:ucanaccess://cortefies.mdb";
    }
    
    public void setRS(String consultaSql){
        
        rs = null;
       
        try{
           conectar();
           rs = st.executeQuery(consultaSql);
           
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR\n"+e);
        }
       
    }
    
    public ResultSet getRS(){
        return rs;
    }
    
    public Connection getCN(){
        return cn;
    }
    
    //método que conecta a la base de datos
    public Connection conectar(){
        try{
           
           //1. Crear conexión
           cn = DriverManager.getConnection(url);
           //2. Crear objeto Statement
           st = cn.createStatement();
           
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No ha sido posible realizar la conexión");
            
        }
        
        return cn;
    }
    
    //método para cerrar la conexión a la base de datos
    public void cerrarConexion(){
        try {
            if (cn != null)
                cn.close();
            if (st != null)
               st.close();
            if (rs != null)
              rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
   
    //método que crea las tablas en la base de datos
    public void crearTabla(String nombreTabla){
        
        String stn_sql = null;
        
        try{
            
            conectar();
           
            if (nombreTabla.equalsIgnoreCase("Empleados")){
               
                if (existeTabla(cn,nombreTabla)){
                    JOptionPane.showMessageDialog(null, "La tabla empleados ya está creada", null,JOptionPane.INFORMATION_MESSAGE);
                }else{
                    //instrucción para crear la tabla Empleados
                    stn_sql = "CREATE TABLE "+nombreTabla
                        +"(Codigo_Empleado TEXT(9) Primary Key,"
                        + "Nombre_Empleado TEXT(50),"
                        + "Telefono TEXT(9))";
                        
                    //ejecutamos la sentencia
                    st.execute(stn_sql);
                    JOptionPane.showMessageDialog(null, "Tabla "+nombreTabla+" creada con éxito ");
                    
                }
            }else{
                if (existeTabla(cn,nombreTabla)){
                    JOptionPane.showMessageDialog(null, "La tabla "+nombreTabla+" ya está creada", null,JOptionPane.INFORMATION_MESSAGE);
                }else{
                    if (existeTabla(cn,"Empleados")){
                        //instrucción para crear la tabla ordenes
                        stn_sql = "CREATE TABLE "+nombreTabla
                            + "(Codigo_Producto TEXT(9) NOT NULL, "
                            + "Nombre_Producto TEXT(60), "
                            + "Cod_Emple TEXT(9) NOT NULL,"
                            + "PRIMARY KEY (Codigo_Producto,Cod_Emple))";
                            
                        //ejecutamos la sentencia
                        st.execute(stn_sql);
                        JOptionPane.showMessageDialog(null, "Tabla "+nombreTabla+" creada con éxito ");
                    }else{
                        JOptionPane.showMessageDialog(null,nombreTabla+" no se puede crear si no está creada la tabla EMPLEADOS");
                    }    
                        
                }
            }
            
            cerrarConexion();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR. No se ha podido crear la tabla "+nombreTabla);
        }
        
    }
    
    //método que nos indica si una tabla está o no creada
    public Boolean existeTabla(Connection cn,String tabla){
        /*utilizamos la interface DataBaseMetaData que nos permitirá
          comprobar si las tablas ya existen o no en la base de datos
        */
        DatabaseMetaData metaDatos;
        
        try {
            
            //Obtenemos los metadatos sobre la base de datos de la conexión
            metaDatos = cn.getMetaData();
            
            //comprobamos si la tabla ya ha sido creada mediante el ResultSet
            rs = metaDatos.getTables(null, null, tabla, null);
            
            if (rs.next()){
                return true;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    //método para insetar un registro en las tablas
    public void insertar(String nombreTabla, String [] campos){
        
        String stn_inserta = null, tabla = nombreTabla.toUpperCase();
        
        try{
            
           conectar();
           
           switch (tabla){
               
               case "EMPLEADOS":
                    stn_inserta = "INSERT INTO EMPLEADOS VALUES('"
                            +campos[0]+"','"
                            +campos[1]+"','"
                            +campos[2]+"')"; 
                    
                    break;
                    
               case "ORDENES":
                   
                    stn_inserta = "INSERT INTO ORDENES VALUES('"+campos[0]+"','"
                            +campos[1]+"','"
                            +campos[2]+"')"; 
                    break;
                    
           }
           
           st.execute(stn_inserta);
           
           JOptionPane.showMessageDialog(null, "Registro insertado con éxito en la tabla "+nombreTabla);
           
           cerrarConexion();
           
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR. No se ha podido insertar el registro en la tabla "+nombreTabla+
                    "\nCódigo ya existente");
        }
                
    }
    //método con las sentencias para actualizar las tablas
    public void actualiza(String nombreTabla, String[] campos){
        String stn_actualiza = null, tabla = nombreTabla.toUpperCase();
        
        try{
            
           conectar();
           
           switch (tabla){
               
               case "EMPLEADOS":
                    stn_actualiza = "UPDATE EMPLEADOS SET "
                            + "Nombre_Empleado = '"+campos[1]+"',"
                            + "Telefono = '"+campos[2]+"'"
                            + " WHERE Codigo_Empleado = '"+campos[0]+"'";
                        
                    break;
                    
               case "ORDENES":
                    stn_actualiza = "UPDATE ORDENES SET "
                            + "Nombre_Producto = '"+campos[1]+"'"
                            + " WHERE Codigo_Producto = '"+campos[0]+"'";
                    break;
                    
           }
           
           st.executeUpdate(stn_actualiza);
           
           JOptionPane.showMessageDialog(null, "Registro modificado con éxito en la tabla "+nombreTabla+"\n");
           
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR. No se ha podido modificar el registro en la tabla "+nombreTabla);
        }
    } 
    
    
}
