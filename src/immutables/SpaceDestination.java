package immutables;

/**
 * Created by tomi on 11/17/16.
 */
public class SpaceDestination {

    public static final String NONE = "none";
    public static final String MOON = "moon";
    public static final String MARS = "mars";
    private final String destination;

    public SpaceDestination(final String destination) {
        switch (destination) {
            case MARS:
                this.destination = MARS;
                break;
            case MOON:
                this.destination = MOON;
                break;
            case NONE:
                this.destination = NONE;
                break;
            default:
                this.destination = NONE;
        }
    }

    @Override
    public String toString() {
        return "SpaceDestination{" +
                "destination='" + destination + '\'' +
                '}';
    }
}
