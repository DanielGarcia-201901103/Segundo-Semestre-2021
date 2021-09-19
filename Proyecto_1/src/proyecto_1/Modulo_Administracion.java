package proyecto_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Modulo_Administracion {

    private JFrame ventanaAdmin = new JFrame();
    private JPanel panel, panel1, panel2, panel3, panel4;
    private JTabbedPane primeras_pestañas = new JTabbedPane();
    
    //Datos para vendedor
    int contador_Vendedor = 0;
    DefaultTableModel modelo_tabVende = new DefaultTableModel();
    String almacenaVendedor[][] = new String[GuardarObjetos.guardarVendedor.length][6];   // almacenamiento temporal para los vendedores y agregarlos a la tabla
    JTable tab_Vendedores;
    
    //Datos para cliente
    int contador_Cliente = 0;
    DefaultTableModel modelo_tabCliente = new DefaultTableModel();
    String almacenaCliente[][] = new String[GuardarObjetos.guardarCliente.length][5];
    JTable tab_Clientes;
    
    //Datos para productos
    int contador_Producto = 0;
    DefaultTableModel modelo_tabProducto = new DefaultTableModel();
    String almacenaProducto[][] = new String[GuardarObjetos.guardarProductos.length][5];
    JTable tab_Productos;
    
    //Datos para sucursales
    int contador_Sucursal = 0;
    DefaultTableModel modelo_tabSucursal = new DefaultTableModel();
    String almacenaSucursal[][] = new String[GuardarObjetos.guardarSucursales.length][5];
    JTable tab_Sucursal;
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
    // inicia cada componente de la ventana  tablas, pestañas, paneles, botones , etc

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

    // BOTON PARA CERRAR SESION
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
            if (tab_Sucursal.getSelectedRow() < 0) {
                JOptionPane.showMessageDialog(null, "Seleccione la fila a eliminar");
            } else {
                int indiceEliminar = tab_Sucursal.getSelectedRow(); // obtiene la fila seleccionada
                Object indiceFilaCodigo = tab_Sucursal.getValueAt(indiceEliminar, 0); // obtiene el valor que se encuentra en la columna de la fila seleccionada
                int convertirIndiceCodigo = Integer.valueOf((String) indiceFilaCodigo);
//                System.out.println("" + indiceEliminar + " " + indiceFilaCodigo+ "  codigo: " +convertirIndiceCodigo);
                int conf = JOptionPane.showConfirmDialog(null, "Desea eliminar el elemento seleccionado?");
                if (JOptionPane.OK_OPTION == conf) {
                    modelo_tabSucursal.removeRow(tab_Sucursal.getSelectedRow());
                    for (int i = 0; i < GuardarObjetos.guardarSucursales.length; i++) {
                        if (convertirIndiceCodigo == GuardarObjetos.guardarSucursales[i].getSucursalCodigo()) {
                            GuardarObjetos.guardarSucursales[i] = new Sucursal(0,null,null,null,null);
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "El elemento seleccionado fue eliminado");
                }
            }
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
            productos_vCrear();
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
            productos_vActualizar();
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
             if (tab_Productos.getSelectedRow() < 0) {
                JOptionPane.showMessageDialog(null, "Seleccione la fila a eliminar");
            } else {
                int indiceEliminar = tab_Productos.getSelectedRow(); // obtiene la fila seleccionada
                Object indiceFilaCodigo = tab_Productos.getValueAt(indiceEliminar, 0); // obtiene el valor que se encuentra en la columna de la fila seleccionada
                int convertirIndiceCodigo = Integer.valueOf((String) indiceFilaCodigo);
//                System.out.println("" + indiceEliminar + " " + indiceFilaCodigo+ "  codigo: " +convertirIndiceCodigo);
                int conf = JOptionPane.showConfirmDialog(null, "Desea eliminar el elemento seleccionado?");
                if (JOptionPane.OK_OPTION == conf) {
                    modelo_tabProducto.removeRow(tab_Productos.getSelectedRow());
                    for (int i = 0; i < GuardarObjetos.guardarProductos.length; i++) {
                        if (convertirIndiceCodigo == GuardarObjetos.guardarProductos[i].getProductoCodigo()) {
                            GuardarObjetos.guardarProductos[i] = new Producto(0,null,null,0,0);
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "El elemento seleccionado fue eliminado");
                }
            }
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
            if (tab_Clientes.getSelectedRow() < 0) {
                JOptionPane.showMessageDialog(null, "Seleccione la fila a eliminar");
            } else {
                int indiceEliminar = tab_Clientes.getSelectedRow(); // obtiene la fila seleccionada
                Object indiceFilaCodigo = tab_Clientes.getValueAt(indiceEliminar, 0); // obtiene el valor que se encuentra en la columna de la fila seleccionada
                int convertirIndiceCodigo = Integer.valueOf((String) indiceFilaCodigo);
//                System.out.println("" + indiceEliminar + " " + indiceFilaCodigo+ "  codigo: " +convertirIndiceCodigo);
                int conf = JOptionPane.showConfirmDialog(null, "Desea eliminar el elemento seleccionado?");
                if (JOptionPane.OK_OPTION == conf) {
                    modelo_tabCliente.removeRow(tab_Clientes.getSelectedRow());
                    for (int i = 0; i < GuardarObjetos.guardarCliente.length; i++) {
                        if (convertirIndiceCodigo == GuardarObjetos.guardarCliente[i].getClienteCodigo()) {
                            GuardarObjetos.guardarCliente[i] = new Cliente(0,null,0,null,null);
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "El elemento seleccionado fue eliminado");
                }
            }
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
            try {
                vendedores_CargaMasiva();
            } catch (IOException ex) {
                Logger.getLogger(Modulo_Administracion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Modulo_Administracion.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            if (tab_Vendedores.getSelectedRow() < 0) {
                JOptionPane.showMessageDialog(null, "Seleccione la fila a eliminar");
            } else {
                int indiceEliminar = tab_Vendedores.getSelectedRow(); // obtiene la fila seleccionada
                Object indiceFilaCodigo = tab_Vendedores.getValueAt(indiceEliminar, 0); // obtiene el valor que se encuentra en la columna de la fila seleccionada
                int convertirIndiceCodigo = Integer.valueOf((String) indiceFilaCodigo);
//                System.out.println("" + indiceEliminar + " " + indiceFilaCodigo+ "  codigo: " +convertirIndiceCodigo);
                int conf = JOptionPane.showConfirmDialog(null, "Desea eliminar el elemento seleccionado?");
                if (JOptionPane.OK_OPTION == conf) {
                    modelo_tabVende.removeRow(tab_Vendedores.getSelectedRow());
                    for (int i = 0; i < GuardarObjetos.guardarVendedor.length; i++) {
                        if (convertirIndiceCodigo == GuardarObjetos.guardarVendedor[i].getVendedorCodigo()) {
                            GuardarObjetos.guardarVendedor[i] = new Vendedor(0, null, 0, 0, null, null);
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "El elemento seleccionado fue eliminado");
                }
            }
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
            vendedores_PDF();
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

            int codigoSuc = Integer.parseInt(c1.getText());
            String nombreSuc = c2.getText();
            String direccionSuc = c3.getText();
            String correoSuc = c4.getText();
            String telefonoSuc = c5.getText();

            if (GuardarObjetos.guardarSucursales[contador_Sucursal] == null && contador_Sucursal < GuardarObjetos.guardarSucursales.length) {
                GuardarObjetos.guardarSucursales[contador_Sucursal] = new Sucursal(codigoSuc, nombreSuc, direccionSuc, correoSuc, telefonoSuc);
                almacenaSucursal[contador_Sucursal][0] = Integer.toString(GuardarObjetos.guardarSucursales[contador_Sucursal].getSucursalCodigo());
                almacenaSucursal[contador_Sucursal][1] = GuardarObjetos.guardarSucursales[contador_Sucursal].getSucursalNombre();
                almacenaSucursal[contador_Sucursal][2] = GuardarObjetos.guardarSucursales[contador_Sucursal].getSucursalDireccion();
                almacenaSucursal[contador_Sucursal][3] = GuardarObjetos.guardarSucursales[contador_Sucursal].getSucursalCorreo();
                almacenaSucursal[contador_Sucursal][4] = GuardarObjetos.guardarSucursales[contador_Sucursal].getSucursalTelefono();
                modelo_tabSucursal.addRow(almacenaSucursal[contador_Sucursal]);
                contador_Sucursal = contador_Sucursal + 1;
            }

            vCrear.dispose();
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

            int codigoSuc = Integer.parseInt(c1.getText());
            String nombreSuc = c2.getText();
            String direccionSuc = c3.getText();
            String correoSuc = c4.getText();
            String telefonoSuc = c5.getText();
            for (int i = 0; i < GuardarObjetos.guardarSucursales.length; i++) {
                if (codigoSuc == GuardarObjetos.guardarSucursales[i].getSucursalCodigo()) {
                    GuardarObjetos.guardarSucursales[i] = new Sucursal(codigoSuc, nombreSuc, direccionSuc, correoSuc, telefonoSuc);
                    modelo_tabSucursal.setValueAt(Integer.toString(GuardarObjetos.guardarSucursales[i].getSucursalCodigo()), i, 0);
                    modelo_tabSucursal.setValueAt(GuardarObjetos.guardarSucursales[i].getSucursalNombre(), i, 1);
                    modelo_tabSucursal.setValueAt(GuardarObjetos.guardarSucursales[i].getSucursalDireccion(), i, 2);
                    modelo_tabSucursal.setValueAt(GuardarObjetos.guardarSucursales[i].getSucursalCorreo(), i, 3);
                    modelo_tabSucursal.setValueAt(GuardarObjetos.guardarSucursales[i].getSucursalTelefono(), i, 4);
                    break;
                }
            }

            vActualizar.dispose();
        };
        b_actualizar.addActionListener(a_actualizar);
    }

    // ########################## Acciones de Botones Sucursales ###############################################
    private void productos_vCrear() {
        //Creando la ventana
        JFrame vCrear = new JFrame();
        vCrear.setSize(400, 400);
        vCrear.setTitle("Productos(Crear)");
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
        JLabel t1 = new JLabel("Crear Nuevo Producto");
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

        JLabel t4 = new JLabel("Descripción");
        t4.setBounds(30, 150, 100, 30);
        t4.setForeground(Color.BLACK);
        t4.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t4);

        JLabel t5 = new JLabel("Cantidad");
        t5.setBounds(30, 200, 100, 30);
        t5.setForeground(Color.BLACK);
        t5.setFont(new Font("arial", Font.BOLD, 13));
        p_Crear.add(t5);

        JLabel t6 = new JLabel("Precio");
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

            int codigoProd = Integer.parseInt(c1.getText());
            String nombreProd = c2.getText();
            String descripcionProd = c3.getText();
            int cantidadProd = Integer.parseInt(c4.getText());
            float precioProd = Float.parseFloat(c5.getText());

            if (GuardarObjetos.guardarProductos[contador_Producto] == null && contador_Producto < GuardarObjetos.guardarProductos.length) {
                GuardarObjetos.guardarProductos[contador_Producto] = new Producto(codigoProd, nombreProd, descripcionProd, cantidadProd, precioProd);
                almacenaProducto[contador_Producto][0] = Integer.toString(GuardarObjetos.guardarProductos[contador_Producto].getProductoCodigo());
                almacenaProducto[contador_Producto][1] = GuardarObjetos.guardarProductos[contador_Producto].getProductoNombre();
                almacenaProducto[contador_Producto][2] = GuardarObjetos.guardarProductos[contador_Producto].getProductoDescripcion();
                almacenaProducto[contador_Producto][3] = Integer.toString(GuardarObjetos.guardarProductos[contador_Producto].getProductoCantidad());
                almacenaProducto[contador_Producto][4] = Float.toString(GuardarObjetos.guardarProductos[contador_Producto].getProductoPrecio());
                modelo_tabProducto.addRow(almacenaProducto[contador_Producto]);
                contador_Producto = contador_Producto + 1;
            }

            vCrear.dispose();
        };
        b_agregar.addActionListener(a_agregar);
    }

    private void productos_vActualizar() {
        //Creando la ventana
        JFrame vActualizar = new JFrame();
        vActualizar.setSize(400, 400);
        vActualizar.setTitle("Producto (Actualizar)");
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
        JLabel t1 = new JLabel("Actualizar Datos Producto");
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

        JLabel t4 = new JLabel("Descripción");
        t4.setBounds(30, 150, 100, 30);
        t4.setForeground(Color.BLACK);
        t4.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t4);

        JLabel t5 = new JLabel("Cantidad");
        t5.setBounds(30, 200, 100, 30);
        t5.setForeground(Color.BLACK);
        t5.setFont(new Font("arial", Font.BOLD, 13));
        p_Actualizar.add(t5);

        JLabel t6 = new JLabel("Precio");
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

            int codigoProd = Integer.parseInt(c1.getText());
            String nombreProd = c2.getText();
            String descripcionProd = c3.getText();
            int cantidadProd = Integer.parseInt(c4.getText());
            float precioProd = Float.parseFloat(c5.getText());

            for (int i = 0; i < GuardarObjetos.guardarProductos.length; i++) {
                if (codigoProd == GuardarObjetos.guardarProductos[i].getProductoCodigo()) {
                    GuardarObjetos.guardarProductos[i] = new Producto(codigoProd, nombreProd, descripcionProd, cantidadProd, precioProd);
                    modelo_tabProducto.setValueAt(Integer.toString(GuardarObjetos.guardarProductos[i].getProductoCodigo()), i, 0);
                    modelo_tabProducto.setValueAt(GuardarObjetos.guardarProductos[i].getProductoNombre(), i, 1);
                    modelo_tabProducto.setValueAt(GuardarObjetos.guardarProductos[i].getProductoDescripcion(), i, 2);
                    modelo_tabProducto.setValueAt(Integer.toString(GuardarObjetos.guardarProductos[i].getProductoCantidad()), i, 3);
                    modelo_tabProducto.setValueAt(Float.toString(GuardarObjetos.guardarProductos[i].getProductoPrecio()), i, 4);

                    break;
                }
            }

            vActualizar.dispose();

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

            int codigoClien = Integer.parseInt(c1.getText());
            String nombreClien = c2.getText();
            int nitClien = Integer.parseInt(c3.getText());
            String correoClien = c4.getText();
            String generoClien = c5.getText();
            if (GuardarObjetos.guardarCliente[contador_Cliente] == null && contador_Cliente < GuardarObjetos.guardarCliente.length) {
                GuardarObjetos.guardarCliente[contador_Cliente] = new Cliente(codigoClien, nombreClien, nitClien, correoClien, generoClien);
                almacenaCliente[contador_Cliente][0] = Integer.toString(GuardarObjetos.guardarCliente[contador_Cliente].getClienteCodigo());
                almacenaCliente[contador_Cliente][1] = GuardarObjetos.guardarCliente[contador_Cliente].getClienteNombre();
                almacenaCliente[contador_Cliente][2] = Integer.toString(GuardarObjetos.guardarCliente[contador_Cliente].getClienteNit());
                almacenaCliente[contador_Cliente][3] = GuardarObjetos.guardarCliente[contador_Cliente].getClienteCorreo();
                almacenaCliente[contador_Cliente][4] = GuardarObjetos.guardarCliente[contador_Cliente].getClienteGenero();
                modelo_tabCliente.addRow(almacenaCliente[contador_Cliente]);
                contador_Cliente = contador_Cliente + 1;
            }

            vCrear.dispose();
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
            int codigoClien = Integer.parseInt(c1.getText());
            String nombreClien = c2.getText();
            int nitClien = Integer.parseInt(c3.getText());
            String correoClien = c4.getText();
            String generoClien = c5.getText();

            for (int i = 0; i < GuardarObjetos.guardarCliente.length; i++) {
                if (codigoClien == GuardarObjetos.guardarCliente[i].getClienteCodigo()) {
                    GuardarObjetos.guardarCliente[i] = new Cliente(codigoClien, nombreClien, nitClien, correoClien, generoClien);
                    modelo_tabCliente.setValueAt(Integer.toString(GuardarObjetos.guardarCliente[i].getClienteCodigo()), i, 0);
                    modelo_tabCliente.setValueAt(GuardarObjetos.guardarCliente[i].getClienteNombre(), i, 1);
                    modelo_tabCliente.setValueAt(Integer.toString(GuardarObjetos.guardarCliente[i].getClienteNit()), i, 2);
                    modelo_tabCliente.setValueAt(GuardarObjetos.guardarCliente[i].getClienteCorreo(), i, 3);
                    modelo_tabCliente.setValueAt(GuardarObjetos.guardarCliente[i].getClienteGenero(), i, 4);
                    break;
                }
            }
            vActualizar.dispose();

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
            int codigoVend = Integer.parseInt(c1.getText());
            String nombreVend = c2.getText();
            int cajaVend = Integer.parseInt(c3.getText());
            int ventasVend = Integer.parseInt(c4.getText());
            String generoVend = c5.getText();
            String passwordVend = c6.getText();
            if (GuardarObjetos.guardarVendedor[contador_Vendedor] == null && contador_Vendedor < GuardarObjetos.guardarVendedor.length) {
                GuardarObjetos.guardarVendedor[contador_Vendedor] = new Vendedor(codigoVend, nombreVend, cajaVend, ventasVend, generoVend, passwordVend);
                almacenaVendedor[contador_Vendedor][0] = Integer.toString(GuardarObjetos.guardarVendedor[contador_Vendedor].getVendedorCodigo());
                almacenaVendedor[contador_Vendedor][1] = GuardarObjetos.guardarVendedor[contador_Vendedor].getVendedorNombre();
                almacenaVendedor[contador_Vendedor][2] = Integer.toString(GuardarObjetos.guardarVendedor[contador_Vendedor].getVendedorCaja());
                almacenaVendedor[contador_Vendedor][3] = Integer.toString(GuardarObjetos.guardarVendedor[contador_Vendedor].getVendedorVentas());
                almacenaVendedor[contador_Vendedor][4] = GuardarObjetos.guardarVendedor[contador_Vendedor].getVendedorGenero();
                modelo_tabVende.addRow(almacenaVendedor[contador_Vendedor]);
                contador_Vendedor = contador_Vendedor + 1;

            }

            vCrear.dispose();

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
            int codigoVend = Integer.parseInt(c1.getText());
            String nombreVend = c2.getText();
            int cajaVend = Integer.parseInt(c3.getText());
            int ventasVend = Integer.parseInt(c4.getText());
            String generoVend = c5.getText();
            String passwordVend = c6.getText();
            for (int i = 0; i < GuardarObjetos.guardarVendedor.length; i++) {
                if (codigoVend == GuardarObjetos.guardarVendedor[i].getVendedorCodigo()) {
                    GuardarObjetos.guardarVendedor[i] = new Vendedor(codigoVend, nombreVend, cajaVend, ventasVend, generoVend, passwordVend);
                    modelo_tabVende.setValueAt(Integer.toString(GuardarObjetos.guardarVendedor[i].getVendedorCodigo()), i, 0);
                    modelo_tabVende.setValueAt(GuardarObjetos.guardarVendedor[i].getVendedorNombre(), i, 1);
                    modelo_tabVende.setValueAt(Integer.toString(GuardarObjetos.guardarVendedor[i].getVendedorCaja()), i, 2);
                    modelo_tabVende.setValueAt(Integer.toString(GuardarObjetos.guardarVendedor[i].getVendedorVentas()), i, 3);
                    modelo_tabVende.setValueAt(GuardarObjetos.guardarVendedor[i].getVendedorGenero(), i, 4);
                    break;
                }
            }
            vActualizar.dispose();

        };
        b_actualizar.addActionListener(a_actualizar);
    }

    private void vendedores_CargaMasiva() throws FileNotFoundException, IOException, ParseException {
        try {
            JFileChooser seleccionArchivo = new JFileChooser();
            seleccionArchivo.showOpenDialog(panel4);
            File arch = seleccionArchivo.getSelectedFile();
            String pathR = arch.getAbsolutePath(); //obtiene la ruta del archivo seleccionado
            BufferedReader abrirArchivo = new BufferedReader(new FileReader(arch));
            String filaLectura;
            String contenido = "";
            String espacio = "\n";
            while ((filaLectura = abrirArchivo.readLine()) != null) {
                contenido = filaLectura + espacio;
                System.out.println("" + contenido);
            }
            System.out.println("asdfasdfasdfasdf");
            JSONParser pr = new JSONParser();
            System.out.println("asdfasdfasdfasdf");
//            JSONArray arregloDatos = (JSONArray) pr.parse(pathR);
            JSONArray arregloDatos = (JSONArray) pr.parse(pathR);
            System.out.println("asdfasdfasdfasdf");
            int cont = 0;
            System.out.println("asdfasdfasdfasdf");
            do {
                for (int i = 0; i < arregloDatos.size(); i++) {
                    JSONObject objeto = (JSONObject) arregloDatos.get(i);
                    cont += 1;

                    int codigoVendedor = (int) objeto.get("codigo");
                    String nombreVendedor = (String) objeto.get("nombre");
                    int cajaVendedor = (int) objeto.get("caja");
                    int ventasVendedor = (int) objeto.get("ventas");
                    String generoVendedor = (String) objeto.get("genero");
                    String passwordVendedor = (String) objeto.get("password");
                    Vendedor n = new Vendedor(codigoVendedor, nombreVendedor, cajaVendedor, ventasVendedor, generoVendedor, passwordVendedor);
                    GuardarObjetos.guardarVendedor[i] = n;

                    System.out.println("codigo: " + GuardarObjetos.guardarVendedor[i].getVendedorCodigo());
                    System.out.println("nombre: " + GuardarObjetos.guardarVendedor[i].getVendedorNombre());
                    System.out.println("caja: " + GuardarObjetos.guardarVendedor[i].getVendedorCaja());
                    System.out.println("ventas: " + GuardarObjetos.guardarVendedor[i].getVendedorVentas());
                    System.out.println("genero: " + GuardarObjetos.guardarVendedor[i].getVendedorGenero());
                    System.out.println("password: " + GuardarObjetos.guardarVendedor[i].getVendedorPassword());

                }
            } while (cont <= 20);

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            //manejo de error
        } catch (ParseException e) {
            //manejo de error
        }

    }

    private void vendedores_PDF() {
//        try{
        JFileChooser guardar = new JFileChooser();
        int opcion = guardar.showSaveDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION) {
//                guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            File arch = guardar.getSelectedFile();
            try (FileWriter escrib = new FileWriter(arch)) {
                escrib.write("hola");// para escribir dentro del archivo
            } catch (IOException el) {
                el.printStackTrace();
            }
//            String pathR = arch.getAbsolutePath(); //obtiene la ruta del archivo seleccionado
//            File rut= guardar.getCurrentDirectory();
        }
//                guardar.setFileFilter(new FileNameExtensionFilter("Listado Vendedores","pdf"));

//            String nombredoc= guardar.getSelectedFile().getName();
        // TODO LO DEL PDF
//            PDDocument rep = new PDDocument();
//            PDPage pag = new PDPage(PDRectangle.A4);
//            
//            rep.addPage(pag);
//            PDPageContentStream conte = new PDPageContentStream(rep,pag);
//            for(int i=1; i<=5;i++){
//            conte.beginText();
//            conte.setFont(PDType1Font.HELVETICA_BOLD,15);
//            conte.newLineAtOffset(25,pag.getMediaBox().getHeight()-(45-i)); 
//            conte.showText("Hola Mu "+i); //agrega la linea de texto y se separa las lineas para que no se sobreescriba
//            conte.endText();
//            }
//            
//            conte.close();
//            rep.save(rut);
//        }catch(Exception x){
//            
//            System.out.println("Error:"+ x.getMessage().toString());
//        }
    }

    // ########################## Tablas ###############################################
    private void colocarTabla_Sucursales() {
        modelo_tabSucursal.addColumn("Código");
        modelo_tabSucursal.addColumn("Nombre");
        modelo_tabSucursal.addColumn("Dirección");
        modelo_tabSucursal.addColumn("Correo");
        modelo_tabSucursal.addColumn("Teléfono");
        tab_Sucursal = new JTable(modelo_tabSucursal);
        JScrollPane scr = new JScrollPane(tab_Sucursal);
        scr.setBounds(25, 20, 400, 650);
        panel1.add(scr);
    }

    private void colocarTabla_Productos() {
        modelo_tabProducto.addColumn("Código");
        modelo_tabProducto.addColumn("Nombre");
        modelo_tabProducto.addColumn("Descripción");
        modelo_tabProducto.addColumn("Cantidad");
        modelo_tabProducto.addColumn("Precio");
        tab_Productos = new JTable(modelo_tabProducto);
        JScrollPane scr = new JScrollPane(tab_Productos);
        scr.setBounds(25, 20, 400, 650);
        panel2.add(scr);
    }

    private void colocarTabla_Clientes() {
        modelo_tabCliente.addColumn("Código");
        modelo_tabCliente.addColumn("Nombre");
        modelo_tabCliente.addColumn("NIT");
        modelo_tabCliente.addColumn("Correo");
        modelo_tabCliente.addColumn("Género");
        tab_Clientes = new JTable(modelo_tabCliente);
        JScrollPane scr = new JScrollPane(tab_Clientes);
        scr.setBounds(25, 20, 400, 650);
        panel3.add(scr);
    }

    private void colocarTabla_Vendedores() {
        modelo_tabVende.addColumn("Código");
        modelo_tabVende.addColumn("Nombre");
        modelo_tabVende.addColumn("Caja");
        modelo_tabVende.addColumn("Ventas");
        modelo_tabVende.addColumn("Género");
        tab_Vendedores = new JTable(modelo_tabVende);
        JScrollPane scr = new JScrollPane(tab_Vendedores);
        scr.setBounds(25, 20, 400, 650);
        panel4.add(scr);

    }

    // ########################## Graficos ###############################################
    private void colocarGrafico_Productos() {

    }

    private void colocarGrafico_Clientes() {

    }

    private void colocarGrafico_Vendedores() {

    }
}
