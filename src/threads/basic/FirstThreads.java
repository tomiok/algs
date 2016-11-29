package threads.basic;

/**
 * Created by tomi on 11/19/16.
 */
public class FirstThreads {

    public static void main(final String[] args) {
        final Thread t = new Thread(new RunnableCounter());


        final Thread t2 = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                System.out.println("From lambda" + i + " " + Thread.currentThread().getName());
                try {
                    Thread.sleep(450);
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        t2.start();

        try {
            t.join();
            t2.join();
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Finalized...");
    }

}

class RunnableCounter implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {

            System.out.println("Counter: " + i + " " + Thread.currentThread().getName());

            try {
                Thread.sleep(450);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
