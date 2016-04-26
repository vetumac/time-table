package by.bsuir.timetable.api.dto;

import java.util.ArrayList;
import java.util.List;

public class TimetableDto {

    private Long stationCode;

    private List<TimetablePointDto> timetablePointDtoList = new ArrayList<>();

    public TimetableDto() {
    }

    public TimetableDto(Long stationCode) {
        this.stationCode = stationCode;
    }

    public Long getStationCode() {
        return stationCode;
    }

    public void setStationCode(Long stationCode) {
        this.stationCode = stationCode;
    }

    public List<TimetablePointDto> getTimetablePointDtoList() {
        return timetablePointDtoList;
    }

    public void setTimetablePointDtoList(List<TimetablePointDto> timetablePointDtoList) {
        this.timetablePointDtoList = timetablePointDtoList;
    }
}
