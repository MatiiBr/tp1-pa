/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Contacto;

import Modelos.Gestion.Contacto;
import Modelos.Gestion.GestorContacto;
import java.util.List;
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
        public void newModel() {
            this.getGestor().newModel();
    }
        
     public Contacto getModel() {
        return this.getGestor().getModel();
    }
     
     public void setModel(){
          this.getModel().setNombre(this.getForm().getTxtNombre().getText().toUpperCase());
          this.getModel().setApellido(this.getForm().getTxtApellido().getText().toUpperCase());
          this.getModel().setFechaNacimiento(this.getForm().getInpFechaNacimiento().getDate());
    }
    
    public void setModel(Contacto model) {
        this.getGestor().setModel(model);
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

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

     public FrmContacto getForm() {
        return form;
    }
      public void setForm(FrmContacto form) {
        this.form = form;
    }
    
    public GestorContacto getGestor() {
        if (gestor == null) {
           synchronized (GestorContacto.class) {
                gestor = new GestorContacto();
           }
        }
        return gestor;
    }
    public void setGestor(GestorContacto gestor) {
        this.gestor = gestor;
    }
    public void guardarContacto(){
        this.setModel();
        this.getGestor().guardarObjeto();
    }
    
   public void actualizarContacto(){
       this.setModel();
       this.getGestor().actualizarContacto();
   }
    
     public List buscarContacto(String nombre) {
        List<Contacto> contactos = this.getGestor().buscarContacto(nombre);
        return contactos;
        /*// TO DO: Validacion de contacto
        this.setModel(contacto);
        this.cargarContacto(contacto);*/
    }
    
     public void cargarContacto(Contacto contacto){
         this.getForm().cargarContacto(contacto);
     }
    
    public void eliminarContacto(){
        this.getGestor().eliminarContacto();
    }
}
