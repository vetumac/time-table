package by.bsuir.timetable.api.dto;

import java.time.LocalDateTime;

public class TimetablePoint {

    private Long route;
    private LocalDateTime dateTime;
    private Long stay;

    public TimetablePoint(LocalDateTime dateTime, Long route, Long stay) {
        this.dateTime = dateTime;
        this.route = route;
        this.stay = stay;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getRoute() {
        return route;
    }

    public void setRoute(Long route) {
        this.route = route;
    }

    public Long getStay() {
        return stay;
    }

    public void setStay(Long stay) {
        this.stay = stay;
    }
}
