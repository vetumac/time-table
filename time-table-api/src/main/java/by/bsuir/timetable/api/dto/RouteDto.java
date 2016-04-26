package by.bsuir.timetable.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.List;

public class RouteDto {

    private String id;

    private Long code;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime firstDeparture;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime end;

    private Long period;

    private List<PointDto> points;

    public RouteDto() {
    }

    public RouteDto(Long code, LocalDateTime firstDeparture, LocalDateTime end, Long period, List<PointDto> points) {
        this.code = code;
        this.firstDeparture = firstDeparture;
        this.end = end;
        this.period = period;
        this.points = points;
    }

    public Long getCode() {
        return code;
    }

    public List<PointDto> getPoints() {
        return points;
    }

    public void setPoints(List<PointDto> points) {
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
        if (!(o instanceof RouteDto)) return false;

        RouteDto route = (RouteDto) o;

        return code.equals(route.code);

    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
