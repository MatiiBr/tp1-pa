/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Perfil;

import Modelos.Gestion.GestorPerfil;
import Modelos.Gestion.Perfil;
import Util.UtilJtable;
import javax.swing.JDesktopPane;

/**
 *
 * @author Pedro
 */
public class GestorVistaPerfil {
    private JDesktopPane escritorio;
    private boolean actualizacion;
    FrmPerfil form;  
    private GestorPerfil gestor; 
    private UtilJtable UtilTable= new UtilJtable();
    
    public String revisarFormulario(){
        String mensaje = "";
        if(this.getForm().getTxtNombre().getText().isEmpty()){
             this.getForm().setFormValido(false);
             this.getForm().getLblNombreRequerido().setText("Requerido.");
             mensaje +="\n - El campo Nombre no puede estar vacio.";
         }
        return mensaje;
    }
    public FrmPerfil getForm() {
        return form;
    }

    public void guardarPerfil() {
        this.setActualizacion(false);
        this.setModel();
        this.getGestor().guardarObjeto();
    }

    private void setActualizacion(boolean b) {
        this.actualizacion = b;
    }

    private void setModel() {
        this.getModel().setNombre(this.getForm().getTxtNombre().getText().toUpperCase());
        this.getModel().setDescripcion(this.getForm().getjTxtDescripcion().getText().toUpperCase());
    }
    private GestorPerfil getGestor() {
        if (gestor == null) {
           synchronized (GestorPerfil.class) {
                gestor = new GestorPerfil();
           }
        }
        return gestor;
    }
    private Perfil getModel() {
        return this.getGestor().getModel();
    }
    
    public void actualizarPerfil() {
       this.setActualizacion(true);
       this.setModel();
       this.getGestor().actualizarObjeto();
    }

    public void eliminarPerfil() {
        this.getGestor().eliminarObjeto();
    }

    public boolean buscarPerfil(String nombre) {
        Perfil perfil;
        perfil = this.getGestor().buscarPerfil(nombre);
         if(perfil!=null){
              this.setModel(perfil);
              this.cargarPerfil(perfil);
         }else{
             return false;
         }
         return true;
    }

    private void setModel(Perfil model) {
        this.getGestor().setModel(model);
    }

    private void cargarPerfil(Perfil perfil) {
        this.getForm().cargarPerfil(perfil);
    }

    public void openFormulario(JDesktopPane pantalla, GestorVistaPerfil gestor) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmPerfil(gestor));
        this.getEscritorio().add(form);
        this.getForm().setVisible(true);
    }
    
    private void setEscritorio(JDesktopPane pantalla) {
        this.escritorio = pantalla;
    }

    private void setForm(FrmPerfil form) {
        this.form = form;
    }

    private JDesktopPane getEscritorio() {
        return this.escritorio;
    }

    public void newModel() {
        this.getGestor().newModel();
    }

    public String save(String accion) {
        String dialog="";
        if("Guardar".equals(accion)){
              this.guardarPerfil();
              dialog = "Perfil guardado exitosamente.";
         }else{
            this.actualizarPerfil();
            dialog = "Perfil actualizado exitosamente.";
         } 
        return dialog;
    }
}