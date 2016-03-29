package by.bsuir.timetable.desktop.controller;

import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    private final double MINIMUM_WINDOW_WIDTH = 600.0;
    private final double MINIMUM_WINDOW_HEIGHT = 400.0;

    @Autowired
    private StationsController stationsController;

    public void init(Stage primaryStage) {
        primaryStage.setTitle("Проект 'Расписание поездов'");
        primaryStage.setMinWidth(MINIMUM_WINDOW_WIDTH);
        primaryStage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        BorderPane borderPane = new BorderPane();
        final TabPane tabPane = new TabPane();
        tabPane.prefWidthProperty().bind(primaryStage.widthProperty());
        tabPane.setSide(Side.TOP);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        final Tab stations = new Tab();
        stations.setText("Станции");
        stationsController.init(stations);
        final Tab routes = new Tab();
        routes.setText("Маршруты");
        final Tab tab3 = new Tab();
        tab3.setText("Tab 3");
        final Tab tab4 = new Tab();
        tab4.setText("Tab 4");
        tabPane.getTabs().addAll(stations, routes, tab3, tab4);
        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
    }
}
