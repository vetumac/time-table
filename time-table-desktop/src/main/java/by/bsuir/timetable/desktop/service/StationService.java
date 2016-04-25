package by.bsuir.timetable.desktop.service;

import by.bsuir.timetable.api.dto.StationDto;
import by.bsuir.timetable.desktop.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StationService {

    @Autowired
    private RestClient restClient;

    public List<StationDto> findByNameLike(String name) {
        StationDto[] stations = restClient.template().getForObject(restClient.apiUrl("/station?name=" + name), StationDto[].class);
        return Arrays.asList(stations);
    }

    public StationDto findByCode(Long code) {
        return restClient.template().getForObject(restClient.apiUrl("/station/" + code.toString()), StationDto.class);
    }

    public Long saveStation(StationDto stationDto) {
        return restClient.template().postForObject(restClient.apiUrl("/station"), stationDto, Long.class);
    }
}
