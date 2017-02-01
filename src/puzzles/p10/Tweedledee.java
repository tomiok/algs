package puzzles.p10;

/**
 * Created by tomi on 1/24/17.
 */
public class Tweedledee {

    public static void main(final String[] args) {
        Object x = "tomi";
        final String i = "effective";

        x = x + i;
        x += i;
        System.out.println(x);
    }
}
