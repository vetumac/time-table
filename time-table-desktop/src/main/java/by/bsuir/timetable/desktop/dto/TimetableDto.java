package by.bsuir.timetable.desktop.dto;

import java.util.List;

public class TimetableDto {

    private StationDto stationDto;

    private List<TimetablePoint> timetablePointList;

    public TimetableDto(StationDto stationDto, List<TimetablePoint> timetablePointList) {
        this.stationDto = stationDto;
        this.timetablePointList = timetablePointList;
    }

    public StationDto getStationDto() {
        return stationDto;
    }

    public void setStationDto(StationDto stationDto) {
        this.stationDto = stationDto;
    }

    public List<TimetablePoint> getTimetablePointList() {
        return timetablePointList;
    }

    public void setTimetablePointList(List<TimetablePoint> timetablePointList) {
        this.timetablePointList = timetablePointList;
    }
}
