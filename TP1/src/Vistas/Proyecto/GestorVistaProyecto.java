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
import Reportes.GestorReportes;
import Util.UtilJtable;
import Vistas.MenuPrincipal.GestorMenuPrincipal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.resource.cci.Connection;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Usuario
 */
public class GestorVistaProyecto {
    private JDesktopPane escritorio;
    private boolean actualizacion;
    FrmProyecto form;  
    private GestorProyecto gestor;
    private DefaultListModel modeloListaDerecha= new DefaultListModel();
    private DefaultListModel modeloListaIzquierda= new DefaultListModel();
    private GestorMenuPrincipal gestorMenu;
    private UtilJtable UtilTable= new UtilJtable();
    private GestorReportes gestorReportes;
    
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
        this.getGestor().newModel();

    }
    
   public void actualizarProyecto(){
       this.setActualizacion(true);
       this.setModel();
       this.getGestor().actualizarObjeto();
       this.getGestor().newModel();

   }
    
     public void cargarProyecto(Proyecto proyecto){
        this.setModel(proyecto);
        this.getForm().cargarProyecto(proyecto);
     }
    
    public void eliminarProyecto(){
        this.getGestor().eliminarObjeto();
    }
    public String revisarFormulario(){
        String dialog = "";
         if(this.getForm().getTxtNombre().getText().isEmpty()){
             dialog += "- El campo Nombre no puede estar vacío.\n";
            this.getForm().setFormValido(false);
         }
         System.out.println("VALIDO: " + this.getForm().getFormValido());
         if(this.getForm().getCboTipoProyecto().getSelectedIndex()==0){
             dialog += "- Debe elegir un Tipo de Proyecto.\n";
             this.getForm().setFormValido(false);
         }
         System.out.println("VALIDO: " + this.getForm().getFormValido());

          if(this.getForm().getCboCliente().getSelectedIndex()==0){
             dialog += "- Debe elegir un Cliente.\n";
             this.getForm().setFormValido(false);
         }
          System.out.println("VALIDO: " + this.getForm().getFormValido());
           if(this.getForm().getCboPersonal().getSelectedIndex()==0){
               dialog += "- Debe elegir un Personal.\n";
             this.getForm().setFormValido(false);
         }
         System.out.println("VALIDO: " + this.getForm().getFormValido());

         if (this.getForm().getFormValido()){
             this.getForm().setFormValido(this.revisarFechas());
         }
         System.out.println("VALIDO: " + this.getForm().getFormValido());

       return dialog;  
     }
    
     public boolean revisarFechas(){
         Date fechaCarga;
         if(this.isActualizacion()){
             fechaCarga = this.getModel().getFechaCarga();
         }else{
             fechaCarga = new Date();
         }
         if (this.getForm().getFormValido()) {
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
                 System.out.println(this.getForm().getInpFechaConfirmacion().getDate());
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
         } else {
             return false;
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
    
     public void buscarProyecto(String nombre, Object cliente, Object tipoProyecto, Object personal, Date fechaDesde, Date fechaHasta) {
         Cliente clienteFilter = null;
         TipoProyecto tipoProyectoFilter = null;
         Personal personalFilter = null;
         if (fechaDesde != null && fechaHasta != null) {
           if (fechaHasta.before(fechaDesde)) {
                JOptionPane.showMessageDialog(null, "La fecha de nacimiento DESDE debe ser anterior a la fecha de nacimiento HASTA.");
           }    
       }
         if(!cliente.equals("")){
             clienteFilter = (Cliente) cliente;
         }
         if(!tipoProyecto.equals("")){
             tipoProyectoFilter = (TipoProyecto) tipoProyecto;
         }
         if(!personal.equals("")){
             personalFilter = (Personal) personal;
         }
       this.getForm().getTblProyectos().setModel(this.crearModelo(this.getGestor().consultarProyectos(nombre,clienteFilter,tipoProyectoFilter,personalFilter,fechaDesde,fechaHasta)));
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
            Object[] registros = new Object[5];
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
            String nombre = this.getForm().getTblProyectos().getValueAt(indice, 0).toString();
            this.cargarProyecto(this.getGestor().buscarProyectoPorNombre(Proyecto.class, nombre));

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
        System.out.println(this.getForm().getCboPersonal().getSelectedItem()!="");
        System.out.println(this.getForm().getCboPersonal().getSelectedItem()!=null);
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
    public void abrirListado(String archivo){
        try{
            gestorReportes= new GestorReportes(archivo);
            gestorReportes.agregarParametro("tituloMembrete", "Programación Avanzada");
            gestorReportes.agregarParametro("frase", "");
            gestorReportes.agregarParametro("pieMembrete", "");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void agregarParametroListado(String nombre,Object objeto){
        gestorReportes.agregarParametro(nombre, objeto);
    }
    public void agregarDatosListado(List listaDatosOrdenada){
        gestorReportes.setColeccionDeDatos(listaDatosOrdenada);
    }
    public void imprimirListado() {
        try{
            gestorReportes.imprimir();
//             gestorReportes.imprimirDirecto();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void imprimir() {
        this.abrirListado("C:/Users/Pedro/Desktop/4to AÑO/2do Cuatrimestre/Programación Avanzada/tp1-pa/TP1/src/Recursos/Reportes/proyectos.jasper");
        this.agregarParametroListado("titulo", "Proyecto");
        this.agregarDatosListado(this.gestor.consultarProyectos() );
        this.imprimirListado();
    }  
}
