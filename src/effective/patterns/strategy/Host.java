package effective.patterns.strategy;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by tomi on 3/12/17.
 */
public class Host {
    private Host() {
        throw new RuntimeException();

    }

    private static class StrLengthComparator implements Comparator<String>, Serializable {
        private static final long serialVersionUID = 1L;

        @Override
        public int compare(final String o1, final String o2) {
            return o1.compareTo(o2);
        }
    }


}
