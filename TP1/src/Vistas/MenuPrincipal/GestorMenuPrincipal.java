/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.MenuPrincipal;

import Vistas.Cliente.GestorVistaCliente;
import Vistas.Contacto.GestorVistaContacto;
import Vistas.Personal.GestorVistaPersonal;
import Vistas.Proyecto.GestorVistaProyecto;
import Vistas.TipoProyecto.GestorVistaTipoProyecto;
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
        GestorVistaContacto gestorVistaContacto= new GestorVistaContacto();
        gestorVistaContacto.openFormulario(escritorio, gestorVistaContacto);
     }
     
     public void abrirProyecto(JDesktopPane escritorio){
         GestorVistaProyecto gestorVistaProyecto= new GestorVistaProyecto();
        gestorVistaProyecto.openFormulario(escritorio, gestorVistaProyecto);
     }
     public void abrirCliente(JDesktopPane escritorio){
         GestorVistaCliente gestorVistaCliente= new GestorVistaCliente();
        gestorVistaCliente.openFormulario(escritorio, gestorVistaCliente);
     }
     public void abrirPersonal(JDesktopPane escritorio){
         GestorVistaPersonal gestorVistaPersonal= new GestorVistaPersonal();
        gestorVistaPersonal.openFormulario(escritorio, gestorVistaPersonal);
     }
     public void abrirTipoProyecto(JDesktopPane escritorio){
         GestorVistaTipoProyecto gestorVistaTipoProyecto= new GestorVistaTipoProyecto();
        gestorVistaTipoProyecto.openFormulario(escritorio, gestorVistaTipoProyecto);
     }
}
