package effective.generics;

/**
 * Created by tomi on 1/25/17.
 */
public class Test {

    public static void main(final String[] args) {
        final Favorites f = new Favorites();

        f.putFav(String.class, "hola");
        f.putFav(String.class, "chau");
        f.putFav(Long.class, 99L);


        System.out.println(f.getFav(String.class));


    }
}
