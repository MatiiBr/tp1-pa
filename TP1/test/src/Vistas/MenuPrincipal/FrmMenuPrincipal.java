/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.MenuPrincipal;

import javax.swing.JDesktopPane;

/**
 *
 * @author Usuario
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {

    public GestorMenuPrincipal gestorMenuPrincipal;

    /**
     * Creates new form FrmMenuPrincipal
     */
    public FrmMenuPrincipal() {
        initComponents();
    }

    public FrmMenuPrincipal(GestorMenuPrincipal aThis) {
        initComponents();
        gestorMenuPrincipal = aThis;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        barraMenuPrincipal = new javax.swing.JMenuBar();
        menuMenu = new javax.swing.JMenu();
        menuItemContacto = new javax.swing.JMenuItem();
        menuItemCliente = new javax.swing.JMenuItem();
        menuItemPersonal = new javax.swing.JMenuItem();
        menuItemPerfil = new javax.swing.JMenuItem();
        menuItemPosts = new javax.swing.JMenuItem();
        menuItemProyecto = new javax.swing.JMenuItem();
        menuItemTipoProyecto = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1728, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 964, Short.MAX_VALUE)
        );

        menuMenu.setText("Menu");

        menuItemContacto.setText("Contacto");
        menuItemContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemContactoActionPerformed(evt);
            }
        });
        menuMenu.add(menuItemContacto);

        menuItemCliente.setText("Cliente");
        menuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemClienteActionPerformed(evt);
            }
        });
        menuMenu.add(menuItemCliente);

        menuItemPersonal.setText("Personal");
        menuItemPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPersonalActionPerformed(evt);
            }
        });
        menuMenu.add(menuItemPersonal);

        menuItemPerfil.setText("Perfil");
        menuItemPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPerfilActionPerformed(evt);
            }
        });
        menuMenu.add(menuItemPerfil);

        menuItemPosts.setText("Posts");
        menuItemPosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPostsActionPerformed(evt);
            }
        });
        menuMenu.add(menuItemPosts);

        menuItemProyecto.setText("Proyecto");
        menuItemProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProyectoActionPerformed(evt);
            }
        });
        menuMenu.add(menuItemProyecto);

        menuItemTipoProyecto.setText("Tipo Proyecto");
        menuItemTipoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTipoProyectoActionPerformed(evt);
            }
        });
        menuMenu.add(menuItemTipoProyecto);

        barraMenuPrincipal.add(menuMenu);

        setJMenuBar(barraMenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemContactoActionPerformed
        this.gestorMenuPrincipal.abrirContacto(getEscritorio());
    }//GEN-LAST:event_menuItemContactoActionPerformed

    private void menuItemProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProyectoActionPerformed
      this.gestorMenuPrincipal.abrirProyecto(getEscritorio());
    }//GEN-LAST:event_menuItemProyectoActionPerformed

    private void menuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemClienteActionPerformed
        this.gestorMenuPrincipal.abrirCliente(getEscritorio());
    }//GEN-LAST:event_menuItemClienteActionPerformed

    private void menuItemPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPersonalActionPerformed
        this.gestorMenuPrincipal.abrirPersonal(getEscritorio());
    }//GEN-LAST:event_menuItemPersonalActionPerformed

    private void menuItemTipoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTipoProyectoActionPerformed
       this.gestorMenuPrincipal.abrirTipoProyecto(getEscritorio());
    }//GEN-LAST:event_menuItemTipoProyectoActionPerformed

    private void menuItemPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPerfilActionPerformed
        this.gestorMenuPrincipal.abrirPerfil(getEscritorio());
    }//GEN-LAST:event_menuItemPerfilActionPerformed

    private void menuItemPostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPostsActionPerformed
        this.gestorMenuPrincipal.abrirPosts(getEscritorio());
    }//GEN-LAST:event_menuItemPostsActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenuPrincipal;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem menuItemCliente;
    private javax.swing.JMenuItem menuItemContacto;
    private javax.swing.JMenuItem menuItemPerfil;
    private javax.swing.JMenuItem menuItemPersonal;
    private javax.swing.JMenuItem menuItemPosts;
    private javax.swing.JMenuItem menuItemProyecto;
    private javax.swing.JMenuItem menuItemTipoProyecto;
    private javax.swing.JMenu menuMenu;
    // End of variables declaration//GEN-END:variables

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

   
}
