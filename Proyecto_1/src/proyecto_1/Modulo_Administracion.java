package proyecto_1;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Modulo_Administracion extends JFrame {
    private JPanel panel, panel1, panel2, panel3, panel4;
    JTextField Text_codigo = new JTextField();
    JTextField Text_contraseña = new JTextField();
    JTabbedPane primeras_pestañas = new JTabbedPane();
    
    public void ventanaAdmin(){
        this.setSize(800, 800);
        this.setTitle("Administración");
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(200, 200));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    //Permite cerrar la pestaña
        this.setResizable(false);
        this.setVisible(true);
        iniciarComponentes();
    }
    private void iniciarComponentes() {
        colocarPanel();

    }
    private void colocarPanel() {
        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        this.getContentPane().add(panel);

        //Sucursales
        panel1 = new JPanel();
        panel1.setBackground(Color.ORANGE);
        panel1.setBounds(21, 21, 730, 730);
        panel1.setLayout(null);
        // Productos
        panel2 = new JPanel();
        panel2.setBackground(Color.CYAN);
        panel2.setBounds(21, 21, 730, 730);
        panel2.setLayout(null);
        //Clientes
        panel3 = new JPanel();
        panel3.setBackground(Color.ORANGE);
        panel3.setBounds(21, 21, 730, 730);
        panel3.setLayout(null);
        //Vendedores
        panel4 = new JPanel();
        panel4.setBackground(Color.CYAN);
        panel4.setBounds(21, 21, 730, 730);
        panel4.setLayout(null);

        primeras_pestañas.addTab("Sucursales", this.getContentPane().add(panel1));
        primeras_pestañas.addTab("Productos", this.getContentPane().add(panel2));
        primeras_pestañas.addTab("Clientes", this.getContentPane().add(panel3));
        primeras_pestañas.addTab("Vendedores", this.getContentPane().add(panel4));
        add(primeras_pestañas);
    }

    
}
