package by.bsuir.timetable.rest.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Station {

    @Id
    private String id;

    @Indexed(unique = true)
    private Long code;

    @Indexed
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Station)) return false;

        Station station = (Station) o;

        return code.equals(station.code);

    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
