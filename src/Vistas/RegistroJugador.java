package Vistas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistroJugador extends JFrame {
    public JLabel lNombre;
    public JLabel lApellido;
    public JLabel lSaldo;
    public JLabel lUsuario;
    public JLabel lContrasena;
    public JLabel lCorreo;
    public JLabel imagen;
    public JTextField tfCorreo;
    public JTextField tfNombre;
    public JTextField tfApellido;
    public JTextField tfSaldo;
    public JTextField tfUsuario;
    public JTextField tfContrasena;
    public JButton buttonAceptar;
    public JButton buttonCancelar;
    
    public void iniciarVista(){
        marco();
        this.setTitle("Registro Jugador");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(550,650);
        this.setVisible(true);
    }
    
    public void marco(){ 
        JPanel contenedor;
        
        Font a = new Font("Britannic", Font.BOLD, 16);
        
        imagen = new JLabel();
        
        imagen.setIcon(new ImageIcon(getClass().getResource("/Imagenes/registro.png"))); 
        
        contenedor = new JPanel();
        contenedor.setLayout(null);

        lNombre = new JLabel("Nombre");
        lApellido = new JLabel("Apellidos");
        lCorreo = new JLabel("Correo");
        
        lSaldo = new JLabel("Saldo");
        lUsuario = new JLabel("Usuario");
        lContrasena = new JLabel("Contraseña");
        
        tfNombre = new JTextField();
        tfApellido = new JTextField();
        tfCorreo = new JTextField();
      
        tfSaldo = new JTextField();
        tfUsuario = new JTextField();
        tfContrasena = new JTextField();
        
        buttonAceptar = new JButton("Aceptar");
        buttonCancelar = new JButton("Cancelar");
        
        lNombre.setFont(a);
        lNombre.setForeground(Color.WHITE); 
        lApellido.setFont(a);
        lApellido.setForeground(Color.WHITE);
        lCorreo.setFont(a);
        lCorreo.setForeground(Color.WHITE);
        lSaldo.setFont(a);
        lSaldo.setForeground(Color.WHITE);
        lUsuario.setFont(a);
        lUsuario.setForeground(Color.WHITE);
        lContrasena.setFont(a);
        lContrasena.setForeground(Color.WHITE);
        
        lNombre.setBounds(63,220,100,50);
        lApellido.setBounds(63,260,100,50);
        lCorreo.setBounds(63, 290, 100, 50);
       
        lSaldo.setBounds(63,340,100,50);
        lUsuario.setBounds(63,380,100,50);
        lContrasena.setBounds(63,420,100,50);
        
        tfNombre.setBounds(187,230,300,30);
        tfApellido.setBounds(187,270,300,30);
        tfCorreo.setBounds(187,300, 300,30);
      
        tfSaldo.setBounds(187,350,300,30);
        tfUsuario.setBounds(187,390,300,30);
        tfContrasena.setBounds(187,430,300,30);
        
        buttonAceptar.setBounds(83,500,100,30);
        buttonCancelar.setBounds(337,500,100,30);
        imagen.setBounds(0,0,550,650);
        
        contenedor.add(lNombre);
        contenedor.add(lApellido);
        contenedor.add(lCorreo);
        
        contenedor.add(lSaldo);
        contenedor.add(lUsuario);
        contenedor.add(lContrasena);
        contenedor.add(tfNombre);
        contenedor.add(tfApellido);
        contenedor.add(tfCorreo); 
        contenedor.add(tfSaldo);
        contenedor.add(tfUsuario);        
        contenedor.add(tfContrasena);
        contenedor.add(buttonAceptar);    
        contenedor.add(imagen);
        contenedor.add(buttonCancelar);
        
        add(contenedor);
    }
}