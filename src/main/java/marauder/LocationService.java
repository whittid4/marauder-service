package marauder;

import com.google.common.collect.Lists;
import marauder.pojo.ItemPosition;
import marauder.pojo.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;

@Controller
@RequestMapping("/marauder")
public class LocationService {

    private final LocationMap locationMap;

    private static final Collection<ItemPosition> HOTSPOT_POSITIONS = Lists.newArrayList(
           new ItemPosition("74:26:ac:75:cb:14", "", new Position(0.169000, 0.174321, 5), LocalDateTime.now()),
           new ItemPosition("74:26:ac:77:06:04", "", new Position(0.276000, 0.255858, 5), LocalDateTime.now()),
           new ItemPosition("74:26:ac:75:cc:30", "", new Position(0.477000, 0.207123, 5), LocalDateTime.now()),
           new ItemPosition("74:26:ac:77:06:10", "", new Position(0.048000, 0.466729, 5), LocalDateTime.now()),
           new ItemPosition("74:26:ac:76:ff:b0", "", new Position(0.245000, 0.602624, 5), LocalDateTime.now()),
           new ItemPosition("74:26:ac:77:06:08", "", new Position(0.080000, 0.773196, 5), LocalDateTime.now()),
           new ItemPosition("74:26:ac:77:05:24", "", new Position(0.348000, 0.719775, 5), LocalDateTime.now()),
           new ItemPosition("74:26:ac:72:66:7c", "", new Position(0.481000, 0.630740, 5), LocalDateTime.now()),
           new ItemPosition("74:26:ac:5b:d3:88", "", new Position(0.562000, 0.848172, 5), LocalDateTime.now()),
           new ItemPosition("74:26:ac:75:ca:b4", "", new Position(0.592000, 0.714152, 5), LocalDateTime.now()),
           new ItemPosition("74:26:ac:77:03:18", "", new Position(0.810000, 0.675726, 5), LocalDateTime.now()),
           new ItemPosition("74:26:ac:77:02:8c", "", new Position(0.870000, 0.475164, 5), LocalDateTime.now()),
           new ItemPosition("74:26:ac:77:06:50", "", new Position(0.713000, 0.351453, 5), LocalDateTime.now()),
           new ItemPosition("74:26:ac:77:05:a0", "", new Position(0.864000, 0.292409, 5), LocalDateTime.now()),
           new ItemPosition("74:26:ac:75:c1:48", "", new Position(0.795000, 0.137769, 5), LocalDateTime.now())
    );

    @Autowired
    public LocationService(LocationMap locationMap) {
        this.locationMap = locationMap;
    }

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody
    ItemPosition sendMyLocation(@RequestBody ItemPosition position) {
        position.setTimestamp(LocalDateTime.now());
        locationMap.addLocation(position);
        return position;
    }

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody
    Collection<ItemPosition> getLocations() {
        return locationMap.getAllLocations();
    }

    @RequestMapping("/hotspots")
    public @ResponseBody
    Collection<ItemPosition> getHotspotLocations() {
        return HOTSPOT_POSITIONS;
    }
}
