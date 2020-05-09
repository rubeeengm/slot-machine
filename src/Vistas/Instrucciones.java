package Vistas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Instrucciones extends JFrame {
    public JLabel a;
    
    public void iniciarVista(){
        marco();
        setTitle("Intrucciones");
        setSize(796,530);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(100,100);
    }
     
    public void marco(){
        JPanel p = new JPanel();
        
        a = new JLabel();
        
        a.setIcon(new ImageIcon(getClass().getResource("/Imagenes/instrucciones.png"))); 
        a.setBounds(0,0,96,500);
        p.add(a);
        add(p);
    }
}