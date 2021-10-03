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
public class GestorTipoProyecto extends  GestorHibernate{
     private TipoProyecto  model;

    public TipoProyecto  getModel() {
        return model;
    }
    public void newModel() {
         this.setModel(new TipoProyecto());
    }
    public void setModel(TipoProyecto  tipoProyecto) {
        this.model = tipoProyecto;
    }
    public DefaultComboBoxModel getComboModel() {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (TipoProyecto auxTipo : this.listar()) {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }
     public List <TipoProyecto> listar(){   
        return this.listarClase(TipoProyecto.class);
    }
}
