package firstAlgs.racecondition;

/**
 * Created by tomi on 10/23/16.
 */
public class LongWrapper {

    private final Object key = new Object();
    private long l;

    public LongWrapper(final Long l) {
        this.l = l;
    }

    public long getL() {
        return l;
    }

    public void increment() {
        synchronized (key) {
            this.l += 1;
        }
    }
}
