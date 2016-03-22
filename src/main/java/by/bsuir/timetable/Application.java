package by.bsuir.timetable;

import by.bsuir.timetable.domain.Station;
import by.bsuir.timetable.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private StationRepository stationRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        stationRepository.deleteAll();
        stationRepository.save(new Station("Zabolot"));
    }
}
