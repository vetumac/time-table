package by.bsuir.timetable.rest.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Point {

    @Id
    private String id;

    private Long offset;

    private Long station;

    private Long stay;

    public Point() {
    }

    public Point(Long offset, Long station, Long stay) {
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
