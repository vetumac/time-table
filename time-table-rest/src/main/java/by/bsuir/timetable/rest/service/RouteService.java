package by.bsuir.timetable.rest.service;

import by.bsuir.timetable.rest.domain.Route;
import by.bsuir.timetable.rest.domain.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private CounterService counterService;

    public Route findByCode(Long code) {
        return routeRepository.findByCode(code);
    }

    public Long addRoute(Route route) {
        route.setCode(counterService.getNextSequence("route"));
        return routeRepository.save(route).getCode();
    }

}
