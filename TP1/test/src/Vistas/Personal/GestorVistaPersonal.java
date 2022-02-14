/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Personal;

import Modelos.Gestion.Cargo;
import Modelos.Gestion.GestorPersonal;
import Modelos.Gestion.Perfil;
import Modelos.Gestion.Personal;
import Util.UtilJtable;
import Vistas.MenuPrincipal.GestorMenuPrincipal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JList;

/**
 *
 * @author Usuario
 */
public class GestorVistaPersonal {
    private JDesktopPane escritorio;
    FrmPersonal form;  
    private GestorPersonal gestor; 
    private GestorMenuPrincipal gestorMenu;
    private UtilJtable UtilTable= new UtilJtable();
    private DefaultListModel modeloListaDerecha= new DefaultListModel();
    private DefaultListModel modeloListaIzquierda= new DefaultListModel();
    
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
//          this.getModel().setCargo((Cargo) this.getForm().getCboCargo().getSelectedItem());
          this.getModel().setCargo(new Cargo());
          this.getModel().setPerfiles((List<Perfil>) this.getForm().getListPerfilesDer().getModel());
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
    public GestorMenuPrincipal getGestorMenu() {
        if (gestorMenu == null) {
           synchronized (GestorMenuPrincipal.class) {
                gestorMenu = new GestorMenuPrincipal();
           }
        }
        return gestorMenu;
    }
    public void setGestorMenu(GestorMenuPrincipal gestorMenu) {
        this.gestorMenu = gestorMenu;
    }
    public void nuevoPerfil() {
        this.getGestorMenu().abrirPerfil(this.getEscritorio());
    }
    public void buscarPerfiles(JList lista) {
        this.modeloListaIzquierda = new DefaultListModel();
        lista.setModel(this.crearModelo(this.getGestor().buscarPerfiles(),this.modeloListaIzquierda));
    }
    public void limpiarPerfiles(JList lista){
        this.modeloListaDerecha = new DefaultListModel();
        lista.setModel(this.modeloListaDerecha);
    }
    public void moverPerfilesDer(List listaPerfiles, JList listaDer, JList listaIzq) {
        listaDer.setModel(this.crearModelo(listaPerfiles,this.modeloListaDerecha));
        listaIzq.setModel(this.removerPerfiles(listaPerfiles, this.modeloListaIzquierda));
    }
    public void moverPerfilesIzq(List listaPerfiles, JList listaIzq, JList listaDer) {
        listaIzq.setModel(this.crearModelo(listaPerfiles,this.modeloListaIzquierda));
        listaDer.setModel(this.removerPerfiles(listaPerfiles, this.modeloListaDerecha));
    }
    public DefaultListModel crearModelo(List perfiles, DefaultListModel modelo){
        if (perfiles!=null) {
            for (Iterator it = perfiles.iterator(); it.hasNext();) {
                Perfil perfil = (Perfil) it.next();
                 modelo.addElement(perfil);
            }
        }
        return modelo;
    }
    
    public DefaultListModel removerPerfiles(List perfiles, DefaultListModel modelo){
        for (Iterator it = perfiles.iterator(); it.hasNext();) {
                Perfil perfil = (Perfil) it.next();
                 modelo.removeElement(perfil);
            }
        return modelo;
    }
}
