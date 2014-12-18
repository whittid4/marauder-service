package hello;

public class Location {
    private Double x;
    private Double y;
    private Integer floor;

    public Location(Double x, Double y, Integer floor) {
        this.x = x;
        this.y = y;
    }

    public Location() {
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Integer getFloor() {
        return floor;
    }
}
