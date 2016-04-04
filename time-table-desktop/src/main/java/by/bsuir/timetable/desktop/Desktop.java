package by.bsuir.timetable.desktop;

import by.bsuir.timetable.desktop.controller.MainController;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

@Lazy
@SpringBootApplication
public class Desktop extends AbstractJavaFxApplicationSupport {

    @Autowired
    private SpringFxmlLoader fxmlLoader;

    @Value("${window.title}")
    private String windowTitle;

    @Value("${window.width}")
    private Double windowWidth;

    @Value("${window.height}")
    private Double windowHeight;

    @Override
    public void start(Stage primaryStage) throws Exception {
        SpringFxmlLoader.View mainView = fxmlLoader.load("fxml/main.fxml");
        SpringFxmlLoader.View loginView = fxmlLoader.load("fxml/login.fxml");
        Stage loginStage = new Stage();
        loginStage.setTitle("Логин");
        loginStage.setScene(new Scene(loginView.parent));
        ((MainController) mainView.controller).setLoginStage(loginStage);
        primaryStage.setTitle(windowTitle);
        primaryStage.setMinWidth(windowWidth);
        primaryStage.setMinHeight(windowHeight);
        primaryStage.setScene(new Scene(mainView.parent));
        primaryStage.setOnCloseRequest(event -> loginStage.close());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launchApp(Desktop.class, args);
    }
}
