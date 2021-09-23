package proyecto_1;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Proyecto_1 {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Modulo_Autenticacion autenticacion = new Modulo_Autenticacion();
        autenticacion.ventanaPrincipal();
        
         GuardarObjetos sn = new GuardarObjetos();
         sn.cargarBinario();
    }

}
