package j2se8.sample.lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tomi on 1/29/17.
 */
public class FruitsComparables {

    public static void main(final String[] args) {
        final List<String> fruits = Arrays.asList("Kiwi", "Apple", "Organge", "Mango", "Banana", "Peach", "Zek");

        System.out.println("Unordered: ");
        System.out.println();
        fruits.forEach(System.out::println);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Ordered: ");
        System.out.println();

        fruits.stream().sorted(String::compareToIgnoreCase).forEach(System.out::println);
    }
}
