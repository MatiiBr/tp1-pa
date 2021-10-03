/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Proyecto;

import Modelos.Gestion.Proyecto;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
        this.vistaInicio();
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
        btnEditar.setEnabled(false);
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
         String dialog;
         if("Guardar".equals(btnGuardar.getText())){
              this.getGestorVistaProyecto().guardarProyecto();
              dialog = "Proyecto guardado exitosamente.";
         }else{
            this.getGestorVistaProyecto().actualizarProyecto();
            dialog = "Proyecto actualizado exitosamente.";
         }
        this.limpiarPantalla();
        this.vistaInicio();
        this.botonesInicio();
        JOptionPane.showMessageDialog(null, dialog);
    }
     
     public void buscarProyecto(){
         if(this.txtNombre.getText().isBlank()){
             JOptionPane.showMessageDialog(null, "Debe ingresar un nombre de proyecto antes de buscar.");
             this.limpiarPantalla();
         }else{
            if(!this.getGestorVistaProyecto().buscarProyecto(txtNombre.getText().toUpperCase())){
                JOptionPane.showMessageDialog(null, "No se encontro un proyecto con el nombre ingresado.");
                this.limpiarPantalla();
            }else{
                this.botonesListado();
            };
         }
     }
     
     public void eliminarProyecto(){
         this.getGestorVistaProyecto().eliminarProyecto();
         this.vistaInicio();
         this.limpiarPantalla();
         this.botonesInicio();
         JOptionPane.showMessageDialog(null, "Proyecto eliminado exitosamente");
     }
     
    public void cargarCombos() {
        this.gestorProyecto.setModelTipoProyecto(cboTipoProyecto);
         this.gestorProyecto.setModelCliente(cboCliente);
         this.gestorProyecto.setModelPersonal(cboPersonal);
    }
    
    public void limpiarCombos(){
         this.cboTipoProyecto.setSelectedIndex(0);
         this.cboPersonal.setSelectedIndex(0);
         this.cboCliente.setSelectedIndex(0);
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
        btnBuscar = new javax.swing.JButton();
        lblNombreRequerido = new javax.swing.JLabel();
        lblTipoProyecto = new javax.swing.JLabel();
        cboTipoProyecto = new javax.swing.JComboBox();
        cboCliente = new javax.swing.JComboBox<>();
        lblFechaConfirmacion2 = new javax.swing.JLabel();
        lblFechaConfirmacion3 = new javax.swing.JLabel();
        cboPersonal = new javax.swing.JComboBox<>();
        btnCliente = new javax.swing.JButton();
        btnPersonal = new javax.swing.JButton();
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

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setResizable(true);
        setTitle("Proyecto");
        setToolTipText("Proyecto");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelProyecto.setBorder(javax.swing.BorderFactory.createTitledBorder("Proyecto"));
        panelProyecto.setToolTipText("Proyecto");
        panelProyecto.setName("Contacto"); // NOI18N

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setText("Nombre: ");

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

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblNombreRequerido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombreRequerido.setForeground(new java.awt.Color(204, 0, 51));
        lblNombreRequerido.setText(" ");

        lblTipoProyecto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTipoProyecto.setText("Tipo Proyecto:");

        cboTipoProyecto.setToolTipText("Seleccione.");
        cboTipoProyecto.setEnabled(false);
        cboTipoProyecto.setName(""); // NOI18N
        cboTipoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoProyectoActionPerformed(evt);
            }
        });

        cboCliente.setToolTipText("Seleccione.");
        cboCliente.setEnabled(false);
        cboCliente.setName(""); // NOI18N
        cboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboClienteActionPerformed(evt);
            }
        });

        lblFechaConfirmacion2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaConfirmacion2.setText("Cliente:");

        lblFechaConfirmacion3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaConfirmacion3.setText("Personal:");

        cboPersonal.setToolTipText("Seleccione.");
        cboPersonal.setEnabled(false);
        cboPersonal.setName(""); // NOI18N
        cboPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPersonalActionPerformed(evt);
            }
        });

        btnCliente.setIcon(new javax.swing.ImageIcon("D:\\Usuario\\Downloads\\add-user (1).png")); // NOI18N
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnPersonal.setIcon(new javax.swing.ImageIcon("D:\\Usuario\\Downloads\\add-user (1).png")); // NOI18N
        btnPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProyectoLayout = new javax.swing.GroupLayout(panelProyecto);
        panelProyecto.setLayout(panelProyectoLayout);
        panelProyectoLayout.setHorizontalGroup(
            panelProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProyectoLayout.createSequentialGroup()
                .addGroup(panelProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProyectoLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(panelProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTipoProyecto)
                            .addComponent(lblNombre)
                            .addComponent(lblFechaConfirmacion2)
                            .addComponent(lblFechaConfirmacion3))
                        .addGap(18, 18, 18)
                        .addGroup(panelProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addComponent(cboTipoProyecto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar)
                            .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelProyectoLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(lblNombreRequerido)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelProyectoLayout.setVerticalGroup(
            panelProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProyectoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre)
                    .addComponent(btnBuscar))
                .addGap(27, 27, 27)
                .addGroup(panelProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoProyecto)
                    .addComponent(cboTipoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelProyectoLayout.createSequentialGroup()
                        .addGroup(panelProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblFechaConfirmacion2)
                                .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(panelProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFechaConfirmacion3)
                            .addComponent(cboPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(lblNombreRequerido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cboTipoProyecto.getAccessibleContext().setAccessibleName("");

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
        btnEditar.setEnabled(false);
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
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(btnCancelar)
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

        lblFechaTerminacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaTerminacion.setText("Fecha Terminacion:");

        lblFechaConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaConfirmacion.setText("Fecha Confirmacion:");

        inpFechaConfirmacion.setToolTipText("Fecha de Nacimiento");
        inpFechaConfirmacion.setEnabled(false);
        inpFechaConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inpFechaConfirmacion.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inpFechaConfirmacionPropertyChange(evt);
            }
        });

        inpFechaTerminacion.setToolTipText("Fecha de Nacimiento");
        inpFechaTerminacion.setEnabled(false);
        inpFechaTerminacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inpFechaTerminacion.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inpFechaTerminacionPropertyChange(evt);
            }
        });

        inpFechaEntrega.setToolTipText("Fecha de Nacimiento");
        inpFechaEntrega.setEnabled(false);
        inpFechaEntrega.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inpFechaEntrega.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inpFechaEntregaPropertyChange(evt);
            }
        });

        lblFechaEntrega.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaEntrega.setText("Fecha Entrega:");

        lblFechaCarga.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaCarga.setText("Fecha Carga:");

        lblFechaCargaDato.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelFechasLayout = new javax.swing.GroupLayout(panelFechas);
        panelFechas.setLayout(panelFechasLayout);
        panelFechasLayout.setHorizontalGroup(
            panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechasLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFechasLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelFechasLayout.createSequentialGroup()
                                .addComponent(lblFechaEntrega)
                                .addGap(18, 18, 18)
                                .addComponent(inpFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelFechasLayout.createSequentialGroup()
                                .addComponent(lblFechaTerminacion)
                                .addGap(18, 18, 18)
                                .addComponent(inpFechaTerminacion, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechasLayout.createSequentialGroup()
                        .addGroup(panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFechaCarga)
                            .addComponent(lblFechaConfirmacion))
                        .addGap(18, 18, 18)
                        .addGroup(panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inpFechaConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFechaCargaDato))
                        .addGap(1, 1, 1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFechasLayout.setVerticalGroup(
            panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechasLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaCarga)
                    .addComponent(lblFechaCargaDato))
                .addGap(18, 18, 18)
                .addGroup(panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaConfirmacion)
                    .addComponent(inpFechaConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaTerminacion)
                    .addComponent(inpFechaTerminacion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaEntrega)
                    .addComponent(inpFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelFechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
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
       this.getGestorVistaProyecto().revisarFormulario();
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
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void inpFechaTerminacionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inpFechaTerminacionPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_inpFechaTerminacionPropertyChange

    private void inpFechaEntregaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inpFechaEntregaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_inpFechaEntregaPropertyChange

    private void inpFechaConfirmacionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inpFechaConfirmacionPropertyChange
        
    }//GEN-LAST:event_inpFechaConfirmacionPropertyChange

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.buscarProyecto();
    }//GEN-LAST:event_btnBuscarActionPerformed

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
        // TODO add your handling code here:
    }//GEN-LAST:event_cboClienteActionPerformed

    private void cboPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPersonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPersonalActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
       //this.nuevoCliente()
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalActionPerformed
       //this.nuevoPersonal()
    }//GEN-LAST:event_btnPersonalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPersonal;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboCliente;
    private javax.swing.JComboBox<String> cboPersonal;
    private javax.swing.JComboBox cboTipoProyecto;
    private com.toedter.calendar.JDateChooser inpFechaConfirmacion;
    private com.toedter.calendar.JDateChooser inpFechaEntrega;
    private com.toedter.calendar.JDateChooser inpFechaTerminacion;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblFechaCarga;
    private javax.swing.JLabel lblFechaCargaDato;
    private javax.swing.JLabel lblFechaConfirmacion;
    private javax.swing.JLabel lblFechaConfirmacion2;
    private javax.swing.JLabel lblFechaConfirmacion3;
    private javax.swing.JLabel lblFechaEntrega;
    private javax.swing.JLabel lblFechaTerminacion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreRequerido;
    private javax.swing.JLabel lblTipoProyecto;
    private javax.swing.JPanel panelFechas;
    private javax.swing.JPanel panelProyecto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
