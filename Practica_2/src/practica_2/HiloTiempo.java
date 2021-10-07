package practica_2;

import javax.swing.JOptionPane;

public class HiloTiempo extends Thread {

    int tiempoRegresivo;
    boolean v;
    Juego jN = new Juego();

    public HiloTiempo() {
        this.v = true;
    }
    @Override
    public void run() {
        
        if (GuardarOb.getTiempoJN() == null) {
            tiempoRegresivo = 120;
        } else if (GuardarOb.getTiempoJN() != null) {
            tiempoRegresivo = Integer.parseInt((String)GuardarOb.getTiempoJN());
        }
        while ((this.v == true)) {
            
            if (tiempoRegresivo == 0) {
                JOptionPane.showMessageDialog(null, "Perdió el juego");
                v = false;
                tiempoRegresivo=0;
                GuardarOb.setTiempoJN(null);
                break;
            }else if(tiempoRegresivo < 0) {
                JOptionPane.showMessageDialog(null, "Perdió el juego");
                v = false;
                tiempoRegresivo=0;
                GuardarOb.setTiempoJN(null);
                break;
            }else {
                String mos = Integer.toString(tiempoRegresivo);
                GuardarOb.setTiempoJN(mos);
                jN.mostrarTiempo.setText(GuardarOb.getTiempoJN());
                System.out.println(jN.mostrarTiempo.getText());
                tiempoRegresivo = tiempoRegresivo - 1;
                
                try {
                    //tiempo de creacion
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        }
    }
}
