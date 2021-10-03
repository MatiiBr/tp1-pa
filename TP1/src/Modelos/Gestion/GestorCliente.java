/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Gestion;

import Hibernate.GestorHibernate;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Usuario
 */
public class GestorCliente extends GestorHibernate {
    private Cliente model;

    public Cliente  getModel() {
        return model;
    }
    public void newModel() {
         this.setModel(new Cliente());
    }
    public void setModel(Cliente cliente) {
        this.model = cliente;
    }
    public DefaultComboBoxModel getComboModel() {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Cliente auxTipo : this.listar()) {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }
     public List <Cliente> listar(){   
        return this.listarClase(Cliente.class);
    }
     public Cliente buscarCliente(String nombre) {
        Cliente cliente = null;
       try {
          cliente = this.buscarCliente(Cliente.class, nombre);
       }
       catch(Exception e){
          e.printStackTrace();
       }
       return cliente;
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
       
}
