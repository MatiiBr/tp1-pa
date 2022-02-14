/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Proyecto;

import Modelos.Gestion.Cliente;
import Modelos.Gestion.Personal;
import Modelos.Gestion.Proyecto;
import Modelos.Gestion.TipoProyecto;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Usuario
 */
public class FrmProyecto extends javax.swing.JInternalFrame {
     private GestorVistaProyecto gestorProyecto;
     private int YES_NO_OPTION;
     private boolean formValido = true;
     SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
    /**
     * Creates new form FrmContacto
     */
     public FrmProyecto(GestorVistaProyecto gestorProyecto) {
        try{
           initComponents();
           }
           catch(Exception e){
            
        }  
        this.setGestorVistaProyecto(gestorProyecto);
        this.getGestorVistaProyecto().newModel();
        this.cargarCombos();
        this.getGestorVistaProyecto().cargarTabla(this.tblProyectos);
        this.actualizarPerfiles();
     }
    
    public JComboBox getCboCliente() {
        return cboCliente;
    }

    public void setCboCliente(JComboBox cboCliente) {
        this.cboCliente = cboCliente;
    }

    public JComboBox getCboPersonal() {
        return cboPersonal;
    }

    public void setCboPersonal(JComboBox cboPersonal) {
        this.cboPersonal = cboPersonal;
    }

    public JComboBox getCboTipoProyecto() {
        return cboTipoProyecto;
    }

    public void setCboTipoProyecto(JComboBox cboTipoProyecto) {
        this.cboTipoProyecto = cboTipoProyecto;
    }
    public JDateChooser getInpFechaEntrega() {
        return inpFechaEntrega;
    }

    public void setInpFechaEntrega(JDateChooser inpFechaEntrega) {
        this.inpFechaEntrega = inpFechaEntrega;
    }
    public JDateChooser getInpFechaConfirmacion() {
        return inpFechaConfirmacion;
    }

    public void setInpFechaConfirmacion(JDateChooser inpFechaConfirmacion) {
        this.inpFechaConfirmacion = inpFechaConfirmacion;
    }
    public JDateChooser getInpFechaTerminacion() {
        return inpFechaTerminacion;
    }

    public void setInpFechaTerminacion(JDateChooser inpFechaTerminacion) {
        this.inpFechaTerminacion = inpFechaTerminacion;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }
    
    public JLabel getLblNombreRequerido(){
        return this.lblNombreRequerido;
    }
    public void setLblNombreRequerido(JLabel lblNombreRequerido) {
        this.lblNombreRequerido = lblNombreRequerido;
    }
    
    public boolean getFormValido(){
        return this.formValido;
    }
    public void setFormValido(boolean formValido){
        this.formValido = formValido;
    }

    public JScrollPane getScrProyectos() {
        return scrProyectos;
    }

    public void setScrProyectos(JScrollPane scrProyectos) {
        this.scrProyectos = scrProyectos;
    }

    public JTable getTblProyectos() {
        return tblProyectos;
    }

    public void setTblProyectos(JTable tblProyectos) {
        this.tblProyectos = tblProyectos;
    }

    public FrmProyecto() {
        initComponents();
    }

    public GestorVistaProyecto getGestorVistaProyecto() {
        return gestorProyecto;
    }

