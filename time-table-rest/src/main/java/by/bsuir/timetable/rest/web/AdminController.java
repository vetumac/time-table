package by.bsuir.timetable.rest.web;

import by.bsuir.timetable.rest.domain.Route;
import by.bsuir.timetable.rest.domain.Station;
import by.bsuir.timetable.rest.domain.User;
import by.bsuir.timetable.rest.service.RouteService;
import by.bsuir.timetable.rest.service.StationService;
import by.bsuir.timetable.rest.service.UserService;
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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/route", method = RequestMethod.POST)
    Long saveRoute(@RequestBody Route route) {
        return routeService.saveRoute(route);
    }

    @RequestMapping(value = "/station", method = RequestMethod.POST)
    Long saveStation(@RequestBody Station station) {
        return stationService.saveStation(station);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
