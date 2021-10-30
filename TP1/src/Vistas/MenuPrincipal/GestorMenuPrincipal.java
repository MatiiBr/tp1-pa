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
import Vistas.Perfil.GestorVistaPerfil;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

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
          if(this.estaCerrada(escritorio, "Contacto")){
        GestorVistaContacto gestorVistaContacto= new GestorVistaContacto();
        gestorVistaContacto.openFormulario(escritorio, gestorVistaContacto);
         }else{
               this.mostrarMensajeVentanaAbierta("Contacto");
          }
         
     }
     
     public void abrirProyecto(JDesktopPane escritorio){
        if(this.estaCerrada(escritorio, "Proyecto")){
          GestorVistaProyecto gestorVistaProyecto= new GestorVistaProyecto();
          gestorVistaProyecto.openFormulario(escritorio, gestorVistaProyecto);
         }else{
               this.mostrarMensajeVentanaAbierta("Proyecto");
          }
     }
     public void abrirCliente(JDesktopPane escritorio){
         if(this.estaCerrada(escritorio, "Cliente")){
             GestorVistaCliente gestorVistaCliente= new GestorVistaCliente();
            gestorVistaCliente.openFormulario(escritorio, gestorVistaCliente);
         }else{
               this.mostrarMensajeVentanaAbierta("Cliente");
          }
     }
     public void abrirPersonal(JDesktopPane escritorio){
         if(this.estaCerrada(escritorio, "Personal")){
            GestorVistaPersonal gestorVistaPersonal= new GestorVistaPersonal();
            gestorVistaPersonal.openFormulario(escritorio, gestorVistaPersonal);
         }else{
               this.mostrarMensajeVentanaAbierta("Personal");
          }
     }
     public void abrirTipoProyecto(JDesktopPane escritorio){
         if(this.estaCerrada(escritorio, "Tipo de Proyecto")){
            GestorVistaPerfil gestorVistaTipoProyecto= new GestorVistaPerfil();
            gestorVistaTipoProyecto.openFormulario(escritorio, gestorVistaTipoProyecto);
         }else{
               this.mostrarMensajeVentanaAbierta("Tipo de Proyecto");
          }
     }

    public boolean estaCerrada(JDesktopPane escritorio, String nuevoFrame) {
        System.out.println(escritorio.getAllFrames());
        JInternalFrame[] frames = escritorio.getAllFrames();
        for(int i=0;i<frames.length;i++){
            System.out.println(frames[i].getTitle());
            if(frames[i].getTitle() == nuevoFrame){
                return false;
            }
        }
        return true;
    }
    
    public void mostrarMensajeVentanaAbierta(String msg){
        JOptionPane.showMessageDialog(null, "La ventana "+msg+" ya esta abierta");
    }

    public void abrirPerfil(JDesktopPane escritorio) {
        if(this.estaCerrada(escritorio, "Tipo de Proyecto")){
            GestorVistaPerfil gestorVistaTipoProyecto= new GestorVistaPerfil();
            gestorVistaTipoProyecto.openFormulario(escritorio, gestorVistaTipoProyecto);
         }else{
               this.mostrarMensajeVentanaAbierta("Tipo de Proyecto");
         }
    }
}
