package practica_2;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Juego extends javax.swing.JFrame {

    int movimientoJugador = 0;
   
    public Juego() {
        initComponents();
        
        if (GuardarOb.tiempoJN == null && GuardarOb.numDisc == null) {
            mostrarTiempo.setText("120");
            GuardarOb.numDisc = "3";
        } else if (GuardarOb.tiempoJN != null) {
            mostrarTiempo.setText(GuardarOb.tiempoJN);
        }
        disco_1.setVisible(false);
        disco_2.setVisible(false);
        disco_3.setVisible(false);
        disco_4.setVisible(false);
        disco_5.setVisible(false);
        disco_6.setVisible(false);
        disco_7.setVisible(false);
        disco__1.setVisible(false);
        disco__2.setVisible(false);
        disco__3.setVisible(false);
        disco__4.setVisible(false);
        disco__5.setVisible(false);
        disco__6.setVisible(false);
        disco__7.setVisible(false);
        if (GuardarOb.numDisc.equals("3")) {
            disco4.setVisible(false);
            disco5.setVisible(false);
            disco6.setVisible(false);
            disco7.setVisible(false);

        } else if (GuardarOb.numDisc.equals("4")) {
            disco5.setVisible(false);
            disco6.setVisible(false);
            disco7.setVisible(false);

        } else if (GuardarOb.numDisc.equals("5")) {
            disco6.setVisible(false);
            disco7.setVisible(false);

        } else if (GuardarOb.numDisc.equals("6")) {
            disco7.setVisible(false);

        }
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
        exitJuego = new javax.swing.JButton();
        pBtorreC = new javax.swing.JButton();
        pBtorreA = new javax.swing.JButton();
        pCtorreB = new javax.swing.JButton();
        pCtorreA = new javax.swing.JButton();
        pAtorreC = new javax.swing.JButton();
        botonRojo = new javax.swing.JButton();
        botonVerde = new javax.swing.JButton();
        torresYDiscos = new fondoDPanel();
        disco7 = new javax.swing.JLabel();
        disco6 = new javax.swing.JLabel();
        disco5 = new javax.swing.JLabel();
        disco4 = new javax.swing.JLabel();
        disco3 = new javax.swing.JLabel();
        disco2 = new javax.swing.JLabel();
        disco1 = new javax.swing.JLabel();
        disco_1 = new javax.swing.JLabel();
        disco_2 = new javax.swing.JLabel();
        disco_3 = new javax.swing.JLabel();
        disco_4 = new javax.swing.JLabel();
        disco_5 = new javax.swing.JLabel();
        disco_6 = new javax.swing.JLabel();
        disco_7 = new javax.swing.JLabel();
        disco__1 = new javax.swing.JLabel();
        disco__2 = new javax.swing.JLabel();
        disco__3 = new javax.swing.JLabel();
        disco__4 = new javax.swing.JLabel();
        disco__5 = new javax.swing.JLabel();
        disco__6 = new javax.swing.JLabel();
        disco__7 = new javax.swing.JLabel();
        mostrarMovimientos = new javax.swing.JLabel();
        juegoRegresar = new javax.swing.JButton();
        mostrarTiempo = new javax.swing.JLabel();

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
        pAtorreB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pAtorreBActionPerformed(evt);
            }
        });

        exitJuego.setBackground(new java.awt.Color(255, 102, 102));
        exitJuego.setFont(new java.awt.Font("Segoe UI Black", 1, 15)); // NOI18N
        exitJuego.setForeground(new java.awt.Color(0, 0, 0));
        exitJuego.setText("Salir");
        exitJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJuegoActionPerformed(evt);
            }
        });

        pBtorreC.setBackground(new java.awt.Color(204, 255, 204));
        pBtorreC.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        pBtorreC.setForeground(new java.awt.Color(0, 0, 0));
        pBtorreC.setText(">");
        pBtorreC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pBtorreCActionPerformed(evt);
            }
        });

        pBtorreA.setBackground(new java.awt.Color(204, 255, 204));
        pBtorreA.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        pBtorreA.setForeground(new java.awt.Color(0, 0, 0));
        pBtorreA.setText("<");
        pBtorreA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pBtorreAActionPerformed(evt);
            }
        });

        pCtorreB.setBackground(new java.awt.Color(204, 255, 204));
        pCtorreB.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        pCtorreB.setForeground(new java.awt.Color(0, 0, 0));
        pCtorreB.setText("<");
        pCtorreB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pCtorreBActionPerformed(evt);
            }
        });

        pCtorreA.setBackground(new java.awt.Color(204, 255, 204));
        pCtorreA.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        pCtorreA.setForeground(new java.awt.Color(0, 0, 0));
        pCtorreA.setText(">");
        pCtorreA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pCtorreAActionPerformed(evt);
            }
        });

        pAtorreC.setBackground(new java.awt.Color(204, 255, 204));
        pAtorreC.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        pAtorreC.setForeground(new java.awt.Color(0, 0, 0));
        pAtorreC.setText("<");
        pAtorreC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pAtorreCActionPerformed(evt);
            }
        });

        botonRojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/relojRojo 48 pixeles.png"))); // NOI18N
        botonRojo.setContentAreaFilled(false);
        botonRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRojoActionPerformed(evt);
            }
        });

        botonVerde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/relojVerde 48pixeles.png"))); // NOI18N
        botonVerde.setContentAreaFilled(false);
        botonVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerdeActionPerformed(evt);
            }
        });

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

        disco_1.setBackground(new java.awt.Color(0, 153, 153));
        disco_1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco_1.setForeground(new java.awt.Color(51, 51, 51));
        disco_1.setText("     1");
        disco_1.setOpaque(true);

        disco_2.setBackground(new java.awt.Color(204, 204, 204));
        disco_2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco_2.setForeground(new java.awt.Color(51, 51, 51));
        disco_2.setText("        2");
        disco_2.setOpaque(true);

        disco_3.setBackground(new java.awt.Color(153, 255, 153));
        disco_3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco_3.setForeground(new java.awt.Color(51, 51, 51));
        disco_3.setText("           3");
        disco_3.setOpaque(true);

        disco_4.setBackground(new java.awt.Color(255, 255, 153));
        disco_4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco_4.setForeground(new java.awt.Color(51, 51, 51));
        disco_4.setText("              4");
        disco_4.setOpaque(true);

        disco_5.setBackground(new java.awt.Color(255, 153, 153));
        disco_5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco_5.setForeground(new java.awt.Color(51, 51, 51));
        disco_5.setText("                 5");
        disco_5.setOpaque(true);

        disco_6.setBackground(new java.awt.Color(153, 153, 255));
        disco_6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco_6.setForeground(new java.awt.Color(51, 51, 51));
        disco_6.setText("                    6");
        disco_6.setOpaque(true);

        disco_7.setBackground(new java.awt.Color(153, 255, 255));
        disco_7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco_7.setForeground(new java.awt.Color(51, 51, 51));
        disco_7.setText("                       7");
        disco_7.setToolTipText("");
        disco_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        disco_7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        disco_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        disco_7.setOpaque(true);

        disco__1.setBackground(new java.awt.Color(0, 153, 153));
        disco__1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco__1.setForeground(new java.awt.Color(51, 51, 51));
        disco__1.setText("     1");
        disco__1.setOpaque(true);

        disco__2.setBackground(new java.awt.Color(204, 204, 204));
        disco__2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco__2.setForeground(new java.awt.Color(51, 51, 51));
        disco__2.setText("        2");
        disco__2.setOpaque(true);

        disco__3.setBackground(new java.awt.Color(153, 255, 153));
        disco__3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco__3.setForeground(new java.awt.Color(51, 51, 51));
        disco__3.setText("           3");
        disco__3.setOpaque(true);

        disco__4.setBackground(new java.awt.Color(255, 255, 153));
        disco__4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco__4.setForeground(new java.awt.Color(51, 51, 51));
        disco__4.setText("              4");
        disco__4.setOpaque(true);

        disco__5.setBackground(new java.awt.Color(255, 153, 153));
        disco__5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco__5.setForeground(new java.awt.Color(51, 51, 51));
        disco__5.setText("                 5");
        disco__5.setOpaque(true);

        disco__6.setBackground(new java.awt.Color(153, 153, 255));
        disco__6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco__6.setForeground(new java.awt.Color(51, 51, 51));
        disco__6.setText("                    6");
        disco__6.setOpaque(true);

        disco__7.setBackground(new java.awt.Color(153, 255, 255));
        disco__7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        disco__7.setForeground(new java.awt.Color(51, 51, 51));
        disco__7.setText("                       7");
        disco__7.setToolTipText("");
        disco__7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        disco__7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        disco__7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        disco__7.setOpaque(true);

        javax.swing.GroupLayout torresYDiscosLayout = new javax.swing.GroupLayout(torresYDiscos);
        torresYDiscos.setLayout(torresYDiscosLayout);
        torresYDiscosLayout.setHorizontalGroup(
            torresYDiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(torresYDiscosLayout.createSequentialGroup()
                .addGroup(torresYDiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(disco7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(disco6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(disco5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(disco4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(torresYDiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(disco3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(torresYDiscosLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(torresYDiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(disco1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(disco2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(142, 142, 142)
                .addGroup(torresYDiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(disco_7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(disco_6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(disco_5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(disco_4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(torresYDiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(disco_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(torresYDiscosLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(torresYDiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(disco_2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(disco_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(torresYDiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(disco__7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(disco__6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(disco__5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(disco__4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(torresYDiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(disco__3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(torresYDiscosLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(torresYDiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(disco__2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(disco__1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(31, 31, 31))
        );
        torresYDiscosLayout.setVerticalGroup(
            torresYDiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, torresYDiscosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(torresYDiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                        .addComponent(disco__1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disco__2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disco__3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disco__4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disco__5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disco__6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disco__7))
                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                        .addComponent(disco_1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disco_2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disco_3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disco_4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disco_5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disco_6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disco_7))
                    .addGroup(torresYDiscosLayout.createSequentialGroup()
                        .addComponent(disco1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(disco7)))
                .addGap(19, 19, 19))
        );

        disco7.getAccessibleContext().setAccessibleName("               7");

        mostrarMovimientos.setForeground(new java.awt.Color(255, 102, 0));
        mostrarMovimientos.setText("000");

        juegoRegresar.setBackground(new java.awt.Color(51, 153, 255));
        juegoRegresar.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        juegoRegresar.setForeground(new java.awt.Color(0, 0, 0));
        juegoRegresar.setText("Regresar");
        juegoRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juegoRegresarActionPerformed(evt);
            }
        });

        mostrarTiempo.setForeground(new java.awt.Color(255, 102, 0));
        mostrarTiempo.setText("120");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pCtorreB)
                .addGap(18, 18, 18)
                .addComponent(pCtorreA)
                .addGap(179, 179, 179))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(juegoRegresar)
                        .addGap(18, 18, 18)
                        .addComponent(exitJuego))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(mostrarTiempo)
                                        .addGap(128, 128, 128)
                                        .addComponent(mostrarMovimientos))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(73, 73, 73)
                                        .addComponent(jLabel1)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(torresYDiscos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(62, 62, 62)))))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(botonRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(botonVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mostrarMovimientos)
                            .addComponent(mostrarTiempo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(torresYDiscos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pAtorreB)
                    .addComponent(pBtorreC)
                    .addComponent(pCtorreB)
                    .addComponent(pCtorreA)
                    .addComponent(pAtorreC)
                    .addComponent(pBtorreA))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(exitJuego)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(juegoRegresar)))
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

    private void exitJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJuegoActionPerformed
//        JOptionPane.showMessageDialog(null, "Está seguro de abandonar la partida");
        System.exit(0);
    }//GEN-LAST:event_exitJuegoActionPerformed

    private void juegoRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juegoRegresarActionPerformed
        int conf = JOptionPane.showConfirmDialog(null, "Está seguro de abandonar la partida?");
        if (JOptionPane.OK_OPTION == conf) {
            Main.pararHilos();
            GuardarOb.tiempoJN=null;
            PantallaPrincipal pp = new PantallaPrincipal();
            pp.setVisible(true);
            this.dispose();
        } else if (JOptionPane.CANCEL_OPTION == conf) {

        }
        
    }//GEN-LAST:event_juegoRegresarActionPerformed

    private void botonVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerdeActionPerformed
        Main.botVer();
    }//GEN-LAST:event_botonVerdeActionPerformed

    private void botonRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRojoActionPerformed
        Main.botRoj();
    }//GEN-LAST:event_botonRojoActionPerformed
    
    public void mosT(){
        mostrarTiempo.setText(GuardarOb.getTiempoJN());
        System.out.println( mostrarTiempo.getText());
    }
//Boton para mover los discos de la torre A a la torre B
    private void pAtorreBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pAtorreBActionPerformed
//        System.out.println(disco1.getWidth()); // el ancho del disco
//        System.out.println(disco2.getWidth());
// movimientos para 3 discos 
// movimientos para 4 discos
// movimientos para 5 discos
// movimientos para 6 discos
// movimientos para 7 discos
        //MUEVE EL DISCO 1 DE LA TORRE A A LA TORRE B
        if (disco1.isVisible() == true && disco_1.isVisible() == false && disco__1.isVisible() == false) {
            disco1.setVisible(false);
            disco_1.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        } // MUEVE EL DISCO 2 DE LA TORRE A A LA TORRE B SI EL DISCO 1 NO ESTA EN LA TORRE A NI EN LA B
        else if (disco_1.isVisible() == false && disco1.isVisible() == false && disco2.isVisible() == true) {
            disco2.setVisible(false);
            disco_2.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 3 DE LA TORRE A A LA TORRE B SI EL DISCO 1 Y 2 NO ESTAN EN LA TORRE A NI EN LA B
        else if (disco1.isVisible() == false && disco2.isVisible() == false
                && disco_1.isVisible() == false && disco_2.isVisible() == false && disco3.isVisible() == true) {
            disco3.setVisible(false);
            disco_3.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        } //MUEVE EL DISCO 4 DE LA TORRE A A LA TORRE B SI EL DISCO 1,2 Y 3 NO ESTAN EN LA TORRE A NI EN LA B
        else if (disco1.isVisible() == false && disco_1.isVisible() == false && disco2.isVisible() == false && disco_2.isVisible() == false
                && disco3.isVisible() == false && disco_3.isVisible() == false && disco4.isVisible() == true) {
            disco4.setVisible(false);
            disco_4.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 5 DE LA TORRE A A LA TORRE B SI EL DISCO 1,2,3,4 NO ESTAN EN LA TORRE A NI EN LA B
        else if (disco1.isVisible() == false && disco_1.isVisible() == false && disco2.isVisible() == false && disco_2.isVisible() == false
                && disco3.isVisible() == false && disco_3.isVisible() == false && disco4.isVisible() == false && disco_4.isVisible() == false && disco5.isVisible() == true) {
            disco5.setVisible(false);
            disco_5.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 6 DE LA TORRE A A LA TORRE B SI EL DISCO 1,2,3,4,5 NO ESTAN EN LA TORRE A NI EN LA B
        else if (disco1.isVisible() == false && disco_1.isVisible() == false && disco2.isVisible() == false && disco_2.isVisible() == false
                && disco3.isVisible() == false && disco_3.isVisible() == false && disco4.isVisible() == false && disco_4.isVisible() == false
                && disco5.isVisible() == false && disco_5.isVisible() == false && disco6.isVisible() == true) {
            disco6.setVisible(false);
            disco_6.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 7 DE LA TORRE A A LA TORRE B SI EL DISCO 1,2,3,4,5,6 NO ESTAN EN LA TORRE A NI EN LA B
        else if (disco1.isVisible() == false && disco_1.isVisible() == false && disco2.isVisible() == false && disco_2.isVisible() == false
                && disco3.isVisible() == false && disco_3.isVisible() == false && disco4.isVisible() == false && disco_4.isVisible() == false
                && disco5.isVisible() == false && disco_5.isVisible() == false && disco6.isVisible() == false && disco_6.isVisible() == false
                && disco7.isVisible() == true) {
            disco7.setVisible(false);
            disco_7.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }
        finJuego();
    }//GEN-LAST:event_pAtorreBActionPerformed
//Boton para mover discos de la torre A a la torre C
    private void pAtorreCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pAtorreCActionPerformed
// movimientos para 3 discos
        //MUEVE EL DISCO 1 DE LA TORRE A A LA TORRE C 
        if (disco1.isVisible() == true) {
            disco1.setVisible(false);
            disco__1.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 2 DE LA TORRE A A LA TORRE C SI EL DISCO 1 NO ESTA EN LA TORRE A NI EN LA C
        else if (disco__1.isVisible() == false && disco1.isVisible() == false && disco2.isVisible() == true) {
            disco2.setVisible(false);
            disco__2.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 3 DE LA TORRE A A LA TORRE C SI EL DISCO 1 Y 2 NO ESTAN EN LA TORRE A NI EN LA C
        else if (disco__1.isVisible() == false && disco1.isVisible() == false
                && disco__2.isVisible() == false && disco2.isVisible() == false && disco3.isVisible() == true) {
            disco3.setVisible(false);
            disco__3.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 4 DE LA TORRE A A LA TORRE C SI EL DISCO 1,2 Y 3 NO ESTAN EN LA TORRE A NI EN LA C
        else if (disco__1.isVisible() == false && disco1.isVisible() == false
                && disco__2.isVisible() == false && disco2.isVisible() == false
                && disco__3.isVisible() == false && disco3.isVisible() == false && disco4.isVisible() == true) {
            disco4.setVisible(false);
            disco__4.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 5 DE LA TORRE A A LA TORRE C SI EL DISCO 1,2,3,4 NO ESTAN EN LA TORRE A NI EN LA C
        else if (disco__1.isVisible() == false && disco1.isVisible() == false
                && disco__2.isVisible() == false && disco2.isVisible() == false
                && disco__3.isVisible() == false && disco3.isVisible() == false
                && disco__4.isVisible() == false && disco4.isVisible() == false && disco5.isVisible() == true) {
            disco5.setVisible(false);
            disco__5.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 6 DE LA TORRE A A LA TORRE C SI EL DISCO 1,2,3,4,5 NO ESTAN EN LA TORRE A NI EN LA C
        else if (disco__1.isVisible() == false && disco1.isVisible() == false
                && disco__2.isVisible() == false && disco2.isVisible() == false
                && disco__3.isVisible() == false && disco3.isVisible() == false
                && disco__4.isVisible() == false && disco4.isVisible() == false
                && disco__5.isVisible() == false && disco5.isVisible() == false && disco6.isVisible() == true) {
            disco6.setVisible(false);
            disco__6.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 7 DE LA TORRE A A LA TORRE C SI EL DISCO 1,2,3,4,5,6 NO ESTAN EN LA TORRE A NI EN LA C
        else if (disco__1.isVisible() == false && disco1.isVisible() == false
                && disco__2.isVisible() == false && disco2.isVisible() == false
                && disco__3.isVisible() == false && disco3.isVisible() == false
                && disco__4.isVisible() == false && disco4.isVisible() == false
                && disco__5.isVisible() == false && disco5.isVisible() == false
                && disco__6.isVisible() == false && disco6.isVisible() == false && disco7.isVisible() == true) {
            disco7.setVisible(false);
            disco__7.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }
        finJuego();
// movimientos para 4 discos
// movimientos para 5 discos
// movimientos para 6 discos
// movimientos para 7 discos
    }//GEN-LAST:event_pAtorreCActionPerformed
    // boton para mover los discos de la torre B a la torre A
    private void pBtorreAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pBtorreAActionPerformed
// movimientos para 3 discos
        //MUEVE EL DISCO 1 DE LA TORRE B A LA TORRE A 
        if (disco1.isVisible() == false && disco_1.isVisible() == true) {
            disco_1.setVisible(false);
            disco1.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 2 DE LA TORRE B A LA TORRE A SI EL DISCO 1 NO ESTA EN LA TORRE A NI EN LA TORRE B
        else if (disco1.isVisible() == false && disco_1.isVisible() == false && disco_2.isVisible() == true) {
            disco_2.setVisible(false);
            disco2.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 3 DE LA TORRE B A LA TORRE A SI EL DISCO 1 Y 2 NO ESTAN EN LA TORRE A NI EN LA TORRE B
        else if (disco1.isVisible() == false && disco_1.isVisible() == false
                && disco2.isVisible() == false && disco_2.isVisible() == false && disco_3.isVisible() == true) {
            disco_3.setVisible(false);
            disco3.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 4 DE LA TORRE B A LA TORRE A SI EL DISCO 1,2,3 NO ESTAN EN LA TORRE A NI EN LA TORRE B
        else if (disco1.isVisible() == false && disco_1.isVisible() == false
                && disco2.isVisible() == false && disco_2.isVisible() == false
                && disco3.isVisible() == false && disco_3.isVisible() == false && disco_4.isVisible() == true) {
            disco_4.setVisible(false);
            disco4.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 5 DE LA TORRE B A LA TORRE A SI EL DISCO 1,2,3,4 NO ESTAN EN LA TORRE A NI EN LA TORRE B
        else if (disco1.isVisible() == false && disco_1.isVisible() == false
                && disco2.isVisible() == false && disco_2.isVisible() == false
                && disco3.isVisible() == false && disco_3.isVisible() == false
                && disco4.isVisible() == false && disco_4.isVisible() == false && disco_5.isVisible() == true) {
            disco_5.setVisible(false);
            disco5.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 6 DE LA TORRE B A LA TORRE A SI EL DISCO 1,2,3,4,5 NO ESTAN EN LA TORRE A NI EN LA TORRE B
        else if (disco1.isVisible() == false && disco_1.isVisible() == false
                && disco2.isVisible() == false && disco_2.isVisible() == false
                && disco3.isVisible() == false && disco_3.isVisible() == false
                && disco4.isVisible() == false && disco_4.isVisible() == false
                && disco5.isVisible() == false && disco_5.isVisible() == false && disco_6.isVisible() == true) {
            disco_6.setVisible(false);
            disco6.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 7 DE LA TORRE B A LA TORRE A SI EL DISCO 1,2,3,4,5,6 NO ESTAN EN LA TORRE A NI EN LA TORRE B
        else if (disco1.isVisible() == false && disco_1.isVisible() == false
                && disco2.isVisible() == false && disco_2.isVisible() == false
                && disco3.isVisible() == false && disco_3.isVisible() == false
                && disco4.isVisible() == false && disco_4.isVisible() == false
                && disco5.isVisible() == false && disco_5.isVisible() == false
                && disco6.isVisible() == false && disco_6.isVisible() == false && disco_7.isVisible() == true) {
            disco_7.setVisible(false);
            disco7.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }
        finJuego();
// movimientos para 4 discos
// movimientos para 5 discos
// movimientos para 6 discos
// movimientos para 7 discos
    }//GEN-LAST:event_pBtorreAActionPerformed
    // boton para mover los discos de la torre B a la torre C 
    private void pBtorreCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pBtorreCActionPerformed
// movimientos para 3 discos
        //MUEVE EL DISCO 1 DE LA TORRE B A LA TORRE C
        if (disco1.isVisible() == false && disco_1.isVisible() == true && disco__1.isVisible() == false) {
            disco_1.setVisible(false);
            disco__1.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 2 DE LA TORRE B A LA TORRE C SI EL DISCO 1 NO ESTA EN LA TORRE B NI C
        else if (disco_1.isVisible() == false && disco__1.isVisible() == false && disco_2.isVisible() == true) {
            disco_2.setVisible(false);
            disco__2.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 3 DE LA TORRE B A LA TORRE C SI EL DISCO 1 Y 2 NO ESTAN EN LA TORRE B NI EN LA C
        else if (disco_1.isVisible() == false && disco__1.isVisible() == false
                && disco_2.isVisible() == false && disco__2.isVisible() == false && disco_3.isVisible() == true) {
            disco_3.setVisible(false);
            disco__3.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 4 DE LA TORRE B A LA TORRE C SI EL DISCO 1,2,3 NO ESTAN EN LA TORRE B NI EN LA C
        else if (disco_1.isVisible() == false && disco__1.isVisible() == false
                && disco_2.isVisible() == false && disco__2.isVisible() == false
                && disco_3.isVisible() == false && disco__3.isVisible() == false && disco_4.isVisible() == true) {
            disco_4.setVisible(false);
            disco__4.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 5 DE LA TORRE B A LA TORRE C SI EL DISCO 1,2,3,4 NO ESTAN EN LA TORRE B NI EN LA C
        else if (disco_1.isVisible() == false && disco__1.isVisible() == false
                && disco_2.isVisible() == false && disco__2.isVisible() == false
                && disco_3.isVisible() == false && disco__3.isVisible() == false
                && disco_4.isVisible() == false && disco__4.isVisible() == false && disco_5.isVisible() == true) {
            disco_5.setVisible(false);
            disco__5.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 6 DE LA TORRE B A LA TORRE C SI EL DISCO 1,2,3,4,5 NO ESTAN EN LA TORRE B NI EN LA C
        else if (disco_1.isVisible() == false && disco__1.isVisible() == false
                && disco_2.isVisible() == false && disco__2.isVisible() == false
                && disco_3.isVisible() == false && disco__3.isVisible() == false
                && disco_4.isVisible() == false && disco__4.isVisible() == false
                && disco_5.isVisible() == false && disco__5.isVisible() == false && disco_6.isVisible() == true) {
            disco_6.setVisible(false);
            disco__6.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 7 DE LA TORRE B A LA TORRE C SI EL DISCO 1,2,3,4,5,6 NO ESTAN EN LA TORRE B NI EN LA C
        else if (disco_1.isVisible() == false && disco__1.isVisible() == false
                && disco_2.isVisible() == false && disco__2.isVisible() == false
                && disco_3.isVisible() == false && disco__3.isVisible() == false
                && disco_4.isVisible() == false && disco__4.isVisible() == false
                && disco_5.isVisible() == false && disco__5.isVisible() == false
                && disco_6.isVisible() == false && disco__6.isVisible() == false && disco_7.isVisible() == true) {
            disco_7.setVisible(false);
            disco__7.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }
        finJuego();
// movimientos para 4 discos
// movimientos para 5 discos
// movimientos para 6 discos
// movimientos para 7 discos
    }//GEN-LAST:event_pBtorreCActionPerformed
    // boton para mover los discos de la torre C a la torre B
    private void pCtorreBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pCtorreBActionPerformed
// movimientos para 3 discos
        //MUEVE EL DISCO 1 DE LA TORRE C A LA TORRE B 
        if (disco1.isVisible() == false && disco_1.isVisible() == false && disco__1.isVisible() == true) {
            disco__1.setVisible(false);
            disco_1.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 2 DE LA TORRE C A LA TORRE B SI EL DISCO 1 NO ESTA EN LA TORRE B NI EN LA C
        else if (disco_1.isVisible() == false && disco__1.isVisible() == false && disco__2.isVisible() == true) {
            disco__2.setVisible(false);
            disco_2.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 3 DE LA TORRE C A LA TORRE B SI EL DISCO 1 Y 2 NO ESTAN EN LA TORRE B NI EN LA C
        else if (disco_1.isVisible() == false && disco__1.isVisible() == false
                && disco_2.isVisible() == false && disco__2.isVisible() == false && disco__3.isVisible() == true) {
            disco__3.setVisible(false);
            disco_3.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 4 DE LA TORRE C A LA TORRE B SI EL DISCO 1,2,3 NO ESTAN EN LA TORRE B NI EN LA C
        else if (disco_1.isVisible() == false && disco__1.isVisible() == false
                && disco_2.isVisible() == false && disco__2.isVisible() == false
                && disco_3.isVisible() == false && disco__3.isVisible() == false && disco__4.isVisible() == true) {
            disco__4.setVisible(false);
            disco_4.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 5 DE LA TORRE C A LA TORRE B SI EL DISCO 1,2,3,4 NO ESTAN EN LA TORRE B NI EN LA C
        else if (disco_1.isVisible() == false && disco__1.isVisible() == false
                && disco_2.isVisible() == false && disco__2.isVisible() == false
                && disco_3.isVisible() == false && disco__3.isVisible() == false
                && disco_4.isVisible() == false && disco__4.isVisible() == false && disco__5.isVisible() == true) {
            disco__5.setVisible(false);
            disco_5.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 6 DE LA TORRE C A LA TORRE B SI EL DISCO 1,2,3,4,5 NO ESTAN EN LA TORRE B NI EN LA C
        else if (disco_1.isVisible() == false && disco__1.isVisible() == false
                && disco_2.isVisible() == false && disco__2.isVisible() == false
                && disco_3.isVisible() == false && disco__3.isVisible() == false
                && disco_4.isVisible() == false && disco__4.isVisible() == false
                && disco_5.isVisible() == false && disco__5.isVisible() == false && disco__6.isVisible() == true) {
            disco__6.setVisible(false);
            disco_6.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 7 DE LA TORRE C A LA TORRE B SI EL DISCO 1,2,3,4,5,6 NO ESTAN EN LA TORRE B NI EN LA C
        else if (disco_1.isVisible() == false && disco__1.isVisible() == false
                && disco_2.isVisible() == false && disco__2.isVisible() == false
                && disco_3.isVisible() == false && disco__3.isVisible() == false
                && disco_4.isVisible() == false && disco__4.isVisible() == false
                && disco_5.isVisible() == false && disco__5.isVisible() == false
                && disco_6.isVisible() == false && disco__6.isVisible() == false && disco__7.isVisible() == true) {
            disco__7.setVisible(false);
            disco_7.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }

        finJuego();
// movimientos para 4 discos
// movimientos para 5 discos
// movimientos para 6 discos
// movimientos para 7 discos
    }//GEN-LAST:event_pCtorreBActionPerformed
    // boton para mover los discos de la torre C a la torre A
    private void pCtorreAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pCtorreAActionPerformed
// movimientos para 3 discos
        //MUEVE EL DISCO 1 DE LA TORRE C A LA TORRE A 
        if (disco1.isVisible() == false && disco_1.isVisible() == false && disco__1.isVisible() == true) {
            disco__1.setVisible(false);
            disco1.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 2 DE LA TORRE C A LA TORRE A SI EL DISCO 1 NO ESTA EN LA TORRE C NI EN LA A
        else if (disco1.isVisible() == false && disco__1.isVisible() == false && disco__2.isVisible() == true) {
            disco__2.setVisible(false);
            disco2.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 3 DE LA TORRE C A LA TORRE A SI EL DISCO 1 Y 2 NO ESTAN EN LA TORRE C NI EN LA A
        else if (disco1.isVisible() == false && disco__1.isVisible() == false
                && disco2.isVisible() == false && disco__2.isVisible() == false && disco__3.isVisible() == true) {
            disco__3.setVisible(false);
            disco3.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 4 DE LA TORRE C A LA TORRE A SI EL DISCO 1,2,3 NO ESTAN EN LA TORRE C NI EN LA A
        else if (disco1.isVisible() == false && disco__1.isVisible() == false
                && disco2.isVisible() == false && disco__2.isVisible() == false
                && disco3.isVisible() == false && disco__3.isVisible() == false && disco__4.isVisible() == true) {
            disco__4.setVisible(false);
            disco4.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 5 DE LA TORRE C A LA TORRE A SI EL DISCO 1,2,3,4 NO ESTAN EN LA TORRE C NI EN LA A
        else if (disco1.isVisible() == false && disco__1.isVisible() == false
                && disco2.isVisible() == false && disco__2.isVisible() == false
                && disco3.isVisible() == false && disco__3.isVisible() == false
                && disco4.isVisible() == false && disco__4.isVisible() == false && disco__5.isVisible() == true) {
            disco__5.setVisible(false);
            disco5.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 6 DE LA TORRE C A LA TORRE A SI EL DISCO 1,2,3,4,5 NO ESTAN EN LA TORRE C NI EN LA A
        else if (disco1.isVisible() == false && disco__1.isVisible() == false
                && disco2.isVisible() == false && disco__2.isVisible() == false
                && disco3.isVisible() == false && disco__3.isVisible() == false
                && disco4.isVisible() == false && disco__4.isVisible() == false
                && disco5.isVisible() == false && disco__5.isVisible() == false && disco__6.isVisible() == true) {
            disco__6.setVisible(false);
            disco6.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }//MUEVE EL DISCO 7 DE LA TORRE C A LA TORRE A SI EL DISCO 1,2,3,4,5,6 NO ESTAN EN LA TORRE C NI EN LA A
        else if (disco1.isVisible() == false && disco__1.isVisible() == false
                && disco2.isVisible() == false && disco__2.isVisible() == false
                && disco3.isVisible() == false && disco__3.isVisible() == false
                && disco4.isVisible() == false && disco__4.isVisible() == false
                && disco5.isVisible() == false && disco__5.isVisible() == false
                && disco6.isVisible() == false && disco__6.isVisible() == false && disco__7.isVisible() == true) {
            disco__7.setVisible(false);
            disco7.setVisible(true);
            movimientoJugador = movimientoJugador + 1;
            mostrarMovimientos.setText(Integer.toString(movimientoJugador));
        }

        finJuego();
// movimientos para 4 discos
// movimientos para 5 discos
// movimientos para 6 discos
// movimientos para 7 discos
    }//GEN-LAST:event_pCtorreAActionPerformed

    public void finJuego() {
        if (GuardarOb.numDisc.equals("3") && disco__1.isVisible() == true && disco__2.isVisible() == true && disco__3.isVisible() == true) {
//          String nombre = JOptionPane.showInputDialog(null,"Felicidades ha ganado la partida \n"+" Por favor ingrese su nombre");
            Main.pararHilos();
            guardarNomJ();
            GuardarOb.tiempoJN=null;
            PantallaPrincipal pp = new PantallaPrincipal();
            pp.setVisible(true);
            this.dispose();
        } else if (GuardarOb.numDisc.equals("4") && disco__1.isVisible() == true && disco__2.isVisible() == true && disco__3.isVisible() == true && disco__4.isVisible() == true) {
            Main.pararHilos();
            guardarNomJ();
            GuardarOb.tiempoJN=null;
            PantallaPrincipal pp = new PantallaPrincipal();
            pp.setVisible(true);
            this.dispose();
        } else if (GuardarOb.numDisc.equals("5") && disco__1.isVisible() == true && disco__2.isVisible() == true && disco__3.isVisible() == true && disco__4.isVisible() == true && disco__5.isVisible() == true) {
            Main.pararHilos();
            guardarNomJ();
            GuardarOb.tiempoJN=null;
            PantallaPrincipal pp = new PantallaPrincipal();
            pp.setVisible(true);
            this.dispose();
        } else if (GuardarOb.numDisc.equals("6") && disco__1.isVisible() == true && disco__2.isVisible() == true && disco__3.isVisible() == true && disco__4.isVisible() == true && disco__5.isVisible() == true && disco__6.isVisible() == true) {
            Main.pararHilos();
            guardarNomJ();
            GuardarOb.tiempoJN=null;
            PantallaPrincipal pp = new PantallaPrincipal();
            pp.setVisible(true);
            this.dispose();
        } else if (GuardarOb.numDisc.equals("7") && disco__1.isVisible() == true && disco__2.isVisible() == true && disco__3.isVisible() == true && disco__4.isVisible() == true && disco__5.isVisible() == true && disco__6.isVisible() == true && disco__7.isVisible() == true) {
            Main.pararHilos();
            guardarNomJ();
            GuardarOb.tiempoJN=null;
            PantallaPrincipal pp = new PantallaPrincipal();
            pp.setVisible(true);
            this.dispose();
        }

    }

    public void guardarNomJ() {
        String nombre = JOptionPane.showInputDialog(null, "Felicidades ha ganado la partida \n" + " Por favor ingrese su nombre");
        for (int i = 0; i < GuardarOb.jugadorGuardar.length; i++) {
            if (GuardarOb.jugadorGuardar[i] == null) {
                GuardarOb.jugadorGuardar[i] = new Jugador(nombre, GuardarOb.getTiempoJN(), movimientoJugador);
                System.out.println("nombre: " + GuardarOb.jugadorGuardar[i].getNombre());
                System.out.println("tiempo: " + GuardarOb.jugadorGuardar[i].getTiempoRestante());
                System.out.println("movimientos: " + GuardarOb.jugadorGuardar[i].getMovimientosRealizados());
//                cantidadJugadores = cantidadJugadores + 1;
                break;
            }
        }
    }
    
    public void jugadores_PDF() throws DocumentException {
        try {
            Document docu;
            FileOutputStream arch = new FileOutputStream("Top 5" + ".pdf");
            Paragraph tit = new Paragraph("Top 5 jugadores con la menor cantidad de movimientos");
            docu = new Document() {};
            PdfWriter.getInstance((com.itextpdf.text.Document) docu, arch);
            docu.open();
            tit.setAlignment(1);
            docu.add(tit);
            docu.add(Chunk.NEWLINE);
            Paragraph texto = new Paragraph("");//aqui dentro va todo lo que lleve el documento

            texto.setAlignment(Element.ALIGN_JUSTIFIED);
            docu.add(texto);
            docu.add(Chunk.NEWLINE);
            PdfPTable tab = new PdfPTable(3);
            tab.setWidthPercentage(100);
            PdfPCell nam = new PdfPCell(new Phrase("Nombre"));
            nam.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell ti = new PdfPCell(new Phrase("Tiempo"));
            ti.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell mo = new PdfPCell(new Phrase("Movimientos"));
            mo.setBackgroundColor(BaseColor.ORANGE);
            tab.addCell(nam);
            tab.addCell(ti);
            tab.addCell(mo);
            ordenamiento_burbujaJugadores();
            for (int i = 0; i < 5; i++) {
                if (GuardarOb.jugadorGuardar[i] != null) {
                    String tempCodigo = GuardarOb.jugadorGuardar[i].getNombre();
                    tab.addCell(tempCodigo);
                    String tempTiempo = GuardarOb.jugadorGuardar[i].getTiempoRestante();
                    tab.addCell(tempTiempo);
                    String tempMovimientos = Integer.toString(GuardarOb.jugadorGuardar[i].getMovimientosRealizados());
                    tab.addCell(tempMovimientos);
                } else if (GuardarOb.jugadorGuardar[i] == null) {
                    break;
                }
            }

            docu.add(tab);
            docu.add(Chunk.NEWLINE);

//            Para manejar la fecha es 
            LocalDate fecha = LocalDate.now();
            String fech = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Paragraph texto1 = new Paragraph(fech);//aqui dentro va la fecha 
            texto1.setAlignment(Element.ALIGN_JUSTIFIED);
            docu.add(texto1);
            docu.close();
            JOptionPane.showMessageDialog(null, "El archivo PDF se creó correctamente");
            //abre archivo automaticamente
            try {
                File enlace = new File("Top 5" + ".pdf");
                Desktop.getDesktop().open(enlace);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex, "Alerta", 2);
            }

        } catch (FileNotFoundException e) {

        } catch (DocumentException e) {

        }

    }
    
    private void ordenamiento_burbujaJugadores() {
        String auxiliar_jugadorNombre;
        String auxiliar_jugadorTiempo;
        int auxiliar_jugadorMovimientos;
        for (int i = 0; i < GuardarOb.jugadorGuardar.length; i++) {
            for (int j = 0; j < GuardarOb.jugadorGuardar.length; j++) {
                if ((GuardarOb.jugadorGuardar[j] != null) && (GuardarOb.jugadorGuardar[j + 1] != null)) {
                    if ((GuardarOb.jugadorGuardar[j].getMovimientosRealizados() > GuardarOb.jugadorGuardar[j + 1].getMovimientosRealizados())) {
                        //cambiando movimientos
                        auxiliar_jugadorMovimientos = GuardarOb.jugadorGuardar[j].getMovimientosRealizados();
                        GuardarOb.jugadorGuardar[j].setMovimientosRealizados(GuardarOb.jugadorGuardar[j + 1].getMovimientosRealizados());
                        GuardarOb.jugadorGuardar[j + 1].setMovimientosRealizados(auxiliar_jugadorMovimientos);
                        //cambiando nombre
                        auxiliar_jugadorNombre = GuardarOb.jugadorGuardar[j].getNombre();
                        GuardarOb.jugadorGuardar[j].setNombre(GuardarOb.jugadorGuardar[j + 1].getNombre());
                        GuardarOb.jugadorGuardar[j + 1].setNombre(auxiliar_jugadorNombre);
                        //cambiando tiempo
                        auxiliar_jugadorTiempo = GuardarOb.jugadorGuardar[j].getTiempoRestante();
                        GuardarOb.jugadorGuardar[j].setTiempoRestante(GuardarOb.jugadorGuardar[j + 1].getTiempoRestante());
                        GuardarOb.jugadorGuardar[j + 1].setTiempoRestante(auxiliar_jugadorTiempo);
                     }

                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonRojo;
    public javax.swing.JButton botonVerde;
    private javax.swing.JLabel disco1;
    private javax.swing.JLabel disco2;
    private javax.swing.JLabel disco3;
    private javax.swing.JLabel disco4;
    private javax.swing.JLabel disco5;
    private javax.swing.JLabel disco6;
    private javax.swing.JLabel disco7;
    private javax.swing.JLabel disco_1;
    private javax.swing.JLabel disco_2;
    private javax.swing.JLabel disco_3;
    private javax.swing.JLabel disco_4;
    private javax.swing.JLabel disco_5;
    private javax.swing.JLabel disco_6;
    private javax.swing.JLabel disco_7;
    private javax.swing.JLabel disco__1;
    private javax.swing.JLabel disco__2;
    private javax.swing.JLabel disco__3;
    private javax.swing.JLabel disco__4;
    private javax.swing.JLabel disco__5;
    private javax.swing.JLabel disco__6;
    private javax.swing.JLabel disco__7;
    private javax.swing.JButton exitJuego;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton juegoRegresar;
    private javax.swing.JLabel mostrarMovimientos;
    public javax.swing.JLabel mostrarTiempo;
    private javax.swing.JButton pAtorreB;
    private javax.swing.JButton pAtorreC;
    private javax.swing.JButton pBtorreA;
    private javax.swing.JButton pBtorreC;
    private javax.swing.JButton pCtorreA;
    private javax.swing.JButton pCtorreB;
    private javax.swing.JPanel torresYDiscos;
    // End of variables declaration//GEN-END:variables
    class fondoDPanel extends JPanel {

        private Image imagenfon;

        @Override
        public void paint(Graphics g) {
            imagenfon = new ImageIcon(getClass().getResource("/imagenes/Torres.png")).getImage();
            g.drawImage(imagenfon, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
