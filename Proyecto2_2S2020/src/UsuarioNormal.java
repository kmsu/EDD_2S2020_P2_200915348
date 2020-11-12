
import javax.swing.JComboBox;
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
public class UsuarioNormal extends javax.swing.JFrame {

    /**
     * Creates new form UsuarioNormal
     */
    //ArbolB usuario  = new ArbolB(5);
    //ArbolB conductor = new ArbolB(5);
    ArbolB usuario;
    //ArbolB conductor;
    Usuario actual;
    HashTable tablaHash;
    public UsuarioNormal() {
        initComponents();
    }
    
    //public UsuarioNormal(Usuario actual, ArbolB usuario, ArbolB conductor) {
    public UsuarioNormal(Usuario actual, ArbolB usuario, HashTable hash) {
        initComponents();
        this.usuario = usuario;
        //this.conductor = conductor;
        this.actual = actual;
        this.tablaHash = hash;
        jlUsuario.setText(actual.usuario);
        jlNombre.setText(actual.nombre);
        jlCorreo.setText(actual.correo);
        jlNumero.setText(actual.telefono);
        //Agregar items al combo box
        llenarComboBox();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbModificarPerfil = new javax.swing.JButton();
        jbCerrarCuenta = new javax.swing.JButton();
        jlNombre = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jlCorreo = new javax.swing.JLabel();
        jlNumero = new javax.swing.JLabel();
        jbCerrarSesion = new javax.swing.JButton();
        jcbLugares = new javax.swing.JComboBox<>();
        Lugares = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaMostrarLugares = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuario");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Usuario");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Correo");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Telefono");

        jbModificarPerfil.setText("Modificar Perfil");
        jbModificarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarPerfilActionPerformed(evt);
            }
        });

        jbCerrarCuenta.setText("Cerrar Cuenta");
        jbCerrarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarCuentaActionPerformed(evt);
            }
        });

        jlNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlNombre.setText("jLabel3");

        jlUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlUsuario.setText("jLabel6");

        jlCorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlCorreo.setText("jLabel7");

        jlNumero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlNumero.setText("jLabel8");

        jbCerrarSesion.setText("Cerrar Sesion");
        jbCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarSesionActionPerformed(evt);
            }
        });

        jcbLugares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbLugaresActionPerformed(evt);
            }
        });

        Lugares.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Lugares.setText("Lugares");

        jtaMostrarLugares.setEditable(false);
        jtaMostrarLugares.setColumns(20);
        jtaMostrarLugares.setRows(5);
        jScrollPane1.setViewportView(jtaMostrarLugares);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlNombre)
                            .addComponent(jlUsuario)
                            .addComponent(jlCorreo)
                            .addComponent(jlNumero)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbModificarPerfil)
                        .addGap(18, 18, 18)
                        .addComponent(jbCerrarCuenta)
                        .addGap(18, 18, 18)
                        .addComponent(jbCerrarSesion)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Lugares)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jcbLugares, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jlUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCorreo)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlNumero)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lugares)
                    .addComponent(jcbLugares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModificarPerfil)
                    .addComponent(jbCerrarCuenta)
                    .addComponent(jbCerrarSesion))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCerrarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarCuentaActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "Eliminar Cuenta", "¿Desea eliminar la cuenta?", JOptionPane.YES_NO_OPTION);
        if(respuesta == 0){
            usuario.eliminar(actual);
            JOptionPane.showMessageDialog(this, "Eliminado");
            //cierro la ventana
            dispose();
        }else{
            System.out.println("no hacer nada");
        }
    }//GEN-LAST:event_jbCerrarCuentaActionPerformed

    private void jbCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarSesionActionPerformed
        dispose();
    }//GEN-LAST:event_jbCerrarSesionActionPerformed

    private void jbModificarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarPerfilActionPerformed
        //false es conductor (true es normal). Si contiene la tabla hash es usuario normal
        Modificar mod = new Modificar(actual, usuario, true, tablaHash);
        mod.setLocationRelativeTo(null);
        mod.setVisible(true);
        dispose();
    }//GEN-LAST:event_jbModificarPerfilActionPerformed

    private void jcbLugaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbLugaresActionPerformed
        int pos = jcbLugares.getSelectedIndex();
        //System.out.println("seleccione "+ pos);
        String lugar = jcbLugares.getItemAt(pos);
        //System.out.println("Seleccione " + lugar);
        NodoTablaHash datos = tablaHash.buscar(lugar);
        if(datos != null){
            
            String mostrar = "Categoria: " + datos.categoria +
                             "\nNombre: " + datos.nombre +
                            "\nlatitud: " + datos.latitud +
                            "\nLongitu: " + datos.longitud;
            jtaMostrarLugares.setText(mostrar);
        }
        
    }//GEN-LAST:event_jcbLugaresActionPerformed

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
            java.util.logging.Logger.getLogger(UsuarioNormal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioNormal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioNormal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioNormal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioNormal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lugares;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCerrarCuenta;
    private javax.swing.JButton jbCerrarSesion;
    private javax.swing.JButton jbModificarPerfil;
    private javax.swing.JComboBox<String> jcbLugares;
    private javax.swing.JLabel jlCorreo;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlNumero;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JTextArea jtaMostrarLugares;
    // End of variables declaration//GEN-END:variables

    public void llenarComboBox(){
        if(tablaHash.elementos == 0){
            jcbLugares.addItem("vacio");
            jcbLugares.setEnabled(false);
            jtaMostrarLugares.setText("vacío");
        }else{
            //String combo[] = new String[tablaHash.tamaño];
            for(int i = 0; i < tablaHash.tamaño; i++){
                
                if(tablaHash.tabla[i] != null){
                    String agregar = tablaHash.tabla[i].nombre;
                    jcbLugares.addItem(agregar);
                }
                
            }
        }
    }
        /*
        if(jcbTipoUsuario.getSelectedIndex() == 0){
            System.out.println("Usuario");
        }else if(jcbTipoUsuario.getSelectedIndex() == 1){
            System.out.println("Conductor");
        }else{
            System.out.println("administrador");
        }
        */
}