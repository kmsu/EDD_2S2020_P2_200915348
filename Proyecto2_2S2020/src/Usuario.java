/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
public class Usuario {
    int id;
    //int id;
    String nombre;
    String usuario;
    String correo;
    String contraseña;
    //int telefono;
    String telefono;
    double latitud;
    double longitud;
    boolean disponibilidad;

    //Usuario normal
    public Usuario(int id_usuario, String nombre, String usuario, String correo, String contraseña, String telefono) {
        this.id = id_usuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.latitud = 0;
        this.longitud = 0;
        this.disponibilidad = true;
    }

    //usuario conductor
    public Usuario(int id_conductor, String nombre, String usuario, String correo, String contraseña, String telefono, double lat, double longi) {
        this.id = id_conductor;
        this.nombre = nombre;
        this.usuario = usuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.latitud = lat;
        this.longitud = longi;
        this.disponibilidad = true;
    }
    
}
