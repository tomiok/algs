package threads.basic.producerconsumer.first;

/**
 * Created by tomi on 11/28/16.
 */
public class App {

    private static final Producer producer = new Producer();

    public static void main(final String[] args) {
        final Thread t1 = new Thread(() -> {
            try {
                producer.produce();
            } catch (final InterruptedException e) {
                e.printStackTrace();
                e.getCause();
            }
        });

        final Thread t2 = new Thread(() -> {
            try {
                producer.consume();
            } catch (final InterruptedException e) {
                e.printStackTrace();
                e.getCause();
            }
        });


        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (final InterruptedException w) {
            w.printStackTrace();
            w.getCause();
        }
    }
}


class Producer {


    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producing...");
            wait();
            System.out.println("Producing, again...");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        synchronized (this) {
            System.out.println("consuming...");
            Thread.sleep(3000);
            notify();
        }
    }


}