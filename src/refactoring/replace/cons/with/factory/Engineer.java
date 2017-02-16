package refactoring.replace.cons.with.factory;

/**
 * Created by tomi on 05/02/17.
 */
public class Engineer extends Employee {

    private String engineerSector;


    public String getEngineerSector() {
        return engineerSector;
    }

    public void setEngineerSector(final String engineerSector) {
        this.engineerSector = engineerSector;
    }
}
