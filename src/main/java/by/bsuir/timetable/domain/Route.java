package by.bsuir.timetable.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalTime;
import java.util.Map;

public class Route {
    @Id
    private String id;
    private Long code;
    private LocalTime firstDeparture;
    private LocalTime lastDeparture;
    private Long period;
    /*
    * Time interval between start end current station in minutes and station id.
    * */
    private Map<Long, Long> route;

    public Route() {
    }

    public Route(Long code, LocalTime firstDeparture, LocalTime lastDeparture, Long period, Map<Long, Long> route) {
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

    public LocalTime getFirstDeparture() {
        return firstDeparture;
    }

    public void setFirstDeparture(LocalTime firstDeparture) {
        this.firstDeparture = firstDeparture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalTime getLastDeparture() {
        return lastDeparture;
    }

    public void setLastDeparture(LocalTime lastDeparture) {
        this.lastDeparture = lastDeparture;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Map<Long, Long> getRoute() {
        return route;
    }

    public void setRoute(Map<Long, Long> route) {
        this.route = route;
    }
}
