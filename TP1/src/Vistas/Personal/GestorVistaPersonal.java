/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Personal;

import Modelos.Gestion.Cargo;
import Modelos.Gestion.Cliente;
import Modelos.Gestion.Contacto;
import Modelos.Gestion.GestorPersonal;
import Modelos.Gestion.Perfil;
import Modelos.Gestion.Personal;
import Modelos.Gestion.TipoProyecto;
import Util.UtilJtable;
import Vistas.MenuPrincipal.GestorMenuPrincipal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class GestorVistaPersonal {
    private JDesktopPane escritorio;
    FrmPersonal form;  
    private GestorPersonal gestor; 
    private GestorMenuPrincipal gestorMenu;
    private UtilJtable UtilTable= new UtilJtable();
    private DefaultListModel modeloListaDerecha= new DefaultListModel();
    private DefaultListModel modeloListaIzquierda= new DefaultListModel();
    
    public UtilJtable getUtilTable() {
        return UtilTable;
    }

    public void setUtilTable(UtilJtable UtilTable) {
        this.UtilTable = UtilTable;
    }
    
    public GestorVistaPersonal() {
    }
        public void newModel() {
            this.getGestor().newModel();
    }
        
     public Personal getModel() {
        return this.getGestor().getModel();
    }
     
     public void setModel(){
        this.getModel().setNombre(this.getForm().getTxtNombre().getText().toUpperCase());
        this.getModel().setApellido(this.getForm().getTxtApellido().getText().toUpperCase());
        this.getModel().setFechaNacimiento(this.getForm().getInpFechaNacimiento().getDate());
        this.getModel().setCargo((Cargo) this.getForm().getCboCargo().getSelectedItem());
    }
    
    public void setModel(Personal model) {
        this.getGestor().setModel(model);
    }
     
    public void openFormulario(JDesktopPane pantalla, GestorVistaPersonal gestor) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmPersonal(gestor));
        this.getEscritorio().add(form);
        this.getForm().setVisible(true);
    }
    
    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

     public FrmPersonal getForm() {
        return form;
    }
      public void setForm(FrmPersonal form) {
        this.form = form;
    }
    
    public GestorPersonal getGestor() {
        if (gestor == null) {
           synchronized (GestorPersonal.class) {
                gestor = new GestorPersonal();
           }
        }
        return gestor;
    }
    public void setGestor(GestorPersonal gestor) {
        this.gestor = gestor;
    }
    public void guardarPersonal(){
        this.setModel();
        this.getGestor().guardarObjeto();
        this.getGestor().newModel();
    }
    
   public void actualizarPersonal(){
       this.setModel();
       this.getGestor().actualizarObjeto();
       this.getGestor().newModel();
   }
    
     public boolean buscarPersonal(String nombre) {
        Personal personal;
        personal=this.getGestor().buscarPersonal(nombre);
         if(personal!=null){
              this.setModel(personal);
              this.cargarPersonal(personal);
         }else{
             return false;
         }
         return true;
    }
    public void cargarPersonal(Personal personal){
        this.getForm().cargarPersonal(personal);
    }
    public void cargarModelo(int indice){
       if(indice != -1){
           this.getForm().vistaEditar();
           String nombre = this.getForm().getTblPersonal().getValueAt(indice, 0).toString();
           this.cargarPersonal(this.getGestor().buscarPersonal(Personal.class, nombre));
        }else{
             JOptionPane.showMessageDialog(null, "Debe seleccionar el registro a editar.");
        }
   } 
    public void eliminarPersonal(){
        this.getGestor().eliminarObjeto();
    }
    public String revisarFormulario(){
        
        String mensaje = "";
         if(this.getForm().getTxtNombre().getText().isEmpty()){
             this.getForm().getLblNombreRequerido().setText("Requerido.");
             mensaje +="\n - El campo Nombre no puede estar vacio.";
             this.getForm().setFormValido(false);
         }
         if(this.getForm().getTxtApellido().getText().isEmpty()){
             this.getForm().getLblApellidoRequerido().setText("Requerido.");
             mensaje +="\n - El campo Apellido no puede estar vacio.";
             this.getForm().setFormValido(false);
         }
         if(this.getForm().getInpFechaNacimiento().getDate()==null){
             this.getForm().getLblFechaNacimientoRequerido().setText("Requerido.");
             mensaje +="\n - El campo Fecha de Nacimiento no puede estar vacio.";
             this.getForm().setFormValido(false);
         }else if(!verificarEdad()){
              mensaje +="\n - La edad debe ser mayor o igual a 18 años.";
             this.getForm().setFormValido(false);
         }
         if(this.getForm().getCboCargo().getSelectedIndex()==0 || this.getForm().getCboCargo().getSelectedIndex()==-1){
             
             mensaje +="\n - Debe seleccionar un Cargo.";
             this.getForm().setFormValido(false);
         }
         return mensaje;
     }
     public boolean verificarEdad(){
         var date = new Date();
         int edad = 0;
         if (this.getForm().getInpFechaNacimiento().getDate().getYear() < date.getYear()) {
           edad = (date.getYear()) - (this.getForm().getInpFechaNacimiento().getDate().getYear());
           if(this.getForm().getInpFechaNacimiento().getDate().getMonth() > date.getMonth() ) {
               edad--;
           } else if(this.getForm().getInpFechaNacimiento().getDate().getMonth() == date.getMonth()) {
               if(this.getForm().getInpFechaNacimiento().getDate().getDate() > date.getDate() ) {
                   edad--;
               }
           }
         }
         return edad>=18;
     }
    public void setModelCargo(JComboBox cboCargo) {
       cboCargo.setModel(getGestor().getComboModelCargo());
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
    public void cargarTabla(JTable tabla){
        tabla.setModel(this.crearModelo(this.getGestor().consultarPersonales()));
    }
    public DefaultTableModel crearModelo(List lista){
        String[] titulos = {"Nombre", "Apellido", "Cargo", "Fecha de Nacimiento"};
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        for (Iterator it = lista.iterator(); it.hasNext();) {
            Personal personal = (Personal) it.next();   
             registros[0] =  personal.getNombre();
             registros[1] = personal.getApellido();
             registros[2] = personal.getCargo().toString();
             registros[3] = formatter.format(personal.getFechaNacimiento());
             modelo.addRow(registros);
        }
       return modelo;
     }
    public void buscarPersonal(String nombre, String apellido, Object cargo, Date fechaDesde, Date fechaHasta) {
         Cargo cargoFilter = null;
         if(!cargo.equals("")){
             cargoFilter = (Cargo) cargo;
         }
         if (fechaDesde != null && fechaHasta != null) {
           if (fechaHasta.before(fechaDesde)) {
                JOptionPane.showMessageDialog(null, "La fecha de nacimiento DESDE, debe ser anterior a la fecha de nacimiento HASTA.");
           }
         }
       this.getForm().getTblPersonal().setModel(this.crearModelo(this.getGestor().consultarPersonales(nombre,apellido,cargoFilter,fechaDesde,fechaHasta)));
       }
}

    