    public void setGestorVistaProyecto(GestorVistaProyecto gestorProyecto) {
        this.gestorProyecto = gestorProyecto;
    }
    public void editarProyecto(){
        this.getGestorVistaProyecto().cargarModelo(this.tblProyectos.getSelectedRow());
    }
    public void vistaEditar(){
        this.vistaNuevoProyecto();
        this.botonesNuevo();
        btnGuardar.setText("Actualizar");
    }
    public void nuevoProyecto(){
        this.limpiarPantalla();
        this.vistaNuevoProyecto();
        this.botonesNuevo();
    }
    public void cancelar(){
        this.limpiarPantalla();
        this.vistaInicio();
        this.limpiarCombos();
        this.botonesInicio();
    }
    public void cargarProyecto(Proyecto proyecto){
        this.limpiarPantalla();
        this.vistaActualizacion();
        txtNombre.setText(proyecto.getNombre());
        lblFechaCargaDato.setText(sdf.format(proyecto.getFechaCarga()));
        inpFechaEntrega.setDate(proyecto.getFechaEntrega());
        inpFechaTerminacion.setDate(proyecto.getFechaTerminacion());
        inpFechaConfirmacion.setDate(proyecto.getFechaConfirmacion());
        cboCliente.setSelectedItem(proyecto.getCliente());
        cboPersonal.setSelectedItem(proyecto.getPersonal());
        cboTipoProyecto.setSelectedItem(proyecto.getTipoProyecto());
    }
    public void vistaInicio(){
        this.inpFechaConfirmacion.setEnabled(false);
        this.inpFechaTerminacion.setEnabled(false);
        this.inpFechaEntrega.setEnabled(false);
        this.cboCliente.setEnabled(false);
        this.cboPersonal.setEnabled(false);
        this.cboTipoProyecto.setEnabled(false);
        this.txtNombre.setEnabled(true);
    }
    public void vistaNuevoProyecto(){
        this.inpFechaConfirmacion.setEnabled(true);
        this.inpFechaTerminacion.setEnabled(true);
        this.inpFechaEntrega.setEnabled(true);
        this.cboCliente.setEnabled(true);
        this.cboPersonal.setEnabled(true);
        this.cboTipoProyecto.setEnabled(true);
        this.txtNombre.setEnabled(true);
        this.lblFechaCargaDato.setText(sdf.format(new Date()));
    }
    public void vistaActualizacion(){
        this.inpFechaConfirmacion.setEnabled(true);
        this.inpFechaTerminacion.setEnabled(true);
        this.inpFechaEntrega.setEnabled(true);
        this.cboCliente.setEnabled(true);
        this.cboPersonal.setEnabled(true);
        this.cboTipoProyecto.setEnabled(true);
        this.txtNombre.setEnabled(true);
    }
    
    public void limpiarPantalla(){
        this.txtNombre.setText("");
        this.limpiarCombos();
        this.inpFechaConfirmacion.setDate(null);
        this.inpFechaTerminacion.setDate(null);
        this.inpFechaEntrega.setDate(null);
        this.lblNombreRequerido.setText(" ");
        this.lblFechaCargaDato.setText(" ");
    }
    public void botonesInicio(){
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnGuardar.setText("Guardar");
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnSalir.setEnabled(true);
        btnBuscar.setEnabled(true);
    }
    public void botonesNuevo(){
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(false);
        btnBuscar.setEnabled(false);
    }
    
     public void botonesListado(){
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(true);
        btnBuscar.setEnabled(false);
     }
     public void guardarProyecto(){
         String dialog = this.getGestorVistaProyecto().save(btnGuardar.getText());
        this.limpiarPantalla();
        this.vistaInicio();
        this.botonesInicio();
        this.getGestorVistaProyecto().cargarTabla(this.tblProyectos);
        JOptionPane.showMessageDialog(null, dialog);
    }
     
     public void buscarProyecto(){
         this.getGestorVistaProyecto().buscarProyecto(this.txtBuscarNombre.getText().toUpperCase(), 
                 this.cboFilterCliente.getModel().getSelectedItem(),
                 this.cboFilterTipoProyecto.getModel().getSelectedItem(),
                 this.cboFilterPersonal.getModel().getSelectedItem());
     }
     
     public void eliminarProyecto(){
         this.getGestorVistaProyecto().eliminarProyecto();
         this.vistaInicio();
         this.limpiarPantalla();
         this.botonesInicio();
         this.getGestorVistaProyecto().cargarTabla(this.tblProyectos);
         JOptionPane.showMessageDialog(null, "Proyecto eliminado exitosamente");
     }
     
