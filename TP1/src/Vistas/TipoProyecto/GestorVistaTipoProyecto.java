/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.TipoProyecto;

import Vistas.TipoProyecto.FrmTipoProyecto;
import Vistas.TipoProyecto.GestorVistaTipoProyecto;
import Modelos.Gestion.GestorTipoProyecto;
import Modelos.Gestion.TipoProyecto;
import Util.UtilJtable;
import java.util.Iterator;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pedro
 */
public class GestorVistaTipoProyecto {
    private JDesktopPane escritorio;
    private boolean actualizacion;
    FrmTipoProyecto form;  
    private GestorTipoProyecto gestor; 
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
    public FrmTipoProyecto getForm() {
        return form;
    }

    public void guardarTipoProyecto() {
        this.setActualizacion(false);
        this.setModel();
        this.getGestor().guardarObjeto();
        this.getGestor().newModel();
        this.cargarTabla(this.getForm().getTblTipoProyecto());
    }

    private void setActualizacion(boolean b) {
        this.actualizacion = b;
    }

    private void setModel() {
        this.getModel().setNombre(this.getForm().getTxtNombre().getText().toUpperCase());
        this.getModel().setDescripcion(this.getForm().getjTxtDescripcion().getText().toUpperCase());
    }
    private GestorTipoProyecto getGestor() {
        if (gestor == null) {
           synchronized (GestorTipoProyecto.class) {
                gestor = new GestorTipoProyecto();
           }
        }
        return gestor;
    }
    private TipoProyecto getModel() {
        return this.getGestor().getModel();
    }
    
    public void actualizarTipoProyecto() {
       this.setActualizacion(true);
       this.setModel();
       this.getGestor().actualizarObjeto();
       this.getGestor().newModel();
       this.cargarTabla(this.getForm().getTblTipoProyecto());
    }

    public void eliminarTipoProyecto() {
        this.getGestor().eliminarObjeto();
    }

    public boolean buscarTipoProyecto(String nombre) {
        TipoProyecto tipoProyecto;
        tipoProyecto = this.getGestor().buscarTipoProyecto(nombre);
         if(tipoProyecto!=null){
              this.setModel(tipoProyecto);
              this.cargarTipoProyecto(tipoProyecto);
         }else{
             return false;
         }
         return true;
    }
    public void buscarTipoProyecto(String nombre, String descripcion){
       this.getForm().getTblTipoProyecto().setModel(this.crearModelo(this.getGestor().consultarTipoProyecto(nombre,descripcion)));
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
            TipoProyecto tipoProyecto = (TipoProyecto) it.next();   
             registros[0] =  tipoProyecto.getNombre();
             registros[1] = tipoProyecto.getDescripcion();
             modelo.addRow(registros);
        }
       return modelo;
    }
    private void setModel(TipoProyecto model) {
        this.getGestor().setModel(model);
    }

    private void cargarTipoProyecto(TipoProyecto tipoProyecto) {
        this.setModel(tipoProyecto);
        this.getForm().cargarTipoProyecto(tipoProyecto);
    }

    public void openFormulario(JDesktopPane pantalla, GestorVistaTipoProyecto gestor) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmTipoProyecto(gestor));
        this.getEscritorio().add(form);
        this.getForm().setVisible(true);
    }

    private void setEscritorio(JDesktopPane pantalla) {
        this.escritorio = pantalla;
    }

    private void setForm(FrmTipoProyecto form) {
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
              this.guardarTipoProyecto();
              dialog = "Tipo de Proyecto guardado exitosamente.";
         }else{
            this.actualizarTipoProyecto();
            dialog = "Tipo de Proyecto actualizado exitosamente.";
         } 
        return dialog;
    }
    public void cargarTabla(JTable tabla){
        tabla.setModel(this.crearModelo(this.getGestor().consultarTipoProyecto()));
   }
    public void cargarModelo(int indice){
       if(indice != -1){
           this.getForm().vistaEditar();
           String nombre = this.getForm().getTblTipoProyecto().getValueAt(indice, 0).toString();
           this.cargarTipoProyecto(this.getGestor().buscarTipoProyecto(TipoProyecto.class, nombre));
        }else{
             JOptionPane.showMessageDialog(null, "Debe seleccionar el registro a editar.");
        }
   }
}