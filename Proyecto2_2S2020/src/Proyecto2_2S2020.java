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
        
        Login log = new Login(usuario, conductor);
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        
        
        
        
        
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
