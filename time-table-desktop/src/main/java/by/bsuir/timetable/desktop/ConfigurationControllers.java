package by.bsuir.timetable.desktop;

import by.bsuir.timetable.desktop.controller.MainController;
import by.bsuir.timetable.desktop.controller.StationsController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class ConfigurationControllers {

    @Bean
    public MainController mainController() throws IOException {
        return (MainController) getMainView().controller;
    }

    @Bean(name = "mainView")
    public View getMainView() throws IOException {
        return loadController(MainController.VIEW);
    }

    @Bean
    public StationsController stationsController() throws IOException {
        return (StationsController) getStationsView().controller;
    }

    @Bean(name = "stationsView")
    public View getStationsView() throws IOException {
        return loadController(StationsController.VIEW);
    }

    private View loadController(String url) throws IOException {
        try (InputStream fxmlStream = getClass().getClassLoader().getResourceAsStream(url)) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("fxml/"));
            return new View(loader.load(fxmlStream), loader.getController());
        }
    }

    public class View {
        public Parent parent;
        public Object controller;

        public View(Parent parent, Object controller) {
            this.parent = parent;
            this.controller = controller;
        }
    }

}
