package by.bsuir.timetable.domain;

import org.springframework.data.annotation.Id;

import java.time.Period;
import java.time.ZonedDateTime;
import java.util.Map;

public class Route {
    @Id
    private String id;
    private Long code;
    private ZonedDateTime firstDeparture;
    private ZonedDateTime lastDeparture;
    private Period period;
    private Map<Long, Station> route;

    public Route() {
    }

    public Route(Long code, ZonedDateTime firstDeparture, ZonedDateTime lastDeparture, Period period, Map<Long, Station> route) {
        this.code = code;
        this.firstDeparture = firstDeparture;
        this.lastDeparture = lastDeparture;
        this.period = period;
        this.route = route;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public ZonedDateTime getFirstDeparture() {
        return firstDeparture;
    }

    public void setFirstDeparture(ZonedDateTime firstDeparture) {
        this.firstDeparture = firstDeparture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ZonedDateTime getLastDeparture() {
        return lastDeparture;
    }

    public void setLastDeparture(ZonedDateTime lastDeparture) {
        this.lastDeparture = lastDeparture;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Map<Long, Station> getRoute() {
        return route;
    }

    public void setRoute(Map<Long, Station> route) {
        this.route = route;
    }
}
