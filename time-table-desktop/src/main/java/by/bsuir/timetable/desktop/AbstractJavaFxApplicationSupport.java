package by.bsuir.timetable.desktop;

import javafx.application.Application;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class AbstractJavaFxApplicationSupport extends Application {

    private ConfigurableApplicationContext applicationContext;
    protected SpringFxmlLoader fxmlLoader;

    @Override
    public void init() throws Exception {
        applicationContext = new AnnotationConfigApplicationContext(Desktop.class);
        fxmlLoader = applicationContext.getBean(SpringFxmlLoader.class);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        applicationContext.close();
    }

    protected static void launchApp(Class<? extends AbstractJavaFxApplicationSupport> appClass, String[] args) {
        Application.launch(appClass, args);
    }
}
