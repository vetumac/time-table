package by.bsuir.timetable.web;

import by.bsuir.timetable.domain.Route;
import by.bsuir.timetable.domain.Station;
import by.bsuir.timetable.repository.AccountRepository;
import by.bsuir.timetable.repository.CounterService;
import by.bsuir.timetable.repository.RouteRepository;
import by.bsuir.timetable.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.TreeMap;

@RestController
public class HomeController {

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private CounterService counterService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RouteRepository routeRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "Hello woffddfrffld!";
    }

    @RequestMapping(value = "/addstation", method = RequestMethod.GET)
    String addStation() {
        stationRepository.save(new Station(counterService.getNextSequence("station"), "NewVasyuki", ZoneId.of("Europe/Minsk")));
        //     accountRepository.save(new Account("admin", "admin"));
        Map<Long, Station> route = new TreeMap<Long, Station>();
        route.put(0L, stationRepository.findByCode(1L));
        route.put(10L, stationRepository.findByCode(2L));
        routeRepository.save(new Route(counterService.getNextSequence("route"),
                ZonedDateTime.now(),
                ZonedDateTime.now().plusYears(1),
                Period.ofDays(1),
                route));
        return "Added";
    }

    @RequestMapping(value = "/getone", method = RequestMethod.GET)
    String getOne() {
        return String.valueOf(stationRepository.findByCode(1L));
    }

}
