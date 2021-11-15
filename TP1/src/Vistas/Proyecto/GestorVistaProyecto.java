/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Proyecto;

import Modelos.Gestion.Cliente;
import Modelos.Gestion.Proyecto;
import Modelos.Gestion.GestorProyecto;
import Modelos.Gestion.Personal;
import Modelos.Gestion.TipoProyecto;
import Util.UtilJtable;
import Vistas.MenuPrincipal.GestorMenuPrincipal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.transaction.Transactional;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author Usuario
 */
public class GestorVistaProyecto {
    private JDesktopPane escritorio;
    private boolean actualizacion;
    FrmProyecto form;  
    private GestorProyecto gestor;
    private GestorMenuPrincipal gestorMenu;
     private UtilJtable UtilTable= new UtilJtable();
    
    public UtilJtable getUtilTable() {
        return UtilTable;
    }

    public void setUtilTable(UtilJtable UtilTable) {
        this.UtilTable = UtilTable;
    }

    public boolean isActualizacion() {
        return actualizacion;
    }

    public void setActualizacion(boolean actualizacion) {
        this.actualizacion = actualizacion;
    }
    
    public GestorVistaProyecto() {
    }
        public void newModel() {
            this.getGestor().newModel();
    }
        
     public Proyecto getModel() {
        return this.getGestor().getModel();
    }
     
     public void setModel(){
          this.getModel().setNombre(this.getForm().getTxtNombre().getText().toUpperCase());
          if(!this.isActualizacion()){
              this.getModel().setFechaCarga(new Date());
          }
          this.getModel().setFechaEntrega(this.getForm().getInpFechaEntrega().getDate());
          this.getModel().setFechaConfirmacion(this.getForm().getInpFechaConfirmacion().getDate());
          this.getModel().setFechaTerminacion(this.getForm().getInpFechaTerminacion().getDate());
          this.getModel().setTipoProyecto((TipoProyecto) this.getForm().getCboTipoProyecto().getSelectedItem());
           this.getModel().setCliente((Cliente) this.getForm().getCboCliente().getSelectedItem());
            this.getModel().setPersonal((Personal) this.getForm().getCboPersonal().getSelectedItem());
    }
    
    public void setModel(Proyecto model) {
        this.getGestor().setModel(model);
    }
     
