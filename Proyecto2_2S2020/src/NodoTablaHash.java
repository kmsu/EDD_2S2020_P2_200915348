/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
public class NodoTablaHash {
    int id;
    String categoria;
    String nombre;
    double latitud;
    double longitud;

    public NodoTablaHash(int id, String categoria, String nombre, double latitud, double longitud) {
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

}
