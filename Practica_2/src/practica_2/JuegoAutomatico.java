package practica_2;


public class JuegoAutomatico extends javax.swing.JFrame {

    int nuDisc;
    int pTorre = 1;
    int sTorre = 2;
    int tTorre = 3;
    int movimien = 0;

    public JuegoAutomatico() {

        initComponents();
//        System.out.println("" + nuDisc);
        if (GuardarOb.numDisc != null) {
            nuDisc = Integer.parseInt((String) GuardarOb.numDisc);
            mostrarNumeroDiscJA.setText(GuardarOb.numDisc);
        } else if (GuardarOb.numDisc == null) {
            mostrarNumeroDiscJA.setText("3");
            nuDisc = 3;
        }
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void tH(int nDisc, int or, int de, int au) {
        if (nDisc == 1) {
//            jTextArea1.setText("Se movió el disco #"+ nDisc+" del poste #"+ or+ " al poste #"+ de);
            jTextArea1.append("Se movió el disco #" + nDisc + " del poste #" + or + " al poste #" + de);
            jTextArea1.append("\n");
            movimien = movimien + 1;
            mostrarMovimientosJA.setText(Integer.toString(movimien));
//            System.out.println("Se movió el disco #"+ nDisc+" del poste #"+ or+ " al poste #"+ de);
        } else {
            tH(nDisc - 1, or, au, de);
//            jTextArea1.setText("Se movió el disco #"+ nDisc+" del poste #"+ or+ " al poste #"+ de);
            jTextArea1.append("Se movió el disco #" + nDisc + " del poste #" + or + " al poste #" + de);
            jTextArea1.append("\n");
            movimien = movimien + 1;
            mostrarMovimientosJA.setText(Integer.toString(movimien));
//            System.out.println("Se movió el disco #"+ nDisc+" del poste #"+ or+ " al poste #"+ de);
            tH(nDisc - 1, au, de, or);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tituloJA = new javax.swing.JLabel();
        discosJA = new javax.swing.JLabel();
        moviemientJA = new javax.swing.JLabel();
        mostrarMovimientosJA = new javax.swing.JLabel();
        mostrarNumeroDiscJA = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        regresarJA = new javax.swing.JButton();
        iniciarJA = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Torres de Hanoi - FIUSAC");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

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

        tituloJA.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        tituloJA.setForeground(new java.awt.Color(153, 255, 153));
        tituloJA.setText("Juego Automático");

        discosJA.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        discosJA.setForeground(new java.awt.Color(255, 255, 0));
        discosJA.setText("Discos");

        moviemientJA.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        moviemientJA.setForeground(new java.awt.Color(255, 255, 0));
        moviemientJA.setText("Movimientos");

        mostrarMovimientosJA.setForeground(new java.awt.Color(255, 153, 51));
        mostrarMovimientosJA.setText("000");

        mostrarNumeroDiscJA.setForeground(new java.awt.Color(255, 153, 51));
        mostrarNumeroDiscJA.setText("3");

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        regresarJA.setBackground(new java.awt.Color(51, 153, 255));
        regresarJA.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        regresarJA.setForeground(new java.awt.Color(0, 0, 0));
        regresarJA.setText("Regresar");
        regresarJA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarJAActionPerformed(evt);
            }
        });

        iniciarJA.setBackground(new java.awt.Color(102, 255, 102));
        iniciarJA.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        iniciarJA.setForeground(new java.awt.Color(0, 0, 0));
        iniciarJA.setText("Iniciar");
        iniciarJA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarJAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(iniciarJA)
                                .addGap(41, 41, 41)
                                .addComponent(regresarJA))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(discosJA)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(21, 21, 21)
                                            .addComponent(mostrarNumeroDiscJA)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(123, 123, 123)
                                            .addComponent(moviemientJA))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(156, 156, 156)
                                            .addComponent(mostrarMovimientosJA)))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(tituloJA)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(tituloJA)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discosJA)
                    .addComponent(moviemientJA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostrarMovimientosJA)
                    .addComponent(mostrarNumeroDiscJA))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regresarJA)
                    .addComponent(iniciarJA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarJAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarJAActionPerformed
        PantallaPrincipal pp = new PantallaPrincipal();
        pp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresarJAActionPerformed

    private void iniciarJAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarJAActionPerformed
        tH(nuDisc, pTorre, tTorre, sTorre);
        jTextArea1.append("Se finalizó el juego");
        GuardarOb.setNumDisc(null);
    }//GEN-LAST:event_iniciarJAActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel discosJA;
    private javax.swing.JButton iniciarJA;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel mostrarMovimientosJA;
    private javax.swing.JLabel mostrarNumeroDiscJA;
    private javax.swing.JLabel moviemientJA;
    private javax.swing.JButton regresarJA;
    private javax.swing.JLabel tituloJA;
    // End of variables declaration//GEN-END:variables
}