    public void openFormulario(JDesktopPane pantalla, GestorVistaProyecto gestor) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmProyecto(gestor));
        this.getEscritorio().add(form);
        this.getForm().setVisible(true);
    }
    
    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

     public FrmProyecto getForm() {
        return form;
    }
      public void setForm(FrmProyecto form) {
        this.form = form;
    }
    
    public GestorProyecto getGestor() {
        if (gestor == null) {
           synchronized (GestorProyecto.class) {
                gestor = new GestorProyecto();
           }
        }
        return gestor;
    }
    public void setGestor(GestorProyecto gestor) {
        this.gestor = gestor;
    }

    public GestorMenuPrincipal getGestorMenu() {
        if (gestorMenu == null) {
           synchronized (GestorMenuPrincipal.class) {
                gestorMenu = new GestorMenuPrincipal();
           }
        }
        return gestorMenu;
    }

    public void setGestorMenu(GestorMenuPrincipal gestorMenu) {
        this.gestorMenu = gestorMenu;
    }
    
    public void guardarProyecto(){
        this.setActualizacion(false);
        this.setModel();
        this.getGestor().guardarObjeto();
    }
    
   public void actualizarProyecto(){
       this.setActualizacion(true);
       this.setModel();
       this.getGestor().actualizarObjeto();
   }
    
     public void cargarProyecto(Proyecto proyecto){
        this.setModel(proyecto);
         this.getForm().cargarProyecto(proyecto);
     }
    
    public void eliminarProyecto(){
        this.getGestor().eliminarObjeto();
    }
    public void revisarFormulario(){
         if(this.getForm().getTxtNombre().getText().isEmpty()){
             this.getForm().getLblNombreRequerido().setText("Requerido.");
             this.getForm().setFormValido(false);
         }
         if(this.getForm().getCboTipoProyecto().getSelectedIndex()==0){
             this.getForm().setFormValido(false);
         }
          if(this.getForm().getCboCliente().getSelectedIndex()==0){
             this.getForm().setFormValido(false);
         }
           if(this.getForm().getCboPersonal().getSelectedIndex()==0){
             this.getForm().setFormValido(false);
         }
         if (this.getForm().getFormValido()){
             this.getForm().setFormValido(this.revisarFechas());
         }
         
     }
    
     public boolean revisarFechas(){
         Date fechaCarga;
         if(this.isActualizacion()){
             fechaCarga = this.getModel().getFechaCarga();
         }else{
             fechaCarga = new Date();
         }
         if(this.getForm().getInpFechaConfirmacion().getDate()==null){
              if(this.getForm().getInpFechaTerminacion().getDate()==null){
                  if(this.getForm().getInpFechaEntrega().getDate()==null){
                      return true;
                  }else{
                      JOptionPane.showMessageDialog(null, "Debe cargar la fecha de confirmacion y de terminacion antes de la fecha de entrega");
                      return false;
                  }
              }else{
                  JOptionPane.showMessageDialog(null, "Debe cargar la fecha de confirmacion antes de la fecha de terminacion");
                  return false;
              }
         }else{
            if (this.getForm().getInpFechaConfirmacion().getDate().before(fechaCarga) ) {
                JOptionPane.showMessageDialog(null, "La fecha de confirmacion es anterior a la fecha de carga.");
                return false;
            }else{
                if(this.getForm().getInpFechaTerminacion().getDate()==null){
                    if(this.getForm().getInpFechaEntrega().getDate()==null){
                        return true;
                    }else{
                        JOptionPane.showMessageDialog(null, "Debe cargar la fecha de terminacion antes de la fecha de entrega");
                        return false;
                    }
                }else{
                     if (this.getForm().getInpFechaTerminacion().getDate().before(this.getForm().getInpFechaConfirmacion().getDate()) ) {
                         JOptionPane.showMessageDialog(null, "La fecha de terminacion es anterior a la fecha de confirmacion.");
                          return false;
                     }else{
                          if(this.getForm().getInpFechaEntrega().getDate()==null){
                              return true;
                          }else{
                              if (this.getForm().getInpFechaEntrega().getDate().before(this.getForm().getInpFechaTerminacion().getDate()) ) {
                                  JOptionPane.showMessageDialog(null, "La fecha de entrega es anterior a la fecha de terminacion.");
                                  return false;
                              }else{
                                  return true;
                              }
                          }
                      }
                  }
            }
         }
     }

    public void setModelTipoProyecto(JComboBox cboTipoProyecto) {
       cboTipoProyecto.setModel(gestor.getComboModelTipoProyecto());
    }
    public void setModelCliente(JComboBox cboCliente) {
       cboCliente.setModel(gestor.getComboModelCliente());
    }
    public void setModelPersonal(JComboBox cboPersonal) {
       cboPersonal.setModel(gestor.getComboModelPersonal());
    }
    
    public void nuevoCliente(){
        this.getGestorMenu().abrirCliente(this.getEscritorio());
    }
    
    public void nuevoPersonal(){
        this.getGestorMenu().abrirPersonal(this.getEscritorio());
    }
    
    public void nuevoTipoProyecto(){
        this.getGestorMenu().abrirTipoProyecto(this.getEscritorio());
    }
    public String save(String accion) {
        String dialog="";
        if("Guardar".equals(accion)){
              this.guardarProyecto();
              dialog = "Proyecto guardado exitosamente.";
         }else{
            this.actualizarProyecto();
            dialog = "Proyecto actualizado exitosamente.";
         } 
        return dialog;
    }
    
    public void cargarTabla(JTable tabla){
        tabla.setModel(this.crearModelo(this.getGestor().consultarProyectos()));
    }
    
     public void buscarProyecto(String nombre) {
       this.getForm().getTblProyectos().setModel(this.crearModelo(this.getGestor().consultarProyectosPorNombre(nombre)));
    }
     
    public DefaultTableModel crearModelo(List lista){
        String[] titulos = {"Id","Nombre", "Tipo de Proyecto", "Cliente", "Personal", "Fecha Carga"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos){
           @Override
            public boolean isCellEditable(int row, int column) {
               return false;
         }
        };
        if(lista==null){
            return modelo;
        }
            Object[] registros = new Object[6];
//        String[] registros = new String[6];
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        for (Iterator it = lista.iterator(); it.hasNext();) {
            Proyecto proyecto = (Proyecto) it.next();
//                registros[0] = proyecto;
             registros[0] = proyecto;
             registros[1] =  proyecto.getNombre();
             registros[2] = proyecto.getTipoProyecto().getNombre();
             registros[3] = proyecto.getCliente().toString();
             registros[4] = proyecto.getPersonal().toString();
             registros[5] = formatter.format(proyecto.getFechaCarga());
             modelo.addRow(registros);
        }
       return modelo;
     }

    public void cargarModelo(int indice) {
        if(indice != -1){
            this.getForm().vistaEditar();
//            Object id = this.getForm().getTblProyectos().getValueAt(indice, 0);
//            this.cargarProyecto(this.getGestor().buscarProyectoPorId(new Long(id.toString())));

            Proyecto proyecto =(Proyecto) this.getForm().getTblProyectos().getValueAt(indice, 0);
            this.cargarProyecto(proyecto);
        }else{
             JOptionPane.showMessageDialog(null, "Debe seleccionar el registro a editar.");
        }
    }
    
    
    
}
