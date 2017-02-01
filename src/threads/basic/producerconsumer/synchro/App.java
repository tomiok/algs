package threads.basic.producerconsumer.synchro;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by tomi on 1/28/17.
 */
public class App {
    static final ConcurrentLinkedQueue<? super Object> queue = new ConcurrentLinkedQueue<>();
    private static final Object LOCK = new Object();
    static int count = 0;

    public static void main(final String[] args) throws InterruptedException {
        final Producer p = new Producer();
        final Consumer c = new Consumer();

        final Runnable producerTask = () ->
        {
            for (int i = 0; i < 10; i++) {
                p.produce();
            }
            System.out.println("Done producing.");
        };

        final Runnable consumerTask = () -> {
            for (int i = 0; i < 10; i++) {
                c.consume();
            }
            System.out.println("Done consuming.");
        };

        final Thread consumerThread = new Thread(consumerTask);
        final Thread producerThread = new Thread(producerTask);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("Count: " + count);

        System.out.println(queue);

    }

    private static class Producer {

        void produce() {
            synchronized (LOCK) {
                if (queue.size() >= 9) {
                    try {
                        LOCK.wait();
                    } catch (final InterruptedException e) {
                    }
                }
                count++;
                System.out.println("sum + 1");
                queue.add(new Input(String.valueOf(count)));
                LOCK.notify();
            }
        }
    }

    private static class Consumer {

        void consume() {
            synchronized (LOCK) {

                if (queue.isEmpty()) {
                    try {
                        LOCK.wait();
                    } catch (final InterruptedException e) {

                    }
                }
                --count;
                System.out.println("Sum -1");
                queue.poll();
                LOCK.notify();
            }
        }
    }

}

class Input {

    private final String buffetti;

    public Input(final String buffetti) {
        this.buffetti = buffetti;
    }

    public String getBuffetti() {
        return buffetti;
    }

    @Override
    public String toString() {
        return "Input{" +
                "buffetti='" + buffetti + '\'' +
                '}';
    }
}

/**
 * Staties of Threads:
 * <p>
 * Runnable: that the ones that can be reach from the Scheduler.
 * Blocked: can only run again when the key is released. (can cause a block for the entire app)
 * Waiting: can only run again when the notify method is called. (can cause a block for the entire app)
 * <p>
 * Thread.getCurrent().getState();
 * <p>
 * <p>
 * Synchronized block protect that 2 threads execute the same piece of code.
 * Prevents race conditions.
 * <p>
 * <p>
 * Synchronized block protect that 2 threads execute the same piece of code.
 * Prevents race conditions.
 * <p>
 * <p>
 * Synchronized block protect that 2 threads execute the same piece of code.
 * Prevents race conditions.
 * <p>
 * <p>
 * Synchronized block protect that 2 threads execute the same piece of code.
 * Prevents race conditions.
 * <p>
 * <p>
 * Synchronized block protect that 2 threads execute the same piece of code.
 * Prevents race conditions.
 * <p>
 * <p>
 * Synchronized block protect that 2 threads execute the same piece of code.
 * Prevents race conditions.
 * <p>
 * <p>
 * Synchronized block protect that 2 threads execute the same piece of code.
 * Prevents race conditions.
 * <p>
 * <p>
 * Synchronized block protect that 2 threads execute the same piece of code.
 * Prevents race conditions.
 * <p>
 * <p>
 * Synchronized block protect that 2 threads execute the same piece of code.
 * Prevents race conditions.
 * <p>
 * <p>
 * Synchronized block protect that 2 threads execute the same piece of code.
 * Prevents race conditions.
 * <p>
 * <p>
 * Synchronized block protect that 2 threads execute the same piece of code.
 * Prevents race conditions.
 * <p>
 * <p>
 * Synchronized block protect that 2 threads execute the same piece of code.
 * Prevents race conditions.
 * <p>
 * <p>
 * Synchronized block protect that 2 threads execute the same piece of code.
 * Prevents race conditions.
 * <p>
 * <p>
 * Synchronized block protect that 2 threads execute the same piece of code.
 * Prevents race conditions.
 */


/**
 *
 *  Synchronized block protect that 2 threads execute the same piece of code.
 *  Prevents race conditions.
 *
 */


