package by.bsuir.timetable.rest.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class Route {
    @Id
    private String id;

    @Indexed(unique = true)
    private Long code;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime firstDeparture;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime end;

    private Long period;

    private List<Point> points;

    public Route() {
    }

    public Route(Long code, LocalDateTime firstDeparture, LocalDateTime end, Long period, List<Point> points) {
        this.code = code;
        this.firstDeparture = firstDeparture;
        this.end = end;
        this.period = period;
        this.points = points;
    }

    public Long getCode() {
        return code;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public LocalDateTime getFirstDeparture() {
        return firstDeparture;
    }

    public void setFirstDeparture(LocalDateTime firstDeparture) {
        this.firstDeparture = firstDeparture;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Route)) return false;

        Route route = (Route) o;

        return code.equals(route.code);

    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
