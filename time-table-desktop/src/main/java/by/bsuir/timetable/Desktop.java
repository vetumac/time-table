package by.bsuir.timetable;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Desktop extends Application {

    private final double MINIMUM_WINDOW_WIDTH = 600.0;
    private final double MINIMUM_WINDOW_HEIGHT = 400.0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Проект 'Расписание поездов'");
        primaryStage.setMinWidth(MINIMUM_WINDOW_WIDTH);
        primaryStage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
        init(primaryStage);
        primaryStage.show();
    }

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        BorderPane borderPane = new BorderPane();
        final TabPane tabPane = new TabPane();
        tabPane.setPrefSize(MINIMUM_WINDOW_WIDTH, MINIMUM_WINDOW_HEIGHT);
        tabPane.setSide(Side.TOP);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        final Tab stations = new Tab();
        stations.setText("Станции");
        stations.setContent(new Label("adfasd"));
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
