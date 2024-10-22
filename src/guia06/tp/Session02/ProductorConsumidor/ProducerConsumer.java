package guia06.tp.Session02.ProductorConsumidor;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

    private static final int QUEUE_CAPACITY = 10;

    public static void main(String[] args) {

        BlockingQueue<Integer> buffer = new LinkedBlockingQueue<>(QUEUE_CAPACITY);

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }

    static class Producer implements Runnable {
        private BlockingQueue<Integer> buffer;
        private Random random = new Random();

        public Producer(BlockingQueue<Integer> buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    int number = random.nextInt(100) + 1;
                    System.out.println("Productor genera: " + number);
                    buffer.put(number);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Consumer implements Runnable {
        private BlockingQueue<Integer> buffer;

        public Consumer(BlockingQueue<Integer> buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    int number = buffer.take();
                    System.out.println("Consumidor lee: " + number + ", multiplica por 2: " + (number * 2));
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
