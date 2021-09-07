package tarea2;

import java.util.Scanner;

public class MenuPrincipal {

    Scanner entrada = new Scanner(System.in);
    int opciones;
    float[][] matriz_A = new float[3][3];
    float[][] matriz_B = new float[3][3];

    public MenuPrincipal() {
        menu();
    }

    public void menu() {

        do {
            System.out.println("---------Menu Principal---------\n"
                    + "1. Ingresar Matriz A\n"
                    + "2. Ingresar Matriz B \n"
                    + "3. Realizar División\n"
                    + "4. Salir\n"
                    + "--------------------------------"
                    + " \nIngrese una opción:");

            opciones = entrada.nextInt();
            switch (opciones) {
                case 1:
                    matrizA();
                    break;
                case 2:
                    matrizB();
                    break;
                case 3:
                    dividir();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ingrese una opción correcta");
                    break;
            }
        } while (opciones != 4);
    }

    public void matrizA() {
        System.out.println("\nIngrese la matriz A linea por linea separado por comas: Ejemplo -> 5,10,1");
        Scanner linea1 = new Scanner(System.in);
        Scanner linea2 = new Scanner(System.in);
        Scanner linea3 = new Scanner(System.in);

        String fila1, fila2, fila3;
        System.out.println("Ingrese primera fila");
        fila1 = linea1.nextLine();
        String[] le = fila1.split(",");
        for (int j = 0; j < matriz_A.length; j++) {
            matriz_A[0][j] = Float.parseFloat(le[j]);
        }
        System.out.println("Ingrese segunda fila");
        fila2 = linea2.nextLine();
        String[] le1 = fila2.split(",");
        for (int j = 0; j < matriz_A.length; j++) {
            matriz_A[1][j] = Float.parseFloat(le1[j]);
        }
        System.out.println("Ingrese tercera fila");
        fila3 = linea3.nextLine();
        String[] le2 = fila3.split(",");
        for (int j = 0; j < matriz_A.length; j++) {
            matriz_A[2][j] = Float.parseFloat(le2[j]);
        }
        System.out.println("   Matriz A");
        System.out.println("-------------------");
        System.out.println("| " + matriz_A[0][0] + "   " + matriz_A[0][1] + "   " + matriz_A[0][2] + " |");
        System.out.println("| " + matriz_A[1][0] + "   " + matriz_A[1][1] + "   " + matriz_A[1][2] + " |");
        System.out.println("| " + matriz_A[2][0] + "   " + matriz_A[2][1] + "   " + matriz_A[2][2] + " |");
        System.out.println("-------------------\n");

    }

    public void matrizB() {
        System.out.println("\nIngrese la matriz B linea por linea separado por comas: Ejemplo -> 5,10,1");
        Scanner line1 = new Scanner(System.in);
        Scanner line2 = new Scanner(System.in);
        Scanner line3 = new Scanner(System.in);

        String fil1, fil2, fil3;
        System.out.println("Ingrese primera fila");
        fil1 = line1.nextLine();
        String[] let = fil1.split(",");
        for (int j = 0; j < matriz_B.length; j++) {
            matriz_B[0][j] = Float.parseFloat(let[j]);
        }
        System.out.println("Ingrese segunda fila");
        fil2 = line2.nextLine();
        String[] let1 = fil2.split(",");
        for (int j = 0; j < matriz_B.length; j++) {
            matriz_B[1][j] = Float.parseFloat(let1[j]);
        }
        System.out.println("Ingrese tercera fila");
        fil3 = line3.nextLine();
        String[] let2 = fil3.split(",");
        for (int j = 0; j < matriz_B.length; j++) {
            matriz_B[2][j] = Float.parseFloat(let2[j]);
        }
        System.out.println("   Matriz B");
        System.out.println("-------------------");
        System.out.println("| " + matriz_B[0][0] + "   " + matriz_B[0][1] + "   " + matriz_B[0][2] + " |");
        System.out.println("| " + matriz_B[1][0] + "   " + matriz_B[1][1] + "   " + matriz_B[1][2] + " |");
        System.out.println("| " + matriz_B[2][0] + "   " + matriz_B[2][1] + "   " + matriz_B[2][2] + " |");
        System.out.println("-------------------\n");
    }

