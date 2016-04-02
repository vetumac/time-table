package by.bsuir.timetable.desktop;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

@Lazy
@SpringBootApplication
public class Desktop extends AbstractJavaFxApplicationSupport {

    @Autowired
    @Qualifier("mainView")
    private ConfigurationControllers.View view;

    @Value("${window.title}")
    private String windowTitle;

    @Value("${window.width}")
    private Double windowWidth;

    @Value("${window.height}")
    private Double windowHeight;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(windowTitle);
        primaryStage.setMinWidth(windowWidth);
        primaryStage.setMinHeight(windowHeight);
        primaryStage.setScene(new Scene(view.parent));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launchApp(Desktop.class, args);
    }
}
