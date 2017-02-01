package firstAlgs.racecondition;

/**
 * Created by tomi on 1/1/17.
 */
public class RaceCondition {

    public static void main(final String[] args) throws InterruptedException {
        final LongWrapper lw = new LongWrapper(0L);

        final Runnable r = () -> {

            for (int i = 0; i < 1_000; i++) {
                lw.increment();
            }
        };

        final Thread[] t = new Thread[1_000];

        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(r);
            t[i].start();


        }

        for (int i = 0; i < t.length; i++) {
            t[i].join();
        }


        System.out.println(lw.getL());
    }
}
