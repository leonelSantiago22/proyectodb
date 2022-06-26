/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectodb;

/**
 *
 * @author Leonel
 */
public class vista_usuarios extends javax.swing.JFrame {

    /**
     * Creates new form 
     */
    //contructor
    public vista_usuarios() {
        initComponents();
        //cambios de dani
        
        coneccion objetoconexion = new coneccion();
        objetoconexion.establecerConecxionstatic();
        //mostrar la coneecion se realizo o no
        this.setLocationRelativeTo(null); //centramos   
        usarios objetoUsuarios = new usarios();
        objetoUsuarios.Mostrarusuarios(paraTotalDeUsuarios);
    }
    public void limpiar()
    {
        nickname_text.setText(null);
        email_text.setText(null);
        nombre_text.setText(null);
        Fechadenacimiento_text.setText(null);
        telefono_text.setText(null);
        Plataforma_text.setText(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Usuario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nickname_text = new javax.swing.JTextField();
        email_text = new javax.swing.JTextField();
        nombre_text = new javax.swing.JTextField();
        Fechadenacimiento_text = new javax.swing.JTextField();
        telefono_text = new javax.swing.JTextField();
        Plataforma_text = new javax.swing.JTextField();
        jButtonModificar = new javax.swing.JButton();
        Botton_Insertar = new javax.swing.JButton();
        Button_Eliminar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paraTotalDeUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuarios");
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Usuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario"));

        jLabel1.setText("Nickname:");

        jLabel2.setText("Email:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Fecha de acimiento:");

        jLabel5.setText("Telefono:");

        jLabel6.setText("Plataforma:");

        nickname_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nickname_textActionPerformed(evt);
            }
        });

        nombre_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_textActionPerformed(evt);
            }
        });

        Fechadenacimiento_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fechadenacimiento_textActionPerformed(evt);
            }
        });

        Plataforma_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plataforma_textActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        Botton_Insertar.setText("Insertar");
        Botton_Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_InsertarActionPerformed(evt);
            }
        });

        Button_Eliminar.setText("Eliminar");
        Button_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_EliminarActionPerformed(evt);
            }
        });

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UsuarioLayout = new javax.swing.GroupLayout(Usuario);
        Usuario.setLayout(UsuarioLayout);
        UsuarioLayout.setHorizontalGroup(
            UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsuarioLayout.createSequentialGroup()
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UsuarioLayout.createSequentialGroup()
                        .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nickname_text)
                            .addComponent(email_text)
                            .addComponent(nombre_text)
                            .addComponent(Fechadenacimiento_text)
                            .addComponent(telefono_text)
                            .addComponent(Plataforma_text, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                    .addGroup(UsuarioLayout.createSequentialGroup()
                        .addComponent(jButtonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(Botton_Insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(UsuarioLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Button_Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UsuarioLayout.setVerticalGroup(
            UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nickname_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombre_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Fechadenacimiento_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(telefono_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(Plataforma_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonModificar)
                    .addComponent(Botton_Insertar))
                .addGap(18, 18, 18)
                .addComponent(Button_Eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, 370));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de usuarios"));

        paraTotalDeUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        paraTotalDeUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paraTotalDeUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(paraTotalDeUsuarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 600, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nickname_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nickname_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nickname_textActionPerformed

    private void nombre_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_textActionPerformed

    private void Fechadenacimiento_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fechadenacimiento_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fechadenacimiento_textActionPerformed

    private void Plataforma_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plataforma_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Plataforma_textActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
       usarios u = new usarios();
       u.modificar_usuario(nickname_text, email_text, nombre_text, Fechadenacimiento_text, telefono_text, Plataforma_text);
       u.Mostrarusuarios(paraTotalDeUsuarios);
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void Botton_InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_InsertarActionPerformed
        usarios u = new usarios();
        u.inserta_usuario(nickname_text, email_text, nombre_text, Fechadenacimiento_text, telefono_text, Plataforma_text);
        u.Mostrarusuarios(paraTotalDeUsuarios);
        
    }//GEN-LAST:event_Botton_InsertarActionPerformed

    private void Button_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EliminarActionPerformed
        usarios u = new usarios();
        u.eliminar_usuario(nickname_text);
        limpiar();
    }//GEN-LAST:event_Button_EliminarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void paraTotalDeUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paraTotalDeUsuariosMouseClicked
        usarios u = new usarios();
        u.seleccionar_usuario(paraTotalDeUsuarios, nickname_text, email_text, nombre_text, Fechadenacimiento_text, telefono_text, Plataforma_text);
        
    }//GEN-LAST:event_paraTotalDeUsuariosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        menu_vista v = new menu_vista();
        this.setVisible(false);
        v.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vista_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista_usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Botton_Insertar;
    private javax.swing.JButton Button_Eliminar;
    private javax.swing.JTextField Fechadenacimiento_text;
    private javax.swing.JTextField Plataforma_text;
    private javax.swing.JPanel Usuario;
    private javax.swing.JTextField email_text;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nickname_text;
    private javax.swing.JTextField nombre_text;
    private javax.swing.JTable paraTotalDeUsuarios;
    private javax.swing.JTextField telefono_text;
    // End of variables declaration//GEN-END:variables
}
