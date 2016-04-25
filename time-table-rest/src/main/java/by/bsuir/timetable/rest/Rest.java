package by.bsuir.timetable.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class Rest {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Rest.class, args);
    }
}
