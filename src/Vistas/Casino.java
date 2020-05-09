package Vistas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
 
public class Casino extends JFrame{
    public JLabel lCasilla1;
    public JLabel lCasilla2; 
    public JLabel lCasilla3; 
    public JLabel lFondo; 
    public JLabel lSaldo;
    public JTextField tfmonto;
    public JButton buttonJugar;
    public JMenuBar mb;
    public JMenu menu1;
    public JMenuItem miInstrucciones;
    
    public void iniciarVista(){
        marco();
        this.setTitle("Casino");
        this.setSize(953,660);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);            
        this.setVisible(true);
        this.setLocation(50,10);
        this.setResizable(false);
    }
    
    public void marco(){
        Font a = new Font("arial", Font.BOLD, 20);
        
        mb = new JMenuBar();
        setJMenuBar(mb);
        menu1 = new JMenu("Opciones");
        mb.add(menu1);
        miInstrucciones = new JMenuItem("Acerca De");
        menu1.add(miInstrucciones);

        lCasilla1 = new JLabel();
        lCasilla2 = new JLabel();
        lCasilla3 = new JLabel(); 
        lFondo = new JLabel();
        lSaldo = new JLabel("Saldo");
        
        buttonJugar = new JButton("Jugar");
        
        tfmonto = new JTextField();
        
        lCasilla1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Logo.gif"))); 
        lCasilla2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Logo.gif")));
        lCasilla3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Logo.gif")));
        lFondo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/casino.jpg")));
        
        lSaldo.setFont(a);
        lSaldo.setForeground(Color.black);
        tfmonto.setEditable(false);
        tfmonto.setHorizontalAlignment(JTextField.CENTER);
        tfmonto.setBackground(Color.BLACK);
        tfmonto.setForeground(Color.YELLOW);
        
        lCasilla1.setBounds(287,247,91,152);
        lCasilla2.setBounds(417,247,91,152);
        lCasilla3.setBounds(547,247,91,152);
        lFondo.setBounds(1,1,950,630);
        lSaldo.setBounds(820,515,100,50);
        tfmonto.setBounds(800,550,100,30);
        buttonJugar.setBounds(800,280,100,50);
        
        add(lSaldo);
        add(tfmonto);
        add(buttonJugar);
        add(lCasilla1);
        add(lCasilla2);
        add(lCasilla3);
        add(lFondo);
    }
}