package practica_1;

public class Operacion_facil {

    Reporte_1 enviardatos = new Reporte_1();
//    int valo[] = new int[3]; // Crea el arreglo con la cantidad de espacios para lo aleatorio
    static float LA1, LB1, LC1;
    static float LA2, LB2, LC2;
    static float LA3, LB3, LC3;
    static float anguloAlfa1, anguloBeta1, anguloGamma1;
    static float anguloAlfa2, anguloBeta2, anguloGamma2;
    static float anguloAlfa3, anguloBeta3, anguloGamma3;

    public Operacion_facil() {
    }

    public void ley_cosenos(int indi) {

        switch (indi) {
            case 0:
                System.out.println("\nOpción 1: Ley de cosenos");
                LA1 = 15;
                LC1 = 20;
                anguloAlfa1 = (float) Math.toRadians(25);   //conversion del angulo en grados a radianes para el calculo en java
                LB1 = (float) Math.sqrt(((LA1 * LA1) + (LC1 * LC1)) - (2 * LA1 * LC1 * Math.cos(anguloAlfa1)));
                anguloBeta1 = (float) Math.acos(((LA1 * LA1) - (LB1 * LB1) - (LC1 * LC1)) / (-2 * LB1 * LC1));
                anguloGamma1 = (float) Math.acos(((LC1 * LC1) - (LB1 * LB1) - (LA1 * LA1)) / (-2 * LA1 * LB1));
                LB1 = (float) Math.round(LB1 * 1000d) / 1000;
                anguloBeta1 = (float) Math.round(Math.toDegrees(anguloBeta1) * 1000d) / 1000;
                anguloGamma1 = (float) Math.round(Math.toDegrees(anguloGamma1) * 1000d) / 1000;
                System.out.println("\n Nota: Los angulos están en grados");
                System.out.println("Los resultados son:");
                System.out.println("El lado B = " + LB1);
                System.out.println("El angulo Beta (β) = " + anguloBeta1);
                System.out.println("El angulo Gamma (γ)= " + anguloGamma1);
                System.out.println("");

                enviardatos.recibirDatos1(LA1, LC1, anguloAlfa1, LB1, anguloBeta1, anguloGamma1, indi);
                break;

            case 1:
                System.out.println("\nOpción 2: Ley de cosenos");
                LB2 = 10;
                LC2 = 25;
                anguloBeta2 = (float) Math.toRadians(30);  //conversion del angulo en grados a radianes para el calculo en java
                LA2 = (float) Math.sqrt(((LB2 * LB2) + (LC2 * LC2)) - (2 * LB2 * LC2 * Math.cos(anguloBeta2)));
                anguloAlfa2 = (float) Math.acos(((LB2 * LB2) - (LA2 * LA2) - (LC2 * LC2)) / (-2 * LA2 * LC2));
                anguloGamma2 = (float) Math.acos(((LC2 * LC2) - (LB2 * LB2) - (LA2 * LA2)) / (-2 * LA2 * LB2));
                LA2 = (float) Math.round(LA2 * 1000d) / 1000;
                anguloAlfa2 = (float) Math.round(Math.toDegrees(anguloAlfa2) * 1000d) / 1000;
                anguloGamma2 = (float) Math.round(Math.toDegrees(anguloGamma2) * 1000d) / 1000;
                System.out.println("\n Nota: Los angulos están en grados");
                System.out.println("Los resultados son:");
                System.out.println("El lado A = " + LA2);
                System.out.println("El angulo Alfa (α) = " + anguloAlfa2);
                System.out.println("El angulo Gamma (γ) = " + anguloGamma2);
                System.out.println("");
                enviardatos.recibirDatos2(LB2, LC2, anguloBeta2, LA2, anguloAlfa2, anguloGamma2, indi);
                break;
            case 2:
                System.out.println("\nOpción 3: Ley de cosenos");
                LA3 = 18;
                LB3 = 25;
                anguloGamma3 = (float) Math.toRadians(30);
                LC3 = (float) Math.sqrt(((LB3 * LB3) + (LA3 * LA3)) - (2 * LA3 * LB3 * Math.cos(anguloGamma3)));
                anguloAlfa3 = (float) Math.acos(((LB3 * LB3) - (LA3 * LA3) - (LC3 * LC3)) / (-2 * LA3 * LC3));
                anguloBeta3 = (float) Math.acos(((LA3 * LA3) - (LB3 * LB3) - (LC3 * LC3)) / (-2 * LB3 * LC3));
                LC3 = (float) Math.round(LC3 * 1000d) / 1000;
                anguloAlfa3 = (float) Math.round(Math.toDegrees(anguloAlfa3) * 1000d) / 1000;
                anguloBeta3 = (float) Math.round(Math.toDegrees(anguloBeta3) * 1000d) / 1000;
                System.out.println("\n Nota: Los angulos están en grados");
                System.out.println("Los resultados son:");
                System.out.println("El lado C = " + LC3);
                System.out.println("El angulo Alfa (α) = " + anguloAlfa3);
                System.out.println("El angulo Beta (β) = " + anguloBeta3);

                System.out.println("");
                enviardatos.recibirDatos3(LA3, LB3, anguloGamma3, LC3, anguloAlfa3, anguloBeta3, indi);

                break;
            default:
                break;
        }
    }
}
//    public void aleatorioSinrepetir() {
//        int in = 0;                                 // indice para ir sumando las iteraciones
//        int indice;
//        while (in < 3) {                            // Se ingresa al bucle de acuerdo al limite del indice y al limite del arreglo
//            int alea = (int) (Math.random() * 3);  //elige valores de 0,1,2 
//            boolean repe = false;                                    //indica que no hay nada repetido y si hay algo repetido cambia a true
//            while (!repe) {                                          // valua si hay algo repetido ingresa al bucle
//                for (int conta = 0; conta < in; conta++) {                // bucle para indicar que si hay algun numero repetido vuelva la variable a repetido a true
//                    if (alea == valo[conta]) {      //si el valor de la posicion coincide con el valor del arreglo  es porque está repetido 
//                        repe = true;                                   // cambia el valor a verdadero  
//                        break;                                             // termina la ejecucion  
//                    }
//                }
//                if (!repe) {                                           // si la variable no está repetida 
//                    valo[in] = alea;                    // al arreglo le ingreso el valor aleatorio 
//                    indice = valo[in];                             // a la nueva variable indice le guardo el valor de la variable
//                    ley_cosenos(alea);
//                    in++;  
//                    //aumenta la unidad  del iterador
//                }
//                
//            }
//            break;
//        }
//        
//    }

