
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
public class ArbolB {
    nodoB root;
    int t;//Grado
    int caso;
    int retornar = 0;//se usa en el metodo noHoja
    boolean rootInsert;
    boolean tipoActual;
    
    public ArbolB(int t){
        this.t = t;
        this.root = new nodoB(t);//contiene arreglo de claves y arreglo de hijos
    }
    
    public void insertar2(int key){
        nodoB r = root;//contiene arreglo de claves y arreglo de hijos (conservo la raiz)
        //si el nodo esta lleno lo debe separar
        if(r.n == (t - 1)){//No debería estar aqui de entrada pues cuando la raiz esta llena
                            //sin importar a que hijo inserte aunque tenga espacio va a hacer el split
            rootInsert = true;
            nonFullInsert2(r, key);//inserto el ultimo dato para obtener los 3 arreglos que necesito
            if(rootInsert){//en lugar de rootInsert podría ver si r.n es 3
                nodoB s = new nodoB(t);//creo el nuevo nodo
                s.leaf = false;//este nodo no es hoja
                s.n = 0;//lo inicializo con 0 elementos en el arreglo
                root = s;//vuelvo el nuevo nodo como raiz
                s.child[0] = r;//al nodo hijo del nuevo nodo en la posicion 0 paso el nodo lleno que tendré que partir
                split2(s, 0, r);
            }
        }else{
            nonFullInsert2(r, key);
        }
    }
    
    private void nonFullInsert2(nodoB x, int key){//x es la raiz(actual)
        //si es hoja
        if(x.leaf){
            int i = x.n; //cantidad de valores del nodo (con posicion)
            //busca la posicion i donde asignar el valor
            while(i >= 1 && key < x.key[i-1]){//empieza a comparar si es mayor desde la ultima posicion hacia atras
                x.key[i] = x.key[i-1];//Desplaza los valores mayores a key
                i--;
            }
            //Verifico que no exista la llave para insertarla
            if(x.key[i]==key){
                System.out.println("ya existe");
                rootInsert = false;
            }else{
                x.key[i] = key; //asigna el valor al arreglo key en el nodo
                x.n++; //aumenta la cantidad de elementos del arreglo en el nodo
            }
        }else{
            int j = 0;
            //Busca la posicion del hijo (para ver si me voy al hijo de la derecha de key[j]
            while (j < x.n && key > x.key[j]){
                j++;
            }
            
            if(key == x.key[j]){//Verifica que no exista la llave
                System.out.println("Clave ya existe");
                rootInsert = false;
            }
            else if(x.child[j].n == (t-1)){//si el nodo hijo esta lleno lo separa
                nonFullInsert2(x.child[j], key);
                if(x.child[j].n == t){//al salir de la recursion verifica si debe dividirlo
                    split2(x, j, x.child[j]);
                }
            }else{
                nonFullInsert2(x.child[j], key);
                rootInsert = false;
            }
        }
    }
    
    private void split2(nodoB x, int i, nodoB y){//nuevo nodo, posicion del nuevo hijo, raiz actual AGREGAR KEY
        //ESTE SPLIT SOLO FUNCIONA CON NUMEROS GRADOS IMPARES
        //Nodo temporal que sera el de la derecha al partir el arreglo inicial
        int tam = t/2;
        nodoB z = new nodoB(t);
        z.leaf = y.leaf;
        z.n = tam;//tamaño que debera tener con los elementos que quedan a la derecha

        //copia las ultimas claves del nodo y al inicio del nodo z
        for(int j = 0; j < tam; j++){
            z.key[j] = y.key[j+tam+1];
        }
        
        //si no es hoja hay que reasignar los nodos hijos de la nueva z
        if(!y.leaf){     
            int k = 0;
            for(int m = tam+1; m <= t; m++){//pasa los hijos de la derecha
                z.child[k] = y.child[m];
                k++;
            }
        }
        
        //nuevo tamaño de y(actual). Para acceder solo a los datos desde y[0] hasta (t/2)-1
        y.n = tam; //PONER A TODOS LOS N-1 DATOS EN 0 COMO LOGICA PERO NO ES NECESARIO
        
        //Mueve los hijos de x (nueva raiz) para darle espacio a z si es necesario
        for(int j=x.n; j > i; j--){//entra cuando separo hijos por la izquierda
            //System.out.println("mueve los hijos");
            x.child[j+1] = x.child[j];
        }
        
        //Reasigna el hijo (i+1) de x
        if((i+1) <= t){//El (i+1) <= t es lo mismo que (i+1)<(t+1)
            x.child[i+1] = z;//z se vuelve el hijo derecho
        }
        
        //Mueve las claves de x cuando muevo hijos y claves por la izquierda
        for(int j = x.n; j>i; j--){//entra cuando separo hijos por la izquierda
            x.key[j] = x.key[j-1];
        }
        
        //Agrega la clave situada en la mediana
        x.key[i] = y.key[tam];//tam = t/2; t=5, 5/2= 2 
        x.n++;
        //El arreglo mantiene los t daton pero por el valor de n solo tendra acceso
        //a lo que debe quedar al dividir (t/2)
    }
    
