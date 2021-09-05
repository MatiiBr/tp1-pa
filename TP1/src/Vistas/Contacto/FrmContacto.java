/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Contacto;

import Modelos.Gestion.Contacto;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Usuario
 */
public class FrmContacto extends javax.swing.JInternalFrame {
     private GestorVistaContacto gestorContacto;
     private int YES_NO_OPTION;
     private boolean formValido = true;
    /**
     * Creates new form FrmContacto
     */
     public FrmContacto(GestorVistaContacto gestorContacto) {
        try{
           initComponents();
           }
           catch(Exception e){
            
        }  
        this.setGestorVistaContacto(gestorContacto);
        //this.onViewOpened();
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
      public JTable getTblContacto() {
        return tblContacto;
    }

    public void setTblContacto(JTable tblContacto) {
        this.tblContacto = tblContacto;
    }
    public FrmContacto() {
        initComponents();
    }

    public GestorVistaContacto getGestorVistaContacto() {
        return gestorContacto;
    }

    public void setGestorVistaContacto(GestorVistaContacto gestorContacto) {
        this.gestorContacto = gestorContacto;
    }
    public void editarContacto(){
        this.vistaNuevoContacto();
        this.botonesNuevo();
        btnGuardar.setText("Actualizar");
    }
    public void nuevoContacto(){
        this.limpiarPantalla();
        this.vistaNuevoContacto();
        this.getGestorVistaContacto().newModel();
        this.botonesNuevo();
    }
    public void cancelar(){
        this.limpiarPantalla();
        this.vistaInicio();
        this.botonesInicio();
    }
    public void cargarContacto(Contacto contacto){
        this.limpiarPantalla();
        this.vistaInicio();
        txtNombre.setText(contacto.getNombre());
        txtApellido.setText(contacto.getApellido());
        inpFechaNacimiento.setDate(contacto.getFechaNacimiento());
    }
    public void vistaInicio(){
        this.inpFechaNacimiento.setEnabled(false);
        this.txtNombre.setEnabled(true);
        this.txtApellido.setEnabled(false);
    }
    public void vistaNuevoContacto(){
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
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(true);
        btnBuscar.setEnabled(true);
     }
     public void guardarContacto(){
         String dialog;
         if(btnGuardar.getText()=="Guardar"){
              this.getGestorVistaContacto().guardarContacto();
              dialog = "Contacto guardado exitosamente.";
         }else{
            this.getGestorVistaContacto().actualizarContacto();
            dialog = "Contacto actualizado exitosamente.";
         }
        this.limpiarPantalla();
        this.vistaInicio();
        this.botonesInicio();
        JOptionPane.showMessageDialog(null, dialog);
    }
     public void revisarFormulario(){
         if(this.txtNombre.getText().isEmpty()){
             this.lblNombreRequerido.setText("Requerido.");
             this.formValido = false;
         }
         if(this.txtApellido.getText().isEmpty()){
             this.lblApellidoRequerido.setText("Requerido.");
             this.formValido = false;
         }
         if(this.inpFechaNacimiento.getDate()==null){
             this.lblFechaNacimientoRequerido.setText("Requerido.");
             this.formValido = false;
         }else if(!verificarEdad()){
             this.lblFechaNacimientoRequerido.setText("La edad debe ser mayor o igual a 18 años.");
             this.formValido = false;
         }
     }
     public boolean verificarEdad(){
         var date = new Date();
         int edad = 0;
         if (this.inpFechaNacimiento.getDate().getYear() < date.getYear()) {
           edad = (date.getYear()) - (this.inpFechaNacimiento.getDate().getYear());
           if(this.inpFechaNacimiento.getDate().getMonth() > date.getMonth() ) {
               edad--;
           } else if(this.inpFechaNacimiento.getDate().getMonth() == date.getMonth()) {
               if(this.inpFechaNacimiento.getDate().getDate() > date.getDate() ) {
                   edad--;
               }
           }
         }
         return edad>=18;
     }
     
     public void buscarContacto(){
         if(this.txtNombre.getText().isBlank()){
             JOptionPane.showMessageDialog(null, "Debe ingresar un nombre de contacto antes de buscar.");
             this.limpiarPantalla();
         }else{
            if(!this.getGestorVistaContacto().buscarContacto(txtNombre.getText().toUpperCase())){
                JOptionPane.showMessageDialog(null, "No se encontro un contacto con el nombre ingresado.");
                this.limpiarPantalla();
            }else{
                this.botonesListado();
            };
             /*DefaultTableModel contactoModel = new DefaultTableModel();
             contactoModel.addColumn("Nombre");
             contactoModel.addColumn("Apellido");
             contactoModel.addColumn("Fecha de Nacimiento");
             this.tblContacto.setModel(contactoModel); */
             
         }
     }
     
     public void eliminarContacto(){
         this.getGestorVistaContacto().eliminarContacto();
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
        btnBuscar = new javax.swing.JButton();
        inpFechaNacimiento = new com.toedter.calendar.JDateChooser();
        lblNombreRequerido = new javax.swing.JLabel();
        lblApellidoRequerido = new javax.swing.JLabel();
        lblFechaNacimientoRequerido = new javax.swing.JLabel();
        scrContacto = new javax.swing.JScrollPane();
        tblContacto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setTitle("Contacto");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Contacto"));
        jPanel1.setToolTipText("Contacto");
        jPanel1.setName("Contacto"); // NOI18N

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setText("Nombre: ");

        lblEdad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEdad.setText("Fecha Nacimiento:");

        lblApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblApellido.setText("Apellido:");

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

        inpFechaNacimiento.setToolTipText("Fecha de Nacimiento");
        inpFechaNacimiento.setEnabled(false);
        inpFechaNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inpFechaNacimiento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inpFechaNacimientoPropertyChange(evt);
            }
        });

        lblNombreRequerido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombreRequerido.setForeground(new java.awt.Color(204, 0, 51));
        lblNombreRequerido.setText(" ");

        lblApellidoRequerido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblApellidoRequerido.setForeground(new java.awt.Color(204, 0, 51));
        lblApellidoRequerido.setText(" ");

        lblFechaNacimientoRequerido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaNacimientoRequerido.setForeground(new java.awt.Color(204, 0, 51));
        lblFechaNacimientoRequerido.setText(" ");

        tblContacto.setAutoCreateColumnsFromModel(false);
        tblContacto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblContacto.setFillsViewportHeight(true);
        scrContacto.setViewportView(tblContacto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(lblNombre)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreRequerido)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblApellido)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellidoRequerido)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblEdad)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inpFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFechaNacimientoRequerido))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(scrContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre)
                    .addComponent(btnBuscar))
                .addGap(2, 2, 2)
                .addComponent(lblNombreRequerido)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblApellidoRequerido)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inpFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEdad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFechaNacimientoRequerido)
                .addGap(47, 47, 47))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addGap(57, 57, 57))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addContainerGap())
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Descripcion");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.nuevoContacto();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       this.editarContacto();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       this.revisarFormulario();
       if(this.formValido){
            if (JOptionPane.showConfirmDialog(null, (btnGuardar.getText()=="Guardar") ? "¿Desea guardar el contacto seleccionado?":"¿Desea actualizar el contacto seleccionado?","Atencion", YES_NO_OPTION) == 0 )
            this.guardarContacto();
       }else{
           JOptionPane.showMessageDialog(null, "Error al enviar el formulario");
           this.formValido = true;
       }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el contacto seleccionado?","Atencion", YES_NO_OPTION) == 0 )
           this.eliminarContacto();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       this.cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.buscarContacto();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
       this.lblNombreRequerido.setText(" ");
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        this.lblApellidoRequerido.setText(" ");
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void inpFechaNacimientoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inpFechaNacimientoPropertyChange
        this.lblFechaNacimientoRequerido.setText(" ");
    }//GEN-LAST:event_inpFechaNacimientoPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private com.toedter.calendar.JDateChooser inpFechaNacimiento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellidoRequerido;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblFechaNacimientoRequerido;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreRequerido;
    private javax.swing.JScrollPane scrContacto;
    private javax.swing.JTable tblContacto;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
