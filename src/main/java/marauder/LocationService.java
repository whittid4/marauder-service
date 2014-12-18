package marauder;

import marauder.pojo.PersonPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;

@Controller
@RequestMapping("/marauder")
public class LocationService {

    private final LocationMap locationMap;

    @Autowired
    public LocationService(LocationMap locationMap) {
        this.locationMap = locationMap;
    }

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody
    PersonPosition sendMyLocation(@RequestBody PersonPosition position) {
        position.setTimestamp(LocalDateTime.now());
        locationMap.addLocation(position);
        return position;
    }

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody
    Collection<PersonPosition> getLocations() {
        return locationMap.getAllLocations();
    }
}
