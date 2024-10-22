package guia06.tp.Session02.Matrices;

import java.util.Random;

public class Concurrente {
    public static void main(String[] args) throws InterruptedException {
        int size = 1000;
        double[][] A = generateMatrix(size);
        double[][] B = generateMatrix(size);
        double[][] C = new double[size][size];

        long startTime = System.currentTimeMillis();

        Thread t1 = new Thread(new MatrixMultiplier(A, B, C, 0, size / 4));
        Thread t2 = new Thread(new MatrixMultiplier(A, B, C, size / 4, size / 2));
        Thread t3 = new Thread(new MatrixMultiplier(A, B, C, size / 2, 3 * size / 4));
        Thread t4 = new Thread(new MatrixMultiplier(A, B, C, 3 * size / 4, size));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        long endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución concurrente: " + (endTime - startTime) + " ms");
    }

    static class MatrixMultiplier implements Runnable {
        private double[][] A, B, C;
        private int startRow, endRow;

        public MatrixMultiplier(double[][] A, double[][] B, double[][] C, int startRow, int endRow) {
            this.A = A;
            this.B = B;
            this.C = C;
            this.startRow = startRow;
            this.endRow = endRow;
        }

        @Override
        public void run() {
            int size = A.length;
            for (int i = startRow; i < endRow; i++) {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
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
