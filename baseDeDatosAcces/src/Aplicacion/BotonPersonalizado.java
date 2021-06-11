/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import java.awt.*;
import javax.swing.JButton;

/**
 *
 * @author Estimado Usuario
 */
public class BotonPersonalizado extends JButton{
    
    public BotonPersonalizado(String Titulo){
        
        super(Titulo);
        setContentAreaFilled(false);
        setForeground(java.awt.Color.BLACK);
        setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,16));
        
    }
    
    public void paintComponent(Graphics g){
        
        final Graphics2D g2 = (Graphics2D) g.create();
               g2.setPaint(new GradientPaint(
                       new Point(0, 0), 
                       java.awt.Color.CYAN.darker(),//java.awt.Color.PINK.darker(), 
                       new Point(0, getHeight()), 
                       java.awt.Color.DARK_GRAY));
               g2.fillRect(0, 0, getWidth(), getHeight());
               g2.dispose();
           
               super.paintComponent(g);
        
    }
   
}
