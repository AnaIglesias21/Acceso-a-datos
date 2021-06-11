/*
 * Clase que encapsula cada uno de los datos de la tabla
 */
package datos;

/**
 *
 * @author Ana Isabel Iglesias Martínez
 */
public class Empleados {
    
    public Empleados(){
        codigo = null;
        nombre = null;
        telefono = null;
    }

    public Empleados(String codigo, String nombre, String telefono){
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String[] getArrayEmpleado(){
        String[] emp = new String[3];
        emp[0] = codigo;
        emp[1] = nombre;
        emp[2] = telefono;
        
        return emp;
    }
    
    public String[] getCampos(){
        String[] campos = new String[3];
        campos[0] = "Código";
        campos[1] = "Nombre";
        campos[2] = "Teléfono";
        
        return campos;
    }
    
    //Campos de clase
    private String codigo;
    private String nombre;
    private String telefono;
}
