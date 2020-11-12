
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
public class Proyecto2_2S2020 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int t = 5;
        ArbolB usuario = new ArbolB(t);
        ArbolB conductor = new ArbolB(t);
        HashTable tablaHash = new HashTable();
        
        //Login log = new Login();
        Login log = new Login(usuario, conductor, tablaHash);
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        
        //PRUEBA TABLA HASH
        /*
        HashTable tablaHash = new HashTable();
        for(int i=1; i < 5; i++){
            String nombre = "nombre"+i;
            NodoTablaHash nuevo = new NodoTablaHash(1, "Categoria", nombre, 14.3654, -90.4578);
            tablaHash.insertar(nuevo);
        }
        tablaHash.print();
        System.out.println("Factor de carga: "+tablaHash.getFactorCarga());
        DecimalFormat formato = new DecimalFormat("#0.000");
        String presentar = formato.format(tablaHash.getFactorCarga());
        System.out.println("factor nuevo: " + presentar);
        */
        
        //PRUEBA ARBOL B
        /*
        for(int i = 10; i<90;i+=10){
            String nombre = "nombre"+i;
            String usuarioU = "usuario"+i;
            String correo = "correo"+i;
            String pass = "pass"+i;
            String telefono = "telefono"+i;
            String rol = "rol";
            Usuario newUser = new Usuario(i, nombre, usuarioU, correo, pass, telefono);
            usuario.insertar2(newUser);
        }
        
        //Usuario newUser = new Usuario(80, nombre, usuarioU, correo, pass, telefono);
        //usuario.insertar2(newUser);
        
        System.out.println("");
        System.out.println("ESTADO ARBOL B");
        usuario.showBTree();
        System.out.println("");
        
        System.out.println("usuario antes de eliminar");
        Usuario newUser2 = usuario.iniciarSesion("usuario30", "pass30");
        System.out.println("id "+newUser2.id);
        System.out.println("nombre "+newUser2.nombre);
        System.out.println("usuario "+newUser2.usuario);
        System.out.println("correo "+newUser2.correo);
        System.out.println("pass "+newUser2.contraseña);
        System.out.println("telefono "+newUser2.telefono);
        
        //System.out.println("\nbusqueda por id");
        //usuario.buscarNodoPorClave(80);
        System.out.println("\nvoy a eliminar");
        int i = 30;
        String nombre = "nombre"+i;
        String usuarioU = "usuario"+i;
        String correo = "correo"+i;
        String pass = "pass"+i;
        String telefono = "telefono"+i;
        String rol = "rol";
        Usuario newUser = new Usuario(i, nombre, usuarioU, correo, pass, telefono);
        
        usuario.eliminar(newUser);
        
        System.out.println("");
        System.out.println("ESTADO ARBOL B");
        usuario.showBTree();
        System.out.println("");
        
        System.out.println("\nbusqueda por pass");
        Usuario buscar = null;
        buscar = usuario.iniciarSesion("usuario30", "pass30");
        if(buscar != null){
            usuario.reporte(0);
        }else{
            System.out.println("no se encontro");
        }
        */
        
        //PRUEBA REPORTE Y EJECUTAR AUTOMATICO
        /*conductor.reporte();
        usuario.reporte();
        try{
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "arbolb.png");
        }catch(Exception ex){
            
        }*/
        
        
        //DESDE LA VENTA ADMIN
        
        //Admin admin = new Admin(usuario, conductor);
        //admin.setLocationRelativeTo(null);
        //admin.setVisible(true);
        
    }
}
