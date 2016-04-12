package by.bsuir.timetable.desktop.service;

import by.bsuir.timetable.desktop.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

    @Autowired
    private RestClient restClient;

    public boolean login(String username, String password) {
        return restClient.login(username, password);
    }
}
