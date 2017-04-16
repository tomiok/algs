package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by tomi on 4/16/17.
 */
public class MainApp {

    public static void main(final String[] args) {
        final Building b1 = new Building(new Address("Cordoba ", "778"), 3, false);
        final House h1 = new House(new Address("Sante Fe", "990"), false);
        final House h2 = new House(new Address("Callao", "751"), true);
        final List<Construction> houses = new ArrayList<>();
        addConstructions(houses, h1, h2, b1);
    }

    /**
     *
     * @param list with the fahter class, in this case is  #Construction
     * @param construction
     * @param <T> a varArgs with classes extending Construction.
     * @see Construction
     */
    private static <T extends Construction> void addConstructions(final List<T> list, final T... construction) {
        Stream.of(construction).forEach(list::add);
        list.forEach(System.out::print);
    }
}
