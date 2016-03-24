package by.bsuir.timetable.domain;

import org.springframework.data.annotation.Id;

import java.time.ZoneId;

public class Station {

    @Id
    private String id;
    private Long code;
    private String name;
    private ZoneId zoneId;

    public Station() {
    }

    public Station(Long code, String name, ZoneId zoneId) {
        this.code = code;
        this.name = name;
        this.zoneId = zoneId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }
}
