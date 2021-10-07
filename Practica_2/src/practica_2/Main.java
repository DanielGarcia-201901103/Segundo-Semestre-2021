
package practica_2;

public class Main {
   static ManejoHilos man = new ManejoHilos();
    public static void main(String args[]){
        PantallaPrincipal in = new PantallaPrincipal();
        in.setVisible(true);
    }
    public static void iniciarHilos(){
        man.iniciarTiempoJ();
    }
    public static void pararHilos(){
        man.pararTiempoJ();
    }
    public static void botVer(){
        man.potenciadorVerde();
    }
    public static void botRoj(){
        man.debilitadorRojo();
    }
    
}
