package generics;

/**
 * Created by tomi on 4/16/17.
 */
public class House extends Construction {

    private final Address address;
    private final boolean hasGarden;

    public House(final Address address, final boolean hasGarden) {
        this.address = address;
        this.hasGarden = hasGarden;
    }

    public Address getAddress() {
        return address;
    }

    public boolean isHasGarden() {
        return hasGarden;
    }

    @Override
    protected void setPrice() {

    }

    @Override
    protected long getPrice() {
        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("House{");
        sb.append("address=").append(address);
        sb.append(", hasGarden=").append(hasGarden);
        sb.append('}');
        return sb.toString();
    }
}
