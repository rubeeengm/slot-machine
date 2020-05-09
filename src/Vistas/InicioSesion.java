package Vistas;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InicioSesion extends JFrame {    
    public JLabel imagen;
    public JLabel lUsuario;
    public JLabel lContraseña;
    public JLabel lRegistrar;
    public JTextField tfUsuario;
    public JTextField tfContraseña;
    public JButton buttonIngresar;
    public JButton buttonRegistrar;

    public void iniciarVista(){
        marco();
        this.setTitle("Inicio de Sesion");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(672,504);
        this.setLocation(100,100);
    }
    
    public void marco(){
        JPanel contenedor = new JPanel();
        
        contenedor.setLayout(null);
        
        Font a = new Font("arial", Font.BOLD, 16);
        
        imagen = new JLabel();
        
        imagen.setIcon(new ImageIcon(getClass().getResource("/Imagenes/sesion.png"))); 
        lUsuario = new JLabel("Usuario");
        lContraseña = new JLabel("Contraseña");
         
        //Cajas de texto 
        tfUsuario = new JTextField();
        tfContraseña = new JTextField();
         
        //botones
        buttonIngresar = new JButton("Ingresar");
        buttonRegistrar = new JButton("¿Aun no se ha registrado?");
        
        //letra
        lUsuario.setFont(a);
        lContraseña.setFont(a);
         
        //acomodo
        // //(posicion x,posicion y,ancho,altura)
        imagen.setBounds(0,0,672,504);
        lUsuario.setBounds(400,250,100,30);
        tfUsuario.setBounds(500,250,150,30);
        lContraseña.setBounds(400,300,100,30);
        tfContraseña.setBounds(500,300,150,30);
        buttonIngresar.setBounds(500,350,100,30);
        //lRegistrar.setBounds(100,360,100,30);
        buttonRegistrar.setBounds(450,410,200,30);
        
        tfUsuario.setHorizontalAlignment(JTextField.CENTER);
        tfContraseña.setHorizontalAlignment(JTextField.CENTER);
         
        contenedor.add(lUsuario);
        contenedor.add(tfUsuario);
        contenedor.add(lContraseña);
        contenedor.add(tfContraseña);
        contenedor.add(buttonIngresar);
        contenedor.add(buttonRegistrar);
        contenedor.add(imagen);
        
        add(contenedor);
    }
}