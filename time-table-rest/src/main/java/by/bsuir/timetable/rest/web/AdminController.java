package by.bsuir.timetable.rest.web;

import by.bsuir.timetable.rest.domain.Route;
import by.bsuir.timetable.rest.domain.Station;
import by.bsuir.timetable.rest.service.RouteService;
import by.bsuir.timetable.rest.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private StationService stationService;

    @RequestMapping(value = "/route", method = RequestMethod.POST)
    Long addRoute(@RequestBody Route route) {
        return routeService.addRoute(route);
    }

    @RequestMapping(value = "/station", method = RequestMethod.POST)
    Long addStation(@RequestBody Station station) {
        return stationService.addStation(station);
    }

}