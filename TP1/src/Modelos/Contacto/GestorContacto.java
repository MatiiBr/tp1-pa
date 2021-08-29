/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Contacto;

import Hibernate.GestorHibernate;

/**
 *
 * @author Usuario
 */
public class GestorContacto extends GestorHibernate {
     private Contacto model;

    public Contacto  getModel() {
        return model;
    }

    public void setModel(Contacto  contacto) {
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
    public void setEdad(String edad){
        this.model.setEdad(edad);
    }
    
    public String getNombre(){
       return this.model.getNombre();
    }
    public String getApellido(){
       return this.model.getApellido();
    }
    public String getEdad(){
       return this.model.getEdad();
    }
    
}
