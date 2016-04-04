package by.bsuir.timetable.desktop;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class SpringFxmlLoader {

    @Autowired
    private ApplicationContext applicationContext;

    public View load(final String url) throws IOException {
        try (InputStream fxmlStream = applicationContext.getResource(url).getInputStream()) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(applicationContext.getResource("fxml/").getURL());
            loader.setControllerFactory(clazz -> applicationContext.getBean(clazz));
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
