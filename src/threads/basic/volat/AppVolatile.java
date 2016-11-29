package threads.basic.volat;

/**
 * Created by tomi on 11/19/16.
 */
public class AppVolatile {

    //private static final AtomicInteger counter = new AtomicInteger();
    private static int counter = 0;
    static Runnable runnable = () -> {
        for (int i = 0; i < 1900; i++) {
            //   counter.incrementAndGet();
            increment();
        }
    };

    private static synchronized void increment() {
        counter++;
    }

    static void process() {
        final Thread t1 = new Thread(runnable);
        final Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (final InterruptedException e) {

        }
    }

    public static void main(final String[] args) {
        process();
        System.out.println(counter);
        System.out.println("Finished");
    }
}
