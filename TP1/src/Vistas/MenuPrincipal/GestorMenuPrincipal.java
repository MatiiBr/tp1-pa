/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.MenuPrincipal;

import Vistas.Contacto.GestorContacto;
import javax.swing.JDesktopPane;

/**
 *
 * @author Usuario
 */
public class GestorMenuPrincipal {
     public void iniciarMenu() {
        FrmMenuPrincipal frmMenuPrincipal = new FrmMenuPrincipal(this);
        frmMenuPrincipal.setVisible(true);
        
    }
     
     public void abrirContacto(JDesktopPane escritorio){
        GestorContacto gestorContacto= new GestorContacto();
        gestorContacto.openFormulario(escritorio);
     }
}
