package practica_2;

import java.awt.Font;
import java.util.HashSet;
import java.util.Set;

public class PantallaPrincipal extends javax.swing.JFrame {

    public PantallaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tituloPrincipal = new javax.swing.JLabel();
        nuevoJBoton = new javax.swing.JButton();
        juegoABoton = new javax.swing.JButton();
        topBoton = new javax.swing.JButton();
        configBoton = new javax.swing.JButton();
        exitBoton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Torres de Hanoi");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        tituloPrincipal.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        tituloPrincipal.setForeground(new java.awt.Color(102, 255, 102));
        tituloPrincipal.setText("Torres de Hanoi");
        tituloPrincipal.setToolTipText("");

        nuevoJBoton.setBackground(new java.awt.Color(255, 204, 51));
        nuevoJBoton.setForeground(new java.awt.Color(0, 0, 0));
        nuevoJBoton.setText("Nuevo Juego");
        nuevoJBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoJBotonActionPerformed(evt);
            }
        });

        juegoABoton.setBackground(new java.awt.Color(255, 204, 51));
        juegoABoton.setForeground(new java.awt.Color(0, 0, 0));
        juegoABoton.setText("Juego Automático");
        juegoABoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juegoABotonActionPerformed(evt);
            }
        });

        topBoton.setBackground(new java.awt.Color(255, 204, 51));
        topBoton.setForeground(new java.awt.Color(0, 0, 0));
        topBoton.setText("Top 5");
        topBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topBotonActionPerformed(evt);
            }
        });

        configBoton.setBackground(new java.awt.Color(255, 204, 51));
        configBoton.setForeground(new java.awt.Color(0, 0, 0));
        configBoton.setText("Configuración");
        configBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configBotonActionPerformed(evt);
            }
        });

        exitBoton.setBackground(new java.awt.Color(255, 102, 102));
        exitBoton.setFont(new java.awt.Font("Segoe UI Black", 1, 15)); // NOI18N
        exitBoton.setForeground(new java.awt.Color(0, 0, 0));
        exitBoton.setText("Salir");
        exitBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBotonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 153, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(376, 376, 376)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(exitBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(topBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tituloPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nuevoJBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(juegoABoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(configBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(364, Short.MAX_VALUE))))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tituloPrincipal)
                .addGap(47, 47, 47)
                .addComponent(nuevoJBoton)
                .addGap(26, 26, 26)
                .addComponent(juegoABoton)
                .addGap(26, 26, 26)
                .addComponent(topBoton)
                .addGap(26, 26, 26)
                .addComponent(configBoton)
                .addGap(20, 20, 20)
                .addComponent(exitBoton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoJBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoJBotonActionPerformed
        Juego nuevJuego = new Juego();
        nuevJuego.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nuevoJBotonActionPerformed

    private void juegoABotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juegoABotonActionPerformed
       JuegoAutomatico automaticJuego = new JuegoAutomatico();
       automaticJuego.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_juegoABotonActionPerformed

    private void topBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topBotonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_topBotonActionPerformed

    private void configBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configBotonActionPerformed
        ConfiguracionJuego config = new ConfiguracionJuego();
        config.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_configBotonActionPerformed

    private void exitBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBotonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitBotonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton configBoton;
    private javax.swing.JButton exitBoton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton juegoABoton;
    private javax.swing.JButton nuevoJBoton;
    private javax.swing.JLabel tituloPrincipal;
    private javax.swing.JButton topBoton;
    // End of variables declaration//GEN-END:variables
}
