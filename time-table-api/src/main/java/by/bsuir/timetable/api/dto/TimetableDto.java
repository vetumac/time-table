package by.bsuir.timetable.api.dto;

import java.util.List;

public class TimetableDto {

    private StationDto stationDto;

    private List<TimetablePointDto> timetablePointDtoList;

    public TimetableDto(StationDto stationDto, List<TimetablePointDto> timetablePointDtoList) {
        this.stationDto = stationDto;
        this.timetablePointDtoList = timetablePointDtoList;
    }

    public StationDto getStationDto() {
        return stationDto;
    }

    public void setStationDto(StationDto stationDto) {
        this.stationDto = stationDto;
    }

    public List<TimetablePointDto> getTimetablePointDtoList() {
        return timetablePointDtoList;
    }

    public void setTimetablePointDtoList(List<TimetablePointDto> timetablePointDtoList) {
        this.timetablePointDtoList = timetablePointDtoList;
    }
}
