/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author da
 */
public class Serializacion implements Serializable {
    GuardarObjetos gu = new GuardarObjetos();
    
    public void serializando() throws FileNotFoundException, IOException{
        ObjectOutputStream se = new ObjectOutputStream(new FileOutputStream("GuardarDat.bin"));
        se.writeObject(gu);
        se.close();
    }
    public void cargarBinario() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ca = new ObjectInputStream(new FileInputStream("GuardarDat.bin"));
        gu = (GuardarObjetos) ca.readObject();
    }
}
