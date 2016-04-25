package by.bsuir.timetable.rest.web;

import by.bsuir.timetable.rest.domain.Route;
import by.bsuir.timetable.rest.domain.Station;
import by.bsuir.timetable.rest.domain.Timetable;
import by.bsuir.timetable.rest.service.RouteService;
import by.bsuir.timetable.rest.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HomeController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private StationService stationService;

    @RequestMapping(value = "/station/{code}", method = RequestMethod.GET)
    Station getStationByCode(@PathVariable(value = "code") Long code) {
        return stationService.findByCode(code);
    }

    @RequestMapping(value = "/station", method = RequestMethod.GET)
    List<Station> findStationByName(@RequestParam(value = "name") String name) {
        return stationService.findByNameLike(name);
    }

    @RequestMapping(value = "/stations/{codes}", method = RequestMethod.GET)
    List<Station> findStationByNameIn(@PathVariable(value = "codes") String codes) {
        return stationService.findByCodeIn(Arrays.asList(codes.split(",")).stream().map(Long::parseLong).collect(Collectors.toList()));
    }

    @RequestMapping(value = "/route/{code}", method = RequestMethod.GET)
    Route getRouteByRoute(@PathVariable(value = "code") Long code) {
        return routeService.findByCode(code);
    }

    @RequestMapping(value = "/timetable/{code}", method = RequestMethod.GET)
    Timetable findRouteByStation(

            @PathVariable(value = "code")
            Long code,

            @RequestParam(value = "from")
            LocalDate from,

            @RequestParam(value = "to")
            LocalDate to) {

        return routeService.findByStationAndFromAndTo(code, from, to);

    }
}
