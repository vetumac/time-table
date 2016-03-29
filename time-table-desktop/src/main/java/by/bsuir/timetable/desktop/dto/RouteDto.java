package by.bsuir.timetable.desktop.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class RouteDto {
    private Long code;
    private LocalTime departure;
    private LocalDate start;
    private LocalDate end;
    private Long period;
    /*
    * Time interval between start end current station in minutes and station id.
    * */
    private Map<Long, Long> route;

    public RouteDto() {
    }

    public RouteDto(Long code, LocalTime departure, LocalDate start, LocalDate end, Long period, Map<Long, Long> route) {
        this.code = code;
        this.departure = departure;
        this.end = end;
        this.period = period;
        this.route = route;
        this.start = start;
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

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
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

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RouteDto)) return false;

        RouteDto routeDto = (RouteDto) o;

        return code.equals(routeDto.code);

    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
