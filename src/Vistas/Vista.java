package Vistas;

public class Vista {
    public InicioSesion inicioSesion;
    public RegistroJugador registroJugador;
    public Casino casino;
    public Instrucciones instrucciones;
    
    public Vista() {
        inicioSesion = new InicioSesion();
        registroJugador = new RegistroJugador();
        casino = new Casino();
        instrucciones = new Instrucciones();
    } 
}