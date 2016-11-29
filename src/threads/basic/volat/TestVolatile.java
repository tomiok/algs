package threads.basic.volat;

import java.util.Random;

/**
 * Created by tomi on 11/19/16.
 */
public class TestVolatile {

    public static void main(final String[] args) throws InterruptedException {
        final App app = new App();
        final Thread t = new Thread(app);

        t.start();
        Thread.sleep(300);
        app.setTerminated(true);

        System.out.println("Finished");
    }
}


class App implements Runnable {

    //Not cache the value for this field.
    private volatile boolean isTerminated = false;

    @Override
    public void run() {
        //always the current thread will check the value.
        while (!isTerminated) {
            final Random random = new Random();
            System.out.println("Working " + Thread.currentThread().getName());
        }
    }

    public void setTerminated(final boolean isTerminated) {
        this.isTerminated = isTerminated;
    }
}
