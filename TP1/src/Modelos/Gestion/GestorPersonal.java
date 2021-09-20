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
public class GestorPersonal extends GestorHibernate {
     private Personal  model;

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
}
