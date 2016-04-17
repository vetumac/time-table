package by.bsuir.timetable.desktop.controller;

import by.bsuir.timetable.desktop.dto.StationDto;
import by.bsuir.timetable.desktop.service.StationService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditStationController {

    @Autowired
    private StationService stationService;

    @FXML
    private TextField codeField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField zoneField;

    @FXML
    private Button saveButton;

    @FXML
    public void initialize() {
        saveButton.setOnAction(event -> {
            Long code;
            try {
                code = Long.parseLong(codeField.getText());
            } catch (NumberFormatException e) {
                code = null;
            }
            codeField.setText(stationService.saveStation(new StationDto(code, nameField.getText(), zoneField.getText())).toString());
        });
    }
}
