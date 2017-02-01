package puzzles.p13;

/**
 * Created by tomi on 1/25/17.
 */
public class AnimalsFarm {

    public static void main(final String[] args) {

        final String pig = "length: 10";
        final String dog = "length: " + pig.length();

        System.out.println(pig.equals(dog));
        System.out.println(pig == dog);
    }
}
