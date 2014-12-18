package marauder.pojo;

public class Position {
    private Double x;
    private Double y;
    private Integer floor;

    public Position(Double x, Double y, Integer floor) {
        this.x = x;
        this.y = y;
        this.floor = floor;
    }

    public Position() {
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
