package weather.model;

/**
 * Created by tomi on 2/12/17.
 */
public class Geocode {

    private final double latitude;
    private final double longitude;


    public Geocode(final double latitude, final double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
