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
}
