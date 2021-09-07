package practica_1;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Tablero {
    Reporte_2 bita = new Reporte_2(); 
    Scanner ent = new Scanner(System.in);
    int azar;
    static int posicionCasilla = 0;
    char penalización = '#';
    char vacio1 = ' ';
    static char[][] jugador = new char[8][8];
    static char[][] penalizaciones = new char[8][8];
    static int contpenalizaciones_facil = 0;
    static int contpenalizaciones_intermedio = 0;
    static int contpenalizaciones_dificil = 0;
    final int constante = 2;        // limite para las muestras de penalizaciones
    static int posicion = 0;         // variable para manejar la primer fila
    static int posicion_contraria = 0;  //variable para la segunda fila
    static int nuevaposi = 0;                  //variable para la tercera fila
    static int restnuevaposi = 0;                //variable para manejar la cuarta fila
    static int posiQuinta = 0;                      //variable para manejar la quinta fila
    static int posiSexta = 0;                        //variable para manejar la sexta fila
    static int posiSeptima = 0;                      //variable para manejar la septima fila
    static int posiOcta = 0;                       //variable para manejar la octaba fila
    int valo[] = new int[3]; // Crea el arreglo con la cantidad de espacios para lo aleatorio
    int indice;

    public Tablero() {
    }

    public void reiniciarValores() throws FileNotFoundException {
        posicionCasilla = 0;
        contpenalizaciones_facil = 0;
        contpenalizaciones_intermedio = 0;
        contpenalizaciones_dificil = 0;
        posicion = 0;
        posicion_contraria = 0;
        nuevaposi = 0;
        restnuevaposi = 0;
        posiQuinta = 0;
        posiSexta = 0;
        posiSeptima = 0;
        posiOcta = 0;
        iniciando();
    }

    public void iniciando() throws FileNotFoundException {
        for (int contador = 0; contador < 64; contador++) {
            iniciar();
        }
    }

    public void iniciar() throws FileNotFoundException {
        String espa = "";
        if (posicionCasilla == 0) {
            llenado_matrizjugador();
            penalizaciones();
            tableroDibujado();
            posicionCasilla = posicionCasilla + 1;
            System.out.println("Presione enter para continuar");
            System.out.println("O presione la letra 'p' para pausar\n");
        } else {
            espa = ent.nextLine();
            if (espa.equals("")) {
                dado_aleatorio();
                aleatorioSinrepetir();
                movimiento_jugador();
                tableroDibujado();
                System.out.println("Presione enter para continuar");
            System.out.println("O presione la letra 'p' para pausar\n");
            } else if (espa.equals("p")) {
                System.out.println("");
                MenuPrincipal m = new MenuPrincipal();
            } else {
                System.out.println("error");
            }
        }
          
//            bita.recibirTablero(posicionCasilla, ent,azar );
    }

    public void dado_aleatorio() {
        //debe lanzar del 2 al 6, generando los numeros aleatorios 
        azar = (int) (Math.random() * 5 + 2);
        System.out.println("Valor del Dado : " + azar);

    }

    public void penalizaciones() {  // solo se agrega los simbolos aleatoriamente en el tablero    
        // todo esto funciona para la fila 7
        for (int i = 7; i >= 0; i--) {
            if (i == 7) {
                int azarpenalizaciones = (int) (Math.random() * 3 + 2); // Para elegir la cantidad de penalizaciones que debe haber en una fila del 2-4
                int valores[] = new int[azarpenalizaciones]; // Crea el arreglo con la cantidad de espacios para las penalizaciones que habrán en una fila
                int ind = 0;                                 // indice para ir sumando las iteraciones
                for (int j = 0; j < 8; j++) {                   // Se indica que todas las casillas de las filas estén vacias
                    penalizaciones[7][j] = vacio1;
                }
                while (ind < valores.length) {                            // Se ingresa al bucle de acuerdo al limite del indice y al limite del arreglo
                    int posicionpenalizacion = (int) (Math.random() * 6 + 2);   // para elegir la posicion en la que caera la penalizacion del    0-7
                    boolean repetido = false;                                    //indica que no hay nada repetido y si hay algo repetido cambia a true
                    while (!repetido) {                                          // valua si hay algo repetido ingresa al bucle
                        for (int conta = 0; conta < ind; conta++) {                // bucle para indicar que si hay algun numero repetido vuelva la variable a repetido a true
                            if (posicionpenalizacion == valores[conta]) {      //si el valor de la posicion coincide con el valor del arreglo  es porque está repetido 
                                repetido = true;                                   // cambia el valor a verdadero  
                                break;                                             // termina la ejecucion  
                            }
                        }
                        if (!repetido) {                                           // si la variable no está repetida 
                            valores[ind] = posicionpenalizacion;                    // al arreglo le ingreso el valor aleatorio 
                            int indice = valores[ind];                             // a la nueva variable indice le guardo el valor de la variable

                            penalizaciones[7][indice] = '#';                      // a la matriz se le ingresa la variable indice para que genere la posicion sin que se repita
                            ind++;                                              //aumenta la unidad  del iterador
                        }
                    }
                }
            } else if (i == 6) {
                int azarpenalizaciones1 = (int) (Math.random() * 3 + 2); // Para elegir la cantidad de penalizaciones que debe haber en una fila del 2-4
                int valores1[] = new int[azarpenalizaciones1];
                int ind1 = 0;
                for (int j = 0; j < 8; j++) {
                    penalizaciones[6][j] = vacio1;
                }
                while (ind1 < valores1.length) {
                    int posicionpenalizacion1 = (int) (Math.random() * 8);   // para elegir la posicion en la que caera la penalizacion del    0-7
                    boolean repetido1 = false;
                    while (!repetido1) {
                        for (int conta1 = 0; conta1 < ind1; conta1++) {
                            if (posicionpenalizacion1 == valores1[conta1]) {
                                repetido1 = true;
                                break;
                            }
                        }
                        if (!repetido1) {
                            valores1[ind1] = posicionpenalizacion1;
                            int indice1 = valores1[ind1];

                            penalizaciones[6][indice1] = '#';
                            ind1++;
                        }
                    }
                }
            } else if (i == 5) {
                int azarpenalizaciones2 = (int) (Math.random() * 3 + 2); // Para elegir la cantidad de penalizaciones que debe haber en una fila del 2-4
                int valores2[] = new int[azarpenalizaciones2];
                int ind2 = 0;
                for (int j = 0; j < 8; j++) {
                    penalizaciones[5][j] = vacio1;
                }
                while (ind2 < valores2.length) {
                    int posicionpenalizacion2 = (int) (Math.random() * 8);   // para elegir la posicion en la que caera la penalizacion del    0-7
                    boolean repetido2 = false;
                    while (!repetido2) {
                        for (int conta2 = 0; conta2 < ind2; conta2++) {
                            if (posicionpenalizacion2 == valores2[conta2]) {
                                repetido2 = true;
                                break;
                            }
                        }
                        if (!repetido2) {
                            valores2[ind2] = posicionpenalizacion2;
                            int indice2 = valores2[ind2];

                            penalizaciones[5][indice2] = '#';
                            ind2++;
                        }
                    }
                }
            } else if (i == 4) {
                int azarpenalizaciones3 = (int) (Math.random() * 3 + 2); // Para elegir la cantidad de penalizaciones que debe haber en una fila del 2-4
                int valores3[] = new int[azarpenalizaciones3];
                int ind3 = 0;
                for (int j = 0; j < 8; j++) {
                    penalizaciones[4][j] = vacio1;
                }
                while (ind3 < valores3.length) {
                    int posicionpenalizacion3 = (int) (Math.random() * 8);   // para elegir la posicion en la que caera la penalizacion del    0-7
                    boolean repetido3 = false;
                    while (!repetido3) {
                        for (int conta3 = 0; conta3 < ind3; conta3++) {
                            if (posicionpenalizacion3 == valores3[conta3]) {
                                repetido3 = true;
                                break;
                            }
                        }
                        if (!repetido3) {
                            valores3[ind3] = posicionpenalizacion3;
                            int indice1 = valores3[ind3];

                            penalizaciones[4][indice1] = '#';
                            ind3++;
                        }
                    }
                }
            } else if (i == 3) {
                int azarpenalizaciones4 = (int) (Math.random() * 3 + 2); // Para elegir la cantidad de penalizaciones que debe haber en una fila del 2-4
                int valores4[] = new int[azarpenalizaciones4];
                int ind4 = 0;
                for (int j = 0; j < 8; j++) {
                    penalizaciones[3][j] = vacio1;
                }
                while (ind4 < valores4.length) {
                    int posicionpenalizacion4 = (int) (Math.random() * 8);   // para elegir la posicion en la que caera la penalizacion del    0-7
                    boolean repetido4 = false;
                    while (!repetido4) {
                        for (int conta4 = 0; conta4 < ind4; conta4++) {
                            if (posicionpenalizacion4 == valores4[conta4]) {
                                repetido4 = true;
                                break;
                            }
                        }
                        if (!repetido4) {
                            valores4[ind4] = posicionpenalizacion4;
                            int indice4 = valores4[ind4];

                            penalizaciones[3][indice4] = '#';
                            ind4++;
                        }
                    }
                }
            } else if (i == 2) {
                int azarpenalizaciones5 = (int) (Math.random() * 3 + 2); // Para elegir la cantidad de penalizaciones que debe haber en una fila del 2-4
                int valores5[] = new int[azarpenalizaciones5];
                int ind5 = 0;
                for (int j = 0; j < 8; j++) {
                    penalizaciones[2][j] = vacio1;
                }
                while (ind5 < valores5.length) {
                    int posicionpenalizacion5 = (int) (Math.random() * 8);   // para elegir la posicion en la que caera la penalizacion del    0-7
                    boolean repetido5 = false;
                    while (!repetido5) {
                        for (int conta5 = 0; conta5 < ind5; conta5++) {
                            if (posicionpenalizacion5 == valores5[conta5]) {
                                repetido5 = true;
                                break;
                            }
                        }
                        if (!repetido5) {
                            valores5[ind5] = posicionpenalizacion5;
                            int indice5 = valores5[ind5];

                            penalizaciones[2][indice5] = '#';
                            ind5++;
                        }
                    }
                }
            } else if (i == 1) {
                int azarpenalizaciones6 = (int) (Math.random() * 3 + 2); // Para elegir la cantidad de penalizaciones que debe haber en una fila del 2-4
                int valores6[] = new int[azarpenalizaciones6];
                int ind6 = 0;
                for (int j = 0; j < 8; j++) {
                    penalizaciones[1][j] = vacio1;
                }
                while (ind6 < valores6.length) {
                    int posicionpenalizacion6 = (int) (Math.random() * 8);   // para elegir la posicion en la que caera la penalizacion del    0-7
                    boolean repetido6 = false;
                    while (!repetido6) {
                        for (int conta6 = 0; conta6 < ind6; conta6++) {
                            if (posicionpenalizacion6 == valores6[conta6]) {
                                repetido6 = true;
                                break;
                            }
                        }
                        if (!repetido6) {
                            valores6[ind6] = posicionpenalizacion6;
                            int indice6 = valores6[ind6];

                            penalizaciones[1][indice6] = '#';
                            ind6++;
                        }
                    }
                }
            } else if (i == 0) {
                int azarpenalizaciones7 = (int) (Math.random() * 3 + 2); // Para elegir la cantidad de penalizaciones que debe haber en una fila del 2-4
                int valores7[] = new int[azarpenalizaciones7];
                int ind7 = 0;
                for (int j = 0; j < 8; j++) {
                    penalizaciones[0][j] = vacio1;
                }
                while (ind7 < valores7.length) {
                    int posicionpenalizacion7 = (int) (Math.random() * 8);   // para elegir la posicion en la que caera la penalizacion del    0-7
                    boolean repetido7 = false;
                    while (!repetido7) {
                        for (int conta7 = 0; conta7 < ind7; conta7++) {
                            if (posicionpenalizacion7 == valores7[conta7]) {
                                repetido7 = true;
                                break;
                            }
                        }
                        if (!repetido7) {
                            valores7[ind7] = posicionpenalizacion7;
                            int indice7 = valores7[ind7];

                            penalizaciones[0][indice7] = '#';
                            ind7++;
                        }
                    }
                }
            }
        }
    }

    public void llenado_matrizjugador() {
        for (int i = 0; i < 8; i++) {
            jugador[0][i] = ' ';
            jugador[1][i] = ' ';
            jugador[2][i] = ' ';
            jugador[3][i] = ' ';
            jugador[4][i] = ' ';
            jugador[5][i] = ' ';
            jugador[6][i] = ' ';
            if (i != 0) {
                jugador[7][i] = ' ';
            } else {
                jugador[7][0] = '@';
            }
        }
    }

    public void movimiento_jugador() throws FileNotFoundException {

        posicionCasilla = posicionCasilla + azar;
        System.out.println("Avanza a la casilla No.: " + posicionCasilla);
        System.out.println(" ");

        if (posicion < 8 && posicion > -1) {
            if (posicion == 0) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                    }
                    posicion = 2;
                    jugador[7][posicion] = '@';
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                    }
                    posicion = 3;
                    jugador[7][posicion] = '@';
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                    }
                    posicion = 4;
                    jugador[7][posicion] = '@';
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                    }
                    posicion = 5;
                    jugador[7][posicion] = '@';
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                    }
                    posicion = 6;
                    jugador[7][posicion] = '@';
                }
                if (penalizaciones[7][posicion] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                    System.out.println("¡Haz caído en una penalizacion!");
                    Operacion_facil facil = new Operacion_facil();
                    facil.ley_cosenos(indice);
                    contpenalizaciones_facil = contpenalizaciones_facil + 1;
                }
            } else if (posicion == 2) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                    }
                    posicion = 4;
                    jugador[7][posicion] = '@';
                    if (penalizaciones[7][posicion] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                    }
                    posicion = 5;
                    jugador[7][posicion] = '@';

                    if (penalizaciones[7][posicion] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                    }
                    posicion = 6;
                    jugador[7][posicion] = '@';
                    if (penalizaciones[7][posicion] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                    }
                    posicion = 7;
                    jugador[7][posicion] = '@';
                    if (penalizaciones[7][posicion] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 7;
                    posicion = 8;
                    jugador[6][posicion_contraria] = '@';                                                       // pasa a fila 6 casilla 9 y valor 7

                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                }
            } else if (posicion == 3) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                    }
                    posicion = 5;
                    jugador[7][posicion] = '@';
                    if (penalizaciones[7][posicion] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                    }
                    posicion = 6;
                    jugador[7][posicion] = '@';
                    if (penalizaciones[7][posicion] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                    }
                    posicion = 7;
                    jugador[7][posicion] = '@';
                    if (penalizaciones[7][posicion] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 7;
                    jugador[6][posicion_contraria] = '@';                                                           // pasa a fila 6 casilla 9 y valor 7
                    posicion = 8;
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 6;
                    posicion = 8;
                    jugador[6][posicion_contraria] = '@';          // pasa a fila 6 casilla 10 y valor 6
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                }
            } else if (posicion == 4) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                    }
                    posicion = 6;
                    jugador[7][posicion] = '@';
                    if (penalizaciones[7][posicion] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                    }
                    posicion = 7;
                    jugador[7][posicion] = '@';
                    if (penalizaciones[7][posicion] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 7;
                    posicion = 8;
                    jugador[6][posicion_contraria] = '@';             // pasa a fila 6 casilla 9 y valor 7
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 6;
                    posicion = 8;
                    jugador[6][posicion_contraria] = '@';         // pasa a fila 6 casilla 10 y valor 6
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 5;
                    posicion = 8;
                    jugador[6][posicion_contraria] = '@';          // pasa a fila 6 casilla 11 y valor 5
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                }
            } else if (posicion == 5) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                    }
                    posicion = 7;
                    jugador[7][posicion] = '@';

                    if (penalizaciones[7][posicion] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 7;
                    jugador[6][posicion_contraria] = '@';            // pasa a fila 6 casilla 9 y valor 7
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                    posicion = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 6;
                    jugador[6][posicion_contraria] = '@';             // pasa a fila 6 casilla 10 y valor 6
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                    posicion = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 5;
                    jugador[6][posicion_contraria] = '@';         // pasa a fila 6 casilla 11 y valor 5
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                    posicion = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 4;
                    jugador[6][posicion_contraria] = '@';          // pasa a fila 6 casilla 12 y valor 4
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                    posicion = 8;
                }

            } else if (posicion == 6) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 7;
                    jugador[6][posicion_contraria] = '@';            // pasa a fila 6 casilla 9 y valor 7
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                    posicion = 8;
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 6;
                    jugador[6][posicion_contraria] = '@';             // pasa a fila 6 casilla 10 y valor 6
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                    posicion = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 5;
                    jugador[6][posicion_contraria] = '@';         // pasa a fila 6 casilla 11 y valor 5
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                    posicion = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 4;
                    jugador[6][posicion_contraria] = '@';          // pasa a fila 6 casilla 12 y valor 4
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                    posicion = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 3;
                    jugador[6][posicion_contraria] = '@';          // pasa a fila 6 casilla 13 y valor 3
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                    posicion = 8;
                }
            } else if (posicion == 7) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }

                    posicion_contraria = 6;
                    jugador[6][posicion_contraria] = '@';             // pasa a fila 6 casilla 10 y valor 6
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 5;
                    jugador[6][posicion_contraria] = '@';         // pasa a fila 6 casilla 11 y valor 5
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }

                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 4;
                    jugador[6][posicion_contraria] = '@';          // pasa a fila 6 casilla 12 y valor 4
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }

                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 3;
                    jugador[6][posicion_contraria] = '@';          // pasa a fila 6 casilla 13 y valor 3
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }

                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[7][j] = ' ';
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 2;
                    jugador[6][posicion_contraria] = '@';          // pasa a fila 6 casilla 13 y valor 2
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                }
                posicion = 8;
            }
        } else if (posicion_contraria < 8 && posicion_contraria > -1 && posicion == 8) {               //Validaciones para la segunda fila         #################################################3
            if (posicion_contraria == 7) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 5;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 4;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 3;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 2;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 1;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                }
            } else if (posicion_contraria == 6) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 4;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 3;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 2;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 1;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 0;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                }
            } else if (posicion_contraria == 5) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 3;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 2;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 1;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 0;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 0;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 17 y posicion 0  
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    posicion_contraria = 8;
                }
            } else if (posicion_contraria == 4) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 2;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 1;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 0;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 0;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 17 y posicion 0    
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();

                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    posicion_contraria = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 1;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 18 y posicion 1  
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    posicion_contraria = 8;
                }
            } else if (posicion_contraria == 3) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 1;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 0;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 0;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 17 y posicion 0
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    posicion_contraria = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 1;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 18 y posicion 1  
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    posicion_contraria = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 2;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 19 y posicion 2   
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    posicion_contraria = 8;
                }
            } else if (posicion_contraria == 2) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                    }
                    posicion_contraria = 0;
                    jugador[6][posicion_contraria] = '@';
                    if (penalizaciones[6][posicion_contraria] == '#' && contpenalizaciones_facil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_facil facil = new Operacion_facil();
                        facil.ley_cosenos(indice);
                        contpenalizaciones_facil = contpenalizaciones_facil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 0;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 17 y posicion 0  
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    posicion_contraria = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 1;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 18 y posicion 1  
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    posicion_contraria = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 2;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 19 y posicion 2 
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    posicion_contraria = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 3;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 20 y posicion 3   
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    posicion_contraria = 8;
                }
            } else if (posicion_contraria == 1) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 0;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 17 y posicion 0  
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }

                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 1;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 18 y posicion 1 
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 2;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 19 y posicion 2       
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 3;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 20 y posicion 3    
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 4;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 21 y posicion 4       
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                }
                posicion_contraria = 8;
            } else if (posicion_contraria == 0) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 1;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 18 y posicion 1    
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 2;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 19 y posicion 2  
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 3;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 20 y posicion 3 
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 4;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 21 y posicion 4  
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 5;
                    jugador[5][nuevaposi] = '@';                   // aqui cae a la fila 5 casilla 22 y posicion 5 

                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                }
                posicion_contraria = 8;
            }
        } else if (posicion_contraria == 8 && nuevaposi > -1 && nuevaposi < 8) {               //Validaciones para la tercera fila ############################################################3
            if (nuevaposi == 0) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 2;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 3;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 4;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 5;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 6;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                }
            } else if (nuevaposi == 1) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 3;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 4;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 5;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 6;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 7;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                }
            } else if (nuevaposi == 2) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 4;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 5;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 6;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 7;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 7;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 25 y posicion7  
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                }
            } else if (nuevaposi == 3) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 5;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 6;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 7;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 7;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 25 y posicion7 
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 6;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 26 y posicion6 
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                }
            } else if (nuevaposi == 4) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 6;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 7;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 7;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 25 y posicion7  
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 6;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 26 y posicion6 
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 5;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 27 y posicion5
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                }
            } else if (nuevaposi == 5) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[6][j] = ' ';
                        jugador[5][j] = ' ';
                    }
                    nuevaposi = 7;
                    jugador[5][nuevaposi] = '@';
                    if (penalizaciones[5][nuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 7;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 25 y posicion7  
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 6;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 26 y posicion6 
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 5;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 27 y posicion5
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 4;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 28 y posicion4
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                }
            } else if (nuevaposi == 6) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 7;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 25 y posicion7  
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 6;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 26 y posicion6 
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 5;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 27 y posicion5
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 4;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 28 y posicion4
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 3;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 29 y posicion3
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                }
            } else if (nuevaposi == 7) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 6;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 26 y posicion6 
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 5;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 27 y posicion5
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 4;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 28 y posicion4
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 3;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 29 y posicion3
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 2;
                    jugador[4][restnuevaposi] = '@';                                   //aqui cae a la fila 4 y casilla 30 y posicion2
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    nuevaposi = 8;
                }
            }
        } else if (nuevaposi == 8 && restnuevaposi > -1 && restnuevaposi < 8) {               //Validaciones para la cuarta fila ############################################################3
            if (restnuevaposi == 7) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 5;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 4;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 3;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 2;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 1;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                }
            } else if (restnuevaposi == 6) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 4;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 3;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 2;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 1;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 0;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                }
            } else if (restnuevaposi == 5) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 3;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 2;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 1;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 0;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 0;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 33 y posicion 0
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                }
            } else if (restnuevaposi == 4) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 2;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 1;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 0;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 0;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 33 y posicion 0
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 1;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 34 y posicion 1
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                }
            } else if (restnuevaposi == 3) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 1;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 0;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 0;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 33 y posicion 0
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 1;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 34 y posicion 1
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 2;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 35 y posicion 2
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                }
            } else if (restnuevaposi == 2) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[5][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    restnuevaposi = 0;
                    jugador[4][restnuevaposi] = '@';
                    if (penalizaciones[4][restnuevaposi] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 0;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 33 y posicion 0
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 1;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 34 y posicion 1
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 2;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 35 y posicion 2
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 3;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 36 y posicion 3
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                }
            } else if (restnuevaposi == 1) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 0;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 33 y posicion 0
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 1;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 34 y posicion 1
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 2;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 35 y posicion 2
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 3;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 36 y posicion 3
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 4;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 37 y posicion 4
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                }
            } else if (restnuevaposi == 0) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 1;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 34 y posicion 1
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 2;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 35 y posicion 2
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 3;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 36 y posicion 3
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 4;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 37 y posicion 4
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 5;
                    jugador[3][posiQuinta] = '@';                         //aqui cae a la fila 3 y casilla 38 y posicion 5
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                    restnuevaposi = 8;
                }
            }
        } else if (restnuevaposi == 8 && posiQuinta > -1 && posiQuinta < 8) {               //Validaciones para la quinta fila ##################################################################
            if (posiQuinta == 0) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 2;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 3;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 4;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 5;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 6;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                }
            } else if (posiQuinta == 1) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 3;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 4;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 5;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 6;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 7;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                }
            } else if (posiQuinta == 2) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 4;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 5;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 6;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 7;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 7;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 41 posicion 7
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                }
            } else if (posiQuinta == 3) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 5;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 6;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 7;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 7;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 41 posicion 7
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 6;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 42 posicion 6
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                }
            } else if (posiQuinta == 4) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 6;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 7;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 7;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 41 posicion 7
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 6;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 42 posicion 6
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 5;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 43 posicion 5
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                }
            } else if (posiQuinta == 5) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[4][j] = ' ';
                    }
                    posiQuinta = 7;
                    jugador[3][posiQuinta] = '@';
                    if (penalizaciones[3][posiQuinta] == '#' && contpenalizaciones_intermedio < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_intermedia intermedia = new Operacion_intermedia();
                        contpenalizaciones_intermedio = contpenalizaciones_intermedio + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 7;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 41 posicion 7
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 6;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 42 posicion 6
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 5;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 43 posicion 5
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 4;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 44 posicion 4
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                }
            } else if (posiQuinta == 6) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 7;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 41 posicion 7
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 6;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 42 posicion 6
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 5;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 43 posicion 5
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 4;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 44 posicion 4
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 3;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 45 posicion 3
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                }
            } else if (posiQuinta == 7) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 6;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 42 posicion 6
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 5;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 43 posicion 5
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 4;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 44 posicion 4
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 3;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 45 posicion 3
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 2;
                    jugador[2][posiSexta] = '@';                             //aqui cae a la fila 2 casilla 46 posicion 2
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiQuinta = 8;
                }
            }
        } else if (posiQuinta == 8 && posiSexta > -1 && posiSexta < 8) {               //Validaciones para la sexta fila ##################################################################
            if (posiSexta == 7) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 5;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 4;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 3;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 2;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 1;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                }
            } else if (posiSexta == 6) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 4;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 3;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 2;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 1;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 0;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                }
            } else if (posiSexta == 5) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 3;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 2;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 1;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 0;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 0;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 49 posicion 0
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                }
            } else if (posiSexta == 4) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 2;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 1;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 0;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 0;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 49 posicion 0
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 1;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 50 posicion 1
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                }
            } else if (posiSexta == 3) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 1;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 0;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 0;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 49 posicion 0
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 1;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 50 posicion 1
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 2;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 51 posicion 2
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                }
            } else if (posiSexta == 2) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[3][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSexta = 0;
                    jugador[2][posiSexta] = '@';
                    if (penalizaciones[2][posiSexta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 0;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 49 posicion 0
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 1;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 50 posicion 1
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 2;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 51 posicion 2
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 3;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 52 posicion 3
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                }
            } else if (posiSexta == 1) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 0;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 49 posicion 0
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 1;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 50 posicion 1
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 2;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 51 posicion 2
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 3;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 52 posicion 3
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 4;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 53 posicion 4
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                }
            } else if (posiSexta == 0) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 1;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 50 posicion 1
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 2;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 51 posicion 2
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 3;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 52 posicion 3
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 4;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 53 posicion 4
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 5;
                    jugador[1][posiSeptima] = '@';                          //aqui cae a la fila 1 casilla 54 posicion 5
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSexta = 8;
                }
            }
        } else if (posiSexta == 8 && posiSeptima > -1 && posiSeptima < 8) {               //Validaciones para la septima fila ###########################
            if (posiSeptima == 0) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 2;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 3;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 4;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 5;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 6;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                }
            } else if (posiSeptima == 1) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 3;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 4;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 5;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 6;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 7;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                }
            } else if (posiSeptima == 2) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 4;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 5;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 6;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 7;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 7;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 57 y posicion 7
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                }
            } else if (posiSeptima == 3) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 5;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 6;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 7;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 7;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 57 y posicion 7
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 6;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 58 y posicion 6
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                }
            } else if (posiSeptima == 4) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 6;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 7;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 7;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 57 y posicion 7
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 6;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 58 y posicion 6
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 5;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 59 y posicion 5
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                }
            } else if (posiSeptima == 5) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[2][j] = ' ';
                    }
                    posiSeptima = 7;
                    jugador[1][posiSeptima] = '@';
                    if (penalizaciones[1][posiSeptima] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 7;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 57 y posicion 7
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 6;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 58 y posicion 6
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 5;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 59 y posicion 5
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 4;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 60 y posicion 4
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                }
            } else if (posiSeptima == 6) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 7;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 57 y posicion 7
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 6;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 58 y posicion 6
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 5;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 59 y posicion 5
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 4;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 60 y posicion 4
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 3;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 61 y posicion 3
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                }
            } else if (posiSeptima == 7) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 6;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 58 y posicion 6
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 5;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 59 y posicion 5
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 4;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 60 y posicion 4
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 3;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 61 y posicion 3
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 2;
                    jugador[0][posiOcta] = '@';                             //aqui cae a la fila 0 casilla 62 y posicion 2
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                    posiSeptima = 8;
                }
            }
        } else if (posiSeptima == 8 && posiOcta > -1 && posiOcta < 8) {               //Validaciones para la octava fila ###########################
            if (posiOcta == 7) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 5;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 4;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 3;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 2;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 1;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                }
            } else if (posiOcta == 6) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 4;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 3;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 2;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 1;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 0;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                }
            } else if (posiOcta == 5) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 3;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 2;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 1;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 5) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 0;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 8;
                    mensajeFinaljuego();
                }
            } else if (posiOcta == 4) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 2;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 1;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 4) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 0;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 5 || azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 8;
                    mensajeFinaljuego();
                }
            } else if (posiOcta == 3) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 1;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 0;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 4 || azar == 5 || azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 8;
                    mensajeFinaljuego();
                }
            } else if (posiOcta == 2) {
                if (azar == 2) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 0;
                    jugador[0][posiOcta] = '@';
                    if (penalizaciones[0][posiOcta] == '#' && contpenalizaciones_dificil < constante) {                     //Valua si existe penalizacion en esa posicion para imprimir la operacion
                        System.out.println("¡Haz caído en una penalizacion!");
                        Operacion_Dificil dificil = new Operacion_Dificil();
                        contpenalizaciones_dificil = contpenalizaciones_dificil + 1;
                    }
                } else if (azar == 3 || azar == 4 || azar == 5 || azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 8;
                    mensajeFinaljuego();
                }
            } else if (posiOcta == 1 || posiOcta == 0) {
                if (azar == 2 || azar == 3 || azar == 4 || azar == 5 || azar == 6) {
                    for (int j = 0; j < jugador.length; j++) {
                        jugador[1][j] = ' ';
                        jugador[0][j] = ' ';
                    }
                    posiOcta = 8;
                    mensajeFinaljuego();
                }
            }
        }
    }

    public void mensajeFinaljuego() throws FileNotFoundException {
        System.out.println("Felicidades ");
        System.out.println("Ha ganado la partida \n");
        MenuPrincipal m = new MenuPrincipal();
    }

    public void tableroDibujado() {

        System.out.println("\n-------------------------------------------------");
        System.out.println("|" + penalizaciones[0][0] + "  64|" + penalizaciones[0][1] + "  63|" + penalizaciones[0][2] + "  62|" + penalizaciones[0][3] + "  61|" + penalizaciones[0][4] + "  60|" + penalizaciones[0][5] + "  59|" + penalizaciones[0][6] + "  58|" + penalizaciones[0][7] + "  57|");
        System.out.println("|  " + jugador[0][0] + "  |  " + jugador[0][1] + "  |  " + jugador[0][2] + "  |  " + jugador[0][3] + "  |  " + jugador[0][4] + "  |  " + jugador[0][5] + "  |  " + jugador[0][6] + "  |  " + jugador[0][7] + "  |");
        System.out.println("-------------------------------------------------");
        System.out.println("|" + penalizaciones[1][0] + "  49|" + penalizaciones[1][1] + "  50|" + penalizaciones[1][2] + "  51|" + penalizaciones[1][3] + "  52|" + penalizaciones[1][4] + "  53|" + penalizaciones[1][5] + "  54|" + penalizaciones[1][6] + "  55|" + penalizaciones[1][7] + "  56|");
        System.out.println("|  " + jugador[1][0] + "  |  " + jugador[1][1] + "  |  " + jugador[1][2] + "  |  " + jugador[1][3] + "  |  " + jugador[1][4] + "  |  " + jugador[1][5] + "  |  " + jugador[1][6] + "  |  " + jugador[1][7] + "  |");
        System.out.println("-------------------------------------------------");
        System.out.println("|" + penalizaciones[2][0] + "  48|" + penalizaciones[2][1] + "  47|" + penalizaciones[2][2] + "  46|" + penalizaciones[2][3] + "  45|" + penalizaciones[2][4] + "  44|" + penalizaciones[2][5] + "  43|" + penalizaciones[2][6] + "  42|" + penalizaciones[2][7] + "  41|");
        System.out.println("|  " + jugador[2][0] + "  |  " + jugador[2][1] + "  |  " + jugador[2][2] + "  |  " + jugador[2][3] + "  |  " + jugador[2][4] + "  |  " + jugador[2][5] + "  |  " + jugador[2][6] + "  |  " + jugador[2][7] + "  |");
        System.out.println("-------------------------------------------------");
        System.out.println("|" + penalizaciones[3][0] + "  33|" + penalizaciones[3][1] + "  34|" + penalizaciones[3][2] + "  35|" + penalizaciones[3][3] + "  36|" + penalizaciones[3][4] + "  37|" + penalizaciones[3][5] + "  38|" + penalizaciones[3][6] + "  39|" + penalizaciones[3][7] + "  40|");
        System.out.println("|  " + jugador[3][0] + "  |  " + jugador[3][1] + "  |  " + jugador[3][2] + "  |  " + jugador[3][3] + "  |  " + jugador[3][4] + "  |  " + jugador[3][5] + "  |  " + jugador[3][6] + "  |  " + jugador[3][7] + "  |");
        System.out.println("-------------------------------------------------");
        System.out.println("|" + penalizaciones[4][0] + "  32|" + penalizaciones[4][1] + "  31|" + penalizaciones[4][2] + "  30|" + penalizaciones[4][3] + "  29|" + penalizaciones[4][4] + "  28|" + penalizaciones[4][5] + "  27|" + penalizaciones[4][6] + "  26|" + penalizaciones[4][7] + "  25|");
        System.out.println("|  " + jugador[4][0] + "  |  " + jugador[4][1] + "  |  " + jugador[4][2] + "  |  " + jugador[4][3] + "  |  " + jugador[4][4] + "  |  " + jugador[4][5] + "  |  " + jugador[4][6] + "  |  " + jugador[4][7] + "  |");
        System.out.println("-------------------------------------------------");
        System.out.println("|" + penalizaciones[5][0] + "  17|" + penalizaciones[5][1] + "  18|" + penalizaciones[5][2] + "  19|" + penalizaciones[5][3] + "  20|" + penalizaciones[5][4] + "  21|" + penalizaciones[5][5] + "  22|" + penalizaciones[5][6] + "  23|" + penalizaciones[5][7] + "  24|");
        System.out.println("|  " + jugador[5][0] + "  |  " + jugador[5][1] + "  |  " + jugador[5][2] + "  |  " + jugador[5][3] + "  |  " + jugador[5][4] + "  |  " + jugador[5][5] + "  |  " + jugador[5][6] + "  |  " + jugador[5][7] + "  |");
        System.out.println("-------------------------------------------------");
        System.out.println("|" + penalizaciones[6][0] + "  16|" + penalizaciones[6][1] + "  15|" + penalizaciones[6][2] + "  14|" + penalizaciones[6][3] + "  13|" + penalizaciones[6][4] + "  12|" + penalizaciones[6][5] + "  11|" + penalizaciones[6][6] + "  10|" + penalizaciones[6][7] + "   9|");
        System.out.println("|  " + jugador[6][0] + "  |  " + jugador[6][1] + "  |  " + jugador[6][2] + "  |  " + jugador[6][3] + "  |  " + jugador[6][4] + "  |  " + jugador[6][5] + "  |  " + jugador[6][6] + "  |  " + jugador[6][7] + "  |");
        System.out.println("-------------------------------------------------");
        System.out.println("|" + penalizaciones[7][0] + "   1|" + penalizaciones[7][1] + "   2|" + penalizaciones[7][2] + "   3|" + penalizaciones[7][3] + "   4|" + penalizaciones[7][4] + "   5|" + penalizaciones[7][5] + "   6|" + penalizaciones[7][6] + "   7|" + penalizaciones[7][7] + "   8|");
        System.out.println("|  " + jugador[7][0] + "  |  " + jugador[7][1] + "  |  " + jugador[7][2] + "  |  " + jugador[7][3] + "  |  " + jugador[7][4] + "  |  " + jugador[7][5] + "  |  " + jugador[7][6] + "  |  " + jugador[7][7] + "  |");
        System.out.println("-------------------------------------------------\n");

    }

    public void aleatorioSinrepetir() {
        int in = (int) (Math.random() * 3);                             // indice para ir sumando las iteraciones

        while (in < 3) {                            // Se ingresa al bucle de acuerdo al limite del indice y al limite del arreglo
            int alea = (int) (Math.random() * 3);  //elige valores de 0,1,2 
            boolean repe = false;                                    //indica que no hay nada repetido y si hay algo repetido cambia a true
            while (!repe) {                                          // valua si hay algo repetido ingresa al bucle
                for (int conta = 0; conta < in; conta++) {                // bucle para indicar que si hay algun numero repetido vuelva la variable a repetido a true
                    if (alea == valo[conta]) {      //si el valor de la posicion coincide con el valor del arreglo  es porque está repetido 
                        repe = true;                                   // cambia el valor a verdadero  
                        break;                                             // termina la ejecucion  
                    }
                }
                if (!repe) {                                           // si la variable no está repetida 
                    valo[in] = alea;                    // al arreglo le ingreso el valor aleatorio 
                    indice = valo[in];                             // a la nueva variable indice le guardo el valor de la variable
//                    ley_cosenos(alea);
                    in++;
                    //aumenta la unidad  del iterador
                }

            }
            break;
        }

    }

}
