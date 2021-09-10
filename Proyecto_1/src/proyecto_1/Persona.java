package proyecto_1;

public class Persona {

    private String nombre;
    private String codigo;
    private String genero;

    public Persona(String codigo, String nombre, String genero) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getGenero() {
        return genero;
    }

}
