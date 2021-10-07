package practica_2;

import java.awt.Point;

public class HiloPotenciadoresMov extends Thread {
   
    String tiempoRegre = GuardarOb.getTiempoJN();
    int y,y1;
    boolean ve;
    Juego juN = new Juego();
    public HiloPotenciadoresMov() {
        this.ve = true;
    }

    @Override
    public void run() {
        while (ve) {
            if( juN.botonRojo.getY()<= 237){
                y=juN.botonRojo.getY();
//                juN.botonRojo.setLocation(12, y+2);
                juN.botonRojo.setBounds(12, y+2,60,60);
                System.out.println(""+ juN.botonRojo.getBounds());
//                System.out.println(""+juN.botonRojo.getY());

            }else if(juN.botonRojo.getY()>237 && juN.botonVerde.getY()>=237 && juN.botonVerde.getY() <= 500){
                juN.botonRojo.setVisible(false);
                y1=juN.botonVerde.getY();
//                juN.botonRojo.setLocation(12, y+2);
                juN.botonVerde.setBounds(12, y1+2,60,60);
                System.out.println(""+ juN.botonVerde.getBounds());
            }else if(juN.botonVerde.getY() >500){
                y=12;
                juN.botonRojo.setBounds(12, y,60,60);
                y1=237;
                juN.botonRojo.setBounds(12, y,60,60);
             break;   
            }
            try {
                //tiempo de creacion
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }

}
