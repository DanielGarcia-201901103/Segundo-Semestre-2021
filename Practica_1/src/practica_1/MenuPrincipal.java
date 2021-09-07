package practica_1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuPrincipal {

    Tablero mitabla = new Tablero();
    Scanner reader = new Scanner(System.in);

    public MenuPrincipal() throws FileNotFoundException {
        men();
    }

    public void men() throws FileNotFoundException {
        try {
            int opcion;
            do {

                System.out.println("------Menu Principal------\n"
                        + "1. Iniciar Juego\n"
                        + "2. Retomar Juego\n"
                        + "3. Generar Reportes\n"
                        + "4. Salir\n");

                System.out.println("Ingrese una opción:");
                opcion = reader.nextInt();
                switch (opcion) {
                    case 1:
                        mitabla.reiniciarValores();
                        break;
                    case 2:
                        mitabla.iniciando();
                        break;
                    case 3:
                        Reporte_1 rep1 = new Reporte_1();
                        rep1.realizarRep();
                        Reporte_2 bitacora = new Reporte_2();
                        bitacora.bitacora();
                        System.out.println("Se han creado los reportes correctamente\n");
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                        break;
                }
            } while (opcion != 4);
        } catch (Exception e) {
            System.out.println("Formato incorrecto");
        }
    }
}
