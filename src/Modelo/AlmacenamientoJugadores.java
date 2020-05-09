package Modelo;

import java.util.Date;
import javax.swing.DefaultListModel;

public class AlmacenamientoJugadores {
    public DefaultListModel<Jugador> listaJugadores;

    public AlmacenamientoJugadores() {
        this.listaJugadores = new DefaultListModel();
    }
    
    public void agregarJugador(String nombre, String apellido, String usuario, String contraseña, String email, double saldo){
        listaJugadores.addElement(new Jugador(nombre,apellido,usuario,contraseña,email,saldo));
    }
    
    public void movimiento(char tipoMov, double importe, String usuario){
        double saldo;
        
        for(int i = 0; i<listaJugadores.size(); i++){
            if(usuario.equals(listaJugadores.elementAt(i).getUsuario())){
                if(tipoMov == 'g'){
                    saldo = listaJugadores.elementAt(i).getSaldo();
                    
                    listaJugadores.elementAt(i).setSaldo(saldo+importe);
                    listaJugadores.elementAt(i).movimientos.addElement("Ha ganado: $"+importe+" | Fecha: "+new Date());
                }
                
                else{
                    saldo = listaJugadores.elementAt(i).getSaldo();
                    
                    listaJugadores.elementAt(i).setSaldo(saldo-importe);
                    listaJugadores.elementAt(i).movimientos.addElement("Ha perdido: $"+importe+" | Fecha: "+new Date());
                }
            }
        }
    }
    
    public Jugador comprobarInicioSesion(String usuario, String password){
        Jugador j = new Jugador("No");
        
        for(int i = 0; i < listaJugadores.getSize(); i++){
            Jugador original = (Jugador) listaJugadores.elementAt(i);
            
            if(usuario.equals(original.getUsuario())&&password.equals(original.getContraseña())){
                j = (Jugador) original;
                break;
            }
        }
        
        return j;
    }
}