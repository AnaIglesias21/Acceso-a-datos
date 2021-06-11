/*
 * clase que encapsula cada uno de los datos de la tabla
 */
package datos;

/**
 *
 * @author Ana Isabel Iglesias Martínez
 */
public class Ordenes {
    
    public Ordenes(){
        codigo = null;
        nombre = null;
        cod_emple = null;
    }
    
    public Ordenes(String codigo, String nombre, String cod_emple){
        this.codigo = codigo;
        this.nombre = nombre;
        this.cod_emple = cod_emple;
        
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

    public String getCod_emple() {
        return cod_emple;
    }

    public void setCod_emple(String cod_emple) {
        this.cod_emple = cod_emple;
    }
    
    public String[] getArrayOrdenes(){
        String[] orden = new String[3];
        
        orden[0] = codigo;
        orden[1] = nombre;
        orden[2] = cod_emple;
        
        return orden;
    }
    
    public String[] getCampos(){
        String[] campos = new String[3];
        campos[0] = "Código";
        campos[1] = "Nombre";
        campos[2] = "Empleado";
        
        return campos;
    }
    
    private String codigo;
    private String nombre;
    private String cod_emple;
    
}
