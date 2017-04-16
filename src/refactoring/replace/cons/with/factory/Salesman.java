package refactoring.replace.cons.with.factory;

/**
 * Created by tomi on 05/02/17.
 */
public class Salesman extends Employee {

    private String salesSector;


    public String getSalesSector() {
        return salesSector;
    }

    public void setSalesSector(final String salesSector) {
        this.salesSector = salesSector;
    }
}