    public void cargarCombos() {
        this.cargarTipoProyecto();
         this.cargarClientes();
         this.cargarPersonal();
        this.cargarFilterClientes();
         this.cargarFilterTipoProyecto();
         this.cargarFilterPersonal();
    }
    public void cargarClientes(){
        this.getGestorVistaProyecto().setModelCliente(cboCliente);
    }
    public void cargarTipoProyecto(){
        this.getGestorVistaProyecto().setModelTipoProyecto(cboTipoProyecto);
    }
    public void cargarPersonal(){
        this.getGestorVistaProyecto().setModelPersonal(cboFilterPersonal);
    }
    public void cargarFilterClientes(){
        this.getGestorVistaProyecto().setModelCliente(cboFilterCliente);
    }
    public void cargarFilterTipoProyecto(){
        this.getGestorVistaProyecto().setModelTipoProyecto(cboFilterTipoProyecto);
    }
    public void cargarFilterPersonal(){
        this.getGestorVistaProyecto().setModelPersonal(cboFilterPersonal);
    }
    
    public void limpiarCombos(){
        if(this.cboTipoProyecto.getModel().getSize()!=0){
         this.cboTipoProyecto.setSelectedIndex(0);
        }
        if(this.cboPersonal.getModel().getSize()!=0){
         this.cboPersonal.setSelectedIndex(0);            
        }
        if(this.cboCliente.getModel().getSize() !=0){
         this.cboCliente.setSelectedIndex(0);   
        }
    }
    
    public void nuevoCliente(){
        this.getGestorVistaProyecto().nuevoCliente();
    }
    
     public void nuevoPersonal(){
        this.getGestorVistaProyecto().nuevoPersonal();
    }
     
     public void nuevoTipoProyecto(){
        this.getGestorVistaProyecto().nuevoTipoProyecto();
    }
    private void nuevoPerfil() {
        this.getGestorVistaProyecto().nuevoPerfil();
    }
    private void moverPerfilesDer() {
        this.getGestorVistaProyecto().moverPerfilesDer(this.listPerfilesIzq.getSelectedValuesList(), this.listPerfilesDer, this.listPerfilesIzq);
        this.setAvgText();
    }
    private void moverPerfilesIzq() {
        this.getGestorVistaProyecto().moverPerfilesIzq(this.listPerfilesDer.getSelectedValuesList(), this.listPerfilesIzq, this.listPerfilesDer);
        this.setAvgText();
    }
    public void actualizarPerfiles() {
        this.getGestorVistaProyecto().buscarPerfiles(this.listPerfilesIzq);
        this.getGestorVistaProyecto().limpiarPerfiles(this.listPerfilesDer);
    }
    
