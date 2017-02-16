package weather.local;

import weather.cache.AirportsEnum;
import weather.lookup.AirportLookupService;
import weather.model.Geocode;
import weather.providers.StrategicProvider;

/**
 * Created by tomi on 2/12/17.
 */
public class LocalResource {

    AirportLookupService lookupService;
    StrategicProvider strategicProvider;

    public LocalResource(AirportLookupService lookupService, StrategicProvider strategicProvider) {
        this.lookupService = lookupService;
        this.strategicProvider = strategicProvider;
    }

    /**
     * localhost:1400/airport?a=LON
     *
     * @param airport
     */
    public String exposedLocalEndpoint(final String airport) {
        final AirportsEnum a = AirportsEnum.valueOf(airport);

        final Geocode g = lookupService.getGeocode(a);

        String endpoint = strategicProvider.getEndpoint(g);
        String response = callExternal(endpoint);

        return response;
    }

    private String callExternal(String endpoint) {
        if (endpoint.isEmpty()) return "Bad luck";

        return "OK";
    }


}
