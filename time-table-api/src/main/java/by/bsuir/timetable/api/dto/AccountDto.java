package by.bsuir.timetable.api.dto;

public class AccountDto {

    private String username;
    private String password;

    public AccountDto() {

    }

    public AccountDto(String password, String username) {
        this.password = password;
        this.username = username;
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
