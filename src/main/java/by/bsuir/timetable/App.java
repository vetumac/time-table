package by.bsuir.timetable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class App {

    @RequestMapping("/")
    String home() {
        return "Hello wofffrld!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
