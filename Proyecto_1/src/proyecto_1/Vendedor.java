package proyecto_1;

public class Vendedor {

    private int vendedorCodigo;
    private String vendedorNombre;
    private int vendedorCaja;
    private int vendedorVentas;
    private String vendedorGenero;
    private String vendedorPassword;

    public Vendedor(int vendedorCodigo, String vendedorNombre, int vendedorCaja, int vendedorVentas, String vendedorGenero, String vendedorPassword) {
        this.vendedorCodigo = vendedorCodigo;
        this.vendedorNombre = vendedorNombre;
        this.vendedorCaja = vendedorCaja;
        this.vendedorVentas = vendedorVentas;
        this.vendedorGenero = vendedorGenero;
        this.vendedorPassword = vendedorPassword;
    }

    public int getVendedorCodigo() {
        return vendedorCodigo;
    }

    public void setVendedorCodigo(int vendedorCodigo) {
        this.vendedorCodigo = vendedorCodigo;
    }

    public String getVendedorNombre() {
        return vendedorNombre;
    }

    public void setVendedorNombre(String vendedorNombre) {
        this.vendedorNombre = vendedorNombre;
    }

    public int getVendedorCaja() {
        return vendedorCaja;
    }

    public void setVendedorCaja(int vendedorCaja) {
        this.vendedorCaja = vendedorCaja;
    }

    public int getVendedorVentas() {
        return vendedorVentas;
    }

    public void setVendedorVentas(int vendedorVentas) {
        this.vendedorVentas = vendedorVentas;
    }

    public String getVendedorGenero() {
        return vendedorGenero;
    }

    public void setVendedorGenero(String vendedorGenero) {
        this.vendedorGenero = vendedorGenero;
    }

    public String getVendedorPassword() {
        return vendedorPassword;
    }

    public void setVendedorPassword(String vendedorPassword) {
        this.vendedorPassword = vendedorPassword;
    }

}
