package by.bsuir.timetable.web;

import by.bsuir.timetable.domain.Route;
import by.bsuir.timetable.domain.Station;
import by.bsuir.timetable.repository.AccountRepository;
import by.bsuir.timetable.repository.CounterService;
import by.bsuir.timetable.repository.RouteRepository;
import by.bsuir.timetable.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/station/{code}", method = RequestMethod.GET)
    Station getStationByCode(@PathVariable(value = "code") Long code) {
        return stationRepository.findByCode(code);
    }

    @RequestMapping(value = "/station", method = RequestMethod.GET)
    List<Station> findStationByName(@RequestParam(value = "name") String name) {
        return stationRepository.findByNameLike(name);
    }

    @RequestMapping(value = "/route/{code}", method = RequestMethod.GET)
    Route getRouteByRoute(@PathVariable(value = "code") Long code) {
        return routeRepository.findByCode(code);
    }

/*
    @RequestMapping(value = "/route", method = RequestMethod.POST)
    void addRoute(@RequestBody Route route) {
        routeRepository.save(route);
    }

    @RequestMapping(value = "/getone", method = RequestMethod.GET)
    String getOne() {
        return String.valueOf(stationRepository.findByCode(1L));
    }
*/




}
