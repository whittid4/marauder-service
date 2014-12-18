package marauder.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersonPosition {

    private String name;
    private Position position;
    private LocalDateTime timestamp;

    public PersonPosition(String name, Position position, LocalDateTime timestamp) {
        this.name = name;
        this.position = position;
        this.timestamp = timestamp;
    }

    public PersonPosition() {
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @JsonIgnore
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public String getTimestampString() {
        return DateTimeFormatter.ISO_DATE_TIME.format(timestamp);
    }

}
