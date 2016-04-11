package by.bsuir.timetable.desktop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
public class RestClient {

    @Value("${host}")
    private String host;

    @Value("${port}")
    private String port;

    private String loginPath = "login";
    private String logoutPath = "logout";
    private final String usernameInputFieldName = "username";
    private final String passwordInputFieldName = "password";
    private final StatefullRestTemplate template = new StatefullRestTemplate();

    public boolean login(String username, String password) {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add(usernameInputFieldName, username);
        form.add(passwordInputFieldName, password);
        return !template.postForLocation(loginUrl(), form).toString().matches("(.*)error(.*)");
    }

    public ResponseEntity<String> logout() {
        return this.template.getForEntity(logoutUrl(), String.class);
    }

    public StatefullRestTemplate template() {
        return template;
    }

    public String apiUrl(String relativePath) {
        return serverUrl() + "/" + checkNotNull(relativePath);
    }

    public String serverUrl() {
        return "http://" + host + ":" + port;
    }

    public String loginUrl() {
        return serverUrl() + "/" + loginPath;
    }

    public String logoutUrl() {
        return serverUrl() + "/" + logoutPath;
    }

    private String checkNotNull(String str) {
        if (str != null) return str;
        else throw new IllegalArgumentException("Must e not null.");
    }
}