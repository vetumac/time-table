package by.bsuir.timetable.desktop.controller;

import by.bsuir.timetable.desktop.dto.PointDto;
import by.bsuir.timetable.desktop.dto.RouteDto;
import by.bsuir.timetable.desktop.service.RouteService;
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

import java.time.LocalDate;
import java.time.LocalTime;

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
    private TableColumn offsetColumn;

    @FXML
    private TableColumn stationColumn;

    @FXML
    private TableColumn stayColumn;

    @FXML
    private TextField newOffsetTextField;

    @FXML
    private TextField newStationTextField;

    @FXML
    private TextField newStayTextField;

    @FXML
    private Button addPointButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button findRouteButton;

    final private ObservableList<PointDto> pointObservableList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        offsetColumn.setCellValueFactory(new PropertyValueFactory<PointDto, String>("offset"));
        stationColumn.setCellValueFactory(new PropertyValueFactory<PointDto, String>("station"));
        stayColumn.setCellValueFactory(new PropertyValueFactory<PointDto, String>("stay"));

        routeTale.setItems(pointObservableList);

        addPointButton.setOnAction(event -> {
            pointObservableList.add(new PointDto(
                    Long.parseLong(newOffsetTextField.getText()),
                    Long.parseLong(newStationTextField.getText()),
                    Long.parseLong(newStayTextField.getText()))
            );
            newOffsetTextField.clear();
            newStationTextField.clear();
            newStayTextField.clear();
        });

        saveButton.setOnAction(event -> {
            Long code;
            try {
                code = Long.parseLong(codeField.getText());
            } catch (NumberFormatException e) {
                code = null;
            }

            codeField.setText(routeService.saveRoute(new RouteDto(
                    code,
                    LocalTime.parse(departureField.getText()),
                    LocalDate.parse(startField.getText()),
                    LocalDate.parse(endField.getText()),
                    Long.parseLong(periodField.getText()),
                    pointObservableList
            )).toString());
        });

        findRouteButton.setOnAction(event -> {
            RouteDto routeDto = routeService.findByCode(Long.parseLong(codeField.getText()));
            departureField.setText(routeDto.getDeparture().toString());
            startField.setText(routeDto.getStart().toString());
            endField.setText(routeDto.getEnd().toString());
            periodField.setText(routeDto.getPeriod().toString());
            pointObservableList.clear();
            pointObservableList.addAll(routeDto.getPoints());
        });
    }
}
