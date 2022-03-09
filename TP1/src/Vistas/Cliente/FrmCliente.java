/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Cliente;

import Modelos.Gestion.Cliente;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class FrmCliente extends javax.swing.JInternalFrame {
     private GestorVistaCliente gestorCliente;
     private int YES_NO_OPTION;
     private boolean formValido = true;
    /**
     * Creates new form FrmContacto
     */
     public FrmCliente(GestorVistaCliente gestorCliente) {
         try{
           initComponents();
        }
        catch(Exception e){
            
        }  
        this.setGestorVistaCliente(gestorCliente);
        this.getGestorVistaCliente().cargarTabla(this.tblCliente);
    }
     
    public FrmCliente() {
       
        initComponents();
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
    
    public boolean getFormValido(){
        return this.formValido;
    }
    public void setFormValido(boolean formValido){
        this.formValido = formValido;
    }
    
    public GestorVistaCliente getGestorVistaCliente() {
        return gestorCliente;
    }

    public void setGestorVistaCliente(GestorVistaCliente gestorCliente) {
        this.gestorCliente = gestorCliente;
    }

    public JDateChooser getInpBuscarFechaDesde() {
        return inpBuscarFechaDesde;
    }

    public void setInpBuscarFechaDesde(JDateChooser inpBuscarFechaDesde) {
        this.inpBuscarFechaDesde = inpBuscarFechaDesde;
    }

    public JTable getTblCliente() {
        return tblCliente;
    }

    public void setTblCliente(JTable tblCliente) {
        this.tblCliente = tblCliente;
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
    
    public void editarCliente(){
        this.getGestorVistaCliente().cargarModelo(this.tblCliente.getSelectedRow());
    }
    public void vistaEditar(){
        this.vistaNuevoCliente();
        this.botonesNuevo();
        btnGuardar.setText("Actualizar");
    }
    public void nuevoCliente(){
        this.limpiarPantalla();
        this.vistaNuevoCliente();
        this.getGestorVistaCliente().newModel();
        this.botonesNuevo();
    }
    public void cancelar(){
        this.limpiarPantalla();
        this.vistaInicio();
        this.botonesInicio();
    }
    public void cargarCliente(Cliente cliente){
        this.limpiarPantalla();
        txtNombre.setText(cliente.getNombre());
        txtApellido.setText(cliente.getApellido());
        inpFechaNacimiento.setDate(cliente.getFechaNacimiento());
    }
    public void vistaInicio(){
        this.inpFechaNacimiento.setEnabled(false);
        this.txtNombre.setEnabled(false);
        this.txtApellido.setEnabled(false);
    }
    public void vistaNuevoCliente(){
        this.inpFechaNacimiento.setEnabled(true);
        this.txtNombre.setEnabled(true);
        this.txtApellido.setEnabled(true);
    }
    
    public void limpiarPantalla(){
        this.txtNombre.setText("");
        this.txtApellido.setText("");
        this.inpFechaNacimiento.setDate(null);
        this.lblApellidoRequerido.setText(" ");
        this.lblNombreRequerido.setText(" ");
        this.lblFechaNacimientoRequerido.setText(" ");
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
     public void guardarCliente(){
         String dialog;
         if(btnGuardar.getText()=="Guardar"){
              this.getGestorVistaCliente().guardarCliente();
              dialog = "Cliente guardado exitosamente.";
         }else{
            this.getGestorVistaCliente().actualizarCliente();
            dialog = "Cliente actualizado exitosamente.";
         }
        this.limpiarPantalla();
        this.vistaInicio();
        this.botonesInicio();
        JOptionPane.showMessageDialog(null, dialog);
    }
     
     public void buscarCliente(){
         this.getGestorVistaCliente().buscarCliente(
                 this.txtBuscarNombre.getText().toUpperCase(),
                 this.txtBuscarApellido.getText().toUpperCase(),
                 this.inpBuscarFechaDesde.getDate(),
                 this.inpBuscarFechaHasta.getDate());
     }
     
     public void eliminarCliente(){
         this.getGestorVistaCliente().eliminarCliente();
         this.vistaInicio();
         this.limpiarPantalla();
         this.botonesInicio();
         JOptionPane.showMessageDialog(null, "Contacto eliminado exitosamente");
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
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtBuscarNombre = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        lblEdad1 = new javax.swing.JLabel();
        inpBuscarFechaDesde = new com.toedter.calendar.JDateChooser();
        lblEdad2 = new javax.swing.JLabel();
        lblApellido1 = new javax.swing.JLabel();
        txtBuscarApellido = new javax.swing.JTextField();
        inpBuscarFechaHasta = new com.toedter.calendar.JDateChooser();
        scrContacto = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setTitle("Cliente");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        jPanel1.setToolTipText("Cliente");
        jPanel1.setName("Contacto"); // NOI18N
        jPanel1.setLayout(null);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setText("Nombre: ");
        jPanel1.add(lblNombre);
        lblNombre.setBounds(30, 30, 70, 20);

        lblEdad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEdad.setText("Fecha Nacimiento:");
        jPanel1.add(lblEdad);
        lblEdad.setBounds(30, 190, 120, 20);

        lblApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblApellido.setText("Apellido:");
        jPanel1.add(lblApellido);
        lblApellido.setBounds(30, 110, 60, 20);

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
        jPanel1.add(txtApellido);
        txtApellido.setBounds(30, 130, 135, 26);

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
        jPanel1.add(txtNombre);
        txtNombre.setBounds(30, 50, 139, 26);

        inpFechaNacimiento.setToolTipText("Fecha de Nacimiento");
        inpFechaNacimiento.setEnabled(false);
        inpFechaNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inpFechaNacimiento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inpFechaNacimientoPropertyChange(evt);
            }
        });
        jPanel1.add(inpFechaNacimiento);
        inpFechaNacimiento.setBounds(30, 210, 161, 26);

        lblNombreRequerido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombreRequerido.setForeground(new java.awt.Color(204, 0, 51));
        lblNombreRequerido.setText(" ");
        jPanel1.add(lblNombreRequerido);
        lblNombreRequerido.setBounds(30, 80, 100, 20);

        lblApellidoRequerido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblApellidoRequerido.setForeground(new java.awt.Color(204, 0, 51));
        lblApellidoRequerido.setText(" ");
        jPanel1.add(lblApellidoRequerido);
        lblApellidoRequerido.setBounds(30, 160, 100, 20);

        lblFechaNacimientoRequerido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaNacimientoRequerido.setForeground(new java.awt.Color(204, 0, 51));
        lblFechaNacimientoRequerido.setText(" ");
        jPanel1.add(lblFechaNacimientoRequerido);
        lblFechaNacimientoRequerido.setBounds(30, 240, 111, 20);

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
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));

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

        lblNombre1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre1.setText("Nombre: ");

        lblEdad1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEdad1.setText("Fecha Nac. Desde:");

        inpBuscarFechaDesde.setToolTipText("Fecha de Nacimiento");
        inpBuscarFechaDesde.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inpBuscarFechaDesde.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inpBuscarFechaDesdePropertyChange(evt);
            }
        });

        lblEdad2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEdad2.setText("Fecha Nac. Hasta:");

        lblApellido1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblApellido1.setText("Apellido:");

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

        inpBuscarFechaHasta.setToolTipText("Fecha de Nacimiento");
        inpBuscarFechaHasta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inpBuscarFechaHasta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inpBuscarFechaHastaPropertyChange(evt);
            }
        });

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCliente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblCliente.getTableHeader().setReorderingAllowed(false);
        scrContacto.setViewportView(tblCliente);

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
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblEdad1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inpBuscarFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(lblNombre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(323, 323, 323)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(lblApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txtBuscarApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(lblEdad2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(inpBuscarFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(132, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre1)
                    .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEdad1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inpBuscarFechaDesde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblApellido1)
                        .addComponent(txtBuscarApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblEdad2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inpBuscarFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(277, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Descripcion");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.nuevoCliente();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       this.editarCliente();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       String mensaje = this.getGestorVistaCliente().revisarFormulario();
       if(this.formValido){
            if (JOptionPane.showConfirmDialog(null, (btnGuardar.getText()=="Guardar") ? "¿Desea guardar el contacto seleccionado?":"¿Desea actualizar el contacto seleccionado?","Atencion", YES_NO_OPTION) == 0 )
            this.guardarCliente();
       }else{
           JOptionPane.showMessageDialog(null, "Error al enviar el formulario."+mensaje);
           this.formValido = true;
       }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el contacto seleccionado?","Atencion", YES_NO_OPTION) == 0 )
           this.eliminarCliente();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       this.cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void inpFechaNacimientoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inpFechaNacimientoPropertyChange
        this.lblFechaNacimientoRequerido.setText(" ");
    }//GEN-LAST:event_inpFechaNacimientoPropertyChange

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.buscarCliente();
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

    private void txtBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarNombreActionPerformed

    private void txtBuscarNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarNombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarNombreKeyTyped

    private void inpBuscarFechaDesdePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inpBuscarFechaDesdePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_inpBuscarFechaDesdePropertyChange

    private void txtBuscarApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarApellidoActionPerformed

    private void txtBuscarApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarApellidoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarApellidoKeyTyped

    private void inpBuscarFechaHastaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inpBuscarFechaHastaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_inpBuscarFechaHastaPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private com.toedter.calendar.JDateChooser inpBuscarFechaDesde;
    private com.toedter.calendar.JDateChooser inpBuscarFechaHasta;
    private com.toedter.calendar.JDateChooser inpFechaNacimiento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblApellidoRequerido;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEdad1;
    private javax.swing.JLabel lblEdad2;
    private javax.swing.JLabel lblFechaNacimientoRequerido;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombreRequerido;
    private javax.swing.JScrollPane scrContacto;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscarApellido;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
