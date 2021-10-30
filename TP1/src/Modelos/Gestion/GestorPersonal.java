/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Gestion;

import Hibernate.GestorHibernate;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Usuario
 */
public class GestorPersonal extends GestorHibernate {
     private Personal  model;
      private GestorCargo gestorCargo = new GestorCargo();

    public Personal  getModel() {
        return model;
    }
    public void newModel() {
         this.setModel(new Personal());
    }
    public void setModel(Personal personal) {
        this.model = personal;
    }
    public DefaultComboBoxModel getComboModel() {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Personal auxTipo : this.listar()) {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }
     public List <Personal> listar(){   
        return this.listarClase(Personal.class);
    }

    public GestorCargo getGestorCargo() {
        return gestorCargo;
    }

    public void setGestorCargo(GestorCargo gestorCargo) {
        this.gestorCargo = gestorCargo;
    }
     
      public void guardarObjeto(){
        this.guardarObjeto(this.getModel());
    }
      public void actualizarObjeto() {
        this.actualizarObjeto(this.getModel());
    }
       
       public void eliminarObjeto(){
        this.eliminarObjeto(this.getModel());
       }
       
       public Personal buscarPersonal(String nombre) {
        Personal personal = null;
       try {
          personal = this.buscarPersonal(Personal.class, nombre);
       }
       catch(Exception e){
          e.printStackTrace();
       }
       return personal;
    }
       
       public DefaultComboBoxModel getComboModelCargo() {
            return this.getGestorCargo().getComboModel();
       }
    public DefaultListModel buscarPerfiles(){
        List perfiles = this.listarClase(Perfil.class);
        if (perfiles!=null) {
            DefaultListModel modelo = new DefaultListModel();
            String[] registros = new String[1];
            for (Iterator it = perfiles.iterator(); it.hasNext();) {
                Perfil perfil = (Perfil) it.next();
                 registros[0] = perfil.getNombre();
                 modelo.addElement(registros);
            }
            return modelo;    
        }
        return null;
    }
}
