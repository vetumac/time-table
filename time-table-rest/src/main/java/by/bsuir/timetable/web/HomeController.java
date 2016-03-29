package by.bsuir.timetable.web;

import by.bsuir.timetable.domain.Route;
import by.bsuir.timetable.domain.Station;
import by.bsuir.timetable.service.RouteService;
import by.bsuir.timetable.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
