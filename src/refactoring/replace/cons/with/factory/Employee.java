package refactoring.replace.cons.with.factory;

/**
 * Created by tomi on 05/02/17.
 */
public abstract class Employee {

    private String id;
    private String name;

    public Employee() {

    }

    public Employee(final String name) {
        this.name = name;
    }

    public static <T extends Employee> T create(final String type) {

        try {
            return (T) Class.forName(type).newInstance();

            //return (T) Class.forName(type).newInstance();
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}
