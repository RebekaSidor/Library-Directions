package gr.hua.dit.LibraryDirections.core.impl;

import gr.hua.dit.LibraryDirections.config.LibraryDirectionProperties;
import gr.hua.dit.LibraryDirections.core.MapService;
import gr.hua.dit.LibraryDirections.core.model.GoogleDirectionsResponse;
import gr.hua.dit.LibraryDirections.core.model.Map;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Service
public class MapServiceImpl implements MapService {

    private final LibraryDirectionProperties properties;
    private final RestTemplate restTemplate;

    public MapServiceImpl(LibraryDirectionProperties properties,
                          RestTemplate restTemplate) {
        this.properties = properties;
        this.restTemplate = restTemplate;
    }

    @Override
    @Cacheable("directions")
    public Map getDirections() {
        Map map = new Map();
        map.setOrigin(properties.getOriginCoordinates());
        map.setDestination(properties.getDestinationAddress());
        map.setProvider("Google Maps");

        try {
            String origin = URLEncoder.encode(properties.getOriginCoordinates(), "UTF-8");
            String destination = URLEncoder.encode(properties.getDestinationAddress(), "UTF-8");

            String apiUrl = properties.getMapsBaseUrl()
                    + "?origin=" + origin
                    + "&destination=" + destination
                    + "&key=" + properties.getApiKey();

            // ✅ REST CALL στο Google Directions API
            GoogleDirectionsResponse response =
                    restTemplate.getForObject(apiUrl, GoogleDirectionsResponse.class);

            if (response != null && !response.routes().isEmpty()) {
                var leg = response.routes().get(0).legs().get(0);

                map.setDistanceMeters(leg.distance().value());
                map.setDurationSeconds(leg.duration().value());
            }

            // Link για άνοιγμα Maps
            map.setDirectionsUrl(
                    "https://www.google.com/maps/dir/?api=1&origin="
                            + origin + "&destination=" + destination
            );

        } catch (Exception e) {
            map.setDirectionsUrl("https://www.google.com/maps");
        }

        return map;
    }
}
