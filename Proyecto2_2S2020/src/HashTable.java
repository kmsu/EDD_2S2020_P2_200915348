
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
public class HashTable {
    int tamaño = 13;
    NodoTablaHash[] tabla;
    double factorCarga = 0;
    int elementos = 0;
    
    public HashTable() {
        tabla = new NodoTablaHash[tamaño];
        for (int i = 0; i < tamaño; i++) {
            tabla[i] = null;
        }
        factorCarga = 0;
        elementos = 0;
    }
    
    public int posicion(int dato) {
        int i = 0, indice = 0;
        //calcula el modulo para obtener el residuo
        indice = dato % tamaño;
        //Prueba lineal (busca la siguiente posicion disponible si hay colision
        while (tabla[indice] != null) {
            i++;
            indice = indice + i;
            if (indice > tamaño) {
                indice = indice - tamaño;
            }
        }
        return indice;
    }
    
    public void insertar(NodoTablaHash nuevo) {
        //obtengo el indice 
        int indice = posicion(ObtenerASCII(nuevo.nombre));
        tabla[indice] = nuevo;
        elementos++;
        //factorCarga = (double) elementos / tamaño;
        factorCarga = (double) elementos / tamaño;
        if (factorCarga > 0.75) {
            rehashing();
            factorCarga = (double) elementos / tamaño;
        }
    }
    
    //Toma la cadena, convierte en ascii cada caracter y los suma
    public int ObtenerASCII(String cadena) {
        int suma = 0;
        //Recorre la cadena, toma cada caracter, toma su ascii y lo suma
        for (char caracter : cadena.toCharArray()) {
            suma += (int) caracter;
        }
        System.out.println("cadena: " + cadena);
        System.out.println("suma ascii " + suma);
        return suma;
    }
    
    private void rehashing() {
        
        //int nuevoTamaño = tamaño;
        int nuevoTamaño = (int) (elementos/0.3);
        nuevoTamaño--;
        double factor = 0;
        do {
            nuevoTamaño = sigPrimo(nuevoTamaño);
            //factor = (double) elementos / nuevoTamaño;
            factor = (double)elementos / nuevoTamaño;
        } while (factor >= 0.3);

        NodoTablaHash[] temporal = new NodoTablaHash[nuevoTamaño];
        for (int i = 0; i < nuevoTamaño; i++) {
            temporal[i] = null;
        }

        System.arraycopy(tabla, 0, temporal, 0, tamaño);
        tabla = temporal;
        tamaño = nuevoTamaño;
    }

    private int sigPrimo(int tam) {
        int a = 0;
        tam = tam + 1;
        for (int i = 1; i <= tam; i++) {
            if ((tam) % i == 0) {
                a++;
            }
        }
        if(a == 2) {
            return tam;
        }else {
            return sigPrimo(tam);
        }
    }

    public void print() {
        for (int i = 0; i < tamaño; i++) {
            if (tabla[i] != null) {
                //%d es para digito y %s es para cadena (string)
                System.out.printf("Indice: %d, Id: %d, Categoria: %s, Nombre: %s, Latitud: %s, Longitud: %s\n", i, tabla[i].id, tabla[i].categoria, tabla[i].nombre, tabla[i].latitud, tabla[i].longitud);
            } else {
                System.out.printf("Indice: %d\n", i);
            }
        }
    }

    public double getFactorCarga() {
        return factorCarga;
    }
    
    //para reportar
    public String factorCarga(){
        DecimalFormat formato = new DecimalFormat("#0.000");
        String presentar = formato.format(factorCarga);
        return presentar;
    }
    
    public NodoTablaHash buscar(String lugar){
        int i = 0;
        boolean encontrado = false;
        NodoTablaHash retornar = null;
        while(i < tamaño && encontrado == false){
            if(tabla[i] != null && tabla[i].nombre.equals(lugar)){
                encontrado = true;
                retornar = tabla[i];
            }
            i++;
        }
        return retornar;
    }
    
    public void reporte(){
        BufferedWriter linea = null;
        try{
            File archivo = new File("hash.txt");
            linea = new BufferedWriter(new FileWriter(archivo));
            linea.write("digraph G {");
            linea.write("\nnode[shape = record fontname=\"Arial\" fontsize=\"10\" ,style = filled];");
            linea.write("\ngraph [nodesep = 0.4]");
            linea.write("\nlabel = < <font color='deepskyblue'> <font point-size='20'>Tabla Hash con direccionamiento abierto: LUGARES</font></font>>;");
            linea.write("labelloc=t;");
            linea.write("\nrankdir=LR;");
            
            //Primer tabla
            linea.write("\nnode [shape=record,width=.1,height=.1];");
            linea.write("\nN0 [label = \" ");
            //lleno los nodos de la izquierda
            int size = tabla.length;
            
            int i = 0;
            String imprimir = "";
            while(i < size-1){
                imprimir = "\n<f" + i + "> \\n \\n Indice: " + i + " \\n \\n \\n|";
                linea.write(imprimir);
                i++;
            }
            imprimir = "\n<f" + i + "> \\n \\n Indice: " + i + "\\n \\n \\n \", height=2];";
            linea.write(imprimir);
            linea.write("\nnode [shape=component]");
            
            linea.write("");
            
            //Segunda tabla
            linea.write("\nnode [shape=record,width=.1,height=.1];");
            linea.write("\nN1 [label = \" ");
            //lleno los nodos de la derecha
            i = 0;
            while(i < size-1){
                //ver si esta vacio el indice para imprimir
                if(tabla[i] != null){
                    imprimir = "\n<f" + i + "> Id: " + tabla[i].id +" \\n "
                        + "Categoria: " + tabla[i].categoria + " \\n " 
                        + "Nombre: " + tabla[i].nombre + " \\n "
                        + "Latitud: " + tabla[i].latitud + " \\n "
                        + "Longitud: " + tabla[i].longitud + "|";
                }else{
                    imprimir = "\n<f" + i + "> \\n \\n Null \\n \\n \\n|";
                }
                //imprimo la linea
                linea.write(imprimir);
                i++;
            }
            //ver si esta vacio el indice para imprimir
            if(tabla[i] != null){
                imprimir = "\n<f" + i + "> Id: " + tabla[i].id + " \\n "
                    + "Categoria: " + tabla[i].categoria + " \\n " 
                    + "Nombre: " + tabla[i].nombre + " \\n "
                    + "Latitud: " + tabla[i].latitud + " \\n "
                    + "Longitud: " + tabla[i].longitud + " \", height=2];";
            }else{
                imprimir = "\n<f" + i + "> \\n \\n Null \\n \\n \\n \", height=2];";
            }
            linea.write(imprimir);
            linea.write("\nnode [shape=component]");
            
            //enlazo las tablas
            i = 0;
            while(i < size){
                imprimir = "\nN0:f" + i + " -> N1:f" + i;
                linea.write(imprimir);
                i++;
            }
            //metemos el factor de carga
            String factor = "\nfactor  [label = \"factor: " + factorCarga() + "\"];";
            linea.write(factor);
            //cierro el codigo del archivo
            linea.write("\n}");
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        } finally {
            if (linea != null) {
                try {
                    linea.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //Ejecutar el archivo dot
        try {
            String fileInputPath = ".//hash.txt";;
            String fileOutputPath = ".//hash.png";
            ProcessBuilder proceso;
            proceso = new ProcessBuilder("dot", "-Tpng", "-o", fileOutputPath, fileInputPath);
            proceso.redirectErrorStream(true);
            proceso.start();
            String salida = "hash.png";
            //Para que ejecuteautomaticamente, puede ir en otro lado
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + salida);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
