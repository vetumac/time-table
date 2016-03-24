package by.bsuir.timetable.domain;

import org.springframework.data.annotation.Id;

public class Station {

    @Id
    private String id;

    private String name;

    private Long code;

    public Station(Long code, String name) {
        this.name = name;
        this.code = code;
    }

    public Station() {
    }

    public Long getCode() {
        return code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Station{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
