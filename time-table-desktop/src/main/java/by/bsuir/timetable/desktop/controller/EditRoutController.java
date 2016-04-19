package by.bsuir.timetable.desktop.controller;

import by.bsuir.timetable.desktop.dto.RouteDto;
import by.bsuir.timetable.desktop.service.RouteService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class EditRoutController {

    @Autowired
    private RouteService routeService;

    @FXML
    private TextField codeField;

    @FXML
    private TextField departureField;

    @FXML
    private TextField startField;

    @FXML
    private TextField endField;

    @FXML
    private TextField periodField;

    @FXML
    private TableView routeTale;

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
            Map<Long, Long> route = new HashMap<>();
            routeTale.getItems();
            codeField.setText(routeService.saveRoute(new RouteDto(
                    code,
                    LocalTime.parse(departureField.getText()),
                    LocalDate.parse(startField.getText()),
                    LocalDate.parse(endField.getText()),
                    Long.parseLong(periodField.getText()),
                    route
            )).toString());
        });
    }
}
