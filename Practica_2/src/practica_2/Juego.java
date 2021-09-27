
package practica_2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Juego extends javax.swing.JFrame {
    public Juego() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pAtorreB = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        pBtorreC = new javax.swing.JButton();
        pBtorreA = new javax.swing.JButton();
        pCtorreB = new javax.swing.JButton();
        pCtorreA = new javax.swing.JButton();
        pAtorreC = new javax.swing.JButton();
        botonRojo = new javax.swing.JButton();
        botonVerde = new javax.swing.JButton();
        TorresYDiscos = new fondoDPanel();
        disco7 = new javax.swing.JLabel();
        disco6 = new javax.swing.JLabel();
        disco5 = new javax.swing.JLabel();
        disco4 = new javax.swing.JLabel();
        disco3 = new javax.swing.JLabel();
        disco2 = new javax.swing.JLabel();
        disco1 = new javax.swing.JLabel();
        mostrarTiempo = new javax.swing.JLabel();
        mostrarMovimientos = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 153));
        jLabel1.setText("Movimientos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 153));
        jLabel2.setText("Tiempo");

        pAtorreB.setBackground(new java.awt.Color(204, 255, 204));
        pAtorreB.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        pAtorreB.setForeground(new java.awt.Color(0, 0, 0));
        pAtorreB.setText(">");

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 15)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Salir");

        pBtorreC.setBackground(new java.awt.Color(204, 255, 204));
        pBtorreC.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        pBtorreC.setForeground(new java.awt.Color(0, 0, 0));
        pBtorreC.setText(">");

        pBtorreA.setBackground(new java.awt.Color(204, 255, 204));
        pBtorreA.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        pBtorreA.setForeground(new java.awt.Color(0, 0, 0));
        pBtorreA.setText("<");

        pCtorreB.setBackground(new java.awt.Color(204, 255, 204));
        pCtorreB.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        pCtorreB.setForeground(new java.awt.Color(0, 0, 0));
        pCtorreB.setText("<");

        pCtorreA.setBackground(new java.awt.Color(204, 255, 204));
        pCtorreA.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        pCtorreA.setForeground(new java.awt.Color(0, 0, 0));
        pCtorreA.setText(">");

        pAtorreC.setBackground(new java.awt.Color(204, 255, 204));
        pAtorreC.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        pAtorreC.setForeground(new java.awt.Color(0, 0, 0));
        pAtorreC.setText("<");

        botonRojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/relojRojo 48 pixeles.png"))); // NOI18N
        botonRojo.setContentAreaFilled(false);

        botonVerde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/relojVerde 48pixeles.png"))); // NOI18N
        botonVerde.setContentAreaFilled(false);

        disco7.setBackground(new java.awt.Color(153, 255, 255));
        disco7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco7.setForeground(new java.awt.Color(51, 51, 51));
        disco7.setText("                       7");
        disco7.setToolTipText("");
        disco7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        disco7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        disco7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        disco7.setOpaque(true);

        disco6.setBackground(new java.awt.Color(153, 153, 255));
        disco6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco6.setForeground(new java.awt.Color(51, 51, 51));
        disco6.setText("                    6");
        disco6.setOpaque(true);

        disco5.setBackground(new java.awt.Color(255, 153, 153));
        disco5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco5.setForeground(new java.awt.Color(51, 51, 51));
        disco5.setText("                 5");
        disco5.setOpaque(true);

        disco4.setBackground(new java.awt.Color(255, 255, 153));
        disco4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco4.setForeground(new java.awt.Color(51, 51, 51));
        disco4.setText("              4");
        disco4.setOpaque(true);

        disco3.setBackground(new java.awt.Color(153, 255, 153));
        disco3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco3.setForeground(new java.awt.Color(51, 51, 51));
        disco3.setText("           3");
        disco3.setOpaque(true);

        disco2.setBackground(new java.awt.Color(204, 204, 204));
        disco2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco2.setForeground(new java.awt.Color(51, 51, 51));
        disco2.setText("        2");
        disco2.setOpaque(true);

        disco1.setBackground(new java.awt.Color(0, 153, 153));
        disco1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco1.setForeground(new java.awt.Color(51, 51, 51));
        disco1.setText("     1");
        disco1.setOpaque(true);

        javax.swing.GroupLayout TorresYDiscosLayout = new javax.swing.GroupLayout(TorresYDiscos);
        TorresYDiscos.setLayout(TorresYDiscosLayout);
        TorresYDiscosLayout.setHorizontalGroup(
            TorresYDiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TorresYDiscosLayout.createSequentialGroup()
                .addGroup(TorresYDiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TorresYDiscosLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(disco7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TorresYDiscosLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(disco6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TorresYDiscosLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(disco5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TorresYDiscosLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(disco4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TorresYDiscosLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(TorresYDiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(disco3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(TorresYDiscosLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(TorresYDiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(disco2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(TorresYDiscosLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(disco1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TorresYDiscosLayout.setVerticalGroup(
            TorresYDiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TorresYDiscosLayout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addComponent(disco1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disco2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disco3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disco4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disco5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disco6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disco7)
                .addGap(19, 19, 19))
        );

        disco7.getAccessibleContext().setAccessibleName("               7");

        mostrarTiempo.setForeground(new java.awt.Color(255, 102, 0));
        mostrarTiempo.setText("120");

        mostrarMovimientos.setForeground(new java.awt.Color(255, 102, 0));
        mostrarMovimientos.setText("000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(pAtorreC)
                .addGap(18, 18, 18)
                .addComponent(pAtorreB)
                .addGap(187, 187, 187)
                .addComponent(pBtorreA)
                .addGap(18, 18, 18)
                .addComponent(pBtorreC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(pCtorreB)
                .addGap(18, 18, 18)
                .addComponent(pCtorreA)
                .addGap(179, 179, 179))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(TorresYDiscos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(62, 62, 62))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(mostrarTiempo)
                        .addGap(129, 129, 129)
                        .addComponent(mostrarMovimientos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mostrarMovimientos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mostrarTiempo))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(botonRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(botonVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TorresYDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pAtorreB)
                    .addComponent(pBtorreC)
                    .addComponent(pCtorreB)
                    .addComponent(pCtorreA)
                    .addComponent(pAtorreC)
                    .addComponent(pBtorreA))
                .addGap(37, 37, 37)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
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

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TorresYDiscos;
    private javax.swing.JButton botonRojo;
    private javax.swing.JButton botonVerde;
    private javax.swing.JLabel disco1;
    private javax.swing.JLabel disco2;
    private javax.swing.JLabel disco3;
    private javax.swing.JLabel disco4;
    private javax.swing.JLabel disco5;
    private javax.swing.JLabel disco6;
    private javax.swing.JLabel disco7;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel mostrarMovimientos;
    private javax.swing.JLabel mostrarTiempo;
    private javax.swing.JButton pAtorreB;
    private javax.swing.JButton pAtorreC;
    private javax.swing.JButton pBtorreA;
    private javax.swing.JButton pBtorreC;
    private javax.swing.JButton pCtorreA;
    private javax.swing.JButton pCtorreB;
    // End of variables declaration//GEN-END:variables
    class fondoDPanel extends JPanel{
        private Image imagenfon;
        @Override
        public void paint(Graphics g){
            imagenfon = new ImageIcon(getClass().getResource("/imagenes/Torres.png")).getImage();
            g.drawImage(imagenfon, 0, 0,getWidth(),getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
