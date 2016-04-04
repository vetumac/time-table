package by.bsuir.timetable.desktop.controller;

import by.bsuir.timetable.desktop.service.StationService;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    @Autowired
    private StationService stationService;

    @FXML
    public void initialize() {
    }
}
