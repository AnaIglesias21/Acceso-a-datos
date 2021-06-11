
package Aplicacion;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;


/**
 *
 * @author AnaIglesias
 */
public class AplicacionTarea3 {

    
    public static void main(String[] args) {
       miIcono = Toolkit.getDefaultToolkit().getImage("Tienda.png");
        
        MarcoPrincipal miMarcoPrincipal = new MarcoPrincipal();
        
        miMarcoPrincipal.setVisible(true);
        
        miMarcoPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public static Image miIcono;
    
}
