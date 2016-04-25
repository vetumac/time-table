package by.bsuir.timetable.rest.web;

import by.bsuir.timetable.api.dto.RouteDto;
import by.bsuir.timetable.api.dto.StationDto;
import by.bsuir.timetable.api.dto.UserDto;
import by.bsuir.timetable.rest.domain.Route;
import by.bsuir.timetable.rest.domain.Station;
import by.bsuir.timetable.rest.domain.User;
import by.bsuir.timetable.rest.service.RouteService;
import by.bsuir.timetable.rest.service.StationService;
import by.bsuir.timetable.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
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

    @Autowired
    private ConversionService conversionService;

    @RequestMapping(value = "/route", method = RequestMethod.POST)
    Long saveRoute(@RequestBody RouteDto routeDto) {
        return routeService.saveRoute(conversionService.convert(routeDto, Route.class));
    }

    @RequestMapping(value = "/station", method = RequestMethod.POST)
    Long saveStation(@RequestBody StationDto stationDto) {
        return stationService.saveStation(conversionService.convert(stationDto, Station.class));
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    void addUser(@RequestBody UserDto userDto) {
        userService.addUser(conversionService.convert(userDto, User.class));
    }
}
