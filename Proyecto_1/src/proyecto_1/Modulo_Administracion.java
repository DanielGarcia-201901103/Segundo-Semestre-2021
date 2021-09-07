package proyecto_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Modulo_Administracion {

    private JFrame ventanaAdmin = new JFrame();
    private JPanel panel, panel1, panel2, panel3, panel4;
    private JTextField Text_codigo = new JTextField();
    private JTextField Text_contraseña = new JTextField();
    private JTabbedPane primeras_pestañas = new JTabbedPane();

    public void ventanaAdmin() {
        ventanaAdmin.setSize(800, 800);
        ventanaAdmin.setTitle("Administración");
        ventanaAdmin.setLocationRelativeTo(null);
        ventanaAdmin.setMinimumSize(new Dimension(200, 200));
        ventanaAdmin.setDefaultCloseOperation(EXIT_ON_CLOSE);    //Permite cerrar la pestaña
        ventanaAdmin.setResizable(false);
        ventanaAdmin.setVisible(true);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        colocarPanel();
        colocarBotones();

    }

    private void colocarPanel() {
        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        ventanaAdmin.add(panel);

        //Sucursales
        panel1 = new JPanel();
        panel1.setBackground(Color.ORANGE);
        panel1.setBounds(21, 21, 730, 730);
        panel1.setLayout(null);
        // Productos
        panel2 = new JPanel();
        panel2.setBackground(Color.ORANGE);
        panel2.setBounds(21, 21, 730, 730);
        panel2.setLayout(null);
        //Clientes
        panel3 = new JPanel();
        panel3.setBackground(Color.ORANGE);
        panel3.setBounds(21, 21, 730, 730);
        panel3.setLayout(null);
        //Vendedores
        panel4 = new JPanel();
        panel4.setBackground(Color.ORANGE);
        panel4.setBounds(21, 21, 730, 730);
        panel4.setLayout(null);
        primeras_pestañas.setBounds(20, 20, 750, 730);
        primeras_pestañas.addTab("Sucursales", panel.add(panel1));
        primeras_pestañas.addTab("Productos", panel.add(panel2));
        primeras_pestañas.addTab("Clientes", panel.add(panel3));
        primeras_pestañas.addTab("Vendedores", panel.add(panel4));
        panel.add(primeras_pestañas);
    }

    private void colocarBotones() {
        JButton boton1 = new JButton("Cerrar Sesión");
        boton1.setBounds(635, 5, 140, 25);
        boton1.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton1.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton1.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton1.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton1.setBackground(Color.RED); //cambia el color del fondo del boton
        panel.add(boton1);
        //Agregando eventos de tipo ActionListener
        ActionListener accion = (ActionEvent ae) -> {
            Modulo_Autenticacion au = new Modulo_Autenticacion();
            au.ventanaPrincipal();
            ventanaAdmin.dispose();
        };
        boton1.addActionListener(accion);
    }
}
