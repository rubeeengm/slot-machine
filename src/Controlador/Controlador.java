package Controlador;

import Modelo.Hilo;
import Modelo.Jugador;
import Modelo.Posicion;
import Modelo.Modelo;
import Vistas.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener{
    public Vista vista;
    public Modelo modelo;
    public Jugador temporal;

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void iniciarJuego(){
        vista.inicioSesion.iniciarVista();
        this.vista.inicioSesion.buttonIngresar.addActionListener(this);
        this.vista.inicioSesion.buttonRegistrar.addActionListener(this);
        mouse();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento){
        try{
            String usuario = vista.inicioSesion.tfUsuario.getText();
            String contraseña = vista.inicioSesion.tfContraseña.getText();
            //Comprueba que el usuario y password sea correcto

            //Evento del boton ingresar
            if(vista.inicioSesion.buttonIngresar == evento.getSource()){    
                temporal = (Jugador) modelo.listaJugadores.comprobarInicioSesion(usuario,contraseña);
                
                if(temporal.getUsuario().equals("No")){
                    JOptionPane.showMessageDialog(null,"¡El usuario o contraseña son incorrectos!");
                }
            
                else{
                    vista.inicioSesion.setVisible(false);
                    vista.casino.iniciarVista();
                    vista.inicioSesion.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Bienvenido "+temporal.getNombre());
                    vista.casino.buttonJugar.addActionListener(this);
                    vista.casino.miInstrucciones.addActionListener(this);
                    vista.casino.tfmonto.setText("$"+temporal.getSaldo());
                }
            }
        
            //Evento del boton "registrar"
            if(vista.inicioSesion.buttonRegistrar == evento.getSource()){
                vista.registroJugador.iniciarVista();
                this.vista.registroJugador.buttonAceptar.addActionListener(this);
            }   
        
            //Evento del boton acepar en la ventana Registro Jugador
            if(vista.registroJugador.buttonAceptar == evento.getSource()){
                double saldo = 0;
                String user = vista.registroJugador.tfUsuario.getText();
                String password = vista.registroJugador.tfContrasena.getText();
                String nombre = vista.registroJugador.tfNombre.getText();
                String apellido = vista.registroJugador.tfApellido.getText();
                String money = vista.registroJugador.tfSaldo.getText();
                String email = vista.registroJugador.tfCorreo.getText();
            
                if(user.equals("")||password.equals("")||nombre.equals("")||apellido.equals("")||money.equals("")||email.equals(""))
                    JOptionPane.showMessageDialog(null,"No se pueden dejar campos en blanco");  
            
                else{
                    saldo = Double.parseDouble(vista.registroJugador.tfSaldo.getText());
                    
                    if(saldo<=0)
                        JOptionPane.showMessageDialog(null,"No puede utilizar cantidad negativa");
                  
                    else{
                        if(saldo<1500)
                            JOptionPane.showMessageDialog(null,"La cantidad con la mínima con la que se puede abrir una cuenta es de $1500");
                    
                        else{
                            vista.inicioSesion.setVisible(false);
                            vista.registroJugador.setVisible(false);
                            modelo.listaJugadores.agregarJugador(nombre,apellido,user,password,email,saldo);
                            temporal = (Jugador) modelo.listaJugadores.listaJugadores.lastElement();
                            vista.casino.iniciarVista();
                            JOptionPane.showMessageDialog(null, "Bienvenido "+temporal.getNombre());
                            vista.casino.buttonJugar.addActionListener(this);
                            vista.casino.miInstrucciones.addActionListener(this);
                            vista.casino.tfmonto.setText("$"+temporal.getSaldo());
                        }
                    }
                }
            }
            
            if(vista.casino.buttonJugar == evento.getSource()){
                if(temporal.getSaldo()>0){
                    int valorRan;
                    double ran;
                    Posicion llegada = new Posicion(1);
                
                    Hilo h1 = new Hilo(vista,llegada,modelo,temporal);
                    ran = Math.random()*10;
                    valorRan = (int)ran;
                    valorRan = ((valorRan<1 || valorRan>10) ? 5 : valorRan);
                    h1.setName("Hilo1");
                    h1.setPriority(valorRan);
                    h1.start();
                
                    Hilo h2 = new Hilo(vista,llegada,modelo,temporal);
                    ran = Math.random()*10;
                    valorRan = (int)ran;
                    valorRan = ((valorRan<1 || valorRan>10) ? 5 : valorRan);
                    h2.setName("Hilo2");
                    h2.setPriority(valorRan);
                    h2.start();
                
                    Hilo h3 = new Hilo(vista,llegada,modelo,temporal);
                    ran = Math.random()*10;
                    valorRan = (int)ran;
                    valorRan = ((valorRan<1 || valorRan>10) ? 5 : valorRan);
                    h3.setName("Hilo3");
                    h3.setPriority(valorRan);
                    h3.start();
                }
                
                else
                    JOptionPane.showMessageDialog(null,"No cuentas con el dinero suficiente");
            }
            
            if(vista.casino.miInstrucciones == evento.getSource()){
                vista.instrucciones.iniciarVista();
            }

        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }        
    
    public void mouse(){
        vista.inicioSesion.tfUsuario.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                vista.inicioSesion.tfUsuario.setText("");
            }
        });
        
        vista.inicioSesion.tfContraseña.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                vista.inicioSesion.tfContraseña.setText("");
            }
        });
    }
}