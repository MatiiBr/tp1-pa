/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Contacto;

import Modelos.Gestion.Contacto;
import Modelos.Gestion.GestorContacto;
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
 * @author Usuario
 */
public class GestorVistaContacto {
    private JDesktopPane escritorio;
    FrmContacto form;  
    private GestorContacto gestor; 
     private UtilJtable UtilTable= new UtilJtable();
    
    public UtilJtable getUtilTable() {
        return UtilTable;
    }

    public void setUtilTable(UtilJtable UtilTable) {
        this.UtilTable = UtilTable;
    }
    
    public GestorVistaContacto() {
    }
        public void newModel() {
            this.getGestor().newModel();
    }
        
     public Contacto getModel() {
        return this.getGestor().getModel();
    }
     
     public void setModel(){
         this.getModel().setNombre(this.getForm().getTxtNombre().getText().toUpperCase());
         this.getModel().setApellido(this.getForm().getTxtApellido().getText().toUpperCase());
         this.getModel().setFechaNacimiento(this.getForm().getInpFechaNacimiento().getDate());
    }
    
    public void setModel(Contacto model) {
        this.getGestor().setModel(model);
    }
     
    public void openFormulario(JDesktopPane pantalla, GestorVistaContacto gestor) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmContacto(gestor));
        this.getEscritorio().add(form);
        this.getForm().setVisible(true);
    }
    
    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

     public FrmContacto getForm() {
        return form;
    }
      public void setForm(FrmContacto form) {
        this.form = form;
    }
    
    public GestorContacto getGestor() {
        if (gestor == null) {
           synchronized (GestorContacto.class) {
                gestor = new GestorContacto();
           }
        }
        return gestor;
    }
    public void setGestor(GestorContacto gestor) {
        this.gestor = gestor;
    }
    public void guardarContacto(){
        this.setModel();
        this.getGestor().guardarObjeto();
        this.getGestor().newModel();
        this.cargarTabla(this.getForm().getTblContacto());
    }
    
   public void actualizarContacto(){
       this.setModel();
       this.getGestor().actualizarObjeto();
       this.getGestor().newModel();
       this.cargarTabla(this.getForm().getTblContacto());
   }

   public void cargarTabla(JTable tabla){
        tabla.setModel(this.crearModelo(this.getGestor().consultarContactos()));
   }
   
   public void buscarContacto(String nombre, String apellido, Date fechaDesde, Date fechaHasta){
       if (fechaDesde != null && fechaHasta != null) {
           if (fechaHasta.before(fechaDesde)) {
                JOptionPane.showMessageDialog(null, "La fecha de nacimiento DESDE debe ser anterior a la fecha de nacimiento HASTA.");
           }    
       }
       this.getForm().getTblContacto().setModel(this.crearModelo(this.getGestor().consultarContactos(nombre,apellido,fechaDesde,fechaHasta)));
   }

   public void cargarModelo(int indice){
       if(indice != -1){
           this.getForm().vistaEditar();
           String nombre = this.getForm().getTblContacto().getValueAt(indice, 0).toString();
           this.cargarContacto(this.getGestor().buscarContacto(Contacto.class, nombre));
        }else{
             JOptionPane.showMessageDialog(null, "Debe seleccionar el registro a editar.");
        }
   }
   public DefaultTableModel crearModelo(List lista){
        String[] titulos = {"Nombre", "Apellido", "Fecha Nacimiento"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos){
           @Override
            public boolean isCellEditable(int row, int column) {
               return false;
         }
        };
        if(lista==null){
            return modelo;
        }
        Object[] registros = new Object[4];
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        for (Iterator it = lista.iterator(); it.hasNext();) {
            Contacto contacto = (Contacto) it.next();   
             registros[0] =  contacto.getNombre();
             registros[1] = contacto.getApellido();
             registros[2] = formatter.format(contacto.getFechaNacimiento());
             modelo.addRow(registros);
        }
       return modelo;
     }
     public void cargarContacto(Contacto contacto){
         this.setModel(contacto);
         this.getForm().cargarContacto(contacto);
     }
    
    public void eliminarContacto(int indice){
        if (indice != -1) {
            if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el contacto seleccionado?","Atencion", YES_NO_OPTION) == 0 ){
                String nombre = this.getForm().getTblContacto().getValueAt(indice, 0).toString();
                this.setModel(this.getGestor().buscarContacto(Contacto.class, nombre));
                this.getGestor().eliminarObjeto();
                this.cargarTabla(this.getForm().getTblContacto());
                JOptionPane.showMessageDialog(null, "Contacto eliminado exitosamente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro para eliminar.");
        }
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
     
}
