package threads.basic.producerconsumer.second;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomi on 11/29/16.
 */
public class App {

    static Processor processor = new Processor();


    public static void main(final String[] args) throws InterruptedException {

        final Runnable r1 = () -> {
            try {
                processor.produce();
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        };

        final Runnable r2 = () -> {
            try {
                processor.consume();
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        };


        final Thread t1 = new Thread(r1);
        final Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}


class Processor {

    private static final int LIMIT = 10;
    private final Object LOCK = new Object();
    private final List<Integer> shared = new ArrayList<>();

    public void produce() throws InterruptedException {
        int value = 0;

        while (true) {
            synchronized (LOCK) {
                while (this.shared.size() == LIMIT) {
                    LOCK.wait();
                }
                this.shared.add(value);
                value++;
                System.out.println("Produced" + value);
                LOCK.notify();

            }
        }
    }


    public void consume() throws InterruptedException {

        while (true) {
            synchronized (LOCK) {
                while (this.shared.isEmpty()) {
                    LOCK.wait();
                }
                final int value = this.shared.remove(0);
                System.out.println("Consumed and removed " + value);
                LOCK.notify();
            }
            Thread.sleep(1000);
        }
    }
}
