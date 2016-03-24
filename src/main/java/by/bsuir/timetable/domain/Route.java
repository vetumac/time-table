package by.bsuir.timetable.domain;

import org.springframework.data.annotation.Id;

import java.time.ZonedDateTime;
import java.util.Map;

public class Route {
    @Id
    private String id;
    private Long code;
    private ZonedDateTime departure;
    private Map<Long, Station> route;

    public Route(Long code, ZonedDateTime departure, Map<Long, Station> route) {
        this.code = code;
        this.departure = departure;
        this.route = route;
    }

    public Route() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public ZonedDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(ZonedDateTime departure) {
        this.departure = departure;
    }

    public Map<Long, Station> getRoute() {
        return route;
    }

    public void setRoute(Map<Long, Station> route) {
        this.route = route;
    }
}
