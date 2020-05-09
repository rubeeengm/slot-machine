package Modelo;

import javax.swing.DefaultListModel;

public class Jugador {
    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;
    private String email;
    private double saldo;
    public DefaultListModel<String> movimientos;

    public Jugador() {
    }
    
    public Jugador(String usuario){
        this.usuario = usuario;
    }

    public Jugador(String nombre, String apellido, String usuario, String contraseña, String email, double saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.email = email;
        this.saldo = saldo;
        this.movimientos = new DefaultListModel();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", apellido=" + apellido + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + ", email=" + email + ", saldo=" + saldo + ", movimientos=" + movimientos + '}';
    }
}