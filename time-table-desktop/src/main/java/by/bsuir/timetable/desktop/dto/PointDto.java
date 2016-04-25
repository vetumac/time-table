package by.bsuir.timetable.desktop.dto;

public class PointDto {

    private String id;

    private Long offset;

    private Long station;

    private Long stay;

    public PointDto() {
    }

    public PointDto(Long offset, Long station, Long stay) {
        this.offset = offset;
        this.station = station;
        this.stay = stay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getStation() {
        return station;
    }

    public void setStation(Long station) {
        this.station = station;
    }

    public Long getStay() {
        return stay;
    }

    public void setStay(Long stay) {
        this.stay = stay;
    }
}
