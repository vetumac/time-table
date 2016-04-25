package by.bsuir.timetable.api.dto;

public class StationDto {

    private Long code;
    private String name;
    private String zone;

    public StationDto() {
    }

    public StationDto(String name, String zone) {
        this.name = name;
        this.zone = zone;
    }

    public StationDto(Long code, String name, String zone) {
        this(name, zone);
        this.code = code;
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
