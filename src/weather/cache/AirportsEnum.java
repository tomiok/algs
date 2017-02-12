package weather.cache;

/**
 * Created by tomi on 2/12/17.
 */
public enum AirportsEnum {

    LON(11.32, 22.33);

    private final double lat;
    private final double lon;

    AirportsEnum(final double lat, final double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
