package practica_2;

public class GuardarOb {

    public static String numDisc;
    public static String tiempoJN;
    public static Jugador[]  jugadorGuardar = new Jugador[50];
    public GuardarOb(String numDisc, String tiempoJN) {
        this.numDisc = numDisc;
        this.tiempoJN = tiempoJN;
    }

    public static String getNumDisc() {
        return numDisc;
    }

    public static void setNumDisc(String numDisc) {
        GuardarOb.numDisc = numDisc;
    }

    public static String getTiempoJN() {
        return tiempoJN;
    }

    public static void setTiempoJN(String tiempoJN) {
        GuardarOb.tiempoJN = tiempoJN;
    }

    
}
