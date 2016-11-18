package immutables;

/**
 * Created by tomi on 11/17/16.
 */
public final class ImmutableSpaceShip {

    private final String name;
    private final SpaceDestination destination;

    private ImmutableSpaceShip(final String name, final String destination) {
        this.name = name;
        this.destination = new SpaceDestination(destination);
    }

    public static ImmutableSpaceShip of(final String name, final String destination) {
        return new ImmutableSpaceShip(name, destination);
    }

    public ImmutableSpaceShip explore(final String destination) {
        return new ImmutableSpaceShip(this.name, destination);
    }

    @Override
    public String toString() {
        return "ImmutableSpaceShip{" +
                "name='" + name + '\'' +
                ", destination=" + destination +
                '}';
    }
}
