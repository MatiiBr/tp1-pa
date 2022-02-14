/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Proyecto;

import Hibernate.HibernateUtil;
import Modelos.Gestion.Cliente;
import Modelos.Gestion.Proyecto;
import Modelos.Gestion.GestorProyecto;
import Modelos.Gestion.Perfil;
import Modelos.Gestion.Personal;
import Modelos.Gestion.TipoProyecto;
import Util.UtilJtable;
import Vistas.MenuPrincipal.GestorMenuPrincipal;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Usuario
 */
public class GestorVistaProyecto {
    private JDesktopPane escritorio;
    private boolean actualizacion;
    FrmProyecto form;  
    private GestorProyecto gestor;
    HibernateUtil conn;
    private DefaultListModel modeloListaDerecha= new DefaultListModel();
    private DefaultListModel modeloListaIzquierda= new DefaultListModel();
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
    
     public void buscarProyecto(String nombre, Object cliente, Object tipoProyecto, Object personal) {
         Cliente clienteFilter = null;
         TipoProyecto tipoProyectoFilter = null;
         Personal personalFilter = null;
         if(!cliente.equals("")){
             clienteFilter = (Cliente) cliente;
         }
         if(!tipoProyecto.equals("")){
             tipoProyectoFilter = (TipoProyecto) tipoProyecto;
         }
         if(!personal.equals("")){
             personalFilter = (Personal) personal;
         }
       this.getForm().getTblProyectos().setModel(this.crearModelo(this.getGestor().consultarProyectos(nombre,clienteFilter,tipoProyectoFilter,personalFilter)));
    }
     
    public DefaultTableModel crearModelo(List lista){
        String[] titulos = {"Nombre", "Tipo de Proyecto", "Cliente", "Personal", "Fecha Carga"};
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
             registros[0] =  proyecto.getNombre();
             registros[1] = proyecto.getTipoProyecto().getNombre();
             registros[2] = proyecto.getCliente().toString();
             registros[3] = proyecto.getPersonal().toString();
             registros[4] = formatter.format(proyecto.getFechaCarga());
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
    public void nuevoPerfil() {
        this.getGestorMenu().abrirPerfil(this.getEscritorio());
    }
    
     public void buscarPerfiles(JList lista) {
        this.modeloListaIzquierda = new DefaultListModel<Perfil>();
        lista.setModel(this.crearModelo((List<Perfil>) this.getGestor().getGestorPerfil().buscarPerfiles(),this.modeloListaIzquierda));
    }
    public void limpiarPerfiles(JList lista){
        this.modeloListaDerecha = new DefaultListModel<Perfil>();
        lista.setModel(this.modeloListaDerecha);
    }
    public void moverPerfilesDer(List listaPerfiles, JList listaDer, JList listaIzq) {
        this.getModel().setPerfiles(listaPerfiles);
        listaDer.setModel(this.crearModelo(listaPerfiles,this.modeloListaDerecha));
        listaIzq.setModel(this.removerPerfiles(listaPerfiles, this.modeloListaIzquierda));
    }
    public void moverPerfilesIzq(List listaPerfiles, JList listaIzq, JList listaDer) {
        this.getModel().setPerfiles(listaDer.getSelectedValuesList());
        listaIzq.setModel(this.crearModelo(listaPerfiles,this.modeloListaIzquierda));
        listaDer.setModel(this.removerPerfiles(listaPerfiles, this.modeloListaDerecha));
    }
    public DefaultListModel<Perfil> crearModelo(List perfiles, DefaultListModel modelo){
        if (perfiles!=null) {
            for (Iterator it = perfiles.iterator(); it.hasNext();) {
                Perfil perfil = (Perfil) it.next();
                 modelo.addElement(perfil);
            }
        }
        return modelo;
    }
    
    public DefaultListModel<Perfil> removerPerfiles(List perfiles, DefaultListModel modelo){
        for (Iterator it = perfiles.iterator(); it.hasNext();) {
                Perfil perfil = (Perfil) it.next();
                 modelo.removeElement(perfil);
            }
        return modelo;
    }
    
    public String getAvg(JList perfilesSeleccionados) {
        int count = 0;
        if(this.getForm().getCboPersonal().getSelectedItem()!=""){
             Personal personal = ((Personal) this.getForm().getCboPersonal().getSelectedItem());
            for (Perfil perfil : personal.getPerfiles()) {
                for (int i = 0; i < perfilesSeleccionados.getModel().getSize(); i++) {
                    Object item = perfilesSeleccionados.getModel().getElementAt(i);
                      if(item == perfil){
                          count++;
                      }
                }
            }
            int cantPerfiles = perfilesSeleccionados.getModel().getSize();
            double avg = (double)((count*1.0)/(cantPerfiles*1.0));
            int avgPerc = (int) (avg * 100);
            return Integer.toString(avgPerc)+"% de coincidencia";
        };
        return "";
       
    }
    
//    public void ejecutarReporte(){
//        JasperReport masterReport = null;
//        try {
//            masterReport = (JasperReport) JRLoader.loadObject(getClass().getResource("proyectos.jasper"));
//            
//        } catch (JRException e){
//            System.out.println("Error cargando el Reporte Maestro");
//        }
//        JRDataSource as = new JRResultSetDataSource((ResultSet) this.gestor.buscarProyectoPorId((long)1));
//        JasperPrint jasperPrint;
//        try {
//            jasperPrint = JasperFillManager.fillReport(masterReport, null, as);
//            JasperViewer jViewer = new JasperViewer(jasperPrint, false);
//            jViewer.setTitle("Reporte de Prueba - Programación Avanzada");
//            jViewer.setVisible(true);
//        } catch (JRException ex) {
//            Logger.getLogger(GestorVistaProyecto.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }

    
    
}
