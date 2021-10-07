package practica_2;

public class Jugador {
     String nombre;
     String tiempoRestante;
     int movimientosRealizados;

    public Jugador(String nombre, String tiempoRestante, int movimientosRealizados) {
        this.nombre = nombre;
        this.tiempoRestante = tiempoRestante;
        this.movimientosRealizados = movimientosRealizados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTiempoRestante() {
        return tiempoRestante;
    }

    public void setTiempoRestante(String tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }

    public int getMovimientosRealizados() {
        return movimientosRealizados;
    }

    public void setMovimientosRealizados(int movimientosRealizados) {
        this.movimientosRealizados = movimientosRealizados;
    }


   
     
     
}
