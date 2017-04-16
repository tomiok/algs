package generics;

/**
 * Created by tomi on 4/16/17.
 */
public class Address {

    private final String street;
    private final String number;

    public Address(final String street, final String number) {
        this.number = number;
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("street='").append(street).append('\'');
        sb.append(", number='").append(number).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
