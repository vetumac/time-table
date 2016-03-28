package by.bsuir.timetable.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.Map;

@Document
public class Route {
    @Id
    private String id;

    @Indexed(unique = true)
    private Long code;
    private LocalTime departure;
    private Long period;
    /*
    * Time interval between start end current station in minutes and station id.
    * */
    private Map<Long, Long> route;

    public Route() {
    }

    public Route(Long code, LocalTime departure, Long period, Map<Long, Long> route) {
        this.code = code;
        this.departure = departure;
        this.period = period;
        this.route = route;
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

    public Map<Long, Long> getRoute() {
        return route;
    }

    public void setRoute(Map<Long, Long> route) {
        this.route = route;
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
