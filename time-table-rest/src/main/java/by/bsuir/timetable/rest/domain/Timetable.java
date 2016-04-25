package by.bsuir.timetable.rest.domain;

import java.util.List;

public class Timetable {

    private Station station;

    private List<TimetablePoint> timetablePointList;

    public Timetable(Station station, List<TimetablePoint> timetablePointList) {
        this.station = station;
        this.timetablePointList = timetablePointList;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public List<TimetablePoint> getTimetablePointList() {
        return timetablePointList;
    }

    public void setTimetablePointList(List<TimetablePoint> timetablePointList) {
        this.timetablePointList = timetablePointList;
    }
}