    //Imprimir
    public void showBTree(){
        print(root);
    }
    
    //print en preorder
    private void print(nodoB n){
        n.imprimir();
        //si no es hoja
        if(!n.leaf){
            //recorre los nodos para saber si tiene hijos
            for(int j = 0; j <= n.n; j++){
                if(n.child[j] != null){
                    System.out.println();
                    print(n.child[j]);
                }
            }
        }
    }
    
    //Busca el valor ingresado y muestra el contenido del nodo que contiene el valor
    public void buscarNodoPorClave(int num){
        //nodoB temp = search(root, num);
        int valor = search(root, num);
        //if(temp == null){
        if(valor == -1){
            System.out.println("No se ha encontrado un nodo con el valor ingresado");
        }else{
            System.out.println("Se encontro el valor " + valor);
        }
    }
    
    //Buscar
    //private nodoB search(nodoB actual, int key){
    private int search(nodoB actual, int key){
        int i = 0;//se empieza a buscar siempre en la primera posicion
        
        //Incrementa el indice mientras el valor de la clave del nodo sea menor
        while(i < actual.n && key > actual.key[i]){
            i++;
        }
        
        //si la clave es igual, entonces retornamos el nodo
        if(i < actual.n && key == actual.key[i]){
            //return actual;//retorna el valor
            return actual.key[i];//retorna el valor
        }else{
            //se revisa primero si tiene hijos
            if(actual.leaf){
                return -1;
                //return null;
            }else{
                //si tiene hijos, hace una llamada recursiva
                return search(actual.child[i], key);
            }
        }
    }
    
    public void eliminar(int key){
       tipoActual = false;//variable global
       buscarEliminar(root, key);
    }
    
    private void buscarEliminar(nodoB actual, int key){//agregar un booleano que me indique que ya paso por aqui
        int i = 0;
        
        while(i < actual.n && key > actual.key[i]){
            i++;
        }
        if(i < actual.n && key == actual.key[i]){
            
            //si no es hoja y es la primera vez que esntra
            if(actual.leaf == false && tipoActual == false){
                //System.out.println("eliminar un no hoja ");                
                tipoActual = true;
                //voy a buscar el mayor de los menores
                noHoja(actual.child[i], i, key);
                int mayorMenores = retornar;
                actual.key[i] = mayorMenores;
                //balancear por si algo hubiera quedado desbalanceado
                balancear(actual, i, key);
            }else{
                while(i < actual.n-1){
                    actual.key[i] = actual.key[i+1];
                    i++;
                }
                actual.n--;
            }
            tipoActual=true;
        }else{
            //se revisa primero si tiene hijos
            if(actual.leaf){
                System.out.println("no existe o no se encontro");
                //return -1;
            }else{
                //si tiene hijos, hace una llamada recursiva
                buscarEliminar(actual.child[i], key);
                balancear(actual, i, key);
            }//sale del if si no es hoja
        }//sale de si no es la clave
    }
    
