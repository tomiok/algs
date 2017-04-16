package generics;

/**
 * Created by tomi on 4/16/17.
 */
public class Building extends Construction {

    private final Address address;
    private final int numOfFloors;
    private final boolean hasPool;

    public Building(final Address address, final int numOfFloors, final boolean hasPool) {
        this.address = address;
        this.numOfFloors = numOfFloors;
        this.hasPool = hasPool;
    }

    public Address getAddress() {
        return address;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public boolean isHasPool() {
        return hasPool;
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
        final StringBuilder sb = new StringBuilder("Building{");
        sb.append("address=").append(address);
        sb.append(", numOfFloors=").append(numOfFloors);
        sb.append(", hasPool=").append(hasPool);
        sb.append('}');
        return sb.toString();
    }
}
