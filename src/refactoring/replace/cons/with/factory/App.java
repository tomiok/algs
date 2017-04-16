package refactoring.replace.cons.with.factory;

/**
 * Created by tomi on 05/02/17.
 */
public class App {

    public static void main(final String[] args) {
        final Engineer e = Employee.create("refactoring.replace.cons.with.factory.Engineer");

        e.setEngineerSector("Computer science");

        System.out.println(e.getEngineerSector());
    }
}
