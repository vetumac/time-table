package by.bsuir.timetable.desktop.service;

import by.bsuir.timetable.api.dto.RouteDto;
import by.bsuir.timetable.desktop.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteService {

    @Autowired
    private RestClient restClient;

    public Long saveRoute(RouteDto routeDto) {
        return restClient.template().postForObject(restClient.apiUrl("/route"), routeDto, Long.class);
    }

    public RouteDto findByCode(Long code) {
        return restClient.template().getForObject(restClient.apiUrl("/route/" + code.toString()), RouteDto.class);
    }

}
