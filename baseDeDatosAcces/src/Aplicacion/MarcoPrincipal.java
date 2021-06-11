package Aplicacion;

import static Aplicacion.AplicacionTarea3.miIcono;
import javax.swing.JFrame;

/**
 *
 * @author AnaIglesias
 */
public class MarcoPrincipal extends JFrame{
    //constructor
    public MarcoPrincipal(){
        setTitle("The Casual Clothes");
        setIconImage(miIcono);
        setSize(600,350);
        setLocationRelativeTo(null);
        setResizable(false);
        
        LaminaPrincipal miLaminaPrincipal = new LaminaPrincipal();
        
        this.add(miLaminaPrincipal);
        
    }
}