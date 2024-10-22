package guia06.tp.Session02.Matrices;

import java.util.Random;

public class Secuencial {
    public static void main(String[] args) {
        int size = 1000;
        double[][] A = generateMatrix(size);
        double[][] B = generateMatrix(size);
        double[][] C = new double[size][size];

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución secuencial: " + (endTime - startTime) + " ms");
    }

    public static double[][] generateMatrix(int size) {
        Random rand = new Random();
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = rand.nextDouble() * 10;
            }
        }
        return matrix;
    }
}
