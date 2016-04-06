package by.bsuir.timetable.desktop;

import by.bsuir.timetable.desktop.controller.MainController;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Desktop extends AbstractJavaFxApplicationSupport {

    @Override
    public void start(Stage primaryStage) throws Exception {
        SpringFxmlLoader.View mainView = fxmlLoader.load("fxml/main.fxml");
        SpringFxmlLoader.View loginView = fxmlLoader.load("fxml/login.fxml");
        Stage loginStage = new Stage();
        loginStage.setTitle("Логин");
        loginStage.setScene(new Scene(loginView.parent));
        ((MainController) mainView.controller).setLoginStage(loginStage);
        primaryStage.setTitle("Расписане поездов");
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.setScene(new Scene(mainView.parent));
        primaryStage.setOnCloseRequest(event -> loginStage.close());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launchApp(Desktop.class, args);
    }
}
