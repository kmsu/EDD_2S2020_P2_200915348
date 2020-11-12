
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
public class UsuarioConductor extends javax.swing.JFrame {

    /**
     * Creates new form UsuarioNormal
     */
    //ArbolB usuario;
    Usuario actual;
    ArbolB conductor;
    
    public UsuarioConductor() {
        initComponents();
    }
    
    //public UsuarioConductor(Usuario actual,ArbolB usuario, ArbolB conductor) {
    public UsuarioConductor(Usuario actual, ArbolB conductor) {
        initComponents();
        //this.usuario = usuario;
        this.conductor = conductor;
        this.actual = actual;
        jlUsuario.setText(actual.usuario);
        jlNombre.setText(actual.nombre);
        jlCorreo.setText(actual.correo);
        jlNumero.setText(actual.telefono);
        jlPassWord.setText(actual.contraseña);
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
        jLabel3 = new javax.swing.JLabel();
        jlPassWord = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuario Conductor");

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

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("PassWord");

        jlPassWord.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlPassWord.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbModificarPerfil)
                        .addGap(85, 85, 85)
                        .addComponent(jbCerrarCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(jbCerrarSesion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlUsuario)
                            .addComponent(jlNombre)
                            .addComponent(jlCorreo)
                            .addComponent(jlNumero)
                            .addComponent(jlPassWord))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlUsuario)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCorreo)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlNumero)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jlPassWord))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
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
            conductor.eliminar(actual);
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
        Modificar mod = new Modificar(actual, conductor, false);//false es conductor (true es normal)
        mod.setLocationRelativeTo(null);
        mod.setVisible(true);
        dispose();
    }//GEN-LAST:event_jbModificarPerfilActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbCerrarCuenta;
    private javax.swing.JButton jbCerrarSesion;
    private javax.swing.JButton jbModificarPerfil;
    private javax.swing.JLabel jlCorreo;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlNumero;
    private javax.swing.JLabel jlPassWord;
    private javax.swing.JLabel jlUsuario;
    // End of variables declaration//GEN-END:variables
}