    public void balancear(nodoB actual, int i, int key){//puedo borrar key del metodo
        //System.out.println("balancear: padre sera");
        //actual.imprimir();
        if(actual.child[i].n < t/2){//si tiene menos claves de las permitidas
            //System.out.println("esta vacia " + key);
            int claves = actual.n;
            //caso 1 esta entre el primer hijo y el ultimo
            if(i > 0 && i < claves){//de la derecha hacia atras
                //System.out.println("esta entre el primer y ultimo hijo");
                //Si el anterior puede dar un elemento
                if(actual.child[i-1].n > (t/2)){//si puede dar una clave el hijo anterior
                    //System.out.println("anterior me puede dar un elemento");
                    //muevo las claves a la derecha
                    for(int k=actual.child[i].n;k>0;k--){
                        actual.child[i].key[k] = actual.child[i].key[k-1];
                    }
                    //paso el padre al hijo actual
                    actual.child[i].key[0] = actual.key[i-1];//copio la clave padre en el hijo vacío
                    actual.child[i].n++;//le aumento n porque ya no esta vacio
                    //subo el ultimo valor del anterior hijo al padre
                    actual.key[i-1] = actual.child[i-1].key[actual.child[i-1].n-1];
                    //elimino el valor copiado
                    buscarEliminar(actual.child[i-1], actual.key[i-1]);
                    //si no es hoja, mover los hijos
                    if(!actual.child[i].leaf){
                        //corro los hijos a la derecha
                        for(int j = actual.child[i].n; j > 0; j--){
                            actual.child[i].child[j] = actual.child[i].child[j-1];
                        }
                        //asigno el ultimo hijo del anterior como primer hijo del ultimo hijo
                        actual.child[i].child[0] = actual.child[i-1].child[actual.child[i-1].n+1];
                        //actual.child[i-1].n + 1, sumo el 1 porque elimine un dato y necesito el ultimo hijo cuando lo tenia
                    }
                }else if(actual.child[i+1].n > (t/2)){//cantidad de claves en el hijo derecho
                    //si el anterior no puede, ver si el siguiente puede dar un elemento   
                    //System.out.println("siguiente me puede dar un elemento");
                    //paso el padre al hijo
                    actual.child[i].key[(t/2)-1] = actual.key[i];//copio la clave padre en el hijo vacío
                    actual.child[i].n++;//le aumento n porque ya no esta vacio
                    //subo el primer valor del siguiente hijo al padre
                    actual.key[i] = actual.child[i+1].key[0];
                    //elimino el valor copiado
                    buscarEliminar(actual.child[i+1], actual.key[i]);//siempre es el primero
                    //si no es hoja
                    if(!actual.child[i].leaf){
                        //System.out.println("hijo no es hoja");
                        //paso el primer hijo del siguiente como ultimo del hijo del que  elimine
                        actual.child[i].child[actual.child[i].n] = actual.child[i+1].child[0];
                        //corro los hijos del hijo siguiente
                        for(int j = 0; j <= actual.child[i+1].n; j++){
                            actual.child[i+1].child[j] = actual.child[i+1].child[j+1];
                        }
                    }
                }else{
                    //si ninguno puede dar un elemento
                    //System.out.println("no me puede dar elemento niguno de los dos");
                    if(actual.child[i].leaf){
                        unirUltimo(actual, i, true);
                    }else{
                        unirUltimo(actual, i, false);
                    }
                    //muevo los hijos a la izquierda
                    for(int j = i; j < actual.n + 1; j++){
                        actual.child[j] = actual.child[j+1];
                    }
                }
            }else if(i == 0){//si fuera el primer hijo
                //System.out.println("es el primer hijo");
                //Verifico si el hijo hoja siguiente me puede dar un elemento
                if(actual.child[i+1].n > (t/2)){//cantidad de claves en el hijo derecho
                    //System.out.println("me puede dar un elemento");
                    //SI ES HOJA
                    //paso el padre al hijo
                    //actual.child[i].key[(t/2)-1] = actual.key[i];//copio la clave padre en el hijo vacío
                    actual.child[i].key[actual.child[i].n] = actual.key[i];//copio la clave padre en el hijo vacío
                    actual.child[i].n++;//le aumento n porque ya no esta vacio
                    //subo el primer valor del siguiente hijo al padre
                    actual.key[i] = actual.child[i+1].key[0];
                    //elimino el valor copiado
                    buscarEliminar(actual.child[i+1], actual.key[i]);//siempre es el primero
                    //si no es hoja mover los hijos
                    if(!actual.child[i].leaf){
                        //System.out.println("hijo no es hoja");
                        //paso el primer hijo del siguiente como ultimo del hijo del que  elimine
                        actual.child[i].child[actual.child[i].n] = actual.child[i+1].child[0];
                        //corro los hijos del hijo siguiente
                        for(int j = 0; j <= actual.child[i+1].n; j++){
                            actual.child[i+1].child[j] = actual.child[i+1].child[j+1];
                        }
                    }
                }else{
                    //System.out.println("no me puede dar elemento el siguiente");
                    if(actual.child[i].leaf){
                        unirPrimero(actual, i, true);
                    }else{
                        unirPrimero(actual, i, false);//no es hoja
                    }
                }
            }else{//si fuera el ultimo hijo
                //System.out.println("es el ultimo hijo");
                if(actual.child[i-1].n > (t/2)){//si puede dar una clave el hijo anterior
                    //System.out.println("me puede dar un elemento");
                    //muevo las claves a la derecha
                    for(int k=actual.child[i].n;k>0;k--){
                        actual.child[i].key[k] = actual.child[i].key[k-1];
                    }
                    //paso el padre al hijo actual
                    actual.child[i].key[0] = actual.key[i-1];//copio la clave padre en el hijo vacío
                    actual.child[i].n++;//le aumento n porque ya no esta vacio
                    //subo el ultimo valor del anterior hijo al padre
                    actual.key[i-1] = actual.child[i-1].key[actual.child[i-1].n-1];
                    //elimino el valor copiado
                    buscarEliminar(actual.child[i-1], actual.key[i-1]);
                    //si no es hoja
                    if(!actual.child[i].leaf){
                        //corro los hijos a la derecha
                        for(int j = actual.child[i].n; j > 0; j--){
                            actual.child[i].child[j] = actual.child[i].child[j-1];
                        }
                        //asigno el ultimo hijo del anterior como primer hijo del ultimo hijo
                        actual.child[i].child[0] = actual.child[i-1].child[actual.child[i-1].n+1];
                        //actual.child[i-1].n + 1, sumo el 1 porque elimine un dato y necesito el ultimo hijo cuando lo tenia
                    }
                }else{
                    //System.out.println("no me puede dar elemento el anterior");
                    if(actual.child[i].leaf){
                        unirUltimo(actual, i, true);
                    }else{
                        unirUltimo(actual, i, false);
                    }
                }
            }
        }//fin de verificar si el hijo tiene menos claves de las permitidas
        //else{
            //salir();
            //System.out.println("Balanceado");
        //}
    }
    
