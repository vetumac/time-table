package by.bsuir.timetable.rest.web;

import by.bsuir.timetable.api.dto.RouteDto;
import by.bsuir.timetable.api.dto.StationDto;
import by.bsuir.timetable.api.dto.TimetableDto;
import by.bsuir.timetable.rest.service.RouteService;
import by.bsuir.timetable.rest.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
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

    @Autowired
    private ConversionService conversionService;

    @RequestMapping(value = "/station/{code}", method = RequestMethod.GET)
    StationDto getStationByCode(@PathVariable(value = "code") Long code) {
        return conversionService.convert(stationService.findByCode(code), StationDto.class);
    }

    @RequestMapping(value = "/station", method = RequestMethod.GET)
    List<StationDto> findStationByName(@RequestParam(value = "name") String name) {
        return stationService.findByNameLike(name).stream().map(station -> conversionService.convert(station, StationDto.class)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/stations/{codes}", method = RequestMethod.GET)
    List<StationDto> findStationByNameIn(@PathVariable(value = "codes") String codes) {
        return stationService.findByCodeIn(Arrays.asList(codes.split(",")).stream().map(Long::parseLong).collect(Collectors.toList()))
                .stream().map(station -> conversionService.convert(station, StationDto.class)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/route/{code}", method = RequestMethod.GET)
    RouteDto getRouteByRoute(@PathVariable(value = "code") Long code) {
        return conversionService.convert(routeService.findByCode(code), RouteDto.class);
    }

    @RequestMapping(value = "/timetable/{code}", method = RequestMethod.GET)
    TimetableDto findRouteByStation(

            @PathVariable(value = "code")
            Long code,

            @RequestParam(value = "from")
            LocalDate from,

            @RequestParam(value = "to")
            LocalDate to) {

        return routeService.findByStationAndFromAndTo(code, from, to);

    }
}
