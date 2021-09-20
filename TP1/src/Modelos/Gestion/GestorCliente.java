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
}
