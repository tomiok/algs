package weather.lookup;

import weather.cache.AirportsEnum;
import weather.model.Geocode;

/**
 * Created by tomi on 2/12/17.
 */
public class AirportLookup implements AirportLookupService {

    @Override
    public Geocode getGeocode(final AirportsEnum airport) {
        final double lat = airport.getLat();
        final double lon = airport.getLon();

        return new Geocode(lat, lon);
    }
}
