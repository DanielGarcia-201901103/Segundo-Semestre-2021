package proyecto_1;

import java.io.Serializable;

public class Sucursal implements Serializable {
    private int sucursalCodigo;
    private String sucursalNombre;
    private String sucursalDireccion;
    private String sucursalCorreo;
    private String sucursalTelefono;

    public Sucursal(int sucursalCodigo, String sucursalNombre, String sucursalDireccion, String sucursalCorreo, String sucursalTelefono) {
        this.sucursalCodigo = sucursalCodigo;
        this.sucursalNombre = sucursalNombre;
        this.sucursalDireccion = sucursalDireccion;
        this.sucursalCorreo = sucursalCorreo;
        this.sucursalTelefono = sucursalTelefono;
    }

    public int getSucursalCodigo() {
        return sucursalCodigo;
    }

    public void setSucursalCodigo(int sucursalCodigo) {
        this.sucursalCodigo = sucursalCodigo;
    }

    public String getSucursalNombre() {
        return sucursalNombre;
    }

    public void setSucursalNombre(String sucursalNombre) {
        this.sucursalNombre = sucursalNombre;
    }

    public String getSucursalDireccion() {
        return sucursalDireccion;
    }

    public void setSucursalDireccion(String sucursalDireccion) {
        this.sucursalDireccion = sucursalDireccion;
    }

    public String getSucursalCorreo() {
        return sucursalCorreo;
    }

    public void setSucursalCorreo(String sucursalCorreo) {
        this.sucursalCorreo = sucursalCorreo;
    }

    public String getSucursalTelefono() {
        return sucursalTelefono;
    }

    public void setSucursalTelefono(String sucursalTelefono) {
        this.sucursalTelefono = sucursalTelefono;
    }
    
}
