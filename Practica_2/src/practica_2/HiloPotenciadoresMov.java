package practica_2;

public class HiloPotenciadoresMov extends Thread {
   
    String tiempoRegre = GuardarOb.getTiempoJN();

    boolean ve;
    Juego juN = new Juego();

    public HiloPotenciadoresMov() {
        this.ve = true;
    }

    @Override
    public void run() {
        while (ve) {
            if(juN.botonRojo.isVisible()==true){
                
            }else if(juN.botonRojo.isVisible()==false){
                
            }
            else if(juN.botonVerde.isVisible()==true){
                
            }
            else if(juN.botonVerde.isVisible()==false){
                
            }
            try {
                //tiempo de creacion
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }

}
