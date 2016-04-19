package by.bsuir.timetable.desktop.controller;

import by.bsuir.timetable.desktop.service.LoggedState;
import by.bsuir.timetable.desktop.service.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Tab;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private LoggedState loggedState;

    private Stage loginStage;

    @FXML
    private Hyperlink login;

    @FXML
    private Hyperlink logout;

    @FXML
    private Tab editStationTab;

    @FXML
    private Tab editRouteTab;

    @FXML
    public void initialize() {
        login.setOnAction(event -> loginStage.show());
        logout.setOnAction(event -> loginService.logout());
        loggedState.addListener((observable, oldValue, newValue) -> {
            login.setVisible(!newValue);
            logout.setVisible(newValue);
            editStationTab.setDisable(!newValue);
            editRouteTab.setDisable(!newValue);
        });
    }

    public void setLoginStage(Stage loginStage) {
        this.loginStage = loginStage;
    }
}
