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
public class GestorCargo extends  GestorHibernate {
     private Cargo  model;

    public Cargo  getModel() {
        return model;
    }
    public void newModel() {
         this.setModel(new Cargo());
    }
    public void setModel(Cargo  tipoProyecto) {
        this.model = tipoProyecto;
    }
    public DefaultComboBoxModel getComboModel() {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Cargo auxTipo : this.listar()) {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }
     public List <Cargo> listar(){   
        return this.listarClase(Cargo.class);
    }
}
