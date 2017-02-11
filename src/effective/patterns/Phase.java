package effective.patterns;

/**
 * Created by tomi on 2/8/17.
 */
public enum Phase {

    SOLID, GAS, LIQUID, PHASE_UNDEFINED;

    public enum Transition {

        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID),
        UNDEFINED(PHASE_UNDEFINED, PHASE_UNDEFINED);

        final Phase src;
        final Phase dest;

        Transition(final Phase src, final Phase dest) {
            this.src = src;
            this.dest = dest;
        }

        public Phase getSrc() {
            return this.src;
        }

        public Phase getDest() {
            return this.dest;
        }

    }
}
