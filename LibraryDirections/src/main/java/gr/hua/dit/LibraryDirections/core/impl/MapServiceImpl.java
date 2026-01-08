package gr.hua.dit.LibraryDirections.core.impl;

import gr.hua.dit.LibraryDirections.config.LibraryDirectionProperties;
import gr.hua.dit.LibraryDirections.core.MapService;
import gr.hua.dit.LibraryDirections.core.model.Map;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Service
public class MapServiceImpl implements MapService {

    private final LibraryDirectionProperties properties;

    public MapServiceImpl(LibraryDirectionProperties properties) {
        this.properties = properties;
    }

    @Override
    @Cacheable("directions")
    public Map getDirections() {

        Map map = new Map();
        map.setOrigin("Current Location");
        map.setDestination(properties.getDestinationAddress());
        map.setProvider("Google Maps");

        try {
            String destination =
                    URLEncoder.encode(properties.getDestinationAddress(), "UTF-8");

            String url = properties.getMapsBaseUrl()
                    + "&origin=Current+Location"
                    + "&destination=" + destination;

            map.setDirectionsUrl(url);

        } catch (UnsupportedEncodingException e) {
            map.setDirectionsUrl("https://www.google.com/maps");
        }

        return map;
    }
}

