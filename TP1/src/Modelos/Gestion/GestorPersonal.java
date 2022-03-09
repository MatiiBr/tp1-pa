/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Gestion;

import Hibernate.GestorHibernate;
import java.util.Date;
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
      private GestorPerfil gestorPerfil = new GestorPerfil();

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
         List <Personal> lista = this.listar();
        if(lista != null){
            for (Personal auxTipo : lista) {
                auxModel.addElement(auxTipo);
            }
        }
         return auxModel;
    }
     public List<Personal> listar(){   
        return this.listarClase(Personal.class);
    }

    public GestorCargo getGestorCargo() {
        return gestorCargo;
    }

    public void setGestorCargo(GestorCargo gestorCargo) {
        this.gestorCargo = gestorCargo;
    }

    public GestorPerfil getGestorPerfil() {
        return gestorPerfil;
    }

    public void setGestorPerfil(GestorPerfil gestorPerfil) {
        this.gestorPerfil = gestorPerfil;
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
    public List  consultarPersonales() {
        return this.listarClase(Personal.class);
   }
   public List consultarPersonales(String nombre, String apellido, Cargo cargo, Date fechaDesde, Date fechaHasta){
       return this.buscarPersonales(Personal.class, nombre, apellido, cargo, fechaDesde, fechaHasta);
   }
    
}
