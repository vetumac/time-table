package by.bsuir.timetable.desktop.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    private Stage loginStage;

    @FXML
    private Hyperlink login;

    @FXML
    public void initialize() {
        login.setOnAction(event -> {
            loginStage.show();
        });
    }

    public void setLoginStage(Stage loginStage) {
        this.loginStage = loginStage;
    }
}
