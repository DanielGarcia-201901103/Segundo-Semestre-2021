package practica_1;

public class Operacion_Dificil {
    
    Reporte_1 envi =new Reporte_1();
    int valo2[] = new int[3]; // Crea el arreglo con la cantidad de espacios para lo aleatorio
    double[][] matrizA1 = new double[4][4];
    double[][] matrizA2 = new double[4][4];
    double[][] matrizA3 = new double[4][4];
    double[][] matrizB1 = new double[4][4];
    double[][] matrizB2 = new double[4][4];
    double[][] matrizB3 = new double[4][4];
    double[][] resultadodivision = new double[4][4];
    double[][] resultadodivision1 = new double[4][4];
    double[][] resultadodivision2 = new double[4][4];
    double detB1, detB2, detB3;

    public Operacion_Dificil() {
        llenadoMatrices();
        aleatorioSinrepetir2();
//        division_de_matrices();
    }
     public void aleatorioSinrepetir2() {
        int in = 0;                                 // indice para ir sumando las iteraciones

        while (in < valo2.length) {                            // Se ingresa al bucle de acuerdo al limite del indice y al limite del arreglo
            int alea1 = (int) (Math.random() * 3);  //elige valores de 0,1,2 
            boolean repe = false;                                    //indica que no hay nada repetido y si hay algo repetido cambia a true
            while (!repe) {                                          // valua si hay algo repetido ingresa al bucle
                for (int conta = 0; conta < in; conta++) {                // bucle para indicar que si hay algun numero repetido vuelva la variable a repetido a true
                    if (alea1 == valo2[conta]) {      //si el valor de la posicion coincide con el valor del arreglo  es porque está repetido 
                        repe = true;                                   // cambia el valor a verdadero  
                        break;                                             // termina la ejecucion  
                    }
                }
                if (!repe) {                                           // si la variable no está repetida 
                    valo2[in] = alea1;                    // al arreglo le ingreso el valor aleatorio 
                    int indi = valo2[in];                             // a la nueva variable indice le guardo el valor de la variable
                    division_de_matrices(indi);
                    in++;                                              //aumenta la unidad  del iterador
                }
            }
            break;
        }
    }

    public void llenadoMatrices() {
        matrizA1[0][0] = 5;     matrizA1[0][1] = 10;    matrizA1[0][2] = 1;     matrizA1[0][3] = 3;
        matrizA1[1][0] = 9;     matrizA1[1][1] = 14;    matrizA1[1][2] = 2;     matrizA1[1][3] = 6;
        matrizA1[2][0] = 7;     matrizA1[2][1] = 8;     matrizA1[2][2] = 15;    matrizA1[2][3] = 3;
        matrizA1[3][0] = 6;     matrizA1[3][1] = 8;     matrizA1[3][2] = 9;     matrizA1[3][3] = 2;
        
        matrizA2[0][0] = 1;     matrizA2[0][1] = 12;    matrizA2[0][2] = 9;     matrizA2[0][3] = 8;
        matrizA2[1][0] = 7;     matrizA2[1][1] = 6;     matrizA2[1][2] = 3;     matrizA2[1][3] = 2;
        matrizA2[2][0] = 0;     matrizA2[2][1] = 5;     matrizA2[2][2] = 6;     matrizA2[2][3] = 14;
        matrizA2[3][0] = 6;     matrizA2[3][1] = 9;     matrizA2[3][2] = 6;     matrizA2[3][3] = 10;
        
        matrizA3[0][0] = 5;     matrizA3[0][1] = 9;     matrizA3[0][2] = 14;    matrizA3[0][3] = 5;
        matrizA3[1][0] = 6;     matrizA3[1][1] = 0;     matrizA3[1][2] = 5;     matrizA3[1][3] = 3;
        matrizA3[2][0] = 1;     matrizA3[2][1] = 14;    matrizA3[2][2] = 68;    matrizA3[2][3] = 8;
        matrizA3[3][0] = 7;     matrizA3[3][1] = 5;     matrizA3[3][2] = 3;     matrizA3[3][3] = 9;
        
        matrizB1[0][0] = 5;     matrizB1[0][1] = 13;    matrizB1[0][2] = 9;     matrizB1[0][3] = 4;
        matrizB1[1][0] = 1;     matrizB1[1][1] = 9;     matrizB1[1][2] = 6;     matrizB1[1][3] = 3;
        matrizB1[2][0] = 8;     matrizB1[2][1] = 11;    matrizB1[2][2] = 69;    matrizB1[2][3] = 33;
        matrizB1[3][0] = 25;    matrizB1[3][1] = 6;     matrizB1[3][2] = 7;     matrizB1[3][3] = 4;
        
        matrizB2[0][0] = 8;     matrizB2[0][1] = 19;    matrizB2[0][2] = 20;    matrizB2[0][3] = 4;
        matrizB2[1][0] = 12;    matrizB2[1][1] = 33;    matrizB2[1][2] = 6;     matrizB2[1][3] = 8;
        matrizB2[2][0] = 4;     matrizB2[2][1] = 5;     matrizB2[2][2] = 9;     matrizB2[2][3] = 7;
        matrizB2[3][0] = 8;     matrizB2[3][1] = 22;    matrizB2[3][2] = 14;    matrizB2[3][3] = 6;
        
        matrizB3[0][0] = 0;     matrizB3[0][1] = 9;     matrizB3[0][2] = 7;     matrizB3[0][3] = 19;
        matrizB3[1][0] = 2;     matrizB3[1][1] = 30;    matrizB3[1][2] = 5;     matrizB3[1][3] = 48;
        matrizB3[2][0] = 1;     matrizB3[2][1] = 31;    matrizB3[2][2] = 2;     matrizB3[2][3] = 5;
        matrizB3[3][0] = 15;    matrizB3[3][1] = 8;     matrizB3[3][2] = 4;     matrizB3[3][3] = 3; 
    }
    
