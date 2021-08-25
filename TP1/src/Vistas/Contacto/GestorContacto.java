/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Contacto;

import javax.swing.JDesktopPane;

/**
 *
 * @author Usuario
 */
public class GestorContacto {
    private JDesktopPane escritorio;
    FrmContacto form;  
    
    public GestorContacto() {
    }
     
    public void openFormulario(JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmContacto());
        //this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(form);
        this.getForm().setVisible(true);
    }
    
    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }
    
     public FrmContacto getForm() {
        return form;
    }

    public void setForm(FrmContacto form) {
        this.form = form;
    }
}