    public void dividir() {
        //Determinante de B
        float detB = (matriz_B[0][0] * matriz_B[1][1] * matriz_B[2][2]) + (matriz_B[0][1] * matriz_B[1][2] * matriz_B[2][0]) + 
                (matriz_B[1][0] * matriz_B[2][1] * matriz_B[0][2])
                - ((matriz_B[2][0] * matriz_B[1][1] * matriz_B[0][2]) + (matriz_B[2][1] * matriz_B[1][2] * matriz_B[0][0]) + 
                (matriz_B[0][1] * matriz_B[1][0] * matriz_B[2][2]));
        
        System.out.println("\n-------Determinante de B-------");
        System.out.println("Paso 1");
        System.out.println("determinante de B = " + "(" + matriz_B[0][0] + "*" 
                + matriz_B[1][1] + "*" + matriz_B[2][2] + ")" + " + " + "(" + matriz_B[0][1] + "*" 
                + matriz_B[1][2] + "*" + matriz_B[2][0] + ")" + " + " + "(" + matriz_B[1][0] + "*" 
                + matriz_B[2][1] + "*" + matriz_B[0][2] + ")"
                + "\n- " + "(" + "(" + matriz_B[2][0] + "*" + matriz_B[1][1] + "*" + matriz_B[0][2] + ")" + " + " 
                        + "(" + matriz_B[2][1] + "*" + matriz_B[1][2] + "*" + matriz_B[0][0] + ")" + " + " + "(" 
                + matriz_B[0][1] + "*" + matriz_B[1][0] + "*" + matriz_B[2][2] + ")" + ")");
        System.out.println(" ");
        System.out.println("El determinante de la matriz B es:\n" + detB + "\n");

        //matriz adjunta de B
        System.out.println("\n-------Matriz Adjunta de B-------");
        System.out.println("Paso 2");
        float[][] adjunta = new float[3][3];
        adjunta[0][0] = (matriz_B[1][1] * matriz_B[2][2]) - (matriz_B[2][1] * matriz_B[1][2]);
        System.out.println("adjunta[0][0]=" + "(" + matriz_B[1][1] + "*" + matriz_B[2][2] + ")" + "-" 
                + "(" + matriz_B[2][1] + "*" + matriz_B[1][2] + ")");
        adjunta[0][1] = (-1) * ((matriz_B[1][0] * matriz_B[2][2]) - (matriz_B[2][0] * matriz_B[1][2]));
        System.out.println("adjunta[0][1]=" + "(-1)" + "*" + "(" + "(" + matriz_B[1][0] + "*" + matriz_B[2][2] 
                + ")" + "-" + "(" + matriz_B[2][0] + "*" + matriz_B[1][2] + ")" + ")");
        adjunta[0][2] = (matriz_B[1][0] * matriz_B[2][1]) - (matriz_B[2][0] * matriz_B[1][1]);
        System.out.println("adjunta[0][2]=" + "(" + matriz_B[1][0] + "*" + matriz_B[2][1] + ")" + "-" + "(" 
                + matriz_B[2][0] + "*" + matriz_B[1][1] + ")");

        adjunta[1][0] = (-1) * ((matriz_B[0][1] * matriz_B[2][2]) - (matriz_B[2][1] * matriz_B[0][2]));
        System.out.println("adjunta[1][0]=" + "(-1)" + "*" + "(" + "(" + matriz_B[0][1] + "*" + matriz_B[2][2] 
                + ")" + "-" + "(" + matriz_B[2][1] + "*" + matriz_B[0][2] + ")" + ")");
        adjunta[1][1] = ((matriz_B[0][0] * matriz_B[2][2]) - (matriz_B[2][0] * matriz_B[0][2]));
        System.out.println("adjunta[1][1]=" + "(" + matriz_B[0][0] + "*" + matriz_B[2][2] + ")" + "-" + "(" 
                + matriz_B[2][0] + "*" + matriz_B[0][2] + ")");
        adjunta[1][2] = (-1) * ((matriz_B[0][0] * matriz_B[2][1]) - (matriz_B[2][0] * matriz_B[0][1]));
        System.out.println("adjunta[1][2]=" + "(-1)" + "*" + "(" + "(" + matriz_B[0][0] + "*" + matriz_B[2][1] 
                + ")" + "-" + "(" + matriz_B[2][0] + "*" + matriz_B[0][1] + ")" + ")");

        adjunta[2][0] = (matriz_B[0][1] * matriz_B[1][2]) - (matriz_B[1][1] * matriz_B[0][2]);
        System.out.println("adjunta[2][0]=" + "(" + matriz_B[0][1] + "*" + matriz_B[1][2] + ")" + "-" + "(" 
                + matriz_B[1][1] + "*" + matriz_B[0][2] + ")");
        adjunta[2][1] = (-1) * ((matriz_B[0][0] * matriz_B[1][2]) - (matriz_B[1][0] * matriz_B[0][2]));
        System.out.println("adjunta[2][1]=" + "(-1)" + "*" + "(" + "(" + matriz_B[0][0] + "*" + matriz_B[1][2] 
                + ")" + "-" + "(" + matriz_B[1][0] + "*" + matriz_B[0][2] + ")" + ")");
        adjunta[2][2] = (matriz_B[0][0] * matriz_B[1][1]) - (matriz_B[1][0] * matriz_B[0][1]);
        System.out.println("adjunta[2][2]=" + "(" + matriz_B[0][0] + "*" + matriz_B[1][1] + ")" + "-" + "(" 
                + matriz_B[1][0] + "*" + matriz_B[0][1] + ")");

        System.out.println("\n-------Matriz Adjunta de B-------");
        System.out.println("| " +  adjunta[0][0]  + "   " +  adjunta[0][1]  + "   " +  adjunta[0][2]  + " |");
        System.out.println("| " +  adjunta[1][0]  + "   " +  adjunta[1][1]  + "   " +  adjunta[1][2]  + " |");
        System.out.println("| " +  adjunta[2][0]  + "   " +  adjunta[2][1]  + "   " +  adjunta[2][2]  + " |");

        //matriz traspuesta de B
        System.out.println(" \n");
        System.out.println("-------Matriz Traspuesta de B-------");
        System.out.println("Paso 3");
        float var_aux;
        for (int i = 0; i < adjunta.length; i++) {
            for (int j = 0; j < i; j++) {
                var_aux = adjunta[i][j];
                System.out.println("var_aux = "+adjunta[i][j]);
                adjunta[i][j] = adjunta[j][i];
                System.out.println("adjunta[i][j]= "+adjunta[j][i]);
                adjunta[j][i] = var_aux;
                System.out.println("adjunta[j][i]= "+ var_aux);
            }
        }
        System.out.println("\n-------Matriz Traspuesta de B-------");
        System.out.println("| " +  adjunta[0][0]  + "   " +  adjunta[0][1]  + "   " +  adjunta[0][2]  + " |");
        System.out.println("| " +  adjunta[1][0]  + "   " +  adjunta[1][1]  + "   " +  adjunta[1][2]  + " |");
        System.out.println("| " +  adjunta[2][0]  + "   " +  adjunta[2][1]  + "   " +  adjunta[2][2]  + " |");
        System.out.println("\n");

        //Matriz inversa de B
        System.out.println(" ");
        System.out.println("-------Matriz Inversa de B-------");
        System.out.println("Paso 4");
        float matrizInversaB[][] = new float[3][3];
        if (detB != 0) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matrizInversaB[i][j] = adjunta[i][j] / detB;
                }
            }
        } else {
            System.out.println("El determinante es igual a 0 por lo tanto no puede existir matriz inversa");
        }
        System.out.println("matrizInversaB[0][0] = " + adjunta[0][0] + " /" + detB);
        System.out.println("matrizInversaB[0][1] = " + adjunta[0][1] + " /" + detB);
        System.out.println("matrizInversaB[0][2] = " + adjunta[0][2] + " /" + detB);
        System.out.println("matrizInversaB[1][0] = " + adjunta[1][0] + " /" + detB);
        System.out.println("matrizInversaB[1][1] = " + adjunta[1][1] + " /" + detB);
        System.out.println("matrizInversaB[1][2] = " + adjunta[1][2] + " /" + detB);
        System.out.println("matrizInversaB[2][0] = " + adjunta[2][0] + " /" + detB);
        System.out.println("matrizInversaB[2][1] = " + adjunta[2][1] + " /" + detB);
        System.out.println("matrizInversaB[2][2] = " + adjunta[2][2] + " /" + detB);

        System.out.println("\n-------Matriz Inversa de B-------");
        System.out.println("| " +  matrizInversaB[0][0]  + "   " +  matrizInversaB[0][1]  + "   " +  matrizInversaB[0][2] + " |");
        System.out.println("| " +  matrizInversaB[1][0]  + "   " +  matrizInversaB[1][1]  + "   " +  matrizInversaB[1][2] + " |");
        System.out.println("| " +  matrizInversaB[2][0]  + "   " +  matrizInversaB[2][1]  + "   " +  matrizInversaB[2][2] + " |");

        //Multiplicacion de A por matriz inversa de B
        System.out.println(" ");
        System.out.println("-------División de la Matriz A entre matriz B-------");
        System.out.println("Paso 5");
        float division[][] = new float[3][3];
        for (int i = 0; i < 3; i++) {
            division[0][i] = matriz_A[0][0] * matrizInversaB[0][i] + matriz_A[0][1] * matrizInversaB[1][i] + matriz_A[0][2] * matrizInversaB[2][i];
            division[1][i] = matriz_A[1][0] * matrizInversaB[0][i] + matriz_A[1][1] * matrizInversaB[1][i] + matriz_A[1][2] * matrizInversaB[2][i];
            division[2][i] = matriz_A[2][0] * matrizInversaB[0][i] + matriz_A[2][1] * matrizInversaB[1][i] + matriz_A[2][2] * matrizInversaB[2][i];
        }
        System.out.println("division[0][0] = " + matriz_A[0][0] + "*" + matrizInversaB[0][0] + "+" + matriz_A[0][1] + "*" + matrizInversaB[1][0] 
                + "+" + matriz_A[0][2] + "*" + matrizInversaB[2][0]);
        System.out.println("division[0][1] = " + matriz_A[0][0] + "*" + matrizInversaB[0][1] + "+" + matriz_A[0][1] + "*" + matrizInversaB[1][1] 
                + "+" + matriz_A[0][2] + "*" + matrizInversaB[2][1]);
        System.out.println("division[0][2] = " + matriz_A[0][0] + "*" + matrizInversaB[0][2] + "+" + matriz_A[0][1] + "*" + matrizInversaB[1][2] 
                + "+" + matriz_A[0][2] + "*" + matrizInversaB[2][2]);
        System.out.println("division[1][0] = " + matriz_A[1][0] + "*" + matrizInversaB[0][0] + "+" + matriz_A[1][1] + "*" + matrizInversaB[1][0] 
                + "+" + matriz_A[1][2] + "*" + matrizInversaB[2][0]);
        System.out.println("division[1][1] = " + matriz_A[1][0] + "*" + matrizInversaB[0][1] + "+" + matriz_A[1][1] + "*" + matrizInversaB[1][1] 
                + "+" + matriz_A[1][2] + "*" + matrizInversaB[2][1]);
        System.out.println("division[1][2] = " + matriz_A[1][0] + "*" + matrizInversaB[0][2] + "+" + matriz_A[1][1] + "*" + matrizInversaB[1][2] 
                + "+" + matriz_A[1][2] + "*" + matrizInversaB[2][2]);
        System.out.println("division[2][0] = " + matriz_A[2][0] + "*" + matrizInversaB[0][0] + "+" + matriz_A[2][1] + "*" + matrizInversaB[1][0] 
                + "+" + matriz_A[2][2] + "*" + matrizInversaB[2][0]);
        System.out.println("division[2][1] = " + matriz_A[2][0] + "*" + matrizInversaB[0][1] + "+" + matriz_A[2][1] + "*" + matrizInversaB[1][1] 
                + "+" + matriz_A[2][2] + "*" + matrizInversaB[2][1]);
        System.out.println("division[2][2] = " + matriz_A[2][0] + "*" + matrizInversaB[0][2] + "+" + matriz_A[2][1] + "*" + matrizInversaB[1][2] 
                + "+" + matriz_A[2][2] + "*" + matrizInversaB[2][2]);
        System.out.println("\n");
        System.out.println("-------Matriz Resultado de la división-------");
        System.out.println("| " +  division[0][0]  + "   " +  division[0][1]  + "   " +  division[0][2]  + " |");
        System.out.println("| " +  division[1][0]  + "   " +  division[1][1]  + "   " +  division[1][2]  + " |");
        System.out.println("| " +  division[2][0]  + "   " +  division[2][1]  + "   " +  division[2][2]  + " |");
        System.out.println("\n");
    }

}
