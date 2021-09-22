package proyecto_1;

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
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
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
            try {
                sucursales_CargaMasiva();
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
                            GuardarObjetos.guardarSucursales[i] = new Sucursal(0, null, null, null, null);
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
            try {
                sucursales_PDF();
            } catch (DocumentException ex) {
                Logger.getLogger(Modulo_Administracion.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            try {
                productos_CargaMasiva();
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
                            GuardarObjetos.guardarProductos[i] = new Producto(0, null, null, 0, 0);
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
            try {
                productos_PDF();
            } catch (DocumentException ex) {
                Logger.getLogger(Modulo_Administracion.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            try {
                clientes_CargaMasiva();
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
                            GuardarObjetos.guardarCliente[i] = new Cliente(0, null, 0, null, null);
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
            try {
                clientes_PDF();
            } catch (DocumentException ex) {
                Logger.getLogger(Modulo_Administracion.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            try {
                vendedores_PDF();
            } catch (DocumentException ex) {
                Logger.getLogger(Modulo_Administracion.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    private void sucursales_CargaMasiva() throws FileNotFoundException, IOException, ParseException {
        JFileChooser seleccionArchivo = new JFileChooser();
        seleccionArchivo.showOpenDialog(panel1);
        File arch = seleccionArchivo.getSelectedFile();
        String nombreArchivo = seleccionArchivo.getName(arch);
        String pathR = arch.getAbsolutePath(); //obtiene la ruta del archivo seleccionado
        JSONParser prser = new JSONParser();
        try {
            JSONArray arregl = (JSONArray) prser.parse(new FileReader(pathR));
            int contadorFor = 0;
            for (Object objeto : arregl) {
                if (contadorFor < GuardarObjetos.guardarSucursales.length) {
                    JSONObject objeto1 = (JSONObject) objeto; // se obtienen los datos dentro del objeto que estan dentro del arreglo y dentro del json
//                Envio de datos al objeto vendedor
//                enviando dato codigo al arreglo del vendedor
                    int cod = Integer.parseInt(objeto1.get("codigo").toString());
                    String nombreObjeto = objeto1.get("nombre").toString(); // convierte el objeto a string 
                    //enviando dato caja al arreglo del vendedor
                    String direccionObjeto = objeto1.get("direccion").toString();
                    //enviando dato ventas al arreglo del vendedor
                    String correoObjeto = objeto1.get("correo").toString();
                    //enviando dato genero al arreglo del vendedor
                    String telefonoObjeto = objeto1.get("telefono").toString();
//                
                    GuardarObjetos.guardarSucursales[contadorFor] = new Sucursal(cod, nombreObjeto, direccionObjeto, correoObjeto, telefonoObjeto);
                    contadorFor = contadorFor + 1;
                } else {
                    break;
                }
            }
            ordenamiento_burbujaSucursales();
//            agregando datos a la tabla
            try {
                for (int indiceL = 0; indiceL < GuardarObjetos.guardarSucursales.length; indiceL++) {
                    if (GuardarObjetos.guardarSucursales[indiceL] != null) {
                        almacenaSucursal[indiceL][0] = Integer.toString(GuardarObjetos.guardarSucursales[indiceL].getSucursalCodigo());
                        almacenaSucursal[indiceL][1] = GuardarObjetos.guardarSucursales[indiceL].getSucursalNombre();
                        almacenaSucursal[indiceL][2] = GuardarObjetos.guardarSucursales[indiceL].getSucursalDireccion();
                        almacenaSucursal[indiceL][3] = GuardarObjetos.guardarSucursales[indiceL].getSucursalCorreo();
                        almacenaSucursal[indiceL][4] = GuardarObjetos.guardarSucursales[indiceL].getSucursalTelefono();
                        modelo_tabSucursal.addRow(almacenaSucursal[indiceL]);
                    } else if (GuardarObjetos.guardarSucursales[indiceL] == null) {

                        break;
                    }

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            //hasta aqui si funciona

        } catch (FileNotFoundException e) {
            System.out.println("" + e);
        } catch (IOException e) {
            System.out.println("" + e);
        }
        //manejo de error

    }

    private void sucursales_PDF() throws DocumentException {
        try {
            Document docu1;
            FileOutputStream arch1 = new FileOutputStream("Listado sucursales" + ".pdf");
            Paragraph tit1 = new Paragraph("Listado Sucursales");
            docu1 = new Document();
            PdfWriter.getInstance((com.itextpdf.text.Document) docu1, arch1);
            docu1.open();
            tit1.setAlignment(1);
            docu1.add(tit1);
            docu1.add(Chunk.NEWLINE);
            Paragraph texto = new Paragraph("Los datos de las sucursales son las siguientes:");//aqui dentro va todo lo que lleve el documento

            texto.setAlignment(Element.ALIGN_JUSTIFIED);
            docu1.add(texto);
            docu1.add(Chunk.NEWLINE);
            PdfPTable tab1 = new PdfPTable(5);
            tab1.setWidthPercentage(100);
            PdfPCell cod2 = new PdfPCell(new Phrase("Codigo"));
            cod2.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell name2 = new PdfPCell(new Phrase("Nombre"));
            name2.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell direccion = new PdfPCell(new Phrase("Dirección"));
            direccion.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell correo = new PdfPCell(new Phrase("Correo"));
            correo.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell telefono = new PdfPCell(new Phrase("Telefono"));
            telefono.setBackgroundColor(BaseColor.ORANGE);
            tab1.addCell(cod2);
            tab1.addCell(name2);
            tab1.addCell(direccion);
            tab1.addCell(correo);
            tab1.addCell(telefono);
            ordenamiento_burbujaSucursales();
            for (int i = 0; i < GuardarObjetos.guardarSucursales.length; i++) {
                if (GuardarObjetos.guardarSucursales[i] != null) {
                    String tempCodigo2 = Integer.toString(GuardarObjetos.guardarSucursales[i].getSucursalCodigo());
                    tab1.addCell(tempCodigo2);
                    String tempNombre2 = GuardarObjetos.guardarSucursales[i].getSucursalNombre();
                    tab1.addCell(tempNombre2);
                    String tempDireccion = GuardarObjetos.guardarSucursales[i].getSucursalDireccion();
                    tab1.addCell(tempDireccion);
                    String tempCorreo = GuardarObjetos.guardarSucursales[i].getSucursalCorreo();
                    tab1.addCell(tempCorreo);
                    String tempTelefono = GuardarObjetos.guardarSucursales[i].getSucursalTelefono();
                    tab1.addCell(tempTelefono);
                } else if (GuardarObjetos.guardarSucursales[i] == null) {
                    break;
                }
            }

            docu1.add(tab1);
            docu1.add(Chunk.NEWLINE);

//            Para manejar la fecha es 
            LocalDate fecha1 = LocalDate.now();
            String fech1 = fecha1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Paragraph texto2 = new Paragraph(fech1);//aqui dentro va la fecha 
            texto2.setAlignment(Element.ALIGN_JUSTIFIED);
            docu1.add(texto2);
            docu1.close();
            JOptionPane.showMessageDialog(null, "El archivo PDF se creó correctamente");
            //abre archivo automaticamente
            try {
                File enlace1 = new File("Listado sucursales" + ".pdf");
                Desktop.getDesktop().open(enlace1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex, "Alerta", 2);
            }

        } catch (FileNotFoundException e) {

        } catch (DocumentException e) {

        }

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

    private void productos_CargaMasiva() throws FileNotFoundException, IOException, ParseException {
        JFileChooser seleccionArchivo = new JFileChooser();
        seleccionArchivo.showOpenDialog(panel2);
        File arch = seleccionArchivo.getSelectedFile();
        String nombreArchivo = seleccionArchivo.getName(arch);
        String pathR = arch.getAbsolutePath(); //obtiene la ruta del archivo seleccionado
        JSONParser prser = new JSONParser();
        try {
            JSONArray arregl = (JSONArray) prser.parse(new FileReader(pathR));
            int contadorFor = 0;
            for (Object objeto : arregl) {
                if (contadorFor < GuardarObjetos.guardarProductos.length) {
                    JSONObject objeto1 = (JSONObject) objeto; // se obtienen los datos dentro del objeto que estan dentro del arreglo y dentro del json
//                Envio de datos al objeto vendedor
//                enviando dato codigo al arreglo del vendedor
                    int cod = Integer.parseInt(objeto1.get("codigo").toString());
                    String nombreObjeto = objeto1.get("nombre").toString(); // convierte el objeto a string 
                    //enviando dato caja al arreglo del vendedor
                    String descripObjeto = objeto1.get("descripcion").toString();
                    //enviando dato ventas al arreglo del vendedor
                    int cantObjeto = Integer.parseInt(objeto1.get("cantidad").toString());
                    //enviando dato genero al arreglo del vendedor
                    float precioObjeto = Float.parseFloat(objeto1.get("precio").toString());
//                
                    GuardarObjetos.guardarProductos[contadorFor] = new Producto(cod, nombreObjeto, descripObjeto, cantObjeto, precioObjeto);
                    contadorFor = contadorFor + 1;
                } else {
                    break;
                }
            }
            ordenamiento_burbujaProductos();
//            agregando datos a la tabla
            try {
                for (int indiceL = 0; indiceL < GuardarObjetos.guardarProductos.length; indiceL++) {
                    if (GuardarObjetos.guardarProductos[indiceL] != null) {
                        almacenaProducto[indiceL][0] = Integer.toString(GuardarObjetos.guardarProductos[indiceL].getProductoCodigo());
                        almacenaProducto[indiceL][1] = GuardarObjetos.guardarProductos[indiceL].getProductoNombre();
                        almacenaProducto[indiceL][2] = GuardarObjetos.guardarProductos[indiceL].getProductoDescripcion();
                        almacenaProducto[indiceL][3] = Integer.toString(GuardarObjetos.guardarProductos[indiceL].getProductoCantidad());
                        almacenaProducto[indiceL][4] = Float.toString(GuardarObjetos.guardarProductos[indiceL].getProductoPrecio());
                        modelo_tabProducto.addRow(almacenaProducto[indiceL]);
                    } else if (GuardarObjetos.guardarProductos[indiceL] == null) {

                        break;
                    }

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            //hasta aqui si funciona

        } catch (FileNotFoundException e) {
            System.out.println("" + e);
        } catch (IOException e) {
            System.out.println("" + e);
        }
        //manejo de error

    }

    private void productos_PDF() throws DocumentException {
        try {
            Document docu1;
            FileOutputStream arch1 = new FileOutputStream("Listado productos" + ".pdf");
            Paragraph tit1 = new Paragraph("Listado Productos");
            docu1 = new Document();
            PdfWriter.getInstance((com.itextpdf.text.Document) docu1, arch1);
            docu1.open();
            tit1.setAlignment(1);
            docu1.add(tit1);
            docu1.add(Chunk.NEWLINE);
            Paragraph texto = new Paragraph("Los datos de los productos son los siguientes:");//aqui dentro va todo lo que lleve el documento

            texto.setAlignment(Element.ALIGN_JUSTIFIED);
            docu1.add(texto);
            docu1.add(Chunk.NEWLINE);
            PdfPTable tab1 = new PdfPTable(5);
            tab1.setWidthPercentage(100);
            PdfPCell cod2 = new PdfPCell(new Phrase("Codigo"));
            cod2.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell name2 = new PdfPCell(new Phrase("Nombre"));
            name2.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell descripcion = new PdfPCell(new Phrase("Descripción"));
            descripcion.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell cantidad = new PdfPCell(new Phrase("Cantidad"));
            cantidad.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell precio = new PdfPCell(new Phrase("Precio"));
            precio.setBackgroundColor(BaseColor.ORANGE);
            tab1.addCell(cod2);
            tab1.addCell(name2);
            tab1.addCell(descripcion);
            tab1.addCell(cantidad);
            tab1.addCell(precio);
            ordenamiento_burbujaProductos();
            for (int i = 0; i < GuardarObjetos.guardarProductos.length; i++) {
                if (GuardarObjetos.guardarProductos[i] != null) {
                    String tempCodigo2 = Integer.toString(GuardarObjetos.guardarProductos[i].getProductoCodigo());
                    tab1.addCell(tempCodigo2);
                    String tempNombre2 = GuardarObjetos.guardarProductos[i].getProductoNombre();
                    tab1.addCell(tempNombre2);
                    String tempDescripcion = GuardarObjetos.guardarProductos[i].getProductoDescripcion();
                    tab1.addCell(tempDescripcion);
                    String tempCantidad = Integer.toString(GuardarObjetos.guardarProductos[i].getProductoCantidad());
                    tab1.addCell(tempCantidad);
                    String tempPrecio = Float.toString(GuardarObjetos.guardarProductos[i].getProductoPrecio());
                    tab1.addCell(tempPrecio);
                } else if (GuardarObjetos.guardarProductos[i] == null) {
                    break;
                }
            }

            docu1.add(tab1);
            docu1.add(Chunk.NEWLINE);

//            Para manejar la fecha es 
            LocalDate fecha1 = LocalDate.now();
            String fech1 = fecha1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Paragraph texto2 = new Paragraph(fech1);//aqui dentro va la fecha 
            texto2.setAlignment(Element.ALIGN_JUSTIFIED);
            docu1.add(texto2);
            docu1.close();
            JOptionPane.showMessageDialog(null, "El archivo PDF se creó correctamente");
            //abre archivo automaticamente
            try {
                File enlace1 = new File("Listado productos" + ".pdf");
                Desktop.getDesktop().open(enlace1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex, "Alerta", 2);
            }

        } catch (FileNotFoundException e) {

        } catch (DocumentException e) {

        }

    }

    // ########################## Acciones de Botones Clientes ###############################################
    public void clientes_vCrear() {
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

    private void clientes_CargaMasiva() throws FileNotFoundException, IOException, ParseException {
        JFileChooser seleccionArchivo1 = new JFileChooser();
        seleccionArchivo1.showOpenDialog(panel3);
        File arch1 = seleccionArchivo1.getSelectedFile();
        String nombreArchivo = seleccionArchivo1.getName(arch1);
        String pathR1 = arch1.getAbsolutePath(); //obtiene la ruta del archivo seleccionado
        JSONParser prser1 = new JSONParser();
        try {
            JSONArray arregl1 = (JSONArray) prser1.parse(new FileReader(pathR1));
            int contadorFor = 0;
            for (Object objeto : arregl1) {
                if (contadorFor < GuardarObjetos.guardarCliente.length) {
                    JSONObject objeto1 = (JSONObject) objeto; // se obtienen los datos dentro del objeto que estan dentro del arreglo y dentro del json
//                Envio de datos al objeto vendedor
//                enviando dato codigo al arreglo del cliente
                    int cod = Integer.parseInt(objeto1.get("codigo").toString());
                    //enviando dato nombre al arreglo del cliente
                    String nombreObjeto = objeto1.get("nombre").toString(); // convierte el objeto a string 
                    //enviando dato caja al arreglo del cliente
                    int nitObjeto = Integer.parseInt(objeto1.get("nit").toString());
                    //enviando dato ventas al arreglo del cliente
                    String correoObjeto = objeto1.get("correo").toString();
                    //enviando dato genero al arreglo del cliente
                    String generoObjeto = objeto1.get("genero").toString();
//                
                    GuardarObjetos.guardarCliente[contadorFor] = new Cliente(cod, nombreObjeto, nitObjeto, correoObjeto, generoObjeto);
                    contadorFor = contadorFor + 1;
                } else {
                    break;
                }
            }
            ordenamiento_burbujaClientes();
//            agregando datos a la tabla
            try {
                for (int indiceL = 0; indiceL < GuardarObjetos.guardarCliente.length; indiceL++) {
                    if (GuardarObjetos.guardarCliente[indiceL] != null) {
                        almacenaCliente[indiceL][0] = Integer.toString(GuardarObjetos.guardarCliente[indiceL].getClienteCodigo());
                        almacenaCliente[indiceL][1] = GuardarObjetos.guardarCliente[indiceL].getClienteNombre();
                        almacenaCliente[indiceL][2] = Integer.toString(GuardarObjetos.guardarCliente[indiceL].getClienteNit());
                        almacenaCliente[indiceL][3] = GuardarObjetos.guardarCliente[indiceL].getClienteCorreo();
                        almacenaCliente[indiceL][4] = GuardarObjetos.guardarCliente[indiceL].getClienteGenero();
                        modelo_tabCliente.addRow(almacenaCliente[indiceL]);
                    } else if (GuardarObjetos.guardarCliente[indiceL] == null) {

                        break;
                    }

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            //hasta aqui si funciona

        } catch (FileNotFoundException e) {
            System.out.println("" + e);
        } catch (IOException e) {
            System.out.println("" + e);
        }
        //manejo de error

    }

    private void clientes_PDF() throws DocumentException {
        try {
            Document docu1;
            FileOutputStream arch1 = new FileOutputStream("Listado clientes" + ".pdf");
            Paragraph tit1 = new Paragraph("Listado Clientes");
            docu1 = new Document();
            PdfWriter.getInstance((com.itextpdf.text.Document) docu1, arch1);
            docu1.open();
            tit1.setAlignment(1);
            docu1.add(tit1);
            docu1.add(Chunk.NEWLINE);
            Paragraph texto = new Paragraph("Los datos de los clientes son los siguientes:");//aqui dentro va todo lo que lleve el documento

            texto.setAlignment(Element.ALIGN_JUSTIFIED);
            docu1.add(texto);
            docu1.add(Chunk.NEWLINE);
            PdfPTable tab1 = new PdfPTable(5);
            tab1.setWidthPercentage(100);
            PdfPCell cod1 = new PdfPCell(new Phrase("Codigo"));
            cod1.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell name1 = new PdfPCell(new Phrase("Nombre"));
            name1.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell nit = new PdfPCell(new Phrase("NIT"));
            nit.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell correo = new PdfPCell(new Phrase("Correo"));
            correo.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell gen1 = new PdfPCell(new Phrase("Genero"));
            gen1.setBackgroundColor(BaseColor.ORANGE);
            tab1.addCell(cod1);
            tab1.addCell(name1);
            tab1.addCell(nit);
            tab1.addCell(correo);
            tab1.addCell(gen1);
            ordenamiento_burbujaClientes();
            for (int i = 0; i < GuardarObjetos.guardarCliente.length; i++) {
                if (GuardarObjetos.guardarCliente[i] != null) {
                    String tempCodigo1 = Integer.toString(GuardarObjetos.guardarCliente[i].getClienteCodigo());
                    tab1.addCell(tempCodigo1);
                    String tempNombre1 = GuardarObjetos.guardarCliente[i].getClienteNombre();
                    tab1.addCell(tempNombre1);
                    String tempNit = Integer.toString(GuardarObjetos.guardarCliente[i].getClienteNit());
                    tab1.addCell(tempNit);
                    String tempCorreo = GuardarObjetos.guardarCliente[i].getClienteCorreo();
                    tab1.addCell(tempCorreo);
                    String tempGenero1 = GuardarObjetos.guardarCliente[i].getClienteGenero();
                    tab1.addCell(tempGenero1);
                } else if (GuardarObjetos.guardarVendedor[i] == null) {
                    break;
                }
            }

            docu1.add(tab1);
            docu1.add(Chunk.NEWLINE);

//            Para manejar la fecha es 
            LocalDate fecha1 = LocalDate.now();
            String fech1 = fecha1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Paragraph texto2 = new Paragraph(fech1);//aqui dentro va la fecha 
            texto2.setAlignment(Element.ALIGN_JUSTIFIED);
            docu1.add(texto2);
            docu1.close();
            JOptionPane.showMessageDialog(null, "El archivo PDF se creó correctamente");
            //abre archivo automaticamente
            try {
                File enlace1 = new File("Listado clientes" + ".pdf");
                Desktop.getDesktop().open(enlace1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex, "Alerta", 2);
            }

        } catch (FileNotFoundException e) {

        } catch (DocumentException e) {

        }

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
        JFileChooser seleccionArchivo = new JFileChooser();
        seleccionArchivo.showOpenDialog(panel4);
        File arch = seleccionArchivo.getSelectedFile();
        String nombreArchivo = seleccionArchivo.getName(arch);
        String pathR = arch.getAbsolutePath(); //obtiene la ruta del archivo seleccionado
//        System.out.println("ruta: " + pathR + "\n" + nombreArchivo);
        JSONParser prser = new JSONParser();
        try {
            JSONArray arregl = (JSONArray) prser.parse(new FileReader(pathR));
            int contadorFor = 0;
            for (Object objeto : arregl) {
                if (contadorFor < GuardarObjetos.guardarVendedor.length) {
                    JSONObject objeto1 = (JSONObject) objeto; // se obtienen los datos dentro del objeto que estan dentro del arreglo y dentro del json
//                Envio de datos al objeto vendedor
//                enviando dato codigo al arreglo del vendedor
                    int cod = Integer.parseInt(objeto1.get("codigo").toString());
                    String nombreObjeto = objeto1.get("nombre").toString(); // convierte el objeto a string 
                    //enviando dato caja al arreglo del vendedor
                    int caj = Integer.parseInt(objeto1.get("caja").toString());
//                GuardarObjetos.guardarVendedor[contadorFor].setVendedorCaja(caj);
                    //enviando dato ventas al arreglo del vendedor
                    int ve = Integer.parseInt(objeto1.get("ventas").toString());
//                GuardarObjetos.guardarVendedor[contadorFor].setVendedorVentas(ve);
                    //enviando dato genero al arreglo del vendedor
                    String generoObjeto = objeto1.get("genero").toString();
//                GuardarObjetos.guardarVendedor[contadorFor].setVendedorGenero(generoObjeto);
                    //enviando dato password al arreglo del vendedor
                    String passwordObjeto = objeto1.get("password").toString();
//                
                    GuardarObjetos.guardarVendedor[contadorFor] = new Vendedor(cod, nombreObjeto, caj, ve, generoObjeto, passwordObjeto);
                    contadorFor = contadorFor + 1;
                } else {
                    break;
                }
            }
            ordenamiento_burbujaVendedores();
//            agregando datos a la tabla
            try {
                for (int indiceL = 0; indiceL < GuardarObjetos.guardarVendedor.length; indiceL++) {
                    if (GuardarObjetos.guardarVendedor[indiceL] != null) {
                        almacenaVendedor[indiceL][0] = Integer.toString(GuardarObjetos.guardarVendedor[indiceL].getVendedorCodigo());
                        almacenaVendedor[indiceL][1] = GuardarObjetos.guardarVendedor[indiceL].getVendedorNombre();
                        almacenaVendedor[indiceL][2] = Integer.toString(GuardarObjetos.guardarVendedor[indiceL].getVendedorCaja());
                        almacenaVendedor[indiceL][3] = Integer.toString(GuardarObjetos.guardarVendedor[indiceL].getVendedorVentas());
                        almacenaVendedor[indiceL][4] = GuardarObjetos.guardarVendedor[indiceL].getVendedorGenero();
                        modelo_tabVende.addRow(almacenaVendedor[indiceL]);
                    } else if (GuardarObjetos.guardarVendedor[indiceL] == null) {

                        break;
                    }

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            //hasta aqui si funciona

        } catch (FileNotFoundException e) {
            System.out.println("" + e);
        } catch (IOException e) {
            System.out.println("" + e);
        }
        //manejo de error

    }

    private void vendedores_PDF() throws DocumentException {
        try {
            Document docu;
            FileOutputStream arch = new FileOutputStream("Listado vendedores" + ".pdf");
            Paragraph tit = new Paragraph("Listado Vendedores");
            docu = new Document();
            PdfWriter.getInstance((com.itextpdf.text.Document) docu, arch);
            docu.open();
            tit.setAlignment(1);
            docu.add(tit);
            docu.add(Chunk.NEWLINE);
            Paragraph texto = new Paragraph("Los datos de los vendedores son los siguientes:");//aqui dentro va todo lo que lleve el documento

            texto.setAlignment(Element.ALIGN_JUSTIFIED);
            docu.add(texto);
            docu.add(Chunk.NEWLINE);
            PdfPTable tab = new PdfPTable(6);
            tab.setWidthPercentage(100);
            PdfPCell cod = new PdfPCell(new Phrase("Codigo"));
            cod.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell name = new PdfPCell(new Phrase("Nombre"));
            name.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell caj = new PdfPCell(new Phrase("Caja"));
            caj.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell vent = new PdfPCell(new Phrase("Ventas"));
            vent.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell gen = new PdfPCell(new Phrase("Genero"));
            gen.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell pas = new PdfPCell(new Phrase("Password"));
            pas.setBackgroundColor(BaseColor.ORANGE);
            tab.addCell(cod);
            tab.addCell(name);
            tab.addCell(caj);
            tab.addCell(vent);
            tab.addCell(gen);
            tab.addCell(pas);
            ordenamiento_burbujaVendedores();
            for (int i = 0; i < GuardarObjetos.guardarVendedor.length; i++) {
                if (GuardarObjetos.guardarVendedor[i] != null) {
                    String tempCodigo = Integer.toString(GuardarObjetos.guardarVendedor[i].getVendedorCodigo());
                    tab.addCell(tempCodigo);
                    String tempNombre = GuardarObjetos.guardarVendedor[i].getVendedorNombre();
                    tab.addCell(tempNombre);
                    String tempCaja = Integer.toString(GuardarObjetos.guardarVendedor[i].getVendedorCaja());
                    tab.addCell(tempCaja);
                    String tempVenta = Integer.toString(GuardarObjetos.guardarVendedor[i].getVendedorVentas());
                    tab.addCell(tempVenta);
                    String tempGenero = GuardarObjetos.guardarVendedor[i].getVendedorGenero();
                    tab.addCell(tempGenero);
                    String tempPassword = GuardarObjetos.guardarVendedor[i].getVendedorPassword();
                    tab.addCell(tempPassword);
                } else if (GuardarObjetos.guardarVendedor[i] == null) {
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
                File enlace = new File("Listado vendedores" + ".pdf");
                Desktop.getDesktop().open(enlace);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex, "Alerta", 2);
            }

        } catch (FileNotFoundException e) {

        } catch (DocumentException e) {

        }

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
        ordenamiento_burbujaSucursales();
        try {
            for (int indiceL = 0; indiceL < GuardarObjetos.guardarSucursales.length; indiceL++) {
                if (GuardarObjetos.guardarSucursales[indiceL] != null) {
                    almacenaSucursal[indiceL][0] = Integer.toString(GuardarObjetos.guardarSucursales[indiceL].getSucursalCodigo());
                    almacenaSucursal[indiceL][1] = GuardarObjetos.guardarSucursales[indiceL].getSucursalNombre();
                    almacenaSucursal[indiceL][2] = GuardarObjetos.guardarSucursales[indiceL].getSucursalDireccion();
                    almacenaSucursal[indiceL][3] = GuardarObjetos.guardarSucursales[indiceL].getSucursalCorreo();
                    almacenaSucursal[indiceL][4] = GuardarObjetos.guardarSucursales[indiceL].getSucursalTelefono();
                    modelo_tabSucursal.addRow(almacenaSucursal[indiceL]);
                } else if (GuardarObjetos.guardarSucursales[indiceL] == null) {

                    break;
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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
        ordenamiento_burbujaProductos();
        try {
            for (int indiceL = 0; indiceL < GuardarObjetos.guardarProductos.length; indiceL++) {
                if (GuardarObjetos.guardarProductos[indiceL] != null) {
                    almacenaProducto[indiceL][0] = Integer.toString(GuardarObjetos.guardarProductos[indiceL].getProductoCodigo());
                    almacenaProducto[indiceL][1] = GuardarObjetos.guardarProductos[indiceL].getProductoNombre();
                    almacenaProducto[indiceL][2] = GuardarObjetos.guardarProductos[indiceL].getProductoDescripcion();
                    almacenaProducto[indiceL][3] = Integer.toString(GuardarObjetos.guardarProductos[indiceL].getProductoCantidad());
                    almacenaProducto[indiceL][4] = Float.toString(GuardarObjetos.guardarProductos[indiceL].getProductoPrecio());
                    modelo_tabProducto.addRow(almacenaProducto[indiceL]);
                } else if (GuardarObjetos.guardarProductos[indiceL] == null) {

                    break;
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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
        ordenamiento_burbujaClientes();
        try {
            for (int indiceL = 0; indiceL < GuardarObjetos.guardarCliente.length; indiceL++) {
                if (GuardarObjetos.guardarCliente[indiceL] != null) {
                    almacenaCliente[indiceL][0] = Integer.toString(GuardarObjetos.guardarCliente[indiceL].getClienteCodigo());
                    almacenaCliente[indiceL][1] = GuardarObjetos.guardarCliente[indiceL].getClienteNombre();
                    almacenaCliente[indiceL][2] = Integer.toString(GuardarObjetos.guardarCliente[indiceL].getClienteNit());
                    almacenaCliente[indiceL][3] = GuardarObjetos.guardarCliente[indiceL].getClienteCorreo();
                    almacenaCliente[indiceL][4] = GuardarObjetos.guardarCliente[indiceL].getClienteGenero();
                    modelo_tabCliente.addRow(almacenaCliente[indiceL]);
                } else if (GuardarObjetos.guardarCliente[indiceL] == null) {

                    break;
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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
        ordenamiento_burbujaVendedores();
        try {
            for (int indiceL = 0; indiceL < GuardarObjetos.guardarVendedor.length; indiceL++) {
                if (GuardarObjetos.guardarVendedor[indiceL] != null) {
                    almacenaVendedor[indiceL][0] = Integer.toString(GuardarObjetos.guardarVendedor[indiceL].getVendedorCodigo());
                    almacenaVendedor[indiceL][1] = GuardarObjetos.guardarVendedor[indiceL].getVendedorNombre();
                    almacenaVendedor[indiceL][2] = Integer.toString(GuardarObjetos.guardarVendedor[indiceL].getVendedorCaja());
                    almacenaVendedor[indiceL][3] = Integer.toString(GuardarObjetos.guardarVendedor[indiceL].getVendedorVentas());
                    almacenaVendedor[indiceL][4] = GuardarObjetos.guardarVendedor[indiceL].getVendedorGenero();
                    modelo_tabVende.addRow(almacenaVendedor[indiceL]);
                } else if (GuardarObjetos.guardarVendedor[indiceL] == null) {

                    break;
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // ########################## Graficos ###############################################
    private void colocarGrafico_Productos() {
        //pasando datos del objeto al arreglo para obtener todos los valores 
        String auxiliarGuardarN [] = new String[GuardarObjetos.guardarProductos.length];
        int auxiliarGuardarC [] = new int[GuardarObjetos.guardarProductos.length];
        for (int i = 0; i < GuardarObjetos.guardarProductos.length; i++) {
            if (GuardarObjetos.guardarProductos[i] != null) {
                auxiliarGuardarN [i]= GuardarObjetos.guardarProductos[i].getProductoNombre();
                auxiliarGuardarC [i] = GuardarObjetos.guardarProductos[i].getProductoCantidad();
            }
        }
        
        //se realiza el ordenamiento utilizando los arreglos
        String auxiliar_productoNom;
        int auxiliar_productoCant;
        for (int i = 0; i < auxiliarGuardarC.length; i++) {
            for (int j = 0; j < auxiliarGuardarC.length; j++) {
                if ((GuardarObjetos.guardarProductos[j] != null) && (GuardarObjetos.guardarProductos[j + 1] != null)) {
                    if ((auxiliarGuardarC [j] > auxiliarGuardarC [j+1])) {
                        //cambiando nombre
                        auxiliar_productoNom = auxiliarGuardarN [j];
                        auxiliarGuardarN [j]=auxiliarGuardarN [j+1];
                        auxiliarGuardarN [j+1]=auxiliar_productoNom;
                        //cambiando cantidad
                        auxiliar_productoCant = auxiliarGuardarC [j];
                        auxiliarGuardarC [j]=auxiliarGuardarC [j+1];
                        auxiliarGuardarC [j+1]=auxiliar_productoCant;
                    }

                }
            }
        }
        //obteniendo los datos para ingresarlos en la grafica
        for (int j = auxiliarGuardarC.length; j > auxiliarGuardarC.length; j--) {
                if ((GuardarObjetos.guardarProductos[j] != null) && (GuardarObjetos.guardarProductos[j + 1] != null)) {
                    

                }
            }
       //Grafica de barras
       DefaultCategoryDataset barras_producto = new DefaultCategoryDataset();
       barras_producto.setValue(5, "nombredel producto 1", "nombredel producto 1");
       barras_producto.setValue(6, "nombredel producto 2", "nombredel producto 2");
       barras_producto.setValue(7, "nombredel producto 3", "nombredel producto 3");
       
       JFreeChart barraP = ChartFactory.createBarChart("Top 3 - Productos con más disponibilidad", "Productos", "Cantidad", barras_producto, PlotOrientation.VERTICAL, true, true, false);
       ChartPanel panelBarras = new ChartPanel(barraP);
       panelBarras.setBounds(450, 270, 280, 400);
       panel2.add(panelBarras);
       //Esto funciona solo se debe validar para que haga los top 3 y que funcione solo cuando esté lleno el arreglo
    }

    private void colocarGrafico_Clientes() {

    }

    private void colocarGrafico_Vendedores() {

    }
    // ########################## Ordenamiento Burbuja ###############################################
    private void ordenamiento_burbujaVendedores() {
        int auxiliar_vendedorCodigo;
        String auxiliar_vendedorNombre;
        int auxiliar_vendedorCaja;
        int auxiliar_vendedorVentas;
        String auxiliar_vendedorGenero;
        String auxiliar_vendedorPassword;
        for (int i = 0; i < GuardarObjetos.guardarVendedor.length; i++) {
            for (int j = 0; j < GuardarObjetos.guardarVendedor.length; j++) {
                if ((GuardarObjetos.guardarVendedor[j] != null) && (GuardarObjetos.guardarVendedor[j + 1] != null)) {
                    if ((GuardarObjetos.guardarVendedor[j].getVendedorCodigo() > GuardarObjetos.guardarVendedor[j + 1].getVendedorCodigo())) {
                        //cambiando codigo
                        auxiliar_vendedorCodigo = GuardarObjetos.guardarVendedor[j].getVendedorCodigo();
                        GuardarObjetos.guardarVendedor[j].setVendedorCodigo(GuardarObjetos.guardarVendedor[j + 1].getVendedorCodigo());
                        GuardarObjetos.guardarVendedor[j + 1].setVendedorCodigo(auxiliar_vendedorCodigo);
                        //cambiando nombre
                        auxiliar_vendedorNombre = GuardarObjetos.guardarVendedor[j].getVendedorNombre();
                        GuardarObjetos.guardarVendedor[j].setVendedorNombre(GuardarObjetos.guardarVendedor[j + 1].getVendedorNombre());
                        GuardarObjetos.guardarVendedor[j + 1].setVendedorNombre(auxiliar_vendedorNombre);
                        //cambiando caja
                        auxiliar_vendedorCaja = GuardarObjetos.guardarVendedor[j].getVendedorCaja();
                        GuardarObjetos.guardarVendedor[j].setVendedorCaja(GuardarObjetos.guardarVendedor[j + 1].getVendedorCaja());
                        GuardarObjetos.guardarVendedor[j + 1].setVendedorCaja(auxiliar_vendedorCaja);
                        //cambiando ventas
                        auxiliar_vendedorVentas = GuardarObjetos.guardarVendedor[j].getVendedorVentas();
                        GuardarObjetos.guardarVendedor[j].setVendedorVentas(GuardarObjetos.guardarVendedor[j + 1].getVendedorVentas());
                        GuardarObjetos.guardarVendedor[j + 1].setVendedorVentas(auxiliar_vendedorVentas);
                        //cambiando genero
                        auxiliar_vendedorGenero = GuardarObjetos.guardarVendedor[j].getVendedorGenero();
                        GuardarObjetos.guardarVendedor[j].setVendedorGenero(GuardarObjetos.guardarVendedor[j + 1].getVendedorGenero());
                        GuardarObjetos.guardarVendedor[j + 1].setVendedorGenero(auxiliar_vendedorGenero);
                        //cambiando password
                        auxiliar_vendedorPassword = GuardarObjetos.guardarVendedor[j].getVendedorPassword();
                        GuardarObjetos.guardarVendedor[j].setVendedorPassword(GuardarObjetos.guardarVendedor[j + 1].getVendedorPassword());
                        GuardarObjetos.guardarVendedor[j + 1].setVendedorPassword(auxiliar_vendedorPassword);
                    }

                }
            }
        }
    }

    private void ordenamiento_burbujaClientes() {
        int auxiliar_clienteCodigo;
        String auxiliar_clienteNombre;
        int auxiliar_clienteNit;
        String auxiliar_clienteCorreo;
        String auxiliar_clienteGenero;
        for (int i = 0; i < GuardarObjetos.guardarCliente.length; i++) {
            for (int j = 0; j < GuardarObjetos.guardarCliente.length; j++) {
                if ((GuardarObjetos.guardarCliente[j] != null) && (GuardarObjetos.guardarCliente[j + 1] != null)) {
                    if ((GuardarObjetos.guardarCliente[j].getClienteCodigo() > GuardarObjetos.guardarCliente[j + 1].getClienteCodigo())) {
                        //cambiando codigo
                        auxiliar_clienteCodigo = GuardarObjetos.guardarCliente[j].getClienteCodigo();
                        GuardarObjetos.guardarCliente[j].setClienteCodigo(GuardarObjetos.guardarCliente[j + 1].getClienteCodigo());
                        GuardarObjetos.guardarCliente[j + 1].setClienteCodigo(auxiliar_clienteCodigo);
                        //cambiando nombre
                        auxiliar_clienteNombre = GuardarObjetos.guardarCliente[j].getClienteNombre();
                        GuardarObjetos.guardarCliente[j].setClienteNombre(GuardarObjetos.guardarCliente[j + 1].getClienteNombre());
                        GuardarObjetos.guardarCliente[j + 1].setClienteNombre(auxiliar_clienteNombre);
                        //cambiando nit
                        auxiliar_clienteNit = GuardarObjetos.guardarCliente[j].getClienteNit();
                        GuardarObjetos.guardarCliente[j].setClienteNit(GuardarObjetos.guardarCliente[j + 1].getClienteNit());
                        GuardarObjetos.guardarCliente[j + 1].setClienteNit(auxiliar_clienteNit);
                        //cambiando correo
                        auxiliar_clienteCorreo = GuardarObjetos.guardarCliente[j].getClienteCorreo();
                        GuardarObjetos.guardarCliente[j].setClienteCorreo(GuardarObjetos.guardarCliente[j + 1].getClienteCorreo());
                        GuardarObjetos.guardarCliente[j + 1].setClienteCorreo(auxiliar_clienteCorreo);
                        //cambiando genero
                        auxiliar_clienteGenero = GuardarObjetos.guardarCliente[j].getClienteGenero();
                        GuardarObjetos.guardarCliente[j].setClienteGenero(GuardarObjetos.guardarCliente[j + 1].getClienteGenero());
                        GuardarObjetos.guardarCliente[j + 1].setClienteGenero(auxiliar_clienteGenero);
                    }

                }
            }
        }
    }

    private void ordenamiento_burbujaProductos() {
        int auxiliar_productoCodigo;
        String auxiliar_productoNombre;
        String auxiliar_productoDescripcion;
        int auxiliar_productoCantidad;
        float auxiliar_productoPrecio;
        for (int i = 0; i < GuardarObjetos.guardarProductos.length; i++) {
            for (int j = 0; j < GuardarObjetos.guardarProductos.length; j++) {
                if ((GuardarObjetos.guardarProductos[j] != null) && (GuardarObjetos.guardarProductos[j + 1] != null)) {
                    if ((GuardarObjetos.guardarProductos[j].getProductoCodigo() > GuardarObjetos.guardarProductos[j + 1].getProductoCodigo())) {
                        //cambiando codigo
                        auxiliar_productoCodigo = GuardarObjetos.guardarProductos[j].getProductoCodigo();
                        GuardarObjetos.guardarProductos[j].setProductoCodigo(GuardarObjetos.guardarProductos[j + 1].getProductoCodigo());
                        GuardarObjetos.guardarProductos[j + 1].setProductoCodigo(auxiliar_productoCodigo);
                        //cambiando nombre
                        auxiliar_productoNombre = GuardarObjetos.guardarProductos[j].getProductoNombre();
                        GuardarObjetos.guardarProductos[j].setProductoNombre(GuardarObjetos.guardarProductos[j + 1].getProductoNombre());
                        GuardarObjetos.guardarProductos[j + 1].setProductoNombre(auxiliar_productoNombre);
                        //cambiando descripcion
                        auxiliar_productoDescripcion = GuardarObjetos.guardarProductos[j].getProductoDescripcion();
                        GuardarObjetos.guardarProductos[j].setProductoDescripcion(GuardarObjetos.guardarProductos[j + 1].getProductoDescripcion());
                        GuardarObjetos.guardarProductos[j + 1].setProductoDescripcion(auxiliar_productoDescripcion);
                        //cambiando cantidad
                        auxiliar_productoCantidad = GuardarObjetos.guardarProductos[j].getProductoCantidad();
                        GuardarObjetos.guardarProductos[j].setProductoCantidad(GuardarObjetos.guardarProductos[j + 1].getProductoCantidad());
                        GuardarObjetos.guardarProductos[j + 1].setProductoCantidad(auxiliar_productoCantidad);
                        //cambiando precio
                        auxiliar_productoPrecio = GuardarObjetos.guardarProductos[j].getProductoPrecio();
                        GuardarObjetos.guardarProductos[j].setProductoPrecio(GuardarObjetos.guardarProductos[j + 1].getProductoPrecio());
                        GuardarObjetos.guardarProductos[j + 1].setProductoPrecio(auxiliar_productoPrecio);
                    }

                }
            }
        }
    }

    private void ordenamiento_burbujaSucursales() {
        int auxiliar_sucursalCodigo;
        String auxiliar_sucursalNombre;
        String auxiliar_sucursalDireccion;
        String auxiliar_sucursalCorreo;
        String auxiliar_sucursalTelefono;
        for (int i = 0; i < GuardarObjetos.guardarSucursales.length; i++) {
            for (int j = 0; j < GuardarObjetos.guardarSucursales.length; j++) {
                if ((GuardarObjetos.guardarSucursales[j] != null) && (GuardarObjetos.guardarSucursales[j + 1] != null)) {
                    if ((GuardarObjetos.guardarSucursales[j].getSucursalCodigo() > GuardarObjetos.guardarSucursales[j + 1].getSucursalCodigo())) {
                        //cambiando codigo
                        auxiliar_sucursalCodigo = GuardarObjetos.guardarSucursales[j].getSucursalCodigo();
                        GuardarObjetos.guardarSucursales[j].setSucursalCodigo(GuardarObjetos.guardarSucursales[j + 1].getSucursalCodigo());
                        GuardarObjetos.guardarSucursales[j + 1].setSucursalCodigo(auxiliar_sucursalCodigo);
                        //cambiando nombre
                        auxiliar_sucursalNombre = GuardarObjetos.guardarSucursales[j].getSucursalNombre();
                        GuardarObjetos.guardarSucursales[j].setSucursalNombre(GuardarObjetos.guardarSucursales[j + 1].getSucursalNombre());
                        GuardarObjetos.guardarSucursales[j + 1].setSucursalNombre(auxiliar_sucursalNombre);
                        //cambiando direccion
                        auxiliar_sucursalDireccion = GuardarObjetos.guardarSucursales[j].getSucursalDireccion();
                        GuardarObjetos.guardarSucursales[j].setSucursalDireccion(GuardarObjetos.guardarSucursales[j + 1].getSucursalDireccion());
                        GuardarObjetos.guardarSucursales[j + 1].setSucursalDireccion(auxiliar_sucursalDireccion);
                        //cambiando correo
                        auxiliar_sucursalCorreo = GuardarObjetos.guardarSucursales[j].getSucursalCorreo();
                        GuardarObjetos.guardarSucursales[j].setSucursalCorreo(GuardarObjetos.guardarSucursales[j + 1].getSucursalCorreo());
                        GuardarObjetos.guardarSucursales[j + 1].setSucursalCorreo(auxiliar_sucursalCorreo);
                        //cambiando telefono
                        auxiliar_sucursalTelefono = GuardarObjetos.guardarSucursales[j].getSucursalTelefono();
                        GuardarObjetos.guardarSucursales[j].setSucursalTelefono(GuardarObjetos.guardarSucursales[j + 1].getSucursalTelefono());
                        GuardarObjetos.guardarSucursales[j + 1].setSucursalTelefono(auxiliar_sucursalTelefono);
                    }

                }
            }
        }
    }
}
