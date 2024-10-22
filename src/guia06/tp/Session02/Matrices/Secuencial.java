
// cSpell:ignore guia
package guia06.tp.Session02.Matrices;

import java.util.Random;

public class Secuencial {
    public static void main(String[] args) {
        int tamaño = 1000;
        double[][] A = generateMatrix(tamaño);
        double[][] B = generateMatrix(tamaño);
        double[][] C = new double[tamaño][tamaño];

        long tiempoInicial = System.currentTimeMillis();

        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                for (int k = 0; k < tamaño; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        long tiempoFinal = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución secuencial: " + (tiempoFinal - tiempoInicial) + " ms");
    }

    public static double[][] generateMatrix(int tamaño) {
        Random rand = new Random();
        double[][] matriz = new double[tamaño][tamaño];
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                matriz[i][j] = rand.nextDouble() * 10;
            }
        }
        return matriz;
    }
}
