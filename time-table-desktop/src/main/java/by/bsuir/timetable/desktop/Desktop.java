package by.bsuir.timetable.desktop;

import by.bsuir.timetable.desktop.controller.MainController;
import javafx.application.Preloader;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

@Lazy
@SpringBootApplication
public class Desktop extends AbstractJavaFxApplicationSupport {

    @Autowired
    private MainController mainController;

    @Override
    public void start(Stage primaryStage) throws Exception {

        notifyPreloader(new Preloader.StateChangeNotification(Preloader.StateChangeNotification.Type.BEFORE_START));

        mainController.init(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launchApp(Desktop.class, args);
    }
}
