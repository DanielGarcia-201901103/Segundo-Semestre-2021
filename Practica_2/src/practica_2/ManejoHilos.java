package practica_2;

public class ManejoHilos {

    public HiloTiempo t = new HiloTiempo();

    public void iniciarTiempoJ() {
        t.start();
    }

    public void pararTiempoJ() {
        t.v=false;
        t.stop();
        System.out.println(""+t.isAlive());
    }
    public void potenciadorVerde() {
        t.tiempoRegresivo = t.tiempoRegresivo + 10;
    }

    public void debilitadorRojo() {
        t.tiempoRegresivo = t.tiempoRegresivo - 10;
    }
}
