/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
public class nodoB {
    int n;//numero de claves en el nodo n<m, m es el orden del arbol
    boolean leaf; //si el nodo es hoja
    int key[];//almacena las claves en el nodo
    nodoB child[];//arreglo con referencia a los hijos
    
    //Constructor
    public nodoB(int t){ //t es el grado del arbol
        n = 0;
        leaf = true;
        key = new int[t];//Mantiene t-1 datos, pero dejo t para almacenar todos los datos antes de romper (hacer split)
        child = new nodoB[t+1];
    }
    
    public void imprimir(){
        System.out.println("[");
        for(int i = 0; i < n; i++){
            if(i<n-1){
                System.out.println(key[i]+ " | ");
            }else{
                System.out.println(key[i]);
            }
        }
        System.out.println("]");
    }
    
    public int find(int k){
        for(int i = 0; i<n; i++){
            if(key[i] == k){
                return i;
            }
        }
        return -1;
    }
}
