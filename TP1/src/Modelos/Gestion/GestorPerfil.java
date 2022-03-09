/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Gestion;

import Hibernate.GestorHibernate;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Usuario
 */
public class GestorPerfil extends  GestorHibernate{
     private Perfil  model;

    public Perfil  getModel() {
        return model;
    }
    public void newModel() {
         this.setModel(new Perfil());
    }
    public void setModel(Perfil  perfil) {
        this.model = perfil;
    }
    public DefaultComboBoxModel getComboModel() {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Perfil auxPerfil : this.listar()) {
            auxModel.addElement(auxPerfil);
        }
         return auxModel;
    }
     public List <Perfil> listar(){   
        return this.listarClase(Perfil.class);
    }
    public void guardarObjeto(){
        this.guardarObjeto(this.getModel());
    }
    public void actualizarObjeto() {
        this.actualizarObjeto(this.getModel());
    }

    public void eliminarObjeto() {
        this.eliminarObjeto(this.getModel());
    }
    
    public List<Perfil> buscarPerfiles(){
        return this.listarClase(Perfil.class);
    }
    
    public Perfil buscarPerfil(String nombre) {
       Perfil perfil = null;
       try {
          perfil = this.buscarPerfil(Perfil.class, nombre);
       }
       catch(Exception e){
          e.printStackTrace();
       }
       return perfil;
    }
    public List consultarPerfiles(String nombre, String descripcion){
       return this.buscarPerfiles(Perfil.class, nombre, descripcion);
   }
   public List  consultarPerfiles() {
        return this.listarClase(Perfil.class);
   }
}
