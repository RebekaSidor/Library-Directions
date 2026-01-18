package gr.hua.dit.LibraryDirections.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "library.directions")
public class LibraryDirectionProperties {

    /**
     * Library address used as destination in Google Maps
     */
    private String destinationAddress;

    /**
     * Maps provider base URL
     */
    private String mapsBaseUrl;

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getMapsBaseUrl() {
        return mapsBaseUrl;
    }

    public void setMapsBaseUrl(String mapsBaseUrl) {
        this.mapsBaseUrl = mapsBaseUrl;
    }

    private String apiKey;
    private String originCoordinates; // πχ "37.9838,23.7275" για Αθήνα
    public String getApiKey() { return apiKey; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }

    public String getOriginCoordinates() { return originCoordinates; }
    public void setOriginCoordinates(String originCoordinates) { this.originCoordinates = originCoordinates; }

}
