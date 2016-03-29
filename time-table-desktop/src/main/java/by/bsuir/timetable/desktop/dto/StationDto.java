package by.bsuir.timetable.desktop.dto;

public class StationDto {

    private Long code;
    private String name;
    private String zone;

    public StationDto() {
    }

    public StationDto(Long code, String name, String zone) {
        this.code = code;
        this.name = name;
        this.zone = zone;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StationDto)) return false;

        StationDto stationDto = (StationDto) o;

        return code.equals(stationDto.code);

    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}