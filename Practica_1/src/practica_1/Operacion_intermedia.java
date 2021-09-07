package practica_1;

public class Operacion_intermedia {
    Reporte_1 env =new Reporte_1();
    static int valo1[] = new int[3]; // Crea el arreglo con la cantidad de espacios para lo aleatorio
    static double[][] imatrizA1 = new double[5][5];
    static double[][] imatrizA2 = new double[5][5];
    static double[][] imatrizA3 = new double[5][5];
    static double[][] imatrizB1 = new double[5][5];
    static double[][] imatrizB2 = new double[5][5];
    static double[][] imatrizB3 = new double[5][5];
    static double[][] resultadosuma1 = new double[5][5];
    static double[][] resultadosuma2 = new double[5][5];
    static double[][] resultadosuma3 = new double[5][5];

    public Operacion_intermedia() {
        llenadoMatrices();
        aleatorioSinrepetir1();
//        suma_de_matrices();
    }

    public void aleatorioSinrepetir1() {
        int in = 0;                                 // indice para ir sumando las iteraciones

        while (in < valo1.length) {                            // Se ingresa al bucle de acuerdo al limite del indice y al limite del arreglo
            int alea1 = (int) (Math.random() * 3);  //elige valores de 0,1,2 
            boolean repe = false;                                    //indica que no hay nada repetido y si hay algo repetido cambia a true
            while (!repe) {                                          // valua si hay algo repetido ingresa al bucle
                for (int conta = 0; conta < in; conta++) {                // bucle para indicar que si hay algun numero repetido vuelva la variable a repetido a true
                    if (alea1 == valo1[conta]) {      //si el valor de la posicion coincide con el valor del arreglo  es porque está repetido 
                        repe = true;                                   // cambia el valor a verdadero  
                        break;                                             // termina la ejecucion  
                    }
                }
                if (!repe) {                                           // si la variable no está repetida 
                    valo1[in] = alea1;                    // al arreglo le ingreso el valor aleatorio 
                    int indice = valo1[in];                             // a la nueva variable indice le guardo el valor de la variable
                    suma_de_matrices(indice);
                    in++;                                              //aumenta la unidad  del iterador
                }
            }
            break;
        }
    }

