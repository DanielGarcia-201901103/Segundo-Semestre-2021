package practica_2;

public class ManejoHilos {

    public HiloTiempo t = new HiloTiempo();
    public HiloTiempo t1 = new HiloTiempo();
    public HiloTiempo t2 = new HiloTiempo();
    public HiloTiempo t3 = new HiloTiempo();
    public HiloTiempo t4 = new HiloTiempo();
    public HiloTiempo t5 = new HiloTiempo();
    public HiloTiempo t6 = new HiloTiempo();
    public HiloTiempo t7 = new HiloTiempo();
    public HiloTiempo t8 = new HiloTiempo();
    public HiloTiempo t9 = new HiloTiempo();
    public HiloTiempo t10 = new HiloTiempo();
    public HiloTiempo t11 = new HiloTiempo();
    public HiloTiempo t12 = new HiloTiempo();
    public HiloTiempo t13 = new HiloTiempo();
    public HiloTiempo t14 = new HiloTiempo();
    public HiloTiempo t15 = new HiloTiempo();
    public HiloTiempo t16 = new HiloTiempo();
    public HiloTiempo t17 = new HiloTiempo();
    public HiloTiempo t18 = new HiloTiempo();
    public HiloTiempo t19 = new HiloTiempo();
    static int cantidadHil;
    
    public void recibirNhilo(int cantidadHil){
        this.cantidadHil=cantidadHil;
    }
    public void iniciarTiempoJ() {
        if(cantidadHil==0){
            t.start();
        }else if(cantidadHil==1){
            t1.start();
        }else if(cantidadHil==2){
            t2.start();
        }else if(cantidadHil==3){
            t3.start();
        }else if(cantidadHil==4){
            t4.start();
        }else if(cantidadHil==5){
            t5.start();
        }else if(cantidadHil==6){
            t6.start();
        }else if(cantidadHil==7){
            t7.start();
        }else if(cantidadHil==8){
            t8.start();
        }else if(cantidadHil==9){
            t9.start();
        }else if(cantidadHil==10){
            t10.start();
        }else if(cantidadHil==11){
            t11.start();
        }else if(cantidadHil==12){
            t12.start();
        }else if(cantidadHil==13){
            t13.start();
        }else if(cantidadHil==14){
            t14.start();
        }else if(cantidadHil==15){
            t15.start();
        }else if(cantidadHil==16){
            t16.start();
        }else if(cantidadHil==17){
            t17.start();
        }else if(cantidadHil==18){
            t18.start();
        }else if(cantidadHil==19){
            t19.start();
        }
        
    }

    public void pararTiempoJ() {
        if(cantidadHil==0){
            t.v=false;
        }else if(cantidadHil==1){
            t1.v=false;
        }else if(cantidadHil==2){
            t2.v=false;
        }else if(cantidadHil==3){
            t3.v=false;
        }else if(cantidadHil==4){
            t4.v=false;
        }else if(cantidadHil==5){
            t5.v=false;
        }else if(cantidadHil==6){
            t6.v=false;
        }else if(cantidadHil==7){
            t7.v=false;
        }else if(cantidadHil==8){
            t8.v=false;
        }else if(cantidadHil==9){
            t9.v=false;
        }else if(cantidadHil==10){
            t10.v=false;
        }else if(cantidadHil==11){
            t11.v=false;
        }else if(cantidadHil==12){
            t12.v=false;
        }else if(cantidadHil==13){
            t13.v=false;
        }else if(cantidadHil==14){
            t14.v=false;
        }else if(cantidadHil==15){
            t15.v=false;
        }else if(cantidadHil==16){
            t16.v=false;
        }else if(cantidadHil==17){
            t17.v=false;
        }else if(cantidadHil==18){
            t18.v=false;
        }else if(cantidadHil==19){
            t19.v=false;
        }
       
//        t.stop();
//        System.out.println(""+t.isAlive());
    }
    public void potenciadorVerde() {
        t.tiempoRegresivo = t.tiempoRegresivo + 10;
    }

    public void debilitadorRojo() {
        t.tiempoRegresivo = t.tiempoRegresivo - 10;
    }
}
