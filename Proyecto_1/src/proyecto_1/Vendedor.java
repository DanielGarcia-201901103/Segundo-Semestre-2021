package proyecto_1;

public class Vendedor extends Persona{
    private String vendedorCaja;
    private String vendedorVentas;
    private String vendedorPassword;
    
    public Vendedor( String codigo, String nombre,String vendedorCaja,String vendedorVentas,String genero, String vendedorPassword){
        super(codigo,nombre,genero);
        this.vendedorCaja = vendedorCaja;
        this.vendedorPassword = vendedorPassword;
        this.vendedorVentas = vendedorVentas;
    }

    public String getVendedorCaja() {
        return vendedorCaja;
    }

    public String getVendedorVentas() {
        return vendedorVentas;
    }

    public String getVendedorPassword() {
        return vendedorPassword;
    }
    
}
