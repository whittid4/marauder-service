package marauder;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import marauder.pojo.PersonPosition;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class LocationMap {

    private static Cache<String, PersonPosition> locationMap;


    public LocationMap() {
        locationMap = CacheBuilder.newBuilder()
                                  .expireAfterWrite(1, TimeUnit.MINUTES)
                                  .build();

    }

    public void addLocation(PersonPosition newLocation) {
        locationMap.put(newLocation.getName(), newLocation);
    }

    public Collection<PersonPosition> getAllLocations() {
        return locationMap.asMap().values();
    }
}
