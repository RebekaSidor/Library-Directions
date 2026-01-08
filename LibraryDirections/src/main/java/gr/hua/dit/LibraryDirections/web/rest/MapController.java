package gr.hua.dit.LibraryDirections.web.rest;

import gr.hua.dit.LibraryDirections.core.MapService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gr.hua.dit.LibraryDirections.core.model.Map;


@RestController
@RequestMapping("/api/map")
public class MapController {

    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping("/directions")
    public Map getDirections() {
        return mapService.getDirections();
    }

}
