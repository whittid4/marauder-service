package marauder;

import marauder.pojo.PersonPosition;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LocationMap {

    private static Map<String, PersonPosition> locationMap;

    public LocationMap() {
        locationMap = new HashMap<String, PersonPosition>();
    }

    public PersonPosition addLocation(PersonPosition newLocation) {
        return locationMap.put(newLocation.getName(), newLocation);
    }

    public Collection<PersonPosition> getAllLocations() {
        return locationMap.values();
    }
}
