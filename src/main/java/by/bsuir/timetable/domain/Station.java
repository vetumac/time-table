package by.bsuir.timetable.domain;

import org.springframework.data.annotation.Id;

public class Station {

    @Id
    private String id;
    private Long code;
    private String name;
    private String zone;

    public Station() {
    }

    public Station(Long code, String name, String zone) {
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

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}
