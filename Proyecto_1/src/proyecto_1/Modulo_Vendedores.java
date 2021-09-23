package proyecto_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Modulo_Vendedores {

    private JFrame ventanaVende = new JFrame();
    private JPanel panel, panel1, panel2, panelSeleccionarC, panelAgregarP, panelListaG;
    private JTextField Text_codigo = new JTextField();
    private JTextField Text_contraseña = new JTextField();
    private JTabbedPane primeras_pestañas = new JTabbedPane();
    private int codigoVendedorRecib;
    private String nombreVendedorEncontrado;

    int contador_Product = 0;
    private DefaultTableModel modelo_agregarProd = new DefaultTableModel();
    String almProducto[][] = new String[GuardarObjetos.guardarProductos.length][5];
    float subTot[] = new float[contador_Product + 1];

    public void ventanaVendedores() {
        ventanaVende.setSize(800, 800);
        ventanaVende.setTitle("Modulo Vendedores");
        ventanaVende.setLocationRelativeTo(null);
        ventanaVende.setMinimumSize(new Dimension(200, 200));
        ventanaVende.setDefaultCloseOperation(EXIT_ON_CLOSE);    //Permite cerrar la pestaña
        ventanaVende.setResizable(false);
        ventanaVende.setVisible(true);
        iniciarComponentes();

    }

    public void recibirCodigoAutenticacion(int codigoVendedorRecib) { // recibe el codigo del vendedor y se almacena el nombre en una variable
        this.codigoVendedorRecib = codigoVendedorRecib;
        for (int i = 0; i < GuardarObjetos.guardarVendedor.length; i++) {
            if (this.codigoVendedorRecib == GuardarObjetos.guardarVendedor[i].getVendedorCodigo()) {
                nombreVendedorEncontrado = GuardarObjetos.guardarVendedor[i].getVendedorNombre();
                break;
            }
        }

        // buscando el nombre del vendedor de acuerdo al codigo recibido
        JLabel etiqueta_nom = new JLabel();
        etiqueta_nom.setText("¡Bienvenido " + nombreVendedorEncontrado + " !");
        etiqueta_nom.setBounds(350, 5, 300, 25);
        etiqueta_nom.setForeground(Color.WHITE);
        etiqueta_nom.setFont(new Font("arial", Font.ROMAN_BASELINE, 13));
        etiqueta_nom.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        panel.add(etiqueta_nom);

    }

    private void iniciarComponentes() {
        colocarPanel();
        colocarBotones();
        nuevaVenta_SeleccionarC();
        nuevaVenta_AgregarP();
        ventas_ListadoG();
    }

    private void colocarPanel() {
        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        ventanaVende.add(panel);

        //Nueva venta
        panel1 = new JPanel();
        panel1.setBackground(Color.ORANGE);
        panel1.setBounds(21, 21, 730, 730);
        panel1.setLayout(null);
        // Ventas
        panel2 = new JPanel();
        panel2.setBackground(Color.ORANGE);
        panel2.setBounds(21, 21, 730, 730);
        panel2.setLayout(null);

        primeras_pestañas.setBounds(20, 20, 750, 730);
        primeras_pestañas.addTab("Nueva Venta", panel.add(panel1));
        primeras_pestañas.addTab("Ventas", panel.add(panel2));
        panel.add(primeras_pestañas);

        //Nueva venta Seleccionar cliente
        panelSeleccionarC = new JPanel();
        panelSeleccionarC.setBackground(Color.WHITE);
        panelSeleccionarC.setBounds(30, 30, 685, 300);
        panelSeleccionarC.setLayout(null);
        panel1.add(panelSeleccionarC);
        // Nueva venta Agregar productos
        panelAgregarP = new JPanel();
        panelAgregarP.setBackground(Color.WHITE);
        panelAgregarP.setBounds(30, 350, 685, 300);
        panelAgregarP.setLayout(null);
        panel1.add(panelAgregarP);

        // Ventas listado general
        panelListaG = new JPanel();
        panelListaG.setBackground(Color.WHITE);
        panelListaG.setBounds(30, 30, 685, 640);
        panelListaG.setLayout(null);
        panel2.add(panelListaG);
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
            try {
                au.ventanaPrincipal();
            } catch (IOException ex) {
                Logger.getLogger(Modulo_Vendedores.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Modulo_Vendedores.class.getName()).log(Level.SEVERE, null, ex);
            }
            ventanaVende.dispose();
        };
        boton1.addActionListener(accion);

    }

    private void nuevaVenta_SeleccionarC() {
        //TITULO DEL PRIMER PANEL
        JLabel etiquetaTitulo = new JLabel();
        etiquetaTitulo.setText("Seleccionar Cliente");
        etiquetaTitulo.setBounds(0, 0, 200, 25);
        etiquetaTitulo.setForeground(Color.BLACK);
//      etiqueta.setOpaque(true);   //otorga permiso para poder darle color a la etiqueta
//        etiquetaTitulo.setBackground(Color.yellow); // cambia el color de la etiqueta
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        etiquetaTitulo.setFont(new Font("arial", Font.BOLD, 20));
        etiquetaTitulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelSeleccionarC.add(etiquetaTitulo);
        //Etiquetas subrayadas
        JLabel etiquetaSubrayado = new JLabel();
        etiquetaSubrayado.setText("Filtrar por:");
        Font sub = etiquetaSubrayado.getFont();
        Map atri = sub.getAttributes();
        atri.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        etiquetaSubrayado.setFont(sub.deriveFont(atri));
        etiquetaSubrayado.setBounds(25, 35, 100, 25);
        panelSeleccionarC.add(etiquetaSubrayado);

        JLabel etiquetaSubrayado1 = new JLabel();
        etiquetaSubrayado1.setText("Filtrados:");
        Font sub1 = etiquetaSubrayado1.getFont();
        Map atri1 = sub1.getAttributes();
        atri1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        etiquetaSubrayado1.setFont(sub.deriveFont(atri));
        etiquetaSubrayado1.setBounds(25, 185, 100, 25);
        panelSeleccionarC.add(etiquetaSubrayado1);

        //Etiquetas datos
        JLabel etiqueta_nom = new JLabel();
        etiqueta_nom.setText("Nombre:");
        etiqueta_nom.setBounds(120, 35, 50, 25);
        etiqueta_nom.setForeground(Color.BLACK);
        etiqueta_nom.setFont(new Font("arial", Font.ROMAN_BASELINE, 13));
        etiqueta_nom.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        panelSeleccionarC.add(etiqueta_nom);

        JLabel etiqueta_nit = new JLabel();
        etiqueta_nit.setText("NIT:");
        etiqueta_nit.setBounds(400, 35, 50, 25);
        etiqueta_nit.setForeground(Color.BLACK);
        etiqueta_nit.setFont(new Font("arial", Font.ROMAN_BASELINE, 13));
        etiqueta_nit.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        panelSeleccionarC.add(etiqueta_nit);

        JLabel etiqueta_correo = new JLabel();
        etiqueta_correo.setText("Correo:");
        etiqueta_correo.setBounds(120, 85, 50, 25);
        etiqueta_correo.setForeground(Color.BLACK);
        etiqueta_correo.setFont(new Font("arial", Font.ROMAN_BASELINE, 13));
        etiqueta_correo.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        panelSeleccionarC.add(etiqueta_correo);

        JLabel etiqueta_genero = new JLabel();
        etiqueta_genero.setText("Género:");
        etiqueta_genero.setBounds(400, 85, 50, 25);
        etiqueta_genero.setForeground(Color.BLACK);
        etiqueta_genero.setFont(new Font("arial", Font.ROMAN_BASELINE, 13));
        etiqueta_genero.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        panelSeleccionarC.add(etiqueta_genero);

        JLabel etiqueta_cliente = new JLabel();
        etiqueta_cliente.setText("Cliente:");
        etiqueta_cliente.setBounds(120, 185, 50, 25);
        etiqueta_cliente.setForeground(Color.BLACK);
        etiqueta_cliente.setFont(new Font("arial", Font.ROMAN_BASELINE, 13));
        etiqueta_cliente.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        panelSeleccionarC.add(etiqueta_cliente);

        //lista desplegable
        String[] listadoCliente = new String[GuardarObjetos.guardarCliente.length];
        for (int i = 0; i < GuardarObjetos.guardarCliente.length; i++) {
            if (GuardarObjetos.guardarCliente[i] != null) {
                listadoCliente[i] = GuardarObjetos.guardarCliente[i].getClienteNombre();
            } else if (GuardarObjetos.guardarCliente[i] == null) {
                break;
            }
        }
        JComboBox listaClientes = new JComboBox(listadoCliente);
        listaClientes.setBounds(180, 185, 100, 25);
//        listaClientes.addItem("aqui se agrega el que se quiera");// añade objeto a la lista
//    listaClientes.setSelectedItem(""); // Selecciona el primer visto
        panelSeleccionarC.add(listaClientes);

        //Cajas de texto
        JTextField c_nom = new JTextField();
        c_nom.setBounds(175, 35, 200, 27);
        panelSeleccionarC.add(c_nom);

        JTextField c_nit = new JTextField();
        c_nit.setBounds(450, 35, 200, 27);
        panelSeleccionarC.add(c_nit);

        JTextField c_correo = new JTextField();
        c_correo.setBounds(175, 85, 200, 27);
        panelSeleccionarC.add(c_correo);

        JTextField c_genero = new JTextField();
        c_genero.setBounds(450, 85, 200, 27);
        panelSeleccionarC.add(c_genero);

        //Botones
        JButton boton1 = new JButton("Aplicar Filtro");
        boton1.setBounds(120, 135, 530, 30);
        boton1.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton1.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton1.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton1.setFont(new Font("arial", Font.BOLD, 13));  //establecemos la fuente de la letra del boton
        boton1.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panelSeleccionarC.add(boton1);
        //Agregando eventos de tipo ActionListener
        ActionListener accion = (ActionEvent ae) -> {
//             int contadorBusqueda = 0;
            if (GuardarObjetos.guardarCliente != null) {
                for (int contadorBusqueda = 0; contadorBusqueda < GuardarObjetos.guardarCliente.length; contadorBusqueda++) {
//                    while (contadorBusqueda < GuardarObjetos.guardarCliente.length) {
                    if (c_nom.getText().equals(GuardarObjetos.guardarCliente[contadorBusqueda].getClienteNombre())
                            || (c_nit.getText().equals(Integer.toString(GuardarObjetos.guardarCliente[contadorBusqueda].getClienteNit())))
                            || (c_correo.getText().equals(GuardarObjetos.guardarCliente[contadorBusqueda].getClienteCorreo()))
                            || (c_genero.getText().equals(GuardarObjetos.guardarCliente[contadorBusqueda].getClienteGenero()))) {
                        // falta el componente para mostrar el dato
                        System.out.println("entro al if");
                        listaClientes.setSelectedItem(c_nom.getText());

                    } else if (c_nom.getText().equals(GuardarObjetos.guardarCliente[contadorBusqueda].getClienteNombre())) {
                        // falta el componente para mostrar el dato
                        System.out.println("entro al if");
                        listaClientes.setSelectedItem(c_nom.getText());

                    } else if ((c_nit.getText().equals(Integer.toString(GuardarObjetos.guardarCliente[contadorBusqueda].getClienteNit())))) {
                        // falta el componente para mostrar el dato
                        System.out.println("entro al if");
                        listaClientes.setSelectedItem(c_nom.getText());

                    } else if ((c_correo.getText().equals(GuardarObjetos.guardarCliente[contadorBusqueda].getClienteCorreo()))) {
                        // falta el componente para mostrar el dato
                        System.out.println("entro al if");
                        listaClientes.setSelectedItem(c_nom.getText());

                    } else if ((c_genero.getText().equals(GuardarObjetos.guardarCliente[contadorBusqueda].getClienteGenero()))) {
                        // falta el componente para mostrar el dato
                        System.out.println("entro al if");
                        listaClientes.setSelectedItem(c_nom.getText());

                    } else {
                        JOptionPane.showMessageDialog(null, "El cliente no existe por favor crear uno nuevo");
                        
                        break;
                    }
//                        contadorBusqueda = contadorBusqueda + 1;

                }
            } else if (GuardarObjetos.guardarCliente == null) {

            }
        };
        boton1.addActionListener(accion);

        JButton boton2 = new JButton("Nuevo Cliente");
        boton2.setBounds(450, 185, 200, 30);
        boton2.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton2.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton2.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton2.setFont(new Font("arial", Font.BOLD, 13));  //establecemos la fuente de la letra del boton
        boton2.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panelSeleccionarC.add(boton2);
        //Agregando eventos de tipo ActionListener
        ActionListener accion2 = (ActionEvent ae) -> {
            Modulo_Administracion vCrearNuevo = new Modulo_Administracion();
            vCrearNuevo.clientes_vCrear();
        };
        boton2.addActionListener(accion2);
    }

    private void nuevaVenta_AgregarP() {
        //TITULO DEL PRIMER PANEL
        JLabel etiquetaTitulo = new JLabel();
        etiquetaTitulo.setText("Agregar Productos");
        etiquetaTitulo.setBounds(0, 0, 200, 25);
        etiquetaTitulo.setForeground(Color.BLACK);
//      etiqueta.setOpaque(true);   //otorga permiso para poder darle color a la etiqueta
//        etiquetaTitulo.setBackground(Color.yellow); // cambia el color de la etiqueta
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        etiquetaTitulo.setFont(new Font("arial", Font.BOLD, 20));
        etiquetaTitulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelAgregarP.add(etiquetaTitulo);
        //Etiquetas datos

        JLabel etiqueta_cod = new JLabel();
        etiqueta_cod.setText("Código:");
        etiqueta_cod.setBounds(25, 35, 50, 25);
        etiqueta_cod.setForeground(Color.BLACK);
        etiqueta_cod.setFont(new Font("arial", Font.ROMAN_BASELINE, 13));
        etiqueta_cod.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        panelAgregarP.add(etiqueta_cod);

        JLabel etiqueta_cant = new JLabel();
        etiqueta_cant.setText("Cantidad:");
        etiqueta_cant.setBounds(285, 35, 75, 25);
        etiqueta_cant.setForeground(Color.BLACK);
        etiqueta_cant.setFont(new Font("arial", Font.ROMAN_BASELINE, 13));
        etiqueta_cant.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        panelAgregarP.add(etiqueta_cant);

        JLabel etiqueta_fecha = new JLabel();
        etiqueta_fecha.setText("Fecha:");
        etiqueta_fecha.setBounds(290, 5, 50, 25);
        etiqueta_fecha.setForeground(Color.BLACK);
        etiqueta_fecha.setFont(new Font("arial", Font.ROMAN_BASELINE, 13));
        etiqueta_fecha.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        panelAgregarP.add(etiqueta_fecha);

        JLabel etiqueta_no = new JLabel();
        etiqueta_no.setText("No.");
        etiqueta_no.setBounds(550, 5, 50, 25);
        etiqueta_no.setForeground(Color.BLACK);
        etiqueta_no.setFont(new Font("arial", Font.ROMAN_BASELINE, 13));
        etiqueta_no.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        panelAgregarP.add(etiqueta_no);

        JLabel etiqueta_total = new JLabel();
        etiqueta_total.setText("Total:");
        etiqueta_total.setBounds(500, 250, 50, 25);
        etiqueta_total.setForeground(Color.BLACK);
        etiqueta_total.setFont(new Font("arial", Font.ROMAN_BASELINE, 13));
        etiqueta_total.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        panelAgregarP.add(etiqueta_total);

        // etiquetas modificables con la fecha y el numero
        // Para manejar la fecha es 
        LocalDate fecha1 = LocalDate.now();
        String fech1 = fecha1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        JLabel etimod_fecha = new JLabel();
        etimod_fecha.setText(fech1);
        etimod_fecha.setBounds(355, 5, 100, 25);
        etimod_fecha.setForeground(Color.BLACK);
        etimod_fecha.setFont(new Font("arial", Font.ROMAN_BASELINE, 13));
        etimod_fecha.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        panelAgregarP.add(etimod_fecha);

        JLabel etimod_no = new JLabel();
        etimod_no.setText("Pendiente");
        etimod_no.setBounds(600, 5, 75, 25);
        etimod_no.setForeground(Color.BLACK);
        etimod_no.setFont(new Font("arial", Font.ROMAN_BASELINE, 13));
        etimod_no.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        panelAgregarP.add(etimod_no);

        //Cajas de texto
        JTextField c_codigo = new JTextField();
        c_codigo.setBounds(80, 35, 200, 27);
        panelAgregarP.add(c_codigo);

        JTextField c_cantidad = new JTextField();
        c_cantidad.setBounds(355, 35, 200, 27);
        panelAgregarP.add(c_cantidad);

        JTextField c_total = new JTextField();
        c_total.setBounds(545, 250, 120, 27);
        panelAgregarP.add(c_total);

        //Botones
        JButton boton1 = new JButton("Agregar");
        boton1.setBounds(565, 35, 100, 27);
        boton1.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton1.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton1.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton1.setFont(new Font("arial", Font.BOLD, 13));  //establecemos la fuente de la letra del boton
        boton1.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panelAgregarP.add(boton1);
        //Agregando eventos de tipo ActionListener
        ActionListener accion = (ActionEvent ae) -> {
            int codigoA = Integer.parseInt(c_codigo.getText());
            int cantidadA = Integer.parseInt(c_cantidad.getText());

            for (int i = 0; i < GuardarObjetos.guardarProductos.length; i++) {
                if (codigoA == GuardarObjetos.guardarProductos[i].getProductoCodigo()) {
                    if (cantidadA <= GuardarObjetos.guardarProductos[i].getProductoCantidad() && cantidadA > 0) {

                        almProducto[contador_Product][0] = Integer.toString(GuardarObjetos.guardarProductos[i].getProductoCodigo());
                        almProducto[contador_Product][1] = GuardarObjetos.guardarProductos[i].getProductoNombre();
                        almProducto[contador_Product][2] = Integer.toString(cantidadA);
                        almProducto[contador_Product][3] = Float.toString(GuardarObjetos.guardarProductos[i].getProductoPrecio());
                        float subtotal = cantidadA * GuardarObjetos.guardarProductos[i].getProductoPrecio();
                        subTot[contador_Product] = subtotal;
                        almProducto[contador_Product][4] = Float.toString(subtotal);

                        modelo_agregarProd.addRow(almProducto[contador_Product]);
                        contador_Product = contador_Product++;
                        int nuevCantidadAlmacenada = GuardarObjetos.guardarProductos[i].getProductoCantidad() - cantidadA; //si la cantidad es menor a la existente entonces se resta
                        GuardarObjetos.guardarProductos[i].setProductoCantidad(nuevCantidadAlmacenada);   // lo que resulta de la resta se envia como nueva cantidad existente 

                    } else if (cantidadA > GuardarObjetos.guardarProductos[i].getProductoCantidad()) {
                        JOptionPane.showMessageDialog(null, "Solamente hay una cantidad de " + GuardarObjetos.guardarProductos[i].getProductoCantidad() + " " + GuardarObjetos.guardarProductos[i].getProductoNombre());
                    } else if (GuardarObjetos.guardarProductos[i].getProductoCantidad() == 0) {
                        JOptionPane.showMessageDialog(null, "Producto agotado");
                    }
                    break;
                }
            }
        };
        boton1.addActionListener(accion);

        JButton boton2 = new JButton("Vender");
        boton2.setBounds(25, 250, 400, 30);
        boton2.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton2.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton2.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton2.setFont(new Font("arial", Font.BOLD, 13));  //establecemos la fuente de la letra del boton
        boton2.setBackground(Color.green); //cambia el color del fondo del boton
        panelAgregarP.add(boton2);
        //Agregando eventos de tipo ActionListener
        ActionListener accion2 = (ActionEvent ae) -> {

        };
        boton2.addActionListener(accion2);

        // tabla 
        modelo_agregarProd.addColumn("Código");
        modelo_agregarProd.addColumn("Nombre");
        modelo_agregarProd.addColumn("Cantidad");
        modelo_agregarProd.addColumn("Precio");
        modelo_agregarProd.addColumn("Subtotal");
        JTable tab = new JTable(modelo_agregarProd);
        JScrollPane scr = new JScrollPane(tab);
        scr.setBounds(25, 85, 640, 150);
        panelAgregarP.add(scr);
    }

    private void ventas_ListadoG() {
        //TITULO DEL PRIMER PANEL
        JLabel etiquetaTitulo = new JLabel();
        etiquetaTitulo.setText("Listado General");
        etiquetaTitulo.setBounds(0, 0, 200, 25);
        etiquetaTitulo.setForeground(Color.BLACK);
//      etiqueta.setOpaque(true);   //otorga permiso para poder darle color a la etiqueta
//        etiquetaTitulo.setBackground(Color.yellow); // cambia el color de la etiqueta
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        etiquetaTitulo.setFont(new Font("arial", Font.BOLD, 20));
        etiquetaTitulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelListaG.add(etiquetaTitulo);
        //Etiquetas subrayadas
        JLabel etiquetaSubrayado = new JLabel();
        etiquetaSubrayado.setText("Filtrar por:");
        Font sub = etiquetaSubrayado.getFont();
        Map atri = sub.getAttributes();
        atri.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        etiquetaSubrayado.setFont(sub.deriveFont(atri));
        etiquetaSubrayado.setBounds(25, 35, 100, 25);
        panelListaG.add(etiquetaSubrayado);

        JLabel etiquetaSubrayado1 = new JLabel();
        etiquetaSubrayado1.setText("Filtrados:");
        Font sub1 = etiquetaSubrayado1.getFont();
        Map atri1 = sub1.getAttributes();
        atri1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        etiquetaSubrayado1.setFont(sub.deriveFont(atri));
        etiquetaSubrayado1.setBounds(25, 185, 100, 25);
        panelListaG.add(etiquetaSubrayado1);

        //Etiquetas datos
        JLabel etiqueta_fact = new JLabel();
        etiqueta_fact.setText("No Factura:");
        etiqueta_fact.setBounds(85, 35, 100, 25);
        etiqueta_fact.setForeground(Color.BLACK);
        etiqueta_fact.setFont(new Font("arial", Font.ROMAN_BASELINE, 13));
        etiqueta_fact.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        panelListaG.add(etiqueta_fact);

        JLabel etiqueta_nitL = new JLabel();
        etiqueta_nitL.setText("NIT:");
        etiqueta_nitL.setBounds(400, 35, 50, 25);
        etiqueta_nitL.setForeground(Color.BLACK);
        etiqueta_nitL.setFont(new Font("arial", Font.ROMAN_BASELINE, 13));
        etiqueta_nitL.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        panelListaG.add(etiqueta_nitL);

        JLabel etiqueta_nombreL = new JLabel();
        etiqueta_nombreL.setText("Nombre:");
        etiqueta_nombreL.setBounds(120, 85, 50, 25);
        etiqueta_nombreL.setForeground(Color.BLACK);
        etiqueta_nombreL.setFont(new Font("arial", Font.ROMAN_BASELINE, 13));
        etiqueta_nombreL.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        panelListaG.add(etiqueta_nombreL);

        JLabel etiqueta_fechaL = new JLabel();
        etiqueta_fechaL.setText("Fecha:");
        etiqueta_fechaL.setBounds(400, 85, 50, 25);
        etiqueta_fechaL.setForeground(Color.BLACK);
        etiqueta_fechaL.setFont(new Font("arial", Font.ROMAN_BASELINE, 13));
        etiqueta_fechaL.setHorizontalAlignment(SwingConstants.CENTER); // pone la palabra en el centro de la etiqueta 
        panelListaG.add(etiqueta_fechaL);

        //Cajas de texto
        JTextField c_facL = new JTextField();
        c_facL.setBounds(175, 35, 200, 27);
        panelListaG.add(c_facL);

        JTextField c_nitL = new JTextField();
        c_nitL.setBounds(450, 35, 200, 27);
        panelListaG.add(c_nitL);

        JTextField c_nombreL = new JTextField();
        c_nombreL.setBounds(175, 85, 200, 27);
        panelListaG.add(c_nombreL);

        JTextField c_fechaL = new JTextField();
        c_fechaL.setBounds(450, 85, 200, 27);
        panelListaG.add(c_fechaL);

        //Botones
        JButton boton1 = new JButton("Aplicar Filtro");
        boton1.setBounds(120, 135, 530, 30);
        boton1.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton1.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton1.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton1.setFont(new Font("arial", Font.BOLD, 13));  //establecemos la fuente de la letra del boton
        boton1.setBackground(Color.LIGHT_GRAY); //cambia el color del fondo del boton
        panelListaG.add(boton1);
        //Agregando eventos de tipo ActionListener
        ActionListener accion = (ActionEvent ae) -> {

        };
        boton1.addActionListener(accion);

        // tabla 
        DefaultTableModel modelo_ListadoG = new DefaultTableModel();
        modelo_ListadoG.addColumn("No. Factura");
        modelo_ListadoG.addColumn("NIT");
        modelo_ListadoG.addColumn("Nombre");
        modelo_ListadoG.addColumn("Fecha");
        modelo_ListadoG.addColumn("Total");
        modelo_ListadoG.addColumn("Acciones");
        JTable tab = new JTable(modelo_ListadoG);
        JScrollPane scr = new JScrollPane(tab);
        scr.setBounds(25, 230, 640, 390);
        panelListaG.add(scr);
    }
}
