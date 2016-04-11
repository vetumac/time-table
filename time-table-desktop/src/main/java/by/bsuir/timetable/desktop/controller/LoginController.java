package by.bsuir.timetable.desktop.controller;

import by.bsuir.timetable.desktop.service.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginController {

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button loginButton;

    @Autowired
    private LoginService loginService;

    @FXML
    void initialize() {
        loginButton.setOnAction(event ->
        {
            //loginButton.getScene().getWindow().hide();
            loginButton.setText(String.valueOf(loginService.login(loginTextField.getText(), passwordTextField.getText())));

        });
    }

    ;


}
