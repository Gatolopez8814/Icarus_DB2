/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

/**
 *
 * @author BRYAN
 */
public class VentanaParametros extends javax.swing.JFrame {

    /**
     * Creates new form VentanaParametros
     */
    public VentanaParametros() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSeparador = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTabla = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTabla1 = new javax.swing.JTextField();
        btnListo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parámetros");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        panelPrincipal.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Gadugi", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("Parámetros");

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/Icarus-Icon2.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Ruta del archivo:");

        jLabel3.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setText("Separador:");

        jLabel4.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("Database: ");

        jLabel5.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 0));
        jLabel5.setText("Tabla:");

        txtTabla1.setEditable(false);
        txtTabla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTabla1ActionPerformed(evt);
            }
        });

        btnListo.setBackground(new java.awt.Color(255, 204, 0));
        btnListo.setText("¡Listo!");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRuta)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 120, Short.MAX_VALUE)
                        .addComponent(icon))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTabla))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSeparador, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTabla1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnListo)
                .addGap(163, 163, 163))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTabla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSeparador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListo)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTabla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTabla1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTabla1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaParametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaParametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaParametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaParametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaParametros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListo;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField txtRuta;
    private javax.swing.JTextField txtSeparador;
    private javax.swing.JTextField txtTabla;
    private javax.swing.JTextField txtTabla1;
    // End of variables declaration//GEN-END:variables
}
