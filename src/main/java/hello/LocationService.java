package hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/marauder")
public class LocationService {

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody
    PersonLocation sendMyLocation(@RequestBody PersonLocation position) {
        return new PersonLocation(position.getName(), position.getLocation());
    }

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody
    List<PersonLocation> getLocations() {
        List<PersonLocation> locations = Arrays.asList(new PersonLocation("Mark", new Location(1.1, 2.2)), new PersonLocation("Dave", new Location(9.9, 8.8)));
        return locations;
    }
}