    public void setAvgText(){
        lblAvg.setText(this.getGestorVistaProyecto().getAvg(this.listPerfilesDer));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelProyecto = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNombreRequerido = new javax.swing.JLabel();
        lblTipoProyecto = new javax.swing.JLabel();
        cboTipoProyecto = new javax.swing.JComboBox();
        cboCliente = new javax.swing.JComboBox<>();
        lblFechaConfirmacion2 = new javax.swing.JLabel();
        lblFechaConfirmacion3 = new javax.swing.JLabel();
        cboPersonal = new javax.swing.JComboBox<>();
        btnCliente = new javax.swing.JButton();
        btnPersonal = new javax.swing.JButton();
        btnTipoProyecto = new javax.swing.JButton();
        lblAvg = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listPerfilesIzq = new javax.swing.JList<>();
        lblCargo2 = new javax.swing.JLabel();
        btnActualizarPerfiles = new javax.swing.JButton();
        btnAgregarPerfil = new javax.swing.JButton();
        btnSacarPerfil = new javax.swing.JButton();
        btnNuevoPerfil = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPerfilesDer = new javax.swing.JList<>();
        lblCargo1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        panelFechas = new javax.swing.JPanel();
        lblFechaTerminacion = new javax.swing.JLabel();
        lblFechaConfirmacion = new javax.swing.JLabel();
        inpFechaConfirmacion = new com.toedter.calendar.JDateChooser();
        inpFechaTerminacion = new com.toedter.calendar.JDateChooser();
        inpFechaEntrega = new com.toedter.calendar.JDateChooser();
        lblFechaEntrega = new javax.swing.JLabel();
        lblFechaCarga = new javax.swing.JLabel();
        lblFechaCargaDato = new javax.swing.JLabel();
        panelProyecto1 = new javax.swing.JPanel();
        lblNombreRequerido1 = new javax.swing.JLabel();
        scrProyectos = new javax.swing.JScrollPane();
        tblProyectos = new javax.swing.JTable();
        txtBuscarNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblNombre1 = new javax.swing.JLabel();
        lblNombre2 = new javax.swing.JLabel();
        cboFilterTipoProyecto = new javax.swing.JComboBox();
        lblFechaConfirmacion4 = new javax.swing.JLabel();
        lblFechaConfirmacion5 = new javax.swing.JLabel();
        cboFilterCliente = new javax.swing.JComboBox<>();
        cboFilterPersonal = new javax.swing.JComboBox<>();
        btnReporte = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setResizable(true);
        setTitle("Proyecto");
        setToolTipText("Proyecto");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelProyecto.setBorder(javax.swing.BorderFactory.createTitledBorder("Proyecto"));
        panelProyecto.setToolTipText("Proyecto");
        panelProyecto.setName("Contacto"); // NOI18N
        panelProyecto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setText("Nombre: ");
        panelProyecto.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombre.setToolTipText("Nombre");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        panelProyecto.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 139, -1));

        lblNombreRequerido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombreRequerido.setForeground(new java.awt.Color(204, 0, 51));
        lblNombreRequerido.setText(" ");
        panelProyecto.add(lblNombreRequerido, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 213, -1, -1));

        lblTipoProyecto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTipoProyecto.setText("Tipo Proyecto:");
        panelProyecto.add(lblTipoProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        cboTipoProyecto.setToolTipText("Seleccione.");
        cboTipoProyecto.setEnabled(false);
        cboTipoProyecto.setName(""); // NOI18N
        cboTipoProyecto.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cboTipoProyectoPopupMenuWillBecomeVisible(evt);
            }
        });
        cboTipoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoProyectoActionPerformed(evt);
            }
        });
        panelProyecto.add(cboTipoProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 139, 28));
        cboTipoProyecto.getAccessibleContext().setAccessibleName("");

        cboCliente.setToolTipText("Seleccione.");
        cboCliente.setEnabled(false);
        cboCliente.setName(""); // NOI18N
        cboCliente.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cboClientePopupMenuWillBecomeVisible(evt);
            }
        });
        cboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboClienteActionPerformed(evt);
            }
        });
        panelProyecto.add(cboCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 139, 28));

        lblFechaConfirmacion2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaConfirmacion2.setText("Cliente:");
        panelProyecto.add(lblFechaConfirmacion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        lblFechaConfirmacion3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaConfirmacion3.setText("Personal:");
        panelProyecto.add(lblFechaConfirmacion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        cboPersonal.setToolTipText("Seleccione.");
        cboPersonal.setEnabled(false);
        cboPersonal.setName(""); // NOI18N
        cboPersonal.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cboPersonalPopupMenuWillBecomeVisible(evt);
            }
        });
        cboPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPersonalActionPerformed(evt);
            }
        });
        panelProyecto.add(cboPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 139, 28));

        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add-user.png"))); // NOI18N
        btnCliente.setBorderPainted(false);
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        panelProyecto.add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 30, 28));

        btnPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add-user.png"))); // NOI18N
        btnPersonal.setBorderPainted(false);
        btnPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalActionPerformed(evt);
            }
        });
        panelProyecto.add(btnPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 30, 28));

        btnTipoProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add.png"))); // NOI18N
        btnTipoProyecto.setBorderPainted(false);
        btnTipoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoProyectoActionPerformed(evt);
            }
        });
        panelProyecto.add(btnTipoProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 30, 28));
        panelProyecto.add(lblAvg, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 140, 20));

        jScrollPane2.setViewportView(listPerfilesIzq);

        panelProyecto.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 180, 190));

        lblCargo2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCargo2.setText("Perfiles:");
        panelProyecto.add(lblCargo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 20));

        btnActualizarPerfiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add.png"))); // NOI18N
        btnActualizarPerfiles.setBorderPainted(false);
        btnActualizarPerfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPerfilesActionPerformed(evt);
            }
        });
        panelProyecto.add(btnActualizarPerfiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 40, 40));

        btnAgregarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/flecha-derecha.png"))); // NOI18N
        btnAgregarPerfil.setBorderPainted(false);
        btnAgregarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPerfilActionPerformed(evt);
            }
        });
        panelProyecto.add(btnAgregarPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 40, 40));

        btnSacarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/flecha-izquierda.png"))); // NOI18N
        btnSacarPerfil.setBorderPainted(false);
        btnSacarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacarPerfilActionPerformed(evt);
            }
        });
        panelProyecto.add(btnSacarPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 40, 40));

        btnNuevoPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/actualizar.png"))); // NOI18N
        btnNuevoPerfil.setBorderPainted(false);
        btnNuevoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPerfilActionPerformed(evt);
            }
        });
        panelProyecto.add(btnNuevoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 40, 40));

        jScrollPane1.setViewportView(listPerfilesDer);

        panelProyecto.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 180, 190));

        lblCargo1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCargo1.setText("Perfiles asignados:");
        panelProyecto.add(lblCargo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnNuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addGap(10, 10, 10)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 51));

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addGap(37, 37, 37))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelFechas.setBorder(javax.swing.BorderFactory.createTitledBorder("Fechas"));
        panelFechas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFechaTerminacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaTerminacion.setText("Fecha Terminacion:");
        panelFechas.add(lblFechaTerminacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 106, -1, -1));

        lblFechaConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaConfirmacion.setText("Fecha Confirmacion:");
        panelFechas.add(lblFechaConfirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 51, -1, -1));

        inpFechaConfirmacion.setToolTipText("Fecha de Nacimiento");
        inpFechaConfirmacion.setEnabled(false);
        inpFechaConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inpFechaConfirmacion.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inpFechaConfirmacionPropertyChange(evt);
            }
        });
        panelFechas.add(inpFechaConfirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 74, 161, 26));

        inpFechaTerminacion.setToolTipText("Fecha de Nacimiento");
        inpFechaTerminacion.setEnabled(false);
        inpFechaTerminacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inpFechaTerminacion.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inpFechaTerminacionPropertyChange(evt);
            }
        });
        panelFechas.add(inpFechaTerminacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 128, 161, 26));

        inpFechaEntrega.setToolTipText("Fecha de Nacimiento");
        inpFechaEntrega.setEnabled(false);
        inpFechaEntrega.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inpFechaEntrega.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inpFechaEntregaPropertyChange(evt);
            }
        });
        panelFechas.add(inpFechaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 182, 161, 26));

        lblFechaEntrega.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaEntrega.setText("Fecha Entrega:");
        panelFechas.add(lblFechaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 156, -1, -1));

        lblFechaCarga.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaCarga.setText("Fecha Carga:");
        panelFechas.add(lblFechaCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 26, -1, -1));

        lblFechaCargaDato.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelFechas.add(lblFechaCargaDato, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 160, 20));

        panelProyecto1.setBorder(javax.swing.BorderFactory.createTitledBorder("Proyecto"));
        panelProyecto1.setToolTipText("Proyecto");
        panelProyecto1.setName("Contacto"); // NOI18N
        panelProyecto1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreRequerido1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombreRequerido1.setForeground(new java.awt.Color(204, 0, 51));
        lblNombreRequerido1.setText(" ");
        panelProyecto1.add(lblNombreRequerido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 213, -1, -1));

        tblProyectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProyectos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProyectos.getTableHeader().setReorderingAllowed(false);
        scrProyectos.setViewportView(tblProyectos);

        panelProyecto1.add(scrProyectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 700, 140));

        txtBuscarNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscarNombre.setToolTipText("Nombre");
        txtBuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarNombreActionPerformed(evt);
            }
        });
        txtBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarNombreKeyTyped(evt);
            }
        });
        panelProyecto1.add(txtBuscarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 140, 30));

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        panelProyecto1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 90, 30));

        lblNombre1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre1.setText("Nombre: ");
        panelProyecto1.add(lblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        lblNombre2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre2.setText("Tipo Proyecto:");
        panelProyecto1.add(lblNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        cboFilterTipoProyecto.setToolTipText("Seleccione.");
        cboFilterTipoProyecto.setName(""); // NOI18N
        cboFilterTipoProyecto.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cboFilterTipoProyectoPopupMenuWillBecomeVisible(evt);
            }
        });
        cboFilterTipoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFilterTipoProyectoActionPerformed(evt);
            }
        });
        panelProyecto1.add(cboFilterTipoProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 139, 30));

        lblFechaConfirmacion4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaConfirmacion4.setText("Cliente:");
        panelProyecto1.add(lblFechaConfirmacion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        lblFechaConfirmacion5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaConfirmacion5.setText("Personal:");
        panelProyecto1.add(lblFechaConfirmacion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        cboFilterCliente.setToolTipText("Seleccione.");
        cboFilterCliente.setName(""); // NOI18N
        cboFilterCliente.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cboFilterClientePopupMenuWillBecomeVisible(evt);
            }
        });
        cboFilterCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFilterClienteActionPerformed(evt);
            }
        });
        panelProyecto1.add(cboFilterCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 139, 28));

        cboFilterPersonal.setToolTipText("Seleccione.");
        cboFilterPersonal.setName(""); // NOI18N
        cboFilterPersonal.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cboFilterPersonalPopupMenuWillBecomeVisible(evt);
            }
        });
        cboFilterPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFilterPersonalActionPerformed(evt);
            }
        });
        panelProyecto1.add(cboFilterPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 139, 28));

        btnReporte.setText("Generar Reporte");
        btnReporte.setActionCommand("Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelFechas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelProyecto1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReporte)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                    .addComponent(panelProyecto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelProyecto.getAccessibleContext().setAccessibleName("Descripcion");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.nuevoProyecto();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       this.editarProyecto();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       if(this.formValido){
            if (JOptionPane.showConfirmDialog(null, ("Guardar".equals(btnGuardar.getText())) ? "¿Desea guardar el proyecto?":"¿Desea actualizar el proyecto?","Atencion", YES_NO_OPTION) == 0 )
            this.guardarProyecto();
       }else{
           JOptionPane.showMessageDialog(null, "Error al enviar el formulario");
           this.formValido = true;
       }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el proyecto seleccionado?","Atencion", YES_NO_OPTION) == 0 )
           this.eliminarProyecto();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       this.cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        this.lblNombreRequerido.setText(" ");
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cboTipoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoProyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTipoProyectoActionPerformed

    private void cboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClienteActionPerformed
       
    }//GEN-LAST:event_cboClienteActionPerformed

    private void cboPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPersonalActionPerformed
       this.setAvgText();
    }//GEN-LAST:event_cboPersonalActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
       this.nuevoCliente();
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalActionPerformed
       this.nuevoPersonal();
    }//GEN-LAST:event_btnPersonalActionPerformed

    private void cboClientePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboClientePopupMenuWillBecomeVisible
        this.cargarClientes();
    }//GEN-LAST:event_cboClientePopupMenuWillBecomeVisible

    private void btnTipoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoProyectoActionPerformed
        this.nuevoTipoProyecto();
    }//GEN-LAST:event_btnTipoProyectoActionPerformed

    private void cboTipoProyectoPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboTipoProyectoPopupMenuWillBecomeVisible
        this.cargarTipoProyecto();
    }//GEN-LAST:event_cboTipoProyectoPopupMenuWillBecomeVisible

    private void cboPersonalPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboPersonalPopupMenuWillBecomeVisible
        this.cargarPersonal();
    }//GEN-LAST:event_cboPersonalPopupMenuWillBecomeVisible

    private void txtBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarNombreActionPerformed

    private void txtBuscarNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarNombreKeyTyped
       
    }//GEN-LAST:event_txtBuscarNombreKeyTyped

    private void txtBuscarNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarNombreKeyReleased
        this.buscarProyecto();
    }//GEN-LAST:event_txtBuscarNombreKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.buscarProyecto();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void inpFechaEntregaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inpFechaEntregaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_inpFechaEntregaPropertyChange

    private void inpFechaTerminacionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inpFechaTerminacionPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_inpFechaTerminacionPropertyChange

    private void inpFechaConfirmacionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inpFechaConfirmacionPropertyChange

    }//GEN-LAST:event_inpFechaConfirmacionPropertyChange

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
//        this.getGestorVistaProyecto().ejecutarReporte();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnActualizarPerfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPerfilesActionPerformed
        this.nuevoPerfil();
    }//GEN-LAST:event_btnActualizarPerfilesActionPerformed

    private void btnAgregarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPerfilActionPerformed
        this.moverPerfilesDer();
    }//GEN-LAST:event_btnAgregarPerfilActionPerformed

    private void btnSacarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacarPerfilActionPerformed
        this.moverPerfilesIzq();
    }//GEN-LAST:event_btnSacarPerfilActionPerformed

    private void btnNuevoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPerfilActionPerformed
        this.actualizarPerfiles();
    }//GEN-LAST:event_btnNuevoPerfilActionPerformed

    private void cboFilterTipoProyectoPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboFilterTipoProyectoPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cboFilterTipoProyectoPopupMenuWillBecomeVisible

    private void cboFilterTipoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFilterTipoProyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboFilterTipoProyectoActionPerformed

    private void cboFilterClientePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboFilterClientePopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cboFilterClientePopupMenuWillBecomeVisible

    private void cboFilterClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFilterClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboFilterClienteActionPerformed

    private void cboFilterPersonalPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboFilterPersonalPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cboFilterPersonalPopupMenuWillBecomeVisible

    private void cboFilterPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFilterPersonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboFilterPersonalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarPerfiles;
    private javax.swing.JButton btnAgregarPerfil;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevoPerfil;
    private javax.swing.JButton btnPersonal;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSacarPerfil;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTipoProyecto;
    private javax.swing.JComboBox<String> cboCliente;
    private javax.swing.JComboBox<String> cboFilterCliente;
    private javax.swing.JComboBox<String> cboFilterPersonal;
    private javax.swing.JComboBox cboFilterTipoProyecto;
    private javax.swing.JComboBox<String> cboPersonal;
    private javax.swing.JComboBox cboTipoProyecto;
    private com.toedter.calendar.JDateChooser inpFechaConfirmacion;
    private com.toedter.calendar.JDateChooser inpFechaEntrega;
    private com.toedter.calendar.JDateChooser inpFechaTerminacion;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAvg;
    private javax.swing.JLabel lblCargo1;
    private javax.swing.JLabel lblCargo2;
    private javax.swing.JLabel lblFechaCarga;
    private javax.swing.JLabel lblFechaCargaDato;
    private javax.swing.JLabel lblFechaConfirmacion;
    private javax.swing.JLabel lblFechaConfirmacion2;
    private javax.swing.JLabel lblFechaConfirmacion3;
    private javax.swing.JLabel lblFechaConfirmacion4;
    private javax.swing.JLabel lblFechaConfirmacion5;
    private javax.swing.JLabel lblFechaEntrega;
    private javax.swing.JLabel lblFechaTerminacion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombreRequerido;
    private javax.swing.JLabel lblNombreRequerido1;
    private javax.swing.JLabel lblTipoProyecto;
    private javax.swing.JList<String> listPerfilesDer;
    private javax.swing.JList<String> listPerfilesIzq;
    private javax.swing.JPanel panelFechas;
    private javax.swing.JPanel panelProyecto;
    private javax.swing.JPanel panelProyecto1;
    private javax.swing.JScrollPane scrProyectos;
    private javax.swing.JTable tblProyectos;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    
}
