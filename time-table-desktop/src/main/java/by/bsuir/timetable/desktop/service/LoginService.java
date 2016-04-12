package by.bsuir.timetable.desktop.service;

import by.bsuir.timetable.desktop.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

    @Autowired
    private LoggedState loggedState;

    @Autowired
    private RestClient restClient;

    public boolean login(String username, String password) {
        boolean loggedIn = restClient.login(username, password);
        loggedState.set(loggedIn);
        return loggedIn;
    }

    public void logout() {
        restClient.logout();
        loggedState.set(false);
    }
}