    public void unirPrimero(nodoB actual, int i, boolean hoja){
        nodoB z = new nodoB(t);
        z.leaf = actual.child[i+1].leaf;
        
        //copia las claves que quedan del hijo actual
        for(int j = 0; j < actual.child[i].n; j++){
            z.key[j] = actual.child[i].key[j];
            z.n++;
        }
        
        //copio el padre al nuevo hijo
        z.key[z.n] = actual.key[i];
        z.n++;
        
        //copia las claves del siguiente hijo
        int m = z.n;
        for(int j = 0; j < actual.child[i+1].n; j++){
            z.key[m+j] = actual.child[i+1].key[j];
            z.n++;
        }
        
        if(hoja){
            actual.child[i] = z;//asigno z como hijo primero
            //muevo los hijos del actual
            for(int j=i+1;j<=actual.n;j++){
                actual.child[j] = actual.child[j+1];
            }
        }
        
        else{
            //paso los hijos del hijo izquierdo
            for(int h=0; h<=actual.child[i].n; h++){
                z.child[h]=actual.child[i].child[h];
            }
            //paso los hijos del lado derecho
            int extra = actual.child[i].n + 1;
            for(int h=0; h<=actual.child[i+1].n;h++){
                z.child[extra]=actual.child[i+1].child[h];
                extra++;
            }
            //muevo los hijos del actual
            for(int h = i; h<actual.n; h++){
                actual.child[h] = actual.child[h+1];
            }
            //asigno z como hijo del actual
            actual.child[i] = z;//asigno z como hijo
        }
        
        //elimino la clave del padre
        buscarEliminar(actual, actual.key[i]);
        //si la raiz (actual) quedó vacia volver raiz la unica hoja que quedo
        if(actual.n == 0 && actual == root){//la raiz puede tener menos de t/2 claves
            root = actual.child[0];
        }
    }
    
