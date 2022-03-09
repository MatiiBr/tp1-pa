/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas.TipoProyecto;

import Vistas.TipoProyecto.GestorVistaTipoProyecto;
import Modelos.Gestion.TipoProyecto;
import Vistas.Proyecto.GestorVistaProyecto;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class FrmTipoProyecto extends javax.swing.JInternalFrame {

    /** Creates new form FrmTipoProyectoo */
     private GestorVistaTipoProyecto gestorTipoProyecto;
     private int YES_NO_OPTION;
     private boolean formValido = true;
    /**
     * Creates new form FrmTipoProyecto
     */
    public FrmTipoProyecto() {
        initComponents();
    }

    FrmTipoProyecto(GestorVistaTipoProyecto gestor) {
        try{
           initComponents();
           }
           catch(Exception e){
            
        }  
        this.setGestorVistaTipoProyecto(gestor);
        this.getGestorVistaTipoProyecto().newModel();
        this.vistaInicio();
        this.getGestorVistaTipoProyecto().cargarTabla(this.tblTipoProyecto);
    }

    public GestorVistaTipoProyecto getGestorVistaTipoProyecto() {
        return gestorTipoProyecto;
    }

    public void setGestorVistaTipoProyecto(GestorVistaTipoProyecto gestorTipoProyecto) {
        this.gestorTipoProyecto = gestorTipoProyecto;
    }

    public boolean isFormValido() {
        return formValido;
    }

    public void setFormValido(boolean formValido) {
        this.formValido = formValido;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(JButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnNuevo() {
        return btnNuevo;
    }

    public void setBtnNuevo(JButton btnNuevo) {
        this.btnNuevo = btnNuevo;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public void setBtnSalir(JButton btnSalir) {
        this.btnSalir = btnSalir;
    }

    public JTextArea getjTxtDescripcion() {
        return jTxtDescripcion;
    }

    public void setjTxtDescripcion(JTextArea jTxtDescripcion) {
        this.jTxtDescripcion = jTxtDescripcion;
    }

    public JPanel getPanelTipoProyecto() {
        return panelTipoProyecto;
    }

    public void setPanelTipoProyecto(JPanel panelTipoProyecto) {
        this.panelTipoProyecto = panelTipoProyecto;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JLabel getLblNombreRequerido() {
        return lblNombreRequerido;
    }

    public void setLblNombreRequerido(JLabel lblNombreRequerido) {
        this.lblNombreRequerido = lblNombreRequerido;
    }

    public JTextArea getjTxtBuscarDescripcion() {
        return jTxtBuscarDescripcion;
    }

    public void setjTxtBuscarDescripcion(JTextArea jTxtBuscarDescripcion) {
        this.jTxtBuscarDescripcion = jTxtBuscarDescripcion;
    }

    public JTable getTblTipoProyecto() {
        return tblTipoProyecto;
    }

    public void setTblTipoProyecto(JTable tblTipoProyecto) {
        this.tblTipoProyecto = tblTipoProyecto;
    }

    public JTextField getTxtBuscarNombre() {
        return txtBuscarNombre;
    }

    public void setTxtBuscarNombre(JTextField txtBuscarNombre) {
        this.txtBuscarNombre = txtBuscarNombre;
    }
    
    private void nuevoTipoProyecto() {
        this.limpiarPantalla();
        this.vistaNuevoProyecto();
        this.botonesNuevo();
    }
    private void vistaNuevoProyecto() {
        this.txtNombre.setEnabled(true);
        this.btnBuscar.setEnabled(false);
        this.jTxtDescripcion.setEnabled(true);
        
    }
    private void botonesNuevo() {
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(false);
        btnBuscar.setEnabled(false);
    }

    private void limpiarPantalla() {
        this.txtNombre.setText("");
        this.jTxtDescripcion.setText(" ");
    }

    private void editarProyecto() {
        this.getGestorVistaTipoProyecto().cargarModelo(this.tblTipoProyecto.getSelectedRow());
    }
    public void vistaEditar(){
        this.vistaNuevoTipoProyecto();
        this.botonesNuevo();
        btnGuardar.setText("Actualizar");
    }
    private void vistaNuevoTipoProyecto() {
        this.txtNombre.setEnabled(true);
        this.btnBuscar.setEnabled(false);
        this.jTxtDescripcion.setEnabled(true);
    }
    private void guardarTipoProyecto() {
        String dialog = this.getGestorVistaTipoProyecto().save(btnGuardar.getText());
        this.limpiarPantalla();
        this.vistaInicio();
        this.botonesInicio();
        JOptionPane.showMessageDialog(null, dialog);
    }

    private void vistaInicio() {
        this.txtNombre.setEnabled(false);
        this.jTxtDescripcion.setEnabled(false);
    }

    private void botonesInicio() {
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnGuardar.setText("Guardar");
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnSalir.setEnabled(true);
        btnBuscar.setEnabled(true);
    }    

    private void eliminarTipoProyecto() {
        this.getGestorVistaTipoProyecto().eliminarTipoProyecto();
        this.vistaInicio();
        this.limpiarPantalla();
        this.botonesInicio();
        JOptionPane.showMessageDialog(null, "Proyecto eliminado exitosamente","Validación de Datos",JOptionPane.WARNING_MESSAGE);
    }

    private void cancelar() {
        this.limpiarPantalla();
        this.vistaInicio();
        this.botonesInicio();
    }

    private void buscarTipoProyecto() {
        this.getGestorVistaTipoProyecto().buscarTipoProyecto(
                 this.txtBuscarNombre.getText().toUpperCase(),
                 this.jTxtBuscarDescripcion.getText().toUpperCase());
    }
    

    private void botonesListado() {
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(true);
        btnBuscar.setEnabled(false);
    }

    void cargarTipoProyecto(TipoProyecto tipoProyecto) {
        this.limpiarPantalla();
        txtNombre.setText(tipoProyecto.getNombre());
        jTxtDescripcion.setText(tipoProyecto.getDescripcion());
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        panelTipoProyecto = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtDescripcion = new javax.swing.JTextArea();
        lblNombreRequerido = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        scrContacto = new javax.swing.JScrollPane();
        tblTipoProyecto = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTxtBuscarDescripcion = new javax.swing.JTextArea();
        txtBuscarNombre = new javax.swing.JTextField();
        lblNombre2 = new javax.swing.JLabel();
        lblNombre3 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setTitle("Tipo de Proyecto");
        setToolTipText("Tipo de Proyecto");

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

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 51));

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalir))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panelTipoProyecto.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Proyecto"));

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

        lblNombre1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre1.setText("Descripción:");

        jTxtDescripcion.setColumns(20);
        jTxtDescripcion.setRows(5);
        jScrollPane1.setViewportView(jTxtDescripcion);

        lblNombreRequerido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombreRequerido.setForeground(new java.awt.Color(255, 0, 51));
        lblNombreRequerido.setText("  ");

        javax.swing.GroupLayout panelTipoProyectoLayout = new javax.swing.GroupLayout(panelTipoProyecto);
        panelTipoProyecto.setLayout(panelTipoProyectoLayout);
        panelTipoProyectoLayout.setHorizontalGroup(
            panelTipoProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoProyectoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelTipoProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre)
                    .addComponent(lblNombreRequerido, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        panelTipoProyectoLayout.setVerticalGroup(
            panelTipoProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoProyectoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreRequerido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));

        tblTipoProyecto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblTipoProyecto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblTipoProyecto.getTableHeader().setReorderingAllowed(false);
        scrContacto.setViewportView(tblTipoProyecto);

        jTxtBuscarDescripcion.setColumns(20);
        jTxtBuscarDescripcion.setRows(5);
        jScrollPane2.setViewportView(jTxtBuscarDescripcion);

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

        lblNombre2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre2.setText("Nombre: ");

        lblNombre3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre3.setText("Descripción:");

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(0, 2, Short.MAX_VALUE)
                            .addComponent(scrContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblNombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNombre2, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(298, 298, 298)))))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnBuscar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNombre2))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblNombre3)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGap(6, 6, 6)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 384, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelTipoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTipoProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        this.lblNombreRequerido.setText(" ");
    }//GEN-LAST:event_txtNombreKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.buscarTipoProyecto();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.nuevoTipoProyecto();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.editarProyecto();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String mensaje = this.getGestorVistaTipoProyecto().revisarFormulario();
        if(this.formValido){
            if (JOptionPane.showConfirmDialog(null, ("Guardar".equals(btnGuardar.getText())) ? "¿Desea guardar el Tipo de Proyecto?":"¿Desea actualizar el Tipo de Proyecto?","Atencion", YES_NO_OPTION) == 0 )
            this.guardarTipoProyecto();
        }else{
            JOptionPane.showMessageDialog(null, "Error al enviar el formulario."+mensaje+" ");
            this.formValido = true;
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Tipo de Proyecto seleccionado?","Atencion", YES_NO_OPTION) == 0 )
        this.eliminarTipoProyecto();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarNombreActionPerformed

    private void txtBuscarNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarNombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarNombreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTxtBuscarDescripcion;
    private javax.swing.JTextArea jTxtDescripcion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombreRequerido;
    private javax.swing.JPanel panelTipoProyecto;
    private javax.swing.JScrollPane scrContacto;
    private javax.swing.JTable tblTipoProyecto;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    public boolean isBlanck(JTextField txt) {
        return txt.getText().isBlank();
    }
    }