    public void division_de_matrices(int indice1) {
        //Dividir matriz A/B
        //Determinante de las matrices B
        detB1 = matrizB1[0][0] * ((matrizB1[1][1] * matrizB1[2][2] * matrizB1[3][3]) + (matrizB1[1][2] * matrizB1[2][3] * matrizB1[3][1]) + (matrizB1[2][1] * matrizB1[3][2] * matrizB1[1][3])
                - ((matrizB1[3][1] * matrizB1[2][2] * matrizB1[1][3]) + (matrizB1[3][2] * matrizB1[2][3] * matrizB1[1][1]) + (matrizB1[2][1] * matrizB1[1][2] * matrizB1[3][3])))
                - (matrizB1[1][0] * ((matrizB1[0][1] * matrizB1[2][2] * matrizB1[3][3]) + (matrizB1[0][2] * matrizB1[2][3] * matrizB1[3][1]) + (matrizB1[2][1] * matrizB1[3][2] * matrizB1[0][3])
                - ((matrizB1[3][1] * matrizB1[2][2] * matrizB1[0][3]) + (matrizB1[3][2] * matrizB1[2][3] * matrizB1[0][1]) + (matrizB1[2][1] * matrizB1[0][2] * matrizB1[3][3]))))
                + matrizB1[2][0] * ((matrizB1[0][1] * matrizB1[1][2] * matrizB1[3][3]) + (matrizB1[0][2] * matrizB1[1][3] * matrizB1[3][1]) + (matrizB1[1][1] * matrizB1[3][2] * matrizB1[0][3])
                - ((matrizB1[3][1] * matrizB1[1][2] * matrizB1[0][3]) + (matrizB1[3][2] * matrizB1[1][3] * matrizB1[0][1]) + (matrizB1[1][1] * matrizB1[0][2] * matrizB1[3][3])))
                - (matrizB1[3][0] * ((matrizB1[0][1] * matrizB1[1][2] * matrizB1[2][3]) + (matrizB1[0][2] * matrizB1[1][3] * matrizB1[2][1]) + (matrizB1[1][1] * matrizB1[2][2] * matrizB1[0][3])
                - ((matrizB1[2][1] * matrizB1[1][2] * matrizB1[0][3]) + (matrizB1[2][2] * matrizB1[1][3] * matrizB1[0][1]) + (matrizB1[1][1] * matrizB1[0][2] * matrizB1[2][3]))));
        detB2 = matrizB2[0][0] * ((matrizB2[1][1] * matrizB2[2][2] * matrizB2[3][3]) + (matrizB2[1][2] * matrizB2[2][3] * matrizB2[3][1]) + (matrizB2[2][1] * matrizB2[3][2] * matrizB2[1][3])
                - ((matrizB2[3][1] * matrizB2[2][2] * matrizB2[1][3]) + (matrizB2[3][2] * matrizB2[2][3] * matrizB2[1][1]) + (matrizB2[2][1] * matrizB2[1][2] * matrizB2[3][3])))
                - (matrizB2[1][0] * ((matrizB2[0][1] * matrizB2[2][2] * matrizB2[3][3]) + (matrizB2[0][2] * matrizB2[2][3] * matrizB2[3][1]) + (matrizB2[2][1] * matrizB2[3][2] * matrizB2[0][3])
                - ((matrizB2[3][1] * matrizB2[2][2] * matrizB2[0][3]) + (matrizB2[3][2] * matrizB2[2][3] * matrizB2[0][1]) + (matrizB2[2][1] * matrizB2[0][2] * matrizB2[3][3]))))
                + matrizB2[2][0] * ((matrizB2[0][1] * matrizB2[1][2] * matrizB2[3][3]) + (matrizB2[0][2] * matrizB2[1][3] * matrizB2[3][1]) + (matrizB2[1][1] * matrizB2[3][2] * matrizB2[0][3])
                - ((matrizB2[3][1] * matrizB2[1][2] * matrizB2[0][3]) + (matrizB2[3][2] * matrizB2[1][3] * matrizB2[0][1]) + (matrizB2[1][1] * matrizB2[0][2] * matrizB2[3][3])))
                - (matrizB2[3][0] * ((matrizB2[0][1] * matrizB2[1][2] * matrizB2[2][3]) + (matrizB2[0][2] * matrizB2[1][3] * matrizB2[2][1]) + (matrizB2[1][1] * matrizB2[2][2] * matrizB2[0][3])
                - ((matrizB2[2][1] * matrizB2[1][2] * matrizB2[0][3]) + (matrizB2[2][2] * matrizB2[1][3] * matrizB2[0][1]) + (matrizB2[1][1] * matrizB2[0][2] * matrizB2[2][3]))));
        detB3 = matrizB3[0][0] * ((matrizB3[1][1] * matrizB3[2][2] * matrizB3[3][3]) + (matrizB3[1][2] * matrizB3[2][3] * matrizB3[3][1]) + (matrizB3[2][1] * matrizB3[3][2] * matrizB3[1][3])
                - ((matrizB3[3][1] * matrizB3[2][2] * matrizB3[1][3]) + (matrizB3[3][2] * matrizB3[2][3] * matrizB3[1][1]) + (matrizB3[2][1] * matrizB3[1][2] * matrizB3[3][3])))
                - (matrizB3[1][0] * ((matrizB3[0][1] * matrizB3[2][2] * matrizB3[3][3]) + (matrizB3[0][2] * matrizB3[2][3] * matrizB3[3][1]) + (matrizB3[2][1] * matrizB3[3][2] * matrizB3[0][3])
                - ((matrizB3[3][1] * matrizB3[2][2] * matrizB3[0][3]) + (matrizB3[3][2] * matrizB3[2][3] * matrizB3[0][1]) + (matrizB3[2][1] * matrizB3[0][2] * matrizB3[3][3]))))
                + matrizB3[2][0] * ((matrizB3[0][1] * matrizB3[1][2] * matrizB3[3][3]) + (matrizB3[0][2] * matrizB3[1][3] * matrizB3[3][1]) + (matrizB3[1][1] * matrizB3[3][2] * matrizB3[0][3])
                - ((matrizB3[3][1] * matrizB3[1][2] * matrizB3[0][3]) + (matrizB3[3][2] * matrizB3[1][3] * matrizB3[0][1]) + (matrizB3[1][1] * matrizB3[0][2] * matrizB3[3][3])))
                - (matrizB3[3][0] * ((matrizB3[0][1] * matrizB3[1][2] * matrizB3[2][3]) + (matrizB3[0][2] * matrizB3[1][3] * matrizB3[2][1]) + (matrizB3[1][1] * matrizB3[2][2] * matrizB3[0][3])
                - ((matrizB3[2][1] * matrizB3[1][2] * matrizB3[0][3]) + (matrizB3[2][2] * matrizB3[1][3] * matrizB3[0][1]) + (matrizB3[1][1] * matrizB3[0][2] * matrizB3[2][3]))));
        // ADJUNTA
        double[][] maAdjB1 = new double[4][4];
        //para primera fila de la adjunta
        maAdjB1[0][0] = (matrizB1[1][1] * matrizB1[2][2] * matrizB1[3][3]) + (matrizB1[1][2] * matrizB1[2][3] * matrizB1[3][1]) + (matrizB1[2][1] * matrizB1[3][2] * matrizB1[1][3])
                - ((matrizB1[3][1] * matrizB1[2][2] * matrizB1[1][3]) + (matrizB1[3][2] * matrizB1[2][3] * matrizB1[1][1]) + (matrizB1[2][1] * matrizB1[1][2] * matrizB1[3][3]));

        maAdjB1[0][1] = (-1) * ((matrizB1[1][0] * matrizB1[2][2] * matrizB1[3][3]) + (matrizB1[1][2] * matrizB1[2][3] * matrizB1[3][0]) + (matrizB1[2][0] * matrizB1[3][2] * matrizB1[1][3])
                - ((matrizB1[3][0] * matrizB1[2][2] * matrizB1[1][3]) + (matrizB1[3][2] * matrizB1[2][3] * matrizB1[1][0]) + (matrizB1[2][0] * matrizB1[1][2] * matrizB1[3][3])));

        maAdjB1[0][2] = (matrizB1[1][0] * matrizB1[2][1] * matrizB1[3][3]) + (matrizB1[1][1] * matrizB1[2][3] * matrizB1[3][0]) + (matrizB1[2][0] * matrizB1[3][1] * matrizB1[1][3])
                - ((matrizB1[3][0] * matrizB1[2][1] * matrizB1[1][3]) + (matrizB1[2][3] * matrizB1[3][1] * matrizB1[1][0]) + (matrizB1[2][0] * matrizB1[1][1] * matrizB1[3][3]));

        maAdjB1[0][3] = (-1) * ((matrizB1[1][0] * matrizB1[2][1] * matrizB1[3][2]) + (matrizB1[1][1] * matrizB1[2][2] * matrizB1[3][0]) + (matrizB1[2][0] * matrizB1[3][1] * matrizB1[1][2])
                - ((matrizB1[3][0] * matrizB1[2][1] * matrizB1[1][2]) + (matrizB1[3][1] * matrizB1[2][2] * matrizB1[1][0]) + (matrizB1[1][1] * matrizB1[2][0] * matrizB1[3][2])));

        //para segunda fila de la adjunta
        maAdjB1[1][0] = (-1) * ((matrizB1[0][1] * matrizB1[2][2] * matrizB1[3][3]) + (matrizB1[0][2] * matrizB1[2][3] * matrizB1[3][1]) + (matrizB1[2][1] * matrizB1[3][2] * matrizB1[0][3])
                - ((matrizB1[3][1] * matrizB1[2][2] * matrizB1[0][3]) + (matrizB1[3][2] * matrizB1[2][3] * matrizB1[0][1]) + (matrizB1[0][2] * matrizB1[2][1] * matrizB1[3][3])));

        maAdjB1[1][1] = (matrizB1[0][0] * matrizB1[2][2] * matrizB1[3][3]) + (matrizB1[0][2] * matrizB1[2][3] * matrizB1[3][0]) + (matrizB1[2][0] * matrizB1[3][2] * matrizB1[0][3])
                - ((matrizB1[3][0] * matrizB1[2][2] * matrizB1[0][3]) + (matrizB1[2][3] * matrizB1[3][2] * matrizB1[0][0]) + (matrizB1[2][0] * matrizB1[0][2] * matrizB1[3][3]));

        maAdjB1[1][2] = (-1) * ((matrizB1[0][0] * matrizB1[2][1] * matrizB1[3][3]) + (matrizB1[0][1] * matrizB1[2][3] * matrizB1[3][0]) + (matrizB1[2][0] * matrizB1[3][1] * matrizB1[0][3])
                - ((matrizB1[3][0] * matrizB1[2][1] * matrizB1[0][3]) + (matrizB1[2][3] * matrizB1[3][1] * matrizB1[0][0]) + (matrizB1[2][0] * matrizB1[0][1] * matrizB1[3][3])));

        maAdjB1[1][3] = (matrizB1[0][0] * matrizB1[2][1] * matrizB1[3][2]) + (matrizB1[0][1] * matrizB1[2][2] * matrizB1[3][0]) + (matrizB1[2][0] * matrizB1[3][1] * matrizB1[0][2])
                - ((matrizB1[3][0] * matrizB1[2][1] * matrizB1[0][2]) + (matrizB1[2][2] * matrizB1[3][1] * matrizB1[0][0]) + (matrizB1[0][1] * matrizB1[2][0] * matrizB1[3][2]));

        //para tercera fila
        maAdjB1[2][0] = (matrizB1[0][1] * matrizB1[1][2] * matrizB1[3][3]) + (matrizB1[0][2] * matrizB1[1][3] * matrizB1[3][1]) + (matrizB1[1][1] * matrizB1[3][2] * matrizB1[0][3])
                - ((matrizB1[3][1] * matrizB1[1][2] * matrizB1[0][3]) + (matrizB1[1][3] * matrizB1[3][2] * matrizB1[0][1]) + (matrizB1[1][1] * matrizB1[0][2] * matrizB1[3][3]));

        maAdjB1[2][1] = (-1) * ((matrizB1[0][0] * matrizB1[1][2] * matrizB1[3][3]) + (matrizB1[0][2] * matrizB1[1][3] * matrizB1[3][0]) + (matrizB1[1][0] * matrizB1[3][2] * matrizB1[0][3])
                - ((matrizB1[3][0] * matrizB1[1][2] * matrizB1[0][3]) + (matrizB1[3][2] * matrizB1[1][3] * matrizB1[0][0]) + (matrizB1[1][0] * matrizB1[0][2] * matrizB1[3][3])));

        maAdjB1[2][2] = (matrizB1[0][0] * matrizB1[1][1] * matrizB1[3][3]) + (matrizB1[0][1] * matrizB1[1][3] * matrizB1[3][0]) + (matrizB1[1][0] * matrizB1[3][1] * matrizB1[0][3])
                - ((matrizB1[3][0] * matrizB1[1][1] * matrizB1[0][3]) + (matrizB1[3][1] * matrizB1[1][3] * matrizB1[0][0]) + (matrizB1[1][0] * matrizB1[0][1] * matrizB1[3][3]));

        maAdjB1[2][3] = (-1) * ((matrizB1[0][0] * matrizB1[1][1] * matrizB1[3][2]) + (matrizB1[0][1] * matrizB1[1][2] * matrizB1[3][0]) + (matrizB1[1][0] * matrizB1[3][1] * matrizB1[0][2])
                - ((matrizB1[3][0] * matrizB1[1][1] * matrizB1[0][2]) + (matrizB1[3][1] * matrizB1[1][2] * matrizB1[0][0]) + (matrizB1[1][0] * matrizB1[0][1] * matrizB1[3][2])));

        //para cuarta fila
        maAdjB1[3][0] = (-1) * ((matrizB1[0][1] * matrizB1[1][2] * matrizB1[2][3]) + (matrizB1[0][2] * matrizB1[1][3] * matrizB1[2][1]) + (matrizB1[1][1] * matrizB1[2][2] * matrizB1[0][3])
                - ((matrizB1[2][1] * matrizB1[1][2] * matrizB1[0][3]) + (matrizB1[2][2] * matrizB1[1][3] * matrizB1[0][1]) + (matrizB1[1][1] * matrizB1[0][2] * matrizB1[2][3])));

        maAdjB1[3][1] = (matrizB1[0][0] * matrizB1[1][2] * matrizB1[2][3]) + (matrizB1[0][2] * matrizB1[1][3] * matrizB1[2][0]) + (matrizB1[1][0] * matrizB1[2][2] * matrizB1[0][3])
                - ((matrizB1[2][0] * matrizB1[1][2] * matrizB1[0][3]) + (matrizB1[2][2] * matrizB1[1][3] * matrizB1[0][0]) + (matrizB1[1][0] * matrizB1[0][2] * matrizB1[2][3]));

        maAdjB1[3][2] = (-1) * ((matrizB1[0][0] * matrizB1[1][1] * matrizB1[2][3]) + (matrizB1[0][1] * matrizB1[1][3] * matrizB1[2][0]) + (matrizB1[1][0] * matrizB1[2][1] * matrizB1[0][3])
                - ((matrizB1[2][0] * matrizB1[1][1] * matrizB1[0][3]) + (matrizB1[2][1] * matrizB1[1][3] * matrizB1[0][0]) + (matrizB1[1][0] * matrizB1[0][1] * matrizB1[2][3])));

        maAdjB1[3][3] = (matrizB1[0][0] * matrizB1[1][1] * matrizB1[2][2]) + (matrizB1[0][1] * matrizB1[1][2] * matrizB1[2][0]) + (matrizB1[1][0] * matrizB1[2][1] * matrizB1[0][2])
                - ((matrizB1[2][0] * matrizB1[1][1] * matrizB1[0][2]) + (matrizB1[2][1] * matrizB1[1][2] * matrizB1[0][0]) + (matrizB1[0][1] * matrizB1[1][0] * matrizB1[2][2]));

        double[][] maAdjB2 = new double[4][4];
        //para primera fila de la adjunta
        maAdjB2[0][0] = (matrizB2[1][1] * matrizB2[2][2] * matrizB2[3][3]) + (matrizB2[1][2] * matrizB2[2][3] * matrizB2[3][1]) + (matrizB2[2][1] * matrizB2[3][2] * matrizB2[1][3])
                - ((matrizB2[3][1] * matrizB2[2][2] * matrizB2[1][3]) + (matrizB2[3][2] * matrizB2[2][3] * matrizB2[1][1]) + (matrizB2[2][1] * matrizB2[1][2] * matrizB2[3][3]));

        maAdjB2[0][1] = (-1) * ((matrizB2[1][0] * matrizB2[2][2] * matrizB2[3][3]) + (matrizB2[1][2] * matrizB2[2][3] * matrizB2[3][0]) + (matrizB2[2][0] * matrizB2[3][2] * matrizB2[1][3])
                - ((matrizB2[3][0] * matrizB2[2][2] * matrizB2[1][3]) + (matrizB2[3][2] * matrizB2[2][3] * matrizB2[1][0]) + (matrizB2[2][0] * matrizB2[1][2] * matrizB2[3][3])));

        maAdjB2[0][2] = (matrizB2[1][0] * matrizB2[2][1] * matrizB2[3][3]) + (matrizB2[1][1] * matrizB2[2][3] * matrizB2[3][0]) + (matrizB2[2][0] * matrizB2[3][1] * matrizB2[1][3])
                - ((matrizB2[3][0] * matrizB2[2][1] * matrizB2[1][3]) + (matrizB2[2][3] * matrizB2[3][1] * matrizB2[1][0]) + (matrizB2[2][0] * matrizB2[1][1] * matrizB2[3][3]));

        maAdjB2[0][3] = (-1) * ((matrizB2[1][0] * matrizB2[2][1] * matrizB2[3][2]) + (matrizB2[1][1] * matrizB2[2][2] * matrizB2[3][0]) + (matrizB2[2][0] * matrizB2[3][1] * matrizB2[1][2])
                - ((matrizB2[3][0] * matrizB2[2][1] * matrizB2[1][2]) + (matrizB2[3][1] * matrizB2[2][2] * matrizB2[1][0]) + (matrizB2[1][1] * matrizB2[2][0] * matrizB2[3][2])));

        //para segunda fila de la adjunta
        maAdjB2[1][0] = (-1) * ((matrizB2[0][1] * matrizB2[2][2] * matrizB2[3][3]) + (matrizB2[0][2] * matrizB2[2][3] * matrizB2[3][1]) + (matrizB2[2][1] * matrizB2[3][2] * matrizB2[0][3])
                - ((matrizB2[3][1] * matrizB2[2][2] * matrizB2[0][3]) + (matrizB2[3][2] * matrizB2[2][3] * matrizB2[0][1]) + (matrizB2[0][2] * matrizB2[2][1] * matrizB2[3][3])));

        maAdjB2[1][1] = (matrizB2[0][0] * matrizB2[2][2] * matrizB2[3][3]) + (matrizB2[0][2] * matrizB2[2][3] * matrizB2[3][0]) + (matrizB2[2][0] * matrizB2[3][2] * matrizB2[0][3])
                - ((matrizB2[3][0] * matrizB2[2][2] * matrizB2[0][3]) + (matrizB2[2][3] * matrizB2[3][2] * matrizB2[0][0]) + (matrizB2[2][0] * matrizB2[0][2] * matrizB2[3][3]));

        maAdjB2[1][2] = (-1) * ((matrizB2[0][0] * matrizB2[2][1] * matrizB2[3][3]) + (matrizB2[0][1] * matrizB2[2][3] * matrizB2[3][0]) + (matrizB2[2][0] * matrizB2[3][1] * matrizB2[0][3])
                - ((matrizB2[3][0] * matrizB2[2][1] * matrizB2[0][3]) + (matrizB2[2][3] * matrizB2[3][1] * matrizB2[0][0]) + (matrizB2[2][0] * matrizB2[0][1] * matrizB2[3][3])));

        maAdjB2[1][3] = (matrizB2[0][0] * matrizB2[2][1] * matrizB2[3][2]) + (matrizB2[0][1] * matrizB2[2][2] * matrizB2[3][0]) + (matrizB2[2][0] * matrizB2[3][1] * matrizB2[0][2])
                - ((matrizB2[3][0] * matrizB2[2][1] * matrizB2[0][2]) + (matrizB2[2][2] * matrizB2[3][1] * matrizB2[0][0]) + (matrizB2[0][1] * matrizB2[2][0] * matrizB2[3][2]));

        //para tercera fila
        maAdjB2[2][0] = (matrizB2[0][1] * matrizB2[1][2] * matrizB2[3][3]) + (matrizB2[0][2] * matrizB2[1][3] * matrizB2[3][1]) + (matrizB2[1][1] * matrizB2[3][2] * matrizB2[0][3])
                - ((matrizB2[3][1] * matrizB2[1][2] * matrizB2[0][3]) + (matrizB2[1][3] * matrizB2[3][2] * matrizB2[0][1]) + (matrizB2[1][1] * matrizB2[0][2] * matrizB2[3][3]));

        maAdjB2[2][1] = (-1) * ((matrizB2[0][0] * matrizB2[1][2] * matrizB2[3][3]) + (matrizB2[0][2] * matrizB2[1][3] * matrizB2[3][0]) + (matrizB2[1][0] * matrizB2[3][2] * matrizB2[0][3])
                - ((matrizB2[3][0] * matrizB2[1][2] * matrizB2[0][3]) + (matrizB2[3][2] * matrizB2[1][3] * matrizB2[0][0]) + (matrizB2[1][0] * matrizB2[0][2] * matrizB2[3][3])));

        maAdjB2[2][2] = (matrizB2[0][0] * matrizB2[1][1] * matrizB2[3][3]) + (matrizB2[0][1] * matrizB2[1][3] * matrizB2[3][0]) + (matrizB2[1][0] * matrizB2[3][1] * matrizB2[0][3])
                - ((matrizB2[3][0] * matrizB2[1][1] * matrizB2[0][3]) + (matrizB2[3][1] * matrizB2[1][3] * matrizB2[0][0]) + (matrizB2[1][0] * matrizB2[0][1] * matrizB2[3][3]));

        maAdjB2[2][3] = (-1) * ((matrizB2[0][0] * matrizB2[1][1] * matrizB2[3][2]) + (matrizB2[0][1] * matrizB2[1][2] * matrizB2[3][0]) + (matrizB2[1][0] * matrizB2[3][1] * matrizB2[0][2])
                - ((matrizB2[3][0] * matrizB2[1][1] * matrizB2[0][2]) + (matrizB2[3][1] * matrizB2[1][2] * matrizB2[0][0]) + (matrizB2[1][0] * matrizB2[0][1] * matrizB2[3][2])));

        //para cuarta fila
        maAdjB2[3][0] = (-1) * ((matrizB2[0][1] * matrizB2[1][2] * matrizB2[2][3]) + (matrizB2[0][2] * matrizB2[1][3] * matrizB2[2][1]) + (matrizB2[1][1] * matrizB2[2][2] * matrizB2[0][3])
                - ((matrizB2[2][1] * matrizB2[1][2] * matrizB2[0][3]) + (matrizB2[2][2] * matrizB2[1][3] * matrizB2[0][1]) + (matrizB2[1][1] * matrizB2[0][2] * matrizB2[2][3])));

        maAdjB2[3][1] = (matrizB2[0][0] * matrizB2[1][2] * matrizB2[2][3]) + (matrizB2[0][2] * matrizB2[1][3] * matrizB2[2][0]) + (matrizB2[1][0] * matrizB2[2][2] * matrizB2[0][3])
                - ((matrizB2[2][0] * matrizB2[1][2] * matrizB2[0][3]) + (matrizB2[2][2] * matrizB2[1][3] * matrizB2[0][0]) + (matrizB2[1][0] * matrizB2[0][2] * matrizB2[2][3]));

        maAdjB2[3][2] = (-1) * ((matrizB2[0][0] * matrizB2[1][1] * matrizB2[2][3]) + (matrizB2[0][1] * matrizB2[1][3] * matrizB2[2][0]) + (matrizB2[1][0] * matrizB2[2][1] * matrizB2[0][3])
                - ((matrizB2[2][0] * matrizB2[1][1] * matrizB2[0][3]) + (matrizB2[2][1] * matrizB2[1][3] * matrizB2[0][0]) + (matrizB2[1][0] * matrizB2[0][1] * matrizB2[2][3])));

        maAdjB2[3][3] = (matrizB2[0][0] * matrizB2[1][1] * matrizB2[2][2]) + (matrizB2[0][1] * matrizB2[1][2] * matrizB2[2][0]) + (matrizB2[1][0] * matrizB2[2][1] * matrizB2[0][2])
                - ((matrizB2[2][0] * matrizB2[1][1] * matrizB2[0][2]) + (matrizB2[2][1] * matrizB2[1][2] * matrizB2[0][0]) + (matrizB2[0][1] * matrizB2[1][0] * matrizB2[2][2]));

        double[][] maAdjB3 = new double[4][4];
        //para primera fila de la adjunta
        maAdjB3[0][0] = (matrizB3[1][1] * matrizB3[2][2] * matrizB3[3][3]) + (matrizB3[1][2] * matrizB3[2][3] * matrizB3[3][1]) + (matrizB3[2][1] * matrizB3[3][2] * matrizB3[1][3])
                - ((matrizB3[3][1] * matrizB3[2][2] * matrizB3[1][3]) + (matrizB3[3][2] * matrizB3[2][3] * matrizB3[1][1]) + (matrizB3[2][1] * matrizB3[1][2] * matrizB3[3][3]));

        maAdjB3[0][1] = (-1) * ((matrizB3[1][0] * matrizB3[2][2] * matrizB3[3][3]) + (matrizB3[1][2] * matrizB3[2][3] * matrizB3[3][0]) + (matrizB3[2][0] * matrizB3[3][2] * matrizB3[1][3])
                - ((matrizB3[3][0] * matrizB3[2][2] * matrizB3[1][3]) + (matrizB3[3][2] * matrizB3[2][3] * matrizB3[1][0]) + (matrizB3[2][0] * matrizB3[1][2] * matrizB3[3][3])));

        maAdjB3[0][2] = (matrizB3[1][0] * matrizB3[2][1] * matrizB3[3][3]) + (matrizB3[1][1] * matrizB3[2][3] * matrizB3[3][0]) + (matrizB3[2][0] * matrizB3[3][1] * matrizB3[1][3])
                - ((matrizB3[3][0] * matrizB3[2][1] * matrizB3[1][3]) + (matrizB3[2][3] * matrizB3[3][1] * matrizB3[1][0]) + (matrizB3[2][0] * matrizB3[1][1] * matrizB3[3][3]));

        maAdjB3[0][3] = (-1) * ((matrizB3[1][0] * matrizB3[2][1] * matrizB3[3][2]) + (matrizB3[1][1] * matrizB3[2][2] * matrizB3[3][0]) + (matrizB3[2][0] * matrizB3[3][1] * matrizB3[1][2])
                - ((matrizB3[3][0] * matrizB3[2][1] * matrizB3[1][2]) + (matrizB3[3][1] * matrizB3[2][2] * matrizB3[1][0]) + (matrizB3[1][1] * matrizB3[2][0] * matrizB3[3][2])));

        //para segunda fila de la adjunta
        maAdjB3[1][0] = (-1) * ((matrizB3[0][1] * matrizB3[2][2] * matrizB3[3][3]) + (matrizB3[0][2] * matrizB3[2][3] * matrizB3[3][1]) + (matrizB3[2][1] * matrizB3[3][2] * matrizB3[0][3])
                - ((matrizB3[3][1] * matrizB3[2][2] * matrizB3[0][3]) + (matrizB3[3][2] * matrizB3[2][3] * matrizB3[0][1]) + (matrizB3[0][2] * matrizB3[2][1] * matrizB3[3][3])));

        maAdjB3[1][1] = (matrizB3[0][0] * matrizB3[2][2] * matrizB3[3][3]) + (matrizB3[0][2] * matrizB3[2][3] * matrizB3[3][0]) + (matrizB3[2][0] * matrizB3[3][2] * matrizB3[0][3])
                - ((matrizB3[3][0] * matrizB3[2][2] * matrizB3[0][3]) + (matrizB3[2][3] * matrizB3[3][2] * matrizB3[0][0]) + (matrizB3[2][0] * matrizB3[0][2] * matrizB3[3][3]));

        maAdjB3[1][2] = (-1) * ((matrizB3[0][0] * matrizB3[2][1] * matrizB3[3][3]) + (matrizB3[0][1] * matrizB3[2][3] * matrizB3[3][0]) + (matrizB3[2][0] * matrizB3[3][1] * matrizB3[0][3])
                - ((matrizB3[3][0] * matrizB3[2][1] * matrizB3[0][3]) + (matrizB3[2][3] * matrizB3[3][1] * matrizB3[0][0]) + (matrizB3[2][0] * matrizB3[0][1] * matrizB3[3][3])));

        maAdjB3[1][3] = (matrizB3[0][0] * matrizB3[2][1] * matrizB3[3][2]) + (matrizB3[0][1] * matrizB3[2][2] * matrizB3[3][0]) + (matrizB3[2][0] * matrizB3[3][1] * matrizB3[0][2])
                - ((matrizB3[3][0] * matrizB3[2][1] * matrizB3[0][2]) + (matrizB3[2][2] * matrizB3[3][1] * matrizB3[0][0]) + (matrizB3[0][1] * matrizB3[2][0] * matrizB3[3][2]));

        //para tercera fila
        maAdjB3[2][0] = (matrizB3[0][1] * matrizB3[1][2] * matrizB3[3][3]) + (matrizB3[0][2] * matrizB3[1][3] * matrizB3[3][1]) + (matrizB3[1][1] * matrizB3[3][2] * matrizB3[0][3])
                - ((matrizB3[3][1] * matrizB3[1][2] * matrizB3[0][3]) + (matrizB3[1][3] * matrizB3[3][2] * matrizB3[0][1]) + (matrizB3[1][1] * matrizB3[0][2] * matrizB3[3][3]));

        maAdjB3[2][1] = (-1) * ((matrizB3[0][0] * matrizB3[1][2] * matrizB3[3][3]) + (matrizB3[0][2] * matrizB3[1][3] * matrizB3[3][0]) + (matrizB3[1][0] * matrizB3[3][2] * matrizB3[0][3])
                - ((matrizB3[3][0] * matrizB3[1][2] * matrizB3[0][3]) + (matrizB3[3][2] * matrizB3[1][3] * matrizB3[0][0]) + (matrizB3[1][0] * matrizB3[0][2] * matrizB3[3][3])));

        maAdjB3[2][2] = (matrizB3[0][0] * matrizB3[1][1] * matrizB3[3][3]) + (matrizB3[0][1] * matrizB3[1][3] * matrizB3[3][0]) + (matrizB3[1][0] * matrizB3[3][1] * matrizB3[0][3])
                - ((matrizB3[3][0] * matrizB3[1][1] * matrizB3[0][3]) + (matrizB3[3][1] * matrizB3[1][3] * matrizB3[0][0]) + (matrizB3[1][0] * matrizB3[0][1] * matrizB3[3][3]));

        maAdjB3[2][3] = (-1) * ((matrizB3[0][0] * matrizB3[1][1] * matrizB3[3][2]) + (matrizB3[0][1] * matrizB3[1][2] * matrizB3[3][0]) + (matrizB3[1][0] * matrizB3[3][1] * matrizB3[0][2])
                - ((matrizB3[3][0] * matrizB3[1][1] * matrizB3[0][2]) + (matrizB3[3][1] * matrizB3[1][2] * matrizB3[0][0]) + (matrizB3[1][0] * matrizB3[0][1] * matrizB3[3][2])));

        //para cuarta fila
        maAdjB3[3][0] = (-1) * ((matrizB3[0][1] * matrizB3[1][2] * matrizB3[2][3]) + (matrizB3[0][2] * matrizB3[1][3] * matrizB3[2][1]) + (matrizB3[1][1] * matrizB3[2][2] * matrizB3[0][3])
                - ((matrizB3[2][1] * matrizB3[1][2] * matrizB3[0][3]) + (matrizB3[2][2] * matrizB3[1][3] * matrizB3[0][1]) + (matrizB3[1][1] * matrizB3[0][2] * matrizB3[2][3])));

        maAdjB3[3][1] = (matrizB3[0][0] * matrizB3[1][2] * matrizB3[2][3]) + (matrizB3[0][2] * matrizB3[1][3] * matrizB3[2][0]) + (matrizB3[1][0] * matrizB3[2][2] * matrizB3[0][3])
                - ((matrizB3[2][0] * matrizB3[1][2] * matrizB3[0][3]) + (matrizB3[2][2] * matrizB3[1][3] * matrizB3[0][0]) + (matrizB3[1][0] * matrizB3[0][2] * matrizB3[2][3]));

        maAdjB3[3][2] = (-1) * ((matrizB3[0][0] * matrizB3[1][1] * matrizB3[2][3]) + (matrizB3[0][1] * matrizB3[1][3] * matrizB3[2][0]) + (matrizB3[1][0] * matrizB3[2][1] * matrizB3[0][3])
                - ((matrizB3[2][0] * matrizB3[1][1] * matrizB3[0][3]) + (matrizB3[2][1] * matrizB3[1][3] * matrizB3[0][0]) + (matrizB3[1][0] * matrizB3[0][1] * matrizB3[2][3])));

        maAdjB3[3][3] = (matrizB3[0][0] * matrizB3[1][1] * matrizB3[2][2]) + (matrizB3[0][1] * matrizB3[1][2] * matrizB3[2][0]) + (matrizB3[1][0] * matrizB3[2][1] * matrizB3[0][2])
                - ((matrizB3[2][0] * matrizB3[1][1] * matrizB3[0][2]) + (matrizB3[2][1] * matrizB3[1][2] * matrizB3[0][0]) + (matrizB3[0][1] * matrizB3[1][0] * matrizB3[2][2]));
        // Hasta aqui termina el calculo de la matriz adjunta
        //comienza el calculo de la traspuesta

        double var_aux;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                var_aux = maAdjB1[i][j];
                maAdjB1[i][j] = maAdjB1[j][i];
                maAdjB1[j][i] = var_aux;
            }
        }

        double var_aux1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                var_aux1 = maAdjB2[i][j];
                maAdjB2[i][j] = maAdjB2[j][i];
                maAdjB2[j][i] = var_aux1;
            }
        }

        double var_aux2;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                var_aux2 = maAdjB3[i][j];
                maAdjB3[i][j] = maAdjB3[j][i];
                maAdjB3[j][i] = var_aux2;
            }
        }

        //Matriz inversa
        double[][] matrizInversaB1 = new double[4][4];
        if (detB1 != 0) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    matrizInversaB1[i][j] = maAdjB1[i][j] / detB1;
                }
            }
