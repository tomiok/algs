package weather.main;

import weather.local.LocalResource;
import weather.lookup.AirportLookup;
import weather.lookup.AirportLookupService;
import weather.providers.OpenWeatherProvider;
import weather.providers.StrategicProvider;

/**
 * Created by tomi on 2/12/17.
 */
public class App {

    public static void main(final String[] args) {
        final AirportLookupService service = new AirportLookup();
        final StrategicProvider provider = new OpenWeatherProvider();
        final LocalResource resource = new LocalResource(service, provider);

        final String response = resource.exposedLocalEndpoint("LON");

        System.out.println(response);
    }
}
