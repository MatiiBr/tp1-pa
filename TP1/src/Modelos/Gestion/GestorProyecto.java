/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Gestion;

import Hibernate.GestorHibernate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class GestorProyecto extends GestorHibernate {
       private Proyecto model;
        private GestorTipoProyecto gestorTipoProyecto = new GestorTipoProyecto();
        private GestorCliente gestorCliente = new GestorCliente();
        private GestorPersonal gestorPersonal = new GestorPersonal();
        private GestorPerfil gestorPerfil = new GestorPerfil();

    public GestorPerfil getGestorPerfil() {
        return gestorPerfil;
    }

    public void setGestorPerfil(GestorPerfil gestorPerfil) {
        this.gestorPerfil = gestorPerfil;
    }

    public GestorCliente getGestorCliente() {
        return gestorCliente;
    }

    public void setGestorCliente(GestorCliente gestorCliente) {
        this.gestorCliente = gestorCliente;
    }

    public GestorPersonal getGestorPersonal() {
        return gestorPersonal;
    }

    public void setGestorPersonal(GestorPersonal gestorPersonal) {
        this.gestorPersonal = gestorPersonal;
    }
        
    public GestorTipoProyecto getGestorTipoProyecto() {
        return gestorTipoProyecto;
    }

    public void setGestorTipoProyecto(GestorTipoProyecto gestorTipo) {
        this.gestorTipoProyecto = gestorTipo;
    }
    
    public Proyecto getModel() {
        return model;
    }

    public void setModel(Proyecto model) {
        this.model = model;
    }
    public void newModel() {
         this.setModel(new Proyecto());
    }
    public void guardarObjeto(){
        this.guardarObjeto(this.getModel());
    }
    
     public String getNombre() {
        return this.model.getNombre();
    }

    public void setNombre(String nombre) {
        this.model.setNombre(nombre);
    }

    public Date getFechaEntrega() {
        return this.model.getFechaEntrega();
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.model.setFechaEntrega(fechaEntrega);
    }

    public Date getFechaCarga() {
        return this.model.getFechaCarga();
    }

    public void setFechaCarga(Date fechaCarga) {
        this.model.setFechaCarga(fechaCarga);
    }

    public Date getFechaConfirmacion() {
        return this.model.getFechaConfirmacion();
    }

    public void setFechaConfirmacion(Date fechaConfirmacion) {
        this.model.setFechaConfirmacion(fechaConfirmacion);
    }

    public Date getFechaTerminacion() {
        return this.model.getFechaTerminacion();
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.model.setFechaTerminacion(fechaTerminacion);
    }

    public TipoProyecto getTipoProyecto() {
        return this.model.getTipoProyecto();
    }

    public void setTipoProyecto(TipoProyecto tipoProyecto) {
        this.model.setTipoProyecto(tipoProyecto);
    }
     
     public Proyecto buscarProyectoPorId(Long id) {
        Proyecto proyecto = null;
       try {
          proyecto = this.buscarProyectoPorId(Proyecto.class, id);
       }
       catch(Exception e){
          e.printStackTrace();
       }
       return proyecto;
    }
      public void actualizarObjeto() {
        this.actualizarObjeto(this.getModel());
    }
       
       public void eliminarObjeto(){
        this.eliminarObjeto(this.getModel());
       }
       public DefaultComboBoxModel getComboModelTipoProyecto() {
            return this.getGestorTipoProyecto().getComboModel();
       }
        public DefaultComboBoxModel getComboModelCliente() {
            return this.getGestorCliente().getComboModel();
       }
         public DefaultComboBoxModel getComboModelPersonal() {
            return this.getGestorPersonal().getComboModel();
       }
      
         public List  consultarProyectos() {
            return this.listarClase(Proyecto.class);
        }
         
         public List  consultarProyectos(String nombre, Cliente cliente, TipoProyecto tipoProyecto, Personal personal, Date fechaDesde, Date fechaHasta) {
            return this.buscarProyectos(Proyecto.class, nombre, cliente, tipoProyecto, personal, fechaDesde, fechaHasta);
        }
       
}
