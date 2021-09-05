/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Gestion;

import Hibernate.GestorHibernate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
     public List buscarContacto(String nombre) {
        List<Contacto> contactos = new ArrayList();
       try {
          contactos = this.buscarContacto(Contacto.class, nombre);
       }
       catch(Exception e){
          e.printStackTrace();
       }
       return contactos;
    }
       public void actualizarContacto() {
        this.actualizarObjeto(this.getModel());
    }
       
       public void eliminarContacto(){
        this.eliminarObjeto(this.getModel());
       }
}
     
    
