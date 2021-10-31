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
         List <TipoProyecto> lista = this.listar();
        if(lista != null){
            for (TipoProyecto auxTipo : lista) {
                auxModel.addElement(auxTipo);
            }
        }
         return auxModel;
    }
     public List <TipoProyecto> listar(){   
        return this.listarClase(TipoProyecto.class);
    }
    public void guardarObjeto(){
        this.guardarObjeto(this.getModel());
    }
    public void actualizarObjeto() {
        this.actualizarObjeto(this.getModel());
    }

    public void eliminarObjeto() {
        this.eliminarObjeto(this.getModel());
    }

    public TipoProyecto buscarTipoProyecto(String nombre) {
       TipoProyecto tipoProyecto = null;
       try {
          tipoProyecto = this.buscarTipoProyecto(TipoProyecto.class, nombre);
       }
       catch(Exception e){
          e.printStackTrace();
       }
       return tipoProyecto;
    }
}
