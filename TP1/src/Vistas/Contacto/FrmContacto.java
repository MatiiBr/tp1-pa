/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Contacto;

/**
 *
 * @author Usuario
 */
public class FrmContacto extends javax.swing.JInternalFrame {
     private GestorContacto gestorContacto;
    /**
     * Creates new form FrmContacto
     */
     public FrmContacto(GestorContacto gestorContacto) {
        try{
           initComponents();
           }
           catch(Exception e){
            
        }  
        this.setGestorVista(gestorContacto);
        //this.onViewOpened();
    }
     
    public FrmContacto() {
        initComponents();
    }

    public GestorContacto getGestorVista() {
        return gestorContacto;
    }

    public void setGestorVista(GestorContacto gestorContacto) {
        this.gestorContacto = gestorContacto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setTitle("Contacto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
