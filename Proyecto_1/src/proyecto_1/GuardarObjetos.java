package proyecto_1;

import java.io.Serializable;


public class GuardarObjetos implements Serializable {
    public static Vendedor guardarVendedor[] = new Vendedor[400];  // arreglo de OBjeto creado para guardar vendedores
    public static Cliente  guardarCliente[] = new Cliente[100];
    public static Producto guardarProductos[] = new Producto[200];
    public static Sucursal guardarSucursales[] = new Sucursal[50];
    public static Venta guardarVentas[] = new Venta[1000];

    public GuardarObjetos() {
        
    }
}
