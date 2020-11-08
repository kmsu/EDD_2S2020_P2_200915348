/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
public class EjemploArbolBKnuth {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //grado del arbol b es t=3
        //cada nodo soporta 2t hijos y 2t-1 claves
        int t = 5;
        //int p = 5/2; retorna 2 en el vector sería el tercer elemento arr[2]
        //System.out.println(p);
        //se crea el arbol B segun t
        ArbolB arbolB = new ArbolB(t);
        //para t=3
        //arbolPequeño(arbolB);
        //arbolGrande(arbolB);
        //para t=5
        /*arbolB.insertar2(100);
        arbolB.insertar2(200);
        arbolB.insertar2(300);
        arbolB.insertar2(400);
        arbolB.insertar2(500);
        arbolB.insertar2(600);
        arbolB.insertar2(700);
        arbolB.insertar2(800);
        arbolB.insertar2(900);
        arbolB.insertar2(1000);
        arbolB.insertar2(1100);
        arbolB.insertar2(1200);
        arbolB.insertar2(1300);
        arbolB.insertar2(1400);
        arbolB.insertar2(1500);
        arbolB.insertar2(1600);
        arbolB.insertar2(1700);*/
        
        
        for(int i = 100; i <= 5300; i=i+100){
            arbolB.insertar2(i);
        }
        //arbolB.insertar2(2250);
        
        
        System.out.println("");
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");
        
        //Buscar
        System.out.println("\nBuscando el nodo con el valor 15 en el arbol B");
        //arbolB.buscarNodoPorClave(15);
        
        //Eliminar
        System.out.println("\nEliminando el nodo con el valor 100 en el arbol B");
        arbolB.eliminar(200);
        //arbolB.eliminar(1800);
        
        //System.out.println("\nEliminando el nodo con el valor 10 en el arbol B");
        //arbolB.eliminar(50);
        
        //System.out.println("\nEliminando el nodo con el valor 10 en el arbol B");
        //arbolB.eliminar(10);
        
        //System.out.println("\nEliminando el nodo con el valor 60 en el arbol B");
        //arbolB.eliminar(60);
        
        //System.out.println("\nEliminando el nodo con el valor 40 en el arbol B");
        //arbolB.eliminar(40);
        
        //System.out.println("\nEliminando el nodo con el valor 35 en el arbol B");
        //arbolB.eliminar(35);
        
        //System.out.println("\nEliminando el nodo con el valor 30 en el arbol B");
        //arbolB.eliminar(37);
        
        System.out.println("");
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");
        
        arbolB.reporte();
        //Para abrir la imagen automaticamente. Debe ir despues de llamar al meteodo
        try{
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "arbolb.png");
        }catch(Exception ex){
            
        }
        
        
    }
    
    public static void arbolPequeño(ArbolB arbolB){
        System.out.println("arbol pequeño");
        //int[] valoresUno = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,35,50};
        int[] valoresUno = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        System.out.println("-- INICIO --");
        System.out.println("INSERTANDO VALORES AL ARBOL B");
        for(int i=0; i<valoresUno.length; i++){
            System.out.println("Insertando... valor " + valoresUno[i]);
            arbolB.insertar2(valoresUno[i]);
        }
        
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");
        
    }
    
    public static void arbolGrande(ArbolB arbolB){
        System.out.println("arbol grande");
        //valores a ingresar primera ronda 
        //int[] valoresUno = {20, 10, 50, 30, 40};
        int[] valoresUno = {150, 140, 130, 120, 110, 100};
        System.out.println("-- INICIO --");
        System.out.println("INSERTANDO VALORES AL ARBOL B");
        for(int i=0; i<valoresUno.length; i++){
            System.out.println("Insertando... valor " + valoresUno[i]);
            arbolB.insertar2(valoresUno[i]);
        }
        
        //Mostrando arbol B por pantalla en preorder
        //System.out.println("ESTADO ARBOL B");
        //arbolB.showBTree();
        //System.out.println("");
        
        //valores a ingresar segunda ronda
        System.out.println("Insertando... valor 90");
        arbolB.insertar2(90);
        
        System.out.println("Insertando... valor 90");
        arbolB.insertar2(80);
        
        System.out.println("Insertando... valor 70");
        arbolB.insertar2(70);
        
        System.out.println("Insertando... valor 60");
        arbolB.insertar2(60);
        
        System.out.println("Insertando... valor 50");
        arbolB.insertar2(50);
        
        System.out.println("Insertando... valor 40");
        arbolB.insertar2(40);
        
        System.out.println("Insertando... valor 30");
        arbolB.insertar2(30);
        
        System.out.println("Insertando... valor 20");
        arbolB.insertar2(20);
        
        System.out.println("Insertando... valor 10");
        arbolB.insertar2(10);
        
        //for(int i=81; i<89; i++){
            //System.out.println("Insertando... valor " + i);
            //arbolB.insertar2(i);
        //}
        
        //for(int i=71; i<79; i++){
           //System.out.println("Insertando... valor " + i);
          //  arbolB.insertar2(i);
        //}
        
        //System.out.println("Insertando... valor 15");
        //arbolB.insertar2(15);
        
        //mostrando arbol B por pantalla en preorder
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");
        
        System.out.println("Insertando... valor 80 repetido");
        arbolB.insertar2(80);
        
        //System.out.println("Insertando... valor 35 repetido");
        //arbolB.insertar2(35);
        
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");
    }
}
