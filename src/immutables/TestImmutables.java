package immutables;

/**
 * Created by tomi on 11/18/16.
 */
public class TestImmutables {


    public static void main(final String[] args) {
        final ImmutableSpaceShip spaceShip = ImmutableSpaceShip.of("Bang", SpaceDestination.MOON);
        final ImmutableSpaceShip spaceShip2 = spaceShip.explore(SpaceDestination.MARS);
    }
}
