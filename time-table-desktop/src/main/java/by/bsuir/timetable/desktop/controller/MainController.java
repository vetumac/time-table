package by.bsuir.timetable.desktop.controller;

import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    Group root = new Group();

    @FXML
    BorderPane borderPane;
    final TabPane tabPane = new TabPane();

    @FXML
    private Tab stationsTab;

    @FXML
    private Tab routesTab = new Tab();
    final Tab tab3 = new Tab();
    final Tab tab4 = new Tab();
    Button loginButton = new Button("Войти");

    public void init(Stage primaryStage) {
        primaryStage.setTitle("Проект 'Расписание поездов'");
        primaryStage.setMinWidth(MINIMUM_WINDOW_WIDTH);
        primaryStage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
        primaryStage.setScene(new Scene(root));
        tabPane.prefWidthProperty().bind(primaryStage.widthProperty());
        tabPane.setSide(Side.TOP);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        stationsTab.setText("Станции");
        stationsController.init(stationsTab);
        routesTab.setText("Маршруты");
        tab3.setText("Tab 3");
        tab4.setText("Tab 4");
        tabPane.getTabs().addAll(stationsTab, routesTab, tab3, tab4);
        borderPane.setCenter(tabPane);
        borderPane.setTop(loginButton);
        root.getChildren().add(borderPane);
    }
}
