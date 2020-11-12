/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
public class nodoArbolB {
    int n;//numero de claves en el nodo n<m, m es el orden del arbol
    boolean leaf; //si el nodo es hoja
    Usuario key[];//almacena las claves en el nodo
    nodoArbolB child[];//arreglo con referencia a los hijos
    
    //Constructor
    public nodoArbolB(int t){ //t es el grado del arbol
        n = 0;
        leaf = true;
        key = new Usuario[t];//Mantiene t-1 datos, pero dejo t para almacenar todos los datos antes de romper (hacer split)
        child = new nodoArbolB[t+1];
    }
    
    public void imprimir(){
        System.out.println("[");
        for(int i = 0; i < n; i++){
            if(i<n-1){
                System.out.println(key[i].id + " | ");
            }else{
                System.out.println(key[i].id);
            }
        }
        System.out.println("]");
    }
    
    public Usuario nodoSesion(String nick, String pass){
        Usuario encontrado = null;
        int i = 0;
        while(i < n && encontrado == null){
            if(key[i].usuario.equals(nick) && key[i].contraseña.equals(pass)){
                encontrado = key[i];
            }
            i++;
        }
        return encontrado;
    }
    
    //encontrar la posicion del arreglo en que esta la clave
    public int find(int k){
        for(int i = 0; i<n; i++){
            if(key[i].id == k){
                return i;
            }
        }
        return -1;
    }
}
