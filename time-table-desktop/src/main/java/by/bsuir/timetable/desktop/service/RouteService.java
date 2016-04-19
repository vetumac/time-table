package by.bsuir.timetable.desktop.service;

import by.bsuir.timetable.desktop.RestClient;
import by.bsuir.timetable.desktop.dto.RouteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteService {

    @Autowired
    private RestClient restClient;

    public Long saveRoute(RouteDto routeDto) {
        return restClient.template().postForObject(restClient.apiUrl("/route"), routeDto, Long.class);
    }

}
