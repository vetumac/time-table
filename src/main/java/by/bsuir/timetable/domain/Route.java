package by.bsuir.timetable.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalTime;
import java.time.Period;
import java.util.Map;

public class Route {
    @Id
    private String id;
    private Long code;
    private LocalTime departure;
    private Period period;
    private Map<Long, Station> route;

    public Route(Long code, LocalTime departure, Period period, Map<Long, Station> route) {

        this.code = code;
        this.departure = departure;
        this.period = period;
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

    public LocalTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalTime departure) {
        this.departure = departure;
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
