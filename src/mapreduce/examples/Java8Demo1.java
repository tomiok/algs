package mapreduce.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by tomi on 1/8/17.
 */
public class Java8Demo1 {

    public static void main(final String[] args) {
        final List<String> countries = Arrays.asList("USA", "ARG", "COLOMBIA", "CHILE", "JAPAN");
        final List<String> countries2 = Arrays.asList("USA", "ARG", "COLOMBIA", "CHILE", "JAPAN");

        final Map<String, Integer> mapped = countries
                .stream()
                .collect(Collectors.toMap(s -> String.valueOf(s.charAt(0) + "" + s.charAt(1)), v -> v.length(), (l, r) -> l));


        System.out.println(mapped);

    }
}
