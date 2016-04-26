package by.bsuir.timetable.rest.service;

import by.bsuir.timetable.api.dto.TimetableDto;
import by.bsuir.timetable.api.dto.TimetablePointDto;
import by.bsuir.timetable.rest.dao.RouteRepository;
import by.bsuir.timetable.rest.domain.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Value(value = "${max-route-duration}")
    private Long maxRouteDuration;

    @Autowired
    private CounterService counterService;

    public Route findByCode(Long code) {
        return routeRepository.findByCode(code);
    }

    public Long saveRoute(Route route) {
        if (route.getCode() == null) route.setCode(counterService.getNextSequence("route"));
        return routeRepository.saveRoute(route).getCode();
    }

    public TimetableDto findByStationAndFromAndTo(Long stationCode, LocalDateTime from, LocalDateTime to) {

        LocalDateTime innerFrom = from == null ? LocalDateTime.now() : from;
        LocalDateTime innerTo = to == null ? LocalDateTime.now() : to;

        List<Route> routes = routeRepository.findByStationAndFromAndTo(
                stationCode,
                innerFrom,
                innerTo.plusDays(maxRouteDuration));

        TimetableDto timetableDto = new TimetableDto(stationCode);

        for (Route currentRoute : routes) {

            LocalDateTime currentDateTime = currentRoute.getFirstDeparture()
                    .plusMinutes(currentRoute.getPoints().stream()
                            .filter(point -> Objects.equals(point.getStation(), stationCode))
                            .findAny().get()
                            .getOffset());

            while (currentDateTime.isBefore(ChronoLocalDateTime.from(innerTo))) {
                if (currentDateTime.isAfter(ChronoLocalDateTime.from(innerFrom)))
                    timetableDto.getTimetablePointDtoList().add(new TimetablePointDto(
                            currentDateTime,
                            currentRoute.getCode(),
                            currentRoute.getPoints().stream()
                                    .filter(point -> Objects.equals(point.getStation(), stationCode))
                                    .findAny().get()
                                    .getStay()));
                currentDateTime = currentDateTime.plusDays(currentRoute.getPeriod());
            }
        }

        return timetableDto;
    }

}