    public void llenadoMatrices() {
        imatrizA1[0][0] = 7;   imatrizA1[0][1] = 48;   imatrizA1[0][2] = 5;   imatrizA1[0][3] = 0;  imatrizA1[0][4] = 1;
        imatrizA1[1][0] = 57;  imatrizA1[1][1] = 8;    imatrizA1[1][2] = 4;   imatrizA1[1][3] = 6;  imatrizA1[1][4] = 14;
        imatrizA1[2][0] = 0;   imatrizA1[2][1] = 5;    imatrizA1[2][2] = 6;   imatrizA1[2][3] = 78; imatrizA1[2][4] = 15;
        imatrizA1[3][0] = 21;  imatrizA1[3][1] = 14;   imatrizA1[3][2] = 8;   imatrizA1[3][3] = 19; imatrizA1[3][4] = 54;
        imatrizA1[4][0] = 32;  imatrizA1[4][1] = 20;   imatrizA1[4][2] = 26;  imatrizA1[4][3] = 47; imatrizA1[4][4] = 12;

        imatrizA2[0][0] = 4;   imatrizA2[0][1] = 9;    imatrizA2[0][2] = 7;   imatrizA2[0][3] = 45; imatrizA2[0][4] = 18;
        imatrizA2[1][0] = 7;   imatrizA2[1][1] = 51;   imatrizA2[1][2] = 26;  imatrizA2[1][3] = 8;  imatrizA2[1][4] = 38;
        imatrizA2[2][0] = 48;  imatrizA2[2][1] = 26;   imatrizA2[2][2] = 37;  imatrizA2[2][3] = 21; imatrizA2[2][4] = 19;
        imatrizA2[3][0] = 1;   imatrizA2[3][1] = 0;    imatrizA2[3][2] = 6;   imatrizA2[3][3] = 8;  imatrizA2[3][4] = 1;
        imatrizA2[4][0] = 2;   imatrizA2[4][1] = 19;   imatrizA2[4][2] = 55;  imatrizA2[4][3] = 25; imatrizA2[4][4] = 15;

        imatrizA3[0][0] = 0;   imatrizA3[0][1] = 1;    imatrizA3[0][2] = 15;  imatrizA3[0][3] = 5;  imatrizA3[0][4] = 36;
        imatrizA3[1][0] = 1;   imatrizA3[1][1] = 78;   imatrizA3[1][2] = 65;  imatrizA3[1][3] = 32; imatrizA3[1][4] = 4;
        imatrizA3[2][0] = 48;  imatrizA3[2][1] = 66;   imatrizA3[2][2] = 39;  imatrizA3[2][3] = 0;  imatrizA3[2][4] = 55;
        imatrizA3[3][0] = 14;  imatrizA3[3][1] = 98;   imatrizA3[3][2] = 63;  imatrizA3[3][3] = 20; imatrizA3[3][4] = 15;
        imatrizA3[4][0] = 11;  imatrizA3[4][1] = 39;   imatrizA3[4][2] = 84;  imatrizA3[4][3] = 7;  imatrizA3[4][4] = 1;

        imatrizB1[0][0] = 9;   imatrizB1[0][1] = 5;    imatrizB1[0][2] = 2;   imatrizB1[0][3] = 1;  imatrizB1[0][4] = 8;
        imatrizB1[1][0] = 4;   imatrizB1[1][1] = 2;    imatrizB1[1][2] = 3;   imatrizB1[1][3] = 47; imatrizB1[1][4] = 8;
        imatrizB1[2][0] = 48;  imatrizB1[2][1] = 55;   imatrizB1[2][2] = 32;  imatrizB1[2][3] = 19; imatrizB1[2][4] = 6;
        imatrizB1[3][0] = 7;   imatrizB1[3][1] = 56;   imatrizB1[3][2] = 32;  imatrizB1[3][3] = 14; imatrizB1[3][4] = 8;
        imatrizB1[4][0] = 32;  imatrizB1[4][1] = 87;   imatrizB1[4][2] = 0;   imatrizB1[4][3] = 1;  imatrizB1[4][4] = 7;

        imatrizB2[0][0] = 0;   imatrizB2[0][1] = 2;    imatrizB2[0][2] = 15;  imatrizB2[0][3] = 1;  imatrizB2[0][4] = 66;
        imatrizB2[1][0] = 21;  imatrizB2[1][1] = 48;   imatrizB2[1][2] = 62;  imatrizB2[1][3] = 7;  imatrizB2[1][4] = 33;
        imatrizB2[2][0] = 4;   imatrizB2[2][1] = 88;   imatrizB2[2][2] = 0;   imatrizB2[2][3] = 68; imatrizB2[2][4] = 4;
        imatrizB2[3][0] = 25;  imatrizB2[3][1] = 18;   imatrizB2[3][2] = 24;  imatrizB2[3][3] = 7;  imatrizB2[3][4] = 55;
        imatrizB2[4][0] = 24;  imatrizB2[4][1] = 15;   imatrizB2[4][2] = 36;  imatrizB2[4][3] = 5;  imatrizB2[4][4] = 98;

        imatrizB3[0][0] = 78;  imatrizB3[0][1] = 25;   imatrizB3[0][2] = 66;  imatrizB3[0][3] = 48; imatrizB3[0][4] = 98;
        imatrizB3[1][0] = 0;   imatrizB3[1][1] = 45;   imatrizB3[1][2] = 2;   imatrizB3[1][3] = 3;  imatrizB3[1][4] = 1;
        imatrizB3[2][0] = 2;   imatrizB3[2][1] = 9;    imatrizB3[2][2] = 14;  imatrizB3[2][3] = 10; imatrizB3[2][4] = 20;
        imatrizB3[3][0] = 35;  imatrizB3[3][1] = 87;   imatrizB3[3][2] = 65;  imatrizB3[3][3] = 2;  imatrizB3[3][4] = 32;
        imatrizB3[4][0] = 25;  imatrizB3[4][1] = 8;    imatrizB3[4][2] = 4;   imatrizB3[4][3] = 9;  imatrizB3[4][4] = 39;
       
    }

