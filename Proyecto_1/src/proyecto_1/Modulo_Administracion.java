package proyecto_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class Modulo_Administracion {

    private JFrame ventanaAdmin = new JFrame();
    private JPanel panel, panel1, panel2, panel3, panel4;
    private JTabbedPane primeras_pestañas = new JTabbedPane();
    //Datos para vendedor
    int tamañoVectorVendedor = 1;
    Vendedor guardarVendedor[] = new Vendedor[tamañoVectorVendedor];
    DefaultTableModel modelo_tabVende = new DefaultTableModel();
    String almacenaVendedor[][]= new String [tamañoVectorVendedor][6];
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
        //Para pestaña sucursales
        colocarBotones_Sucursales();
        colocarTabla_Sucursales();
        //Para pestaña productos
        colocarBotones_Productos();
        colocarTabla_Productos();
        colocarGrafico_Productos();
        //Para pestaña clientes
        colocarBotones_Clientes();
        colocarTabla_Clientes();
        colocarGrafico_Clientes();
        //Para pestaña vendedores
        colocarBotones_Vendedores();
        colocarTabla_Vendedores();
        colocarGrafico_Vendedores();
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

    // ########################## Botones ###############################################
    private void colocarBotones_Sucursales() {
        JButton boton = new JButton("Crear");
        boton.setBounds(450, 20, 130, 60);
        boton.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel1.add(boton);
        //Agregando eventos de tipo ActionListener
        ActionListener accion = (ActionEvent ae) -> {
            sucursales_vCrear();
        };
        boton.addActionListener(accion);

        JButton boton1 = new JButton("Carga Masiva");
        boton1.setBounds(600, 20, 130, 60);
        boton1.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton1.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton1.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton1.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton1.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel1.add(boton1);
        //Agregando eventos de tipo ActionListener
        ActionListener accion1 = (ActionEvent ae) -> {

        };
        boton1.addActionListener(accion1);

        JButton boton2 = new JButton("Actualizar");
        boton2.setBounds(450, 100, 130, 60);
        boton2.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton2.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton2.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton2.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton2.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel1.add(boton2);
        //Agregando eventos de tipo ActionListener
        ActionListener accion2 = (ActionEvent ae) -> {
            sucursales_vActualizar();
        };
        boton2.addActionListener(accion2);

        JButton boton3 = new JButton("Eliminar");
        boton3.setBounds(600, 100, 130, 60);
        boton3.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton3.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton3.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton3.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton3.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel1.add(boton3);
        //Agregando eventos de tipo ActionListener
        ActionListener accion3 = (ActionEvent ae) -> {

        };
        boton3.addActionListener(accion3);

        JButton boton4 = new JButton("Exportar Listado a PDF");
        boton4.setBounds(450, 180, 280, 60);
        boton4.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton4.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton4.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton4.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton4.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel1.add(boton4);
        //Agregando eventos de tipo ActionListener
        ActionListener accion4 = (ActionEvent ae) -> {

        };
        boton4.addActionListener(accion4);
    }

    private void colocarBotones_Productos() {
        JButton boton = new JButton("Crear");
        boton.setBounds(450, 20, 130, 60);
        boton.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel2.add(boton);
        //Agregando eventos de tipo ActionListener
        ActionListener accion = (ActionEvent ae) -> {

        };
        boton.addActionListener(accion);

        JButton boton1 = new JButton("Carga Masiva");
        boton1.setBounds(600, 20, 130, 60);
        boton1.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton1.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton1.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton1.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton1.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel2.add(boton1);
        //Agregando eventos de tipo ActionListener
        ActionListener accion1 = (ActionEvent ae) -> {

        };
        boton1.addActionListener(accion1);

        JButton boton2 = new JButton("Actualizar");
        boton2.setBounds(450, 100, 130, 60);
        boton2.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton2.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton2.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton2.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton2.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel2.add(boton2);
        //Agregando eventos de tipo ActionListener
        ActionListener accion2 = (ActionEvent ae) -> {

        };
        boton2.addActionListener(accion2);

        JButton boton3 = new JButton("Eliminar");
        boton3.setBounds(600, 100, 130, 60);
        boton3.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton3.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton3.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton3.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton3.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel2.add(boton3);
        //Agregando eventos de tipo ActionListener
        ActionListener accion3 = (ActionEvent ae) -> {

        };
        boton3.addActionListener(accion3);

        JButton boton4 = new JButton("Exportar Listado a PDF");
        boton4.setBounds(450, 180, 280, 60);
        boton4.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton4.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton4.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton4.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton4.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel2.add(boton4);
        //Agregando eventos de tipo ActionListener
        ActionListener accion4 = (ActionEvent ae) -> {

        };
        boton4.addActionListener(accion4);
    }

    private void colocarBotones_Clientes() {
        JButton boton = new JButton("Crear");
        boton.setBounds(450, 20, 130, 60);
        boton.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel3.add(boton);
        //Agregando eventos de tipo ActionListener
        ActionListener accion = (ActionEvent ae) -> {
            clientes_vCrear();
        };
        boton.addActionListener(accion);

        JButton boton1 = new JButton("Carga Masiva");
        boton1.setBounds(600, 20, 130, 60);
        boton1.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton1.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton1.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton1.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton1.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel3.add(boton1);
        //Agregando eventos de tipo ActionListener
        ActionListener accion1 = (ActionEvent ae) -> {

        };
        boton1.addActionListener(accion1);

        JButton boton2 = new JButton("Actualizar");
        boton2.setBounds(450, 100, 130, 60);
        boton2.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton2.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton2.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton2.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton2.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel3.add(boton2);
        //Agregando eventos de tipo ActionListener
        ActionListener accion2 = (ActionEvent ae) -> {
            clientes_vActualizar();
        };
        boton2.addActionListener(accion2);

        JButton boton3 = new JButton("Eliminar");
        boton3.setBounds(600, 100, 130, 60);
        boton3.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton3.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton3.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton3.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton3.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel3.add(boton3);
        //Agregando eventos de tipo ActionListener
        ActionListener accion3 = (ActionEvent ae) -> {

        };
        boton3.addActionListener(accion3);

        JButton boton4 = new JButton("Exportar Listado a PDF");
        boton4.setBounds(450, 180, 280, 60);
        boton4.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton4.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton4.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton4.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton4.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel3.add(boton4);
        //Agregando eventos de tipo ActionListener
        ActionListener accion4 = (ActionEvent ae) -> {

        };
        boton4.addActionListener(accion4);
    }

    private void colocarBotones_Vendedores() {
        JButton boton = new JButton("Crear");
        boton.setBounds(450, 20, 130, 60);
        boton.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel4.add(boton);
        //Agregando eventos de tipo ActionListener
        ActionListener accion = (ActionEvent ae) -> {
            vendedores_vCrear();
        };
        boton.addActionListener(accion);

        JButton boton1 = new JButton("Carga Masiva");
        boton1.setBounds(600, 20, 130, 60);
        boton1.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton1.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton1.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton1.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton1.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel4.add(boton1);
        //Agregando eventos de tipo ActionListener
        ActionListener accion1 = (ActionEvent ae) -> {

        };
        boton1.addActionListener(accion1);

        JButton boton2 = new JButton("Actualizar");
        boton2.setBounds(450, 100, 130, 60);
        boton2.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton2.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton2.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton2.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton2.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel4.add(boton2);
        //Agregando eventos de tipo ActionListener
        ActionListener accion2 = (ActionEvent ae) -> {
            vendedores_vActualizar();
        };
        boton2.addActionListener(accion2);

        JButton boton3 = new JButton("Eliminar");
        boton3.setBounds(600, 100, 130, 60);
        boton3.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton3.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton3.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton3.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton3.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel4.add(boton3);
        //Agregando eventos de tipo ActionListener
        ActionListener accion3 = (ActionEvent ae) -> {

        };
        boton3.addActionListener(accion3);

        JButton boton4 = new JButton("Exportar Listado a PDF");
        boton4.setBounds(450, 180, 280, 60);
        boton4.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton4.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton4.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton4.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
        boton4.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panel4.add(boton4);
        //Agregando eventos de tipo ActionListener
        ActionListener accion4 = (ActionEvent ae) -> {

        };
        boton4.addActionListener(accion4);
    }

    // ########################## Acciones de Botones Sucursales ###############################################
    private void sucursales_vCrear() {
        //Creando la ventana
        JFrame vCrear = new JFrame();
        vCrear.setSize(400, 400);
        vCrear.setTitle("Sucursales (Crear)");
        vCrear.setLocationRelativeTo(null);
        vCrear.setMinimumSize(new Dimension(200, 200));
        vCrear.setDefaultCloseOperation(HIDE_ON_CLOSE);    //Permite cerrar la pestaña
        vCrear.setResizable(false);
        vCrear.setVisible(true);
        //Agregando panel
        JPanel p_Crear = new JPanel();
        p_Crear.setBackground(Color.GREEN);
        p_Crear.setLayout(null);
        vCrear.add(p_Crear);
        //Agregando Label
        JLabel t1 = new JLabel("Crear Nueva Sucursal");
        t1.setBounds(150, 10, 200, 30);
        t1.setForeground(Color.BLACK);
//      etiqueta.setOpaque(true);   //otorga permiso para poder darle color a la etiqueta
//      etiqueta.setBackground(Color.yellow); // cambia el color de la etiqueta
//      etiqueta.setHorizontalAlignment(SwingConstants.CENTER);  pone la palabra en el centro de la etiqueta 
        t1.setFont(new Font("arial", Font.BOLD, 15));
        p_Crear.add(t1);

        JLabel t2 = new JLabel("Código");
        t2.setBounds(30, 50, 100, 30);
        t2.setForeground(Color.BLACK);
        t2.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t2);

        JLabel t3 = new JLabel("Nombre");
        t3.setBounds(30, 100, 100, 30);
        t3.setForeground(Color.BLACK);
        t3.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t3);

        JLabel t4 = new JLabel("Dirección");
        t4.setBounds(30, 150, 100, 30);
        t4.setForeground(Color.BLACK);
        t4.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t4);

        JLabel t5 = new JLabel("Correo");
        t5.setBounds(30, 200, 100, 30);
        t5.setForeground(Color.BLACK);
        t5.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t5);

        JLabel t6 = new JLabel("Teléfono");
        t6.setBounds(30, 250, 100, 30);
        t6.setForeground(Color.BLACK);
        t6.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t6);

        //Agregando JText
        JTextField c1 = new JTextField();
        c1.setBounds(110, 50, 250, 27);
        p_Crear.add(c1);

        JTextField c2 = new JTextField();
        c2.setBounds(110, 100, 250, 27);
        p_Crear.add(c2);

        JTextField c3 = new JTextField();
        c3.setBounds(110, 150, 250, 27);
        p_Crear.add(c3);

        JTextField c4 = new JTextField();
        c4.setBounds(110, 200, 250, 27);
        p_Crear.add(c4);

        JTextField c5 = new JTextField();
        c5.setBounds(110, 250, 250, 27);
        p_Crear.add(c5);

        //Boton agregar
        JButton b_agregar = new JButton("Agregar");
        b_agregar.setBounds(110, 310, 250, 30);
        b_agregar.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        b_agregar.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        b_agregar.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        b_agregar.setFont(new Font("arial", Font.BOLD, 13));  //establecemos la fuente de la letra del boton
        b_agregar.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        p_Crear.add(b_agregar);
        //Agregando eventos de tipo ActionListener
        ActionListener a_agregar = (ActionEvent ae) -> {

        };
        b_agregar.addActionListener(a_agregar);
    }

    private void sucursales_vActualizar() {
        //Creando la ventana
        JFrame vActualizar = new JFrame();
        vActualizar.setSize(400, 400);
        vActualizar.setTitle("Sucursales (Actualizar)");
        vActualizar.setLocationRelativeTo(null);
        vActualizar.setMinimumSize(new Dimension(200, 200));
        vActualizar.setDefaultCloseOperation(HIDE_ON_CLOSE);    //Permite cerrar la pestaña
        vActualizar.setResizable(false);
        vActualizar.setVisible(true);
        //Agregando panel
        JPanel p_Actualizar = new JPanel();
        p_Actualizar.setBackground(Color.GREEN);
        p_Actualizar.setLayout(null);
        vActualizar.add(p_Actualizar);
        //Agregando Label
        JLabel t1 = new JLabel("Actualizar Datos Sucursales");
        t1.setBounds(150, 10, 200, 30);
        t1.setForeground(Color.BLACK);
//      etiqueta.setOpaque(true);   //otorga permiso para poder darle color a la etiqueta
//      etiqueta.setBackground(Color.yellow); // cambia el color de la etiqueta
//      etiqueta.setHorizontalAlignment(SwingConstants.CENTER);  pone la palabra en el centro de la etiqueta 
        t1.setFont(new Font("arial", Font.BOLD, 15));
        p_Actualizar.add(t1);

        JLabel t2 = new JLabel("Código");
        t2.setBounds(30, 50, 100, 30);
        t2.setForeground(Color.BLACK);
        t2.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t2);

        JLabel t3 = new JLabel("Nombre");
        t3.setBounds(30, 100, 100, 30);
        t3.setForeground(Color.BLACK);
        t3.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t3);

        JLabel t4 = new JLabel("Dirección");
        t4.setBounds(30, 150, 100, 30);
        t4.setForeground(Color.BLACK);
        t4.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t4);

        JLabel t5 = new JLabel("Correo");
        t5.setBounds(30, 200, 100, 30);
        t5.setForeground(Color.BLACK);
        t5.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t5);

        JLabel t6 = new JLabel("Teléfono");
        t6.setBounds(30, 250, 100, 30);
        t6.setForeground(Color.BLACK);
        t6.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t6);

        //Agregando JText
        JTextField c1 = new JTextField();
        c1.setBounds(110, 50, 250, 27);
        p_Actualizar.add(c1);

        JTextField c2 = new JTextField();
        c2.setBounds(110, 100, 250, 27);
        p_Actualizar.add(c2);

        JTextField c3 = new JTextField();
        c3.setBounds(110, 150, 250, 27);
        p_Actualizar.add(c3);

        JTextField c4 = new JTextField();
        c4.setBounds(110, 200, 250, 27);
        p_Actualizar.add(c4);

        JTextField c5 = new JTextField();
        c5.setBounds(110, 250, 250, 27);
        p_Actualizar.add(c5);

        //Boton agregar
        JButton b_actualizar = new JButton("Actualizar");
        b_actualizar.setBounds(110, 310, 250, 30);
        b_actualizar.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        b_actualizar.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        b_actualizar.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        b_actualizar.setFont(new Font("arial", Font.BOLD, 13));  //establecemos la fuente de la letra del boton
        b_actualizar.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        p_Actualizar.add(b_actualizar);
        //Agregando eventos de tipo ActionListener
        ActionListener a_actualizar = (ActionEvent ae) -> {

        };
        b_actualizar.addActionListener(a_actualizar);
    }

    // ########################## Acciones de Botones Clientes ###############################################
    private void clientes_vCrear() {
        //Creando la ventana
        JFrame vCrear = new JFrame();
        vCrear.setSize(400, 400);
        vCrear.setTitle("Cliente (Crear)");
        vCrear.setLocationRelativeTo(null);
        vCrear.setMinimumSize(new Dimension(200, 200));
        vCrear.setDefaultCloseOperation(HIDE_ON_CLOSE);    //Permite cerrar la pestaña
        vCrear.setResizable(false);
        vCrear.setVisible(true);
        //Agregando panel
        JPanel p_Crear = new JPanel();
        p_Crear.setBackground(Color.GREEN);
        p_Crear.setLayout(null);
        vCrear.add(p_Crear);
        //Agregando Label
        JLabel t1 = new JLabel("Crear Nuevo Cliente");
        t1.setBounds(150, 10, 200, 30);
        t1.setForeground(Color.BLACK);
//      etiqueta.setOpaque(true);   //otorga permiso para poder darle color a la etiqueta
//      etiqueta.setBackground(Color.yellow); // cambia el color de la etiqueta
//      etiqueta.setHorizontalAlignment(SwingConstants.CENTER);  pone la palabra en el centro de la etiqueta 
        t1.setFont(new Font("arial", Font.BOLD, 15));
        p_Crear.add(t1);

        JLabel t2 = new JLabel("Código");
        t2.setBounds(30, 50, 100, 30);
        t2.setForeground(Color.BLACK);
        t2.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t2);

        JLabel t3 = new JLabel("Nombre");
        t3.setBounds(30, 100, 100, 30);
        t3.setForeground(Color.BLACK);
        t3.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t3);

        JLabel t4 = new JLabel("NIT");
        t4.setBounds(30, 150, 100, 30);
        t4.setForeground(Color.BLACK);
        t4.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t4);

        JLabel t5 = new JLabel("Correo");
        t5.setBounds(30, 200, 100, 30);
        t5.setForeground(Color.BLACK);
        t5.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t5);

        JLabel t6 = new JLabel("Género");
        t6.setBounds(30, 250, 100, 30);
        t6.setForeground(Color.BLACK);
        t6.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t6);

        //Agregando JText
        JTextField c1 = new JTextField();
        c1.setBounds(110, 50, 250, 27);
        p_Crear.add(c1);

        JTextField c2 = new JTextField();
        c2.setBounds(110, 100, 250, 27);
        p_Crear.add(c2);

        JTextField c3 = new JTextField();
        c3.setBounds(110, 150, 250, 27);
        p_Crear.add(c3);

        JTextField c4 = new JTextField();
        c4.setBounds(110, 200, 250, 27);
        p_Crear.add(c4);

        JTextField c5 = new JTextField();
        c5.setBounds(110, 250, 250, 27);
        p_Crear.add(c5);

        //Boton agregar
        JButton b_agregar = new JButton("Agregar");
        b_agregar.setBounds(110, 310, 250, 30);
        b_agregar.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        b_agregar.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        b_agregar.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        b_agregar.setFont(new Font("arial", Font.BOLD, 13));  //establecemos la fuente de la letra del boton
        b_agregar.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        p_Crear.add(b_agregar);
        //Agregando eventos de tipo ActionListener
        ActionListener a_agregar = (ActionEvent ae) -> {

        };
        b_agregar.addActionListener(a_agregar);
    }

    private void clientes_vActualizar() {
        //Creando la ventana
        JFrame vActualizar = new JFrame();
        vActualizar.setSize(400, 400);
        vActualizar.setTitle("Cliente (Actualizar)");
        vActualizar.setLocationRelativeTo(null);
        vActualizar.setMinimumSize(new Dimension(200, 200));
        vActualizar.setDefaultCloseOperation(HIDE_ON_CLOSE);    //Permite cerrar la pestaña
        vActualizar.setResizable(false);
        vActualizar.setVisible(true);
        //Agregando panel
        JPanel p_Actualizar = new JPanel();
        p_Actualizar.setBackground(Color.GREEN);
        p_Actualizar.setLayout(null);
        vActualizar.add(p_Actualizar);
        //Agregando Label
        JLabel t1 = new JLabel("Actualizar Datos Cliente");
        t1.setBounds(150, 10, 200, 30);
        t1.setForeground(Color.BLACK);
//      etiqueta.setOpaque(true);   //otorga permiso para poder darle color a la etiqueta
//      etiqueta.setBackground(Color.yellow); // cambia el color de la etiqueta
//      etiqueta.setHorizontalAlignment(SwingConstants.CENTER);  pone la palabra en el centro de la etiqueta 
        t1.setFont(new Font("arial", Font.BOLD, 15));
        p_Actualizar.add(t1);

        JLabel t2 = new JLabel("Código");
        t2.setBounds(30, 50, 100, 30);
        t2.setForeground(Color.BLACK);
        t2.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t2);

        JLabel t3 = new JLabel("Nombre");
        t3.setBounds(30, 100, 100, 30);
        t3.setForeground(Color.BLACK);
        t3.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t3);

        JLabel t4 = new JLabel("NIT");
        t4.setBounds(30, 150, 100, 30);
        t4.setForeground(Color.BLACK);
        t4.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t4);

        JLabel t5 = new JLabel("Correo");
        t5.setBounds(30, 200, 100, 30);
        t5.setForeground(Color.BLACK);
        t5.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t5);

        JLabel t6 = new JLabel("Género");
        t6.setBounds(30, 250, 100, 30);
        t6.setForeground(Color.BLACK);
        t6.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t6);

        //Agregando JText
        JTextField c1 = new JTextField();
        c1.setBounds(110, 50, 250, 27);
        p_Actualizar.add(c1);

        JTextField c2 = new JTextField();
        c2.setBounds(110, 100, 250, 27);
        p_Actualizar.add(c2);

        JTextField c3 = new JTextField();
        c3.setBounds(110, 150, 250, 27);
        p_Actualizar.add(c3);

        JTextField c4 = new JTextField();
        c4.setBounds(110, 200, 250, 27);
        p_Actualizar.add(c4);

        JTextField c5 = new JTextField();
        c5.setBounds(110, 250, 250, 27);
        p_Actualizar.add(c5);

        //Boton agregar
        JButton b_actualizar = new JButton("Actualizar");
        b_actualizar.setBounds(110, 310, 250, 30);
        b_actualizar.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        b_actualizar.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        b_actualizar.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        b_actualizar.setFont(new Font("arial", Font.BOLD, 13));  //establecemos la fuente de la letra del boton
        b_actualizar.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        p_Actualizar.add(b_actualizar);
        //Agregando eventos de tipo ActionListener
        ActionListener a_actualizar = (ActionEvent ae) -> {

        };
        b_actualizar.addActionListener(a_actualizar);
    }

    // ########################## Acciones de Botones Vendedores ###############################################
    private void vendedores_vCrear() {
        //Creando la ventana
        JFrame vCrear = new JFrame();
        vCrear.setSize(400, 450);
        vCrear.setTitle("Vendedor (Crear)");
        vCrear.setLocationRelativeTo(null);
        vCrear.setMinimumSize(new Dimension(200, 200));
        vCrear.setDefaultCloseOperation(HIDE_ON_CLOSE);    //Permite cerrar la pestaña
        vCrear.setResizable(false);
        vCrear.setVisible(true);
        //Agregando panel
        JPanel p_Crear = new JPanel();
        p_Crear.setBackground(Color.GREEN);
        p_Crear.setLayout(null);
        vCrear.add(p_Crear);
        //Agregando Label
        JLabel t1 = new JLabel("Crear Nuevo Vendedor");
        t1.setBounds(150, 10, 200, 30);
        t1.setForeground(Color.BLACK);
//      etiqueta.setOpaque(true);   //otorga permiso para poder darle color a la etiqueta
//      etiqueta.setBackground(Color.yellow); // cambia el color de la etiqueta
//      etiqueta.setHorizontalAlignment(SwingConstants.CENTER);  pone la palabra en el centro de la etiqueta 
        t1.setFont(new Font("arial", Font.BOLD, 15));
        p_Crear.add(t1);

        JLabel t2 = new JLabel("Código");
        t2.setBounds(30, 50, 100, 30);
        t2.setForeground(Color.BLACK);
        t2.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t2);

        JLabel t3 = new JLabel("Nombre");
        t3.setBounds(30, 100, 100, 30);
        t3.setForeground(Color.BLACK);
        t3.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t3);

        JLabel t4 = new JLabel("Caja");
        t4.setBounds(30, 150, 100, 30);
        t4.setForeground(Color.BLACK);
        t4.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t4);

        JLabel t5 = new JLabel("Ventas");
        t5.setBounds(30, 200, 100, 30);
        t5.setForeground(Color.BLACK);
        t5.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t5);

        JLabel t6 = new JLabel("Género");
        t6.setBounds(30, 250, 100, 30);
        t6.setForeground(Color.BLACK);
        t6.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t6);

        JLabel t7 = new JLabel("Password");
        t7.setBounds(30, 300, 100, 30);
        t7.setForeground(Color.BLACK);
        t7.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t7);

        //Agregando JText
        JTextField c1 = new JTextField();
        c1.setBounds(110, 50, 250, 27);
        p_Crear.add(c1);

        JTextField c2 = new JTextField();
        c2.setBounds(110, 100, 250, 27);
        p_Crear.add(c2);

        JTextField c3 = new JTextField();
        c3.setBounds(110, 150, 250, 27);
        p_Crear.add(c3);

        JTextField c4 = new JTextField();
        c4.setBounds(110, 200, 250, 27);
        p_Crear.add(c4);

        JTextField c5 = new JTextField();
        c5.setBounds(110, 250, 250, 27);
        p_Crear.add(c5);

        JPasswordField c6 = new JPasswordField();
        c6.setBounds(110, 300, 250, 27);
        p_Crear.add(c6);

        //Boton agregar
        JButton b_agregar = new JButton("Agregar");
        b_agregar.setBounds(110, 360, 250, 30);
        b_agregar.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        b_agregar.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        b_agregar.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        b_agregar.setFont(new Font("arial", Font.BOLD, 13));  //establecemos la fuente de la letra del boton
        b_agregar.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        p_Crear.add(b_agregar);
        //Agregando eventos de tipo ActionListener
        ActionListener a_agregar = (ActionEvent ae) -> {

            for (int i = 0; i < guardarVendedor.length; i++) {
//                int codigoVend = Integer.parseInt(c1.getText());
                String codigoVend = c1.getText();
                String nombreVend = c2.getText();
//                int cajaVend = Integer.parseInt(c3.getText());
                String cajaVend = c3.getText();
//                int ventasVend = Integer.parseInt(c3.getText());
                String ventasVend = c4.getText();
                String generoVend = c5.getText();
                String passwordVend = c6.getText();
                
                guardarVendedor[i] = new Vendedor(codigoVend, nombreVend, cajaVend, ventasVend, generoVend, passwordVend);
                almacenaVendedor[i][0] = guardarVendedor[i].getCodigo();
                almacenaVendedor[i][1] = guardarVendedor[i].getNombre();
                almacenaVendedor[i][2] =guardarVendedor[i].getVendedorCaja();
                almacenaVendedor[i][3] = guardarVendedor[i].getVendedorVentas();
                almacenaVendedor[i][4] = guardarVendedor[i].getGenero();
                modelo_tabVende.addRow(almacenaVendedor[i]);
                vCrear.dispose();
            }
            tamañoVectorVendedor = tamañoVectorVendedor + 1;
        };
        b_agregar.addActionListener(a_agregar);
    }

    private void vendedores_vActualizar() {
        //Creando la ventana
        JFrame vActualizar = new JFrame();
        vActualizar.setSize(400, 450);
        vActualizar.setTitle("Vendedor (Actualizar)");
        vActualizar.setLocationRelativeTo(null);
        vActualizar.setMinimumSize(new Dimension(200, 200));
        vActualizar.setDefaultCloseOperation(HIDE_ON_CLOSE);    //Permite cerrar la pestaña
        vActualizar.setResizable(false);
        vActualizar.setVisible(true);
        //Agregando panel
        JPanel p_Actualizar = new JPanel();
        p_Actualizar.setBackground(Color.GREEN);
        p_Actualizar.setLayout(null);
        vActualizar.add(p_Actualizar);
        //Agregando Label
        JLabel t1 = new JLabel("Actualizar Datos Vendedor");
        t1.setBounds(150, 10, 200, 30);
        t1.setForeground(Color.BLACK);
//      etiqueta.setOpaque(true);   //otorga permiso para poder darle color a la etiqueta
//      etiqueta.setBackground(Color.yellow); // cambia el color de la etiqueta
//      etiqueta.setHorizontalAlignment(SwingConstants.CENTER);  pone la palabra en el centro de la etiqueta 
        t1.setFont(new Font("arial", Font.BOLD, 15));
        p_Actualizar.add(t1);

        JLabel t2 = new JLabel("Código");
        t2.setBounds(30, 50, 100, 30);
        t2.setForeground(Color.BLACK);
        t2.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t2);

        JLabel t3 = new JLabel("Nombre");
        t3.setBounds(30, 100, 100, 30);
        t3.setForeground(Color.BLACK);
        t3.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t3);

        JLabel t4 = new JLabel("Caja");
        t4.setBounds(30, 150, 100, 30);
        t4.setForeground(Color.BLACK);
        t4.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t4);

        JLabel t5 = new JLabel("Ventas");
        t5.setBounds(30, 200, 100, 30);
        t5.setForeground(Color.BLACK);
        t5.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t5);

        JLabel t6 = new JLabel("Género");
        t6.setBounds(30, 250, 100, 30);
        t6.setForeground(Color.BLACK);
        t6.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t6);

        JLabel t7 = new JLabel("Password");
        t7.setBounds(30, 300, 100, 30);
        t7.setForeground(Color.BLACK);
        t7.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t7);

        //Agregando JText
        JTextField c1 = new JTextField();
        c1.setBounds(110, 50, 250, 27);
        p_Actualizar.add(c1);

        JTextField c2 = new JTextField();
        c2.setBounds(110, 100, 250, 27);
        p_Actualizar.add(c2);

        JTextField c3 = new JTextField();
        c3.setBounds(110, 150, 250, 27);
        p_Actualizar.add(c3);

        JTextField c4 = new JTextField();
        c4.setBounds(110, 200, 250, 27);
        p_Actualizar.add(c4);

        JTextField c5 = new JTextField();
        c5.setBounds(110, 250, 250, 27);
        p_Actualizar.add(c5);

        JPasswordField c6 = new JPasswordField();
        c6.setBounds(110, 300, 250, 27);
        p_Actualizar.add(c6);

        //Boton agregar
        JButton b_actualizar = new JButton("Actualizar");
        b_actualizar.setBounds(110, 360, 250, 30);
        b_actualizar.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        b_actualizar.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        b_actualizar.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        b_actualizar.setFont(new Font("arial", Font.BOLD, 13));  //establecemos la fuente de la letra del boton
        b_actualizar.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        p_Actualizar.add(b_actualizar);
        //Agregando eventos de tipo ActionListener
        ActionListener a_actualizar = (ActionEvent ae) -> {
               for (int i = 0; i < guardarVendedor.length; i++) {
//                int codigoVend = Integer.parseInt(c1.getText());
                String codigoVend = c1.getText();
                String nombreVend = c2.getText();
//                int cajaVend = Integer.parseInt(c3.getText());
                String cajaVend = c3.getText();
//                int ventasVend = Integer.parseInt(c3.getText());
                String ventasVend = c4.getText();
                String generoVend = c5.getText();
                String passwordVend = c6.getText();
                int indice = Integer.parseInt(c1.getText());
                if(i == (indice-1)){
                guardarVendedor[i] = new Vendedor(codigoVend, nombreVend, cajaVend, ventasVend, generoVend, passwordVend);
                almacenaVendedor[i][0] = guardarVendedor[i].getCodigo();
                almacenaVendedor[i][1] = guardarVendedor[i].getNombre();
                almacenaVendedor[i][2] = guardarVendedor[i].getVendedorCaja();
                almacenaVendedor[i][3] = guardarVendedor[i].getVendedorVentas();
                almacenaVendedor[i][4] = guardarVendedor[i].getGenero();
                modelo_tabVende.addRow(almacenaVendedor[i]); 
                
                }
                vActualizar.dispose();
                
            }
        };
        b_actualizar.addActionListener(a_actualizar);
    }

    // ########################## Tablas ###############################################
    private void colocarTabla_Sucursales() {
        DefaultTableModel modelo_tab = new DefaultTableModel();
        modelo_tab.addColumn("Código");
        modelo_tab.addColumn("Nombre");
        modelo_tab.addColumn("Dirección");
        modelo_tab.addColumn("Correo");
        modelo_tab.addColumn("Teléfono");
        JTable tab = new JTable(modelo_tab);
        JScrollPane scr = new JScrollPane(tab);
        scr.setBounds(25, 20, 400, 650);
        panel1.add(scr);
//        String [] dat = {"1","da","9 calle b","ca@g.com","231546"};
//        String [] dat1 = {"2","ale","9 calle b","ca@g.com","549875"};
//        modelo_tab.addRow(dat);    el .addRow() agrega una fila a la tabla 
//        modelo_tab.addRow(dat1);
    }

    private void colocarTabla_Productos() {
        DefaultTableModel modelo_tab = new DefaultTableModel();
        modelo_tab.addColumn("Código");
        modelo_tab.addColumn("Nombre");
        modelo_tab.addColumn("Descripción");
        modelo_tab.addColumn("Cantidad");
        modelo_tab.addColumn("Precio");
        JTable tab = new JTable(modelo_tab);
        JScrollPane scr = new JScrollPane(tab);
        scr.setBounds(25, 20, 400, 650);
        panel2.add(scr);
//        String [] dat = {"1","da","9 calle b","ca@g.com","231546"};
//        String [] dat1 = {"2","ale","9 calle b","ca@g.com","549875"};
//        modelo_tab.addRow(dat);    el .addRow() agrega una fila a la tabla 
//        modelo_tab.addRow(dat1);
    }

    private void colocarTabla_Clientes() {
        DefaultTableModel modelo_tab = new DefaultTableModel();
        modelo_tab.addColumn("Código");
        modelo_tab.addColumn("Nombre");
        modelo_tab.addColumn("NIT");
        modelo_tab.addColumn("Correo");
        modelo_tab.addColumn("Género");
        JTable tab = new JTable(modelo_tab);
        JScrollPane scr = new JScrollPane(tab);
        scr.setBounds(25, 20, 400, 650);
        panel3.add(scr);
//        String [] dat = {"1","da","9 calle b","ca@g.com","231546"};
//        String [] dat1 = {"2","ale","9 calle b","ca@g.com","549875"};
//        modelo_tab.addRow(dat);    el .addRow() agrega una fila a la tabla 
//        modelo_tab.addRow(dat1);
    }

    private void colocarTabla_Vendedores() {
        modelo_tabVende.addColumn("Código");
        modelo_tabVende.addColumn("Nombre");
        modelo_tabVende.addColumn("Caja");
        modelo_tabVende.addColumn("Ventas");
        modelo_tabVende.addColumn("Género");
        JTable tab = new JTable(modelo_tabVende);
        JScrollPane scr = new JScrollPane(tab);
        scr.setBounds(25, 20, 400, 650);
        panel4.add(scr);
//        String [] dat = {"1","da","9 calle b","ca@g.com","231546"};
//        String [] dat1 = {"2","ale","9 calle b","ca@g.com","549875"};
//        modelo_tab.addRow(dat);    el .addRow() agrega una fila a la tabla 
//        modelo_tab.addRow(dat1);

    }

    // ########################## Graficos ###############################################
    private void colocarGrafico_Productos() {

    }

    private void colocarGrafico_Clientes() {

    }

    private void colocarGrafico_Vendedores() {

    }
}
