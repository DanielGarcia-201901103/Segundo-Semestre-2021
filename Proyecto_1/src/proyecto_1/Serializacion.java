package proyecto_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializacion implements Serializable {
    GuardarObjetos gu = new GuardarObjetos();
    
     public void serializando() throws FileNotFoundException, IOException{
        ObjectOutputStream guardD = new ObjectOutputStream(new FileOutputStream("GuardarDatos.bin"));
        guardD.writeObject(gu);
//        guardD.writeObject(guardarCliente);
//        guardD.writeObject(guardarProductos);
//        guardD.writeObject(guardarSucursales);
//        guardD.writeObject(guardarVendedor);
//        guardD.writeObject(guardarVentas);
        guardD.close();
//        ObjectOutputStream guardProduc = new ObjectOutputStream(new FileOutputStream("GuardarProducto.bin"));
//        guardProduc.writeObject(guardarProductos);
//        guardProduc.close();
//        ObjectOutputStream guardSucur = new ObjectOutputStream(new FileOutputStream("GuardarSucursales.bin"));
//        guardSucur.writeObject(guardarSucursales);
//        guardSucur.close();
//        ObjectOutputStream guardVend = new ObjectOutputStream(new FileOutputStream("GuardarVendedor.bin"));
//        guardVend.writeObject(guardarVendedor);
//        guardVend.close();
//        ObjectOutputStream guardVent = new ObjectOutputStream(new FileOutputStream("GuardarVentas.bin"));
//        guardVent.writeObject(guardarVendedor);
//        guardVent.close();
    }
     
    public void cargarBinario() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream abrirD = new ObjectInputStream(new FileInputStream("GuardarDatos.bin"));
        gu = (GuardarObjetos) abrirD.readObject();
//        gu = (GuardarObjetos) ca.readObject();
//        Cliente[] recupClient = (Cliente[]) abrirD.readObject();
//        Producto[] recupProdu = (Producto[]) abrirD.readObject();
//        Sucursal[] recupSucu = (Sucursal[]) abrirD.readObject();
//        Vendedor[] recupVendedor = (Vendedor[]) abrirD.readObject();
//        Venta[] recupVenta = (Venta[]) abrirD.readObject();
        abrirD.close();
    }
}