//            for (int i = 0; i < 4; i++) {
//                System.out.println((double) Math.round(matrizInversaB1[i][0] * 1000d) / 1000 + " "
//                        + (double) Math.round(matrizInversaB1[i][1] * 1000d) / 1000 + " "
//                        + (double) Math.round(matrizInversaB1[i][2] * 1000d) / 1000 + " "
//                        + (double) Math.round(matrizInversaB1[i][3] * 1000d) / 1000);
//            }
        } else {
            System.out.println("Error, el determinante de la matriz es igual a : 0");
        }

        double[][] matrizInversaB2 = new double[4][4];
        if (detB2 != 0) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    matrizInversaB2[i][j] = maAdjB2[i][j] / detB2;
                }
            }
//            for (int i = 0; i < 4; i++) {
//                System.out.println((double) Math.round(matrizInversaB2[i][0] * 1000d) / 1000 + " "
//                        + (double) Math.round(matrizInversaB2[i][1] * 1000d) / 1000 + " "
//                        + (double) Math.round(matrizInversaB2[i][2] * 1000d) / 1000 + " "
//                        + (double) Math.round(matrizInversaB2[i][3] * 1000d) / 1000);
//            }
        } else {
            System.out.println("Error, el determinante de la matriz es igual a : 0");
        }

        double[][] matrizInversaB3 = new double[4][4];
        if (detB3 != 0) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    matrizInversaB3[i][j] = maAdjB3[i][j] / detB3;
                }
            }
