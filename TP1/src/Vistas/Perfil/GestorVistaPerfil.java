/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Perfil;

import Modelos.Gestion.Contacto;
import Modelos.Gestion.GestorPerfil;
import Modelos.Gestion.Perfil;
import Modelos.Gestion.Proyecto;
import Util.UtilJtable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pedro
 */
public class GestorVistaPerfil {
    private JDesktopPane escritorio;
    private boolean actualizacion;
    FrmPerfil form;  
    private GestorPerfil gestor; 
    private UtilJtable UtilTable= new UtilJtable();
    
    public String revisarFormulario(){
        String mensaje = "";
        if(this.getForm().getTxtNombre().getText().isEmpty()){
             this.getForm().setFormValido(false);
             this.getForm().getLblNombreRequerido().setText("Requerido.");
             mensaje +="\n - El campo Nombre no puede estar vacio.";
         }
        return mensaje;
    }
    public FrmPerfil getForm() {
        return form;
    }

    public void guardarPerfil() {
        this.setActualizacion(false);
        this.setModel();
        this.getGestor().guardarObjeto();
        this.getGestor().newModel();
        this.cargarTabla(this.getForm().getTblPerfil());
    }

    private void setActualizacion(boolean b) {
        this.actualizacion = b;
    }

    private void setModel() {
        this.getModel().setNombre(this.getForm().getTxtNombre().getText().toUpperCase());
        this.getModel().setDescripcion(this.getForm().getjTxtDescripcion().getText().toUpperCase());
    }
    private GestorPerfil getGestor() {
        if (gestor == null) {
           synchronized (GestorPerfil.class) {
                gestor = new GestorPerfil();
           }
        }
        return gestor;
    }
    private Perfil getModel() {
        return this.getGestor().getModel();
    }
    
    public void actualizarPerfil() {
       this.setActualizacion(true);
       this.setModel();
       this.getGestor().actualizarObjeto();
       this.getGestor().newModel();
       this.cargarTabla(this.getForm().getTblPerfil());

    }
    public void cargarTabla(JTable tabla){
        tabla.setModel(this.crearModelo(this.getGestor().consultarPerfiles()));
   }
    public void eliminarPerfil(int indice) {
        if (indice != -1) {
            if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el perfil seleccionado?","Atencion", YES_NO_OPTION) == 0 ){
                String nombre = this.getForm().getTblPerfil().getValueAt(indice, 0).toString();
                this.setModel(this.getGestor().buscarPerfil(Perfil.class, nombre));
                this.getGestor().eliminarObjeto();
                this.cargarTabla(this.getForm().getTblPerfil());
                JOptionPane.showMessageDialog(null, "Perfil eliminado exitosamente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro para eliminar.");
        }
    }

    public boolean buscarPerfil(String nombre) {
        Perfil perfil;
        perfil = this.getGestor().buscarPerfil(nombre);
         if(perfil!=null){
              this.setModel(perfil);
              this.cargarPerfil(perfil);
         }else{
             return false;
         }
         return true;
    }
    public void buscarPerfil(String nombre, String descripcion){
       this.getForm().getTblPerfil().setModel(this.crearModelo(this.getGestor().consultarPerfiles(nombre,descripcion)));
    }
    public DefaultTableModel crearModelo(List lista){
        String[] titulos = {"Nombre", "Descripción"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos){
           @Override
            public boolean isCellEditable(int row, int column) {
               return false;
         }
        };
        if(lista==null){
            return modelo;
        }
        Object[] registros = new Object[3];
        for (Iterator it = lista.iterator(); it.hasNext();) {
            Perfil perfil = (Perfil) it.next();   
             registros[0] =  perfil.getNombre();
             registros[1] = perfil.getDescripcion();
             modelo.addRow(registros);
        }
       return modelo;
    }
    private void setModel(Perfil model) {
        this.getGestor().setModel(model);
    }

    private void cargarPerfil(Perfil perfil) {
        this.setModel(perfil);
        this.getForm().cargarPerfil(perfil);
    }
    public void cargarModelo(int indice){
       if(indice != -1){
           this.getForm().vistaEditar();
           String nombre = this.getForm().getTblPerfil().getValueAt(indice, 0).toString();
           this.cargarPerfil(this.getGestor().buscarPerfil(Perfil.class, nombre));
        }else{
             JOptionPane.showMessageDialog(null, "Debe seleccionar el registro a editar.");
        }
   }
    public void openFormulario(JDesktopPane pantalla, GestorVistaPerfil gestor) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmPerfil(gestor));
        this.getEscritorio().add(form);
        this.getForm().setVisible(true);
    }
    
    private void setEscritorio(JDesktopPane pantalla) {
        this.escritorio = pantalla;
    }

    private void setForm(FrmPerfil form) {
        this.form = form;
    }

    private JDesktopPane getEscritorio() {
        return this.escritorio;
    }

    public void newModel() {
        this.getGestor().newModel();
    }

    public String save(String accion) {
        String dialog="";
        if("Guardar".equals(accion)){
              this.guardarPerfil();
              dialog = "Perfil guardado exitosamente.";
         }else{
            this.actualizarPerfil();
            dialog = "Perfil actualizado exitosamente.";
         } 
        return dialog;
    }
}