package by.bsuir.timetable.desktop.controller;

import by.bsuir.timetable.api.dto.TimetableDto;
import by.bsuir.timetable.api.dto.TimetablePointDto;
import by.bsuir.timetable.desktop.service.TimetableService;
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

import java.time.LocalDateTime;

@Component
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    @FXML
    private TableView<TimetablePointDto> timetableTableView;

    @FXML
    private Button searchStationButton;

    @FXML
    private TextField fromTextField;

    @FXML
    private TextField toTextField;

    @FXML
    private TextField searchStationTextField;

    @FXML
    private TableColumn routeCol;

    @FXML
    private TableColumn dateTimeCol;

    @FXML
    private TableColumn stayCol;

    final private ObservableList<TimetablePointDto> timetablePointDtos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        searchStationButton.setOnAction(event -> {
            TimetableDto timetableDto = timetableService.getTimetible(
                    Long.parseLong(searchStationTextField.getText()),
                    LocalDateTime.parse(fromTextField.getText()),
                    LocalDateTime.parse(toTextField.getText()));
            timetablePointDtos.clear();
            timetablePointDtos.addAll(timetableDto.getTimetablePointDtoList());
        });

        routeCol.setCellValueFactory(new PropertyValueFactory("route"));
        dateTimeCol.setCellValueFactory(new PropertyValueFactory("dateTime"));
        stayCol.setCellValueFactory(new PropertyValueFactory("stay"));

        timetableTableView.setItems(timetablePointDtos);

    }
}
