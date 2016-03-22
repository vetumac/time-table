package by.bsuir.timetable.domain;

import org.springframework.data.annotation.Id;

public class Station {

    @Id
    private String id;

    private String name;

    public Station() {
    }

    public Station(String name) {
        this.name = name;
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
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
