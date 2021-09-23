package proyecto_1;

import java.io.Serializable;

public class Producto implements Serializable{
    private int productoCodigo;
    private String productoNombre;
    private String productoDescripcion;
    private int productoCantidad;
    private float productoPrecio;

    public Producto(int productoCodigo, String productoNombre, String productoDescripcion, int productoCantidad, float productoPrecio) {
        this.productoCodigo = productoCodigo;
        this.productoNombre = productoNombre;
        this.productoDescripcion = productoDescripcion;
        this.productoCantidad = productoCantidad;
        this.productoPrecio = productoPrecio;
    }

    public int getProductoCodigo() {
        return productoCodigo;
    }

    public void setProductoCodigo(int productoCodigo) {
        this.productoCodigo = productoCodigo;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public String getProductoDescripcion() {
        return productoDescripcion;
    }

    public void setProductoDescripcion(String productoDescripcion) {
        this.productoDescripcion = productoDescripcion;
    }

    public int getProductoCantidad() {
        return productoCantidad;
    }

    public void setProductoCantidad(int productoCantidad) {
        this.productoCantidad = productoCantidad;
    }

    public float getProductoPrecio() {
        return productoPrecio;
    }

    public void setProductoPrecio(float productoPrecio) {
        this.productoPrecio = productoPrecio;
    }
    
   
}
