package gr.hua.dit.LibraryDirections.core.model;

import java.util.List;

/**
 * DTO για το JSON που επιστρέφει το Google Directions API
 */
public record GoogleDirectionsResponse(
        List<Route> routes
) {

    public record Route(
            List<Leg> legs
    ) {}

    public record Leg(
            Distance distance,
            Duration duration
    ) {}

    public record Distance(
            int value // σε μέτρα
    ) {}

    public record Duration(
            int value // σε δευτερόλεπτα
    ) {}
}