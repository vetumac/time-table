package by.bsuir.timetable.domain;

import org.springframework.data.annotation.Id;

import java.time.OffsetDateTime;
import java.time.Period;
import java.util.Map;

public class Route {
    @Id
    private String id;
    private Long code;
    private OffsetDateTime firstDeparture;
    private OffsetDateTime lastDeparture;
    private Period period;
    private Map<Long, Station> route;

    public Route() {
    }

    public Route(Long code, OffsetDateTime firstDeparture, OffsetDateTime lastDeparture, Period period, Map<Long, Station> route) {
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

    public OffsetDateTime getFirstDeparture() {
        return firstDeparture;
    }

    public void setFirstDeparture(OffsetDateTime firstDeparture) {
        this.firstDeparture = firstDeparture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OffsetDateTime getLastDeparture() {
        return lastDeparture;
    }

    public void setLastDeparture(OffsetDateTime lastDeparture) {
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
