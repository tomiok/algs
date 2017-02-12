package weather.lookup;

import weather.cache.AirportsEnum;
import weather.model.Geocode;

/**
 * Created by tomi on 2/12/17.
 */
public interface AirportLookupService {

    Geocode getGeocode(AirportsEnum airport);
}
