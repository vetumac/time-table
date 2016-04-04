package by.bsuir.timetable.desktop.controller;

import by.bsuir.timetable.desktop.dto.StationDto;
import by.bsuir.timetable.desktop.service.StationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StationsController {

    @Autowired
    private StationService stationService;

    @FXML
    private TableView stationsView;

    @FXML
    private Button searchStationButton;

    @FXML
    private TextField searchStationTextField;

    @FXML
    private TableColumn codeCol;

    @FXML
    private TableColumn nameCol;

    @FXML
    private TableColumn zoneCol;

    final private ObservableList<StationDto> stationObservableList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        searchStationButton.setOnAction(event -> {
            System.out.println("Initialize");
            List<StationDto> stations = stationService.findStationByNameLike(searchStationTextField.getText());
            stationObservableList.addAll(stations);
        });

        codeCol.setCellValueFactory(new PropertyValueFactory("code"));
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        zoneCol.setCellValueFactory(new PropertyValueFactory("zone"));

        stationsView.setItems(stationObservableList);

    }
}
