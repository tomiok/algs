package weather.providers;

import weather.model.Geocode;

/**
 * Created by tomi on 2/12/17.
 */
public class OpenWeatherProvider implements StrategicProvider {

    @Override
    public String getEndpoint(final Geocode geocode) {
        final String endpointMasked = "openweather.external.api?lat=%1$s/lon=%2$s";
        final String endpoint = this.endpointResolver(endpointMasked, geocode.getLatitude(), geocode.getLongitude());
        System.out.println("Endpoint to hit: " + endpoint);
        return endpoint;
    }
}
