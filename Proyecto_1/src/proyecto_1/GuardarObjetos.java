package proyecto_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class GuardarObjetos implements Serializable {
    public static Vendedor guardarVendedor[] = new Vendedor[400];  // arreglo de OBjeto creado para guardar vendedores
    public static Cliente  guardarCliente[] = new Cliente[100];
    public static Producto guardarProductos[] = new Producto[200];
    public static Sucursal guardarSucursales[] = new Sucursal[50];
    public static Venta guardarVentas[] = new Venta[1000];
    
    
     public void serializando() throws FileNotFoundException, IOException{
        ObjectOutputStream guardClien = new ObjectOutputStream(new FileOutputStream("GuardarCLIENTE.bin"));
        guardClien.writeObject(guardarCliente);
        guardClien.close();
        ObjectOutputStream guardProduc = new ObjectOutputStream(new FileOutputStream("GuardarProducto.bin"));
        guardProduc.writeObject(guardarProductos);
        guardProduc.close();
        ObjectOutputStream guardSucur = new ObjectOutputStream(new FileOutputStream("GuardarSucursales.bin"));
        guardSucur.writeObject(guardarSucursales);
        guardSucur.close();
        ObjectOutputStream guardVend = new ObjectOutputStream(new FileOutputStream("GuardarVendedor.bin"));
        guardVend.writeObject(guardarVendedor);
        guardVend.close();
        ObjectOutputStream guardVent = new ObjectOutputStream(new FileOutputStream("GuardarVentas.bin"));
        guardVent.writeObject(guardarVendedor);
        guardVent.close();
    }
     
    public void cargarBinario() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream abrirClien = new ObjectInputStream(new FileInputStream("GuardarCLIENTE.bin"));
//        gu = (GuardarObjetos) ca.readObject();
        Cliente[] recupClient = (Cliente[]) abrirClien.readObject();
        abrirClien.close();
    }
}
