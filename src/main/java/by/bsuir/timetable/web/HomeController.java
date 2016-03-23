package by.bsuir.timetable.web;

import by.bsuir.timetable.domain.Station;
import by.bsuir.timetable.repository.CounterService;
import by.bsuir.timetable.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private CounterService counterService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "Hello woffddfrffld!";
    }

    @RequestMapping(value = "/addstation", method = RequestMethod.GET)
    String addStation() {
        stationRepository.save(new Station(counterService.getNextSequence("station"), "NewVasyuki"));
        return "Added";
    }

    @RequestMapping(value = "/getone", method = RequestMethod.GET)
    String getOne() {
        return String.valueOf(stationRepository.findByCode(1));
    }

}
