package Modelo;

import Vistas.Vista;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Hilo extends Thread{
    Random rnd = new Random();
    public Vista vista;
    public Posicion llegada;
    public Modelo modelo;
    public Jugador jugador;
    
    public Hilo(Vista vista, Posicion llegada, Modelo modelo, Jugador jugador){
        this.vista = vista;
        this.llegada = llegada;
        this.modelo = modelo;
        this.jugador = jugador;
    }
    
    @Override
    public void run(){
        double r;
        long vR;
        String nombreHilo;
        int lugarDeLlegada;
        int x;
        
        Boolean salir;
        
        for(int i = 0; i <= 100; i++){
            r  = Math.random()*10;
            vR = (int)r;
            
            try{
                Thread.sleep(vR);
            }catch(Exception e){
                
            }
            
            salir = false;
            
            do{
                x = (int) (rnd.nextDouble()*5);
            
                if(x != 0){
                    salir = true;
                }
            }while(!salir);
            
            nombreHilo = this.getName();;
            
            switch(nombreHilo){
                case "Hilo1":
                    vista.casino.lCasilla1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+x+".jpg")));
                break;
                    
                case "Hilo2":
                    vista.casino.lCasilla2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+x+".jpg")));
                break;
                    
                case "Hilo3":
                    vista.casino.lCasilla3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+x+".jpg")));
                break;
            }
        }
        
        synchronized (llegada){
            nombreHilo = this.getName();
            lugarDeLlegada = llegada.getLlegada();
            
            llegada.setLlegada(lugarDeLlegada+1);
        }
        
        if(lugarDeLlegada == 3){
            if((vista.casino.lCasilla1.getIcon().toString().equals(vista.casino.lCasilla2.getIcon().toString())) && 
                (vista.casino.lCasilla1.getIcon().toString().equals(vista.casino.lCasilla3.getIcon().toString()))){
                JOptionPane.showMessageDialog(null,"GANASTE!!!!!!!!!");
                    
                modelo.listaJugadores.movimiento('g',100,jugador.getUsuario());
                System.out.println(jugador.movimientos.lastElement());
                vista.casino.tfmonto.setText("$"+jugador.getSaldo());
            }
            
            else{
                modelo.listaJugadores.movimiento('p',50,jugador.getUsuario());
                System.out.println(jugador.movimientos.lastElement());
                vista.casino.tfmonto.setText("$"+jugador.getSaldo());
                
                if(jugador.getSaldo()<0){
                    JOptionPane.showMessageDialog(null, "Cuidado, tienes saldo negativo :v");
                }
            }
        }
    }
}