// cSpell:ignore guia
package guia06.tp.Session02.Matrices;

import java.util.Random;

public class Concurrente {
    static class MatrixMultiplier implements Runnable {
        private double[][] A, B, C;
        private int primeraFila, ultimaFila;

        public MatrixMultiplier(double[][] A, double[][] B, double[][] C, int primeraFila, int ultimaFila) {
            this.A = A;
            this.B = B;
            this.C = C;
            this.primeraFila = primeraFila;
            this.ultimaFila = ultimaFila;
        }

        @Override
        public void run() {
            int tamaño = A.length;
            for (int i = primeraFila; i < ultimaFila; i++) {
                for (int j = 0; j < tamaño; j++) {
                    for (int k = 0; k < tamaño; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int tamaño = 1000;
        double[][] A = generateMatrix(tamaño);
        double[][] B = generateMatrix(tamaño);
        double[][] C = new double[tamaño][tamaño];

        long tiempoInicial = System.currentTimeMillis();

        Thread t1 = new Thread(new MatrixMultiplier(A, B, C, 0, tamaño / 4));
        Thread t2 = new Thread(new MatrixMultiplier(A, B, C, tamaño / 4, tamaño / 2));
        Thread t3 = new Thread(new MatrixMultiplier(A, B, C, tamaño / 2, 3 * tamaño / 4));
        Thread t4 = new Thread(new MatrixMultiplier(A, B, C, 3 * tamaño / 4, tamaño));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        long tiempoFinal = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución concurrente: " + (tiempoFinal - tiempoInicial) + " ms");
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