    public void suma_de_matrices(int indic) {
        //Suma de A+B

        switch (indic) {
            case 0:
                System.out.println("Opcion 1: Matriz A + B");
                for (int i = 0; i < resultadosuma1.length; i++) {
                    for (int j = 0; j < resultadosuma1.length; j++) {
                        resultadosuma1[i][j] = imatrizA1[i][j] + imatrizB1[i][j];
                    }
                }
                for (int i = 0; i < resultadosuma1.length; i++) {
                    for (int j = 0; j < resultadosuma1.length; j++) {
                        resultadosuma1[i][j] = (double) Math.round(resultadosuma1[i][j] * 1000d) / 1000;
                    }
                }
                System.out.println("\n");
                System.out.println("-------Matriz Resultado de la Suma-------");
                System.out.println("| " + resultadosuma1[0][0] + "   " + resultadosuma1[0][1] + "   " + resultadosuma1[0][2] + "   " + resultadosuma1[0][3] + "   " + resultadosuma1[0][4] + " |");
                System.out.println("| " + resultadosuma1[1][0] + "   " + resultadosuma1[1][1] + "   " + resultadosuma1[1][2] + "   " + resultadosuma1[1][3] + "   " + resultadosuma1[1][4] + " |");
                System.out.println("| " + resultadosuma1[2][0] + "   " + resultadosuma1[2][1] + "   " + resultadosuma1[2][2] + "   " + resultadosuma1[2][3] + "   " + resultadosuma1[2][4] + " |");
                System.out.println("| " + resultadosuma1[3][0] + "   " + resultadosuma1[3][1] + "   " + resultadosuma1[3][2] + "   " + resultadosuma1[3][3] + "   " + resultadosuma1[3][4] + " |");
                System.out.println("| " + resultadosuma1[4][0] + "   " + resultadosuma1[4][1] + "   " + resultadosuma1[4][2] + "   " + resultadosuma1[4][3] + "   " + resultadosuma1[4][4] + " |");
                System.out.println("\n");
                env.recibIntermedia1(imatrizA1, imatrizB1, resultadosuma1, indic);
                break;
            case 1:
                System.out.println("Opcion 2: Matriz A + B");
                for (int i = 0; i < resultadosuma2.length; i++) {
                    for (int j = 0; j < resultadosuma2.length; j++) {
                        resultadosuma2[i][j] = imatrizA2[i][j] + imatrizB2[i][j];
                    }
                }
                for (int i = 0; i < resultadosuma2.length; i++) {
                    for (int j = 0; j < resultadosuma2.length; j++) {
                        resultadosuma2[i][j] = (double) Math.round(resultadosuma2[i][j] * 1000d) / 1000;
                    }
                }

                System.out.println("\n");
                System.out.println("-------Matriz Resultado de la Suma-------");
                System.out.println("| " + resultadosuma2[0][0] + "   " + resultadosuma2[0][1] + "   " + resultadosuma2[0][2] + "   " + resultadosuma2[0][3] + "   " + resultadosuma2[0][4] + " |");
                System.out.println("| " + resultadosuma2[1][0] + "   " + resultadosuma2[1][1] + "   " + resultadosuma2[1][2] + "   " + resultadosuma2[1][3] + "   " + resultadosuma2[1][4] + " |");
                System.out.println("| " + resultadosuma2[2][0] + "   " + resultadosuma2[2][1] + "   " + resultadosuma2[2][2] + "   " + resultadosuma2[2][3] + "   " + resultadosuma2[2][4] + " |");
                System.out.println("| " + resultadosuma2[3][0] + "   " + resultadosuma2[3][1] + "   " + resultadosuma2[3][2] + "   " + resultadosuma2[3][3] + "   " + resultadosuma2[3][4] + " |");
                System.out.println("| " + resultadosuma2[4][0] + "   " + resultadosuma2[4][1] + "   " + resultadosuma2[4][2] + "   " + resultadosuma2[4][3] + "   " + resultadosuma2[4][4] + " |");
                System.out.println("\n");
                env.recibIntermedia2(imatrizA2, imatrizB2, resultadosuma2, indic);
                break;
            case 2:
                System.out.println("Opcion 3: Matriz A + B");
                for (int i = 0; i < resultadosuma3.length; i++) {
                    for (int j = 0; j < resultadosuma3.length; j++) {
                        resultadosuma3[i][j] = imatrizA3[i][j] + imatrizB3[i][j];
                    }
                }
                for (int i = 0; i < resultadosuma2.length; i++) {
                    for (int j = 0; j < resultadosuma2.length; j++) {
                        resultadosuma3[i][j] = (double) Math.round(resultadosuma3[i][j] * 1000d) / 1000;
                    }
                }
                System.out.println("\n");
                System.out.println("-------Matriz Resultado de la Suma-------");
                System.out.println("| " + resultadosuma3[0][0] + "   " + resultadosuma3[0][1] + "   " + resultadosuma3[0][2] + "   " + resultadosuma3[0][3] + "   " + resultadosuma3[0][4] + " |");
                System.out.println("| " + resultadosuma3[1][0] + "   " + resultadosuma3[1][1] + "   " + resultadosuma3[1][2] + "   " + resultadosuma3[1][3] + "   " + resultadosuma3[1][4] + " |");
                System.out.println("| " + resultadosuma3[2][0] + "   " + resultadosuma3[2][1] + "   " + resultadosuma3[2][2] + "   " + resultadosuma3[2][3] + "   " + resultadosuma3[2][4] + " |");
                System.out.println("| " + resultadosuma3[3][0] + "   " + resultadosuma3[3][1] + "   " + resultadosuma3[3][2] + "   " + resultadosuma3[3][3] + "   " + resultadosuma3[3][4] + " |");
                System.out.println("| " + resultadosuma3[4][0] + "   " + resultadosuma3[4][1] + "   " + resultadosuma3[4][2] + "   " + resultadosuma3[4][3] + "   " + resultadosuma3[4][4] + " |");
                System.out.println("\n");
                env.recibIntermedia3(imatrizA3, imatrizB3, resultadosuma3, indic);
                break;
            default:
                break;
        }
    }
}
