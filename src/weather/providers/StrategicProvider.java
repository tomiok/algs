package weather.providers;

import weather.model.Geocode;

/**
 * Created by tomi on 2/12/17.
 */
public interface StrategicProvider {

    String getEndpoint(Geocode geocode);

    default String endpointResolver(final String endpoint, final double lat, final double lon) {
        return String.format(endpoint, lat, lon);
    }
}
