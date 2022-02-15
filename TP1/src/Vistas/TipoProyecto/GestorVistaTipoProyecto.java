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
import javax.swing.JDesktopPane;

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

    private void setModel(TipoProyecto model) {
        this.getGestor().setModel(model);
    }

    private void cargarTipoProyecto(TipoProyecto tipoProyecto) {
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
}