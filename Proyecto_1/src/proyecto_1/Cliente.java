package proyecto_1;

import java.io.Serializable;

public class Cliente implements Serializable{

    private int clienteCodigo;
    private String clienteNombre;
    private int clienteNit;
    private String clienteCorreo;
    private String clienteGenero;

    public Cliente(int clienteCodigo, String clienteNombre, int clienteNit, String clienteCorreo, String clienteGenero) {
        this.clienteCodigo = clienteCodigo;
        this.clienteNombre = clienteNombre;
        this.clienteNit = clienteNit;
        this.clienteCorreo = clienteCorreo;
        this.clienteGenero = clienteGenero;
    }

    public int getClienteCodigo() {
        return clienteCodigo;
    }

    public void setClienteCodigo(int clienteCodigo) {
        this.clienteCodigo = clienteCodigo;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public int getClienteNit() {
        return clienteNit;
    }

    public void setClienteNit(int clienteNit) {
        this.clienteNit = clienteNit;
    }

    public String getClienteCorreo() {
        return clienteCorreo;
    }

    public void setClienteCorreo(String clienteCorreo) {
        this.clienteCorreo = clienteCorreo;
    }

    public String getClienteGenero() {
        return clienteGenero;
    }

    public void setClienteGenero(String clienteGenero) {
        this.clienteGenero = clienteGenero;
    }

}
