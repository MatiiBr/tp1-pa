/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Cliente;

import Modelos.Gestion.Cargo;
import Modelos.Gestion.Cliente;
import Modelos.Gestion.Contacto;
import Modelos.Gestion.GestorCliente;
import Util.UtilJtable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class GestorVistaCliente {
    private JDesktopPane escritorio;
    FrmCliente form;  
    private GestorCliente gestor; 
     private UtilJtable UtilTable= new UtilJtable();
    
    public UtilJtable getUtilTable() {
        return UtilTable;
    }

    public void setUtilTable(UtilJtable UtilTable) {
        this.UtilTable = UtilTable;
    }
    
    public GestorVistaCliente() {
    }
        public void newModel() {
            this.getGestor().newModel();
    }
        
     public Cliente getModel() {
        return this.getGestor().getModel();
    }
     
     public void setModel(){
          this.getModel().setNombre(this.getForm().getTxtNombre().getText().toUpperCase());
          this.getModel().setApellido(this.getForm().getTxtApellido().getText().toUpperCase());
          this.getModel().setFechaNacimiento(this.getForm().getInpFechaNacimiento().getDate());
    }
    
    public void setModel(Cliente model) {
        this.getGestor().setModel(model);
    }
     
    public void openFormulario(JDesktopPane pantalla, GestorVistaCliente gestor) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmCliente(gestor));
        this.getEscritorio().add(form);
        this.getForm().setVisible(true);
    }

    
    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

     public FrmCliente getForm() {
        return form;
    }
      public void setForm(FrmCliente form) {
        this.form = form;
    }
    
    public GestorCliente getGestor() {
        if (gestor == null) {
           synchronized (GestorCliente.class) {
                gestor = new GestorCliente();
           }
        }
        return gestor;
    }
    public void setGestor(GestorCliente gestor) {
        this.gestor = gestor;
    }
    public void guardarCliente(){
        this.setModel();
        this.getGestor().guardarObjeto();
        this.getGestor().newModel();
        this.cargarTabla(this.getForm().getTblCliente());
    }
    
   public void actualizarCliente(){
       this.setModel();
       this.getGestor().actualizarObjeto();
       this.getGestor().newModel();
       this.cargarTabla(this.getForm().getTblCliente());
   }
   public void cargarTabla(JTable tabla){
        tabla.setModel(this.crearModelo(this.getGestor().consultarClientes()));
   }
    
     public boolean buscarCliente(String nombre) { //NO SE USA MÁS
        Cliente cliente;
        cliente=this.getGestor().buscarCliente(nombre);
         if(cliente!=null){
              this.setModel(cliente);
              this.cargarCliente(cliente);
         }else{
             return false;
         }
         return true;
    }
    public void buscarCliente(String nombre, String apellido, Date fechaDesde, Date fechaHasta){
       if (fechaDesde != null && fechaHasta != null) {
           if (fechaHasta.before(fechaDesde)) {
                JOptionPane.showMessageDialog(null, "La fecha de nacimiento DESDE debe ser anterior a la fecha de nacimiento HASTA.");
           }    
       }
       this.getForm().getTblCliente().setModel(this.crearModelo(this.getGestor().consultarClientes(nombre,apellido,fechaDesde,fechaHasta)));
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
            Cliente cliente = (Cliente) it.next();   
             registros[0] =  cliente.getNombre();
             registros[1] = cliente.getApellido();
             registros[2] = formatter.format(cliente.getFechaNacimiento());
             modelo.addRow(registros);
        }
       return modelo;
     }
    public void cargarCliente(Cliente cliente){
        this.setModel(cliente);
        this.getForm().cargarCliente(cliente);
    }
    public void cargarModelo(int indice){
       if(indice != -1){
           this.getForm().vistaEditar();
           String nombre = this.getForm().getTblCliente().getValueAt(indice, 0).toString();
           this.cargarCliente(this.getGestor().buscarCliente(Cliente.class, nombre));

        }else{
             JOptionPane.showMessageDialog(null, "Debe seleccionar el registro a editar.");
        }
   }
    public void eliminarCliente(){
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
