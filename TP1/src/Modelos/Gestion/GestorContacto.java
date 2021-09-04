/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Gestion;

import Hibernate.GestorHibernate;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class GestorContacto extends GestorHibernate {
     private Contacto model;

    public Contacto  getModel() {
        return model;
    }

    public void setModel(Contacto contacto) {
        this.model = contacto;
    }
     public void newModel() {
         this.setModel(new Contacto());
    }
     
    public void guardarObjeto(){
        this.guardarObjeto(this.getModel());
    }
    
    public void setNombre(String nombre){
        this.model.setNombre(nombre);
    }
    public void setApellido(String apellido){
        this.model.setApellido(apellido);
    }
    public void setFechaNacimiento(Date fechaNacimiento){
        this.model.setFechaNacimiento(fechaNacimiento);
    }
    
    public String getNombre(){
       return this.model.getNombre();
    }
    public String getApellido(){
       return this.model.getApellido();
    }
    public Date getFechaNacimiento(){
       return this.model.getFechaNacimiento();
    }
     public Contacto buscarContacto(String nombre) {
        Contacto  contacto=null;
       try {
          contacto = (Contacto) this.buscarContacto(Contacto.class, nombre);
          return contacto;
       }
       catch(Exception e){
          return contacto;
       }
    }
       public void actualizarContacto() {
        this.actualizarObjeto(this.getModel());
    }
       
       public void eliminarContacto(){
        this.eliminarObjeto(this.getModel());
       }
}
     
    
