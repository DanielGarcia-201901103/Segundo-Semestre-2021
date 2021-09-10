package proyecto_1;

public class Cliente extends Persona{
    private String clienteCorreo;
    private String clienteNit;
    
    public Cliente( String codigo,String nombre, String clienteNit, String clienteCorreo, String genero){
        super(codigo,nombre,genero);
        this.clienteCorreo = clienteCorreo;
        this.clienteNit = clienteNit;
    }
    
}
