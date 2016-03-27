package by.bsuir.timetable.dto;

import by.bsuir.timetable.domain.Station;

import java.time.LocalTime;
import java.util.Map;

public class RouteDto {

    private String id;
    private Long code;
    private LocalTime firstDeparture;
    private LocalTime lastDeparture;
    private Long period;
    private Map<Long, Station> route;

}
