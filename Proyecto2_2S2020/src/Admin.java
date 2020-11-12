
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.html.HTMLDocument;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
public class Admin extends javax.swing.JFrame {
    //ArbolB usuario = new ArbolB(5);
    //ArbolB conductor = new ArbolB(5);
    ArbolB usuario;
    ArbolB conductor;
    HashTable tablaHash;
    /**
     * Creates new form Admin
     */
    
    public Admin() {
        initComponents();
    }
    
    public Admin(ArbolB usuario, ArbolB conductor, HashTable tablaHash) {
        this.usuario = usuario;
        this.conductor = conductor;
        this.tablaHash = tablaHash;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlAdministrador = new javax.swing.JLabel();
        jbCargarUsuarios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbUsuarioNormal = new javax.swing.JButton();
        jbUsuarioConductor = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();
        jbLugares = new javax.swing.JButton();
        jbReporteLugares = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrador");

        jlAdministrador.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlAdministrador.setText("   Carga de archivos");

        jbCargarUsuarios.setText("Usuarios");
        jbCargarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCargarUsuariosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Reportes");

        jbUsuarioNormal.setText("Usuario Normal");
        jbUsuarioNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUsuarioNormalActionPerformed(evt);
            }
        });

        jbUsuarioConductor.setText("Usuario Conductor");
        jbUsuarioConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUsuarioConductorActionPerformed(evt);
            }
        });

        jbVolver.setText("Volver");
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        jbLugares.setText("Lugares");
        jbLugares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLugaresActionPerformed(evt);
            }
        });

        jbReporteLugares.setText("Lugares");
        jbReporteLugares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReporteLugaresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jbVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbLugares)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbUsuarioConductor)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCargarUsuarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbUsuarioNormal)
                        .addGap(55, 55, 55))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbReporteLugares)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCargarUsuarios)
                    .addComponent(jbUsuarioNormal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbUsuarioConductor)
                    .addComponent(jbLugares))
                .addGap(18, 18, 18)
                .addComponent(jbReporteLugares)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(jbVolver)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCargarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCargarUsuariosActionPerformed
        //File archivo = null;
        FileReader fr = null;
        //BufferedReader br = null;
        
        //selector de archivos
        JFileChooser seleccionar = new JFileChooser();
        //filtro para que solo aparezcan los archivos json
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Json (*.json)", "json");
        seleccionar.setFileFilter(filtro);
        if(seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION){
            String path = seleccionar.getSelectedFile().toString();
            try {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader(path));//obj es el archivo tipo json
                JSONObject jObject = (JSONObject) obj;//convierto el objeto en json
                //recorrer el arreglo
                JSONArray usuarios = (JSONArray) jObject.get("usuarios");
                
                int size = usuarios.size();
                for(int i = 0; i < size; i++){
                    JSONObject jUsuario = (JSONObject) usuarios.get(i);
                    //la libreria reconoce los numeros como long por eso debo pasarlo a int
                    int id = (int)(long)jUsuario.get("id");
                    //System.out.println("\nid: " + id);
                    String nombre = (String)jUsuario.get("nombre");
                    //System.out.println("nombre: "+jUsuario.get("nombre"));
                    String usuarioU = (String)jUsuario.get("usuario");
                    //System.out.println("usuario: "+jUsuario.get("usuario"));
                    String correo = (String)jUsuario.get("correo");
                    //System.out.println("correo: "+jUsuario.get("correo"));
                    String pass = (String)jUsuario.get("pass");
                    //System.out.println("pass: "+jUsuario.get("pass"));
                    String telefono = (String)jUsuario.get("telefono");
                    //System.out.println("telefono: "+jUsuario.get("telefono"));
                    //String rol = (String)jUsuario.get("rol");
                    //System.out.println("rol: "+jUsuario.get("rol"));
                    
                    if(jUsuario.get("rol").equals("normal")){
                 //Usuario(int id_usuario, String nombre, String usuario, String correo, String contraseña, int telefono)
                        Usuario newUser = new Usuario(id, nombre, usuarioU, correo, pass, telefono);
                        usuario.insertar2(newUser);
                    }else{
                        //creo un usuario pero lo inserto en conductor al no ser usuario normal
                        Usuario newUser = new Usuario(id, nombre, usuarioU, correo, pass, telefono);
                        conductor.insertar2(newUser);
                    }
                }
                //usuario.reporte(0);
                //conductor.reporte(1);
                
                /*
                //muestra todos los campos por si solo
                Iterator iterator = usuarios.iterator();
                while (iterator.hasNext()){
                    System.out.println(iterator.next());
                }
                */
                
                JOptionPane.showMessageDialog(this, "Lectura del fichero con exito");
             }
             catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "No se pudo completar la lectura del archivo");
             }finally{
                // En el finally cerramos el fichero, para asegurarnos
                // que se cierra tanto si todo va bien como si salta una excepcion.
                try{                    
                   if( null != fr ){   
                      fr.close();     
                   }                  
                }catch (Exception e2){ 
                   e2.printStackTrace();
                }
             }
        }
    }//GEN-LAST:event_jbCargarUsuariosActionPerformed

    private void jbUsuarioNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUsuarioNormalActionPerformed
        boolean vacio = usuario.paraReporte();
        if(vacio){
            JOptionPane.showMessageDialog(this, "No hay datos de usuarios");
        }else{
            usuario.reporte(0);
        }
    }//GEN-LAST:event_jbUsuarioNormalActionPerformed

    private void jbUsuarioConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUsuarioConductorActionPerformed
        boolean vacio = usuario.paraReporte();
        if(vacio){
            JOptionPane.showMessageDialog(this, "No hay datos de usuarios");
        }else{
            conductor.reporte(1);
        }
    }//GEN-LAST:event_jbUsuarioConductorActionPerformed

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        dispose();
    }//GEN-LAST:event_jbVolverActionPerformed

    private void jbLugaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLugaresActionPerformed
        FileReader fr = null;
        //selector de archivos
        JFileChooser seleccionar = new JFileChooser();
        //filtro para que solo aparezcan los archivos json
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Json (*.json)", "json");
        seleccionar.setFileFilter(filtro);
        if(seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION){
            String path = seleccionar.getSelectedFile().toString();
            try {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader(path));//obj es el archivo tipo json
                JSONObject jObject = (JSONObject) obj;//convierto el objeto en json
                JSONArray lugares = (JSONArray) jObject.get("Lugares");
                int size = lugares.size();
                for(int i = 0; i < size; i++){
                    JSONObject jLugar = (JSONObject) lugares.get(i);
                    //la libreria reconoce los numeros como long por eso debo pasarlo a int
                    int id = (int)(long)jLugar.get("id");
                    //System.out.println("\nid: " + id);
                    
                    String categoria = (String)jLugar.get("Categoria");
                    //System.out.println("Categoria: "+ categoria);
                    
                    String nombre = (String)jLugar.get("Nombre");
                    //System.out.println("nombre: "+nombre);
                    
                    double latitud = (double)jLugar.get("Lat");
                    //System.out.println("latitud: "+latitud);
                    
                    double longitud = (double)jLugar.get("Lon");
                    //System.out.println("longitud: "+longitud);
                    
                    //CARGAR TABLA HASH
                    NodoTablaHash nuevo = new NodoTablaHash(id, categoria, nombre, latitud, longitud);
                    tablaHash.insertar(nuevo);
                    System.out.println("tabla hash actual");
                    tablaHash.print();
                    System.out.println("Factor: " +tablaHash.factorCarga());
                    
                }
                JOptionPane.showMessageDialog(this, "Lectura del fichero con exito");
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "No se pudo completar la lectura del archivo");
            }finally{
                // En el finally cerramos el fichero, para asegurarnos
                // que se cierra tanto si todo va bien como si salta una excepcion.
                try{                    
                   if( null != fr ){   
                      fr.close();     
                   }                  
                }catch (Exception e2){ 
                   e2.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jbLugaresActionPerformed

    private void jbReporteLugaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReporteLugaresActionPerformed
        //REPORTAR
        if(tablaHash.elementos == 0){
            JOptionPane.showMessageDialog(this, "No ha cargado lugares aun");
        }else{
            tablaHash.reporte();
        }
    }//GEN-LAST:event_jbReporteLugaresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbCargarUsuarios;
    private javax.swing.JButton jbLugares;
    private javax.swing.JButton jbReporteLugares;
    private javax.swing.JButton jbUsuarioConductor;
    private javax.swing.JButton jbUsuarioNormal;
    private javax.swing.JButton jbVolver;
    private javax.swing.JLabel jlAdministrador;
    // End of variables declaration//GEN-END:variables
}