    public void unirUltimo(nodoB actual, int i, boolean hoja){
        nodoB z = new nodoB(t);
        z.leaf = actual.child[i-1].leaf;
        
        //copia las claves del hijo anterior
        for(int j = 0; j < actual.child[i-1].n; j++){
            z.key[j] = actual.child[i-1].key[j];
            z.n++;
        }
        
        //copio el padre al nuevo hijo
        z.key[z.n] = actual.key[i-1];
        z.n++;
        
        //copia las claves que quedan del hijo actual
        int m = z.n;
        for(int j = 0; j < actual.child[i].n; j++){
            z.key[m+j] = actual.child[i].key[j];
            z.n++;
        }
        
        if(hoja){
            actual.child[i-1] = z;//asigno z como hijo
        }
        else{
            //paso los hijos del hijo izquierdo
            for(int h=0; h<=actual.child[i-1].n;h++){
                z.child[h]=actual.child[i-1].child[h];
            }
            //agrego los hijos del hijo eliminado
            int extra = actual.child[i-1].n + 1;
            for(int h=0; h<=actual.child[i].n;h++){
                z.child[extra]=actual.child[i].child[h];
                extra++;
            }
            actual.child[i-1] = z;//asigno z como hijo
        }
        //elimino la clave del padre
        buscarEliminar(actual, actual.key[i-1]);
        //si actual es la raiz y quedó vacia, volver raiz el hijo
        if(actual.n == 0 && actual == root){
            root = actual.child[0];
        }
    }
    
    public void noHoja(nodoB actual, int i, int key){
        //System.out.println("metodo noHoja");
        //si es hoja es el que busco
        if(actual.leaf){
            //System.out.println("maximo "+actual.key[actual.n-1]);
            retornar = actual.key[actual.n-1];
            buscarEliminar(actual, retornar);
        }else{
            //si no es hoja busco el mayor de los menores
            noHoja(actual.child[actual.n], actual.n, key);
            balancear(actual, actual.n, key);
        }
        
    }
    
    public void reporte(){
        System.out.println("Reportar");
        //String escribir = "prueba";
        BufferedWriter linea = null;
        try{
            File archivo = new File("arbolb.txt");
            //linea = new BufferedWriter(new FileWriter(archivo,true));//con el true agrega al final del archivo
            //linea.write(escribir);//puedo usar una variable y mandarla como cadena
            //linea.newLine();//si el salto de linea \n no funciona puedo usar este comando
            linea = new BufferedWriter(new FileWriter(archivo));
            linea.write("digraph G {");
            linea.write("\nrankdir=TB;");
            linea.write("\nnode[shape = record, style = filled];");
            reporte2(root, linea, false, "");
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
            //File archivoEntrada = new File("arbolb.txt");
            //File archivoSalida = new File("arbolb.png");
            /*
            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
            //String dotPath = "dot ";

            //String fileInputPath = archivoEntrada.getAbsolutePath();
            //String fileOutputPath = archivoSalida.getAbsolutePath();
            //String fileOutputPath = "C:\\Users\\Kevin\\Documents\\NetBeansProjects\\EjemploArbolBKnuth\\arbolb.png";
            
            String fileInputPath = ".//arbolb.txt";
            String fileOutputPath = ".//arbolb.png";

            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[6];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            cmd[5] = "arbolb.png";
            
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
            */
            String fileInputPath = ".//arbolb.txt";
            String fileOutputPath = ".//arbolb.png";
            ProcessBuilder proceso;
            proceso = new ProcessBuilder("dot", "-Tpng", "-o", fileOutputPath, fileInputPath);
            proceso.redirectErrorStream(true);
            proceso.start();
            
            //Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"arbolb.png");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    //Reporte es cuando no se permite repetir claves en el arbol b
    public void reporte2(nodoB actual, BufferedWriter linea, boolean hijo, String padre){
        try{
            //lo que esta en el metodo imprimir para el nodo
            int n = actual.n;
            linea.newLine();
            String nombreActual = ""+actual.key[0];
            //cadena que contiene el nodo
            String imprimir = nombreActual + " [label = \"";
            for(int i = 0; i < n; i++){
                if(i<n-1){
                    //System.out.println(actual.key[i]+ " | ");
                    imprimir = imprimir + actual.key[i]+ " | ";
                }else{
                    //System.out.println(actual.key[i]);
                    imprimir = imprimir + actual.key[i];
                }
            }
            //imprimir = imprimir + "\"]";
            imprimir = imprimir + "\"]";
            linea.write(imprimir);
            
            //si es hijo escribir su padre apuntando al nodo actual
            if(hijo){
                //linea.write("\n"+padre + " -> nodo"+nodo);
                linea.write("\n"+padre + " -> " + nombreActual);
            }
            
            //si no es hoja
            if(!actual.leaf){
                //nodoPadre = "nodo"+nodoP;
                //recorre los nodos para saber si tiene hijos
                for(int j = 0; j <= n; j++){
                    if(actual.child[j] != null){
                        reporte2(actual.child[j], linea, true, nombreActual);
                    }
                }
            }
            
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        } 
    }
}
