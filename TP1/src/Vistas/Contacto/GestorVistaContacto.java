/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Contacto;

import Modelos.Contacto.GestorContacto;
import javax.swing.JDesktopPane;

/**
 *
 * @author Usuario
 */
public class GestorVistaContacto {
    private JDesktopPane escritorio;
    FrmContacto form;  
    private GestorContacto gestor;  
    
    public GestorVistaContacto() {
    }
     
    public void openFormulario(JDesktopPane pantalla, GestorVistaContacto gestor) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmContacto(gestor));
        this.getEscritorio().add(form);
        this.getForm().setVisible(true);
    }
    
    public JDesktopPane getEscritorio() {
        return escritorio;
    }
    public void newModel() {
            this.getGestor().newModel();
    }
    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }
    
     public FrmContacto getForm() {
        return form;
    }

    public void setGestor(GestorContacto gestor) {
        this.gestor = gestor;
    }
    public void setForm(FrmContacto form) {
        this.form = form;
    }
    public void setModel(){
          this.getGestor().setNombre(this.getForm().getTxtNombre().getText());
          this.getGestor().setApellido(this.getForm().getTxtApellido().getText());
          this.getGestor().setEdad(this.getForm().getTxtEdad().getText());
          
    }
    public void guardarContacto(){
        this.setModel();
        this.getGestor().guardarObjeto();
    }
    
    public GestorContacto getGestor() {
        if (gestor == null) {
           synchronized (GestorContacto.class) {
                gestor = new GestorContacto();
           }
        }
        return gestor;
    }
}
