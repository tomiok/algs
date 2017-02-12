package j2se8.sample.lambdas.reductions;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Gender {
    MALE, FEMALE
}

/**
 * Created by tomi on 2/11/17.
 */
public class SimpleReduction {

    public static void main(final String[] args) {
        final Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);

        final Optional<Integer> max = ints.max(Integer::compareTo);
        max.ifPresent(System.out::println);

        //avoid stream already upon or closed.
        final Stream<Integer> int2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);
        final Optional<Integer> min = int2.min(Integer::compareTo);

        min.ifPresent(System.out::println);


        // final Stream<String> l = Stream.generate(() -> "this is a long string, tommy.").limit(1L);
        final Stream<String> l = Stream.concat(Stream.of("tomi, dude"), Stream.of("this is a string"));
        final Optional<String> oStr = l.filter(s -> s.startsWith("t")).findAny();
        //final Optional<String> oStr = l.filter(s -> s.startsWith("t")).findFirst();
        //allMatch(Predicate<T> p)
        //anyMatch(Predicate<T> p);

        oStr.ifPresent(System.out::println);


        final Optional<Double> n = Optional.of(-4.0d).flatMap(SimpleReduction::inverse).flatMap(SimpleReduction::sqRoot);
        System.out.println("Using flatMap: " + n.get());

        //
        // reduce method.
        //

        final Stream<Person> persons = Stream.of(new Person("Tomas", 27), new Person("Sherman", 30), new Person("India", 1));
        final Integer sum = persons.map(Person::getAge).reduce(0, (a, b) -> a + b);

        System.out.println("Reduce operation: " + sum);


        //
        // collect method.
        //

        //grouping by gender (object person)
        final Stream<Person> persons2 = Stream.of(new Person("Tomas", 27, Gender.MALE), new Person("Sherman", 30, Gender.MALE), new Person("India", 1, Gender.FEMALE));
        final Map<Gender, List<Person>> pp = persons2.collect(Collectors.groupingBy(Person::getGender));

        System.out.println("Grouping by gender with whole Person Object: " + pp);

        //grouping by gender and mapping only the name (not all the object)
        final Stream<Person> persons3 = Stream.of(new Person("Tomas", 27, Gender.MALE),
                new Person("Sherman", 30, Gender.MALE),
                new Person("India", 1, Gender.FEMALE),
                new Person("Tomas", 99));

        //final Map<Gender, List<String>> namesByGender = persons3.collect(Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getName, Collectors.toList())));
        //System.out.println("Names by Gender: " + namesByGender);
        //final Map<String, Integer> mapped = persons3.collect(Collectors.toMap(Person::getName, Person::getAge, (le, ri) -> le)); //need the merge function(binary opertor) if some key is duplicated. NOT GROUPING
        //System.out.println("Names by Age: " + mapped);

        //Another way to map some property and the value is the object - not grouping
        final Map<Gender, Person> objectMapper = persons3.collect(Collectors.toMap(Person::getGender, Function.identity(), (le, ri) -> le)); //merge function needed if could reach some duplicated key
        System.out.println(objectMapper);


        //
        // joining collector.
        //

        final Stream<String> st = Stream.of("hola", "como", "andas", "bro");

        final String finalString = st.collect(Collectors.joining(" "));

        System.out.println(finalString);


        //
        // summary statistics.
        //
        final Stream<Person> persons4 = Stream.of(new Person("Tomas", 27, Gender.MALE), new Person("Sherman", 30, Gender.MALE), new Person("India", 1, Gender.FEMALE));
        final IntSummaryStatistics s = persons4.collect(Collectors.summarizingInt(Person::getAge));
        System.out.println("Summary: " + s);
    }


    private static Optional<Double> inverse(final Double d) {
        return d == null ? Optional.empty() : Optional.of(d * (-1d));
    }

    private static Optional<Double> sqRoot(final Double n) {
        return n > 0 ? Optional.of(Math.sqrt(n)) : Optional.empty();
    }


}

class Person {
    String name;
    Integer age;
    Gender gender;

    public Person(final String name, final Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(final String name, final Integer age, final Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", gender=").append(gender);
        sb.append('}');
        return sb.toString();
    }
}
