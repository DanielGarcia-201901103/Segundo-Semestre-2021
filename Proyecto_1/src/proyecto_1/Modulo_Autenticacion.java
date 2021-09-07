package proyecto_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Modulo_Autenticacion extends JFrame{
    Modulo_Administracion ad = new Modulo_Administracion();
    
    private JPanel panel;
    JTextField Text_codigo1 = new JTextField();
    JPasswordField Text_contraseña1 = new JPasswordField();
    
    public void ventanaPrincipal(){
        this.setSize(350, 250);
        this.setTitle("Autenticación");
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(200, 200));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    //Permite cerrar todo el programa
        this.setResizable(false);
        this.setVisible(true);
        iniciarComponentes();
    }
    private void iniciarComponentes() {
        colocarPanel();
        colocarEtiquetas();
        colocarBotones();
        colocarCajasDeTexto();
    }

    private void colocarPanel() {
        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    private void colocarEtiquetas() {
        JLabel etiqueta = new JLabel();
        etiqueta.setText("POS");
        etiqueta.setBounds(140, 20, 100, 20);
        etiqueta.setForeground(Color.BLACK);
//      etiqueta.setOpaque(true);   //otorga permiso para poder darle color a la etiqueta
//      etiqueta.setBackground(Color.yellow); // cambia el color de la etiqueta
//      etiqueta.setHorizontalAlignment(SwingConstants.CENTER);  pone la palabra en el centro de la etiqueta 
        etiqueta.setFont(new Font("arial", Font.BOLD, 30));
        panel.add(etiqueta);

        JLabel etiqueta1 = new JLabel();
        etiqueta1.setText("Código");
        etiqueta1.setBounds(30, 60, 100, 40);
        etiqueta1.setForeground(Color.BLACK);
        etiqueta1.setFont(new Font("arial", Font.ROMAN_BASELINE, 15));
        panel.add(etiqueta1);

        JLabel etiqueta2 = new JLabel();
        etiqueta2.setText("Contraseña");
        etiqueta2.setBounds(30, 110, 100, 40);
        etiqueta2.setForeground(Color.BLACK);
        etiqueta2.setFont(new Font("arial", Font.ROMAN_BASELINE, 15));
        panel.add(etiqueta2);

    }

    private void colocarCajasDeTexto() {
//        Text_codigo.setText("hola"); se ingresa un texto predeterminado
//        Text_codigo.getText(); // obtiene el texto que se ingrese en la caja
        Text_codigo1.setBounds(120, 65, 200, 30);
        panel.add(Text_codigo1);

        Text_contraseña1.setBounds(120, 115, 200, 30);
        panel.add(Text_contraseña1);

    }

    private void colocarBotones() {
        JButton boton1 = new JButton("Iniciar Sesión");
        boton1.setBounds(110, 170, 130, 30);
        // boton.setText("Iniciar Sesión");  //establece texto en el boton           
        boton1.setEnabled(true); //interaccion del encendido del boton,habilita o desabilita los botones
        boton1.setMnemonic(32); //establecemos alt + letra y se cliquea el boton
        boton1.setForeground(Color.BLACK);//establecemos el color de la letra en el boton
        boton1.setFont(new Font("arial", Font.BOLD, 15));  //establecemos la fuente de la letra del boton
//        boton1.setOpaque(true); // habilita la opcion para cambiar el color de fondo del boton
        boton1.setBackground(Color.yellow); //cambia el color del fondo del boton
//        ImageIcon clic = new ImageIcon("nombredelaimagen.png");  // para ingresar una imagen
//  en la linea de abajo se agrega la imagen al boton y se le colocan las dimensiones del boton ademas se indica que tenga buena calidad de pixeles
//        boton1.setIcon(new ImageIcon(clic.getImage().getScaledInstance(boton1.getWidth(),boton1.getHeight(),Image.SCALE_SMOOTH)));
        panel.add(boton1);
        //Agregando eventos de tipo ActionListener
        ActionListener accion = (ActionEvent ae) -> {
            //                for (int i = 0; i < ; i++) {
            if (Text_codigo1.getText().equals("admin") && Text_contraseña1.getText().equals("admin")) {
                ad.ventanaAdmin();
                dispose();
            }             
//                    else if () {
//                       
//                        profe.setVisible(true);
//                        dispose();
//                    }
            else {
                JOptionPane.showMessageDialog(null, "Codigo o Contraseña incorrectos");
            }
//                    break;
//                }
        };
        boton1.addActionListener(accion);
    }
}
