package Modelo;

import java.util.Random;

public class Modelo{
    public AlmacenamientoJugadores listaJugadores;
    
    public Modelo(){
        listaJugadores = new AlmacenamientoJugadores();
        
        listaJugadores.agregarJugador("Ruben", "Garcia Malaga", "55", "55", "garciamalagaruben@gmail.com", 5000);
    }
}