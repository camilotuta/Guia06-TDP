// cSpell:ignore guia

package guia06.tp.Session02.ProductorConsumidor;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

    private static final int QUEUE_CAPACITY = 10;

    public static void main(String[] args) {

        BlockingQueue<Integer> buffer = new LinkedBlockingQueue<>(QUEUE_CAPACITY);

        Thread hiloProducer = new Thread(new Producer(buffer));
        Thread hiloConsumer = new Thread(new Consumer(buffer));

        hiloProducer.start();
        hiloConsumer.start();
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
                    int numero = random.nextInt(100) + 1;
                    System.out.println("Productor genera: " + numero);
                    buffer.put(numero);
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
                    int numero = buffer.take();
                    System.out.println("Consumidor lee: " + numero + ", multiplica por 2: " + (numero * 2));
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
