/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Contacto;

import Modelos.Gestion.Contacto;
import Modelos.Gestion.GestorContacto;
import Util.UtilJtable;
import java.util.Date;
import javax.swing.JDesktopPane;
import javax.swing.JTable;

/**
 *
 * @author Usuario
 */
public class GestorVistaContacto {
    private JDesktopPane escritorio;
    FrmContacto form;  
    private GestorContacto gestor; 
     private UtilJtable UtilTable= new UtilJtable();
    
    public UtilJtable getUtilTable() {
        return UtilTable;
    }

    public void setUtilTable(UtilJtable UtilTable) {
        this.UtilTable = UtilTable;
    }
    
    public GestorVistaContacto() {
    }
        public void newModel() {
            this.getGestor().newModel();
    }
        
     public Contacto getModel() {
        return this.getGestor().getModel();
    }
     
     public void setModel(){
          this.getModel().setNombre(this.getForm().getTxtNombre().getText());
          this.getModel().setApellido(this.getForm().getTxtApellido().getText());
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
       this.getGestor().actualizarObjeto();
   }
    
     public boolean buscarContacto(String nombre) {
        Contacto contacto;
        contacto=this.getGestor().buscarContacto(nombre);
         if(contacto!=null){
              this.setModel(contacto);
              this.cargarContacto(contacto);
         }else{
             return false;
         }
         return true;
    }
    
     public void cargarContacto(Contacto contacto){
         this.getForm().cargarContacto(contacto);
     }
    
    public void eliminarContacto(){
        this.getGestor().eliminarObjeto();
    }
    public String revisarFormulario(){
        String mensaje = "";
         if(this.getForm().getTxtNombre().getText().isEmpty()){
             this.getForm().getLblNombreRequerido().setText("Requerido.");
             mensaje +="\n - El campo Nombre no puede estar vacio.";
             this.getForm().setFormValido(false);
         }
         if(this.getForm().getTxtApellido().getText().isEmpty()){
             this.getForm().getLblApellidoRequerido().setText("Requerido.");
             mensaje +="\n - El campo Apellido no puede estar vacio.";
             this.getForm().setFormValido(false);
         }
         if(this.getForm().getInpFechaNacimiento().getDate()==null){
             this.getForm().getLblFechaNacimientoRequerido().setText("Requerido.");
             mensaje +="\n - El campo Fecha de Nacimiento no puede estar vacio.";
             this.getForm().setFormValido(false);
         }else if(!verificarEdad()){
              mensaje +="\n - La edad debe ser mayor o igual a 18 años.";
             this.getForm().setFormValido(false);
         }
         return mensaje;
     }
     public boolean verificarEdad(){
         var date = new Date();
         int edad = 0;
         if (this.getForm().getInpFechaNacimiento().getDate().getYear() < date.getYear()) {
           edad = (date.getYear()) - (this.getForm().getInpFechaNacimiento().getDate().getYear());
           if(this.getForm().getInpFechaNacimiento().getDate().getMonth() > date.getMonth() ) {
               edad--;
           } else if(this.getForm().getInpFechaNacimiento().getDate().getMonth() == date.getMonth()) {
               if(this.getForm().getInpFechaNacimiento().getDate().getDate() > date.getDate() ) {
                   edad--;
               }
           }
         }
         return edad>=18;
     }
}