//            for (int i = 0; i < 4; i++) {
//                System.out.println((double) Math.round(matrizInversaB3[i][0] * 1000d) / 1000 + " "
//                        + (double) Math.round(matrizInversaB3[i][1] * 1000d) / 1000 + " "
//                        + (double) Math.round(matrizInversaB3[i][2] * 1000d) / 1000 + " "
//                        + (double) Math.round(matrizInversaB3[i][3] * 1000d) / 1000);
//            }
        } else {
            System.out.println("Error, el determinante de la matriz es igual a : 0");
        }

        
        //elegir aleatoriamente la matriz a operar 
       

        switch (indice1) {
            case 0:
                System.out.println("Opcion 1: Matriz A / B");

                for (int i = 0; i < resultadodivision.length; i++) {
                    resultadodivision[0][i] = matrizA1[0][0] * matrizInversaB1[0][i] + matrizA1[0][1] * matrizInversaB1[1][i] + matrizA1[0][2] * matrizInversaB1[2][i] + matrizA1[0][3] * matrizInversaB1[3][i];
                    resultadodivision[1][i] = matrizA1[1][0] * matrizInversaB1[0][i] + matrizA1[1][1] * matrizInversaB1[1][i] + matrizA1[1][2] * matrizInversaB1[2][i] + matrizA1[1][3] * matrizInversaB1[3][i];
                    resultadodivision[2][i] = matrizA1[2][0] * matrizInversaB1[0][i] + matrizA1[2][1] * matrizInversaB1[1][i] + matrizA1[2][2] * matrizInversaB1[2][i] + matrizA1[2][3] * matrizInversaB1[3][i];
                    resultadodivision[3][i] = matrizA1[3][0] * matrizInversaB1[0][i] + matrizA1[3][1] * matrizInversaB1[1][i] + matrizA1[3][2] * matrizInversaB1[2][i] + matrizA1[3][3] * matrizInversaB1[3][i];
                }
                for (int i = 0; i < resultadodivision.length; i++) {
                    for (int j = 0; j < resultadodivision.length; j++) {
                        resultadodivision[i][j] = (double) Math.round(resultadodivision[i][j] * 1000d) / 1000;
                    }
                }
                System.out.println("\n");
                System.out.println("-------Matriz Resultado de la división-------");
                System.out.println("| " + resultadodivision[0][0] + "   " + resultadodivision[0][1] + "   " + resultadodivision[0][2] + "   " + resultadodivision[0][3] + " |");
                System.out.println("| " + resultadodivision[1][0] + "   " + resultadodivision[1][1] + "   " + resultadodivision[1][2] + "   " + resultadodivision[1][3] + " |");
                System.out.println("| " + resultadodivision[2][0] + "   " + resultadodivision[2][1] + "   " + resultadodivision[2][2] + "   " + resultadodivision[2][3] + " |");
                System.out.println("| " + resultadodivision[3][0] + "   " + resultadodivision[3][1] + "   " + resultadodivision[3][2] + "   " + resultadodivision[3][3] + " |");
                System.out.println("\n");
                
                envi.recibirDificil1(matrizA1,matrizB1,detB1,maAdjB1,matrizInversaB1,resultadodivision,indice1);
                break;
            case 1:
                System.out.println("Opcion 2: Matriz A / B");

                for (int i = 0; i < resultadodivision1.length; i++) {
                    resultadodivision1[0][i] = matrizA2[0][0] * matrizInversaB2[0][i] + matrizA2[0][1] * matrizInversaB2[1][i] + matrizA2[0][2] * matrizInversaB2[2][i] + matrizA2[0][3] * matrizInversaB2[3][i];
                    resultadodivision1[1][i] = matrizA2[1][0] * matrizInversaB2[0][i] + matrizA2[1][1] * matrizInversaB2[1][i] + matrizA2[1][2] * matrizInversaB2[2][i] + matrizA2[1][3] * matrizInversaB2[3][i];
                    resultadodivision1[2][i] = matrizA2[2][0] * matrizInversaB2[0][i] + matrizA2[2][1] * matrizInversaB2[1][i] + matrizA2[2][2] * matrizInversaB2[2][i] + matrizA2[2][3] * matrizInversaB2[3][i];
                    resultadodivision1[3][i] = matrizA2[3][0] * matrizInversaB2[0][i] + matrizA2[3][1] * matrizInversaB2[1][i] + matrizA2[3][2] * matrizInversaB2[2][i] + matrizA2[3][3] * matrizInversaB2[3][i];
                }
                for (int i = 0; i < resultadodivision1.length; i++) {
                    for (int j = 0; j < resultadodivision1.length; j++) {
                        resultadodivision1[i][j] = (double) Math.round(resultadodivision1[i][j] * 1000d) / 1000;
                    }
                }
                System.out.println("\n");
                System.out.println("-------Matriz Resultado de la división-------");
                System.out.println("| " + resultadodivision1[0][0] + "   " + resultadodivision1[0][1] + "   " + resultadodivision1[0][2] + "   " + resultadodivision1[0][3] + " |");
                System.out.println("| " + resultadodivision1[1][0] + "   " + resultadodivision1[1][1] + "   " + resultadodivision1[1][2] + "   " + resultadodivision1[1][3] + " |");
                System.out.println("| " + resultadodivision1[2][0] + "   " + resultadodivision1[2][1] + "   " + resultadodivision1[2][2] + "   " + resultadodivision1[2][3] + " |");
                System.out.println("| " + resultadodivision1[3][0] + "   " + resultadodivision1[3][1] + "   " + resultadodivision1[3][2] + "   " + resultadodivision1[3][3] + " |");
                System.out.println("\n");
                
                envi.recibirDificil2(matrizA2,matrizB2,detB2,maAdjB2,matrizInversaB2,resultadodivision1,indice1);
                break;
            case 2:
                System.out.println("Opcion 3: Matriz A / B");

                for (int i = 0; i < resultadodivision2.length; i++) {
                    resultadodivision2[0][i] = matrizA3[0][0] * matrizInversaB3[0][i] + matrizA3[0][1] * matrizInversaB3[1][i] + matrizA3[0][2] * matrizInversaB3[2][i] + matrizA3[0][3] * matrizInversaB3[3][i];
                    resultadodivision2[1][i] = matrizA3[1][0] * matrizInversaB3[0][i] + matrizA3[1][1] * matrizInversaB3[1][i] + matrizA3[1][2] * matrizInversaB3[2][i] + matrizA3[1][3] * matrizInversaB3[3][i];
                    resultadodivision2[2][i] = matrizA3[2][0] * matrizInversaB3[0][i] + matrizA3[2][1] * matrizInversaB3[1][i] + matrizA3[2][2] * matrizInversaB3[2][i] + matrizA3[2][3] * matrizInversaB3[3][i];
                    resultadodivision2[3][i] = matrizA3[3][0] * matrizInversaB3[0][i] + matrizA3[3][1] * matrizInversaB3[1][i] + matrizA3[3][2] * matrizInversaB3[2][i] + matrizA3[3][3] * matrizInversaB3[3][i];
                }
                for (int i = 0; i < resultadodivision2.length; i++) {
                    for (int j = 0; j < resultadodivision2.length; j++) {
                        resultadodivision2[i][j] = (double) Math.round(resultadodivision2[i][j] * 1000d) / 1000;
                    }
                }
                System.out.println("\n");
                System.out.println("-------Matriz Resultado de la división-------");
                System.out.println("| " + resultadodivision2[0][0] + "   " + resultadodivision2[0][1] + "   " + resultadodivision2[0][2] + "   " + resultadodivision2[0][3] + " |");
                System.out.println("| " + resultadodivision2[1][0] + "   " + resultadodivision2[1][1] + "   " + resultadodivision2[1][2] + "   " + resultadodivision2[1][3] + " |");
                System.out.println("| " + resultadodivision2[2][0] + "   " + resultadodivision2[2][1] + "   " + resultadodivision2[2][2] + "   " + resultadodivision2[2][3] + " |");
                System.out.println("| " + resultadodivision2[3][0] + "   " + resultadodivision2[3][1] + "   " + resultadodivision2[3][2] + "   " + resultadodivision2[3][3] + " |");
                System.out.println("\n");

                envi.recibirDificil3(matrizA3, matrizB3, detB3, maAdjB3, matrizInversaB3, resultadodivision2, indice1);
                break;
            default:

                break;
        }

    }
}
