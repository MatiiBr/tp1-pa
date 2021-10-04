/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Personal;

import Modelos.Gestion.Cargo;
import Modelos.Gestion.GestorPersonal;
import Modelos.Gestion.Personal;
import Util.UtilJtable;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;

/**
 *
 * @author Usuario
 */
public class GestorVistaPersonal {
    private JDesktopPane escritorio;
    FrmPersonal form;  
    private GestorPersonal gestor; 
     private UtilJtable UtilTable= new UtilJtable();
    
    public UtilJtable getUtilTable() {
        return UtilTable;
    }

    public void setUtilTable(UtilJtable UtilTable) {
        this.UtilTable = UtilTable;
    }
    
    public GestorVistaPersonal() {
    }
        public void newModel() {
            this.getGestor().newModel();
    }
        
     public Personal getModel() {
        return this.getGestor().getModel();
    }
     
     public void setModel(){
          this.getModel().setNombre(this.getForm().getTxtNombre().getText().toUpperCase());
          this.getModel().setApellido(this.getForm().getTxtApellido().getText().toUpperCase());
          this.getModel().setFechaNacimiento(this.getForm().getInpFechaNacimiento().getDate());
           this.getModel().setCargo((Cargo) this.getForm().getCboCargo().getSelectedItem());
    }
    
    public void setModel(Personal model) {
        this.getGestor().setModel(model);
    }
     
    public void openFormulario(JDesktopPane pantalla, GestorVistaPersonal gestor) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmPersonal(gestor));
        this.getEscritorio().add(form);
        this.getForm().setVisible(true);
    }
    
    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

     public FrmPersonal getForm() {
        return form;
    }
      public void setForm(FrmPersonal form) {
        this.form = form;
    }
    
    public GestorPersonal getGestor() {
        if (gestor == null) {
           synchronized (GestorPersonal.class) {
                gestor = new GestorPersonal();
           }
        }
        return gestor;
    }
    public void setGestor(GestorPersonal gestor) {
        this.gestor = gestor;
    }
    public void guardarPersonal(){
        this.setModel();
        this.getGestor().guardarObjeto();
    }
    
   public void actualizarPersonal(){
       this.setModel();
       this.getGestor().actualizarObjeto();
   }
    
     public boolean buscarPersonal(String nombre) {
        Personal personal;
        personal=this.getGestor().buscarPersonal(nombre);
         if(personal!=null){
              this.setModel(personal);
              this.cargarPersonal(personal);
         }else{
             return false;
         }
         return true;
    }
    
     public void cargarPersonal(Personal personal){
         this.getForm().cargarPersonal(personal);
     }
    
    public void eliminarPersonal(){
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
         if(this.getForm().getCboCargo().getSelectedIndex()==0 || this.getForm().getCboCargo().getSelectedIndex()==-1){
             System.out.println(this.getForm().getCboCargo().getSelectedIndex());
             mensaje +="\n - Debe seleccionar un Cargo.";
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
    public void setModelCargo(JComboBox cboCargo) {
       cboCargo.setModel(getGestor().getComboModelCargo());
    }
}
