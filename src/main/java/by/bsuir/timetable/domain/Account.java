package by.bsuir.timetable.domain;

import org.springframework.data.annotation.Id;

public class Account {

    @Id
    private String id;
    private String username;
    private String password;

    public Account() {

    }

    public Account(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
