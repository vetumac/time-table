package by.bsuir.timetable.rest.service;

import by.bsuir.timetable.rest.dao.RouteRepository;
import by.bsuir.timetable.rest.domain.Route;
import by.bsuir.timetable.rest.domain.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    public Timetable findByStationAndFromAndTo(Long code, LocalDate from, LocalDate to) {
        List<Route> routes = routeRepository.findByStationAndFromAndTo(
                code,
                from == null ? LocalDate.now() : from,
                to == null ? LocalDate.now().plusDays(maxRouteDuration) : to.plusDays(maxRouteDuration));
        return null;
    }

}
