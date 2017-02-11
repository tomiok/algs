package effective.patterns;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by tomi on 2/8/17.
 */
public class EnumPattern {

    private static final Map<Phase, Map<Phase, Phase.Transition>> transitions =
            new EnumMap<>(Phase.class);

    static {
        for (final Phase ph : Phase.values()) {
            transitions.put(ph, new EnumMap<>(Phase.class));
        }

        for (final Phase.Transition transition : Phase.Transition.values()) {
            transitions.get(transition.src).put(transition.dest, transition);
        }

    }

    public static Phase.Transition from(final Phase src, final Phase dest) {
        return transitions.get(src).get(dest) == null ? Phase.Transition.UNDEFINED :
                transitions.get(src).get(dest);
    }


}

class App {

    public static void main(final String[] args) {
        final EnumPattern e = new EnumPattern();
        System.out.println(EnumPattern.from(Phase.GAS, Phase.LIQUID));
    }
}
