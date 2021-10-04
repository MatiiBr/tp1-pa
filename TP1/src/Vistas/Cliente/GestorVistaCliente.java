/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Cliente;

import Modelos.Gestion.Cargo;
import Modelos.Gestion.Cliente;
import Modelos.Gestion.GestorCliente;
import Util.UtilJtable;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;

/**
 *
 * @author Usuario
 */
public class GestorVistaCliente {
    private JDesktopPane escritorio;
    FrmCliente form;  
    private GestorCliente gestor; 
     private UtilJtable UtilTable= new UtilJtable();
    
    public UtilJtable getUtilTable() {
        return UtilTable;
    }

    public void setUtilTable(UtilJtable UtilTable) {
        this.UtilTable = UtilTable;
    }
    
    public GestorVistaCliente() {
    }
        public void newModel() {
            this.getGestor().newModel();
    }
        
     public Cliente getModel() {
        return this.getGestor().getModel();
    }
     
     public void setModel(){
          this.getModel().setNombre(this.getForm().getTxtNombre().getText().toUpperCase());
          this.getModel().setApellido(this.getForm().getTxtApellido().getText().toUpperCase());
          this.getModel().setFechaNacimiento(this.getForm().getInpFechaNacimiento().getDate());
    }
    
    public void setModel(Cliente model) {
        this.getGestor().setModel(model);
    }
     
    public void openFormulario(JDesktopPane pantalla, GestorVistaCliente gestor) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmCliente(gestor));
        this.getEscritorio().add(form);
        this.getForm().setVisible(true);
    }

    
    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

     public FrmCliente getForm() {
        return form;
    }
      public void setForm(FrmCliente form) {
        this.form = form;
    }
    
    public GestorCliente getGestor() {
        if (gestor == null) {
           synchronized (GestorCliente.class) {
                gestor = new GestorCliente();
           }
        }
        return gestor;
    }
    public void setGestor(GestorCliente gestor) {
        this.gestor = gestor;
    }
    public void guardarCliente(){
        this.setModel();
        this.getGestor().guardarObjeto();
    }
    
   public void actualizarCliente(){
       this.setModel();
       this.getGestor().actualizarObjeto();
   }
    
     public boolean buscarCliente(String nombre) {
        Cliente cliente;
        cliente=this.getGestor().buscarCliente(nombre);
         if(cliente!=null){
              this.setModel(cliente);
              this.cargarCliente(cliente);
         }else{
             return false;
         }
         return true;
    }
    
     public void cargarCliente(Cliente cliente){
         this.getForm().cargarCliente(cliente);
     }
    
    public void eliminarCliente(){
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
