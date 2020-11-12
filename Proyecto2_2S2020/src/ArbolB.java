
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

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
    nodoArbolB root;
    int t;//Grado
    int caso;//Creo no la esta usando
    //int retornar = 0;//se usa en el metodo noHoja
    Usuario retornar = null;//se usa en el metodo noHoja
    int mayor = 0;
    boolean existe;//si es un numero repetido devolver si existe
    boolean rootInsert;
    boolean tipoActual;//Se usa en eliminar
    
    public ArbolB(int t){
        this.t = t;
        this.root = new nodoArbolB(t);//contiene arreglo de claves y arreglo de hijos
    }
    
    public void insertar2(Usuario key){
        existe = false;
        nodoArbolB r = root;//contiene arreglo de claves y arreglo de hijos (conservo la raiz)
        //si el nodo esta lleno lo debe separar
        if(r.n == (t - 1)){//No debería estar aqui de entrada pues cuando la raiz esta llena
                            //sin importar a que hijo inserte aunque tenga espacio va a hacer el split
            rootInsert = true;
            nonFullInsert2(r, key);//inserto el ultimo dato para obtener los 3 arreglos que necesito
            if(rootInsert){//en lugar de rootInsert podría ver si r.n es 3
                nodoArbolB s = new nodoArbolB(t);//creo el nuevo nodo
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
    
    private void nonFullInsert2(nodoArbolB x, Usuario key){//x es la raiz(actual)
        //si es hoja
        if(x.leaf){
            int i = x.n; //cantidad de valores del nodo (con posicion)
            //busca la posicion i donde asignar el valor
            while(i >= 1 && key.id < x.key[i-1].id){//empieza a comparar si es mayor desde la ultima posicion hacia atras
                x.key[i] = x.key[i-1];//Desplaza los valores mayores a key
                i--;
            }
            //Verifico que no exista la llave para insertarla
            if(i == 0 && x.key[i] == key){
                System.out.println("ya existe");
                rootInsert = false;
                int j = i;
                while(j < x.n){
                    System.out.println("Nunca entra en este caso");
                    x.key[j] = x.key[j+1];//Desplaza los valores mayores a key
                    j++;
                }
                existe = true;
            }else if(i > 0 && x.key[i-1].id == key.id){
                System.out.println("ya existe");
                rootInsert = false;
                //arreglo el movimiento por si algo se 
                int j = i;
                while(j < x.n){
                    x.key[j] = x.key[j+1];
                    j++;
                }
                existe = true;
            }else{
                x.key[i] = key; //asigna el valor al arreglo key en el nodo
                x.n++; //aumenta la cantidad de elementos del arreglo en el nodo
                //Guarda el numero mas alto
                if(key.id > mayor){
                    mayor = key.id;
                }
            }
        }else{
            int j = 0;
            //Busca la posicion del hijo (para ver si me voy al hijo de la derecha de key[j]
            while (j < x.n && key.id > x.key[j].id){
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
    
    private void split2(nodoArbolB x, int i, nodoArbolB y){//nuevo nodo, posicion del nuevo hijo, raiz actual AGREGAR KEY
        //ESTE SPLIT SOLO FUNCIONA CON NUMEROS GRADOS IMPARES
        //Nodo temporal que sera el de la derecha al partir el arreglo inicial
        int tam = t/2;
        nodoArbolB z = new nodoArbolB(t);
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
    private void print(nodoArbolB n){
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
    
    Usuario find = null;
    public Usuario iniciarSesion(String nick, String pass){
        sesion(root, nick, pass);
        return find;
    }
    
    //busqueda en orden por hijo a la izquierda
    private void sesion(nodoArbolB n, String nick, String pass){
        find = n.nodoSesion(nick, pass);
        if(!n.leaf && find == null){
            //recorre los nodos para saber si tiene hijos
            int j = 0;
            //for(int j = 0; j <= n.n; j++){
            while(j <= n.n && find == null){
                if(n.child[j] != null){
                    sesion(n.child[j], nick, pass);
                }
                j++;
            }
        }
    }
    
    Usuario datosNuevos;
    //Busca el valor ingresado y muestra el contenido del nodo que contiene el valor
    //public void buscarNodoPorClave(int num){//sin usuario
    public void buscarNodoPorClave(int num, Usuario nuevosDatos){
        this.datosNuevos = nuevosDatos;
        int valor = search(root, num);
        
        if(valor == -1){
            System.out.println("No se ha encontrado un nodo con el valor ingresado");
        }else{
            System.out.println("Se encontro el valor " + valor);
        }
    }
    
    //Buscar
    //private nodoB search(nodoB actual, int key){
    private int search(nodoArbolB actual, int key){
        int i = 0;//se empieza a buscar siempre en la primera posicion
        
        //Incrementa el indice mientras el valor de la clave del nodo sea menor
        while(i < actual.n && key > actual.key[i].id){
            i++;
        }
        
        //si la clave es igual, entonces retornamos el nodo
        if(i < actual.n && key == actual.key[i].id){
            
            //System.out.println("encontrado en buscar ");
            //System.out.println("id "+actual.key[i].id);
            //System.out.println("nombre "+actual.key[i].nombre);
            //System.out.println("usuario "+actual.key[i].usuario);
            //System.out.println("correo "+actual.key[i].correo);
            //System.out.println("pass "+actual.key[i].contraseña);
            //System.out.println("telefono "+actual.key[i].telefono);
            actual.key[i].usuario = datosNuevos.usuario;
            actual.key[i].nombre = datosNuevos.nombre;
            actual.key[i].correo = datosNuevos.correo;
            actual.key[i].telefono = datosNuevos.telefono;
            return actual.key[i].id;//retorna el valor
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
    
    public void eliminar(Usuario key){
       //System.out.println("key " + key);
       tipoActual = false;//variable global
       buscarEliminar(root, key);
    }
    
    private void buscarEliminar(nodoArbolB actual, Usuario key){//agregar un booleano que me indique que ya paso por aqui
        //System.out.println("key de nuevo" + key);
        int i = 0;
        //System.out.println("key otra vez " + actual.key[i].id);
        while(i < actual.n && key.id > actual.key[i].id){
            i++;
        }
        if(i < actual.n && key.id == actual.key[i].id){
            //si no es hoja y es la primera vez que entra
            if(actual.leaf == false && tipoActual == false){
                //System.out.println("eliminar un no hoja ");                
                tipoActual = true;
                //voy a buscar el mayor de los menores
                noHoja(actual.child[i], i, key);
                Usuario mayorMenores = retornar;
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
    
    public void balancear(nodoArbolB actual, int i, Usuario key){//puedo borrar key del metodo
        
        if(actual.child[i].n < t/2){//si tiene menos claves de las permitidas
            //System.out.println("esta vacia " + key);
            int claves = actual.n;
            //caso 1 esta entre el primer hijo y el ultimo
            if(i > 0 && i < claves){//de la derecha hacia atras
                //Si el anterior puede dar un elemento
                if(actual.child[i-1].n > (t/2)){//si puede dar una clave el hijo anterior
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
                    //paso el padre al hijo
                    actual.child[i].key[(t/2)-1] = actual.key[i];//copio la clave padre en el hijo vacío
                    actual.child[i].n++;//le aumento n porque ya no esta vacio
                    //subo el primer valor del siguiente hijo al padre
                    actual.key[i] = actual.child[i+1].key[0];
                    //elimino el valor copiado
                    buscarEliminar(actual.child[i+1], actual.key[i]);//siempre es el primero
                    //si no es hoja
                    if(!actual.child[i].leaf){
                        //paso el primer hijo del siguiente como ultimo del hijo del que  elimine
                        actual.child[i].child[actual.child[i].n] = actual.child[i+1].child[0];
                        //corro los hijos del hijo siguiente
                        for(int j = 0; j <= actual.child[i+1].n; j++){
                            actual.child[i+1].child[j] = actual.child[i+1].child[j+1];
                        }
                    }
                }else{
                    //si ninguno puede dar un elemento
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
                //Verifico si el hijo hoja siguiente me puede dar un elemento
                if(actual.child[i+1].n > (t/2)){//cantidad de claves en el hijo derecho
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
                        //paso el primer hijo del siguiente como ultimo del hijo del que  elimine
                        actual.child[i].child[actual.child[i].n] = actual.child[i+1].child[0];
                        //corro los hijos del hijo siguiente
                        for(int j = 0; j <= actual.child[i+1].n; j++){
                            actual.child[i+1].child[j] = actual.child[i+1].child[j+1];
                        }
                    }
                }else{
                    if(actual.child[i].leaf){
                        unirPrimero(actual, i, true);
                    }else{
                        unirPrimero(actual, i, false);//no es hoja
                    }
                }
            }else{//si fuera el ultimo hijo
                if(actual.child[i-1].n > (t/2)){//si puede dar una clave el hijo anterior
                    //muevo las claves a la derecha
                    for(int k=actual.child[i].n; k>0; k--){
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
                    if(actual.child[i].leaf){
                        unirUltimo(actual, i, true);
                    }else{
                        unirUltimo(actual, i, false);
                    }
                }
            }
        }//fin de verificar si el hijo tiene menos claves de las permitidas
        //else{
            //System.out.println("Balanceado");
        //}
    }
    
    public void unirPrimero(nodoArbolB actual, int i, boolean hoja){
        nodoArbolB z = new nodoArbolB(t);
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
    
    public void unirUltimo(nodoArbolB actual, int i, boolean hoja){
        nodoArbolB z = new nodoArbolB(t);
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
    
    public void noHoja(nodoArbolB actual, int i, Usuario key){
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
    
    public int idMayor(){
        return mayor;
    }
    
    public boolean paraReporte(){
        boolean vacio = true;
        if(root.n != 0){
            vacio = false;
        }
        return vacio;
    }
    
    public void reporte(int tipo){
        System.out.println("Reportar");
        //String escribir = "prueba";
        BufferedWriter linea = null;
        try{
            //tipo = 0 es usuario
            //tipo = 1 es conductor
            String nombreArchivo = "";
            if(tipo == 0){
                nombreArchivo = "usuarioB.txt";
            }else if(tipo == 1){
                nombreArchivo = "conductorB.txt";
            }
            
            File archivo = new File(nombreArchivo);
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
            //tipo = 0 es usuario
            //tipo = 1 es conductor
            String fileInputPath = "";
            String fileOutputPath = "";
            if(tipo == 0){
                fileInputPath = ".//usuarioB.txt";
                fileOutputPath = ".//usuarioB.png"; 
            }else if(tipo == 1){
                fileInputPath = ".//conductorB.txt";
                fileOutputPath = ".//conductorB.png";
            }
            
            ProcessBuilder proceso;
            proceso = new ProcessBuilder("dot", "-Tpng", "-o", fileOutputPath, fileInputPath);
            proceso.redirectErrorStream(true);
            proceso.start();
            
            //tipo = 0 es usuario
            //tipo = 1 es conductor
            String salida = "";
            if(tipo == 0){
                salida = "usuarioB.png";
            }else if(tipo == 1){
                salida = "conductorB.png";
            }
            //Para que ejecuteautomaticamente, puede ir en otro lado
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + salida);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    //Reporte es cuando no se permite repetir claves en el arbol b
    public void reporte2(nodoArbolB actual, BufferedWriter linea, boolean hijo, String padre){
        try{
            //lo que esta en el metodo imprimir para el nodo
            int n = actual.n;
            linea.newLine();
            String nombreActual = ""+actual.key[0].id;
            //cadena que contiene el nodo
            String imprimir = nombreActual + " [label = \"";
            for(int i = 0; i < n; i++){
                if(i<n-1){
                    //System.out.println(actual.key[i]+ " | ");
                    imprimir = imprimir + actual.key[i].id + " | ";
                }else{
                    //System.out.println(actual.key[i]);
                    imprimir = imprimir + actual.key[i].id;
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

