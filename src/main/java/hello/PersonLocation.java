package hello;

public class PersonLocation {

    private String name;
    private Location location;

    public PersonLocation(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public PersonLocation() {
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
}
