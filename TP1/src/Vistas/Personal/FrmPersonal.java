/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Personal;
import Modelos.Gestion.Perfil;
import Modelos.Gestion.Personal;
import com.toedter.calendar.JDateChooser;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class FrmPersonal extends javax.swing.JInternalFrame {
     private GestorVistaPersonal gestorPersonal;
     private int YES_NO_OPTION;
     private boolean formValido = true;
    /**
     * Creates new form FrmPersonal
     */
     public FrmPersonal(GestorVistaPersonal gestorPersonal) {
        try{
           initComponents();
           }
           catch(Exception e){
        }  
        this.setGestorVistaPersonal(gestorPersonal);
        this.actualizarPerfiles();
        this.getGestorVistaPersonal().cargarTabla(this.tblPersonal);
        this.cargarCombos();
    }

    public JList getListPerfilesDer() {
        return listPerfilesDer;
    }

    public void setListPerfilesDer(JList listPerfilesDer) {
        this.listPerfilesDer = listPerfilesDer;
    }

    public JList<String> getListPerfilesIzq() {
        return listPerfilesIzq;
    }

    public void setListPerfilesIzq(JList<String> listPerfilesIzq) {
        this.listPerfilesIzq = listPerfilesIzq;
    }
    
    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(JTextField txtApellido) {
        this.txtApellido = txtApellido;
    }

    public JDateChooser getInpFechaNacimiento() {
        return inpFechaNacimiento;
    }

    public void settInpFechaNacimiento(JDateChooser inpFechaNacimiento) {
        this.inpFechaNacimiento = inpFechaNacimiento;
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
    
     public JLabel getLblApellidoRequerido(){
        return this.lblApellidoRequerido;
    }
    public void setLblApellidoRequerido(JLabel lblApellidoRequerido) {
        this.lblApellidoRequerido = lblApellidoRequerido;
    }
    
    public JLabel getLblFechaNacimientoRequerido(){
        return this.lblFechaNacimientoRequerido;
    }
    public void setLblFechaNacimientoRequerido(JLabel lblFechaNacimientoRequerido) {
        this.lblFechaNacimientoRequerido = lblFechaNacimientoRequerido;
    }

    public JComboBox getCboCargo() {
        return cboCargo;
    }

    public void setCboCargo(JComboBox cboCargo) {
        this.cboCargo = cboCargo;
    }
    
    public boolean getFormValido(){
        return this.formValido;
    }
    public void setFormValido(boolean formValido){
        this.formValido = formValido;
    }

    public JComboBox<String> getCboBuscarCargo() {
        return cboBuscarCargo;
    }

    public void setCboBuscarCargo(JComboBox<String> cboBuscarCargo) {
        this.cboBuscarCargo = cboBuscarCargo;
    }

    public JDateChooser getInpBuscarFechaDesde() {
        return inpBuscarFechaDesde;
    }

    public void setInpBuscarFechaDesde(JDateChooser inpBuscarFechaDesde) {
        this.inpBuscarFechaDesde = inpBuscarFechaDesde;
    }

    public JDateChooser getInpBuscarFechaHasta() {
        return inpBuscarFechaHasta;
    }

    public void setInpBuscarFechaHasta(JDateChooser inpBuscarFechaHasta) {
        this.inpBuscarFechaHasta = inpBuscarFechaHasta;
    }

    public JTable getTblPersonal() {
        return tblPersonal;
    }

    public void setTblPersonal(JTable tblPersonal) {
        this.tblPersonal = tblPersonal;
    }

    public JTextField getTxtBuscarApellido() {
        return txtBuscarApellido;
    }

    public void setTxtBuscarApellido(JTextField txtBuscarApellido) {
        this.txtBuscarApellido = txtBuscarApellido;
    }

    public JTextField getTxtBuscarNombre() {
        return txtBuscarNombre;
    }

    public void setTxtBuscarNombre(JTextField txtBuscarNombre) {
        this.txtBuscarNombre = txtBuscarNombre;
    }
    
    public FrmPersonal() {
        initComponents();
    }

    public GestorVistaPersonal getGestorVistaPersonal() {
        return gestorPersonal;
    }

    public void setGestorVistaPersonal(GestorVistaPersonal gestorPersonal) {
        this.gestorPersonal = gestorPersonal;
    }
    public void editarPersonal(){
        this.getGestorVistaPersonal().cargarModelo(this.tblPersonal.getSelectedRow());
    }
    public void vistaEditar(){
        this.vistaNuevoPersonal();
        this.botonesNuevo();
        btnGuardar.setText("Actualizar");
    }
    public void nuevoPersonal(){
        this.limpiarPantalla();
        this.vistaNuevoPersonal();
        this.getGestorVistaPersonal().newModel();
        this.botonesNuevo();
    }
    public void cancelar(){
        this.limpiarPantalla();
        this.vistaInicio();
        this.botonesInicio();
        this.getGestorVistaPersonal().newModel();
    }
    public void cargarPersonal(Personal personal){
        this.limpiarPantalla();
        txtNombre.setText(personal.getNombre());
        txtApellido.setText(personal.getApellido());
        inpFechaNacimiento.setDate(personal.getFechaNacimiento());
        cboCargo.setSelectedItem(personal.getCargo());
        this.setPerfiles(personal.getPerfiles());
    }
    public void vistaInicio(){
        this.inpFechaNacimiento.setEnabled(false);
        this.txtNombre.setEnabled(true);
        this.txtApellido.setEnabled(false);
        this.cboCargo.setEnabled(false);
    }
    public void vistaNuevoPersonal(){
        this.inpFechaNacimiento.setEnabled(true);
        this.txtNombre.setEnabled(true);
        this.txtApellido.setEnabled(true);
        this.cboCargo.setEnabled(true);
    }
    
    public void limpiarPantalla(){
        this.txtNombre.setText("");
        this.txtApellido.setText("");
        this.inpFechaNacimiento.setDate(null);
        this.lblApellidoRequerido.setText(" ");
        this.lblNombreRequerido.setText(" ");
        this.lblFechaNacimientoRequerido.setText(" ");
        if (this.cboCargo.getModel().getSize() != 0 ) {
            this.cboCargo.setSelectedIndex(0);
        }
        this.actualizarPerfiles();
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
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(true);
        btnBuscar.setEnabled(true);
     }
     public void guardarPersonal(){
         String dialog;
         if(btnGuardar.getText()=="Guardar"){
              this.getGestorVistaPersonal().guardarPersonal();
              dialog = "Personal guardado exitosamente.";
         }else{
            this.getGestorVistaPersonal().actualizarPersonal();
            dialog = "Personal actualizado exitosamente.";
         }
        this.limpiarPantalla();
        this.vistaInicio();
        this.botonesInicio();
        JOptionPane.showMessageDialog(null, dialog);
    }
     
     public void buscarPersonal(){
         this.getGestorVistaPersonal().buscarPersonal(
                 this.txtBuscarNombre.getText().toUpperCase(),
                 this.txtBuscarApellido.getText().toUpperCase(),
                 this.cboBuscarCargo.getModel().getSelectedItem(),
                 this.inpBuscarFechaDesde.getDate(),
                 this.inpBuscarFechaHasta.getDate());
     }
     
     public void eliminarPersonal(){
         this.getGestorVistaPersonal().eliminarPersonal(this.tblPersonal.getSelectedRow());
     }
      public void cargarCombos() {
        this.getGestorVistaPersonal().setModelCargo(cboCargo);
        this.getGestorVistaPersonal().setModelCargo(cboBuscarCargo);

    }
      
      private void nuevoPerfil() {
        this.getGestorVistaPersonal().nuevoPerfil();
    }
    private void setPerfiles(List listaPerfiles){
        this.getGestorVistaPersonal().moverPerfilesDer(listaPerfiles, this.listPerfilesDer, this.listPerfilesIzq);
    }
    private void moverPerfilesDer() {
        this.getGestorVistaPersonal().moverPerfilesDer(this.listPerfilesIzq.getSelectedValuesList(), this.listPerfilesDer, this.listPerfilesIzq);
    }
     private void moverPerfilesIzq() {
        this.getGestorVistaPersonal().moverPerfilesIzq(this.listPerfilesDer.getSelectedValuesList(), this.listPerfilesIzq, this.listPerfilesDer);
    }
    public void actualizarPerfiles() {
        this.getGestorVistaPersonal().buscarPerfiles(this.listPerfilesIzq);
        this.getGestorVistaPersonal().limpiarPerfiles(this.listPerfilesDer);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        inpFechaNacimiento = new com.toedter.calendar.JDateChooser();
        lblNombreRequerido = new javax.swing.JLabel();
        lblApellidoRequerido = new javax.swing.JLabel();
        lblFechaNacimientoRequerido = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        cboCargo = new javax.swing.JComboBox<>();
        btnActualizarPerfiles = new javax.swing.JButton();
        lblCargo1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPerfilesDer = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listPerfilesIzq = new javax.swing.JList<>();
        btnSacarPerfil = new javax.swing.JButton();
        btnAgregarPerfil = new javax.swing.JButton();
        btnNuevoPerfil = new javax.swing.JButton();
        lblCargo2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        scrContacto = new javax.swing.JScrollPane();
        tblPersonal = new javax.swing.JTable();
        inpBuscarFechaHasta = new com.toedter.calendar.JDateChooser();
        txtBuscarApellido = new javax.swing.JTextField();
        lblApellido1 = new javax.swing.JLabel();
        lblEdad2 = new javax.swing.JLabel();
        inpBuscarFechaDesde = new com.toedter.calendar.JDateChooser();
        lblEdad1 = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        txtBuscarNombre = new javax.swing.JTextField();
        cboBuscarCargo = new javax.swing.JComboBox<>();
        lblCargo3 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setTitle("Personal");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal"));
        jPanel1.setToolTipText("Personal");
        jPanel1.setName("Contacto"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setText("Nombre: ");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblEdad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEdad.setText("Fecha Nacimiento:");
        jPanel1.add(lblEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        lblApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblApellido.setText("Apellido:");
        jPanel1.add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        txtApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtApellido.setToolTipText("Apellido");
        txtApellido.setEnabled(false);
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 190, 30));

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
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 139, -1));

        inpFechaNacimiento.setToolTipText("Fecha de Nacimiento");
        inpFechaNacimiento.setEnabled(false);
        inpFechaNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inpFechaNacimiento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inpFechaNacimientoPropertyChange(evt);
            }
        });
        jPanel1.add(inpFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 240, 26));

        lblNombreRequerido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombreRequerido.setForeground(new java.awt.Color(204, 0, 51));
        lblNombreRequerido.setText(" ");
        jPanel1.add(lblNombreRequerido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 100, -1));

        lblApellidoRequerido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblApellidoRequerido.setForeground(new java.awt.Color(204, 0, 51));
        lblApellidoRequerido.setText(" ");
        jPanel1.add(lblApellidoRequerido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 100, 20));

        lblFechaNacimientoRequerido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaNacimientoRequerido.setForeground(new java.awt.Color(204, 0, 51));
        lblFechaNacimientoRequerido.setText(" ");
        jPanel1.add(lblFechaNacimientoRequerido, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 140, -1));

        lblCargo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCargo.setText("Cargo:");
        jPanel1.add(lblCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        cboCargo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboCargo.setEnabled(false);
        cboCargo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cboCargoPopupMenuWillBecomeVisible(evt);
            }
        });
        cboCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCargoActionPerformed(evt);
            }
        });
        jPanel1.add(cboCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 240, 20));

        btnActualizarPerfiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add.png"))); // NOI18N
        btnActualizarPerfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPerfilesActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarPerfiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 40, 40));

        lblCargo1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCargo1.setText("Perfiles asignados:");
        jPanel1.add(lblCargo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        jScrollPane1.setViewportView(listPerfilesDer);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 180, 190));

        jScrollPane2.setViewportView(listPerfilesIzq);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 180, 190));

        btnSacarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/flecha-izquierda.png"))); // NOI18N
        btnSacarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacarPerfilActionPerformed(evt);
            }
        });
        jPanel1.add(btnSacarPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 40, 40));

        btnAgregarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/flecha-derecha.png"))); // NOI18N
        btnAgregarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPerfilActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 40, 40));

        btnNuevoPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/actualizar.png"))); // NOI18N
        btnNuevoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPerfilActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 40, 40));

        lblCargo2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCargo2.setText("Perfiles:");
        jPanel1.add(lblCargo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevo)
                        .addComponent(btnEditar)
                        .addComponent(btnGuardar)))
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
                .addContainerGap(38, Short.MAX_VALUE)
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));

        tblPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPersonal.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPersonal.getTableHeader().setReorderingAllowed(false);
        scrContacto.setViewportView(tblPersonal);

        inpBuscarFechaHasta.setToolTipText("Fecha de Nacimiento");
        inpBuscarFechaHasta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inpBuscarFechaHasta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inpBuscarFechaHastaPropertyChange(evt);
            }
        });

        txtBuscarApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscarApellido.setToolTipText("Nombre");
        txtBuscarApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarApellidoActionPerformed(evt);
            }
        });
        txtBuscarApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarApellidoKeyTyped(evt);
            }
        });

        lblApellido1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblApellido1.setText("Apellido:");

        lblEdad2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEdad2.setText("Fecha Nac. Hasta:");

        inpBuscarFechaDesde.setToolTipText("Fecha de Nacimiento");
        inpBuscarFechaDesde.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inpBuscarFechaDesde.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inpBuscarFechaDesdePropertyChange(evt);
            }
        });

        lblEdad1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEdad1.setText("Fecha Nac. Desde:");

        lblNombre1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre1.setText("Nombre: ");

        txtBuscarNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscarNombre.setToolTipText("Nombre");
        txtBuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarNombreActionPerformed(evt);
            }
        });
        txtBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarNombreKeyTyped(evt);
            }
        });

        cboBuscarCargo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboBuscarCargo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cboBuscarCargoPopupMenuWillBecomeVisible(evt);
            }
        });
        cboBuscarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBuscarCargoActionPerformed(evt);
            }
        });

        lblCargo3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCargo3.setText("Cargo:");

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(scrContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(lblNombre1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(lblApellido1))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblEdad2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inpBuscarFechaHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblEdad1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inpBuscarFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(61, 61, 61)
                                .addComponent(lblCargo3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtBuscarApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cboBuscarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNombre1)
                        .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblApellido1)
                        .addComponent(btnBuscar)))
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEdad1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inpBuscarFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblCargo3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEdad2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inpBuscarFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cboBuscarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Descripcion");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.nuevoPersonal();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       this.editarPersonal();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       String mensaje = this.getGestorVistaPersonal().revisarFormulario();
       if(this.formValido){
            if (JOptionPane.showConfirmDialog(null, (btnGuardar.getText()=="Guardar") ? "¿Desea guardar el contacto seleccionado?":"¿Desea actualizar el contacto seleccionado?","Atencion", YES_NO_OPTION) == 0 )
            this.guardarPersonal();
       }else{
           JOptionPane.showMessageDialog(null, "Error al enviar el formulario."+mensaje);
           this.formValido = true;
       }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        this.eliminarPersonal();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       this.cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnActualizarPerfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPerfilesActionPerformed
        this.nuevoPerfil();
    }//GEN-LAST:event_btnActualizarPerfilesActionPerformed

    private void cboCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCargoActionPerformed

    private void cboCargoPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboCargoPopupMenuWillBecomeVisible
        this.cargarCombos();
    }//GEN-LAST:event_cboCargoPopupMenuWillBecomeVisible

    private void inpFechaNacimientoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inpFechaNacimientoPropertyChange
        this.lblFechaNacimientoRequerido.setText(" ");
    }//GEN-LAST:event_inpFechaNacimientoPropertyChange

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.buscarPersonal();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        this.lblNombreRequerido.setText(" ");
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        this.lblApellidoRequerido.setText(" ");
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void btnNuevoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPerfilActionPerformed
        this.actualizarPerfiles();
    }//GEN-LAST:event_btnNuevoPerfilActionPerformed

    private void btnAgregarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPerfilActionPerformed
        this.moverPerfilesDer();
    }//GEN-LAST:event_btnAgregarPerfilActionPerformed

    private void btnSacarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacarPerfilActionPerformed
        this.moverPerfilesIzq();
    }//GEN-LAST:event_btnSacarPerfilActionPerformed

    private void inpBuscarFechaHastaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inpBuscarFechaHastaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_inpBuscarFechaHastaPropertyChange

    private void txtBuscarApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarApellidoActionPerformed

    private void txtBuscarApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarApellidoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarApellidoKeyTyped

    private void inpBuscarFechaDesdePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inpBuscarFechaDesdePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_inpBuscarFechaDesdePropertyChange

    private void txtBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarNombreActionPerformed

    private void txtBuscarNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarNombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarNombreKeyTyped

    private void cboBuscarCargoPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboBuscarCargoPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cboBuscarCargoPopupMenuWillBecomeVisible

    private void cboBuscarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBuscarCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboBuscarCargoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarPerfiles;
    private javax.swing.JButton btnAgregarPerfil;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevoPerfil;
    private javax.swing.JButton btnSacarPerfil;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboBuscarCargo;
    private javax.swing.JComboBox<String> cboCargo;
    private com.toedter.calendar.JDateChooser inpBuscarFechaDesde;
    private com.toedter.calendar.JDateChooser inpBuscarFechaHasta;
    private com.toedter.calendar.JDateChooser inpFechaNacimiento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblApellidoRequerido;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCargo1;
    private javax.swing.JLabel lblCargo2;
    private javax.swing.JLabel lblCargo3;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEdad1;
    private javax.swing.JLabel lblEdad2;
    private javax.swing.JLabel lblFechaNacimientoRequerido;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombreRequerido;
    private javax.swing.JList<String> listPerfilesDer;
    private javax.swing.JList<String> listPerfilesIzq;
    private javax.swing.JScrollPane scrContacto;
    private javax.swing.JTable tblPersonal;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscarApellido;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
