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
         List <Cliente> lista = this.listar();
        if(lista != null){
            for (Cliente auxTipo : lista) {
                auxModel.addElement(auxTipo);
            }
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
    public List consultarClientes(String nombre, String apellido, Date fechaDesde, Date fechaHasta){
       return this.buscarClientes(Cliente.class, nombre, apellido, fechaDesde, fechaHasta);
    }
    public List  consultarClientes() {
        return this.listarClase(Cliente.class);
    }
       
}
