/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
public class EjemploTablaHash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Tabla hashTable = new Tabla();
        hashTable.insertar(ObtenerASCII("hola"), "Miraflores", "primero");
        hashTable.insertar(ObtenerASCII("valor"), "Miraflores", "segundo");
        hashTable.insertar(ObtenerASCII("valor"), "Miraflores", "tercero");
        hashTable.insertar(ObtenerASCII("nuevo"), "Miraflores", "cuarto");
        hashTable.print();
        System.out.println("Factor de carga " + hashTable.getFactorCarga());
    }
    
    public static int ObtenerASCII(String cadena) {
        int suma = 0;
        for (char caracter : cadena.toCharArray()) {
            suma += (int) caracter;
        }
        return suma;
    }
    
}
